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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class SalesRights
{
	public static final String refname = "SalesRights";
	public static final String shortname = "salesrights";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public SalesRightsType salesRightsType; // Required
	public Territory territory; // Required
	public List<SalesRestriction> salesRestrictions; // ZeroOrMore
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public PublisherName publisherName; // Optional

	public static SalesRights fromDoc(org.w3c.dom.Element element)
	{
		final SalesRights x = new SalesRights();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SalesRightsType.refname) || name.equals(SalesRightsType.shortname))
					x.salesRightsType = SalesRightsType.fromDoc(element);
				else if (name.equals(Territory.refname) || name.equals(Territory.shortname))
					x.territory = Territory.fromDoc(element);
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					x.salesRestrictions = DU.addToList(x.salesRestrictions, SalesRestriction.fromDoc(element));
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
			}
		});

		return x;
	}
}
