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
 * marker interface to assist in IDE navigation to code-list 7 (Product form code)
 */
interface CodeList7 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 7</b>
 * <p>
 * Description: Product form code
 * <p>
 * Jonix-Comment: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist7">ONIX
 * Codelist 7 in Reference Guide</a>
 */
public enum ProductFormsList7 implements OnixCodelist, CodeList7 {
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
     * Other audio format not specified by AB to AL
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
     * Other book format or binding not specified by BB to BP
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
     * Digital or multimedia (detail unspecified)
     */
    Digital("DA", "Digital"), //

    CD_ROM("DB", "CD-ROM"), //

    /**
     * CD interactive, use for 'green book' discs
     */
    CD_I("DC", "CD-I"), //

    /**
     * DEPRECATED - use VI for DVD video, AI for DVD audio, DI for DVD-ROM
     */
    DVD("DD", "DVD"), //

    Game_cartridge("DE", "Game cartridge"), //

    /**
     * AKA 'floppy disc'
     */
    Diskette("DF", "Diskette"), //

    /**
     * Electronic book text in proprietary or open standard format
     */
    Electronic_book_text("DG", "Electronic book text"), //

    /**
     * An electronic database or other resource or service accessible through online networks
     */
    Online_resource("DH", "Online resource"), //

    DVD_ROM("DI", "DVD-ROM"), //

    Secure_Digital_SD("DJ", "Secure Digital (SD) Memory Card"), //

    Compact_Flash_Memory_Card("DK", "Compact Flash Memory Card"), //

    Memory_Stick_Memory_Card("DL", "Memory Stick Memory Card"), //

    USB_Flash_Drive("DM", "USB Flash Drive"), //

    /**
     * Double-sided disc, one side CD-Audio/CD-ROM, other side DVD-Audio/DVD-Video/DVD-ROM (at least one side must be
     * -ROM)
     */
    Double_sided_CD_DVD("DN", "Double-sided CD/DVD"), //

    /**
     * Digital product license delivered through the retail supply chain as a physical 'key', typically a card or
     * booklet containing a code enabling the purchaser to download or activate the associated product
     */
    Digital_product_license_key("DO", "Digital product license key"), //

    /**
     * Other digital or multimedia not specified by DB to DN
     */
    Other_digital("DZ", "Other digital"), //

    /**
     * Film or transparency - detail unspecified
     */
    Film_or_transparency("FA", "Film or transparency"), //

    /**
     * Continuous film or filmstrip: DEPRECATED - use FE or FF
     */
    Film("FB", "Film"), //

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
    Film_("FF", "Film"), //

    /**
     * Other film or transparency format not specified by FB to FF
     */
    Other_film_or_transparency_format("FZ", "Other film or transparency format"), //

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
     * Record book (eg 'birthday book', 'baby book'): may use product form detail codes P201 to P204 to specify binding
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
     * A book with all pages blank for the buyer's own use: may use product form detail codes P201 to P204 to specify
     * binding
     */
    Notebook_blank_book("PR", "Notebook / blank book"), //

    /**
     * May use product form detail codes P201 to P204 to specify binding
     */
    Organizer("PS", "Organizer"), //

    Bookmark("PT", "Bookmark"), //

    /**
     * Other printed item not specified by PB to PT
     */
    Other_printed_item("PZ", "Other printed item"), //

    /**
     * Video - detail unspecified
     */
    Video("VA", "Video"), //

    /**
     * DEPRECATED - use new VJ
     */
    Video_VHS_PAL("VB", "Video, VHS, PAL"), //

    /**
     * DEPRECATED - use new VJ
     */
    Video_VHS_NTSC("VC", "Video, VHS, NTSC"), //

    /**
     * DEPRECATED - use new VK
     */
    Video_Betamax_PAL("VD", "Video, Betamax, PAL"), //

    /**
     * DEPRECATED - use new VK
     */
    Video_Betamax_NTSC("VE", "Video, Betamax, NTSC"), //

    /**
     * eg Laserdisc
     */
    Videodisc("VF", "Videodisc"), //

    /**
     * DEPRECATED - use new VJ
     */
    Video_VHS_SECAM("VG", "Video, VHS, SECAM"), //

    /**
     * DEPRECATED - use new VK
     */
    Video_Betamax_SECAM("VH", "Video, Betamax, SECAM"), //

    /**
     * DVD video: specify TV standard in List 78
     */
    DVD_video("VI", "DVD video"), //

    /**
     * VHS videotape: specify TV standard in List 78
     */
    VHS_video("VJ", "VHS video"), //

    /**
     * Betamax videotape: specify TV standard in List 78
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
     * Other video format not specified by VB to VP
     */
    Other_video_format("VZ", "Other video format"), //

    /**
     * A product consisting of two or more items in different media or different product forms, eg book and CD-ROM, book
     * and toy, hardback book and e-book, etc
     */
    Mixed_media_product("WW", "Mixed media product"), //

    /**
     * A product containing multiple copies of one or more items packaged together for retail sale, consisting of either
     * (a) several copies of a single item (eg 6 copies of a graded reader), or (b) several copies of each of several
     * items (eg 3 copies each of 3 different graded readers), or (c) several copies of one or more single items plus a
     * single copy of one or more related items (eg 30 copies of a pupil's textbook plus 1 of teacher's text). NOT TO BE
     * CONFUSED WITH: multi-volume sets, or sets containing a single copy of a number of different items (boxed,
     * slip-cased or otherwise); items with several components of different physical forms (see WW); or packs intended
     * for trade distribution only, where the contents are retailed separately (see XC, XE, XL)
     */
    Multiple_copy_pack("WX", "Multiple copy pack"), //

    /**
     * Trade-only material (unspecified)
     */
    Trade_only_material("XA", "Trade-only material"), //

    Dumpbin_empty("XB", "Dumpbin – empty"), //

    /**
     * Dumpbin with contents
     */
    Dumpbin_filled("XC", "Dumpbin – filled"), //

    Counterpack_empty("XD", "Counterpack – empty"), //

    /**
     * Counterpack with contents
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
     * sale individually - see also WX. For products or product bundles supplied shrink-wrapped for retail sale, use the
     * Product Form code of the contents plus code 21 from List 80
     */
    Shrink_wrapped_pack("XL", "Shrink-wrapped pack"), //

    /**
     * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for
     * sale individually - see also WX. For products or product bundles supplied boxed for retail sale, use the Product
     * Form code of the contents plus code 09 from List 80
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

    ProductFormsList7(String code, String description) {
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

    private static volatile Map<String, ProductFormsList7> map;

    private static Map<String, ProductFormsList7> map() {
        Map<String, ProductFormsList7> result = map;
        if (result == null) {
            synchronized (ProductFormsList7.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductFormsList7 e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductFormsList7 byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
