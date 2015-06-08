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

package com.tectonica.jonix.export;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.tectonica.jonix.JonixContext;
import com.tectonica.jonix.JonixReader;

public abstract class JonixExporter<H, P> extends JonixReader<H, P>
{
	protected PrintStream out = System.out;

	public JonixExporter(JonixContext<H, P> context)
	{
		super(context);
	}

	public void setOut(PrintStream out)
	{
		this.out = (out == null) ? System.out : out;
	}

	public void setOut(String fileName)
	{
		setOut(fileName, "UTF-8");
	}

	public void setOut(String fileName, String encoding)
	{
		try
		{
			this.out = new PrintStream(fileName, encoding);
		}
		catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace(log);
			throw new RuntimeException(e);
		}
	}

	public PrintStream getOut()
	{
		return out;
	}

	@Override
	protected boolean onBeforeFileList(List<String> onixFileNames)
	{
		log.println("Parsing " + onixFileNames.size() + " files..");
		return true;
	}

	@Override
	protected void onAfterFileList(List<String> processedFileNames)
	{
		log.printf("** DONE, %d products exported so far **\n", productNo);
	}

	@Override
	protected boolean onBeforeFile(String fileName)
	{
		log.println("opening " + fileName + ".. ");
		return true;
	}

	@Override
	protected void onAfterSource()
	{
		super.onAfterSource();
		out.flush();
	}

	@Override
	protected void onHeader(H header)
	{
		logHeaderSummary(header);
	}

	@Override
	protected void onProduct(P product)
	{
		logProductSummary(product);
	}

	protected void logHeaderSummary(H header)
	{
		log.println("-----------------------------------------------------------\n");
		log.println(header.toString());
		log.println("-----------------------------------------------------------\n");
	}

	protected void logProductSummary(P product)
	{
		// show a log message about the product being successfully parsed
		log.println("retrieved product #" + productNo + " - " + context.labelOf(product));
	}
}
