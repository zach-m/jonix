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
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.codelist.PersonOrganizationNameTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.UnnamedPersonss;
import com.tectonica.jonix.struct.JonixContributorDate;
import com.tectonica.jonix.struct.JonixNameIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Contributor composite</h1>
 * <p>
 * A group of data elements which together describe a personal or corporate contributor to a content item. Optional and
 * repeatable.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
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

	/**
	 * (type: dt.DateOrDateTime)
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
	public List<FromLanguage> fromLanguages;

	/**
	 * (this list may be empty)
	 */
	public List<ToLanguage> toLanguages;

	/**
	 * (this field is optional)
	 */
	public NameType nameType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<NameIdentifier> nameIdentifiers;

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
	 * (this field is required)
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
	 * (this field is required)
	 */
	public CorporateName corporateName;

	/**
	 * (this field is optional)
	 */
	public CorporateNameInverted corporateNameInverted;

	/**
	 * (this list may be empty)
	 */
	public List<AlternativeName> alternativeNames;

	/**
	 * (this list may be empty)
	 */
	public List<ContributorDate> contributorDates;

	/**
	 * (this list may be empty)
	 */
	public List<ProfessionalAffiliation> professionalAffiliations;

	/**
	 * (this list may be empty)
	 */
	public List<BiographicalNote> biographicalNotes;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this list may be empty)
	 */
	public List<ContributorDescription> contributorDescriptions;

	/**
	 * (this field is required)
	 */
	public UnnamedPersons unnamedPersons;

	/**
	 * (this list may be empty)
	 */
	public List<ContributorPlace> contributorPlaces;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Contributor()
	{}

	public Contributor(org.w3c.dom.Element element)
	{
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
				else if (name.equals(FromLanguage.refname) || name.equals(FromLanguage.shortname))
					fromLanguages = JPU.addToList(fromLanguages, new FromLanguage(element));
				else if (name.equals(ToLanguage.refname) || name.equals(ToLanguage.shortname))
					toLanguages = JPU.addToList(toLanguages, new ToLanguage(element));
				else if (name.equals(NameType.refname) || name.equals(NameType.shortname))
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
				else if (name.equals(AlternativeName.refname) || name.equals(AlternativeName.shortname))
					alternativeNames = JPU.addToList(alternativeNames, new AlternativeName(element));
				else if (name.equals(ContributorDate.refname) || name.equals(ContributorDate.shortname))
					contributorDates = JPU.addToList(contributorDates, new ContributorDate(element));
				else if (name.equals(ProfessionalAffiliation.refname) || name.equals(ProfessionalAffiliation.shortname))
					professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(
							element));
				else if (name.equals(BiographicalNote.refname) || name.equals(BiographicalNote.shortname))
					biographicalNotes = JPU.addToList(biographicalNotes, new BiographicalNote(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(ContributorDescription.refname) || name.equals(ContributorDescription.shortname))
					contributorDescriptions = JPU.addToList(contributorDescriptions,
							new ContributorDescription(element));
				else if (name.equals(UnnamedPersons.refname) || name.equals(UnnamedPersons.shortname))
					unnamedPersons = new UnnamedPersons(element);
				else if (name.equals(ContributorPlace.refname) || name.equals(ContributorPlace.shortname))
					contributorPlaces = JPU.addToList(contributorPlaces, new ContributorPlace(element));
			}
		});
	}

	/**
	 * Raw Format: Variable-length integer, 1, 2, 3 etc, suggested maximum length 3 digits
	 */
	public Integer getSequenceNumberValue()
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

	public List<LanguageCodes> getFromLanguageValues()
	{
		if (fromLanguages != null)
		{
			List<LanguageCodes> list = new ArrayList<>();
			for (FromLanguage i : fromLanguages)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<LanguageCodes> getToLanguageValues()
	{
		if (toLanguages != null)
		{
			List<LanguageCodes> list = new ArrayList<>();
			for (ToLanguage i : toLanguages)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public PersonOrganizationNameTypes getNameTypeValue()
	{
		return (nameType == null) ? null : nameType.value;
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
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getCorporateNameInvertedValue()
	{
		return (corporateNameInverted == null) ? null : corporateNameInverted.value;
	}

	/**
	 * Raw Format: Variable-length text, no suggested maximum length (since there is no suggested length for the text in
	 * a &lt;TextContent&gt; composite, where a biographical note can alternatively be sent). XHTML is enabled in this
	 * element - see Using XHTML, HTML or XML with ONIX text fields
	 */
	public List<String> getBiographicalNoteValues()
	{
		if (biographicalNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (BiographicalNote i : biographicalNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters. XHTML is enabled in this element - see
	 * Using XHTML, HTML or XML with ONIX text fields
	 */
	public List<String> getContributorDescriptionValues()
	{
		if (contributorDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (ContributorDescription i : contributorDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public UnnamedPersonss getUnnamedPersonsValue()
	{
		return (unnamedPersons == null) ? null : unnamedPersons.value;
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

	public JonixContributorDate findContributorDate(PersonOrganizationDateRoles contributorDateRole)
	{
		if (contributorDates != null)
		{
			for (ContributorDate x : contributorDates)
			{
				if (x.getContributorDateRoleValue() == contributorDateRole)
					return x.asJonixContributorDate();
			}
		}
		return null;
	}

	public List<JonixContributorDate> findContributorDates(
			java.util.Set<PersonOrganizationDateRoles> contributorDateRoles)
	{
		if (contributorDates != null)
		{
			List<JonixContributorDate> matches = new ArrayList<>();
			for (ContributorDate x : contributorDates)
			{
				if (contributorDateRoles == null || contributorDateRoles.contains(x.getContributorDateRoleValue()))
					matches.add(x.asJonixContributorDate());
			}
			return matches;
		}
		return null;
	}
}
