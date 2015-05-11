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

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixFormatter;
import com.tectonica.jonix.basic.BasicProduct2;

public class JonixTabDelimitedExporter extends JonixFilesExport
{
	protected JonixColumn[] columns;

	public JonixTabDelimitedExporter()
	{
		super();
	}

	public JonixTabDelimitedExporter(PrintStream out, PrintStream log)
	{
		super(out, log);
	}

	public JonixColumn[] getColumns()
	{
		return columns;
	}

	public void setColumns(JonixColumn[] columns)
	{
		this.columns = columns;
	}

	@Override
	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		super.onBeforeFiles(onixFileNames);
		if (columns == null)
			columns = BasicProduct2.getDefaultColumns();
		out.println(JonixFormatter.headerAsTabDelimitedString(columns));
		return true;
	}

	@Override
	protected void onProduct(BasicProduct2 product, int index)
	{
		out.println(JonixFormatter.productAsTabDelimitedString(product, columns));
		logProductParseSummary(product, index);
	}
}
