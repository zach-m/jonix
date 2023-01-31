/*
 * Copyright (C) 2012-2022 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 153 (Text type)
 */
interface CodeList153 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 153</b>
 * <p>
 * Description: Text type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist153">ONIX
 *      Codelist 153 in Reference Guide</a>
 */
public enum TextTypes implements OnixCodelist, CodeList153 {
    /**
     * To be used only in circumstances where the parties to an exchange have agreed to include text which (a) is not
     * for general distribution, and (b) cannot be coded elsewhere. If more than one type of text is sent, it must be
     * identified by tagging within the text itself
     */
    Sender_defined_text("01", "Sender-defined text"),

    /**
     * Of the product. Limited to a maximum of 350 characters
     */
    Short_description_annotation("02", "Short description/annotation"),

    /**
     * Of the product. Length unrestricted
     */
    Description("03", "Description"),

    /**
     * Used for a table of contents sent as a single text field, which may or may not carry structure expressed using
     * XHTML
     */
    Table_of_contents("04", "Table of contents"),

    /**
     * Primary descriptive blurb usually taken from the back cover or jacket, or occasionally from the cover/jacket
     * flaps. See also code 27
     */
    Primary_cover_copy("05", "Primary cover copy"),

    /**
     * A quote taken from a review of the product or of the work in question where there is no need to take account of
     * different editions
     */
    Review_quote("06", "Review quote"),

    /**
     * A quote taken from a review of a previous edition of the work
     */
    Review_quote_previous_edition("07", "Review quote: previous edition"),

    /**
     * A quote taken from a review of a previous work by the same author(s) or in the same series
     */
    Review_quote_previous_work("08", "Review quote: previous work"),

    /**
     * A quote usually provided by a celebrity or another author to promote a new book, not from a review
     */
    Endorsement("09", "Endorsement"),

    /**
     * A promotional phrase which is intended to headline a description of the product
     */
    Promotional_headline("10", "Promotional headline"),

    /**
     * Text describing a feature of a product to which the publisher wishes to draw attention for promotional purposes.
     * Each separate feature should be described by a separate repeat, so that formatting can be applied at the
     * discretion of the receiver of the ONIX record, or multiple features can be described using appropriate XHTML
     * markup
     */
    Feature("11", "Feature"),

    /**
     * A note referring to all contributors to a product - NOT linked to a single contributor
     */
    Biographical_note("12", "Biographical note"),

    /**
     * A statement included by a publisher in fulfillment of contractual obligations, such as a disclaimer, sponsor
     * statement, or legal notice of any sort. Note that the inclusion of such a notice cannot and does not imply that a
     * user of the ONIX record is obliged to reproduce it
     */
    Publishers_notice("13", "Publisher’s notice"),

    /**
     * A short excerpt from the main text of the work
     */
    Excerpt("14", "Excerpt"),

    /**
     * Used for an index sent as a single text field, which may be structured using XHTML
     */
    Index("15", "Index"),

    /**
     * (of which the product is a part.) Limited to a maximum of 350 characters
     */
    Short_description_annotation_for_collection("16", "Short description/annotation for collection"),

    /**
     * (of which the product is a part.) Length unrestricted
     */
    Description_for_collection("17", "Description for collection"),

    /**
     * As code 11 but used for a new feature of this edition or version
     */
    New_feature("18", "New feature"),

    Version_history("19", "Version history"),

    /**
     * Short summary statement of open access status and any related conditions (eg 'Open access - no commercial use'),
     * primarily for marketing purposes. Should always be accompanied by a link to the complete license (see
     * &lt;EpubLicense&gt; or code 99 in List 158)
     */
    Open_access_statement("20", "Open access statement"),

    /**
     * Short summary statement that the product is available only in digital formats (eg 'Digital exclusive'). If a
     * non-digital version is planned, &lt;ContentDate&gt; should be used to specify the date when exclusivity will end
     * (use content date role code 15). If a non-digital version is available, the statement should not be included
     */
    Digital_exclusivity_statement("21", "Digital exclusivity statement"),

    /**
     * For example a recommendation or approval provided by a ministry of education or other official body. Use
     * &lt;Text&gt; to provide details and ideally use &lt;TextSourceCorporate&gt; to name the approver
     */
    Official_recommendation("22", "Official recommendation"),

    /**
     * Short description in format specified by Japanese Book Publishers Association
     */
    JBPA_description("23", "JBPA description"),

    /**
     * JSON-LD snippet suitable for use within an HTML &lt;script type=&quot;application/ld+json&quot;&gt; tag,
     * containing structured metadata suitable for use with schema.org
     */
    schema_org_snippet("24", "schema.org snippet"),

    /**
     * Jonix-Comment: Introduced in Onix3
     */
    Errata("25", "Errata"),

    /**
     * Introduction, preface or the text of other preliminary material, sent as a single text field, which may be
     * structured using XHTML
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Introduction("26", "Introduction"),

    /**
     * Secondary descriptive blurb taken from the cover/jacket flaps, or occasionally from the back cover or jacket,
     * used only when there are two separate texts and the primary text is included using code 05
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Secondary_cover_copy("27", "Secondary cover copy"),

    /**
     * For use with dramatized audiobooks, filmed entertainment etc, for a cast list sent as a single text field, which
     * may or may not carry structure expressed using XHTML
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Full_cast_and_credit_list("28", "Full cast and credit list"),

    /**
     * Complete list of books by the author(s), supplied as a single text field, which may be structured using (X)HTML
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Bibliography("29", "Bibliography"),

    /**
     * Formal summary of content (normally used with academic and scholarly content only)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Abstract("30", "Abstract"),

    /**
     * Eg for a game, kit
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Rules_or_instructions("31", "Rules or instructions"),

    /**
     * Eg for a game, kit. Note: use code 04 for a Table of Contents of a book
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    List_of_contents("32", "List of contents"),

    /**
     * Length limited to a maximum of 350 characters
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Short_description_annotation_for_imprint("33", "Short description/annotation for imprint"),

    /**
     * Length unrestricted
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Description_for_imprint("34", "Description for imprint"),

    /**
     * Length limited to a maximum of 350 characters
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Short_description_annotation_for_publisher("35", "Short description/annotation for publisher"),

    /**
     * Length unrestricted
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Description_for_publisher("36", "Description for publisher");

    public final String code;
    public final String description;

    TextTypes(String code, String description) {
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

    private static volatile Map<String, TextTypes> map;

    private static Map<String, TextTypes> map() {
        Map<String, TextTypes> result = map;
        if (result == null) {
            synchronized (TextTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TextTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TextTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
