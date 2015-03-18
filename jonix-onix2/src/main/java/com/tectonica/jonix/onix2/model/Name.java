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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class Name
{
	public static final String refname = "Name";
	public static final String shortname = "name";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public PersonNameType personNameType; // Required
	public PersonName personName; // Required
	public PersonNameInverted personNameInverted; // Optional
	public TitlesBeforeNames titlesBeforeNames; // Optional
	public NamesBeforeKey namesBeforeKey; // Optional
	public PrefixToKey prefixToKey; // Optional
	public KeyNames keyNames; // Optional
	public NamesAfterKey namesAfterKey; // Optional
	public SuffixToKey suffixToKey; // Optional
	public LettersAfterNames lettersAfterNames; // Optional
	public TitlesAfterNames titlesAfterNames; // Optional
	public List<PersonNameIdentifier> personNameIdentifiers; // ZeroOrMore

	public static Name fromDoc(org.w3c.dom.Element element)
	{
		final Name x = new Name();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(PersonNameType.refname) || name.equalsIgnoreCase(PersonNameType.shortname))
					x.personNameType = PersonNameType.fromDoc(element);
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
				else if (name.equalsIgnoreCase(PersonNameIdentifier.refname) || name.equalsIgnoreCase(PersonNameIdentifier.shortname))
					x.personNameIdentifiers = DU.addToList(x.personNameIdentifiers, PersonNameIdentifier.fromDoc(element));
			}
		});

		return x;
	}
}
