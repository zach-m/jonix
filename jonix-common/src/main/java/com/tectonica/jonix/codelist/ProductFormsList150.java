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
 * marker interface to assist in IDE navigation to code-list 150 (Product form)
 */
interface CodeList150 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 150</b>
 * <p>
 * Description: Product form
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist150">ONIX
 * Codelist 150 in Reference Guide</a>
 */
public enum ProductFormsList150 implements OnixCodelist, CodeList150 {
    Undefined("00", "Undefined"), //

    /**
     * Audio recording - detail unspecified
     */
    Audio("AA", "Audio"), //

    /**
     * Audio cassette (analogue)
     */
    Audio_cassette("AB", "Audio cassette"), //

    /**
     * Audio compact disc, in any recording format: use for 'red book' (conventional audio CD) and SACD, and use coding
     * in Product Form Detail to specify the format, if required
     */
    CD_Audio("AC", "CD-Audio"), //

    /**
     * Digital audio tape cassette
     */
    DAT("AD", "DAT"), //

    /**
     * Audio disc (excluding CD-Audio)
     */
    Audio_disc("AE", "Audio disc"), //

    /**
     * Audio tape (analogue open reel tape)
     */
    Audio_tape("AF", "Audio tape"), //

    /**
     * Sony MiniDisc format
     */
    MiniDisc("AG", "MiniDisc"), //

    /**
     * Audio compact disc with part CD-ROM content, also termed CD-Plus or Enhanced-CD: use for 'blue book' and
     * 'yellow/red book' two-session discs
     */
    CD_Extra("AH", "CD-Extra"), //

    DVD_Audio("AI", "DVD Audio"), //

    /**
     * Audio recording downloadable online
     */
    Downloadable_audio_file("AJ", "Downloadable audio file"), //

    /**
     * For example, Playaway audiobook and player: use coding in Product Form Detail to specify the recording format, if
     * required
     */
    Pre_recorded_digital_audio_player("AK", "Pre-recorded digital audio player"), //

    /**
     * For example, Audiofy audiobook chip
     */
    Pre_recorded_SD_card("AL", "Pre-recorded SD card"), //

    /**
     * Other audio format not specified by AB to AK
     */
    Other_audio_format("AZ", "Other audio format"), //

    /**
     * Book - detail unspecified
     */
    Book("BA", "Book"), //

    /**
     * Hardback or cased book
     */
    Hardback("BB", "Hardback"), //

    /**
     * Paperback or other softback book
     */
    Paperback_softback("BC", "Paperback / softback"), //

    /**
     * Loose-leaf book
     */
    Loose_leaf("BD", "Loose-leaf"), //

    /**
     * Spiral, comb or coil bound book
     */
    Spiral_bound("BE", "Spiral bound"), //

    /**
     * Pamphlet or brochure, stapled; German 'geheftet'. Includes low-extent wire-stitched books bound without a
     * distinct spine (eg many comic books)
     */
    Pamphlet("BF", "Pamphlet"), //

    Leather_fine_binding("BG", "Leather / fine binding"), //

    /**
     * Child's book with all pages printed on board
     */
    Board_book("BH", "Board book"), //

    /**
     * Child's book with all pages printed on textile
     */
    Rag_book("BI", "Rag book"), //

    /**
     * Child's book printed on waterproof material
     */
    Bath_book("BJ", "Bath book"), //

    /**
     * A book whose novelty consists wholly or partly in a format which cannot be described by any other available code
     * - a 'conventional' format code is always to be preferred; one or more Product Form Detail codes, eg from the B2nn
     * group, should be used whenever possible to provide additional description
     */
    Novelty_book("BK", "Novelty book"), //

    /**
     * Slide bound book
     */
    Slide_bound("BL", "Slide bound"), //

    /**
     * Extra-large format for teaching etc; this format and terminology may be specifically UK; required as a top-level
     * differentiator
     */
    Big_book("BM", "Big book"), //

    /**
     * A part-work issued with its own ISBN and intended to be collected and bound into a complete book
     */
    Part_work_fasc_culo("BN", "Part-work (fascículo)"), //

    /**
     * Concertina-folded book or chart, designed to fold to pocket or regular page size: use for German 'Leporello'
     */
    Fold_out_book_or_chart("BO", "Fold-out book or chart"), //

    /**
     * A children's book whose cover and pages are made of foam
     */
    Foam_book("BP", "Foam book"), //

    /**
     * Other book format or binding not specified by BB to BO
     */
    Other_book_format("BZ", "Other book format"), //

    /**
     * Sheet map - detail unspecified
     */
    Sheet_map("CA", "Sheet map"), //

    Sheet_map_folded("CB", "Sheet map, folded"), //

    Sheet_map_flat("CC", "Sheet map, flat"), //

    /**
     * See Code List 80 for 'rolled in tube'
     */
    Sheet_map_rolled("CD", "Sheet map, rolled"), //

    /**
     * Globe or planisphere
     */
    Globe("CE", "Globe"), //

    /**
     * Other cartographic format not specified by CB to CE
     */
    Other_cartographic("CZ", "Other cartographic"), //

    /**
     * Digital content delivered on a physical carrier (detail unspecified)
     */
    Digital_on_physical_carrier("DA", "Digital (on physical carrier)"), //

    CD_ROM("DB", "CD-ROM"), //

    /**
     * CD interactive: use for 'green book' discs
     */
    CD_I("DC", "CD-I"), //

    Game_cartridge("DE", "Game cartridge"), //

    /**
     * AKA 'floppy disc'
     */
    Diskette("DF", "Diskette"), //

    DVD_ROM("DI", "DVD-ROM"), //

    Secure_Digital_SD("DJ", "Secure Digital (SD) Memory Card"), //

    Compact_Flash_Memory_Card("DK", "Compact Flash Memory Card"), //

    Memory_Stick_Memory_Card("DL", "Memory Stick Memory Card"), //

    USB_Flash_Drive("DM", "USB Flash Drive"), //

    /**
     * Double-sided disc, one side Audio CD/CD-ROM, other side DVD
     */
    Double_sided_CD_DVD("DN", "Double-sided CD/DVD"), //

    /**
     * Other carrier of digital content not specified by DB to DN
     */
    Other_digital_carrier("DZ", "Other digital carrier"), //

    /**
     * Digital content delivered electronically (delivery method unspecified)
     */
    Digital_delivered_electronically("EA", "Digital (delivered electronically)"), //

    /**
     * Digital content available both by download and by online access
     */
    Digital_download_and_online("EB", "Digital download and online"), //

    /**
     * Digital content accessed online only
     */
    Digital_online("EC", "Digital online"), //

    /**
     * Digital content delivered by download only
     */
    Digital_download("ED", "Digital download"), //

    /**
     * Film or transparency - detail unspecified
     */
    Film_or_transparency("FA", "Film or transparency"), //

    /**
     * Photographic transparencies mounted for projection
     */
    Slides("FC", "Slides"), //

    /**
     * Transparencies for overhead projector
     */
    OHP_transparencies("FD", "OHP transparencies"), //

    Filmstrip("FE", "Filmstrip"), //

    /**
     * Continuous movie film as opposed to filmstrip
     */
    Film("FF", "Film"), //

    /**
     * Other film or transparency format not specified by FB to FF
     */
    Other_film_or_transparency_format("FZ", "Other film or transparency format"), //

    /**
     * Digital product license (delivery method not encoded)
     */
    Digital_product_license("LA", "Digital product license"), //

    /**
     * Digital product license delivered through the retail supply chain as a physical 'key', typically a card or
     * booklet containing a code enabling the purchaser to download the associated product
     */
    Digital_product_license_key("LB", "Digital product license key"), //

    /**
     * Digital product license delivered by email or other electronic distribution, typically providing a code enabling
     * the purchaser to upgrade or extend the license supplied with the associated product
     */
    Digital_product_license_code("LC", "Digital product license code"), //

    /**
     * Microform - detail unspecified
     */
    Microform("MA", "Microform"), //

    Microfiche("MB", "Microfiche"), //

    /**
     * Roll microfilm
     */
    Microfilm("MC", "Microfilm"), //

    /**
     * Other microform not specified by MB or MC
     */
    Other_microform("MZ", "Other microform"), //

    /**
     * Miscellaneous printed material - detail unspecified
     */
    Miscellaneous_print("PA", "Miscellaneous print"), //

    /**
     * May use product form detail codes P201 to P204 to specify binding
     */
    Address_book("PB", "Address book"), //

    Calendar("PC", "Calendar"), //

    /**
     * Cards, flash cards (eg for teaching reading)
     */
    Cards("PD", "Cards"), //

    /**
     * Copymasters, photocopiable sheets
     */
    Copymasters("PE", "Copymasters"), //

    /**
     * May use product form detail codes P201 to P204 to specify binding
     */
    Diary("PF", "Diary"), //

    /**
     * Narrow strip-shaped printed sheet used mostly for education or children's products (eg depicting alphabet, number
     * line, procession of illustrated characters etc). Usually intended for horizontal display
     */
    Frieze("PG", "Frieze"), //

    /**
     * Parts for post-purchase assembly
     */
    Kit("PH", "Kit"), //

    Sheet_music("PI", "Sheet music"), //

    Postcard_book_or_pack("PJ", "Postcard book or pack"), //

    /**
     * Poster for retail sale - see also XF
     */
    Poster("PK", "Poster"), //

    /**
     * Record book (eg 'birthday book', 'baby book'): binding unspecified; may use product form detail codes P201 to
     * P204 to specify binding
     */
    Record_book("PL", "Record book"), //

    /**
     * Wallet or folder (containing loose sheets etc): it is preferable to code the contents and treat 'wallet' as
     * packaging (List 80), but if this is not possible the product as a whole may be coded as a 'wallet'
     */
    Wallet_or_folder("PM", "Wallet or folder"), //

    Pictures_or_photographs("PN", "Pictures or photographs"), //

    Wallchart("PO", "Wallchart"), //

    Stickers("PP", "Stickers"), //

    /**
     * A book-sized (as opposed to poster-sized) sheet, usually in color or high quality print
     */
    Plate_l_mina("PQ", "Plate (lámina)"), //

    /**
     * A book with all pages blank for the buyer's own use; may use product form detail codes P201 to P204 to specify
     * binding
     */
    Notebook_blank_book("PR", "Notebook / blank book"), //

    /**
     * May use product form detail codes P201 to P204 to specify binding
     */
    Organizer("PS", "Organizer"), //

    Bookmark("PT", "Bookmark"), //

    /**
     * Other printed item not specified by PB to PQ
     */
    Other_printed_item("PZ", "Other printed item"), //

    /**
     * Presentation unspecified: format of product items must be given in &lt;ProductPart&gt;
     */
    Multiple_item_retail_product("SA", "Multiple-item retail product"), //

    /**
     * Format of product items must be given in &lt;ProductPart&gt;
     */
    Multiple_item_retail_product_boxed("SB", "Multiple-item retail product, boxed"), //

    /**
     * Format of product items must be given in &lt;ProductPart&gt;
     */
    Multiple_item_retail_product_slip_cased("SC", "Multiple-item retail product, slip-cased"), //

    /**
     * Format of product items must be given in &lt;ProductPart&gt;. Use code XL for a shrink-wrapped pack for trade
     * supply, where the retail items it contains are intended for sale individually
     */
    Multiple_item_retail_product_shrinkwrapped("SD", "Multiple-item retail product, shrinkwrapped"), //

    /**
     * Format of product items must be given in &lt;ProductPart&gt;
     */
    Multiple_item_retail_product_loose("SE", "Multiple-item retail product, loose"), //

    /**
     * Multiple item product where subsidiary product part(s) is/are supplied as enclosures to the primary part, eg a
     * book with a CD packaged in a sleeve glued within the back cover. Format of product items must be given in
     * &lt;ProductPart&gt;
     */
    Multiple_item_retail_product_part_s("SF", "Multiple-item retail product, part(s) enclosed"), //

    /**
     * Video - detail unspecified
     */
    Video("VA", "Video"), //

    /**
     * eg Laserdisc
     */
    Videodisc("VF", "Videodisc"), //

    /**
     * DVD video: specify TV standard in List 175
     */
    DVD_video("VI", "DVD video"), //

    /**
     * VHS videotape: specify TV standard in List 175
     */
    VHS_video("VJ", "VHS video"), //

    /**
     * Betamax videotape: specify TV standard in List 175
     */
    Betamax_video("VK", "Betamax video"), //

    /**
     * VideoCD
     */
    VCD("VL", "VCD"), //

    /**
     * Super VideoCD
     */
    SVCD("VM", "SVCD"), //

    /**
     * High definition DVD disc, Toshiba HD DVD format
     */
    HD_DVD("VN", "HD DVD"), //

    /**
     * High definition DVD disc, Sony Blu-ray format
     */
    Blu_ray("VO", "Blu-ray"), //

    /**
     * Sony Universal Media disc
     */
    UMD_Video("VP", "UMD Video"), //

    /**
     * China Blue High-Definition, derivative of HD-DVD
     */
    CBHD("VQ", "CBHD"), //

    /**
     * Other video format not specified by VB to VP
     */
    Other_video_format("VZ", "Other video format"), //

    /**
     * Trade-only material (unspecified)
     */
    Trade_only_material("XA", "Trade-only material"), //

    Dumpbin_empty("XB", "Dumpbin – empty"), //

    /**
     * Dumpbin with contents. ISBN (where applicable) and format of contained items must be given in Product Part
     */
    Dumpbin_filled("XC", "Dumpbin – filled"), //

    Counterpack_empty("XD", "Counterpack – empty"), //

    /**
     * Counterpack with contents. ISBN (where applicable) and format of contained items must be given in Product Part
     */
    Counterpack_filled("XE", "Counterpack – filled"), //

    /**
     * Promotional poster for display, not for sale - see also PK
     */
    Poster_promotional("XF", "Poster, promotional"), //

    Shelf_strip("XG", "Shelf strip"), //

    /**
     * Promotional piece for shop window display
     */
    Window_piece("XH", "Window piece"), //

    Streamer("XI", "Streamer"), //

    Spinner("XJ", "Spinner"), //

    /**
     * Large scale facsimile of book for promotional display
     */
    Large_book_display("XK", "Large book display"), //

    /**
     * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for
     * sale individually. ISBN (where applicable) and format of contained items must be given in Product Part. For
     * products or product bundles supplied individually shrink-wrapped for retail sale, use code SD
     */
    Shrink_wrapped_pack("XL", "Shrink-wrapped pack"), //

    /**
     * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for
     * sale individually. ISBN (where applicable) and format of contained items must be given in Product Part. For
     * products or product bundles boxed individually for retail sale, use code SB
     */
    Boxed_pack("XM", "Boxed pack"), //

    /**
     * Other point of sale material not specified by XB to XL
     */
    Other_point_of_sale("XZ", "Other point of sale"), //

    /**
     * General merchandise - unspecified
     */
    General_merchandise("ZA", "General merchandise"), //

    Doll("ZB", "Doll"), //

    /**
     * Soft or plush toy
     */
    Soft_toy("ZC", "Soft toy"), //

    Toy("ZD", "Toy"), //

    /**
     * Board game, or other game (except computer game: see DE)
     */
    Game("ZE", "Game"), //

    T_shirt("ZF", "T-shirt"), //

    /**
     * Dedicated e-book reading device, typically with mono screen
     */
    E_book_reader("ZG", "E-book reader"), //

    /**
     * General purpose tablet computer, typically with color screen
     */
    Tablet_computer("ZH", "Tablet computer"), //

    /**
     * Dedicated audiobook player device, typically including book-related features like bookmarking
     */
    Audiobook_player("ZI", "Audiobook player"), //

    Jigsaw("ZJ", "Jigsaw"), //

    /**
     * Other apparel items not specified by ZB to ZJ, including promotional or branded scarves, caps, aprons etc
     */
    Other_apparel("ZY", "Other apparel"), //

    /**
     * Other merchandise not specified by ZB to ZY
     */
    Other_merchandise("ZZ", "Other merchandise");

    public final String code;
    public final String description;

    private ProductFormsList150(String code, String description) {
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

    private static volatile Map<String, ProductFormsList150> map;

    private static Map<String, ProductFormsList150> map() {
        Map<String, ProductFormsList150> result = map;
        if (result == null) {
            synchronized (ProductFormsList150.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductFormsList150 e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductFormsList150 byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
