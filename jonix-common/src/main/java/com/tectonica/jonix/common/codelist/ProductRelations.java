/*
 * Copyright (C) 2012-2023 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 51 (Product relation)
 */
interface CodeList51 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 51</b>
 * <p>
 * Description: Product relation
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist51">ONIX
 *      Codelist 51 in Reference Guide</a>
 */
public enum ProductRelations implements OnixCodelist, CodeList51 {
    /**
     * &lt;Product&gt; is related to &lt;RelatedProduct&gt; in a way that cannot be specified by another code value
     */
    Unspecified("00", "Unspecified"),

    /**
     * &lt;Product&gt; includes &lt;RelatedProduct&gt; (inverse of code 02)
     */
    Includes("01", "Includes"),

    /**
     * &lt;Product&gt; is part of &lt;RelatedProduct&gt;: use for 'also available as part of' (inverse of code 01)
     */
    Is_part_of("02", "Is part of"),

    /**
     * &lt;Product&gt; replaces, or is new edition of, &lt;RelatedProduct&gt; (inverse of code 05)
     */
    Replaces("03", "Replaces"),

    /**
     * &lt;Product&gt; and &lt;RelatedProduct&gt; are companion products, intended to be used, or are usable, together
     * (is own inverse). For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Has_companion_product("04", "Has companion product"),

    /**
     * &lt;Product&gt; is replaced by, or has new edition, &lt;RelatedProduct&gt; (inverse of code 03)
     */
    Replaced_by("05", "Replaced by"),

    /**
     * &lt;Product&gt; is available in an alternative format as &lt;RelatedProduct&gt; - indicates an alternative format
     * of the same content which is or may be available (is own inverse)
     */
    Alternative_format("06", "Alternative format"),

    /**
     * &lt;Product&gt; has an ancillary or supplementary product &lt;RelatedProduct&gt; (inverse of code 08)
     */
    Has_ancillary_product("07", "Has ancillary product"),

    /**
     * &lt;Product&gt; is ancillary or supplementary to &lt;RelatedProduct&gt; (inverse of code 07)
     */
    Is_ancillary_to("08", "Is ancillary to"),

    /**
     * &lt;Product&gt; is remaindered as &lt;RelatedProduct&gt;, when a remainder merchant assigns its own identifier to
     * the product (inverse of code 10)
     */
    Is_remaindered_as("09", "Is remaindered as"),

    /**
     * &lt;Product&gt; was originally sold as &lt;RelatedProduct&gt;, indicating the publisher's original identifier for
     * a title which is offered as a remainder under a different identifier (inverse of code 09)
     */
    Is_remainder_of("10", "Is remainder of"),

    /**
     * &lt;Product&gt; is an other-language version of &lt;RelatedProduct&gt; (is own inverse)
     */
    Is_other_language_version_of("11", "Is other-language version of"),

    /**
     * &lt;Product&gt; has a publisher's suggested alternative &lt;RelatedProduct&gt;, which does not, however, carry
     * the same content (cf 05 and 06)
     */
    Publishers_suggested_alternative("12", "Publisher’s suggested alternative"),

    /**
     * &lt;Product&gt; is an epublication based on printed product &lt;RelatedProduct&gt;. The related product is the
     * source of any print-equivalent page numbering present in the epublication
     */
    Epublication_based_on_print_product("13", "Epublication based on (print product)"),

    /**
     * &lt;Product&gt; is a POD replacement for &lt;RelatedProduct&gt;. &lt;RelatedProduct&gt; is an out-of-print
     * product replaced by a print-on-demand version under a new ISBN (inverse of code 17)
     */
    POD_replacement_for("16", "POD replacement for"),

    /**
     * &lt;Product&gt; is replaced by POD &lt;RelatedProduct&gt;. &lt;RelatedProduct&gt; is a print-on-demand
     * replacement, under a new ISBN, for an out-of-print &lt;Product&gt; (inverse of code 16)
     */
    Replaced_by_POD("17", "Replaced by POD"),

    /**
     * &lt;Product&gt; is a special edition of &lt;RelatedProduct&gt;. Used for a special edition (German:
     * Sonderausgabe) with different cover, binding, premium content etc - more than 'alternative format' - which may be
     * available in limited quantity and for a limited time (inverse of code 19)
     */
    Is_special_edition_of("18", "Is special edition of"),

    /**
     * &lt;Product&gt; has a special edition &lt;RelatedProduct&gt; (inverse of code 18)
     */
    Has_special_edition("19", "Has special edition"),

    /**
     * &lt;Product&gt; is a prebound edition of &lt;RelatedProduct&gt; (In the US, a 'prebound' edition is 'a book that
     * was previously bound and has been rebound with a library quality hardcover binding. In almost all commercial
     * cases, the book in question began as a paperback. This might also be termed 're-bound') (inverse of code 21)
     */
    Is_prebound_edition_of("20", "Is prebound edition of"),

    /**
     * &lt;Product&gt; is the regular edition of which &lt;RelatedProduct&gt; is a prebound edition (inverse of code 20)
     */
    Is_original_of_prebound_edition("21", "Is original of prebound edition"),

    /**
     * &lt;Product&gt; and &lt;RelatedProduct&gt; have a common author
     */
    Product_by_same_author("22", "Product by same author"),

    /**
     * &lt;RelatedProduct&gt; is another product that is suggested as similar to &lt;Product&gt; ('if you liked
     * &lt;Product&gt;, you may also like &lt;RelatedProduct&gt;', or vice versa)
     */
    Similar_product("23", "Similar product"),

    /**
     * &lt;Product&gt; is a facsimile edition of &lt;RelatedProduct&gt; (inverse of code 25)
     */
    Is_facsimile_of("24", "Is facsimile of"),

    /**
     * &lt;Product&gt; is the original edition from which a facsimile edition &lt;RelatedProduct&gt; is taken (inverse
     * of code 24)
     */
    Is_original_of_facsimile("25", "Is original of facsimile"),

    /**
     * &lt;Product&gt; is a license for a digital &lt;RelatedProduct&gt;, traded or supplied separately
     */
    Is_license_for("26", "Is license for"),

    /**
     * &lt;RelatedProduct&gt; is an electronic version of print &lt;Product&gt; (inverse of code 13)
     */
    Electronic_version_available_as("27", "Electronic version available as"),

    /**
     * &lt;RelatedProduct&gt; is an 'enhanced' version of &lt;Product&gt;, with additional content. Typically used to
     * link an enhanced e-book to its original 'unenhanced' equivalent, but not specifically limited to linking e-books
     * - for example, may be used to link illustrated and non-illustrated print books. &lt;Product&gt; and
     * &lt;RelatedProduct&gt; should share the same &lt;ProductForm&gt; (inverse of code 29)
     */
    Enhanced_version_available_as("28", "Enhanced version available as"),

    /**
     * &lt;RelatedProduct&gt; is a basic version of &lt;Product&gt;. &lt;Product&gt; and &lt;RelatedProduct&gt; should
     * share the same &lt;ProductForm&gt; (inverse of code 28)
     */
    Basic_version_available_as("29", "Basic version available as"),

    /**
     * &lt;RelatedProduct&gt; and &lt;Product&gt; are part of the same collection (eg two products in same series or
     * set) (is own inverse)
     */
    Product_in_same_collection("30", "Product in same collection"),

    /**
     * &lt;RelatedProduct&gt; is an alternative product in another sector (of the same geographical market). Indicates
     * an alternative that carries the same content, but available to a different set of customers, as one or both
     * products are retailer-, channel- or market sector-specific (is own inverse)
     */
    Has_alternative_in_a_different_market_sector("31", "Has alternative in a different market sector"),

    /**
     * &lt;RelatedProduct&gt; is an equivalent product, often intended for another (geographical) market. Indicates an
     * alternative that carries essentially the same content, though slightly adapted for local circumstances (as
     * opposed to a translation - use code 11) (is own inverse)
     */
    Has_equivalent_intended_for_a_different_market("32", "Has equivalent intended for a different market"),

    /**
     * &lt;RelatedProduct&gt; is an alternative product, often intended for another (geographical) market. Indicates the
     * content of the alternative is identical in all respects (is own inverse)
     */
    Has_alternative_intended_for_different_market("33", "Has alternative intended for different market"),

    /**
     * &lt;Product&gt; cites &lt;RelatedProduct&gt; (inverse of code 35)
     */
    Cites("34", "Cites"),

    /**
     * &lt;Product&gt; is the object of a citation in &lt;RelatedProduct&gt; (inverse of code 34)
     */
    Is_cited_by("35", "Is cited by"),

    /**
     * &lt;Product&gt; is a signed copy of &lt;RelatedProduct&gt;. Use where signed copies are given a distinct product
     * identifier and can be ordered separately, but are otherwise identical (inverse of code 38)
     */
    Is_signed_version_of("37", "Is signed version of"),

    /**
     * &lt;Product&gt; is an unsigned copy of &lt;RelatedProduct&gt;. Use where signed copies are given a distinct
     * product identifier and can be ordered separately, but are otherwise identical (inverse of code 37)
     */
    Has_signed_version("38", "Has signed version"),

    /**
     * &lt;Product&gt; is intended for teacher use, and the related product is for student use
     */
    Has_related_student_material("39", "Has related student material"),

    /**
     * &lt;Product&gt; is intended for student use, and the related product is for teacher use
     */
    Has_related_teacher_material("40", "Has related teacher material"),

    /**
     * &lt;Product&gt; includes some content shared with &lt;RelatedProduct&gt;. Note the shared content does not form
     * the whole of either product. Compare with the 'includes' / 'is part of' relationship pair (codes 01 and 02),
     * where the shared content forms the whole of one of the products, and with the 'alternative format' relationship
     * (code 06), where the shared content forms the whole of both products (code 41 is own inverse)
     */
    Some_content_shared_with("41", "Some content shared with"),

    /**
     * &lt;Product&gt; is a later edition of &lt;RelatedProduct&gt;, where the related product is the first edition
     */
    Is_later_edition_of_first_edition("42", "Is later edition of first edition"),

    /**
     * &lt;Product&gt; is an adapted (dramatized, abridged, novelized etc) version of &lt;RelatedProduct&gt; (inverse of
     * code 44). For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Adapted_from("43", "Adapted from"),

    /**
     * &lt;Product&gt; is the original from which &lt;RelatedProduct&gt; is adapted (dramatized etc) (inverse of code
     * 43), For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Adapted_as("44", "Adapted as"),

    /**
     * Purchases of &lt;Product&gt; may qualify for one or more copies of &lt;RelatedProduct&gt; either free of charge
     * or at a reduced price, or vice versa (is own inverse). This may be dependent on retailer participation, upon
     * price and upon the quantity of the &lt;Product&gt; or the &lt;RelatedProduct&gt; purchased. For use in ONIX 3.0
     * only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Linked_product_offer("45", "Linked product offer"),

    /**
     * If ordered, &lt;Product&gt; may (at the supplier's discretion) be substituted and the &lt;RelatedProduct&gt;
     * supplied instead. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    May_be_substituted_by("46", "May be substituted by"),

    /**
     * &lt;Product&gt; is an epublication 'rendered' as &lt;RelatedProduct&gt;: use in ONIX 2.1 only when the
     * &lt;Product&gt; record describes a package of electronic content which is available in multiple 'renderings'
     * (coded 000 in &lt;EpubTypeCode&gt;): NOT USED in ONIX 3.0
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Epublication_is_distributed_as("14", "Epublication is distributed as"),

    /**
     * &lt;Product&gt; is a 'rendering' of an epublication &lt;RelatedProduct&gt;: use in ONIX 2.1 only when the
     * &lt;Product&gt; record describes a specific rendering of an epublication content package, to identify the
     * package: NOT USED in ONIX 3.0
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Epublication_is_a_rendering_of("15", "Epublication is a rendering of"),

    /**
     * Use to give the ISBN of another book that had sales (both in terms of copy numbers and customer profile)
     * comparable to that the publisher or distributor estimates for the product. Use in ONIX 2.1 ONLY
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Sales_expectation("36", "Sales expectation");

    public final String code;
    public final String description;

    ProductRelations(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, ProductRelations> map;

    private static Map<String, ProductRelations> map() {
        Map<String, ProductRelations> result = map;
        if (result == null) {
            synchronized (ProductRelations.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductRelations e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductRelations byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
