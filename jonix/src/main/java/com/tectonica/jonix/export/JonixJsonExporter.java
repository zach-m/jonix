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

import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.JonixUtil;
import com.tectonica.jonix.stream.JonixStreamer;

/**
 * An exporter for generating JSON output out of ONIX source(s). The output may be of the:
 * <ul>
 * <li>unified products (i.e. listing the after-unification fields, which are the same for ONIX2 and ONIX3)
 * <li>raw products (i.e. listing the exact same fields and values included in the XML source, which are organized
 * differently in ONIX2 and ONIX3)
 * </ul>
 * When exporting the unified fields, the information may not be complete, but it's better suited for system who don't
 * want to deal with the many discrepancies between ONIX2 and ONIX3.
 * <p>
 * Exporting the raw fields, however, is pretty much a XML-to-JSON functionality, suitable for data inspection
 * scenarios.
 * 
 * @author Zach Melamed
 */
public class JonixJsonExporter<H, P> extends JonixExporter<H, P>
{
	private final boolean exportRawProduct;

	public JonixJsonExporter(JonixUnifier<H, P> context, boolean exportRawProduct)
	{
		super(context);
		this.exportRawProduct = exportRawProduct;
	}

	@Override
	protected void onProduct(P product, JonixStreamer streamer)
	{
		super.onProduct(product, streamer); // logs an info line

		out.println(exportRawProduct ? JonixUtil.toJson(rawOnixProduct) : JonixUtil.toJson(product));
		out.println("\n");
	}
}
