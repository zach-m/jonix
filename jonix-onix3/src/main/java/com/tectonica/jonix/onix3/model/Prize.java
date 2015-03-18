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

public class Prize
{
	public static final String refname = "Prize";
	public static final String shortname = "prize";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public List<PrizeName> prizeNames; // OneOrMore
	public PrizeYear prizeYear; // Optional
	public PrizeCountry prizeCountry; // Optional
	public PrizeCode prizeCode; // Optional
	public List<PrizeStatement> prizeStatements; // ZeroOrMore
	public List<PrizeJury> prizeJurys; // ZeroOrMore

	public static Prize fromDoc(org.w3c.dom.Element element)
	{
		final Prize x = new Prize();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PrizeName.refname) || name.equals(PrizeName.shortname))
					x.prizeNames = DU.addToList(x.prizeNames, PrizeName.fromDoc(element));
				else if (name.equals(PrizeYear.refname) || name.equals(PrizeYear.shortname))
					x.prizeYear = PrizeYear.fromDoc(element);
				else if (name.equals(PrizeCountry.refname) || name.equals(PrizeCountry.shortname))
					x.prizeCountry = PrizeCountry.fromDoc(element);
				else if (name.equals(PrizeCode.refname) || name.equals(PrizeCode.shortname))
					x.prizeCode = PrizeCode.fromDoc(element);
				else if (name.equals(PrizeStatement.refname) || name.equals(PrizeStatement.shortname))
					x.prizeStatements = DU.addToList(x.prizeStatements, PrizeStatement.fromDoc(element));
				else if (name.equals(PrizeJury.refname) || name.equals(PrizeJury.shortname))
					x.prizeJurys = DU.addToList(x.prizeJurys, PrizeJury.fromDoc(element));
			}
		});

		return x;
	}
}
