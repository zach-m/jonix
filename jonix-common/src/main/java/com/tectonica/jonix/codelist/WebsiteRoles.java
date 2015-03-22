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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList73
 * <p>
 * Website role
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum WebsiteRoles
{
	Unspecified_see_website_description("00"), //

	/**
	 * See also codes 17 and 18.
	 */
	Publisher_s_corporate_website("01"), //

	/**
	 * A publisher’s informative and/or promotional webpage relating to a specified work (book, journal, online resource or other
	 * publication type).
	 */
	Publisher_s_website_for_a_specified_work("02"), //

	/**
	 * A webpage giving access to an online content hosting service as a whole.
	 */
	Online_hosting_service_home_page("03"), //

	/**
	 * A webpage giving general information about a serial, in print or electronic format or both.
	 */
	Journal_home_page("04"), //

	/**
	 * A webpage giving direct access to the content that is available online for a specified resource version. Generally used for content
	 * available online under subscription terms.
	 */
	Online_resource_available_content_page("05"), //

	/**
	 * A webpage maintained by an author or other contributor about her/his publications and personal background.
	 */
	Contributor_s_own_website("06"), //

	/**
	 * A publisher’s webpage devoted to a specific author or other contributor.
	 */
	Publisher_s_website_relating_to_specified_contributor("07"), //

	/**
	 * A webpage devoted to a specific author or other contributor, and maintained by a publisher other than the publisher of the item
	 * described in the ONIX record.
	 */
	Other_publisher_s_website_relating_to_specified_contributor("08"), //

	/**
	 * A webpage devoted to a specific author or other contributor, and maintained by a third party (eg a fan site).
	 */
	Third_party_website_relating_to_specified_contributor("09"), //

	/**
	 * A webpage maintained by an author or other contributor and specific to an individual work.
	 */
	Contributor_s_own_website_for_specified_work("10"), //

	/**
	 * A webpage devoted to an individual work, and maintained by a publisher other than the publisher of the item described in the ONIX
	 * record.
	 */
	Other_publisher_s_website_relating_to_specified_work("11"), //

	/**
	 * A webpage devoted to an individual work, and maintained by a third party (eg a fan site).
	 */
	Third_party_website_relating_to_specified_work("12"), //

	/**
	 * A webpage maintained by an author or other contributor and specific to a group or series of works.
	 */
	Contributor_s_own_website_for_group_or_series_of_works("13"), //

	/**
	 * A publisher’s webpage devoted to a group or series of works.
	 */
	Publisher_s_website_relating_to_group_or_series_of_works("14"), //

	/**
	 * A webpage devoted to a group or series of works, and maintained by a publisher other than the publisher of the item described in the
	 * ONIX record.
	 */
	Other_publisher_s_website_relating_to_group_or_series_of_works("15"), //

	/**
	 * A webpage devoted to a group or series of works, and maintained by a third party (eg a fan site).
	 */
	Third_party_website_relating_to_group_or_series_of_works_eg_a_fan_site("16"), //

	/**
	 * Use instead of code 01 to specify a publisher’s website for trade users.
	 */
	Publisher_s_B2B_website("17"), //

	/**
	 * Use instead of code 01 to specify a publisher’s website for end customers (consumers).
	 */
	Publisher_s_B2C_website("18"), //

	/**
	 * For example, a Blogger or Tumblr URL, a Wordpress website or other blog URL.
	 */
	Author_blog("23"), //

	Web_page_for_author_presentation_commentary("24"), //

	Web_page_for_author_interview("25"), //

	Web_page_for_author_reading("26"), //

	Web_page_for_cover_material("27"), //

	Web_page_for_sample_content("28"), //

	/**
	 * Use this value in the <Website> composite in <SupplyDetail> when sending a link to a webpage at which a digital product is available
	 * for download and/or online access.
	 */
	Web_page_for_full_content("29"), //

	Web_page_for_other_commentary_discussion("30"), //

	/**
	 * URL needed by the German National Library for direct access, harvesting and storage of an electronic resource.
	 */
	Transfer_URL("31"), //

	/**
	 * Link needed by German Books in Print (VLB) for DOI registration and ONIX DOI conversion.
	 */
	DOI_Website_Link("32"), //

	/**
	 * A corporate website operated by a distributor or other supplier (not the publisher).
	 */
	Supplier_s_corporate_website("33"), //

	/**
	 * A website operated by a distributor or other supplier (not the publisher) and aimed at trade customers.
	 */
	Supplier_s_B2B_website("34"), //

	/**
	 * A website operated by a distributor or other supplier (not the publisher) and aimed at consumers.
	 */
	Supplier_s_B2C_website("35"), //

	/**
	 * A distributor or supplier’s webpage describing a specified work.
	 */
	Supplier_s_website_for_a_specified_work("36"), //

	/**
	 * A distributor or supplier’s webpage describing a specified work, and aimed at trade customers.
	 */
	Supplier_s_B2B_website_for_a_specified_work("37"), //

	/**
	 * A distributor or supplier’s webpage describing a specified work, and aimed at consumers.
	 */
	Supplier_s_B2C_website_for_a_specified_work("38"), //

	/**
	 * A distributor or supplier’s webpage describing a group or series of works.
	 */
	Supplier_s_website_for_a_group_or_series_of_works("39"), //

	/**
	 * For example an ONIX or MARC record for the product, available online.
	 */
	URL_of_full_metadata_description("40"), //

	/**
	 * For example, a Facebook, Google+ or Twitter URL for the product or work.
	 */
	Social_networking_URL_for_specific_work_or_product("41"), //

	/**
	 * For example, a Facebook, Google+ or Twitter page.
	 */
	Author_s_social_networking_URL("42"), //

	/**
	 * For example, a Facebook, Google+ or Twitter page.
	 */
	Publisher_s_social_networking_URL("43"), //

	/**
	 * For example, a Facebook, Google+ or Twitter page. Use only in the context of a specific content item (eg within <ContentItem>).
	 */
	Social_networking_URL_for_specific_article_chapter_or_content_item("44");

	public final String value;

	private WebsiteRoles(String value)
	{
		this.value = value;
	}

	private static Map<String, WebsiteRoles> map;

	private static Map<String, WebsiteRoles> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (WebsiteRoles e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static WebsiteRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
