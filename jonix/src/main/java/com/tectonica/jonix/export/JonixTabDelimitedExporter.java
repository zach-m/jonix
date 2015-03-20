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

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixFormatter;
import com.tectonica.jonix.basic.BasicProduct;

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
	protected void onProduct(BasicProduct product, int index)
	{
		super.onProduct(product, index);

		// on first product, if no columns-set was explicitly set, ask for the default one
		if (this.columns == null)
			columns = product.getDefaultColumns();
		if (columns == null)
			throw new NullPointerException("No columns are set for output");

		onExportProduct(product);
	}

	/**
	 * Override this method to generate your own needed output. By default generates tab-delimited output.
	 */
	protected void onExportProduct(BasicProduct product)
	{
		out.println(JonixFormatter.productAsTabDelimitedString(product, columns));
	}
}
