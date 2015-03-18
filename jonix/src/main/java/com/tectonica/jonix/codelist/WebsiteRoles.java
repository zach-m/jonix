package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 73
 * 
 * @author Zach Melamed
 * 
 */
public enum WebsiteRoles
{
	Unspecified__see_website_description("00"),

	/**
	 * See also codes 17 and 18.
	 */
	Publishers_corporate_website("01"),

	/**
	 * A publisher’s informative and/or promotional webpage relating to a specified work (book, journal, online resource or other publication type).
	 */
	Publishers_website_for_a_specified_work("02"),

	/**
	 * A webpage giving access to an online content hosting service as a whole.
	 */
	Online_hosting_service_home_page("03"),

	/**
	 * A webpage giving general information about a serial, in print or electronic format or both.
	 */
	Journal_home_page("04"),

	/**
	 * A webpage giving direct access to the content that is available online for a specified resource version. Generally used for content available online under subscription terms.
	 */
	Online_resource__available_content_page("05"),

	/**
	 * A webpage maintained by an author or other contributor about her/his publications and personal background.
	 */
	Contributors_own_website("06"),

	/**
	 * A publisher’s webpage devoted to a specific author or other contributor.
	 */
	Publishers_website_relating_to_specified_contributor("07"),

	/**
	 * A webpage devoted to a specific author or other contributor, and maintained by a publisher other than the publisher of the item described in the ONIX record.
	 */
	Other_publishers_website_relating_to_specified_contributor("08"),

	/**
	 * A webpage devoted to a specific author or other contributor, and maintained by a third party (eg a fan site).
	 */
	Thirdparty_website_relating_to_specified_contributor("09"),

	/**
	 * A webpage maintained by an author or other contributor and specific to an individual work.
	 */
	Contributors_own_website_for_specified_work("10"),

	/**
	 * A webpage devoted to an individual work, and maintained by a publisher other than the publisher of the item described in the ONIX record.
	 */
	Other_publishers_website_relating_to_specified_work("11"),

	/**
	 * A webpage devoted to an individual work, and maintained by a third party (eg a fan site).
	 */
	Thirdparty_website_relating_to_specified_work("12"),

	/**
	 * A webpage maintained by an author or other contributor and specific to a group or series of works.
	 */
	Contributors_own_website_for_group_or_series_of_works("13"),

	/**
	 * A publisher’s webpage devoted to a group or series of works.
	 */
	Publishers_website_relating_to_group_or_series_of_works("14"),

	/**
	 * A webpage devoted to a group or series of works, and maintained by a publisher other than the publisher of the item described in the ONIX record.
	 */
	Other_publishers_website_relating_to_group_or_series_of_works("15"),

	/**
	 * A webpage devoted to a group or series of works, and maintained by a third party (eg a fan site).
	 */
	Thirdparty_website_relating_to_group_or_series_of_works_eg_a_fan_site("16"),

	/**
	 * Use instead of code 01 to specify a publisher’s website for trade users.
	 */
	Publishers_B2B_website("17"),

	/**
	 * Use instead of code 01 to specify a publisher’s website for end customers (consumers).
	 */
	Publishers_B2C_website("18"),

	/**
	 * For example, a Blogger or Tumblr URL, a Wordpress website or other blog URL.
	 */
	Author_blog("23"),

	Web_page_for_author_presentation___commentary("24"),

	Web_page_for_author_interview("25"),

	Web_page_for_author_reading("26"),

	Web_page_for_cover_material("27"),

	Web_page_for_sample_content("28"),

	/**
	 * Use this value in the <Website> composite in <SupplyDetail> when sending a link to a webpage at which a digital product is available for download and/or online access.
	 */
	Web_page_for_full_content("29"),

	Web_page_for_other_commentary___discussion("30"),

	/**
	 * URL needed by the German National Library for direct access, harvesting and storage of an electronic resource.
	 */
	TransferURL("31"),

	/**
	 * Link needed by German Books in Print (VLB) for DOI registration and ONIX DOI conversion.
	 */
	DOI_Website_Link("32"),

	/**
	 * A corporate website operated by a distributor or other supplier (not the publisher).
	 */
	Suppliers_corporate_website("33"),

	/**
	 * A website operated by a distributor or other supplier (not the publisher) and aimed at trade customers.
	 */
	Suppliers_B2B_website("34"),

	/**
	 * A website operated by a distributor or other supplier (not the publisher) and aimed at consumers.
	 */
	Suppliers_B2C_website("35"),

	/**
	 * A distributor or supplier’s webpage describing a specified work.
	 */
	Suppliers_website_for_a_specified_work("36"),

	/**
	 * A distributor or supplier’s webpage describing a specified work, and aimed at trade customers.
	 */
	Suppliers_B2B_website_for_a_specified_work("37"),

	/**
	 * A distributor or supplier’s webpage describing a specified work, and aimed at consumers.
	 */
	Suppliers_B2C_website_for_a_specified_work("38"),

	/**
	 * A distributor or supplier’s webpage describing a group or series of works.
	 */
	Suppliers_website_for_a_group_or_series_of_works("39"),

	/**
	 * For example an ONIX or MARC record for the product, available online.
	 */
	URL_of_full_metadata_description("40"),

	/**
	 * For example, a Facebook, Google+ or Twitter URL for the product or work.
	 */
	Social_networking_URL_for_specific_work_or_product("41"),

	/**
	 * For example, a Facebook, Google+ or Twitter page.
	 */
	Authors_social_networking_URL("42"),

	/**
	 * For example, a Facebook, Google+ or Twitter page.
	 */
	Publishers_social_networking_URL("43"),

	/**
	 * For example, a Facebook, Google+ or Twitter page. Use only in the context of a specific content item (eg within <ContentItem>).
	 */
	Social_networking_URL_for_specific_article__chapter_or_content_item("44");

	public final String code;

	private WebsiteRoles(String code)
	{
		this.code = code;
	}

	private static WebsiteRoles[] values = WebsiteRoles.values();
	public static WebsiteRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (WebsiteRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

