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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 79 (Product form feature type)
 */
interface CodeList79 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 79</b>
 * <p>
 * Description: Product form feature type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist79">ONIX
 *      Codelist 79 in Reference Guide</a>
 */
public enum ProductFormFeatureTypes implements OnixCodelist, CodeList79 {
    /**
     * For Product Form Feature values see code list 98
     */
    Color_of_cover("01", "Color of cover"),

    /**
     * Where it is different from the overall color of the cover (see code 01). For Product Form Feature values see code
     * list 98. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_spine("26", "Color of spine"),

    /**
     * On cover or spine. For Product form feature values see metallic colors from code list 98. If further detail is
     * required, also use Product form feature description. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_foil_on_cover("27", "Color of foil (on cover)"),

    /**
     * On dustjacket. For Product Form Feature values see metallic colors from code list 98. If further detail is
     * required, also use Product form feature description. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_foil_on_jacket("59", "Color of foil (on jacket)"),

    /**
     * Sprayed / stained / gilded edges. For Product form feature values see code list 98. For patterned and illustrated
     * page edges, also use Product form feature description or see List 158 code 54
     */
    Color_of_page_edges("02", "Color of page edges"),

    /**
     * Or of inside front and back covers. For Product form feature values see Codelist 98. For patterned and
     * illustrated endpapers, also use Product form feature description or see List 158 code 55. Only for use in ONIX
     * 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_endpapers("55", "Color of endpapers"),

    /**
     * Use also for color of elasticated strap. For Product Form Feature Values see Codelist 98, and with multicolored
     * or multiple ribbons, also use Product Form Feature Description. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_ribbon_marker_s("57", "Color of ribbon marker(s)"),

    /**
     * Capital bands. For Product form feature values see codelist 98, and with multicolored (eg striped) bands, also
     * use Product form feature description. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Color_of_head_and_tail_bands("58", "Color of head and tail bands"),

    /**
     * The principal font used for body text, when this is a significant aspect of product description, eg for some
     * Bibles, and for large print product. The accompanying &lt;ProductFormFeatureDescription&gt; is text specifying
     * the typeface name. The font size may be specified with the font name, but is preferred separately (in points) in
     * &lt;ProductFormFeatureValue&gt;
     */
    Text_font("03", "Text font"),

    /**
     * For Product Form Feature values see code list 99
     */
    Special_cover_material("04", "Special cover material"),

    /**
     * For Product Form Feature values see code list 76
     */
    DVD_region("05", "DVD region"),

    /**
     * A computer or handheld device operating system required to use a digital product, with version detail if
     * applicable. The accompanying Product Form Feature Value is a code from List 176. Version detail, when applicable,
     * is carried in Product Form Feature Description
     */
    Operating_system_requirements("06", "Operating system requirements"),

    /**
     * Other system requirements for a digital product, described by free text in Product Form Feature Description
     */
    Other_system_requirements("07", "Other system requirements"),

    /**
     * Indicates compatibility with proprietary 'point and listen' devices such as Ting Pen (http://www.ting.eu), the
     * iSmart Touch and Read Pen. These devices scan invisible codes specially printed on the page to identify the book
     * and position of the word, and the word is then read aloud by the device. The name of the compatible device (or
     * range of devices) should be given in &lt;ProductFormFeatureDescription&gt;
     */
    Point_and_listen_device_compatibility("08", "‘Point and listen’ device compatibility"),

    /**
     * For &lt;ProductFormFeatureValue&gt; codes, see Codelist 196
     */
    E_publication_accessibility_detail("09", "E-publication accessibility detail"),

    /**
     * For versioned e-book file formats (or in some cases, devices). &lt;ProductFormFeatureValue&gt; should contain the
     * version number as a period-separated list of numbers (eg '7', '1.5' or '3.10.7'). Only for use in ONIX 3.0 or
     * later - in ONIX 2.1, use &lt;EpubTypeVersion&gt; instead. For the most common file formats, code 15 and List 220
     * is strongly preferred
     */
    E_publication_format_version("10", "E-publication format version"),

    /**
     * Hazard warning required by US Consumer Product Safety Improvement Act (CPSIA) of 2008 or other US or
     * international legislation. Required, when applicable, for products sold in the US. The Product Form Feature Value
     * is a code from List 143. Further explanation may be given in Product Form Feature Description
     */
    US_CPSIA_or_other_international_hazard_warning("12", "US CPSIA or other international hazard warning"),

    /**
     * Product carries hazard warning, conformity notice or other text required by EU General Product Safety Regulation
     * or Toy Safety Directive. The Product Form Feature Value is a code from List 184, and (for some codes) the exact
     * wording of the warning or text may be given in Product Form Feature Description
     */
    EU_General_Product_Safety_Regulation_and_Toy_Safety_Directive_hazard_warning("13",
        "EU General Product Safety Regulation and Toy Safety Directive hazard warning"),

    /**
     * Product Form Feature Description must give further details of the warning
     */
    IATA_Dangerous_Goods_warning("14", "IATA Dangerous Goods warning"),

    /**
     * For common versioned e-book formats (or in some cases, devices) - for example EPUB 2.0.1 or EPUB 3.0.
     * &lt;ProductFormFeatureValue&gt; is a code from list 220. Only for use in ONIX 3.0 or later
     */
    E_publication_format_version_code("15", "E-publication format version code"),

    /**
     * For common versioned e-book formats, the name and version of the validator used to check conformance.
     * &lt;ProductFormFeatureDescription&gt; is the common name of the validator used (eg EpubCheck, Flightdeck), and
     * &lt;ProductFormFeatureValue&gt; is the version number of the validator (eg 4.0.0a). Use with code 15 (or possibly
     * code 10), or with &lt;EpubTypeVersion&gt;, to specify the version the e-publication conforms with
     */
    E_publication_format_validator_version("16", "E-publication format validator version"),

    /**
     * Indicates compatibility with proprietary 'point and watch' devices or apps. These scan invisible codes specially
     * printed on the page, or the whole page image, to identify the book and page position. Scanning can trigger
     * display of (for example) an augmented reality view of the page. The name of the compatible app or device (or
     * range of apps/devices) should be given in &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Point_and_watch_device_app_compatibility("17", "‘Point and watch’ device/app compatibility"),

    /**
     * Requirement for user authentication prior to use, with detail of authentication method (user enrolment, and login
     * passwords, location- or device-based recognition, authentication via third-party identity service etc) given in
     * &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    E_publication_authentication_and_access_control("18", "E-publication authentication and access control"),

    /**
     * Use to describe battery requirements, types, hazards and battery safety warnings. &lt;ProductFormFeatureValue&gt;
     * is a code from List 242. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Battery_type_and_safety("19", "Battery type and safety"),

    /**
     * Total capacity (of batteries in the product) in Watt hours. &lt;ProductFormFeatureValue&gt; is an integer or
     * decimal number (eg '45', not '45Wh'). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Battery_capacity("20", "Battery capacity"),

    /**
     * Use to describe regulation of the product for various purposes. &lt;ProductFormFeatureValue&gt; is a code from
     * List 243. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Dangerous_goods("21", "Dangerous goods"),

    /**
     * Number of pieces, eg for jigsaws, puzzles, kits, board games. &lt;ProductFormFeatureValue&gt; is an integer. Only
     * for use in ONIX 3.0 or later. For pieces like cards in a pack, see &lt;Extent&gt; and code 00 from List 24
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Game_pieces("22", "Game pieces"),

    /**
     * Number of players, for board games, card games, videogames etc. &lt;ProductFormFeatureValue&gt; must be a
     * required (exact) number as an integer OR a range (eg '2-6'), optionally accompanied by the number of players as
     * text (eg 'suitable for 2-6 players') in &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Game_players("23", "Game players"),

    /**
     * Typical time to complete a game, for board games, card games, videogames etc, stated as an integer (in minutes)
     * OR range (eg '60-90') in &lt;ProductFormFeatureValue&gt;, optionally accompanied by the playing time as text (eg
     * 'typically 60-90 minutes') in &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Game_play_time("24", "Game play time"),

    /**
     * Personal data required for registration or use of the product. This can be coded in
     * &lt;ProductFormFeatureValue&gt; (for example using a URI from SCOLOM list 044 - see
     * http://data.education.fr/voc/scolomfr/scolomfr-voc-044) - and/or described in
     * &lt;ProductFormFeatureDescription&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Personal_data_requirements("25", "Personal data requirements"),

    /**
     * Product does not carry FSC or PEFC logo. The Product Form Feature Value element is not used. The Product Form
     * Feature Description element may carry free text indicating the grade or type of paper. The product record may
     * also still carry a claimed Pre- and Post-Consumer Waste (PCW) percentage value (type code 37) in a separate
     * repeat of the Product Form Feature composite
     */
    Not_FSC_or_PEFC_certified("30", "Not FSC or PEFC certified"),

    /**
     * Product carries FSC logo (Pure, 100%). &lt;ProductFormFeatureValue&gt; is the Certification number (ie either a
     * Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of Custody number
     * is two to five letters-COC-six digits (the digits should include leading zeros if necessary), eg 'AB-COC-001234'
     * or 'ABCDE-COC-123456'; Trademark License number is C followed by six digits, eg 'C005678' (this would normally be
     * prefixed by 'FSC&#174;' when displayed). The Product Form Feature Description element may carry free text
     * indicating the grade or type of paper. By definition, a product certified Pure does not contain Pre- or
     * Post-Consumer-Waste (PCW), so type code 31 can only occur on its own. Certification numbers may be checked at
     * https://info.fsc.org/
     */
    FSC_certified_pure("31", "FSC certified – pure"),

    /**
     * Product carries FSC logo (Mixed sources, Mix). &lt;ProductFormFeatureValue&gt; is the Certification number (ie
     * either a Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of
     * Custody number is two to five letters-COC-six digits (the digits should include leading zeros if necessary), eg
     * 'AB-COC-001234' or 'ABCDE-COC-123456'; Trademark License number is C followed by six digits, eg 'C005678' (this
     * would normally be prefixed by 'FSC&#174;' when displayed). The Product Form Feature Description element may carry
     * free text indicating the grade or type of paper. May be accompanied by a Pre- and Post-Consumer-Waste (PCW)
     * percentage value, to be reported in another instance of &lt;ProductFormFeature&gt; with type code 36.
     * Certification numbers may be checked at https://info.fsc.org/
     */
    FSC_certified_mixed_sources("32", "FSC certified – mixed sources"),

    /**
     * Product carries FSC logo (Recycled). &lt;ProductFormFeatureValue&gt; is the Certification number (ie either a
     * Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of Custody number
     * is two to five letters-COC-six digits (the digits should include leading zeroes if necessary), eg 'AB-COC-001234'
     * or 'ABCDE-COC-123456'; Trademark License number is C followed by six digits, eg 'C005678' (this would normally be
     * prefixed by 'FSC&#174;' when displayed). The Product Form Feature Description element may carry free text
     * indicating the grade or type of paper. May be accompanied by a Pre- and Post-Consumer-Waste (PCW) percentage
     * value, to be reported in another instance of &lt;ProductFormFeature&gt; with type code 36, but otherwise assumed
     * to be 100% recycled. Certification numbers may be checked at https://info.fsc.org/
     */
    FSC_certified_recycled("33", "FSC certified – recycled"),

    /**
     * Product carries PEFC logo (certified) or equivalent from PEFC-endorsed national scheme.
     * &lt;ProductFormFeatureValue&gt; is the Chain Of Custody (COC) number printed on the book. The Product Form
     * Feature Description element may carry free text indicating the grade or type of paper. May be accompanied by a
     * Post-Consumer Waste (PCW) percentage value, to be reported in another instance of &lt;ProductFormFeature&gt; with
     * type code 36
     */
    PEFC_certified("34", "PEFC certified"),

    /**
     * Product carries PEFC logo (recycled) or equivalent from PEFC-endorsed national scheme.
     * &lt;ProductFormFeatureValue&gt; is the Chain Of Custody (COC) number printed on the book. The Product Form
     * Feature Description element may carry free text indicating the grade or type of paper. Should be accompanied by a
     * Post-Consumer-Waste (PCW) percentage value, to be reported in another instance of &lt;ProductFormFeature&gt; with
     * type code 36
     */
    PEFC_recycled("35", "PEFC recycled"),

    /**
     * The percentage of recycled Pre- and Post-Consumer-Waste (PCW) used in a product where the composition is
     * certified by FSC, PEFC or PEFC-endorsed scheme. &lt;ProductFormFeatureValue&gt; is an integer. May occur together
     * with type code 32, 33, 34 or 35
     */
    FSC_or_PEFC_certified_Pre_and_Post_Consumer_Waste_PCW("36",
        "FSC or PEFC certified Pre- and Post-Consumer Waste (PCW) percentage"),

    /**
     * The percentage of recycled Pre- and Post-Consumer Waste (PCW) claimed to be used in a product where the
     * composition is not certified by FSC or PEFC. &lt;Product FormFeatureValue&gt; is an integer.
     * &lt;ProductFormFeatureDescription&gt; may carry free text supporting the claim. Must be accompanied by type code
     * 30
     */
    Claimed_Pre_and_Post_Consumer_Waste_PCW("37", "Claimed Pre- and Post-Consumer Waste (PCW) percentage"),

    /**
     * Vegetable-based or other environmentally-conscious inks and varnishes. &lt;ProductFormFeatureDescription&gt; may
     * carry free text with a more detailed statement. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Green_inks("38", "‘Green’ inks"),

    /**
     * Product binding uses environmentally-conscious adhesives and other binding materials.
     * &lt;ProductFormFeatureDescription&gt; may carry free text with a more detailed statement. Only for use in ONIX
     * 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Green_adhesives("39", "‘Green’ adhesives"),

    /**
     * Product made from paper produced using environmentally-conscious technology.
     * &lt;ProductFormFeatureDescription&gt; may carry free text with a more detailed statement
     */
    Paper_produced_by_green_technology("40", "Paper produced by ‘green’ technology"),

    /**
     * &lt;ProductFormFeatureValue&gt; is a code from List 262 identifying the particular certification scheme.
     * &lt;ProductFormFeatureDescription&gt; may be a descriptor for some part, schedule or annex of the certification
     * scheme, where necessary. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_emission_certification_scheme("41", "Carbon/GHG emission certification scheme"),

    /**
     * &lt;ProductFormFeatureValue&gt; is a code from List 262 identifying a particular certification scheme.
     * &lt;ProductFormFeatureDescription&gt; is a certificate or license number used to certify compliance with the
     * scheme. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_emission_certification_license_number("42", "Carbon/GHG emission certification / license number"),

    /**
     * &lt;ProductFormFeatureValue&gt; is a code from List 262 identifying a particular certification scheme.
     * &lt;ProductFormFeatureDescription&gt; is a URL linking to a web page certifying compliance with the scheme. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_emission_certification_URL("43", "Carbon/GHG emission certification URL"),

    /**
     * &lt;ProductFormFeatureValue&gt; is a code from List 262 identifying a particular certification scheme.
     * &lt;ProductFormFeatureDescription&gt; is a number specifying certified GHG emissions per copy of the product,
     * measured in kilograms of Carbon dioxide equivalent (CO&#8322;e) using the Scope 3 methodology of the scheme. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_Scope_3_certified_Carbon_dioxide_equivalent_emission("44",
        "Carbon/GHG Scope 3 certified Carbon dioxide equivalent emission"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_Scope_2_certified_Carbon_dioxide_equivalent_emission("45",
        "Carbon/GHG Scope 2 certified Carbon dioxide equivalent emission"),

    /**
     * Scope 1 emission certifications are not recommended for use. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carbon_GHG_Scope_1_certified_Carbon_dioxide_equivalent_emission("46",
        "Carbon/GHG Scope 1 certified Carbon dioxide equivalent emission"),

    /**
     * For EU Deforestation regulations, location of raw material source plot ('where the tree grew') for the interior
     * or main body of the product (or for the entire product, if the raw material source for the binding and other
     * parts of the product cannot be differentiated). If there are multiple sources for the same raw material, repeat
     * &lt;ProductFormFeature&gt; for each plot or use the 'list of plots' option below. Further repeats of
     * &lt;ProductFormFeature&gt; may be used for multiple paper, card and board types. &lt;ProductFormFeatureValue&gt;
     * is a country code from List 91 indicating the country in which the source plot is, optionally followed by a space
     * and the name of the species, and optionally followed by a space and the date of harvest of the source plot (YYYY,
     * YYYYMM or YYYYMMDD). A species name may itself consist of the binomial Latin name (the 'scientific name'), or the
     * binomial Latin name followed by a space plus the common name in parentheses. The common name may only be included
     * if the Latin name is also present. Alternatively, a list of multiple species names from the same source plot may
     * be listed, separated by commas. In such a list, all species names must include both scientific and common name,
     * or all must include a scientific name only. Note there can be up to four types of data (country, a Latin name and
     * a common name, or a comma-separated list of Latin names and common names, and a date), each space separated, but
     * only the country is mandatory. &lt;ProductFormFeatureDescription&gt; is a list of points defining one or more
     * plots from which the raw material was harvested, using GPS coordinates with 6 decimal places of precision (these
     * are real numbers, &#177;90 for latitude [negative numbers indicate a latitude south of the equator], &#177;180
     * excluding -180 itself for longitude [negative numbers indicate a longitude west of the Prime Greenwich
     * meridian]). Latitude and Longitude for each point are space-separated, and multiple points are comma-separated.
     * Multiple plots are semicolon separated, and must be in the same country. (Any supplied species name and date must
     * also apply to all plots in the list.) (Note these GPS coordinates use decimal parts of a degree, not minutes and
     * seconds.) ONE point defines the center of a 4 hectare plot (200m &#215; 200m). TWO points define a line joining
     * opposite corners of a 'square' plot bounded by two lines of latitude and two of longitude. THREE or more points
     * define a simple polygon outlining the plot. Plot types with one, two or multiple points must not be mixed in a
     * list of multiple plots. Lines and polygon edges may not cross a national boundary or the 180&#176; line of
     * longitude. Polygon edges may not intersect. It is good practice to ensure the polygon is drawn clockwise and is
     * 'closed' (that is, that the first and last points are identical, so that for example four points define a
     * triangle). If not closed, the closing polygon edge is implied, and to avoid ambiguity, trailing zeros in the
     * latitude and longitude should be explicit. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_interior_or_full_product("47", "EUDR raw material location (interior or full product)"),

    /**
     * As code 47, but for endpaper, cover card or board, any other binding or covering material and any jacket (but not
     * including any slipcase or other packaging). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_binding("48", "EUDR raw material location (binding)"),

    /**
     * As code 47, but for any slipcase or box, retail packaging, supplementary material (but not including any
     * packaging discarded before retail sale). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_other("49", "EUDR raw material location (other)"),

    /**
     * For EU Deforestation Regulations, &lt;ProductFormFeatureValue&gt; is the 'Due Diligence Statement' (DDS) document
     * reference recorded by the publisher or other organization responsible for the product when a due diligence
     * statement is uploaded to the EU's portal, expected to be in a format like '24FRXVV3VOS991' (with an optional
     * suffix '+' and a 'verification code' expected to be in a format like 'A4B3C2D1'). This reference is the DDS for
     * the product as a whole. There may also be a UUID acting as an internal or proprietary document reference, for
     * which use &lt;ProductFormFeatureDescription&gt;. &lt;ProductFormFeature&gt; should be repeated if multiple DDSs
     * apply to the product as a whole. Only for use in ONIX 3.0 or later. See
     * https://environment.ec.europa.eu/topics/forests/deforestation/regulation-deforestation-free-products_en
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_due_diligence_reference("50", "EUDR due diligence reference"),

    /**
     * For EU Deforestation Regulation, &lt;ProductFormFeatureValue&gt; is a space-separated list of document references
     * for DDSs (including optional verification code) created by upstream operators that are or may be referred to in
     * the DDS for the product as a whole (ie the DDS specified using code 50)) - for example DDSs for the paper types
     * used to manufacture the product. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_associated_due_diligence_references("51", "EUDR associated due diligence references"),

    /**
     * For EU Deforestation regulations, a 'flag' indicating that all raw materials were produced in accordance with
     * legal requirements of one or more countries within each of which there are one or more source plots, and that
     * documentation to verify this is available upon request. &lt;ProductFormFeatureValue&gt; is a space-separated list
     * of country codes from List 91. Presence of code 52 and a country code acts as an positive attestation that the
     * product's raw materials sourced from the specified country are compliant with the national laws of that country,
     * but the attestation is meaningful only if there is no pre-existing DDS for the product as a whole (presence of a
     * DDS reference already attests the product is compliant with all national laws and that documentation is
     * available). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_compliant_with_national_law_attestation("52", "EUDR compliant with national law attestation"),

    /**
     * For EU Deforestation regulations, a 'flag' indicating that all raw materials used for the product are
     * 'deforestation-free', and that documentation to verify this is available upon request. Presence of code 53 acts
     * as a positive attestation that the product's raw materials are deforestation-free, but the attestation is
     * meaningful only if there is no pre-existing DDS for the product as a whole (presence of a DDS reference already
     * attests the product is deforestation-free and that documentation is available). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_deforestation_free_attestation("53", "EUDR deforestation-free attestation"),

    /**
     * For EU Deforestation regulations, a 'flag' indicating that no (in-EU) supplier has stock that was not physically
     * present within the EU prior to the enforcement date of the Regulation, and that documentation to verify this is
     * available upon request. Presence of code 54 acts as a positive attestation that all copies of the product held at
     * distributors and wholesalers within the EU pre-dates the enforcement date, but the attestation is meaningful only
     * if there is no pre-existing DDS for the product as a whole (presence of a DDS reference already attests the
     * product is compliant with the regulation and that documentation is available). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_stock_present_attestation("54", "EUDR stock present attestation"),

    /**
     * For EU Deforestation regulations, a 'flag' indicating that the raw materials for the product are entirely outside
     * the scope of the regulations for any reason, for example because a map - that would otherwise be required to
     * conform - is printed on plastic rather than paper, or a book is made wholly of recycled raw materials (including
     * the cover). &lt;ProductClassification&gt; may contain an additional TARIC exemption code. Ensure other Product
     * form features agree, and that documentation is available. Only for use in ONIX 3.0 or later. No other EUDR
     * metadata need be included
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_beyond_scope_attestation("56", "EUDR beyond scope attestation"),

    /**
     * As code 47, but &lt;ProductFormFeatureDescription&gt; is the URL of a GeoJSON file outlining the source plot.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_interior_or_full_product_("60",
        "EUDR raw material location (interior or full product) URL"),

    /**
     * As code 48, but &lt;ProductFormFeatureDescription&gt; is the URL of a GeoJSON file outlining the source plot.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_binding_("61", "EUDR raw material location (binding) URL"),

    /**
     * As code 49, but &lt;ProductFormFeatureDescription&gt; is the URL of a GeoJSON file outlining the source plot.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EUDR_raw_material_location_other_("62", "EUDR raw material location (other) URL"),

    /**
     * DEPRECATED - use code 12 and List 143
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    CPSIA_choking_hazard_warning("11", "CPSIA choking hazard warning");

    public final String code;
    public final String description;

    ProductFormFeatureTypes(String code, String description) {
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

    private static volatile Map<String, ProductFormFeatureTypes> map;

    private static Map<String, ProductFormFeatureTypes> map() {
        Map<String, ProductFormFeatureTypes> result = map;
        if (result == null) {
            synchronized (ProductFormFeatureTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductFormFeatureTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductFormFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductFormFeatureTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
