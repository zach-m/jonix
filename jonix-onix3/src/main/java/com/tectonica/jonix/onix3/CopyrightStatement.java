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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.RightsTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Copyright statement composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together represent a copyright or neighbouring right
 * statement for the product. Either the copyright year alone, or a structured rights statement listing year(s) and
 * rights holder(s), may be sent as an instance of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CopyrightStatement&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;copyrightstatement&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class CopyrightStatement implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CopyrightStatement";
	public static final String shortname = "copyrightstatement";

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
	 * (this field is optional)
	 */
	public CopyrightType copyrightType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<CopyrightYear> copyrightYears;

	/**
	 * (this list may be empty)
	 */
	public List<CopyrightOwner> copyrightOwners;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CopyrightStatement()
	{}

	public CopyrightStatement(org.w3c.dom.Element element)
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
				if (name.equals(CopyrightType.refname) || name.equals(CopyrightType.shortname))
					copyrightType = new CopyrightType(element);
				else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					copyrightYears = JPU.addToList(copyrightYears, new CopyrightYear(element));
				else if (name.equals(CopyrightOwner.refname) || name.equals(CopyrightOwner.shortname))
					copyrightOwners = JPU.addToList(copyrightOwners, new CopyrightOwner(element));
			}
		});
	}

	public RightsTypes getCopyrightTypeValue()
	{
		return (copyrightType == null) ? null : copyrightType.value;
	}

	/**
	 * Raw Format: As specified by the value in the dateformat attribute, or the default of YYYY if the attribute is
	 * missing)
	 */
	public List<String> getCopyrightYearValues()
	{
		if (copyrightYears != null)
		{
			List<String> list = new ArrayList<>();
			for (CopyrightYear i : copyrightYears)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
