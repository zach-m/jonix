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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 51</b>
 * <p>
 * Description: Product relation code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductRelations
{
	/**
	 * &lt;Product&gt; is related to &lt;RelatedProduct&gt; in a way that cannot be specified by another code value.
	 */
	Unspecified("00"), //

	/**
	 * &lt;Product&gt; includes &lt;RelatedProduct&gt;.
	 */
	Includes("01"), //

	/**
	 * &lt;Product&gt; is part of &lt;RelatedProduct&gt;: use for &#8216;also available as part of&#8217;.
	 */
	Is_part_of("02"), //

	/**
	 * &lt;Product&gt; replaces, or is new edition of, &lt;RelatedProduct&gt;.
	 */
	Replaces("03"), //

	/**
	 * &lt;Product&gt; is replaced by, or has new edition, &lt;RelatedProduct&gt; (reciprocal of code 03).
	 */
	Replaced_by("05"), //

	/**
	 * &lt;Product&gt; is available in an alternative format as &lt;RelatedProduct&gt; &#8211; indicates an alternative
	 * format of the same content which is or may be available.
	 */
	Alternative_format("06"), //

	/**
	 * &lt;Product&gt; has an ancillary or supplementary product &lt;RelatedProduct&gt;.
	 */
	Has_ancillary_product("07"), //

	/**
	 * &lt;Product&gt; is ancillary or supplementary to &lt;RelatedProduct&gt;.
	 */
	Is_ancillary_to("08"), //

	/**
	 * &lt;Product&gt; is remaindered as &lt;RelatedProduct&gt;, when a remainder merchant assigns its own identifier to
	 * the product.
	 */
	Is_remaindered_as("09"), //

	/**
	 * &lt;Product&gt; was originally sold as &lt;RelatedProduct&gt;, indicating the publisher&#8217;s original
	 * identifier for a title which is offered as a remainder under a different identifier (reciprocal of code 09).
	 */
	Is_remainder_of("10"), //

	/**
	 * &lt;Product&gt; is an other-language version of &lt;RelatedProduct&gt;.
	 */
	Is_other_language_version_of("11"), //

	/**
	 * &lt;Product&gt; has a publisher&#8217;s suggested alternative &lt;RelatedProduct&gt;, which does not, however,
	 * carry the same content (cf 05 and 06).
	 */
	Publisher_s_suggested_alternative("12"), //

	/**
	 * &lt;Product&gt; is an epublication based on printed product &lt;RelatedProduct&gt;.
	 */
	Epublication_based_on_print_product("13"), //

	/**
	 * &lt;Product&gt; is an epublication &#8216;rendered&#8217; as &lt;RelatedProduct&gt;: use in ONIX 2.1 only when
	 * the &lt;Product&gt; record describes a package of electronic content which is available in multiple
	 * &#8216;renderings&#8217; (coded 000 in &lt;EpubTypeCode&gt;): NOT USED in ONIX 3.0.
	 */
	Epublication_is_distributed_as("14"), //

	/**
	 * &lt;Product&gt; is a &#8216;rendering&#8217; of an epublication &lt;RelatedProduct&gt;: use in ONIX 2.1 only when
	 * the &lt;Product&gt; record describes a specific rendering of an epublication content package, to identify the
	 * package: NOT USED in ONIX 3.0.
	 */
	Epublication_is_a_rendering_of("15"), //

	/**
	 * &lt;Product&gt; is a POD replacement for &lt;RelatedProduct&gt;. &lt;RelatedProduct&gt; is an out-of-print
	 * product replaced by a print-on-demand version under a new ISBN.
	 */
	POD_replacement_for("16"), //

	/**
	 * &lt;Product&gt; is replaced by POD &lt;RelatedProduct&gt;. &lt;RelatedProduct&gt; is a print-on-demand
	 * replacement, under a new ISBN, for an out-of-print &lt;Product&gt; (reciprocal of code 16).
	 */
	Replaced_by_POD("17"), //

	/**
	 * &lt;Product&gt; is a special edition of &lt;RelatedProduct&gt;. Used for a special edition (German:
	 * Sonderausgabe) with different cover, binding etc &#8211; more than &#8216;alternative format&#8217; &#8211; which
	 * may be available in limited quantity and for a limited time.
	 */
	Is_special_edition_of("18"), //

	/**
	 * &lt;Product&gt; has a special edition &lt;RelatedProduct&gt; (reciprocal of code 18).
	 */
	Has_special_edition("19"), //

	/**
	 * &lt;Product&gt; is a prebound edition of &lt;RelatedProduct&gt; (in the US, a prebound edition is &#8216;a book
	 * that was previously bound and has been rebound with a library quality hardcover binding. In almost all commercial
	 * cases, the book in question began as a paperback.&#8217;).
	 */
	Is_prebound_edition_of("20"), //

	/**
	 * &lt;Product&gt; is the regular edition of which &lt;RelatedProduct&gt; is a prebound edition.
	 */
	Is_original_of_prebound_edition("21"), //

	/**
	 * &lt;Product&gt; and &lt;RelatedProduct&gt; have a common author.
	 */
	Product_by_same_author("22"), //

	/**
	 * &lt;RelatedProduct&gt; is another product that is suggested as similar to &lt;Product&gt; (&#8216;if you liked
	 * &lt;Product&gt;, you may also like &lt;RelatedProduct&gt;&#8217;).
	 */
	Similar_product("23"), //

	/**
	 * &lt;Product&gt; is a facsimile edition of &lt;RelatedProduct&gt;.
	 */
	Is_facsimile_of("24"), //

	/**
	 * &lt;Product&gt; is the original edition from which a facsimile edition &lt;RelatedProduct&gt; is taken
	 * (reciprocal of code 25).
	 */
	Is_original_of_facsimile("25"), //

	/**
	 * &lt;Product&gt; is a license for a digital &lt;RelatedProduct&gt;, traded or supplied separately.
	 */
	Is_license_for("26"), //

	/**
	 * &lt;RelatedProduct&gt; is an electronic version of print &lt;Product&gt; (reciprocal of code 13).
	 */
	Electronic_version_available_as("27"), //

	/**
	 * &lt;RelatedProduct&gt; is an &#8216;enhanced&#8217; version of &lt;Product&gt;, with additional content.
	 * Typically used to link an enhanced e-book to its original &#8216;unenhanced&#8217; equivalent, but not
	 * specifically limited to linking e-books &#8211; for example, may be used to link illustrated and non-illustrated
	 * print books. &lt;Product&gt; and &lt;RelatedProduct&gt; should share the same &lt;ProductForm&gt;.
	 */
	Enhanced_version_available_as("28"), //

	/**
	 * &lt;RelatedProduct&gt; is a basic version of &lt;Product&gt; (reciprocal of code 28). &lt;Product&gt; and
	 * &lt;RelatedProduct&gt; should share the same &lt;ProductForm&gt;.
	 */
	Basic_version_available_as("29"), //

	/**
	 * &lt;RelatedProduct&gt; and &lt;Product&gt; are part of the same collection (eg two products in same series or
	 * set).
	 */
	Product_in_same_collection("30"), //

	/**
	 * &lt;RelatedProduct&gt; is an alternative product in another sector (of the same geographical market). Indicates
	 * an alternative that carries the same content, but available to a different set of customers, as one or both
	 * products are retailer-, channel- or market sector-specific.
	 */
	Has_alternative_in_a_different_market_sector("31"), //

	/**
	 * &lt;RelatedProduct&gt; is an equivalent product, often intended for another (geographical) market. Indicates an
	 * alternative that carries essentially the same content, though slightly adapted for local circumstances (as
	 * opposed to a translation &#8211; use code 11).
	 */
	Has_equivalent_intended_for_a_different_market("32"), //

	/**
	 * &lt;RelatedProduct&gt; is an alternative product, often intended for another (geographical) market. Indicates the
	 * content of the alternative is identical in all respects.
	 */
	Has_alternative_intended_for_different_market("33"), //

	/**
	 * &lt;Product&gt; cites &lt;RelatedProduct&gt;.
	 */
	Cites("34"), //

	/**
	 * &lt;Product&gt; is the object of a citation in &lt;RelatedProduct&gt;.
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
