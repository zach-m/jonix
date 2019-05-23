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

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 158 (Resource content type)
 */
interface CodeList158 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 158</b>
 * <p>
 * Description: Resource content type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist158">ONIX
 * Codelist 158 in Reference Guide</a>
 */
public enum ResourceContentTypes implements OnixCodelist, CodeList158 {
    /**
     * 2D
     */
    Front_cover("01", "Front cover"), //

    /**
     * 2D
     */
    Back_cover("02", "Back cover"), //

    /**
     * Not limited to front or back, including 3D perspective
     */
    Cover_pack("03", "Cover / pack"), //

    /**
     * Photograph or portrait of contributor(s)
     */
    Contributor_picture("04", "Contributor picture"), //

    Series_image_artwork("05", "Series image / artwork"), //

    Series_logo("06", "Series logo"), //

    Product_image_artwork("07", "Product image / artwork"), //

    Product_logo("08", "Product logo"), //

    Publisher_logo("09", "Publisher logo"), //

    Imprint_logo("10", "Imprint logo"), //

    Contributor_interview("11", "Contributor interview"), //

    /**
     * Contributor presentation and/or commentary
     */
    Contributor_presentation("12", "Contributor presentation"), //

    Contributor_reading("13", "Contributor reading"), //

    /**
     * Link to a schedule in iCalendar format
     */
    Contributor_event_schedule("14", "Contributor event schedule"), //

    /**
     * For example: a short excerpt, sample text or a complete sample chapter, page images, screenshots etc
     */
    Sample_content("15", "Sample content"), //

    /**
     * A 'look inside' feature presented as a small embeddable application
     */
    Widget("16", "Widget"), //

    /**
     * Review text held in a separate downloadable file, not in the ONIX record. Equivalent of code 06 in List 153. Use
     * the &lt;TextContent&gt; composite for review quotes carried in the ONIX record. Use the &lt;CitedContent&gt;
     * composite for a third-party review which is referenced from the ONIX record. Use &lt;SupportingResource&gt; for
     * review text offered as a separate file resource for reproduction as part of promotional material for the product
     */
    Review("17", "Review"), //

    Other_commentary_discussion("18", "Other commentary / discussion"), //

    Reading_group_guide("19", "Reading group guide"), //

    /**
     * Incuding associated teacher / instructor resources
     */
    Teacher_s_guide("20", "Teacher’s guide"), //

    /**
     * Feature article provided by publisher
     */
    Feature_article("21", "Feature article"), //

    /**
     * Fictional character 'interview'
     */
    Character_interview_("22", "Character ‘interview’"), //

    Wallpaper_screensaver("23", "Wallpaper / screensaver"), //

    Press_release("24", "Press release"), //

    /**
     * A table of contents held in a separate downloadable file, not in the ONIX record. Equivalent of code 04 in List
     * 153. Use the &lt;TextContent&gt; composite for a table of contents carried in the ONIX record. Use &lt;Supporting
     * Resource&gt; for text offered as a separate file resource
     */
    Table_of_contents("25", "Table of contents"), //

    /**
     * A promotional video (or audio), similar to a movie trailer (sometimes referred to as a 'book trailer')
     */
    Trailer("26", "Trailer"), //

    /**
     * Intended ONLY for transitional use, where ONIX 2.1 records referencing existing thumbnail assets of unknown pixel
     * size are being re-expressed in ONIX 3.0. Use code 01 for all new cover assets, and where the pixel size of older
     * assets is known
     */
    Cover_thumbnail("27", "Cover thumbnail"), //

    /**
     * The full content of the product (or the product itself), supplied for example to support full-text search or
     * indexing
     */
    Full_content("28", "Full content"), //

    /**
     * Includes cover, back cover, spine and - where appropriate - any flaps
     */
    Full_cover("29", "Full cover"), //

    Master_brand_logo("30", "Master brand logo"), //

    /**
     * Descriptive text in a separate downloadable file, not in the ONIX record. Equivalent of code 03 in List 153. Use
     * the &lt;TextContent&gt; composite for descriptions carried in the ONIX record. Use &lt;Supporting Resource&gt;
     * for text offered as a separate file resource for reproduction as part of promotional material for the product
     */
    Description("31", "Description"), //

    /**
     * Index text held in a separate downloadable file, not in the ONIX record. Equivalent of code 15 in List 153. Use
     * the &lt;TextContent&gt; composite for index text carried in the ONIX record. Use &lt;Supporting Resource&gt; for
     * an index offered as a separate file resource
     */
    Index("32", "Index"), //

    /**
     * Including associated student / learner resources
     */
    Student_s_guide("33", "Student’s guide"), //

    /**
     * For example a PDF or other digital representation of a publisher's 'new titles' or range catalogue
     */
    Publisher_s_catalogue("34", "Publisher’s catalogue"), //

    /**
     * For example a banner ad for the product. Pixel dimensions should typically be included in
     * &lt;ResourceVersionFeature&gt;
     */
    Online_advertisement_panel("35", "Online advertisement panel"), //

    /**
     * German 'B&#250;hnenbild'
     */
    Online_advertisement_page("36", "Online advertisement page"), //

    /**
     * For example, posters, logos, banners, advertising templates for use in connection with a promotional event
     */
    Promotional_event_material("37", "Promotional event material"), //

    /**
     * Availability of a digital review or digital proof copy, may be limited to authorised users or account holders
     */
    Digital_review_copy("38", "Digital review copy"), //

    /**
     * For example, video showing how to use the product
     */
    Instructional_material("39", "Instructional material"), //

    /**
     * Jonix-Comment: Introduced in Onix3
     */
    Errata("40", "Errata"), //

    /**
     * Introduction, preface or other preliminary material in a separate resource file
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Introduction("41", "Introduction"), //

    /**
     * Descriptive material in a separate resource file, not in the ONIX record. Equivalent of code 17 in List 153. Use
     * the &lt;TextContent&gt; composite for collection descriptions carried in the ONIX record. Use &lt;Supporting
     * Resource&gt; for material (which need not be solely only) offered as a separate file resource for reproduction as
     * part of promotional material for the product and collection
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Collection_description("42", "Collection description"), //

    /**
     * Complete list of books by the author(s), supplied as a separate resource file
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Bibliography("43", "Bibliography"), //

    /**
     * Link to a license covering permitted usage of the product content. Deprecated in favor of &lt;EpubLicense&gt;.
     * This was a temporary workaround in ONIX 3.0, and use of &lt;EpubLicense&gt; is strongly preferred
     */
    License("99", "License");

    public final String code;
    public final String description;

    ResourceContentTypes(String code, String description) {
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

    private static volatile Map<String, ResourceContentTypes> map;

    private static Map<String, ResourceContentTypes> map() {
        Map<String, ResourceContentTypes> result = map;
        if (result == null) {
            synchronized (ResourceContentTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ResourceContentTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ResourceContentTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
