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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPageRun;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Page run composite</h1>
 * <p>
 * A repeatable group of data elements which together define a run of contiguous pages on which a text item appears. The
 * composite is optional, but may be repeated where the text item covers two or more separate page runs.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PageRun&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;pagerun&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class PageRun implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PageRun";
	public static final String shortname = "pagerun";

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
	public FirstPageNumber firstPageNumber;

	/**
	 * (this field is optional)
	 */
	public LastPageNumber lastPageNumber;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PageRun()
	{}

	public PageRun(org.w3c.dom.Element element)
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
				if (name.equals(FirstPageNumber.refname) || name.equals(FirstPageNumber.shortname))
					firstPageNumber = new FirstPageNumber(element);
				else if (name.equals(LastPageNumber.refname) || name.equals(LastPageNumber.shortname))
					lastPageNumber = new LastPageNumber(element);
			}
		});
	}

	/**
	 * Format: Variable-length alphanumeric, suggested maximum length 20 characters
	 */
	public String getFirstPageNumberValue()
	{
		return (firstPageNumber == null) ? null : firstPageNumber.value;
	}

	/**
	 * Format: Variable-length alphanumeric, suggested maximum length 20 characters
	 */
	public String getLastPageNumberValue()
	{
		return (lastPageNumber == null) ? null : lastPageNumber.value;
	}

	public JonixPageRun asJonixPageRun()
	{
		JonixPageRun x = new JonixPageRun();
		x.firstPageNumber = getFirstPageNumberValue();
		x.lastPageNumber = getLastPageNumberValue();
		return x;
	}
}
