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

import com.tectonica.jonix.JonixContext;
import com.tectonica.jonix.util.JSON;

public class JonixDumpExporter<H, P> extends JonixFilesExport<H, P>
{
	public JonixDumpExporter(JonixContext<H, P> context)
	{
		super(context);
	}

	@Override
	protected void onProduct(P product, int index)
	{
		super.onProduct(product, index);

		out.println(JSON.toJson(context.onixProductObjectOf(product)));
		out.println("**********************************************************************************\n");
	}
}
