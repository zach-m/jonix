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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Contributor
{
	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public SequenceNumber sequenceNumber; // Optional
	public List<ContributorRole> contributorRoles; // OneOrMore
	public List<FromLanguage> fromLanguages; // ZeroOrMore
	public List<ToLanguage> toLanguages; // ZeroOrMore
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
	public List<AlternativeName> alternativeNames; // ZeroOrMore
	public List<ContributorDate> contributorDates; // ZeroOrMore
	public List<ProfessionalAffiliation> professionalAffiliations; // ZeroOrMore
	public List<BiographicalNote> biographicalNotes; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore
	public List<ContributorDescription> contributorDescriptions; // ZeroOrMore
	public UnnamedPersons unnamedPersons; // Required
	public List<ContributorPlace> contributorPlaces; // ZeroOrMore

	public static Contributor fromDoc(org.w3c.dom.Element element)
	{
		final Contributor x = new Contributor();

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
				else if (name.equals(FromLanguage.refname) || name.equals(FromLanguage.shortname))
					x.fromLanguages = DU.addToList(x.fromLanguages, FromLanguage.fromDoc(element));
				else if (name.equals(ToLanguage.refname) || name.equals(ToLanguage.shortname))
					x.toLanguages = DU.addToList(x.toLanguages, ToLanguage.fromDoc(element));
				else if (name.equals(NameType.refname) || name.equals(NameType.shortname))
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
				else if (name.equals(AlternativeName.refname) || name.equals(AlternativeName.shortname))
					x.alternativeNames = DU.addToList(x.alternativeNames, AlternativeName.fromDoc(element));
				else if (name.equals(ContributorDate.refname) || name.equals(ContributorDate.shortname))
					x.contributorDates = DU.addToList(x.contributorDates, ContributorDate.fromDoc(element));
				else if (name.equals(ProfessionalAffiliation.refname) || name.equals(ProfessionalAffiliation.shortname))
					x.professionalAffiliations = DU.addToList(x.professionalAffiliations, ProfessionalAffiliation.fromDoc(element));
				else if (name.equals(BiographicalNote.refname) || name.equals(BiographicalNote.shortname))
					x.biographicalNotes = DU.addToList(x.biographicalNotes, BiographicalNote.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(ContributorDescription.refname) || name.equals(ContributorDescription.shortname))
					x.contributorDescriptions = DU.addToList(x.contributorDescriptions, ContributorDescription.fromDoc(element));
				else if (name.equals(UnnamedPersons.refname) || name.equals(UnnamedPersons.shortname))
					x.unnamedPersons = UnnamedPersons.fromDoc(element);
				else if (name.equals(ContributorPlace.refname) || name.equals(ContributorPlace.shortname))
					x.contributorPlaces = DU.addToList(x.contributorPlaces, ContributorPlace.fromDoc(element));
			}
		});

		return x;
	}
}
