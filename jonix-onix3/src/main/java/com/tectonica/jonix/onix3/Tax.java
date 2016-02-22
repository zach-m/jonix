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
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TaxTypes;
import com.tectonica.jonix.struct.JonixTax;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Tax composite</h1>
 * <p>
 * A repeatable group of data elements which together specify tax applicable to a price. Optional. For items to which
 * two different taxes or tax rates apply (<i>eg</i> mixed media products in the UK which are partly taxed at standard
 * rate and partly at zero rate), the composite is repeated for each separate tax or tax rate. For UK VAT, it is
 * recommended that all elements in the composite should be explicitly populated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Tax&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;tax&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Tax implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Tax";
	public static final String shortname = "tax";

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
	public TaxType taxType;

	/**
	 * (this field is optional)
	 */
	public TaxRateCode taxRateCode;

	/**
	 * (this field is required)
	 */
	public TaxRatePercent taxRatePercent;

	/**
	 * (this field is optional)
	 */
	public TaxableAmount taxableAmount;

	/**
	 * (this field is optional)
	 */
	public TaxAmount taxAmount;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Tax()
	{}

	public Tax(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(TaxType.refname) || name.equals(TaxType.shortname))
					taxType = new TaxType(element);
				else if (name.equals(TaxRateCode.refname) || name.equals(TaxRateCode.shortname))
					taxRateCode = new TaxRateCode(element);
				else if (name.equals(TaxRatePercent.refname) || name.equals(TaxRatePercent.shortname))
					taxRatePercent = new TaxRatePercent(element);
				else if (name.equals(TaxableAmount.refname) || name.equals(TaxableAmount.shortname))
					taxableAmount = new TaxableAmount(element);
				else if (name.equals(TaxAmount.refname) || name.equals(TaxAmount.shortname))
					taxAmount = new TaxAmount(element);
			}
		});
	}

	public TaxTypes getTaxTypeValue()
	{
		return (taxType == null) ? null : taxType.value;
	}

	public TaxRateCodeds getTaxRateCodeValue()
	{
		return (taxRateCode == null) ? null : taxRateCode.value;
	}

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point where required
	 */
	public Double getTaxRatePercentValue()
	{
		return (taxRatePercent == null) ? null : taxRatePercent.value;
	}

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 */
	public Double getTaxableAmountValue()
	{
		return (taxableAmount == null) ? null : taxableAmount.value;
	}

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 */
	public Double getTaxAmountValue()
	{
		return (taxAmount == null) ? null : taxAmount.value;
	}

	public JonixTax asJonixTax()
	{
		JonixTax x = new JonixTax();
		x.taxType = getTaxTypeValue();
		x.taxRateCode = getTaxRateCodeValue();
		x.taxRatePercent = getTaxRatePercentValue();
		x.taxableAmount = getTaxableAmountValue();
		x.taxAmount = getTaxAmountValue();
		return x;
	}
}
