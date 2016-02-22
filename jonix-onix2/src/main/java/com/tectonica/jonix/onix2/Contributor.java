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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PersonDateRoles;
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.UnnamedPersonss;
import com.tectonica.jonix.struct.JonixPersonDate;
import com.tectonica.jonix.struct.JonixPersonNameIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Contributor composite</h1>
 * <p>
 * A group of data elements which together describe a personal or corporate contributor to a content item. Optional and
 * repeatable. <strong>Please see Group&nbsp;PR.8 for details.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Contributor&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;contributor&gt;</td>
 * </tr>
 * </table>
 */
public class Contributor implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is optional)
	 */
	public SequenceNumber sequenceNumber;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ContributorRole> contributorRoles;

	/**
	 * (this list may be empty)
	 */
	public List<LanguageCode> languageCodes;

	/**
	 * (this field is optional)
	 */
	public SequenceNumberWithinRole sequenceNumberWithinRole;

	/**
	 * (this field is required)
	 */
	public PersonName personName;

	/**
	 * (this field is optional)
	 */
	public PersonNameInverted personNameInverted;

	/**
	 * (this field is optional)
	 */
	public TitlesBeforeNames titlesBeforeNames;

	/**
	 * (this field is optional)
	 */
	public NamesBeforeKey namesBeforeKey;

	/**
	 * (this field is optional)
	 */
	public PrefixToKey prefixToKey;

	/**
	 * (this field is optional)
	 */
	public KeyNames keyNames;

	/**
	 * (this field is optional)
	 */
	public NamesAfterKey namesAfterKey;

	/**
	 * (this field is optional)
	 */
	public SuffixToKey suffixToKey;

	/**
	 * (this field is optional)
	 */
	public LettersAfterNames lettersAfterNames;

	/**
	 * (this field is optional)
	 */
	public TitlesAfterNames titlesAfterNames;

	/**
	 * (this list may be empty)
	 */
	public List<Name> names;

	/**
	 * (this list may be empty)
	 */
	public List<PersonNameIdentifier> personNameIdentifiers;

	/**
	 * (this list may be empty)
	 */
	public List<PersonDate> personDates;

	/**
	 * (this list may be empty)
	 */
	public List<ProfessionalAffiliation> professionalAffiliations;

	/**
	 * (this field is optional)
	 */
	public CorporateName corporateName;

	/**
	 * (this field is optional)
	 */
	public BiographicalNote biographicalNote;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this field is optional)
	 */
	public ProfessionalPosition professionalPosition;

	/**
	 * (this field is optional)
	 */
	public Affiliation affiliation;

	/**
	 * (this field is optional)
	 */
	public ContributorDescription contributorDescription;

	/**
	 * (this field is optional)
	 */
	public UnnamedPersons unnamedPersons;

	/**
	 * (this list may be empty)
	 */
	public List<CountryCode> countryCodes;

	/**
	 * (this list may be empty)
	 */
	public List<RegionCode> regionCodes;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Contributor()
	{}

	public Contributor(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

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
				else if (name.equals(SequenceNumberWithinRole.refname)
						|| name.equals(SequenceNumberWithinRole.shortname))
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
					professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(
							element));
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

	/**
	 * Raw Format: Variable-length integer, 1, 2, 3 etc, suggested maximum length 3 digits
	 */
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

	public List<LanguageCodes> getLanguageCodeValues()
	{
		if (languageCodes != null)
		{
			List<LanguageCodes> list = new ArrayList<>();
			for (LanguageCode i : languageCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length integer, 1, 2, 3 etc, suggested maximum length 3 digits
	 */
	public String getSequenceNumberWithinRoleValue()
	{
		return (sequenceNumberWithinRole == null) ? null : sequenceNumberWithinRole.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getPersonNameInvertedValue()
	{
		return (personNameInverted == null) ? null : personNameInverted.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getTitlesBeforeNamesValue()
	{
		return (titlesBeforeNames == null) ? null : titlesBeforeNames.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getNamesBeforeKeyValue()
	{
		return (namesBeforeKey == null) ? null : namesBeforeKey.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getPrefixToKeyValue()
	{
		return (prefixToKey == null) ? null : prefixToKey.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getKeyNamesValue()
	{
		return (keyNames == null) ? null : keyNames.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getNamesAfterKeyValue()
	{
		return (namesAfterKey == null) ? null : namesAfterKey.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getSuffixToKeyValue()
	{
		return (suffixToKey == null) ? null : suffixToKey.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getLettersAfterNamesValue()
	{
		return (lettersAfterNames == null) ? null : lettersAfterNames.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getTitlesAfterNamesValue()
	{
		return (titlesAfterNames == null) ? null : titlesAfterNames.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 500 characters
	 */
	public String getBiographicalNoteValue()
	{
		return (biographicalNote == null) ? null : biographicalNote.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getProfessionalPositionValue()
	{
		return (professionalPosition == null) ? null : professionalPosition.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getAffiliationValue()
	{
		return (affiliation == null) ? null : affiliation.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getContributorDescriptionValue()
	{
		return (contributorDescription == null) ? null : contributorDescription.value;
	}

	public UnnamedPersonss getUnnamedPersonsValue()
	{
		return (unnamedPersons == null) ? null : unnamedPersons.value;
	}

	public List<CountryCodes> getCountryCodeValues()
	{
		if (countryCodes != null)
		{
			List<CountryCodes> list = new ArrayList<>();
			for (CountryCode i : countryCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length code, consisting of upper case letters with or without a hyphen, successive codes
	 * being separated by spaces. Suggested maximum length 8 characters.
	 */
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

	public JonixPersonNameIdentifier findPersonNameIdentifier(PersonNameIdentifierTypes personNameIDType)
	{
		if (personNameIdentifiers != null)
		{
			for (PersonNameIdentifier x : personNameIdentifiers)
			{
				if (x.getPersonNameIDTypeValue() == personNameIDType)
					return x.asJonixPersonNameIdentifier();
			}
		}
		return null;
	}

	public List<JonixPersonNameIdentifier> findPersonNameIdentifiers(
			java.util.Set<PersonNameIdentifierTypes> personNameIDTypes)
	{
		if (personNameIdentifiers != null)
		{
			List<JonixPersonNameIdentifier> matches = new ArrayList<>();
			for (PersonNameIdentifier x : personNameIdentifiers)
			{
				if (personNameIDTypes == null || personNameIDTypes.contains(x.getPersonNameIDTypeValue()))
					matches.add(x.asJonixPersonNameIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixPersonDate findPersonDate(PersonDateRoles personDateRole)
	{
		if (personDates != null)
		{
			for (PersonDate x : personDates)
			{
				if (x.getPersonDateRoleValue() == personDateRole)
					return x.asJonixPersonDate();
			}
		}
		return null;
	}

	public List<JonixPersonDate> findPersonDates(java.util.Set<PersonDateRoles> personDateRoles)
	{
		if (personDates != null)
		{
			List<JonixPersonDate> matches = new ArrayList<>();
			for (PersonDate x : personDates)
			{
				if (personDateRoles == null || personDateRoles.contains(x.getPersonDateRoleValue()))
					matches.add(x.asJonixPersonDate());
			}
			return matches;
		}
		return null;
	}
}
