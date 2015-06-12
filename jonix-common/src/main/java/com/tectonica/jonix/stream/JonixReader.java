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

package com.tectonica.jonix.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.w3c.dom.Element;

import com.tectonica.jonix.JonixUtil;
import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

public class JonixReader
{
	protected final JonixListener listener;

	public JonixReader(JonixListener listener)
	{
		if (listener == null)
			throw new NullPointerException("listener is required");
		this.listener = listener;
		this.listener.reader = this;
	}

	public JonixReader setLog(PrintStream log)
	{
		listener.log = (listener.log == null) ? System.err : listener.log;
		return this;
	}

	public JonixReader setLog(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		listener.log = new PrintStream(fileName, "UTF-8");
		return this;
	}

	public PrintStream getLog()
	{
		return listener.log;
	}

	protected void doRead(InputStream source, String encoding)
	{
		XmlChunker.parse(new BOMInputStream(source), encoding, 2, new XmlChunker.Listener()
		{
			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
					throw new RuntimeException("file doesn't start with the mandatory <ONIXMessage> tag");
				final Attribute release = element.getAttributeByName(new QName("release"));
				listener.onix2 = (release == null || release.getValue().startsWith("2"));
				listener.onix3 = (release != null && release.getValue().startsWith("3"));
				if (!listener.onix2 && !listener.onix3)
					throw new RuntimeException("file doesn't comply with neither ONIX2 nor ONIX3");
			}

			@Override
			public void onChunk(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equalsIgnoreCase("Header"))
				{
					listener.onHeaderElement(element);
				}
				else if (nodeName.equalsIgnoreCase("Product"))
				{
					++listener.productNo;
					listener.onProductElement(element);
				}
			}
		});
	}

	public void read(final InputStream source)
	{
		read(source, "UTF-8");
	}

	public void read(final InputStream source, final String encoding)
	{
		if (listener.onBeforeSource(source))
		{
			try
			{
				doRead(source, encoding);
			}
			catch (Exception e)
			{
				e.printStackTrace(listener.log);
				throw new RuntimeException(e);
			}
			listener.log.flush();
			listener.onAfterSource();
		}
	}

	public void read(final String fileName)
	{
		read(fileName, listener.getFileEncoding(fileName));
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
			e.printStackTrace(listener.log);
			throw new RuntimeException(e);
		}
		read(fos, encoding); // outside the try{} to avoid double catching
	}

	public void read(List<String> fileNames)
	{
		if (listener.onBeforeFileList(fileNames))
		{
			List<String> processedFileNames = new ArrayList<>();
			for (String fileName : fileNames)
			{
				try
				{
					if (!listener.onBeforeFile(fileName))
						continue;
					read(fileName);
					processedFileNames.add(fileName);
				}
				catch (Exception ignored)
				{
					// we move on to the next file
				}
			}
			listener.onAfterFileList(processedFileNames);
		}
	}

	/**
	 * 
	 * @param rootLocation
	 *            may be a directory or a file
	 * @param suffix
	 */
	public void readFolder(final String rootLocation, final String pattern)
	{
		try
		{
			read(JonixUtil.findFiles(rootLocation, pattern));
		}
		catch (IOException e)
		{
			e.printStackTrace(listener.log);
			throw new RuntimeException(e);
		}
	}
}
