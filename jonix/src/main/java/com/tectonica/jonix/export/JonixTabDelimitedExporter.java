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
import com.tectonica.jonix.stream.JonixAbstractStreamer;

public class JonixTabDelimitedExporter<H, P> extends JonixExporter<H, P>
{
	protected JonixColumn<P>[] columns;
	private boolean headerPrinted = false;

	public JonixTabDelimitedExporter(JonixUnifier<H, P> context)
	{
		super(context);
	}

	public JonixColumn<P>[] getColumns()
	{
		return columns;
	}

	public void setColumns(JonixColumn<P>[] columns)
	{
		this.columns = columns;
	}

	@Override
	protected boolean onBeforeFileList(List<String> onixFileNames, JonixAbstractStreamer streamer)
	{
		super.onBeforeFileList(onixFileNames, streamer);
		if (columns == null)
			columns = unifier.getDefaultColumns();
		if (!headerPrinted)
		{
			out.println(JonixTabulator.headerAsTabDelimitedString(columns));
			headerPrinted = true;
		}
		return true;
	}

	@Override
	protected void onProduct(P product, JonixAbstractStreamer streamer)
	{
		super.onProduct(product, streamer); // logs an info line
		out.println(JonixTabulator.productAsTabDelimitedString(product, columns));
	}
}
