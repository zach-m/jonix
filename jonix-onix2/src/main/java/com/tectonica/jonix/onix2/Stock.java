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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Stock quantity composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a quantity of stock and, where a supplier has more than
 * one warehouse, a supplier location. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Stock&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;stock&gt;</td>
 * </tr>
 * </table>
 */
public class Stock implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Stock";
	public static final String shortname = "stock";

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
	public LocationIdentifier locationIdentifier;

	/**
	 * (this field is optional)
	 */
	public LocationName locationName;

	/**
	 * (this field is required)
	 */
	public StockQuantityCoded stockQuantityCoded;

	/**
	 * (this field is optional)
	 */
	public OnHand onHand;

	/**
	 * (this field is optional)
	 */
	public OnOrder onOrder;

	/**
	 * (this field is optional)
	 */
	public CBO cbo;

	/**
	 * (this list may be empty)
	 */
	public List<OnOrderDetail> onOrderDetails;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Stock()
	{}

	public Stock(org.w3c.dom.Element element)
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
				if (name.equals(LocationIdentifier.refname) || name.equals(LocationIdentifier.shortname))
					locationIdentifier = new LocationIdentifier(element);
				else if (name.equals(LocationName.refname) || name.equals(LocationName.shortname))
					locationName = new LocationName(element);
				else if (name.equals(StockQuantityCoded.refname) || name.equals(StockQuantityCoded.shortname))
					stockQuantityCoded = new StockQuantityCoded(element);
				else if (name.equals(OnHand.refname) || name.equals(OnHand.shortname))
					onHand = new OnHand(element);
				else if (name.equals(OnOrder.refname) || name.equals(OnOrder.shortname))
					onOrder = new OnOrder(element);
				else if (name.equals(CBO.refname) || name.equals(CBO.shortname))
					cbo = new CBO(element);
				else if (name.equals(OnOrderDetail.refname) || name.equals(OnOrderDetail.shortname))
					onOrderDetails = JPU.addToList(onOrderDetails, new OnOrderDetail(element));
			}
		});
	}

	/**
	 * Raw Format: Free text, suggested maximum length 100 characters
	 */
	public String getLocationNameValue()
	{
		return (locationName == null) ? null : locationName.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public String getOnHandValue()
	{
		return (onHand == null) ? null : onHand.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public String getOnOrderValue()
	{
		return (onOrder == null) ? null : onOrder.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public String getCBOValue()
	{
		return (cbo == null) ? null : cbo.value;
	}
}
