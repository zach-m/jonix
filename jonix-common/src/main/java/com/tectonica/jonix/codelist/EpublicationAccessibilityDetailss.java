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
 * Enum that corresponds to ONIX's CodeList196
 * <p>
 * E-publication Accessibility Details
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum EpublicationAccessibilityDetailss
{
	LIA_Compliance_Scheme("01"), //

	/**
	 * No accessibility features offered by the reading system, device or reading software (including but not limited to choice of text size
	 * or typeface, choice of text or background color, text-to-speech) are disabled, overridden or otherwise unusable with the product
	 * EXCEPT – in ONIX 3 messages only – those specifically noted as subject to restriction or prohibition in <EpubUsageConstraint>. Note
	 * that provision of any significant part of the textual content as images (ie as pictures of text, rather than as text) inevitably
	 * prevents use of these accessibility options.
	 */
	No_reading_system_accessibility_options_disabled_except("10"), //

	/**
	 * Table of contents allows direct (eg hyperlinked) access to all levels of text organization above individual paragraphs (eg to all
	 * sections and subsections) and to all tables, figures, illustrations etc. Non-textual items such as illustrations, tables, audio or
	 * video content may be directly accessible from the Table of contents, or from a similar List of illustrations, List of tables, etc.
	 */
	Table_of_contents_navigation("11"), //

	/**
	 * Index provides direct (eg hyperlinked) access to uses of the index terms in the document body.
	 */
	Index_navigation("12"), //

	/**
	 * All or substantially all textual matter is arranged in a single logical reading order (including text that is visually presented as
	 * separate from the main text flow, eg in boxouts, captions, tables, footnotes, endnotes, citations, etc). Non-textual content is also
	 * linked from within this logical reading order. (Purely decorative non-text content can be ignored.)
	 */
	Reading_order("13"), //

	/**
	 * All or substantially all non-text content has short alternative descriptions, usually provided via alt attributes. Note this applies
	 * to normal images (eg photographs, charts and diagrams) and also to any embedded audio, video etc. Audio and video content should
	 * include alternative descriptions suitable for hearing-impaired as well as for visually-impaired readers. (Purely decorative non-text
	 * content can be ignored, but the accessibility of resources delivered via a network connection rather than as part of the
	 * e-publication package must be included.)
	 */
	Short_alternative_descriptions("14"), //

	/**
	 * All or substantially all non-text content has full alternative descriptions. Note this applies to normal images (eg photographs,
	 * charts and diagrams) and also to any embedded audio, video etc. Audio and video content should include full alternative descriptions
	 * (eg audio-described video) and subtitles or closed captions suitable for hearing-impaired as well as for visually-impaired readers.
	 * (Purely decorative non-text content can be ignored, but the accessibility of resources delivered via a network connection rather than
	 * as part of the e-publication package must be included.)
	 */
	Full_alternative_descriptions("15"), //

	/**
	 * Where data visualisations are provided (eg graphs and charts), the underlying data is also available in non-graphical (usually
	 * tabular, textual) form.
	 */
	Visualised_data_also_available_as_non_graphical_data("16"), //

	/**
	 * Mathematical content such as equations is usable with assistive technology, eg through use of MathML. Semantic MathML is preferred
	 * but Presentational MathML is acceptable.
	 */
	Accessible_math_content("17"), //

	/**
	 * Chemistry content such as chemical formulae is usable with assistive technology, eg through use of ChemML.
	 */
	Accessible_chem_content("18"), //

	/**
	 * For a reflowable e-publication, contains references to the page numbering of an equivalent printed product.
	 */
	Print_equivalent_page_numbering("19"), //

	/**
	 * Text-synchronised pre-recorded audio narration (natural or synthesised voice) is included for substantially all textual matter,
	 * including all alternative descriptions.
	 */
	Synchronised_pre_recorded_audio("20"), //

	/**
	 * Text-to-speech has been optimised through provision of PLS lexicons, SSML or CSS Speech synthesis hints.
	 */
	Text_to_speech_hinting_provided("21"), //

	/**
	 * The language of the text has been specified (eg via the HTML or XML lang attribute) to optimise text-to-speech (and other alternative
	 * renderings), both at whole document level and, where appropriate, for individual words, phrases or passages in a different language.
	 */
	Language_tagging_provided("22"), //

	/**
	 * <ProductFormFeatureDescription> carries the URL of a web page giving further detailed description of the accessibility features,
	 * compatibility, testing etc. The web page should be maintained by an independent compliance scheme or testing organization.
	 */
	Compliance_web_page_for_detailed_accessibility_information("94"), //

	/**
	 * <ProductFormFeatureDescription> carries the URL of a web page giving further detailed description of the accessibility features,
	 * compatibility, testing etc. The web page should be provided by a trusted intermediary or third party nominated by the publisher.
	 */
	Trusted_intermediary_s_web_page_for_detailed_accessibility_information("95"), //

	/**
	 * <ProductFormFeatureDescription> carries the URL of a web page giving further detailed description of the accessibility features,
	 * compatibility, testing etc. The web page should be provided by the publisher.
	 */
	Publisher_s_web_page_for_detailed_accessibility_information("96"), //

	/**
	 * <ProductFormFeatureDescription> carries a short description of compatibility testing carried out for this product, including detailed
	 * compatibility with various assistive technology such as third-party screen-reading software.
	 */
	Compatibility_tested("97"), //

	/**
	 * <ProductFormFeatureDescription> carries the e-mail address for a contact at a ‘trusted intermediary’, to whom detailed questions
	 * about accessibility for this product may be directed.
	 */
	Trusted_Intermediary_contact("98"), //

	/**
	 * <ProductFormFeatureDescription> carries the e-mail address for a contact at the publisher to whom detailed questions about
	 * accessibility of this product may be directed.
	 */
	Publisher_contact_for_further_accessibility_information("99");

	public final String value;

	private EpublicationAccessibilityDetailss(String value)
	{
		this.value = value;
	}

	private static Map<String, EpublicationAccessibilityDetailss> map;

	private static Map<String, EpublicationAccessibilityDetailss> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (EpublicationAccessibilityDetailss e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static EpublicationAccessibilityDetailss byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
