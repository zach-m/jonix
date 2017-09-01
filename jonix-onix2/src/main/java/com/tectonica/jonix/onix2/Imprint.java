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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeUncommon;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Imprint or brand composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an imprint or brand under which the product is marketed.
 * The composite must carry either a name code or a name or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Imprint&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;imprint&gt;</td>
 * </tr>
 * </table>
 */
public class Imprint implements OnixDataCompositeUncommon, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Imprint";
	public static final String shortname = "imprint";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

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

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final Imprint EMPTY = new Imprint();

	public Imprint()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public Imprint(org.w3c.dom.Element element)
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

		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
				imprintName = new ImprintName(e);
			else if (name.equals(NameCodeType.refname) || name.equals(NameCodeType.shortname))
				nameCodeType = new NameCodeType(e);
			else if (name.equals(NameCodeTypeName.refname) || name.equals(NameCodeTypeName.shortname))
				nameCodeTypeName = new NameCodeTypeName(e);
			else if (name.equals(NameCodeValue.refname) || name.equals(NameCodeValue.shortname))
				nameCodeValue = new NameCodeValue(e);
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

	private ImprintName imprintName = ImprintName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ImprintName imprintName()
	{
		initialize();
		return imprintName;
	}

	private NameCodeType nameCodeType = NameCodeType.EMPTY;

	/**
	 * (this field is required)
	 */
	public NameCodeType nameCodeType()
	{
		initialize();
		return nameCodeType;
	}

	private NameCodeTypeName nameCodeTypeName = NameCodeTypeName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NameCodeTypeName nameCodeTypeName()
	{
		initialize();
		return nameCodeTypeName;
	}

	private NameCodeValue nameCodeValue = NameCodeValue.EMPTY;

	/**
	 * (this field is required)
	 */
	public NameCodeValue nameCodeValue()
	{
		initialize();
		return nameCodeValue;
	}
}
