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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PersonOrganizationNameTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixNameIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class AlternativeName implements OnixSuperComposite, Serializable
{
	public static final String refname = "AlternativeName";
	public static final String shortname = "alternativename";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
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

	public AlternativeName()
	{}

	public AlternativeName(org.w3c.dom.Element element)
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
				if (name.equals(NameType.refname) || name.equals(NameType.shortname))
					nameType = new NameType(element);
				else if (name.equals(NameIdentifier.refname) || name.equals(NameIdentifier.shortname))
					nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					personName = new PersonName(element);
				else if (name.equals(PersonNameInverted.refname) || name.equals(PersonNameInverted.shortname))
					personNameInverted = new PersonNameInverted(element);
				else if (name.equals(TitlesBeforeNames.refname) || name.equals(TitlesBeforeNames.shortname))
					titlesBeforeNames = new TitlesBeforeNames(element);
				else if (name.equals(NamesBeforeKey.refname) || name.equals(NamesBeforeKey.shortname))
					namesBeforeKey = new NamesBeforeKey(element);
				else if (name.equals(PrefixToKey.refname) || name.equals(PrefixToKey.shortname))
					prefixToKey = new PrefixToKey(element);
				else if (name.equals(KeyNames.refname) || name.equals(KeyNames.shortname))
					keyNames = new KeyNames(element);
				else if (name.equals(NamesAfterKey.refname) || name.equals(NamesAfterKey.shortname))
					namesAfterKey = new NamesAfterKey(element);
				else if (name.equals(SuffixToKey.refname) || name.equals(SuffixToKey.shortname))
					suffixToKey = new SuffixToKey(element);
				else if (name.equals(LettersAfterNames.refname) || name.equals(LettersAfterNames.shortname))
					lettersAfterNames = new LettersAfterNames(element);
				else if (name.equals(TitlesAfterNames.refname) || name.equals(TitlesAfterNames.shortname))
					titlesAfterNames = new TitlesAfterNames(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					corporateName = new CorporateName(element);
				else if (name.equals(CorporateNameInverted.refname) || name.equals(CorporateNameInverted.shortname))
					corporateNameInverted = new CorporateNameInverted(element);
			}
		});
	}

	public PersonOrganizationNameTypes getNameTypeValue()
	{
		return (nameType == null) ? null : nameType.value;
	}

	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	public String getPersonNameInvertedValue()
	{
		return (personNameInverted == null) ? null : personNameInverted.value;
	}

	public String getTitlesBeforeNamesValue()
	{
		return (titlesBeforeNames == null) ? null : titlesBeforeNames.value;
	}

	public String getNamesBeforeKeyValue()
	{
		return (namesBeforeKey == null) ? null : namesBeforeKey.value;
	}

	public String getPrefixToKeyValue()
	{
		return (prefixToKey == null) ? null : prefixToKey.value;
	}

	public String getKeyNamesValue()
	{
		return (keyNames == null) ? null : keyNames.value;
	}

	public String getNamesAfterKeyValue()
	{
		return (namesAfterKey == null) ? null : namesAfterKey.value;
	}

	public String getSuffixToKeyValue()
	{
		return (suffixToKey == null) ? null : suffixToKey.value;
	}

	public String getLettersAfterNamesValue()
	{
		return (lettersAfterNames == null) ? null : lettersAfterNames.value;
	}

	public String getTitlesAfterNamesValue()
	{
		return (titlesAfterNames == null) ? null : titlesAfterNames.value;
	}

	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}

	public String getCorporateNameInvertedValue()
	{
		return (corporateNameInverted == null) ? null : corporateNameInverted.value;
	}

	public JonixNameIdentifier findNameIdentifier(NameCodeTypes nameIDType)
	{
		if (nameIdentifiers != null)
		{
			for (NameIdentifier x : nameIdentifiers)
			{
				if (x.getNameIDTypeValue() == nameIDType)
					return x.asJonixNameIdentifier();
			}
		}
		return null;
	}

	public List<JonixNameIdentifier> findNameIdentifiers(java.util.Set<NameCodeTypes> nameIDTypes)
	{
		if (nameIdentifiers != null)
		{
			List<JonixNameIdentifier> matches = new ArrayList<>();
			for (NameIdentifier x : nameIdentifiers)
			{
				if (nameIDTypes == null || nameIDTypes.contains(x.getNameIDTypeValue()))
					matches.add(x.asJonixNameIdentifier());
			}
			return matches;
		}
		return null;
	}
}
