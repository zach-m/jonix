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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 153</b>
 * <p>
 * Description: Text type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist153">ONIX
 *      Codelist 153 in Reference Guide</a>
 */
public enum TextTypes implements OnixCodelist
{
	/**
	 * To be used only in circumstances where the parties to an exchange have agreed to include text which (a) is not
	 * for general distribution, and (b) cannot be coded elsewhere. If more than one type of text is sent, it must be
	 * identified by tagging within the text itself
	 */
	Sender_defined_text("01", "Sender-defined text"), //

	/**
	 * Limited to a maximum of 350 characters
	 */
	Short_description_annotation("02", "Short description/annotation"), //

	/**
	 * Length unrestricted
	 */
	Description("03", "Description"), //

	/**
	 * Used for a table of contents sent as a single text field, which may or may not carry structure expressed as XHTML
	 */
	Table_of_contents("04", "Table of contents"), //

	/**
	 * Descriptive blurb taken from the back cover and/or flaps
	 */
	Flap_cover_copy("05", "Flap / cover copy"), //

	/**
	 * A quote taken from a review of the product or of the work in question where there is no need to take account of
	 * different editions
	 */
	Review_quote("06", "Review quote"), //

	/**
	 * A quote taken from a review of a previous edition of the work
	 */
	Review_quote_previous_edition("07", "Review quote: previous edition"), //

	/**
	 * A quote taken from a review of a previous work by the same author(s) or in the same series
	 */
	Review_quote_previous_work("08", "Review quote: previous work"), //

	/**
	 * A quote usually provided by a celebrity or another author to promote a new book, not from a review
	 */
	Endorsement("09", "Endorsement"), //

	/**
	 * A promotional phrase which is intended to headline a description of the product
	 */
	Promotional_headline("10", "Promotional headline"), //

	/**
	 * Text describing a feature of a product to which the publisher wishes to draw attention for promotional purposes.
	 * Each separate feature should be described by a separate repeat, so that formatting can be applied at the
	 * discretion of the receiver of the ONIX record, or multiple features can be described using appropriate XHTML
	 * markup
	 */
	Feature("11", "Feature"), //

	/**
	 * A note referring to all contributors to a product - NOT linked to a single contributor
	 */
	Biographical_note("12", "Biographical note"), //

	/**
	 * A statement included by a publisher in fulfillment of contractual obligations, such as a disclaimer, sponsor
	 * statement, or legal notice of any sort. Note that the inclusion of such a notice cannot and does not imply that a
	 * user of the ONIX record is obliged to reproduce it
	 */
	Publisher_s_notice("13", "Publisher’s notice"), //

	/**
	 * A short excerpt from the work
	 */
	Excerpt("14", "Excerpt"), //

	/**
	 * Used for an index sent as a single text field, which may be structured using XHTML
	 */
	Index("15", "Index"), //

	/**
	 * (of which the product is a part.) Limited to a maximum of 350 characters
	 */
	Short_description_annotation_for_collection("16", "Short description/annotation for collection"), //

	/**
	 * (of which the product is a part.) Length unrestricted
	 */
	Description_for_collection("17", "Description for collection"), //

	/**
	 * As code 11 but used for a new feature of this edition or version
	 */
	New_feature("18", "New feature"), //

	Version_history("19", "Version history"), //

	/**
	 * Short summary statement of open access status and any related conditions (eg 'Open access - no commercial use'),
	 * primarily for marketing purposes. Should always be accompanied by a link to the complete license (see
	 * &lt;EpubLicense&gt; or code 99 in List 158)
	 */
	Open_access_statement("20", "Open access statement"), //

	/**
	 * Short summary statement that the product is available only in digital formats (eg 'Digital exclusive'). If a
	 * non-digital version is planned, &lt;ContentDate&gt; should be used to specify the date when exclusivity will end
	 * (use content date role code 15). If a non-digital version is available, the statement should not be included
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Digital_exclusivity_statement("21", "Digital exclusivity statement"), //

	/**
	 * For example a recommendation or approval provided by a ministry of education or other official body. Use
	 * &lt;Text&gt; to provide details and ideally use &lt;TextSourceCorporate&gt; to name the approver &lt;p&gt;NOTE:
	 * Introduced in Onix3
	 */
	Official_recommendation("22", "Official recommendation"), //

	/**
	 * Short description in format specified by Japanese Book Publishers Association &lt;p&gt;NOTE: Introduced in Onix3
	 */
	JBPA_description("23", "JBPA description");

	public final String code;
	public final String description;

	private TextTypes(String code, String description)
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

	private static Map<String, TextTypes> map;

	private static Map<String, TextTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (TextTypes e : values())
				map.put(e.code, e);
		}
		return map;
	}

	public static TextTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
