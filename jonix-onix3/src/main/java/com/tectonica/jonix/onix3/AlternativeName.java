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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixNameIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Alternative name composite</h1>
 * <p>
 * A repeatable group of data elements which together represent an alternative name of a contributor, and specify its
 * type. The &lt;AlternativeName&gt; composite is optional. It may be used to send a pseudonym as well as a real name,
 * where both names are on the product, <i>eg</i> to handle such cases as ‘Ian Rankin writing as Jack Harvey’; or to
 * send an authority-controlled form of a name; or to identify the real name of the contributor where the book is
 * written under a pseudonym (and the real identity need not be kept private). Note that in all cases, the primary name
 * is that used on the product, and the alternative name merely provides additional information.
 * </p>
 * <p>
 * Each instance of the composite must contain the &lt;NameType&gt; element with <em>either</em>:
 * </p>
 * <ul>
 * <li>one or more of the forms of representation of a person name, with or without an occurrence of the
 * &lt;NameIdentifier&gt; composite; <em>or</em></li>
 * <li>one or both of the forms of representation of a corporate name, with or without an occurrence of the
 * &lt;NameIdentifier&gt; composite; <em>or</em></li>
 * <li>an occurrence of the &lt;NameIdentifier&gt; composite without any accompanying name element(s).</li>
 * </ul>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;AlternativeName&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;alternativename&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class AlternativeName implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "AlternativeName";
	public static final String shortname = "alternativename";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final AlternativeName EMPTY = new AlternativeName();

	public AlternativeName()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public AlternativeName(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(NameType.refname) || name.equals(NameType.shortname))
				nameType = new NameType(e);
			else if (name.equals(NameIdentifier.refname) || name.equals(NameIdentifier.shortname))
				nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
			else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
				personName = new PersonName(e);
			else if (name.equals(PersonNameInverted.refname) || name.equals(PersonNameInverted.shortname))
				personNameInverted = new PersonNameInverted(e);
			else if (name.equals(TitlesBeforeNames.refname) || name.equals(TitlesBeforeNames.shortname))
				titlesBeforeNames = new TitlesBeforeNames(e);
			else if (name.equals(NamesBeforeKey.refname) || name.equals(NamesBeforeKey.shortname))
				namesBeforeKey = new NamesBeforeKey(e);
			else if (name.equals(PrefixToKey.refname) || name.equals(PrefixToKey.shortname))
				prefixToKey = new PrefixToKey(e);
			else if (name.equals(KeyNames.refname) || name.equals(KeyNames.shortname))
				keyNames = new KeyNames(e);
			else if (name.equals(NamesAfterKey.refname) || name.equals(NamesAfterKey.shortname))
				namesAfterKey = new NamesAfterKey(e);
			else if (name.equals(SuffixToKey.refname) || name.equals(SuffixToKey.shortname))
				suffixToKey = new SuffixToKey(e);
			else if (name.equals(LettersAfterNames.refname) || name.equals(LettersAfterNames.shortname))
				lettersAfterNames = new LettersAfterNames(e);
			else if (name.equals(TitlesAfterNames.refname) || name.equals(TitlesAfterNames.shortname))
				titlesAfterNames = new TitlesAfterNames(e);
			else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
				corporateName = new CorporateName(e);
			else if (name.equals(CorporateNameInverted.refname) || name.equals(CorporateNameInverted.shortname))
				corporateNameInverted = new CorporateNameInverted(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private NameType nameType = NameType.EMPTY;

	/**
	 * (this field is required)
	 */
	public NameType nameType()
	{
		initialize();
		return nameType;
	}

	private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list is required to contain at least one item)
	 */
	public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers()
	{
		initialize();
		return nameIdentifiers;
	}

	private PersonName personName = PersonName.EMPTY;

	/**
	 * (this field is required)
	 */
	public PersonName personName()
	{
		initialize();
		return personName;
	}

	private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PersonNameInverted personNameInverted()
	{
		initialize();
		return personNameInverted;
	}

	private TitlesBeforeNames titlesBeforeNames = TitlesBeforeNames.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TitlesBeforeNames titlesBeforeNames()
	{
		initialize();
		return titlesBeforeNames;
	}

	private NamesBeforeKey namesBeforeKey = NamesBeforeKey.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NamesBeforeKey namesBeforeKey()
	{
		initialize();
		return namesBeforeKey;
	}

	private PrefixToKey prefixToKey = PrefixToKey.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PrefixToKey prefixToKey()
	{
		initialize();
		return prefixToKey;
	}

	private KeyNames keyNames = KeyNames.EMPTY;

	/**
	 * (this field is required)
	 */
	public KeyNames keyNames()
	{
		initialize();
		return keyNames;
	}

	private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NamesAfterKey namesAfterKey()
	{
		initialize();
		return namesAfterKey;
	}

	private SuffixToKey suffixToKey = SuffixToKey.EMPTY;

	/**
	 * (this field is optional)
	 */
	public SuffixToKey suffixToKey()
	{
		initialize();
		return suffixToKey;
	}

	private LettersAfterNames lettersAfterNames = LettersAfterNames.EMPTY;

	/**
	 * (this field is optional)
	 */
	public LettersAfterNames lettersAfterNames()
	{
		initialize();
		return lettersAfterNames;
	}

	private TitlesAfterNames titlesAfterNames = TitlesAfterNames.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TitlesAfterNames titlesAfterNames()
	{
		initialize();
		return titlesAfterNames;
	}

	private CorporateName corporateName = CorporateName.EMPTY;

	/**
	 * (this field is required)
	 */
	public CorporateName corporateName()
	{
		initialize();
		return corporateName;
	}

	private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CorporateNameInverted corporateNameInverted()
	{
		initialize();
		return corporateNameInverted;
	}
}
