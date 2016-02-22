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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 33</b>
 * <p>
 * Description: Other text type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist33">ONIX
 *      Codelist 33 in Reference Guide</a>
 */
public enum OtherTextTypes implements OnixCodelist
{
	Main_description("01", "Main description"), //

	/**
	 * Limited to a maximum of 350 characters
	 */
	Short_description_annotation("02", "Short description/annotation"), //

	Long_description("03", "Long description"), //

	/**
	 * Used for a table of contents sent as a single text field, which may or may not carry structure expressed through
	 * HTML etc. Alternatively, a fully structured table of contents may be sent by using the &lt;ContentItem&gt;
	 * composite
	 */
	Table_of_contents("04", "Table of contents"), //

	/**
	 * A review quote that is restricted to a maximum length agreed between the sender and receiver of an ONIX file
	 */
	Review_quote_restricted_length("05", "Review quote, restricted length"), //

	/**
	 * A review quote taken from a review of a previous edition of the work
	 */
	Quote_from_review_of_previous_edition("06", "Quote from review of previous edition"), //

	/**
	 * Full text of a review of the product
	 */
	Review_text("07", "Review text"), //

	/**
	 * A quote from a review of the product
	 */
	Review_quote("08", "Review quote"), //

	/**
	 * A promotional phrase which is intended to headline a description of the product
	 */
	Promotional_headline_("09", "Promotional ‘headline’"), //

	/**
	 * A quote from a review of a previous work by the same author(s) or in the same series
	 */
	Previous_review_quote("10", "Previous review quote"), //

	/**
	 * May be part of Reading Group Guide material: for other commentary, see code 42
	 */
	Author_comments("11", "Author comments"), //

	Description_for_reader("12", "Description for reader"), //

	/**
	 * A note referring to all contributors to a product - NOT linked to a single contributor
	 */
	Biographical_note("13", "Biographical note"), //

	/**
	 * For linking to a complete Reading Group Guide, see code 41
	 */
	Description_for_Reading_Group_Guide("14", "Description for Reading Group Guide"), //

	/**
	 * Each instance must carry a single question: for linking to a complete Reading Group Guide, see code 41
	 */
	Discussion_question_for_Reading_Group_Guide("15", "Discussion question for Reading Group Guide"), //

	/**
	 * Free text listing of other titles with which the product is in competition: although this text might not appear
	 * in 'public' ONIX records, it could be required where ONIX Is used as a communication format within a group of
	 * publishing and distribution companies
	 */
	Competing_titles("16", "Competing titles"), //

	Flap_copy("17", "Flap copy"), //

	Back_cover_copy("18", "Back cover copy"), //

	/**
	 * Text describing a feature of a product to which the publisher wishes to draw attention for promotional purposes.
	 * Each separate feature should be described by a separate repeat, so that formatting can be applied at the
	 * discretion of the receiver of the ONIX record
	 */
	Feature("19", "Feature"), //

	/**
	 * As code 19, but used for a feature which is new in a new edition of the product
	 */
	New_feature("20", "New feature"), //

	/**
	 * A statement included by a publisher in fulfillment of its contractual obligations, such as a disclaimer, sponsor
	 * statement, or legal notice of any sort. Note that the inclusion of such a notice cannot and does not imply that a
	 * user of the ONIX record is obliged to reproduce it
	 */
	Publisher_s_notice("21", "Publisher’s notice"), //

	Index("22", "Index"), //

	Excerpt_from_book("23", "Excerpt from book"), //

	First_chapter("24", "First chapter"), //

	Description_for_sales_people("25", "Description for sales people"), //

	Description_for_press_or_other_media("26", "Description for press or other media"), //

	Description_for_subsidiary_rights_department("27", "Description for subsidiary rights department"), //

	Description_for_teachers_educators("28", "Description for teachers/educators"), //

	/**
	 * A quote usually provided by a celebrity to promote a new book, not from a review
	 */
	Unpublished_endorsement("30", "Unpublished endorsement"), //

	Description_for_bookstore("31", "Description for bookstore"), //

	Description_for_library("32", "Description for library"), //

	Introduction_or_preface("33", "Introduction or preface"), //

	Full_text("34", "Full text"), //

	/**
	 * Promotional text not covered elsewhere
	 */
	Promotional_text("35", "Promotional text"), //

	Author_interview_QandA("40", "Author interview / QandA"), //

	/**
	 * Complete guide: see also codes 14 and 15
	 */
	Reading_Group_Guide("41", "Reading Group Guide"), //

	/**
	 * Other than author comments: see code 11
	 */
	Commentary_discussion("42", "Commentary / discussion"), //

	/**
	 * (of which the product is a part.) Limited to a maximum of 350 characters
	 */
	Short_description_for_series_or_set("43", "Short description for series or set"), //

	/**
	 * (of which the product is a part)
	 */
	Long_description_for_series_or_set("44", "Long description for series or set"), //

	/**
	 * Link to a schedule in iCalendar format
	 */
	Contributor_event_schedule("45", "Contributor event schedule"), //

	/**
	 * Link to a license covering permitted usage of the product content
	 */
	License("46", "License"), //

	/**
	 * Short summary statement of open access status and any related conditions (eg 'Open access - no commercial use'),
	 * primarily for marketing purposes. Should always be accompanied by a link to the complete license (see code 46)
	 */
	Open_access_statement("47", "Open access statement"), //

	/**
	 * Short summary statement that the product is available only in digital formats (eg 'Digital exclusive'). If a
	 * non-digital version is planned, an &lt;EndDate&gt; should be used to specify the date when exclusivity will end.
	 * If a non-digital version is available, the statement should not be included &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Digital_exclusivity_statement("48", "Digital exclusivity statement"), //

	/**
	 * For example a recommendation or approval provided by a ministry of education or other official body. Use
	 * &lt;Text&gt; to provide details and &lt;TextSourceCorporate&gt; to name the approver &lt;p&gt;NOTE: Introduced in
	 * Onix3
	 */
	Official_recommendation("49", "Official recommendation"), //

	/**
	 * A master brand name or title, where the use of the brand spans multiple sets, series and product forms, and
	 * possibly multiple imprints and publishers. Used only for branded media properties carrying, for example, a
	 * children's character brand. (This functionality is provided as a workaround in ONIX 2.1 only. ONIX 3.0 has
	 * specific provision for master brands as title elements
	 */
	Master_brand_name("98", "Master brand name"), //

	/**
	 * A single ISO 3166-1 country code from List 91 designating the country of final manufacture of the product. (This
	 * functionality is provided as a workaround in ONIX 2.1. ONIX 3.0 has specific provision for country of manufacture
	 * as a separate element)
	 */
	Country_of_final_manufacture("99", "Country of final manufacture");

	public final String code;
	public final String description;

	private OtherTextTypes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static Map<String, OtherTextTypes> map;

	private static Map<String, OtherTextTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (OtherTextTypes e : values())
				map.put(e.code, e);
		}
		return map;
	}

	public static OtherTextTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
