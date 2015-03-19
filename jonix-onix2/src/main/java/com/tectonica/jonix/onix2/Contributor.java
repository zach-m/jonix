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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;
import com.tectonica.jonix.codelist.UnnamedPersonss;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Contributor
{
	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
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

	public static Contributor fromDoc(org.w3c.dom.Element element)
	{
		final Contributor x = new Contributor();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SequenceNumber.refname) || name.equals(SequenceNumber.shortname))
					x.sequenceNumber = SequenceNumber.fromDoc(element);
				else if (name.equals(ContributorRole.refname) || name.equals(ContributorRole.shortname))
					x.contributorRoles = DU.addToList(x.contributorRoles, ContributorRole.fromDoc(element));
				else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
					x.languageCodes = DU.addToList(x.languageCodes, LanguageCode.fromDoc(element));
				else if (name.equals(SequenceNumberWithinRole.refname) || name.equals(SequenceNumberWithinRole.shortname))
					x.sequenceNumberWithinRole = SequenceNumberWithinRole.fromDoc(element);
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
				else if (name.equals(Name.refname) || name.equals(Name.shortname))
					x.names = DU.addToList(x.names, Name.fromDoc(element));
				else if (name.equals(PersonNameIdentifier.refname) || name.equals(PersonNameIdentifier.shortname))
					x.personNameIdentifiers = DU.addToList(x.personNameIdentifiers, PersonNameIdentifier.fromDoc(element));
				else if (name.equals(PersonDate.refname) || name.equals(PersonDate.shortname))
					x.personDates = DU.addToList(x.personDates, PersonDate.fromDoc(element));
				else if (name.equals(ProfessionalAffiliation.refname) || name.equals(ProfessionalAffiliation.shortname))
					x.professionalAffiliations = DU.addToList(x.professionalAffiliations, ProfessionalAffiliation.fromDoc(element));
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					x.corporateName = CorporateName.fromDoc(element);
				else if (name.equals(BiographicalNote.refname) || name.equals(BiographicalNote.shortname))
					x.biographicalNote = BiographicalNote.fromDoc(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(ProfessionalPosition.refname) || name.equals(ProfessionalPosition.shortname))
					x.professionalPosition = ProfessionalPosition.fromDoc(element);
				else if (name.equals(Affiliation.refname) || name.equals(Affiliation.shortname))
					x.affiliation = Affiliation.fromDoc(element);
				else if (name.equals(ContributorDescription.refname) || name.equals(ContributorDescription.shortname))
					x.contributorDescription = ContributorDescription.fromDoc(element);
				else if (name.equals(UnnamedPersons.refname) || name.equals(UnnamedPersons.shortname))
					x.unnamedPersons = UnnamedPersons.fromDoc(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					x.countryCodes = DU.addToList(x.countryCodes, CountryCode.fromDoc(element));
				else if (name.equals(RegionCode.refname) || name.equals(RegionCode.shortname))
					x.regionCodes = DU.addToList(x.regionCodes, RegionCode.fromDoc(element));
			}
		});

		return x;
	}

	public String getSequenceNumberValue()
	{
		return (sequenceNumber == null) ? null : sequenceNumber.value;
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
}
