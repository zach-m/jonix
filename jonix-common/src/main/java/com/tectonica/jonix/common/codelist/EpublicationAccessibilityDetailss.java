/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

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
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist196">ONIX
 *      Codelist 196 in Reference Guide</a>
 */
public enum EpublicationAccessibilityDetailss implements OnixCodelist, CodeList196 {
    /**
     * &lt;ProductFormFeatureDescription&gt; contains a short explanatory summary of the accessibility of the product,
     * or the URL of a web page comprising such a summary, consistent with the more specific conformance, feature and
     * certification details provided. The summary should note both the accessibility features provided and any
     * potential deficiencies. The summary does not remove the requirement for full structured accessibility data, but
     * should be considered a fall-back option if more structured detail cannot be provided or used. Further detailed
     * information may be provided in an external file using codes 94-96. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
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
     * Conforms with the requirements of EPUB Accessibility Spec v1.1 - see https://www.w3.org/TR/epub-a11y-11/.
     * &lt;ProductFormFeatureDescription&gt; may carry a URL linking to a compliance report or certification provided by
     * an independent third-party certifier. In the absence of a URL, conformance with the requirements of the
     * Accessibility Specification is self- certified by the publisher. Use with other List 196 codes to indicate WCAG
     * version and level, ARIA inclusion. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Epub_Accessibility_Specification_1_1("04", "Epub Accessibility Specification 1.1"),

    /**
     * Conforms with the requirements of ISO 32000-1:2008 plus ISO 14289-1:2014 - Portable Document Format for Universal
     * Accessibility, for example, all content is tagged in logical reading order and correctly represents the
     * document's semantic structure. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_UA_1("05", "PDF/UA-1"),

    /**
     * Conforms with the requirements of ISO 32000-2:2020 (PDF 2.0) plus ISO 14289-2:2024 - Portable Document Format for
     * Universal Accessibility v2, for example, the revised semantic tagging, MathML, Unicode support and associated
     * documents from PDF 2.0. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_UA_2("06", "PDF/UA-2"),

    /**
     * Product has not yet been assessed for accessibility, or no or insufficient accessibility information is provided.
     * It should be treated as likely to be inaccessible (and also may not have been checked for hazards).
     * &lt;ProductFormFeatureDescription&gt; may carry details of why the accessibility of the title is unknown. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unknown_accessibility("08", "Unknown accessibility"),

    /**
     * Known to lack significant features required for broad accessibility. Details of and reasons for limitations on
     * accessibility can be given in &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Inaccessible_or_known_limited_accessibility("09", "Inaccessible, or known limited accessibility"),

    /**
     * No accessibility features or content rendering options offered by the reading system, device or reading software
     * (including but not limited to the ability to modify or choose text size or typeface, word and line spacing, zoom
     * level, text or background color, or use of text-to-speech) are limited, disabled, overridden or otherwise
     * unusable with the product EXCEPT - in ONIX 3 messages only - those specifically noted as subject to restriction
     * or prohibition in &lt;EpubUsageConstraint&gt;. Note that provision of any significant part of the textual content
     * as images (ie as pictures of text, rather than as 'text-as-text', and without any textual equivalent) or the
     * application of some technical protection measures (DRM), inevitably prevents full use of these accessibility
     * options. Code 10 means 'this e-publication is accessible to the full extent that the file format and types of
     * content allow, on a specific reading device, by default, without necessarily inluding any additions such as
     * textual descriptions of images or enhanced navigation. Note that for reflowable e-books, this means code 36 also
     * applies, although code 10 can also be used with accessible non-reflowable (fixed-format) e-publications and with
     * audio material. Should be used with other codes that describe any additions to enhance the level of accessibility
     */
    No_reading_system_accessibility_options_actively_disabled_except("10",
        "No reading system accessibility options actively disabled (except)"),

    /**
     * Table of contents allows direct (eg hyperlinked) access to all levels of text organization above individual
     * paragraphs (ie to all chapters, sections and subsections that exist within the text), and to all tables, figures,
     * illustrations etc (non-textual items such as illustrations, tables, audio or video content may be directly
     * accessible from the Table of contents, or from a similar List of illustrations, List of tables, etc)
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
     * non-text content can be ignored). All or substantially all audio content should also have a single logical
     * 'reading order', which is the order the content should be presented to the listener
     */
    Single_logical_reading_order("13", "Single logical reading order"),

    /**
     * All or substantially all non-text content has short alternative (textual) descriptions, usually provided via alt
     * attributes. Note this applies to normal images (eg photographs, charts and diagrams) and also to any embedded
     * audio, video etc. Audio and video content should include alternative descriptions suitable for hearing-impaired
     * as well as for visually-impaired readers. (Purely decorative non-text content can be ignored, but the
     * accessibility of resources delivered via a network connection rather than as part of the e-publication package
     * must be included)
     */
    Short_alternative_textual_descriptions("14", "Short alternative textual descriptions"),

    /**
     * All or substantially all non-text content has full alternative (textual) descriptions. Note this applies to
     * normal images (eg photographs, charts and diagrams) and also to any embedded audio, video etc. Audio and video
     * content should include full alternative descriptions (eg audio-described video) and transcript, subtitles or
     * captions (whether closed or open) suitable for hearing-impaired as well as for visually-impaired readers. (Purely
     * decorative non-text content can be ignored, but the accessibility of resources delivered via a network connection
     * rather than as part of the e-publication package must be included)
     */
    Full_alternative_textual_descriptions("15", "Full alternative textual descriptions"),

    /**
     * Where data visualisations are provided (eg graphs and charts), the underlying data is also available in
     * non-graphical (usually tabular, textual) form
     */
    Visualised_data_also_available_as_non_graphical_data("16", "Visualised data also available as non-graphical data"),

    /**
     * Mathematical content such as equations is usable with assistive technology, through use of MathML. Semantic
     * MathML is preferred but Presentational MathML is acceptable
     */
    Accessible_math_content_as_MathML("17", "Accessible math content as MathML"),

    /**
     * Chemistry content such as chemical formulae is usable with assistive technology, through use of ChemML
     */
    Accessible_chemistry_content_as_ChemML("18", "Accessible chemistry content as ChemML"),

    /**
     * For a reflowable e-publication, contains references to the page numbering of an equivalent printed product, page
     * number navigation based on print-equivalent page numbers or digital-only static page breaks. Use
     * &lt;RelatedProduct&gt; with relation code 13 to specify an identifier for the source of the page numbers
     */
    Print_equivalent_page_numbering("19", "Print-equivalent page numbering"),

    /**
     * Text-synchronised pre-recorded audio narration (natural or synthesised voice) is included for substantially all
     * textual matter, including all alternative descriptions, eg via a SMIL media overlay
     */
    Synchronised_pre_recorded_audio("20", "Synchronised pre-recorded audio"),

    /**
     * Text-to-speech has been optimised through provision of PLS lexicons, SSML or CSS Speech synthesis hints or other
     * speech synthesis markup languages or hinting
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
     * relevant, should be listed in &lt;ProductFormFeatureDescription&gt;. Use with &lt;EditionType&gt; code HRE as
     * appropriate
     */
    Dyslexia_readability("24", "Dyslexia readability"),

    /**
     * For readers with color vision deficiency, use of color (eg in diagrams, graphs and charts, in prompts or on
     * buttons inviting a response) is not the sole means of graphical distinction or of conveying information. Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Use_of_color_is_not_sole_means_of_conveying_information("25",
        "Use of color is not sole means of conveying information"),

    /**
     * Body text is presented with a contrast ratio of at least 4.5:1 (or 3:1 for large/heading text). Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Use_of_high_contrast_between_text_and_background_color("26",
        "Use of high contrast between text and background color"),

    /**
     * Foreground audio content (eg voice) is presented with no or low background noise (eg ambient sounds, music), at
     * least 20dB below the level of the foreground, or background noise can be switched off (eg via an alternative
     * audio track). Brief and occasional sound effects may be as loud as foreground voice so long as they are isolated
     * from the foreground. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Use_of_high_contrast_between_foreground_and_background_audio("27",
        "Use of high contrast between foreground and background audio"),

    /**
     * All or substantially all non-text content has full alternative descriptions as pre-recorded audio. Note this
     * applies to normal images (eg photographs, charts and diagrams) and also to any embedded video etc. Video content
     * should include full alternative descriptions (eg audio-described video) and transcript, subtitles or captions
     * (whether closed or open) suitable for hearing-impaired as well as for visually-impaired readers. (Purely
     * decorative non-text content can be ignored, but the accessibility of resources delivered via a network connection
     * rather than as part of the e-publication package must be included). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Full_alternative_audio_descriptions("28", "Full alternative audio descriptions"),

    /**
     * All levels of heading and other structural elements of the content are correctly marked up and (if applicable)
     * numbered, to enable fast next heading / previous heading, next chapter / previous chapter navigation without
     * returning to the table of contents. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Next_Previous_structural_navigation("29", "Next / Previous structural navigation"),

    /**
     * Accessible Rich Internet Applications (ARIA) roles (including associated states and properties) are used to
     * organize and improve the structural or landmark navigation of the publication (eg to identify key sections of the
     * content and the purpose of hyperlinks). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    ARIA_roles_provided("30", "ARIA roles provided"),

    /**
     * Where interactive content is included in the product, controls are provided (eg for speed, pause and resume,
     * reset) and labelled to make their use clear. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Accessible_controls_provided("31", "Accessible controls provided"),

    /**
     * E-publication includes basic landmark navigation (usually less detailed than TOC-based navigation). Only for use
     * in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Landmark_navigation("32", "Landmark navigation"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Accessible_chemistry_content_as_MathML("34", "Accessible chemistry content (as MathML)"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Accessible_math_content_as_LaTeX("35", "Accessible math content (as LaTeX)"),

    /**
     * E-publication does not restrict the ability of users to modify and reflow the display of any textual content to
     * the full extent allowed by the reading system (eg to change the text size or typeface, line height and word
     * spacing, colors). Only for use in ONIX 3.0 or later. Compare with code 10 which applies to a broader range of
     * content types
     * <p>
     * JONIX adds: Not included in Onix2
     */
    All_textual_content_can_be_modified("36", "All textual content can be modified"),

    /**
     * Body text is presented with a contrast ratio of at least 7:1 (or 4.5:1 for large/heading text). Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Use_of_ultra_high_contrast_between_text_foreground_and_background("37",
        "Use of ultra-high contrast between text foreground and background"),

    /**
     * E-publication provides explanations for unusual words, abbreviations, acronyms, idioms, jargon in an accessible
     * form, such as glossaries, scripted pop-ups. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unusual_words_or_abbreviations_explained("38", "Unusual words or abbreviations explained"),

    /**
     * All supplementary visual or textual material necessary for understanding of an audiobook, is available as
     * pre-recorded audio, or has full alternative text that can be read via text-to- speech. Only for use in ONIX 3.0
     * or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Supplementary_material_to_an_audiobook_is_accessible("39", "Supplementary material to an audiobook is accessible"),

    /**
     * Where links, controls or buttons are included in the product, the purpose or functionality of each link, control
     * or button is apparent from the associated text alone - or where it is unclear, separate link, control or button
     * descriptions are provided. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Link_purposes_clear("40", "Link purposes clear"),

    /**
     * All contents of the digital publication necessary to use and understanding, including any text, images (via
     * alternative descriptions), video (via audio description) is fully accessible via suitable audio reproduction. The
     * entire publication can be navigated and 'read' using only pre-recorded sound, and does not require visual or
     * tactile perception. NB this implies that all &lt;ProductContent&gt; types listed can be accessed without sight.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    All_non_decorative_content_supports_reading_via_pre_recorded_audio("51",
        "All non-decorative content supports reading via pre-recorded audio"),

    /**
     * Sometimes termed 'screen reader-friendly', and fully supports multiple forms of non-visual reading. All contents
     * of the digital publication necessary to use and understanding, including text, images (via their alternative
     * descriptions), audio and video material (via their transcripts, descriptions, captions or subtitles) are fully
     * accessible via suitable reading devices, for example text-to-speech screen readers or tactile reading devices
     * ('Braille displays'), and nothing in the digital publication prevents or blocks the use of alternative reading
     * modes. The entire publication can be navigated and 'read' using only text rendered via sound or touch, and does
     * not require visual perception. NB this implies that all &lt;ProductContent&gt; types listed can be accessed
     * without sight. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    All_non_decorative_content_supports_reading_without_sight("52",
        "All non-decorative content supports reading without sight"),

    /**
     * Digital product falls under European Accessibility Act exception for Micro-enterprises (as defined by current
     * regulations). The product may not have to comply with requirements of the EAA if the publisher is a
     * micro-enterprise. &lt;ProductFormFeatureDescription&gt; may carry details justifying the exception claim. Use for
     * example with code 09. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EAA_exception_1_Micro_enterprises("75", "EAA exception 1 – Micro-enterprises"),

    /**
     * Digital product falls under European Accessibility Act exception for Disproportionate burden (as defined by
     * current regulations). The product may not have to comply with requirements of the EAA if doing so would
     * financially overburden the publisher. &lt;ProductFormFeatureDescription&gt; may carry details justifying the
     * exception claim. Use for example with code 09. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EAA_exception_2_Disproportionate_burden("76", "EAA exception 2 – Disproportionate burden"),

    /**
     * Digital product falls under European Accessibility Act exception for Fundamental alteration (as defined by
     * current regulations). The product may not have to comply with requirements of the EAA if doing so requires a
     * fundamental modification of the nature of the product or service. &lt;ProductFormFeatureDescription&gt; may carry
     * details justifying the exception claim. Use for example with code 09. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EAA_exception_3_Fundamental_alteration("77", "EAA exception 3 – Fundamental alteration"),

    /**
     * Conforms with the requirements of WCAG version 2.0 - see https://www.w3.org/WAI/standards-guidelines/wcag/.
     * &lt;ProductFormFeatureDescription&gt; may carry a URL linking to a compliance report or certification provided by
     * an independent third-party certifier. In the absence of a URL, conformance with the requirements of the
     * Specification is self-certified by the publisher. Should be used in combination with code 04. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_v2_0("80", "WCAG v2.0"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_v2_1("81", "WCAG v2.1"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_v2_2("82", "WCAG v2.2"),

    /**
     * Conforms with the requirements of WCAG level A. &lt;ProductFormFeatureDescription&gt; may carry a URL linking to
     * a compliance report or certification provided by an independent third-party certifier. In the absence of a URL,
     * conformance with the requirements of the Specification is self-certified by the publisher. Should be used in
     * combination with code 04. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_level_A("84", "WCAG level A"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_level_AA("85", "WCAG level AA"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    WCAG_level_AAA("86", "WCAG level AAA"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the name of the organization responsible for compliance testing and
     * certification of the product. See code 93 for the URL of the organization, which should also be provided. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Compliance_certification_by_name("90", "Compliance certification by (name)"),

    /**
     * &lt;ProductFormFeatureDescription&gt; contains a date in the YYYYMMDD format of the latest assessment or
     * re-assessment of the accessibility of the product. (Note that changes to or re-confirmation of individual
     * accessibility features, standards conformance or certification may be highlighted with a timestamp attribute on
     * the relevant repeat of &lt;ProductFormFeature&gt;). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Latest_accessibility_assessment_date("91", "Latest accessibility assessment date"),

    /**
     * &lt;ProductFormFeatureDescription&gt; contains a short addendum to the accessibility detail of the product, or
     * the URL of a web page comprising such an addendum, providing further details of the specific conformance and
     * features derails provided. The addendum should be considered additional to the more structured data. A complete
     * Accessibility summary (including information that is duplicated in the structured data) should be provided using
     * code 00. Further detailed information may be provided in an external file using codes 94-96. Only for use in ONIX
     * 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Accessibility_addendum("92", "Accessibility addendum"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page belonging to an organization responsible for
     * compliance testing and certification of the product - typically a 'home page' or a page describing the
     * certification scheme itself. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Compliance_certification_by_URL("93", "Compliance certification by (URL)"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing, certification etc relevant to this product. The web page should
     * be maintained by an independent compliance scheme or testing organization. Note the web page may include
     * information about specific national requirements or voluntary conformance reports
     */
    Compliance_web_page_for_detailed_accessibility_information("94",
        "Compliance web page for detailed accessibility information"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing etc relevant to this product. The web page should be provided by a
     * trusted intermediary or third party nominated by the publisher. Note the web page can include information about
     * specific national requirements or voluntary conformance reports
     */
    Trusted_intermediarys_web_page_for_detailed_accessibility_information("95",
        "Trusted intermediary’s web page for detailed accessibility information"),

    /**
     * &lt;ProductFormFeatureDescription&gt; carries the URL of a web page giving further detailed description of the
     * accessibility features, compatibility, testing etc relevant to this product. The web page should be provided by
     * the publisher. Note the web page can include information about specific national requirements or voluntary
     * conformance reports
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
