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

public class NameAsSubject
{
	public static final String refname = "NameAsSubject";
	public static final String shortname = "nameassubject";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public NameType nameType; // Optional
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

	public static NameAsSubject fromDoc(org.w3c.dom.Element element)
	{
		final NameAsSubject x = new NameAsSubject();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(NameType.refname) || name.equals(NameType.shortname))
					x.nameType = NameType.fromDoc(element);
				else if (name.equals(NameIdentifier.refname) || name.equals(NameIdentifier.shortname))
					x.nameIdentifiers = DU.addToList(x.nameIdentifiers, NameIdentifier.fromDoc(element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					x.personName = PersonName.fromDoc(element);
				else if (name.equals(PersonNameInverted.refname) || name.equals(PersonNameInverted.shortname))
					x.personNameInverted = PersonNameInverted.fromDoc(element);
				else if (name.equals(TitlesBeforeNames.refname) || name.equals(TitlesBeforeNames.shortname))
					x.titlesBeforeNames = TitlesBeforeNames.fromDoc(element);
				else if (name.equals(NamesBeforeKey.refname) || name.equals(NamesBeforeKey.shortname))
					x.namesBeforeKey = NamesBeforeKey.fromDoc(element);
				else if (name.equals(PrefixToKey.refname) || name.equals(PrefixToKey.shortname))
					x.prefixToKey = PrefixToKey.fromDoc(element);
				else if (name.equals(KeyNames.refname) || name.equals(KeyNames.shortname))
					x.keyNames = KeyNames.fromDoc(element);
				else if (name.equals(NamesAfterKey.refname) || name.equals(NamesAfterKey.shortname))
					x.namesAfterKey = NamesAfterKey.fromDoc(element);
				else if (name.equals(SuffixToKey.refname) || name.equals(SuffixToKey.shortname))
					x.suffixToKey = SuffixToKey.fromDoc(element);
				else if (name.equals(LettersAfterNames.refname) || name.equals(LettersAfterNames.shortname))
					x.lettersAfterNames = LettersAfterNames.fromDoc(element);
				else if (name.equals(TitlesAfterNames.refname) || name.equals(TitlesAfterNames.shortname))
					x.titlesAfterNames = TitlesAfterNames.fromDoc(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					x.corporateName = CorporateName.fromDoc(element);
				else if (name.equals(CorporateNameInverted.refname) || name.equals(CorporateNameInverted.shortname))
					x.corporateNameInverted = CorporateNameInverted.fromDoc(element);
			}
		});

		return x;
	}
}
