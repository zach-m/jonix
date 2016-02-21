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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixRecordSourceIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Record source identifier composite</h1>
 * <p>
 * A repeatable group of data elements which together define an identifier of the organization which is the source of
 * the ONIX record. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RecordSourceIdentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;recordsourceidentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class RecordSourceIdentifier implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RecordSourceIdentifier";
	public static final String shortname = "recordsourceidentifier";

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
	 * (this field is required)
	 */
	public RecordSourceIDType recordSourceIDType;

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

	public RecordSourceIdentifier()
	{}

	public RecordSourceIdentifier(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RecordSourceIDType.refname) || name.equals(RecordSourceIDType.shortname))
					recordSourceIDType = new RecordSourceIDType(element);
				else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname))
					idTypeName = new IDTypeName(element);
				else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname))
					idValue = new IDValue(element);
			}
		});
	}

	public NameCodeTypes getRecordSourceIDTypeValue()
	{
		return (recordSourceIDType == null) ? null : recordSourceIDType.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getIDTypeNameValue()
	{
		return (idTypeName == null) ? null : idTypeName.value;
	}

	/**
	 * Raw Format: According to the identifier type specified in &lt;PriceIDType&gt;
	 */
	public String getIDValueValue()
	{
		return (idValue == null) ? null : idValue.value;
	}

	public JonixRecordSourceIdentifier asJonixRecordSourceIdentifier()
	{
		JonixRecordSourceIdentifier x = new JonixRecordSourceIdentifier();
		x.recordSourceIDType = getRecordSourceIDTypeValue();
		x.idTypeName = getIDTypeNameValue();
		x.idValue = getIDValueValue();
		return x;
	}
}
