/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 21 (Edition type)
 */
interface CodeList21 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 21</b>
 * <p>
 * Description: Edition type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_64.html#codelist21">ONIX
 *      Codelist 21 in Reference Guide</a>
 */
public enum EditionTypes implements OnixCodelist, CodeList21 {
    /**
     * Content has been shortened: use for abridged, shortened, concise, condensed
     */
    Abridged_edition("ABR", "Abridged edition"),

    /**
     * Version of a play or script intended for use of those directly involved in a production, usually including full
     * stage directions in addition to the text of the script
     */
    Acting_edition("ACT", "Acting edition"),

    /**
     * Content has been adapted to serve a different purpose or audience, or from one medium to another: use for
     * dramatization, novelization etc. Use &lt;EditionStatement&gt; to describe the exact nature of the adaptation
     */
    Adapted_edition("ADP", "Adapted edition"),

    /**
     * Do not use. Deprecated, but retained in the list for reasons of backwards compatibility. Not for use in ONIX 3.0
     * or later
     */
    Alternate("ALT", "Alternate"),

    /**
     * Content is augmented by the addition of notes
     */
    Annotated_edition("ANN", "Annotated edition"),

    /**
     * Both languages should be specified in the &lt;Language&gt; group. Use MLL for an edition in more than two
     * languages
     */
    Bilingual_edition("BLL", "Bilingual edition"),

    /**
     * Use only where the two languages are presented in parallel on facing pages, or in parallel columns of text on a
     * single page (otherwise use BLL). Both languages should be specified in the &lt;Language&gt; group
     */
    Bilingual_facing_page_edition("BLP", "Bilingual ‘facing page’ edition"),

    /**
     * Braille edition
     */
    Braille_edition("BRL", "Braille edition"),

    /**
     * Product sold at lower price than other editions, usually with lower quality paper or binding to reduce production
     * costs. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Budget_edition("BUD", "Budget edition"),

    /**
     * An edition in which two or more works also published separately are combined in a single volume; AKA 'omnibus
     * edition', or in comic books a 'trade paperback' (fr: 'int&#233;grale')
     */
    Combined_volume("CMB", "Combined volume"),

    /**
     * Content includes critical commentary on the text
     */
    Critical_edition("CRI", "Critical edition"),

    /**
     * Content was compiled for a specified educational course
     */
    Coursepack("CSP", "Coursepack"),

    /**
     * A digital product that, at the time of publication, has or had no physical counterpart and that is or was not
     * expected to have a physical counterpart for a reasonable time (recommended at least 30 days following
     * publication)
     */
    Digital_original("DGO", "Digital original"),

    /**
     * Use for e-publications that have been enhanced with additional text, speech, other audio, video, interactive or
     * other content
     */
    Enhanced_edition("ENH", "Enhanced edition"),

    /**
     * Content has been enlarged or expanded from that of a previous edition
     */
    Enlarged_edition("ENL", "Enlarged edition"),

    /**
     * Book which uses highly simplified wording, clear page layout and typography to ensure the content can be
     * understood by those with intellectual disabilities. See https://www.inclusion-europe.eu/easy-to-read for
     * guidelines. See also SMP for editions with simplified language. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Easy_to_read_edition("ETR", "Easy-to-read edition"),

    /**
     * 'Offensive' content has been removed
     */
    Expurgated_edition("EXP", "Expurgated edition"),

    /**
     * Exact reproduction of the content and format of a previous edition
     */
    Facsimile_edition("FAC", "Facsimile edition"),

    /**
     * A collection of writings published in honor of a person, an institution or a society
     */
    Festschrift("FST", "Festschrift"),

    /**
     * Edition optimised for high readability, typically featuring colored or tinted page backgrounds to reduce
     * contrast, extra letter, word and line spacing to reduce crowding and isolate individual words, simplified page
     * layouts and an open, sans serif font (or occasionally, an unusual font design) intended to aid readability.
     * Sometimes labelled 'dyslexia-friendly'. See also code SMP if the text itself is simplified, and codes LTE or ULP
     * if the type size is significantly larger than normal. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    High_readability_edition("HRE", "High readability edition"),

    /**
     * Content includes extensive illustrations which are not part of other editions
     */
    Illustrated_edition("ILL", "Illustrated edition"),

    /**
     * A product aimed specifically at markets other than the country of original publication, usually titled as an
     * 'International edition' and with specification and/or content changes
     */
    International_edition("INT", "International edition"),

    /**
     * Large print edition, print sizes 14 to 19pt - see also ULP
     */
    Large_type_large_print_edition("LTE", "Large type / large print edition"),

    /**
     * A printed edition in a type size too small to be read without a magnifying glass
     */
    Microprint_edition("MCP", "Microprint edition"),

    /**
     * An edition published to coincide with the release of a film, TV program, or electronic game based on the same
     * work. Use &lt;EditionStatement&gt; to describe the exact nature of the tie-in
     */
    Media_tie_in("MDT", "Media tie-in"),

    /**
     * All languages should be specified in the 'Language' group. Use BLL for a bilingual edition
     */
    Multilingual_edition("MLL", "Multilingual edition"),

    /**
     * Where no other information is given, or no other coded type or edition numbering is applicable
     */
    New_edition("NED", "New edition"),

    /**
     * A limited or collectors' edition in which each copy is individually numbered, and the actual number of copies is
     * strictly limited. Note that the supplier may limit the number of orders fulfilled per retail outlet. Use
     * &lt;EditionStatement&gt; to give details of the number of copies printed
     */
    Edition_with_numbered_copies("NUM", "Edition with numbered copies"),

    /**
     * A product published in any form of soft cover, that at the time of publication, has or had no counterpart in any
     * other format, and that is or was not expected to have such a counterpart for a reasonable time (recommended at
     * least 30 days following publication). Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Paperback_original("PBO", "Paperback original"),

    /**
     * In the US, a book that was previously bound, normally as a paperback, and has been rebound with a library-quality
     * hardcover binding by a supplier other than the original publisher. See also the &lt;Publisher&gt; and
     * &lt;RelatedProduct&gt; composites for other aspects of the treatment of prebound editions in ONIX
     */
    Prebound_edition("PRB", "Prebound edition"),

    /**
     * Content has been revised from that of a previous edition (often used when there has been no corresponding
     * increment in the edition number, or no edition numbering is available)
     */
    Revised_edition("REV", "Revised edition"),

    /**
     * An edition intended specifically for use in schools
     */
    School_edition("SCH", "School edition"),

    /**
     * Individually autographed by the author(s)
     */
    Signed_edition("SIG", "Signed edition"),

    /**
     * An edition that uses simplified language, usually for second or additional language learners. See ETR for highly
     * simplified editions for readers with intellectual disabilities
     */
    Simplified_language_edition("SMP", "Simplified language edition"),

    /**
     * Use for anniversary, collectors', de luxe, gift, limited (but prefer codes NUM or UNN as appropriate),
     * autographed (but prefer code SIG as appropriate) edition. Use &lt;EditionStatement&gt; to describe the exact
     * nature of the special edition
     */
    Special_edition("SPE", "Special edition"),

    /**
     * Where a text is available in both student and teacher's editions
     */
    Student_edition("STU", "Student edition"),

    /**
     * Where a text is available in both student and teacher's editions; use also for instructor's or leader's editions,
     * and for editions intended exclusively for educators where no specific student edition is available
     */
    Teachers_edition("TCH", "Teacher’s edition"),

    /**
     * Where a title has also been published in an abridged edition; also for audiobooks, regardless of whether an
     * abridged audio version also exists
     */
    Unabridged_edition("UBR", "Unabridged edition"),

    /**
     * For print sizes 20pt and above, and with typefaces designed for the visually impaired - see also LTE
     */
    Ultra_large_print_edition("ULP", "Ultra large print edition"),

    /**
     * A limited or collectors' edition in which each copy is not individually numbered - but where the actual number of
     * copies is strictly limited. Note that the supplier may limit the number of orders fulfilled per retail outlet.
     * Use &lt;EditionStatement&gt; to give details of the number of copies printed
     */
    Edition_with_unnumbered_copies("UNN", "Edition with unnumbered copies"),

    /**
     * Content previously considered 'offensive' has been restored
     */
    Unexpurgated_edition("UXP", "Unexpurgated edition"),

    /**
     * Content includes notes by various commentators, and/or includes and compares several variant texts of the same
     * work
     */
    Variorum_edition("VAR", "Variorum edition"),

    /**
     * Readaloud edition - specifially intended and designed for reading aloud (to children). Only for use in ONIX 3.0
     * or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Vorlesebucher("VOR", "Vorlesebücher");

    public final String code;
    public final String description;

    EditionTypes(String code, String description) {
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

    private static volatile Map<String, EditionTypes> map;

    private static Map<String, EditionTypes> map() {
        Map<String, EditionTypes> result = map;
        if (result == null) {
            synchronized (EditionTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EditionTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EditionTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<EditionTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
