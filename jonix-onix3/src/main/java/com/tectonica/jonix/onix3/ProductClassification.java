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
import com.tectonica.jonix.codelist.ProductClassificationTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductClassification;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Product classification composite</h1>
 * <p>
 * A repeatable group of data elements which together define a product classification (<em>not</em> to be confused with
 * a subject classification). The intended use is to enable national or international trade classifications (also known
 * as commodity codes) to be carried in an ONIX record. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductClassification&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;productclassification&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ProductClassification implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductClassification";
	public static final String shortname = "productclassification";

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
	public ProductClassificationType productClassificationType;

	/**
	 * (this field is required)
	 */
	public ProductClassificationCode productClassificationCode;

	/**
	 * (this field is optional)
	 */
	public Percent percent;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ProductClassification()
	{}

	public ProductClassification(org.w3c.dom.Element element)
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
				if (name.equals(ProductClassificationType.refname) || name.equals(ProductClassificationType.shortname))
					productClassificationType = new ProductClassificationType(element);
				else if (name.equals(ProductClassificationCode.refname)
						|| name.equals(ProductClassificationCode.shortname))
					productClassificationCode = new ProductClassificationCode(element);
				else if (name.equals(Percent.refname) || name.equals(Percent.shortname))
					percent = new Percent(element);
			}
		});
	}

	public ProductClassificationTypes getProductClassificationTypeValue()
	{
		return (productClassificationType == null) ? null : productClassificationType.value;
	}

	/**
	 * Raw Format: According to the identifier type specified in &lt;ProductClassificationType&gt;
	 */
	public String getProductClassificationCodeValue()
	{
		return (productClassificationCode == null) ? null : productClassificationCode.value;
	}

	/**
	 * Raw Format: Real decimal number in the range 0 to 100
	 */
	public Double getPercentValue()
	{
		return (percent == null) ? null : percent.value;
	}

	public JonixProductClassification asJonixProductClassification()
	{
		JonixProductClassification x = new JonixProductClassification();
		x.productClassificationType = getProductClassificationTypeValue();
		x.percent = getPercentValue();
		x.productClassificationCode = getProductClassificationCodeValue();
		return x;
	}
}
