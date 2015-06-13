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

import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.extract.JonixUnifiedExtractor;
import com.tectonica.jonix.stream.JonixAbstractStreamer;

/**
 * an extractor with the addition of an 'out' member
 * 
 * @author zach
 *
 * @param <H>
 * @param <P>
 */
public abstract class JonixExporter<H, P> extends JonixUnifiedExtractor<H, P>
{
	@Override
	protected void onHeader(H header, JonixAbstractStreamer streamer)
	{
		log("-----------------------------------------------------------\n");
		log(header.toString());
		log("-----------------------------------------------------------\n");
	}

	@Override
	protected void onProduct(P product, JonixAbstractStreamer streamer)
	{
		// show a log message about the product being successfully parsed
		log("retrieved product #" + streamer.getProductNo() + " - " + unifier.labelOf(product));
	}

	// ///////////////////////////////////////////////////////////////////////////////

	public JonixExporter(JonixUnifier<H, P> unifier)
	{
		super(unifier);
	}

	protected PrintStream out = System.out;

	public JonixExporter<H, P> setOut(String fileName)
	{
		return setOut(fileName, "UTF-8");
	}

	public JonixExporter<H, P> setOut(String fileName, String encoding)
	{
		try
		{
			return setOut(new PrintStream(fileName, encoding));
		}
		catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			logStackTrace(e);
			throw new RuntimeException(e);
		}
	}

	public JonixExporter<H, P> setOut(PrintStream out)
	{
		this.out = (out == null) ? System.out : out;
		return this;
	}

	public PrintStream getOut()
	{
		return out;
	}

	@Override
	protected void onAfterSource(JonixAbstractStreamer streamer)
	{
		super.onAfterSource(streamer);
		out.flush();
	}
}
