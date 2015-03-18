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

public class Contributor
{
	public static final String refname = "Contributor";
	public static final String shortname = "contributor";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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
				else if (name.equalsIgnoreCase(FromLanguage.refname) || name.equalsIgnoreCase(FromLanguage.shortname))
					x.fromLanguages = DU.addToList(x.fromLanguages, FromLanguage.fromDoc(element));
				else if (name.equalsIgnoreCase(ToLanguage.refname) || name.equalsIgnoreCase(ToLanguage.shortname))
					x.toLanguages = DU.addToList(x.toLanguages, ToLanguage.fromDoc(element));
				else if (name.equalsIgnoreCase(NameType.refname) || name.equalsIgnoreCase(NameType.shortname))
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
				else if (name.equalsIgnoreCase(AlternativeName.refname) || name.equalsIgnoreCase(AlternativeName.shortname))
					x.alternativeNames = DU.addToList(x.alternativeNames, AlternativeName.fromDoc(element));
				else if (name.equalsIgnoreCase(ContributorDate.refname) || name.equalsIgnoreCase(ContributorDate.shortname))
					x.contributorDates = DU.addToList(x.contributorDates, ContributorDate.fromDoc(element));
				else if (name.equalsIgnoreCase(ProfessionalAffiliation.refname) || name.equalsIgnoreCase(ProfessionalAffiliation.shortname))
					x.professionalAffiliations = DU.addToList(x.professionalAffiliations, ProfessionalAffiliation.fromDoc(element));
				else if (name.equalsIgnoreCase(BiographicalNote.refname) || name.equalsIgnoreCase(BiographicalNote.shortname))
					x.biographicalNotes = DU.addToList(x.biographicalNotes, BiographicalNote.fromDoc(element));
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equalsIgnoreCase(ContributorDescription.refname) || name.equalsIgnoreCase(ContributorDescription.shortname))
					x.contributorDescriptions = DU.addToList(x.contributorDescriptions, ContributorDescription.fromDoc(element));
				else if (name.equalsIgnoreCase(UnnamedPersons.refname) || name.equalsIgnoreCase(UnnamedPersons.shortname))
					x.unnamedPersons = UnnamedPersons.fromDoc(element);
				else if (name.equalsIgnoreCase(ContributorPlace.refname) || name.equalsIgnoreCase(ContributorPlace.shortname))
					x.contributorPlaces = DU.addToList(x.contributorPlaces, ContributorPlace.fromDoc(element));
			}
		});

		return x;
	}
}
