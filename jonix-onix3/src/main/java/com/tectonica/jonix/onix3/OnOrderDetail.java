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
import com.tectonica.jonix.codelist.Proximitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixOnOrderDetail;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>On order detail composite</h1>
 * <p>
 * A repeatable group of data elements which together specify details of a stock shipment currently awaited, normally
 * from overseas. Optional and repeatable if more than a single shipment is outstanding.
 * </p>
 * <p>
 * Note that quantities in the &lt;OnOrderDetail&gt; composite must be included in any total quantity on order given in
 * P.26.37 &lt;OnOrder&gt;, and detail need not be given for all outstanding shipments (<i>ie</i> the P.26.37
 * &lt;OnOrder&gt; must be greater than or equal to the total of the &lt;OnOrder&gt; elements in repeats of the
 * composite).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;OnOrderDetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;onorderdetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class OnOrderDetail implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "OnOrderDetail";
	public static final String shortname = "onorderdetail";

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
	public OnOrder onOrder;

	/**
	 * (this field is optional)
	 */
	public Proximity proximity;

	/**
	 * (this field is required)
	 */
	public ExpectedDate expectedDate;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public OnOrderDetail()
	{}

	public OnOrderDetail(org.w3c.dom.Element element)
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
				if (name.equals(OnOrder.refname) || name.equals(OnOrder.shortname))
					onOrder = new OnOrder(element);
				else if (name.equals(Proximity.refname) || name.equals(Proximity.shortname))
					proximity = new Proximity(element);
				else if (name.equals(ExpectedDate.refname) || name.equals(ExpectedDate.shortname))
					expectedDate = new ExpectedDate(element);
			}
		});
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public Integer getOnOrderValue()
	{
		return (onOrder == null) ? null : onOrder.value;
	}

	public Proximitys getProximityValue()
	{
		return (proximity == null) ? null : proximity.value;
	}

	/**
	 * Format: As specified by the value in the dateformat attribute, or the default of YYYYMMDD if the attribute is
	 * missing
	 */
	public String getExpectedDateValue()
	{
		return (expectedDate == null) ? null : expectedDate.value;
	}

	public JonixOnOrderDetail asJonixOnOrderDetail()
	{
		JonixOnOrderDetail x = new JonixOnOrderDetail();
		x.expectedDate = getExpectedDateValue();
		x.onOrder = getOnOrderValue();
		return x;
	}
}
