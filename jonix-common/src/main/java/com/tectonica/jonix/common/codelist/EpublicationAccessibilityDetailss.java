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
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 196 (E-publication Accessibility Details)
 */
interface CodeList196 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 196</b>
 * <p>
 * Description: E-publication Accessibility Details
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist196">ONIX
 *      Codelist 196 in Reference Guide</a>
 */
public enum EpublicationAccessibilityDetailss implements OnixCodelist, CodeList196 {
    /**
     * &lt;ProductFormFeatureDescription&gt; contains a short explanatory summary of the accessibility of the product,
     * consistent with the more specific conformance and feature details provided. The summary should note both the
     * accessibility features provided and any potential deficiencies. More detailed information may be provided in an
     * external file using codes 94-96. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Accessibility_summary("00", "Accessibility summary"),

    LIA_Compliance_Scheme("01", "LIA Compliance Scheme"),

    /**
     * Conforms with the requirements of EPUB Accessibility Spec 1.0 and WCAG level A.
     * &lt;ProductFormFeatureDescription&gt; may carry a URL linking to a compliance report or certification provided by
     * an independent third party certifier. In the absence of a URL, conformance with the requirements of the
     * Accessibility Specification is self-certified by the publisher
     */
    EPUB_Accessibility_Specification_1_0_A("02", "EPUB Accessibility Specification 1.0 A"),

    /**
     * Conforms with the requirements of EPUB Accessibility Spec 1.0 and WCAG level AA.
     * &lt;ProductFormFeatureDescription&gt; may carry a URL linking to a compliance report or certification provided by
     * an independent third party certifier. In the absence of a URL, conformance with the requirements of the
     * Accessibility Specification is self-certified by the publisher
     */
    EPUB_Accessibility_Specification_1_0_AA("03", "EPUB Accessibility Specification 1.0 AA"),

    /**
     * Conforms with the requirements of ISO 32000-1:2008 plus ISO 14289-1:2014 - Portable Document Format for Universal
     * Accessibility. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    PDF_UA("05", "PDF/UA"),

    /**
     * Known to lack significant features required for broad accessibility. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Inaccessible("09", "Inaccessible"),

    /**
     * No accessibility features offered by the reading system, device or reading software (including but not limited to
     * choice of text size or typeface, choice of text or background color, text-to-speech) are disabled, overridden or
     * otherwise unusable with the product EXCEPT - in ONIX 3 messages only - those specifically noted as subject to
     * restriction or prohibition in &lt;EpubUsageConstraint&gt;. Note that provision of any significant part of the
     * textual content as images (ie as pictures of text, rather than as text, and without any textual equivalent)
     * inevitably prevents use of these accessibility options
     */
    No_reading_system_accessibility_options_disabled_except("10",
        "No reading system accessibility options disabled (except)"),

    /**
     * Table of contents allows direct (eg hyperlinked) access to all levels of text organization above individual
     * paragraphs (eg to all sections and subsections) and to all tables, figures, illustrations etc. Non-textual items
     * such as illustrations, tables, audio or video content may be directly accessible from the Table of contents, or
     * from a similar List of illustrations, List of tables, etc
     */
    Table_of_contents_navigation("11", "Table of contents navigation"),

    /**
     * Index provides direct (eg hyperlinked) access to uses of the index terms in the document body
     */
    Index_navigation("12", "Index navigation"),

    /**
     * All or substantially all textual matter is arranged in a single logical reading order (including text that is
     * visually presented as separate from the main text flow, eg in boxouts, captions, tables, footnotes, endnotes,
     * citations, etc). Non-textual content is also linked from within this logical reading order. (Purely decorative
     * non-text content can be ignored)
     */
    Reading_order("13", "Reading order"),

    /**
     * All or substantially all non-text content has short alternative (textual) descriptions, usually provided via alt
     * attributes. Note this applies to normal images (eg photographs, charts and diagrams) and also to any embedded
     * audio, video etc. Audio and video content should include alternative descriptions suitable for hearing-impaired
     * as well as for visually-impaired readers. (Purely decorative non-text content can be ignored, but the
     * accessibility of resources delivered via a network connection rather than as part of the e-publication package
     * must be included)
     */
    Short_alternative_descriptions("14", "Short alternative descriptions"),

    /**
     * All or substantially all non-text content has full alternative (textual) descriptions. Note this applies to
     * normal images (eg photographs, charts and diagrams) and also to any embedded audio, video etc. Audio and video
     * content should include full alternative descriptions (eg audio-described video) and transcript, subtitles or
     * captions (whether closed or open) suitable for hearing-impaired as well as for visually-impaired readers. (Purely
     * decorative non-text content can be ignored, but the accessibility of resources delivered via a network connection
     * rather than as part of the e-publication package must be included)
     */
    Full_alternative_descriptions("15", "Full alternative descriptions"),

    /**
     * Where data visualisations are provided (eg graphs and charts), the underlying data is also available in
     * non-graphical (usually tabular, textual) form
     */
    Visualised_data_also_available_as_non_graphical_data("16", "Visualised data also available as non-graphical data"),

    /**
     * Mathematical content such as equations is usable with assistive technology, eg through use of MathML. Semantic
     * MathML is preferred but Presentational MathML is acceptable
     */
    Accessible_math_content("17", "Accessible math content"),

    /**
     * Chemistry content such as chemical formulae is usable with assistive technology, eg through use of ChemML
     */
    Accessible_chem_content("18", "Accessible chem content"),

    /**
     * For a reflowable e-publication, contains references to the page numbering of an equivalent printed product. Use
     * &lt;RelatedProduct&gt; with relation code 13 to specify an identifier for the source of the page numbers
     */
    Print_equivalent_page_numbering("19", "Print-equivalent page numbering"),

    /**
     * Text-synchronised pre-recorded audio narration (natural or synthesised voice) is included for substantially all
     * textual matter, including all alternative descriptions
     */
    Synchronised_pre_recorded_audio("20", "Synchronised pre-recorded audio"),

    /**
     * Text-to-speech has been optimised through provision of PLS lexicons, SSML or CSS Speech synthesis hints
     */
    Text_to_speech_hinting_provided("21", "Text-to-speech hinting provided"),

    /**
     * The language of the text has been specified (eg via the HTML or XML lang attribute) to optimise text-to-speech
     * (and other alternative renderings), both at whole document level and, where appropriate, for individual words,
     * phrases or passages in a different language
     */
    Language_tagging_provided("22", "Language tagging provided"),

    /**
     * Specialised font, character and/or line spacing, justification and paragraph spacing, coloring and other options
     * provided specifically to improve readability for dyslexic readers. Details, including the name of the font if
     * relevant, should be listed in &lt;ProductFormFeatureDescription&gt;
     */
    Dyslexia_readability("24", "Dyslexia readability"),

    /**
     * For readers with color vision deficiency, use of color (eg in diagrams) is not the sole means of graphical
     * distinction
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Use_of_color("25", "Use of color"),

    /**
     * Body text is presented with a contrast ratio of at least 4.5:1 (or 3:1 for large/heading text)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Use_of_contrast("26", "Use of contrast"),

    /**
     * Foreground audio content (eg voice) is presented with no or low background noise (eg ambient sounds, music), at
     * least 20dB below the level of the foreground, or background noise can be switched off (eg via an alternative
     * audio track)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Use_of_audio("27", "Use of audio"),

    /**
     * All or substantially all non-text content has full alternative descriptions as pre-recorded audio. Note this
     * applies to normal images (eg photographs, charts and diagrams) and also to any embedded video etc. Video content
     * should include full alternative descriptions (eg audio-described video) and transcript, subtitles or captions
     * (whether closed or open) suitable for hearing-impaired as well as for visually-impaired readers. (Purely
     * decorative non-text content can be ignored, but the accessibility of resources delivered via a network connection
     * rather than as part of the e-publication package must be included)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Full_alternative_audio_descriptions("28", "Full alternative audio descriptions"),

    /**
     * All levels of heading and other structural elements of the content are correctly marked up and (if applicable)
     * numbered, to enable fast next heading / previous heading, next chapter / previous chapter navigation without
     * returning to the table of contents
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Next_Previous_navigation("29", "Next / Previous navigation"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page belonging to the organisation responsible for
     * compliance testing and certification of the product - typically a 'home page' or a page describing the
     * certification scheme itself. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Compliance_certification_by("93", "Compliance certification by"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing, certification etc relevant to this product. The web page should
     * be maintained by an independent compliance scheme or testing organization
     */
    Compliance_web_page_for_detailed_accessibility_information("94",
        "Compliance web page for detailed accessibility information"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing etc relevant to this product. The web page should be provided by a
     * trusted intermediary or third party nominated by the publisher
     */
    Trusted_intermediarys_web_page_for_detailed_accessibility_information("95",
        "Trusted intermediary’s web page for detailed accessibility information"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing etc relevant to this product. The web page should be provided by
     * the publisher
     */
    Publishers_web_page_for_detailed_accessibility_information("96",
        "Publisher’s web page for detailed accessibility information"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving a short description of compatibility
     * testing carried out for this product, including detailed compatibility with various assistive technology such as
     * third-party screen-reading software. See also code 00 for a summary of the accessibility features of the product
     * itself
     */
    Compatibility_tested("97", "Compatibility tested"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the e-mail address for a contact at a 'trusted intermediary', to
     * whom detailed questions about accessibility for this product may be directed
     */
    Trusted_Intermediary_contact("98", "Trusted Intermediary contact"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the e-mail address for a contact at the publisher to whom detailed
     * questions about accessibility of this product may be directed
     */
    Publisher_contact_for_further_accessibility_information("99",
        "Publisher contact for further accessibility information");

    public final String code;
    public final String description;

    EpublicationAccessibilityDetailss(String code, String description) {
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

    private static volatile Map<String, EpublicationAccessibilityDetailss> map;

    private static Map<String, EpublicationAccessibilityDetailss> map() {
        Map<String, EpublicationAccessibilityDetailss> result = map;
        if (result == null) {
            synchronized (EpublicationAccessibilityDetailss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EpublicationAccessibilityDetailss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EpublicationAccessibilityDetailss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<EpublicationAccessibilityDetailss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
