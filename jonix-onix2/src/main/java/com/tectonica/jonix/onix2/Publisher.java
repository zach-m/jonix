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
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Publisher composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an entity which is associated with the publishing of a
 * related product. The composite will allow additional publishing roles to be introduced without adding new fields.
 * Each occurrence of the composite must carry a publishing role code and either a name code or a name or both.
 * <strong>Please see Group&nbsp;PR.19 for details.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Publisher&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;publisher&gt;</td>
 * </tr>
 * </table>
 */
public class Publisher implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Publisher";
	public static final String shortname = "publisher";

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
	public PublishingRole publishingRole;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName;

	/**
	 * (this field is required)
	 */
	public NameCodeType nameCodeType;

	/**
	 * (this field is optional)
	 */
	public NameCodeTypeName nameCodeTypeName;

	/**
	 * (this field is required)
	 */
	public NameCodeValue nameCodeValue;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Publisher()
	{}

	public Publisher(org.w3c.dom.Element element)
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
				if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname))
					publishingRole = new PublishingRole(element);
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
				else if (name.equals(NameCodeType.refname) || name.equals(NameCodeType.shortname))
					nameCodeType = new NameCodeType(element);
				else if (name.equals(NameCodeTypeName.refname) || name.equals(NameCodeTypeName.shortname))
					nameCodeTypeName = new NameCodeTypeName(element);
				else if (name.equals(NameCodeValue.refname) || name.equals(NameCodeValue.shortname))
					nameCodeValue = new NameCodeValue(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
			}
		});
	}

	public PublishingRoles getPublishingRoleValue()
	{
		return (publishingRole == null) ? null : publishingRole.value;
	}

	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}

	public NameCodeTypes getNameCodeTypeValue()
	{
		return (nameCodeType == null) ? null : nameCodeType.value;
	}

	public String getNameCodeTypeNameValue()
	{
		return (nameCodeTypeName == null) ? null : nameCodeTypeName.value;
	}

	public String getNameCodeValueValue()
	{
		return (nameCodeValue == null) ? null : nameCodeValue.value;
	}
}
