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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PersonDateRoles;
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.UnnamedPersonss;
import com.tectonica.jonix.struct.PersonDateStruct;
import com.tectonica.jonix.struct.PersonNameIdentifierStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Contributor implements Serializable
{
	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SequenceNumber sequenceNumber; // Optional
	public List<ContributorRole> contributorRoles; // OneOrMore
	public List<LanguageCode> languageCodes; // ZeroOrMore
	public SequenceNumberWithinRole sequenceNumberWithinRole; // Optional
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
	public List<Name> names; // ZeroOrMore
	public List<PersonNameIdentifier> personNameIdentifiers; // ZeroOrMore
	public List<PersonDate> personDates; // ZeroOrMore
	public List<ProfessionalAffiliation> professionalAffiliations; // ZeroOrMore
	public CorporateName corporateName; // Optional
	public BiographicalNote biographicalNote; // Optional
	public List<Website> websites; // ZeroOrMore
	public ProfessionalPosition professionalPosition; // Optional
	public Affiliation affiliation; // Optional
	public ContributorDescription contributorDescription; // Optional
	public UnnamedPersons unnamedPersons; // Optional
	public List<CountryCode> countryCodes; // ZeroOrMore
	public List<RegionCode> regionCodes; // ZeroOrMore

	public Contributor()
	{}

	public Contributor(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SequenceNumber.refname) || name.equals(SequenceNumber.shortname))
					sequenceNumber = new SequenceNumber(element);
				else if (name.equals(ContributorRole.refname) || name.equals(ContributorRole.shortname))
					contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(element));
				else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
					languageCodes = JPU.addToList(languageCodes, new LanguageCode(element));
				else if (name.equals(SequenceNumberWithinRole.refname) || name.equals(SequenceNumberWithinRole.shortname))
					sequenceNumberWithinRole = new SequenceNumberWithinRole(element);
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
				else if (name.equals(Name.refname) || name.equals(Name.shortname))
					names = JPU.addToList(names, new Name(element));
				else if (name.equals(PersonNameIdentifier.refname) || name.equals(PersonNameIdentifier.shortname))
					personNameIdentifiers = JPU.addToList(personNameIdentifiers, new PersonNameIdentifier(element));
				else if (name.equals(PersonDate.refname) || name.equals(PersonDate.shortname))
					personDates = JPU.addToList(personDates, new PersonDate(element));
				else if (name.equals(ProfessionalAffiliation.refname) || name.equals(ProfessionalAffiliation.shortname))
					professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(element));
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					corporateName = new CorporateName(element);
				else if (name.equals(BiographicalNote.refname) || name.equals(BiographicalNote.shortname))
					biographicalNote = new BiographicalNote(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(ProfessionalPosition.refname) || name.equals(ProfessionalPosition.shortname))
					professionalPosition = new ProfessionalPosition(element);
				else if (name.equals(Affiliation.refname) || name.equals(Affiliation.shortname))
					affiliation = new Affiliation(element);
				else if (name.equals(ContributorDescription.refname) || name.equals(ContributorDescription.shortname))
					contributorDescription = new ContributorDescription(element);
				else if (name.equals(UnnamedPersons.refname) || name.equals(UnnamedPersons.shortname))
					unnamedPersons = new UnnamedPersons(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					countryCodes = JPU.addToList(countryCodes, new CountryCode(element));
				else if (name.equals(RegionCode.refname) || name.equals(RegionCode.shortname))
					regionCodes = JPU.addToList(regionCodes, new RegionCode(element));
			}
		});
	}

	public String getSequenceNumberValue()
	{
		return (sequenceNumber == null) ? null : sequenceNumber.value;
	}

	public List<ContributorRoles> getContributorRoleValues()
	{
		if (contributorRoles != null)
		{
			List<ContributorRoles> list = new ArrayList<>();
			for (ContributorRole i : contributorRoles)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<LanguageCodeIso6392Bs> getLanguageCodeValues()
	{
		if (languageCodes != null)
		{
			List<LanguageCodeIso6392Bs> list = new ArrayList<>();
			for (LanguageCode i : languageCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public String getSequenceNumberWithinRoleValue()
	{
		return (sequenceNumberWithinRole == null) ? null : sequenceNumberWithinRole.value;
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

	public String getBiographicalNoteValue()
	{
		return (biographicalNote == null) ? null : biographicalNote.value;
	}

	public String getProfessionalPositionValue()
	{
		return (professionalPosition == null) ? null : professionalPosition.value;
	}

	public String getAffiliationValue()
	{
		return (affiliation == null) ? null : affiliation.value;
	}

	public String getContributorDescriptionValue()
	{
		return (contributorDescription == null) ? null : contributorDescription.value;
	}

	public UnnamedPersonss getUnnamedPersonsValue()
	{
		return (unnamedPersons == null) ? null : unnamedPersons.value;
	}

	public List<CountryCodeIso31661s> getCountryCodeValues()
	{
		if (countryCodes != null)
		{
			List<CountryCodeIso31661s> list = new ArrayList<>();
			for (CountryCode i : countryCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<java.util.Set<String>> getRegionCodeSets()
	{
		if (regionCodes != null)
		{
			List<java.util.Set<String>> list = new ArrayList<>();
			for (RegionCode i : regionCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public PersonNameIdentifierStruct findPersonNameIdentifier(PersonNameIdentifierTypes personNameIDType)
	{
		if (personNameIdentifiers != null)
		{
			for (PersonNameIdentifier x : personNameIdentifiers)
			{
				if (x.getPersonNameIDTypeValue() == personNameIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<PersonNameIdentifierStruct> findPersonNameIdentifiers(java.util.Set<PersonNameIdentifierTypes> personNameIDTypes)
	{
		if (personNameIdentifiers != null)
		{
			List<PersonNameIdentifierStruct> matches = new ArrayList<>();
			for (PersonNameIdentifier x : personNameIdentifiers)
			{
				if (personNameIDTypes.contains(x.getPersonNameIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}

	public PersonDateStruct findPersonDate(PersonDateRoles personDateRole)
	{
		if (personDates != null)
		{
			for (PersonDate x : personDates)
			{
				if (x.getPersonDateRoleValue() == personDateRole)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<PersonDateStruct> findPersonDates(java.util.Set<PersonDateRoles> personDateRoles)
	{
		if (personDates != null)
		{
			List<PersonDateStruct> matches = new ArrayList<>();
			for (PersonDate x : personDates)
			{
				if (personDateRoles.contains(x.getPersonDateRoleValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
