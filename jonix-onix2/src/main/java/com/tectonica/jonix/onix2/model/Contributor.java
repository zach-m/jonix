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

public class Contributor
{
	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
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
				if (name.equalsIgnoreCase(SequenceNumber.refname) || name.equalsIgnoreCase(SequenceNumber.shortname))
					x.sequenceNumber = SequenceNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(ContributorRole.refname) || name.equalsIgnoreCase(ContributorRole.shortname))
					x.contributorRoles = DU.addToList(x.contributorRoles, ContributorRole.fromDoc(element));
				else if (name.equalsIgnoreCase(LanguageCode.refname) || name.equalsIgnoreCase(LanguageCode.shortname))
					x.languageCodes = DU.addToList(x.languageCodes, LanguageCode.fromDoc(element));
				else if (name.equalsIgnoreCase(SequenceNumberWithinRole.refname)
						|| name.equalsIgnoreCase(SequenceNumberWithinRole.shortname))
					x.sequenceNumberWithinRole = SequenceNumberWithinRole.fromDoc(element);
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
				else if (name.equalsIgnoreCase(Name.refname) || name.equalsIgnoreCase(Name.shortname))
					x.names = DU.addToList(x.names, Name.fromDoc(element));
				else if (name.equalsIgnoreCase(PersonNameIdentifier.refname) || name.equalsIgnoreCase(PersonNameIdentifier.shortname))
					x.personNameIdentifiers = DU.addToList(x.personNameIdentifiers, PersonNameIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(PersonDate.refname) || name.equalsIgnoreCase(PersonDate.shortname))
					x.personDates = DU.addToList(x.personDates, PersonDate.fromDoc(element));
				else if (name.equalsIgnoreCase(ProfessionalAffiliation.refname) || name.equalsIgnoreCase(ProfessionalAffiliation.shortname))
					x.professionalAffiliations = DU.addToList(x.professionalAffiliations, ProfessionalAffiliation.fromDoc(element));
				else if (name.equalsIgnoreCase(CorporateName.refname) || name.equalsIgnoreCase(CorporateName.shortname))
					x.corporateName = CorporateName.fromDoc(element);
				else if (name.equalsIgnoreCase(BiographicalNote.refname) || name.equalsIgnoreCase(BiographicalNote.shortname))
					x.biographicalNote = BiographicalNote.fromDoc(element);
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equalsIgnoreCase(ProfessionalPosition.refname) || name.equalsIgnoreCase(ProfessionalPosition.shortname))
					x.professionalPosition = ProfessionalPosition.fromDoc(element);
				else if (name.equalsIgnoreCase(Affiliation.refname) || name.equalsIgnoreCase(Affiliation.shortname))
					x.affiliation = Affiliation.fromDoc(element);
				else if (name.equalsIgnoreCase(ContributorDescription.refname) || name.equalsIgnoreCase(ContributorDescription.shortname))
					x.contributorDescription = ContributorDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(UnnamedPersons.refname) || name.equalsIgnoreCase(UnnamedPersons.shortname))
					x.unnamedPersons = UnnamedPersons.fromDoc(element);
				else if (name.equalsIgnoreCase(CountryCode.refname) || name.equalsIgnoreCase(CountryCode.shortname))
					x.countryCodes = DU.addToList(x.countryCodes, CountryCode.fromDoc(element));
				else if (name.equalsIgnoreCase(RegionCode.refname) || name.equalsIgnoreCase(RegionCode.shortname))
					x.regionCodes = DU.addToList(x.regionCodes, RegionCode.fromDoc(element));
			}
		});

		return x;
	}
}
