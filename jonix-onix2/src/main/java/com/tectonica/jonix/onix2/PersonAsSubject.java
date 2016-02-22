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
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPersonNameIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Person as subject composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a person as a subject of a content item. <strong>Please
 * see Group&nbsp;PR.13 for details.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PersonAsSubject&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;personassubject&gt;</td>
 * </tr>
 * </table>
 */
public class PersonAsSubject implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PersonAsSubject";
	public static final String shortname = "personassubject";

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

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PersonAsSubject()
	{}

	public PersonAsSubject(org.w3c.dom.Element element)
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
				if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
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
			}
		});
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
}
