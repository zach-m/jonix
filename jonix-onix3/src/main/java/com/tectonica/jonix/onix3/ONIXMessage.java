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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixContent;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ONIXMessage implements OnixContent, Serializable
{
	public static final String refname = "ONIXMessage";
	public static final String shortname = "ONIXmessage";
	public static final String release = "3.0";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public Header header; // Required
	public NoProduct noProduct; // Optional
	public List<Product> products; // ZeroOrMore

	public ONIXMessage()
	{}

	public ONIXMessage(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Header.refname) || name.equals(Header.shortname))
					header = new Header(element);
				else if (name.equals(NoProduct.refname) || name.equals(NoProduct.shortname))
					noProduct = new NoProduct(element);
				else if (name.equals(Product.refname) || name.equals(Product.shortname))
					products = JPU.addToList(products, new Product(element));
			}
		});
	}
}
