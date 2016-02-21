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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixCopyrightOwnerIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Copyright owner identifier composite</h1>
 * <p>
 * A group of data elements which together represent a coded identification of a copyright owner. Optional, and
 * non-repeating. May be sent either instead of or as well as a name.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CopyrightOwnerIdentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;copyrightowneridentifier&gt;</td>
 * </tr>
 * </table>
 */
public class CopyrightOwnerIdentifier implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CopyrightOwnerIdentifier";
	public static final String shortname = "copyrightowneridentifier";

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
	public CopyrightOwnerIDType copyrightOwnerIDType;

	/**
	 * (this field is optional)
	 */
	public IDTypeName idTypeName;

	/**
	 * (this field is required)
	 */
	public IDValue idValue;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CopyrightOwnerIdentifier()
	{}

	public CopyrightOwnerIdentifier(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CopyrightOwnerIDType.refname) || name.equals(CopyrightOwnerIDType.shortname))
					copyrightOwnerIDType = new CopyrightOwnerIDType(element);
				else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname))
					idTypeName = new IDTypeName(element);
				else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname))
					idValue = new IDValue(element);
			}
		});
	}

	public NameCodeTypes getCopyrightOwnerIDTypeValue()
	{
		return (copyrightOwnerIDType == null) ? null : copyrightOwnerIDType.value;
	}

	/**
	 * Raw Format: Variable-length ASCII text, suggested maximum 50 characters
	 */
	public String getIDTypeNameValue()
	{
		return (idTypeName == null) ? null : idTypeName.value;
	}

	/**
	 * Raw Format: According to the identifier type specified in &lt;AddresseeIDType&gt;
	 */
	public String getIDValueValue()
	{
		return (idValue == null) ? null : idValue.value;
	}

	public JonixCopyrightOwnerIdentifier asJonixCopyrightOwnerIdentifier()
	{
		JonixCopyrightOwnerIdentifier x = new JonixCopyrightOwnerIdentifier();
		x.copyrightOwnerIDType = getCopyrightOwnerIDTypeValue();
		x.idTypeName = getIDTypeNameValue();
		x.idValue = getIDValueValue();
		return x;
	}
}
