/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.w3c.dom.Element;

import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

public abstract class JonixReader<H, P>
{
	protected final JonixContext<H, P> context;
	protected int productNo = 0; // TODO: make a getter
	protected Object rawOnixObject; // TODO: make private
	protected boolean isOnix2 = false; // TODO: make a getter
	protected boolean isOnix3 = false;// TODO: make a getter

	protected PrintStream log = System.err;

	public JonixReader(JonixContext<H, P> context)
	{
		if (context == null)
			throw new NullPointerException("context is required");
		this.context = context;
	}

	protected Object getRawOnixObject()
	{
		return rawOnixObject;
	}

	public JonixReader<H, P> setLog(PrintStream log)
	{
		this.log = (log == null) ? System.err : log;
		return this;
	}

	public JonixReader<H, P> setLog(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.log = new PrintStream(fileName, "UTF-8");
		return this;
	}

	public PrintStream getLog()
	{
		return log;
	}

	protected void doRead(InputStream source, String encoding)
	{
		XmlChunker.parse(new BOMInputStream(source), encoding, 2, new XmlChunker.Listener()
		{
			@Override
			public void onChunk(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equalsIgnoreCase("Header"))
				{
					final H header;
					if (isOnix2)
					{
						com.tectonica.jonix.onix2.Header h2 = new com.tectonica.jonix.onix2.Header(element);
						header = context.createFrom(h2);
						rawOnixObject = h2;
					}
					else if (isOnix3)
					{
						com.tectonica.jonix.onix3.Header h3 = new com.tectonica.jonix.onix3.Header(element);
						header = context.createFrom(h3);
						rawOnixObject = h3;
					}
					else
						throw new RuntimeException("Couldn't determine the ONIX version of the file");
					onHeader(header);
				}
				else if (nodeName.equalsIgnoreCase("Product"))
				{
					final P product;
					if (isOnix2)
					{
						com.tectonica.jonix.onix2.Product p2 = new com.tectonica.jonix.onix2.Product(element);
						product = context.createFrom(p2);
						rawOnixObject = p2;
					}
					else if (isOnix3)
					{
						com.tectonica.jonix.onix3.Product p3 = new com.tectonica.jonix.onix3.Product(element);
						product = context.createFrom(p3);
						rawOnixObject = p3;
					}
					else
						throw new RuntimeException("Couldn't determine the ONIX version of the file");
					++productNo;
					onProduct(product);
				}
			}

			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
					throw new RuntimeException("file doesn't start with the mandatory <ONIXMessage> tag");
				final Attribute release = element.getAttributeByName(new QName("release"));
				isOnix2 = (release == null || release.getValue().startsWith("2"));
				isOnix3 = (release != null && release.getValue().startsWith("3"));
				if (!isOnix2 && !isOnix3)
					throw new RuntimeException("file doesn't comply with neither ONIX2 nor ONIX3");
			}
		});
	}

	public void read(final InputStream source)
	{
		read(source, "UTF-8");
	}

	public void read(final InputStream source, final String encoding)
	{
		if (onBeforeSource(source))
		{
			try
			{
				doRead(source, encoding);
			}
			catch (Exception e)
			{
				e.printStackTrace(log);
				throw new RuntimeException(e);
			}
			log.flush();
			onAfterSource();
		}
	}

	public void read(final String fileName)
	{
		read(fileName, getFileEncoding(fileName));
	}

	public void read(final String fileName, String encoding)
	{
		final FileInputStream fos;
		try
		{
			fos = new FileInputStream(fileName);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace(log);
			throw new RuntimeException(e);
		}
		read(fos, encoding); // outside the try{} to avoid double catching
	}

	public void read(List<String> fileNames)
	{
		if (onBeforeFileList(fileNames))
		{
			List<String> processedFileNames = new ArrayList<>();
			for (String fileName : fileNames)
			{
				try
				{
					if (!onBeforeFile(fileName))
						continue;
					read(fileName);
					processedFileNames.add(fileName);
				}
				catch (Exception ignored)
				{
					// we move on to the next file
				}
			}
			onAfterFileList(processedFileNames);
		}
	}

	/**
	 * 
	 * @param rootLocation
	 *            may be a directory or a file
	 * @param suffix
	 */
	public void readFolder(final String rootLocation, final String suffix)
	{
		try
		{
			final List<String> fileNames = new ArrayList<>();
			Files.walkFileTree(Paths.get(rootLocation), new SimpleFileVisitor<Path>()
			{
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{
					String fileName = file.toString();
					if (fileName.endsWith(suffix))
						fileNames.add(fileName);
					return FileVisitResult.CONTINUE;
				}
			});
			read(fileNames);
		}
		catch (IOException e)
		{
			e.printStackTrace(log);
			throw new RuntimeException(e);
		}
	}

	// MAIN EVENTS

	protected void onHeader(H header)
	{}

	protected abstract void onProduct(P product);

	// OTHER EVENTS

	protected boolean onBeforeSource(InputStream source)
	{
		return true;
	}

	protected void onAfterSource()
	{}

	protected boolean onBeforeFileList(List<String> fileNames)
	{
		return true;
	}

	protected boolean onBeforeFile(String fileName)
	{
		return true;
	}

	protected void onAfterFileList(List<String> processedFileNames)
	{}

	public String getFileEncoding(String fileName)
	{
		return "UTF-8";
	}
}
