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

import com.tectonica.jonix.basic.BasicProduct3;
import com.tectonica.jonix.util.JSON;

public class JonixDumpExporter extends JonixFilesExport
{
	public JonixDumpExporter()
	{
		super();
	}

	public JonixDumpExporter(PrintStream out, PrintStream log)
	{
		super(out, log);
	}

	@Override
	protected void onProduct(BasicProduct3 product, int index)
	{
		super.onProduct(product, index);

		out.println(JSON.toJson(product.product));
		out.println("**********************************************************************************\n");
	}
}
