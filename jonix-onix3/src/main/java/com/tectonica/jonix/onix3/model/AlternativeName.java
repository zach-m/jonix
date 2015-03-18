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

public class AlternativeName
{
	public static final String refname = "AlternativeName";
	public static final String shortname = "alternativename";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public NameType nameType; // Required
	public List<NameIdentifier> nameIdentifiers; // OneOrMore
	public PersonName personName; // Required
	public PersonNameInverted personNameInverted; // Optional
	public TitlesBeforeNames titlesBeforeNames; // Optional
	public NamesBeforeKey namesBeforeKey; // Optional
	public PrefixToKey prefixToKey; // Optional
	public KeyNames keyNames; // Required
	public NamesAfterKey namesAfterKey; // Optional
	public SuffixToKey suffixToKey; // Optional
	public LettersAfterNames lettersAfterNames; // Optional
	public TitlesAfterNames titlesAfterNames; // Optional
	public CorporateName corporateName; // Required
	public CorporateNameInverted corporateNameInverted; // Optional

	public static AlternativeName fromDoc(org.w3c.dom.Element element)
	{
		final AlternativeName x = new AlternativeName();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(NameType.refname) || name.equalsIgnoreCase(NameType.shortname))
					x.nameType = NameType.fromDoc(element);
				else if (name.equalsIgnoreCase(NameIdentifier.refname) || name.equalsIgnoreCase(NameIdentifier.shortname))
					x.nameIdentifiers = DU.addToList(x.nameIdentifiers, NameIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(PersonName.refname) || name.equalsIgnoreCase(PersonName.shortname))
					x.personName = PersonName.fromDoc(element);
				else if (name.equalsIgnoreCase(PersonNameInverted.refname) || name.equalsIgnoreCase(PersonNameInverted.shortname))
					x.personNameInverted = PersonNameInverted.fromDoc(element);
				else if (name.equalsIgnoreCase(TitlesBeforeNames.refname) || name.equalsIgnoreCase(TitlesBeforeNames.shortname))
					x.titlesBeforeNames = TitlesBeforeNames.fromDoc(element);
				else if (name.equalsIgnoreCase(NamesBeforeKey.refname) || name.equalsIgnoreCase(NamesBeforeKey.shortname))
					x.namesBeforeKey = NamesBeforeKey.fromDoc(element);
				else if (name.equalsIgnoreCase(PrefixToKey.refname) || name.equalsIgnoreCase(PrefixToKey.shortname))
					x.prefixToKey = PrefixToKey.fromDoc(element);
				else if (name.equalsIgnoreCase(KeyNames.refname) || name.equalsIgnoreCase(KeyNames.shortname))
					x.keyNames = KeyNames.fromDoc(element);
				else if (name.equalsIgnoreCase(NamesAfterKey.refname) || name.equalsIgnoreCase(NamesAfterKey.shortname))
					x.namesAfterKey = NamesAfterKey.fromDoc(element);
				else if (name.equalsIgnoreCase(SuffixToKey.refname) || name.equalsIgnoreCase(SuffixToKey.shortname))
					x.suffixToKey = SuffixToKey.fromDoc(element);
				else if (name.equalsIgnoreCase(LettersAfterNames.refname) || name.equalsIgnoreCase(LettersAfterNames.shortname))
					x.lettersAfterNames = LettersAfterNames.fromDoc(element);
				else if (name.equalsIgnoreCase(TitlesAfterNames.refname) || name.equalsIgnoreCase(TitlesAfterNames.shortname))
					x.titlesAfterNames = TitlesAfterNames.fromDoc(element);
				else if (name.equalsIgnoreCase(CorporateName.refname) || name.equalsIgnoreCase(CorporateName.shortname))
					x.corporateName = CorporateName.fromDoc(element);
				else if (name.equalsIgnoreCase(CorporateNameInverted.refname) || name.equalsIgnoreCase(CorporateNameInverted.shortname))
					x.corporateNameInverted = CorporateNameInverted.fromDoc(element);
			}
		});

		return x;
	}
}
