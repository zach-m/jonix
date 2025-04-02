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
 * marker interface to assist in IDE navigation to code-list 150 (Product form)
 */
interface CodeList150 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 150</b>
 * <p>
 * Description: Product form
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist150">ONIX
 *      Codelist 150 in Reference Guide</a>
 */
public enum ProductForms implements OnixCodelist, CodeList150 {
    Undefined("00", "Undefined"),

    /**
     * Audio recording - detail unspecified. Use only when the form is unknown and no further detail can be provided.
     * Prefer AZ plus &lt;ProductFormDescription&gt; if detail is available but no other A* code applies
     */
    Audio("AA", "Audio"),

    /**
     * Audio cassette (analogue)
     */
    Audio_cassette("AB", "Audio cassette"),

    /**
     * Audio compact disc: use for 'Red book' discs (conventional audio CD) and SACD, and use coding in
     * &lt;ProductFormDetail&gt; to specify the format, if required
     */
    CD_Audio("AC", "CD-Audio"),

    /**
     * Digital audio tape cassette
     */
    DAT("AD", "DAT"),

    /**
     * Audio disc (excluding CD-Audio): use for 'Yellow book' (CD-Rom-style) discs, including for example mp3 CDs, and
     * use coding in &lt;ProductFormDetail&gt; to specify the format of the data on the disc
     */
    Audio_disc("AE", "Audio disc"),

    /**
     * Audio tape (analogue open reel tape)
     */
    Audio_tape("AF", "Audio tape"),

    /**
     * Sony MiniDisc format
     */
    MiniDisc("AG", "MiniDisc"),

    /**
     * Audio compact disc with part CD-ROM content, also termed CD-Plus or Enhanced-CD: use for 'Blue book' and
     * 'Yellow/Red book' two-session discs
     */
    CD_Extra("AH", "CD-Extra"),

    DVD_Audio("AI", "DVD Audio"),

    /**
     * Digital audio recording downloadable to the purchaser's own device(s)
     */
    Downloadable_audio_file("AJ", "Downloadable audio file"),

    /**
     * For example, Playaway audiobook and player: use coding in &lt;ProductFormDetail&gt; to specify the recording
     * format, if required
     */
    Pre_recorded_digital_audio_player("AK", "Pre-recorded digital audio player"),

    /**
     * For example, Audiofy audiobook chip
     */
    Pre_recorded_SD_card("AL", "Pre-recorded SD card"),

    /**
     * Vinyl disc (analogue).
     * <p>
     * JONIX adds: Not included in Onix2
     */
    LP("AM", "LP"),

    /**
     * Digital audio recording available both by download to the purchaser's own device(s) and by online (eg streamed)
     * access
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Downloadable_and_online_audio_file("AN", "Downloadable and online audio file"),

    /**
     * Digital audio recording available online (eg streamed), not downloadable to the purchaser's own device(s)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Online_audio_file("AO", "Online audio file"),

    /**
     * Other audio format not specified by AB to AO. Further detail is expected in &lt;ProductFormDescription&gt;, as
     * &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be sufficient
     */
    Other_audio_format("AZ", "Other audio format"),

    /**
     * Book - detail unspecified. Use only when the form is unknown and no further detail can be provided. Prefer BZ
     * plus &lt;ProductFormDescription&gt; if detail is available but no other B* code applies
     */
    Book("BA", "Book"),

    /**
     * Hardback or cased book
     */
    Hardback("BB", "Hardback"),

    /**
     * Paperback or other softback book
     */
    Paperback_softback("BC", "Paperback / softback"),

    /**
     * Loose-leaf book
     */
    Loose_leaf("BD", "Loose-leaf"),

    /**
     * Spiral, comb or coil bound book
     */
    Spiral_bound("BE", "Spiral bound"),

    /**
     * Pamphlet, stapled (de: 'geheftet'). Includes low-extent wire-stitched books bound without a distinct spine (eg
     * many comic book 'floppies')
     */
    Pamphlet("BF", "Pamphlet"),

    /**
     * Use &lt;ProductFormDetail&gt; to provide additional description
     */
    Leather_fine_binding("BG", "Leather / fine binding"),

    /**
     * Child's book with all pages printed on board
     */
    Board_book("BH", "Board book"),

    /**
     * Child's book with all pages printed on textile
     */
    Rag_book("BI", "Rag book"),

    /**
     * Child's book printed on waterproof material
     */
    Bath_book("BJ", "Bath book"),

    /**
     * A book whose novelty consists wholly or partly in a format which cannot be described by any other available code
     * - a 'conventional' format code is always to be preferred; one or more Product Form Detail codes, eg from the B2nn
     * group, should be used whenever possible to provide additional description
     */
    Novelty_book("BK", "Novelty book"),

    /**
     * Slide bound book
     */
    Slide_bound("BL", "Slide bound"),

    /**
     * Extra-large format for teaching etc; this format and terminology may be specifically UK; required as a top-level
     * differentiator
     */
    Big_book("BM", "Big book"),

    /**
     * A part-work issued with its own ISBN and intended to be collected and bound into a complete book.
     */
    Part_work_fasciculo("BN", "Part-work (fascículo)"),

    /**
     * Concertina-folded booklet or chart, designed to fold to pocket or regular page size, and usually bound within
     * distinct board or card covers (de: 'Leporello')
     */
    Fold_out_book_or_chart("BO", "Fold-out book or chart"),

    /**
     * A children's book whose cover and pages are made of foam
     */
    Foam_book("BP", "Foam book"),

    /**
     * Other book format or binding not specified by BB to BP. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_book_format("BZ", "Other book format"),

    /**
     * Sheet map - detail unspecified. Use only when the form is unknown and no further detail can be provided. Prefer
     * CZ plus &lt;ProductFormDescription&gt; if detail is available but no other C* code applies
     */
    Sheet_map("CA", "Sheet map"),

    Sheet_map_folded("CB", "Sheet map, folded"),

    Sheet_map_flat("CC", "Sheet map, flat"),

    /**
     * See &lt;ProductPackaging&gt; and Codelist 80 for 'rolled in tube'
     */
    Sheet_map_rolled("CD", "Sheet map, rolled"),

    /**
     * Globe or planisphere
     */
    Globe("CE", "Globe"),

    /**
     * Other cartographic format not specified by CB to CE. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_cartographic("CZ", "Other cartographic"),

    /**
     * Digital content delivered on a physical carrier (detail unspecified). Use only when the form is unknown and no
     * further detail can be provided. Prefer DZ plus &lt;ProductFormDescription&gt; if detail is available but no other
     * D* code applies
     */
    Digital_on_physical_carrier("DA", "Digital (on physical carrier)"),

    CD_ROM("DB", "CD-ROM"),

    /**
     * CD interactive: use for 'Green book' discs
     */
    CD_I("DC", "CD-I"),

    Game_cartridge("DE", "Game cartridge"),

    /**
     * AKA 'floppy disc'
     */
    Diskette("DF", "Diskette"),

    DVD_ROM("DI", "DVD-ROM"),

    Secure_Digital_SD("DJ", "Secure Digital (SD) Memory Card"),

    Compact_Flash_Memory_Card("DK", "Compact Flash Memory Card"),

    Memory_Stick_Memory_Card("DL", "Memory Stick Memory Card"),

    USB_Flash_Drive("DM", "USB Flash Drive"),

    /**
     * Double-sided disc, one side Audio CD/CD-ROM, other side DVD
     */
    Double_sided_CD_DVD("DN", "Double-sided CD/DVD"),

    /**
     * (Blu Ray ROM)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    BR_ROM("DO", "BR-ROM"),

    /**
     * Other carrier of digital content not specified by DB to DO. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_digital_carrier("DZ", "Other digital carrier"),

    /**
     * Digital content delivered electronically (delivery method unspecified). Use only when the form and delivery
     * method is unknown, or when no other E* code applies and the delivery method is described in
     * &lt;ProductFormDescription&gt;. Note, use &lt;ProductFormDetail&gt; to specify file format
     */
    Digital_delivered_electronically("EA", "Digital (delivered electronically)"),

    /**
     * Digital content available both by download and by online access
     */
    Digital_download_and_online("EB", "Digital download and online"),

    /**
     * Digital content accessed online only (eg streamed), not downloadable to the purchaser's own device(s)
     */
    Digital_online("EC", "Digital online"),

    /**
     * Digital content delivered by download only
     */
    Digital_download("ED", "Digital download"),

    /**
     * Film or transparency - detail unspecified. Use only when the form is unknown and no further detail can be
     * provided. Prefer FZ plus &lt;ProductFormDescription&gt; if detail is available but no other F* code applies
     */
    Film_or_transparency("FA", "Film or transparency"),

    /**
     * Photographic transparencies mounted for projection
     */
    Slides("FC", "Slides"),

    /**
     * Transparencies for overhead projector
     */
    OHP_transparencies("FD", "OHP transparencies"),

    /**
     * Photographic transparencies, unmounted but cut into short multi-frame strips
     */
    Filmstrip("FE", "Filmstrip"),

    /**
     * Continuous movie film as opposed to filmstrip
     */
    Film("FF", "Film"),

    /**
     * Other film or transparency format not specified by FB to FF. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_film_or_transparency_format("FZ", "Other film or transparency format"),

    /**
     * Digital product license (delivery method unspecified). Use only when the form is unknown, or when no other L*
     * code applies and the delivery method is described in &lt;ProductFormDescription&gt;
     */
    Digital_product_license("LA", "Digital product license"),

    /**
     * Digital product license delivered through the retail supply chain as a physical 'key', typically a card or
     * booklet containing a code enabling the purchaser to download the associated product
     */
    Digital_product_license_key("LB", "Digital product license key"),

    /**
     * Digital product license delivered by email or other electronic distribution, typically providing a code enabling
     * the purchaser to activate, upgrade or extend the license supplied with the associated product
     */
    Digital_product_license_code("LC", "Digital product license code"),

    /**
     * Microform - detail unspecified. Use only when the form is unknown and no further detail can be provided. Prefer
     * MZ plus &lt;ProductFormDescription&gt; if detail is available but no other M* code applies
     */
    Microform("MA", "Microform"),

    Microfiche("MB", "Microfiche"),

    /**
     * Roll microfilm
     */
    Microfilm("MC", "Microfilm"),

    /**
     * Other microform not specified by MB or MC. Further detail is expected in &lt;ProductFormDescription&gt;, as
     * &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be sufficient
     */
    Other_microform("MZ", "Other microform"),

    /**
     * Miscellaneous printed material - detail unspecified. Use only when the form is unknown and no further detail can
     * be provided. Prefer PZ plus &lt;ProductFormDescription&gt; if detail is available but no other P* code applies
     */
    Miscellaneous_print("PA", "Miscellaneous print"),

    /**
     * May use &lt;ProductFormDetail&gt; codes P201 to P204 to specify binding
     */
    Address_book("PB", "Address book"),

    Calendar("PC", "Calendar"),

    /**
     * Cards, flash cards (eg for teaching reading), revision cards, divination, playing or trading cards
     */
    Cards("PD", "Cards"),

    /**
     * Copymasters, photocopiable sheets
     */
    Copymasters("PE", "Copymasters"),

    /**
     * May use &lt;ProductFormDetail&gt; codes P201 to P204 to specify binding
     */
    Diary_or_journal("PF", "Diary or journal"),

    /**
     * Narrow strip-shaped printed sheet used mostly for education or children's products (eg depicting alphabet, number
     * line, procession of illustrated characters etc). Usually intended for horizontal display
     */
    Frieze("PG", "Frieze"),

    /**
     * Parts for post-purchase assembly, including card, wood or plastic parts or model components, interlocking
     * construction blocks, beads and other crafting materials etc
     */
    Kit("PH", "Kit"),

    /**
     * May use &lt;ProductFormDetail&gt; codes P201 to P204 to specify binding
     */
    Sheet_music("PI", "Sheet music"),

    /**
     * Including greeting cards and packs. For bound books (usually with perforated sheets to remove cards), may use
     * &lt;ProductFormDetail&gt; codes P201 to P204 to specify binding
     */
    Postcard_book_or_pack("PJ", "Postcard book or pack"),

    /**
     * Poster for retail sale - see also XF
     */
    Poster("PK", "Poster"),

    /**
     * Record book (eg 'birthday book', 'baby book'): binding unspecified; may use &lt;ProductFormDetail&gt; codes P201
     * to P204 to specify binding
     */
    Record_book("PL", "Record book"),

    /**
     * Wallet, folder or box (containing loose sheets etc, or empty): it is preferable to code the contents and treat
     * 'wallet' (or folder / box) as packaging in &lt;ProductPackaging&gt; with Codelist 80, but if this is not possible
     * (eg where the product is empty and intended for storing other loose items) the product as a whole may be coded as
     * a 'wallet'. For binders intended for loose leaf or partwork publications intended to be updateable, see codes BD,
     * BN
     */
    Wallet_or_folder("PM", "Wallet or folder"),

    Pictures_or_photographs("PN", "Pictures or photographs"),

    Wallchart("PO", "Wallchart"),

    Stickers("PP", "Stickers"),

    /**
     * A book-sized (as opposed to poster-sized) sheet, usually in color or high quality print
     */
    Plate_lamina("PQ", "Plate (lámina)"),

    /**
     * A book with all pages blank for the buyer's own use; may use &lt;ProductFormDetail&gt; codes P201 to P204 to
     * specify binding
     */
    Notebook_blank_book("PR", "Notebook / blank book"),

    /**
     * May use &lt;ProductFormDetail&gt; codes P201 to P204 to specify binding
     */
    Organizer("PS", "Organizer"),

    Bookmark("PT", "Bookmark"),

    /**
     * Folded but unbound
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Leaflet("PU", "Leaflet"),

    /**
     * Ex libris' book labels and packs
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Book_plates("PV", "Book plates"),

    /**
     * Other printed item not specified by PB to PQ. Further detail is expected in &lt;ProductFormDescription&gt;, as
     * &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be sufficient
     */
    Other_printed_item("PZ", "Other printed item"),

    /**
     * Presentation unspecified: format of product components must be given in &lt;ProductPart&gt;. Use only when the
     * packaging of the product is unknown, or when no other S* code applies and the presentation is described in
     * &lt;ProductFormDescription&gt;
     */
    Multiple_component_retail_product("SA", "Multiple-component retail product"),

    /**
     * Format of product components must be given in &lt;ProductPart&gt;
     */
    Multiple_component_retail_product_boxed("SB", "Multiple-component retail product, boxed"),

    /**
     * Format of product components must be given in &lt;ProductPart&gt;
     */
    Multiple_component_retail_product_slip_cased("SC", "Multiple-component retail product, slip-cased"),

    /**
     * Format of product components must be given in &lt;ProductPart&gt;. Use code XL for a shrink-wrapped pack for
     * trade supply, where the retail items it contains are intended for sale individually
     */
    Multiple_component_retail_product_shrink_wrapped("SD", "Multiple-component retail product, shrink-wrapped"),

    /**
     * Format of product components must be given in &lt;ProductPart&gt;
     */
    Multiple_component_retail_product_loose("SE", "Multiple-component retail product, loose"),

    /**
     * Multiple component product where subsidiary product part(s) is/are supplied as enclosures to the primary part, eg
     * a book with a CD packaged in a sleeve glued within the back cover. Format of product components must be given in
     * &lt;ProductPart&gt;
     */
    Multiple_component_retail_product_part_s("SF", "Multiple-component retail product, part(s) enclosed"),

    /**
     * Multiple component product where all parts are digital, and delivered as separate files, eg a group of individual
     * EPUB files, an EPUB with a PDF, an e-book with a license to access a range of online resources, etc. Format of
     * product components must be given in &lt;ProductPart&gt;
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Multiple_component_retail_product_entirely_digital("SG", "Multiple-component retail product, entirely digital"),

    /**
     * Video - detail unspecified. Use only when the form is unknown and no further detail can be provided. Prefer VZ
     * plus &lt;ProductFormDescription&gt; if detail is available but no other V* code applies
     */
    Video("VA", "Video"),

    /**
     * eg Laserdisc
     */
    Videodisc("VF", "Videodisc"),

    /**
     * DVD video: specify TV standard in &lt;ProductFormDetail&gt;
     */
    DVD_video("VI", "DVD video"),

    /**
     * VHS videotape: specify TV standard in &lt;ProductFormDetail&gt;
     */
    VHS_video("VJ", "VHS video"),

    /**
     * Betamax videotape: specify TV standard in &lt;ProductFormDetail&gt;
     */
    Betamax_video("VK", "Betamax video"),

    /**
     * VideoCD
     */
    VCD("VL", "VCD"),

    /**
     * Super VideoCD
     */
    SVCD("VM", "SVCD"),

    /**
     * High definition DVD disc, Toshiba HD DVD format
     */
    HD_DVD("VN", "HD DVD"),

    /**
     * High definition DVD disc, Sony Blu-ray format
     */
    Blu_ray("VO", "Blu-ray"),

    /**
     * Sony Universal Media disc
     */
    UMD_Video("VP", "UMD Video"),

    /**
     * China Blue High-Definition, derivative of HD-DVD
     */
    CBHD("VQ", "CBHD"),

    /**
     * Other video format not specified by VB to VQ. Further detail is expected in &lt;ProductFormDescription&gt;, as
     * &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be sufficient
     */
    Other_video_format("VZ", "Other video format"),

    /**
     * Trade-only material (unspecified). Use only when the form is unknown and no further detail can be provided.
     * Prefer XZ plus &lt;ProductFormDescription&gt; if detail is available but no other X* code applies
     */
    Trade_only_material("XA", "Trade-only material"),

    Dumpbin_empty("XB", "Dumpbin – empty"),

    /**
     * Dumpbin with contents. ISBN (where applicable) and format of contained items must be given in &lt;ProductPart&gt;
     */
    Dumpbin_filled("XC", "Dumpbin – filled"),

    Counterpack_empty("XD", "Counterpack – empty"),

    /**
     * Counterpack with contents. ISBN (where applicable) and format of contained items must be given in
     * &lt;ProductPart&gt;
     */
    Counterpack_filled("XE", "Counterpack – filled"),

    /**
     * Promotional poster for display, not for sale - see also PK
     */
    Poster_promotional("XF", "Poster, promotional"),

    Shelf_strip("XG", "Shelf strip"),

    /**
     * Promotional piece for shop window display
     */
    Window_piece("XH", "Window piece"),

    Streamer("XI", "Streamer"),

    Spinner_empty("XJ", "Spinner – empty"),

    /**
     * Large scale facsimile of book for promotional display
     */
    Large_book_display("XK", "Large book display"),

    /**
     * A quantity pack with its own product code, usually for trade supply only: the retail items it contains are
     * intended for sale individually. ISBN (where applicable) and format of contained items must be given in
     * &lt;ProductPart&gt;. For products or product bundles supplied individually shrink-wrapped for retail sale, use
     * code SD
     */
    Shrink_wrapped_pack("XL", "Shrink-wrapped pack"),

    /**
     * A quantity pack with its own product code, usually for trade supply only: the retail items it contains are
     * intended for sale individually. ISBN (where applicable) and format of contained items must be given in
     * &lt;ProductPart&gt;. For products or product bundles boxed individually for retail sale, use code SB
     */
    Boxed_pack("XM", "Boxed pack"),

    /**
     * A quantity pack with its own product code, usually for trade supply only: the retail items it contains are
     * intended for sale individually. ISBN (where applicable) and format of contained items must be given in
     * &lt;ProductPart&gt;. Use only when the pack is neither shrinp-wrapped nor boxed
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pack_outer_packaging_unspecified("XN", "Pack (outer packaging unspecified)"),

    /**
     * Spinner with contents. ISBN(s) (where applicable) and detail of contained items must be given in
     * &lt;ProductPart&gt;
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Spinner_filled("XO", "Spinner – filled"),

    /**
     * Other point of sale material not specified by XB to XO, supplied with included product(s) for retail sale. The
     * retail product(s) must be described in &lt;ProductPart&gt;. Further detail of the POS material is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Other_point_of_sale_including_retail_product("XY", "Other point of sale – including retail product"),

    /**
     * Other point of sale material not specified by XB to XY, promotional or decorative. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_point_of_sale("XZ", "Other point of sale"),

    /**
     * General merchandise, book accessories and non-book products - unspecified. Use only when the form is unknown and
     * no further detail can be provided. Prefer ZX, ZY or ZZ, plus &lt;ProductFormDescription&gt; if detail is
     * available but no other Z* code applies
     */
    General_merchandise("ZA", "General merchandise"),

    /**
     * Including action figures, figurines
     */
    Doll_or_figure("ZB", "Doll or figure"),

    /**
     * Soft or plush toy
     */
    Soft_toy("ZC", "Soft toy"),

    /**
     * Including educational toys (where no other code is relevant)
     */
    Toy("ZD", "Toy"),

    /**
     * Board game, or other game (except computer game: see DE and other D* codes)
     */
    Game("ZE", "Game"),

    T_shirt("ZF", "T-shirt"),

    /**
     * Dedicated e-book reading device, typically with mono screen
     */
    E_book_reader("ZG", "E-book reader"),

    /**
     * General purpose tablet computer, typically with color screen
     */
    Tablet_computer("ZH", "Tablet computer"),

    /**
     * Dedicated audiobook player device, typically including book-related features like bookmarking
     */
    Audiobook_player("ZI", "Audiobook player"),

    /**
     * Jigsaw or similar 'shapes' puzzle
     */
    Jigsaw("ZJ", "Jigsaw"),

    /**
     * For example, branded, promotional or tie-in drinking mug, cup etc
     */
    Mug("ZK", "Mug"),

    /**
     * For example, branded, promotional or tie-in bag
     */
    Tote_bag("ZL", "Tote bag"),

    /**
     * For example, branded, promotional or tie-in plates, bowls etc (note for mugs and cups, use code ZK)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Tableware("ZM", "Tableware"),

    /**
     * For example, branded, promotional or tie-in umbrella
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Umbrella("ZN", "Umbrella"),

    /**
     * Coloring set, including pens, chalks, etc
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Paints_crayons_pencils("ZO", "Paints, crayons, pencils"),

    /**
     * Handicraft kit or set, eg sewing, crochet, weaving, basketry, beadwork, leather, wood or metalworking, pottery
     * and glassworking, candlemaking etc
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Handicraft_kit("ZP", "Handicraft kit"),

    /**
     * Other toy, game and puzzle items not specified by ZB to ZQ, generally accessories to other products etc. Further
     * detail is expected in &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt;
     * are unlikely to be sufficient
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Other_toy_game_accessories("ZX", "Other toy/game accessories"),

    /**
     * Other apparel items not specified by ZB to ZQ, including branded, promotional or tie-in scarves, caps, aprons,
     * dress-up costumes etc. Further detail is expected in &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt;
     * and &lt;ProductFormFeature&gt; are unlikely to be sufficient
     */
    Other_apparel("ZY", "Other apparel"),

    /**
     * Other branded, promotional or tie-in merchandise not specified by ZB to ZY. Further detail is expected in
     * &lt;ProductFormDescription&gt;, as &lt;ProductFormDetail&gt; and &lt;ProductFormFeature&gt; are unlikely to be
     * sufficient
     */
    Other_merchandise("ZZ", "Other merchandise");

    public final String code;
    public final String description;

    ProductForms(String code, String description) {
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

    private static volatile Map<String, ProductForms> map;

    private static Map<String, ProductForms> map() {
        Map<String, ProductForms> result = map;
        if (result == null) {
            synchronized (ProductForms.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductForms e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductForms byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductForms> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
