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
 * marker interface to assist in IDE navigation to code-list 73 (Website role)
 */
interface CodeList73 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 73</b>
 * <p>
 * Description: Website role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist73">ONIX
 *      Codelist 73 in Reference Guide</a>
 */
public enum WebsiteRoles implements OnixCodelist, CodeList73 {
    Unspecified_see_website_description("00", "Unspecified, see website description"),

    /**
     * See also codes 17 and 18
     */
    Publishers_corporate_website("01", "Publisher’s corporate website"),

    /**
     * A publisher's informative and/or promotional webpage relating to a specified work (book, journal, online resource
     * or other publication type)
     */
    Publishers_website_for_a_specified_work("02", "Publisher’s website for a specified work"),

    /**
     * A webpage giving access to an online content hosting service as a whole
     */
    Online_hosting_service_home_page("03", "Online hosting service home page"),

    /**
     * A webpage giving general information about a serial, in print or electronic format or both
     */
    Journal_home_page("04", "Journal home page"),

    /**
     * A webpage giving direct access to the content that is available online for a specified resource version.
     * Generally used for content available online under subscription terms
     */
    Online_resource_available_content_page("05", "Online resource ‘available content’ page"),

    /**
     * A webpage maintained by an author or other contributor about her/his publications and personal background
     */
    Contributors_own_website("06", "Contributor’s own website"),

    /**
     * A publisher's webpage devoted to a specific author or other contributor
     */
    Publishers_website_relating_to_specified_contributor("07", "Publisher’s website relating to specified contributor"),

    /**
     * A webpage devoted to a specific author or other contributor, and maintained by a publisher other than the
     * publisher of the item described in the ONIX record
     */
    Other_publishers_website_relating_to_specified_contributor("08",
        "Other publisher’s website relating to specified contributor"),

    /**
     * A webpage devoted to a specific author or other contributor, and maintained by a third party (eg a fan site)
     */
    Third_party_website_relating_to_specified_contributor("09",
        "Third-party website relating to specified contributor"),

    /**
     * A webpage maintained by an author or other contributor and specific to an individual work
     */
    Contributors_own_website_for_specified_work("10", "Contributor’s own website for specified work"),

    /**
     * A webpage devoted to an individual work, and maintained by a publisher other than the publisher of the item
     * described in the ONIX record
     */
    Other_publishers_website_relating_to_specified_work("11", "Other publisher’s website relating to specified work"),

    /**
     * A webpage devoted to an individual work, and maintained by a third party (eg a fan site)
     */
    Third_party_website_relating_to_specified_work("12", "Third-party website relating to specified work"),

    /**
     * A webpage maintained by an author or other contributor and specific to a group or series of works
     */
    Contributors_own_website_for_group_or_series_of_works("13",
        "Contributor’s own website for group or series of works"),

    /**
     * A publisher's webpage devoted to a group or series of works
     */
    Publishers_website_relating_to_group_or_series_of_works("14",
        "Publisher’s website relating to group or series of works"),

    /**
     * A webpage devoted to a group or series of works, and maintained by a publisher other than the publisher of the
     * item described in the ONIX record
     */
    Other_publishers_website_relating_to_group_or_series_of_works("15",
        "Other publisher’s website relating to group or series of works"),

    /**
     * A webpage devoted to a group or series of works, and maintained by a third party (eg a fan site)
     */
    Third_party_website_relating_to_group_or_series_of_works_eg_a_fan_site("16",
        "Third-party website relating to group or series of works (eg a fan site)"),

    /**
     * Use instead of code 01 to specify a publisher's website for trade users
     */
    Publishers_B2B_website("17", "Publisher’s B2B website"),

    /**
     * Use instead of code 01 to specify a publisher's website for end customers (consumers)
     */
    Publishers_B2C_website("18", "Publisher’s B2C website"),

    /**
     * For example, a Blogger or Tumblr URL, a Wordpress website or other blog URL
     */
    Author_blog("23", "Author blog"),

    Web_page_for_author_presentation_commentary("24", "Web page for author presentation / commentary"),

    Web_page_for_author_interview("25", "Web page for author interview"),

    Web_page_for_author_reading("26", "Web page for author reading"),

    Web_page_for_cover_material("27", "Web page for cover material"),

    Web_page_for_sample_content("28", "Web page for sample content"),

    /**
     * Use this value in the &lt;Website&gt; composite (typically within &lt;Publisher&gt; or &lt;SupplyDetail&gt;) when
     * sending a link to a webpage at which a digital product is available for download and/or online access
     */
    Web_page_for_full_content("29", "Web page for full content"),

    /**
     * For example a subscribable podcast hosting site, social media message, newsletter issue, other commentary
     */
    Web_page_for_other_commentary_discussion("30", "Web page for other commentary / discussion"),

    /**
     * URL needed by the German National Library for direct access, harvesting and storage of an electronic resource
     */
    Transfer_URL("31", "Transfer-URL"),

    /**
     * Link needed by German Books in Print (VLB) for DOI registration and ONIX DOI conversion
     */
    DOI_Website_Link("32", "DOI Website Link"),

    /**
     * A corporate website operated by a distributor or other supplier (not the publisher)
     */
    Suppliers_corporate_website("33", "Supplier’s corporate website"),

    /**
     * A website operated by a distributor or other supplier (not the publisher) and aimed at trade customers
     */
    Suppliers_B2B_website("34", "Supplier’s B2B website"),

    /**
     * A website operated by a distributor or other supplier (not the publisher) and aimed at consumers
     */
    Suppliers_B2C_website("35", "Supplier’s B2C website"),

    /**
     * A distributor or supplier's webpage describing a specified work
     */
    Suppliers_website_for_a_specified_work("36", "Supplier’s website for a specified work"),

    /**
     * A distributor or supplier's webpage describing a specified work, and aimed at trade customers
     */
    Suppliers_B2B_website_for_a_specified_work("37", "Supplier’s B2B website for a specified work"),

    /**
     * A distributor or supplier's webpage describing a specified work, and aimed at consumers
     */
    Suppliers_B2C_website_for_a_specified_work("38", "Supplier’s B2C website for a specified work"),

    /**
     * A distributor or supplier's webpage describing a group or series of works
     */
    Suppliers_website_for_a_group_or_series_of_works("39", "Supplier’s website for a group or series of works"),

    /**
     * For example an ONIX or MARC record for the product, available online
     */
    URL_of_full_metadata_description("40", "URL of full metadata description"),

    /**
     * For example, a Facebook, Google+, Instagram, Youtube, Pinterest, Tiktok, Twitter or similar URL for the product
     * or work
     */
    Social_networking_URL_for_specific_work_or_product("41", "Social networking URL for specific work or product"),

    /**
     * For example, a Facebook, Google+, Instagram, Youtube, Pinterest, Tiktok, Twitter or similar page
     */
    Authors_social_networking_URL("42", "Author’s social networking URL"),

    /**
     * For example, a Facebook, Google+, Instagram, Youtube, Pinterest, Tiktok, Twitter or similar page
     */
    Publishers_social_networking_URL("43", "Publisher’s social networking URL"),

    /**
     * For example, a Facebook, Google+, Instagram, Youtube, Pinterest, Tiktok, Twitter or similar page. Use only in the
     * context of a specific content item (eg within &lt;ContentItem&gt;)
     */
    Social_networking_URL_for_specific_article_chapter_or_content_item("44",
        "Social networking URL for specific article, chapter or content item"),

    /**
     * For example, a service offering click-through licensing of extracts
     */
    Publishers_or_third_party_website_for_permissions_requests("45",
        "Publisher’s or third party website for permissions requests"),

    /**
     * For example, a page providing details related to GDPR. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Publishers_or_third_party_website_for_privacy_statement("46",
        "Publisher’s or third party website for privacy statement"),

    /**
     * The URL of the publisher's preservation service, or a more specific URL for access to its preserved copy. For use
     * in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Publishers_website_for_digital_preservation("47", "Publisher’s website for digital preservation"),

    /**
     * The URL of the preservation service (eg https://clockss.org), or a more specific URL for access to its preserved
     * copy. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Third_party_website_for_digital_preservation("48", "Third-party website for digital preservation"),

    /**
     * The URL of a web page describing the environmental and sustainability policy, or carbon neutrality status, that
     * applies to the specific product. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Product_website_for_environmental_responsibility_statement("49",
        "Product website for environmental responsibility statement"),

    /**
     * The URL of a web page describing the environmental and sustainability policies, carbon neutrality status, etc of
     * the organisation (publisher, supplier etc). For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Organisations_website_for_environmental_responsibility_statement("50",
        "Organisation’s website for environmental responsibility statement");

    public final String code;
    public final String description;

    WebsiteRoles(String code, String description) {
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

    private static volatile Map<String, WebsiteRoles> map;

    private static Map<String, WebsiteRoles> map() {
        Map<String, WebsiteRoles> result = map;
        if (result == null) {
            synchronized (WebsiteRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (WebsiteRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static WebsiteRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
