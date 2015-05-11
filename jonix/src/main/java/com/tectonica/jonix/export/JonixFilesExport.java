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

import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.JonixFilesScanner;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct2;

public abstract class JonixFilesExport extends JonixFilesScanner
{
	public JonixFilesExport()
	{
		super();
	}

	public JonixFilesExport(PrintStream out, PrintStream log)
	{
		super(out, log);
	}

	@Override
	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		log.println("Parsing " + onixFileNames.size() + " files");
		return true;
	}

	@Override
	protected void onAfterFiles()
	{
		log.println("** DONE **");
	}

	@Override
	protected boolean onBeforeFile(String fileName)
	{
		log.println("opening " + fileName + ".. ");
		return true;
	}

	@Override
	protected void onHeader(BasicHeader header)
	{
		logHeaderParseSummary(header);
	}

	@Override
	protected void onProduct(BasicProduct2 product, int index)
	{
		logProductParseSummary(product, index);
	}

	protected void logHeaderParseSummary(BasicHeader header)
	{
		log.println("-----------------------------------------------------------\n");
		log.println(header.toString());
		log.println("-----------------------------------------------------------\n");
	}

	protected void logProductParseSummary(BasicProduct2 product, int index)
	{
		// show a log message about the product being successfully parsed
		log.println("parsed product #" + index + " - " + product.getLabel());
	}
}
