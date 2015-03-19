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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Product relation code
 */
public enum ProductRelations
{
	/**
	 * <Product> is related to <RelatedProduct> in a way that cannot be specified by another code value.
	 */
	Unspecified("00"), //

	/**
	 * <Product> includes <RelatedProduct>.
	 */
	Includes("01"), //

	/**
	 * <Product> is part of <RelatedProduct>: use for ‘also available as part of’.
	 */
	Is_part_of("02"), //

	/**
	 * <Product> replaces, or is new edition of, <RelatedProduct>.
	 */
	Replaces("03"), //

	/**
	 * <Product> is replaced by, or has new edition, <RelatedProduct> (reciprocal of code 03).
	 */
	Replaced_by("05"), //

	/**
	 * <Product> is available in an alternative format as <RelatedProduct> – indicates an alternative format of the same content which is or
	 * may be available.
	 */
	Alternative_format("06"), //

	/**
	 * <Product> has an ancillary or supplementary product <RelatedProduct>.
	 */
	Has_ancillary_product("07"), //

	/**
	 * <Product> is ancillary or supplementary to <RelatedProduct>.
	 */
	Is_ancillary_to("08"), //

	/**
	 * <Product> is remaindered as <RelatedProduct>, when a remainder merchant assigns its own identifier to the product.
	 */
	Is_remaindered_as("09"), //

	/**
	 * <Product> was originally sold as <RelatedProduct>, indicating the publisher’s original identifier for a title which is offered as a
	 * remainder under a different identifier (reciprocal of code 09).
	 */
	Is_remainder_of("10"), //

	/**
	 * <Product> is an other-language version of <RelatedProduct>.
	 */
	Is_other_language_version_of("11"), //

	/**
	 * <Product> has a publisher’s suggested alternative <RelatedProduct>, which does not, however, carry the same content (cf 05 and 06).
	 */
	Publisher_s_suggested_alternative("12"), //

	/**
	 * <Product> is an epublication based on printed product <RelatedProduct>.
	 */
	Epublication_based_on_print_product("13"), //

	/**
	 * <Product> is an epublication ‘rendered’ as <RelatedProduct>: use in ONIX 2.1 only when the <Product> record describes a package of
	 * electronic content which is available in multiple ‘renderings’ (coded 000 in <EpubTypeCode>): NOT USED in ONIX 3.0.
	 */
	Epublication_is_distributed_as("14"), //

	/**
	 * <Product> is a ‘rendering’ of an epublication <RelatedProduct>: use in ONIX 2.1 only when the <Product> record describes a specific
	 * rendering of an epublication content package, to identify the package: NOT USED in ONIX 3.0.
	 */
	Epublication_is_a_rendering_of("15"), //

	/**
	 * <Product> is a POD replacement for <RelatedProduct>. <RelatedProduct> is an out-of-print product replaced by a print-on-demand
	 * version under a new ISBN.
	 */
	POD_replacement_for("16"), //

	/**
	 * <Product> is replaced by POD <RelatedProduct>. <RelatedProduct> is a print-on-demand replacement, under a new ISBN, for an
	 * out-of-print <Product> (reciprocal of code 16).
	 */
	Replaced_by_POD("17"), //

	/**
	 * <Product> is a special edition of <RelatedProduct>. Used for a special edition (German: Sonderausgabe) with different cover, binding
	 * etc – more than ‘alternative format’ – which may be available in limited quantity and for a limited time.
	 */
	Is_special_edition_of("18"), //

	/**
	 * <Product> has a special edition <RelatedProduct> (reciprocal of code 18).
	 */
	Has_special_edition("19"), //

	/**
	 * <Product> is a prebound edition of <RelatedProduct> (in the US, a prebound edition is ‘a book that was previously bound and has been
	 * rebound with a library quality hardcover binding. In almost all commercial cases, the book in question began as a paperback.’).
	 */
	Is_prebound_edition_of("20"), //

	/**
	 * <Product> is the regular edition of which <RelatedProduct> is a prebound edition.
	 */
	Is_original_of_prebound_edition("21"), //

	/**
	 * <Product> and <RelatedProduct> have a common author.
	 */
	Product_by_same_author("22"), //

	/**
	 * <RelatedProduct> is another product that is suggested as similar to <Product> (‘if you liked <Product>, you may also like
	 * <RelatedProduct>’).
	 */
	Similar_product("23"), //

	/**
	 * <Product> is a facsimile edition of <RelatedProduct>.
	 */
	Is_facsimile_of("24"), //

	/**
	 * <Product> is the original edition from which a facsimile edition <RelatedProduct> is taken (reciprocal of code 25).
	 */
	Is_original_of_facsimile("25"), //

	/**
	 * <Product> is a license for a digital <RelatedProduct>, traded or supplied separately.
	 */
	Is_license_for("26"), //

	/**
	 * <RelatedProduct> is an electronic version of print <Product> (reciprocal of code 13).
	 */
	Electronic_version_available_as("27"), //

	/**
	 * <RelatedProduct> is an ‘enhanced’ version of <Product>, with additional content. Typically used to link an enhanced e-book to its
	 * original ‘unenhanced’ equivalent, but not specifically limited to linking e-books – for example, may be used to link illustrated and
	 * non-illustrated print books. <Product> and <RelatedProduct> should share the same <ProductForm>.
	 */
	Enhanced_version_available_as("28"), //

	/**
	 * <RelatedProduct> is a basic version of <Product> (reciprocal of code 28). <Product> and <RelatedProduct> should share the same
	 * <ProductForm>.
	 */
	Basic_version_available_as("29"), //

	/**
	 * <RelatedProduct> and <Product> are part of the same collection (eg two products in same series or set).
	 */
	Product_in_same_collection("30"), //

	/**
	 * <RelatedProduct> is an alternative product in another sector (of the same geographical market). Indicates an alternative that carries
	 * the same content, but available to a different set of customers, as one or both products are retailer-, channel- or market
	 * sector-specific.
	 */
	Has_alternative_in_a_different_market_sector("31"), //

	/**
	 * <RelatedProduct> is an equivalent product, often intended for another (geographical) market. Indicates an alternative that carries
	 * essentially the same content, though slightly adapted for local circumstances (as opposed to a translation – use code 11).
	 */
	Has_equivalent_intended_for_a_different_market("32"), //

	/**
	 * <RelatedProduct> is an alternative product, often intended for another (geographical) market. Indicates the content of the
	 * alternative is identical in all respects.
	 */
	Has_alternative_intended_for_different_market("33"), //

	/**
	 * <Product> cites <RelatedProduct>.
	 */
	Cites("34"), //

	/**
	 * <Product> is the object of a citation in <RelatedProduct>.
	 */
	Is_cited_by("35");

	public final String value;

	private ProductRelations(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductRelations> map;

	private static Map<String, ProductRelations> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductRelations e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductRelations byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
