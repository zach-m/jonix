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

import java.util.List;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixTabulator;
import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.stream.JonixStreamer;

/**
 * An exporter for generating tab-delimited output out of ONIX source(s). Turning a tree-like ONIX product into a
 * fixed-length column-oriented table is far from trivial. All the details are explained in {@link JonixColumn}.
 * 
 * @author Zach Melamed
 */
public class JonixTabDelimitedExporter<H, P> extends JonixExporter<H, P>
{
	private final JonixColumn<P>[] columns;
	protected boolean headerPrinted = false;

	public JonixTabDelimitedExporter(JonixUnifier<H, P> unifier, JonixColumn<P>[] columns)
	{
		super(unifier);
		if (columns == null)
			throw new RuntimeException("At least one column must be specified");
		this.columns = columns;
	}

	public JonixColumn<P>[] getColumns()
	{
		return columns;
	}

	@Override
	protected boolean onBeforeFileList(List<String> onixFileNames, JonixStreamer streamer)
	{
		super.onBeforeFileList(onixFileNames, streamer);
		if (!headerPrinted) // we print header once per output, i.e. once in the exporter's life
		{
			out.println(JonixTabulator.headerAsTabDelimitedString(columns));
			headerPrinted = true;
		}
		return true;
	}

	@Override
	protected boolean onProduct(P product, JonixStreamer streamer)
	{
		super.onProduct(product, streamer); // logs an info line
		out.println(JonixTabulator.productAsTabDelimitedString(product, columns));
		
		return true;
	}
}
