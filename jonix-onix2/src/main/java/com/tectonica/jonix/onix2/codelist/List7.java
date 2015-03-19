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

package com.tectonica.jonix.onix2.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Product form code
 */
public enum List7
{
	Undefined("00"), //

	/**
	 * Audio recording – detail unspecified.
	 */
	Audio("AA"), //

	/**
	 * Audio cassette (analogue).
	 */
	Audio_cassette("AB"), //

	/**
	 * Audio compact disc, in any recording format: use for ‘red book’ (conventional audio CD) and SACD, and use coding in Product Form
	 * Detail to specify the format, if required.
	 */
	CD_Audio("AC"), //

	/**
	 * Digital audio tape cassette.
	 */
	DAT("AD"), //

	/**
	 * Audio disc (excluding CD-Audio).
	 */
	Audio_disc("AE"), //

	/**
	 * Audio tape (analogue open reel tape).
	 */
	Audio_tape("AF"), //

	/**
	 * Sony MiniDisc format.
	 */
	MiniDisc("AG"), //

	/**
	 * Audio compact disc with part CD-ROM content, also termed CD-Plus or Enhanced-CD: use for ‘blue book’ and ‘yellow/red book’
	 * two-session discs.
	 */
	CD_Extra("AH"), //

	DVD_Audio("AI"), //

	/**
	 * Audio recording downloadable online.
	 */
	Downloadable_audio_file("AJ"), //

	/**
	 * For example, Playaway audiobook and player: use coding in Product Form Detail to specify the recording format, if required.
	 */
	Pre_recorded_digital_audio_player("AK"), //

	/**
	 * For example, Audiofy audiobook chip.
	 */
	Pre_recorded_SD_card("AL"), //

	/**
	 * Other audio format not specified by AB to AL.
	 */
	Other_audio_format("AZ"), //

	/**
	 * Book – detail unspecified.
	 */
	Book("BA"), //

	/**
	 * Hardback or cased book.
	 */
	Hardback("BB"), //

	/**
	 * Paperback or other softback book.
	 */
	Paperback_softback("BC"), //

	/**
	 * Loose-leaf book.
	 */
	Loose_leaf("BD"), //

	/**
	 * Spiral, comb or coil bound book.
	 */
	Spiral_bound("BE"), //

	/**
	 * Pamphlet or brochure, stapled; German ‘geheftet’.
	 */
	Pamphlet("BF"), //

	Leather_fine_binding("BG"), //

	/**
	 * Child’s book with all pages printed on board.
	 */
	Board_book("BH"), //

	/**
	 * Child’s book with all pages printed on textile.
	 */
	Rag_book("BI"), //

	/**
	 * Child’s book printed on waterproof material.
	 */
	Bath_book("BJ"), //

	/**
	 * A book whose novelty consists wholly or partly in a format which cannot be described by any other available code – a ‘conventional’
	 * format code is always to be preferred; one or more Product Form Detail codes, eg from the B2nn group, should be used whenever
	 * possible to provide additional description.
	 */
	Novelty_book("BK"), //

	/**
	 * Slide bound book.
	 */
	Slide_bound("BL"), //

	/**
	 * Extra-large format for teaching etc; this format and terminology may be specifically UK; required as a top-level differentiator.
	 */
	Big_book("BM"), //

	/**
	 * A part-work issued with its own ISBN and intended to be collected and bound into a complete book.
	 */
	Part_work_fasc_culo("BN"), //

	/**
	 * Concertina-folded book or chart, designed to fold to pocket or regular page size: use for German ‘Leporello’.
	 */
	Fold_out_book_or_chart("BO"), //

	/**
	 * A children’s book whose cover and pages are made of foam.
	 */
	Foam_book("BP"), //

	/**
	 * Other book format or binding not specified by BB to BP.
	 */
	Other_book_format("BZ"), //

	/**
	 * Sheet map – detail unspecified.
	 */
	Sheet_map("CA"), //

	Sheet_map_folded("CB"), //

	Sheet_map_flat("CC"), //

	/**
	 * See Code List 80 for ‘rolled in tube’.
	 */
	Sheet_map_rolled("CD"), //

	/**
	 * Globe or planisphere.
	 */
	Globe("CE"), //

	/**
	 * Other cartographic format not specified by CB to CE.
	 */
	Other_cartographic("CZ"), //

	/**
	 * Digital or multimedia (detail unspecified).
	 */
	Digital("DA"), //

	CD_ROM("DB"), //

	/**
	 * CD interactive, use for ‘green book’ discs.
	 */
	CD_I("DC"), //

	/**
	 * DEPRECATED – use VI for DVD video, AI for DVD audio, DI for DVD-ROM.
	 */
	DVD("DD"), //

	Game_cartridge("DE"), //

	/**
	 * AKA ‘floppy disc’.
	 */
	Diskette("DF"), //

	/**
	 * Electronic book text in proprietary or open standard format.
	 */
	Electronic_book_text("DG"), //

	/**
	 * An electronic database or other resource or service accessible through online networks.
	 */
	Online_resource("DH"), //

	DVD_ROM("DI"), //

	Secure_Digital_SD("DJ"), //

	Compact_Flash_Memory_Card("DK"), //

	Memory_Stick_Memory_Card("DL"), //

	USB_Flash_Drive("DM"), //

	/**
	 * Double-sided disc, one side CD-Audio/CD-ROM, other side DVD-Audio/DVD-Video/DVD-ROM (at least one side must be -ROM).
	 */
	Double_sided_CD_DVD("DN"), //

	/**
	 * Digital product license delivered through the retail supply chain as a physical “key”, typically a card or booklet containing a code
	 * enabling the purchaser to download or activate the associated product.
	 */
	Digital_product_license_key("DO"), //

	/**
	 * Other digital or multimedia not specified by DB to DN.
	 */
	Other_digital("DZ"), //

	/**
	 * Film or transparency – detail unspecified.
	 */
	Film_or_transparency("FA"), //

	/**
	 * Continuous film or filmstrip: DEPRECATED – use FE or FF.
	 */
	Film("FB"), //

	/**
	 * Photographic transparencies mounted for projection.
	 */
	Slides("FC"), //

	/**
	 * Transparencies for overhead projector.
	 */
	OHP_transparencies("FD"), //

	Filmstrip("FE"), //

	/**
	 * Continuous movie film as opposed to filmstrip.
	 */
	Film_("FF"), //

	/**
	 * Other film or transparency format not specified by FB to FF.
	 */
	Other_film_or_transparency_format("FZ"), //

	/**
	 * Microform – detail unspecified.
	 */
	Microform("MA"), //

	Microfiche("MB"), //

	/**
	 * Roll microfilm.
	 */
	Microfilm("MC"), //

	/**
	 * Other microform not specified by MB or MC.
	 */
	Other_microform("MZ"), //

	/**
	 * Miscellaneous printed material – detail unspecified.
	 */
	Miscellaneous_print("PA"), //

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Address_book("PB"), //

	Calendar("PC"), //

	/**
	 * Cards, flash cards (eg for teaching reading).
	 */
	Cards("PD"), //

	/**
	 * Copymasters, photocopiable sheets.
	 */
	Copymasters("PE"), //

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Diary("PF"), //

	/**
	 * Narrow strip-shaped printed sheet used mostly for education or children’s products (eg depicting alphabet, number line, procession of
	 * illustrated characters etc). Usually intended for horizontal display.
	 */
	Frieze("PG"), //

	/**
	 * Parts for post-purchase assembly.
	 */
	Kit("PH"), //

	Sheet_music("PI"), //

	Postcard_book_or_pack("PJ"), //

	/**
	 * Poster for retail sale – see also XF.
	 */
	Poster("PK"), //

	/**
	 * Record book (eg ‘birthday book’, ‘baby book’): may use product form detail codes P201 to P204 to specify binding.
	 */
	Record_book("PL"), //

	/**
	 * Wallet or folder (containing loose sheets etc): it is preferable to code the contents and treat ‘wallet’ as packaging (List 80), but
	 * if this is not possible the product as a whole may be coded as a ‘wallet’.
	 */
	Wallet_or_folder("PM"), //

	Pictures_or_photographs("PN"), //

	Wallchart("PO"), //

	Stickers("PP"), //

	/**
	 * A book-sized (as opposed to poster-sized) sheet, usually in colour or high quality print.
	 */
	Plate_l_mina("PQ"), //

	/**
	 * A book with all pages blank for the buyer’s own use: may use product form detail codes P201 to P204 to specify binding.
	 */
	Notebook_blank_book("PR"), //

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Organizer("PS"), //

	Bookmark("PT"), //

	/**
	 * Other printed item not specified by PB to PT.
	 */
	Other_printed_item("PZ"), //

	/**
	 * Video – detail unspecified.
	 */
	Video("VA"), //

	/**
	 * DEPRECATED – use new VJ.
	 */
	Video_VHS_PAL("VB"), //

	/**
	 * DEPRECATED – use new VJ.
	 */
	Video_VHS_NTSC("VC"), //

	/**
	 * DEPRECATED – use new VK.
	 */
	Video_Betamax_PAL("VD"), //

	/**
	 * DEPRECATED – use new VK.
	 */
	Video_Betamax_NTSC("VE"), //

	/**
	 * eg Laserdisc.
	 */
	Videodisc("VF"), //

	/**
	 * DEPRECATED – use new VJ.
	 */
	Video_VHS_SECAM("VG"), //

	/**
	 * DEPRECATED – use new VK.
	 */
	Video_Betamax_SECAM("VH"), //

	/**
	 * DVD video: specify TV standard in List 78.
	 */
	DVD_video("VI"), //

	/**
	 * VHS videotape: specify TV standard in List 78.
	 */
	VHS_video("VJ"), //

	/**
	 * Betamax videotape: specify TV standard in List 78.
	 */
	Betamax_video("VK"), //

	/**
	 * VideoCD.
	 */
	VCD("VL"), //

	/**
	 * Super VideoCD.
	 */
	SVCD("VM"), //

	/**
	 * High definition DVD disc, Toshiba HD DVD format.
	 */
	HD_DVD("VN"), //

	/**
	 * High definition DVD disc, Sony Blu-ray format.
	 */
	Blu_ray("VO"), //

	/**
	 * Sony Universal Media disc.
	 */
	UMD_Video("VP"), //

	/**
	 * Other video format not specified by VB to VP.
	 */
	Other_video_format("VZ"), //

	/**
	 * A product consisting of two or more items in different media or different product forms, eg book and CD-ROM, book and toy, hardback
	 * book and e-book, etc.
	 */
	Mixed_media_product("WW"), //

	/**
	 * A product containing multiple copies of one or more items packaged together for retail sale, consisting of either (a) several copies
	 * of a single item (eg 6 copies of a graded reader), or (b) several copies of each of several items (eg 3 copies each of 3 different
	 * graded readers), or (c) several copies of one or more single items plus a single copy of one or more related items (eg 30 copies of a
	 * pupil’s textbook plus 1 of teacher’s text). NOT TO BE CONFUSED WITH: multi-volume sets, or sets containing a single copy of a number
	 * of different items (boxed, slip-cased or otherwise); items with several components of different physical forms (see WW); or packs
	 * intended for trade distribution only, where the contents are retailed separately (see XC, XE, XL).
	 */
	Multiple_copy_pack("WX"), //

	/**
	 * Trade-only material (unspecified).
	 */
	Trade_only_material("XA"), //

	Dumpbin_empty("XB"), //

	/**
	 * Dumpbin with contents.
	 */
	Dumpbin_filled("XC"), //

	Counterpack_empty("XD"), //

	/**
	 * Counterpack with contents.
	 */
	Counterpack_filled("XE"), //

	/**
	 * Promotional poster for display, not for sale – see also PK.
	 */
	Poster_promotional("XF"), //

	Shelf_strip("XG"), //

	/**
	 * Promotional piece for shop window display.
	 */
	Window_piece("XH"), //

	Streamer("XI"), //

	Spinner("XJ"), //

	/**
	 * Large scale facsimile of book for promotional display.
	 */
	Large_book_display("XK"), //

	/**
	 * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for sale individually –
	 * see also WX. For products or product bundles supplied shrink-wrapped for retail sale, use the Product Form code of the contents plus
	 * code 21 from List 80.
	 */
	Shrink_wrapped_pack("XL"), //

	/**
	 * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for sale individually –
	 * see also WX. For products or product bundles supplied boxed for retail sale, use the Product Form code of the contents plus code 09
	 * from List 80.
	 */
	Boxed_pack("XM"), //

	/**
	 * Other point of sale material not specified by XB to XL.
	 */
	Other_point_of_sale("XZ"), //

	/**
	 * General merchandise – unspecified.
	 */
	General_merchandise("ZA"), //

	Doll("ZB"), //

	/**
	 * Soft or plush toy.
	 */
	Soft_toy("ZC"), //

	Toy("ZD"), //

	/**
	 * Board game, or other game (except computer game: see DE).
	 */
	Game("ZE"), //

	T_shirt("ZF"), //

	/**
	 * Dedicated e-book reading device, typically with mono screen.
	 */
	E_book_reader("ZG"), //

	/**
	 * General purpose tablet computer, typically with color screen.
	 */
	Tablet_computer("ZH"), //

	/**
	 * Dedicated audiobook player device, typically including book-related features like bookmarking.
	 */
	Audiobook_player("ZI"), //

	Jigsaw("ZJ"), //

	/**
	 * Other apparel items not specified by ZB to ZJ, including promotional or branded scarves, caps, aprons etc.
	 */
	Other_apparel("ZY"), //

	/**
	 * Other merchandise not specified by ZB to ZY.
	 */
	Other_merchandise("ZZ");

	public final String value;

	private List7(String value)
	{
		this.value = value;
	}

	private static Map<String, List7> map;

	private static Map<String, List7> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List7 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List7 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
