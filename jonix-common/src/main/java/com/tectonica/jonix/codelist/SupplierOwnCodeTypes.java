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

package com.tectonica.jonix.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 165</b>
 * <p>
 * Description: Supplier own code type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum SupplierOwnCodeTypes
{
	/**
	 * A rating applied by a supplier (typically a wholesaler) to indicate its assessment of the expected or actual
	 * sales performance of a product
	 */
	Supplier_s_sales_classification("01", "Supplier’s sales classification"), //

	/**
	 * A supplier&#8217;s coding of the eligibility of a product for a bonus scheme on overall sales
	 */
	Supplier_s_bonus_eligibility("02", "Supplier’s bonus eligibility"), //

	/**
	 * A rating applied by the publisher to indicate a sales category (eg backlist/frontlist, core stock etc). Use only
	 * when the publisher is not the &#8216;supplier&#8217;
	 */
	Publisher_s_sales_classification("03", "Publisher’s sales classification"), //

	/**
	 * A classification applied by a supplier to a product sold on Agency terms, to indicate that retail price
	 * restrictions are applicable
	 */
	Supplier_s_pricing_restriction_classification("04", "Supplier’s pricing restriction classification"), //

	/**
	 * Code is the ISBN of another book that had sales (both in terms of copy numbers and customer profile) comparable
	 * to that the distributor or supplier estimates for the product. &lt;SupplierCodeValue&gt; must be an ISBN-13 or
	 * GTIN-13 &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Supplier_s_sales_expectation("05", "Supplier’s sales expectation"), //

	/**
	 * Code is the ISBN of another book that had sales (both in terms of copy numbers and customer profile) comparable
	 * to that the publisher estimates for the product. &lt;SupplierCodeValue&gt; must be an ISBN-13 or GTIN-13
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Publisher_s_sales_expectation("06", "Publisher’s sales expectation");

	public final String value;
	public final String label;

	private SupplierOwnCodeTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static SupplierOwnCodeTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (SupplierOwnCodeTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
