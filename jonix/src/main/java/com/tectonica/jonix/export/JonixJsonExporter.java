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
import com.tectonica.jonix.JonixUtil;

public class JonixJsonExporter<H, P> extends JonixExporter<H, P>
{
	private final boolean exportRawProduct;

	public JonixJsonExporter(JonixContext<H, P> context, boolean exportRawProduct)
	{
		super(context);
		this.exportRawProduct = exportRawProduct;
	}

	@Override
	protected void onProduct(P product)
	{
		super.onProduct(product); // logs an info line

		out.println(exportRawProduct ? JonixUtil.toJson(getRawOnixObject()) : JonixUtil.toJson(product));
		out.println("\n");
	}
}
