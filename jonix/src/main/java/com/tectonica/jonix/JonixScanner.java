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

import com.tectonica.jonix.JonixParser.JonixParserListener;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;

public abstract class JonixScanner
{
	protected PrintStream log = System.err;
	private final JonixParser parser;

	public JonixScanner()
	{
		parser = new JonixParser();
		parser.setJonixParserListener(new JonixParserListener()
		{
			@Override
			public void onHeader(BasicHeader header)
			{
				JonixScanner.this.onHeader(header);
			}

			@Override
			public void onProduct(BasicProduct product, int index)
			{
				JonixScanner.this.onProduct(product, index);
			}
		});
	}

	public JonixScanner(PrintStream log)
	{
		this();
		setLog(log);
	}

	public void setLog(PrintStream log)
	{
		this.log = (log == null) ? System.err : log;
	}

	public void setLog(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.log = new PrintStream(fileName, "UTF8");
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
				doScan(parser, source);
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

	protected void doScan(JonixParser parser, InputStream source)
	{
		parser.parse(source);
	}

	protected abstract void onHeader(BasicHeader header);

	protected abstract void onProduct(BasicProduct product, int index);

	protected void onAfterSource()
	{
		log.flush();
	}
}
