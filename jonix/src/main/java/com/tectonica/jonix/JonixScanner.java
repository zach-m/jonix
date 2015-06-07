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

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.tectonica.jonix.JonixReader.JonixReaderListener;

public abstract class JonixScanner<H, P>
{
	protected final JonixContext<H, P> context;

	protected PrintStream log = System.err;
	private final JonixReader<H, P> reader;

	public JonixScanner(JonixContext<H, P> context)
	{
		if (context == null)
			throw new NullPointerException("context is required");
		this.context = context;

		reader = new JonixReader<H, P>(context);
		reader.setListener(new JonixReaderListener<H, P>()
		{
			@Override
			public void onHeader(H header)
			{
				JonixScanner.this.onHeader(header);
			}

			@Override
			public void onProduct(P product, int index)
			{
				JonixScanner.this.onProduct(product, index);

			}
		});
	}

	public JonixScanner<H, P> setLog(PrintStream log)
	{
		this.log = (log == null) ? System.err : log;
		return this;
	}

	public JonixScanner<H, P> setLog(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.log = new PrintStream(fileName, "UTF-8");
		return this;
	}

	public PrintStream getLog()
	{
		return log;
	}

	public void scan(InputStream source)
	{
		if (onBeforeSource(source))
		{
			try
			{
				doScan(reader, source);
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
			onAfterSource();
		}
	}

	// OVERRIDE CANDIDATES:

	protected boolean onBeforeSource(InputStream source)
	{
		return true;
	}

	protected void doScan(JonixReader<H, P> parser, InputStream source)
	{
		parser.read(source);
	}

	protected Object getRawOnixObject()
	{
		return reader.rawOnixObject;
	}

	protected abstract void onHeader(H header);

	protected abstract void onProduct(P product, int index);

	protected void onAfterSource()
	{
		log.flush();
	}
}
