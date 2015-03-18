package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 150
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductForms
{
	Undefined("00"),

	/**
	 * Audio recording – detail unspecified.
	 */
	Audio("AA"),

	/**
	 * Audio cassette (analogue).
	 */
	Audio_cassette("AB"),

	/**
	 * Audio compact disc, in any recording format: use coding in Product Form Detail to specify the format, if required.
	 */
	CDAudio("AC"),

	/**
	 * Digital audio tape cassette.
	 */
	DAT("AD"),

	/**
	 * Audio disc (excluding CD).
	 */
	Audio_disc("AE"),

	/**
	 * Audio tape (reel tape).
	 */
	Audio_tape("AF"),

	/**
	 * Sony MiniDisc format.
	 */
	MiniDisc("AG"),

	/**
	 * Audio compact disc with part CD-ROM content.
	 */
	CDExtra("AH"),

	DVD_Audio("AI"),

	/**
	 * Audio recording downloadable online.
	 */
	Downloadable_audio_file("AJ"),

	/**
	 * For example, Playaway audiobook and player: use coding in Product Form Detail to specify the recording format, if required.
	 */
	Prerecorded_digital_audio_player("AK"),

	/**
	 * For example, Audiofy audiobook chip.
	 */
	Prerecorded_SD_card("AL"),

	/**
	 * Other audio format not specified by AB to AK.
	 */
	Other_audio_format("AZ"),

	/**
	 * Book – detail unspecified.
	 */
	Book("BA"),

	/**
	 * Hardback or cased book.
	 */
	Hardback("BB"),

	/**
	 * Paperback or other softback book.
	 */
	Paperback___softback("BC"),

	/**
	 * Loose-leaf book.
	 */
	Looseleaf("BD"),

	/**
	 * Spiral, comb or coil bound book.
	 */
	Spiral_bound("BE"),

	/**
	 * Pamphlet or brochure, stapled; German ‘geheftet’.
	 */
	Pamphlet("BF"),

	Leather___fine_binding("BG"),

	/**
	 * Child’s book with all pages printed on board.
	 */
	Board_book("BH"),

	/**
	 * Child’s book with all pages printed on textile.
	 */
	Rag_book("BI"),

	/**
	 * Child’s book printed on waterproof material.
	 */
	Bath_book("BJ"),

	/**
	 * A book whose novelty consists wholly or partly in a format which cannot be described by any other available code – a ‘conventional’ format code is always to be preferred; one or more Product Form Detail codes, eg from the B2nn group, should be used whenever possible to provide additional description.
	 */
	Novelty_book("BK"),

	/**
	 * Slide bound book.
	 */
	Slide_bound("BL"),

	/**
	 * Extra-large format for teaching etc; this format and terminology may be specifically UK; required as a top-level differentiator.
	 */
	Big_book("BM"),

	/**
	 * A part-work issued with its own ISBN and intended to be collected and bound into a complete book.
	 */
	Partwork_fasc_culo("BN"),

	/**
	 * Concertina-folded book or chart, designed to fold to pocket or regular page size: use for German ‘Leporello’.
	 */
	Foldout_book_or_chart("BO"),

	/**
	 * A children’s book whose cover and pages are made of foam.
	 */
	Foam_book("BP"),

	/**
	 * Other book format or binding not specified by BB to BO.
	 */
	Other_book_format("BZ"),

	/**
	 * Sheet map – detail unspecified.
	 */
	Sheet_map("CA"),

	Sheet_map__folded("CB"),

	Sheet_map__flat("CC"),

	/**
	 * See Code List 80 for ‘rolled in tube’.
	 */
	Sheet_map__rolled("CD"),

	/**
	 * Globe or planisphere.
	 */
	Globe("CE"),

	/**
	 * Other cartographic format not specified by CB to CE.
	 */
	Other_cartographic("CZ"),

	/**
	 * Digital content delivered on a physical carrier (detail unspecified).
	 */
	Digital_on_physical_carrier("DA"),

	CDROM("DB"),

	/**
	 * CD interactive.
	 */
	CDI("DC"),

	Game_cartridge("DE"),

	/**
	 * AKA ‘floppy disc’.
	 */
	Diskette("DF"),

	DVDROM("DI"),

	Secure_Digital_SD_Memory_Card("DJ"),

	Compact_Flash_Memory_Card("DK"),

	Memory_Stick_Memory_Card("DL"),

	USB_Flash_Drive("DM"),

	/**
	 * Double-sided disc, one side Audio CD/CD-ROM, other side DVD.
	 */
	Doublesided_CD_DVD("DN"),

	/**
	 * Other carrier of digital content not specified by DB to DN.
	 */
	Other_digital_carrier("DZ"),

	/**
	 * Digital content delivered electronically (delivery method unspecified).
	 */
	Digital_delivered_electronically("EA"),

	/**
	 * Digital content available both by download and by online access.
	 */
	Digital_download_and_online("EB"),

	/**
	 * Digital content accessed online only.
	 */
	Digital_online("EC"),

	/**
	 * Digital content delivered by download only.
	 */
	Digital_download("ED"),

	/**
	 * Film or transparency – detail unspecified.
	 */
	Film_or_transparency("FA"),

	/**
	 * Photographic transparencies mounted for projection.
	 */
	Slides("FC"),

	/**
	 * Transparencies for overhead projector.
	 */
	OHP_transparencies("FD"),

	Filmstrip("FE"),

	/**
	 * Continuous movie film as opposed to filmstrip.
	 */
	Film("FF"),

	/**
	 * Other film or transparency format not specified by FB to FF.
	 */
	Other_film_or_transparency_format("FZ"),

	/**
	 * Digital product license (delivery method not encoded).
	 */
	Digital_product_license("LA"),

	/**
	 * Digital product license delivered through the retail supply chain as a physical “key”, typically a card or booklet containing a code enabling the purchaser to download the associated product.
	 */
	Digital_product_license_key("LB"),

	/**
	 * Digital product license delivered by email or other electronic distribution, typically providing a code enabling the purchaser to upgrade or extend the license supplied with the associated product.
	 */
	Digital_product_license_code("LC"),

	/**
	 * Microform – detail unspecified.
	 */
	Microform("MA"),

	Microfiche("MB"),

	/**
	 * Roll microfilm.
	 */
	Microfilm("MC"),

	/**
	 * Other microform not specified by MB or MC.
	 */
	Other_microform("MZ"),

	/**
	 * Miscellaneous printed material – detail unspecified.
	 */
	Miscellaneous_print("PA"),

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Address_book("PB"),

	Calendar("PC"),

	/**
	 * Cards, flash cards (eg for teaching reading).
	 */
	Cards("PD"),

	/**
	 * Copymasters, photocopiable sheets.
	 */
	Copymasters("PE"),

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Diary("PF"),

	/**
	 * Narrow strip-shaped printed sheet used mostly for education or children’s products (eg depicting alphabet, number line, procession of illustrated characters etc). Usually intended for horizontal display.
	 */
	Frieze("PG"),

	/**
	 * Parts for post-purchase assembly.
	 */
	Kit("PH"),

	Sheet_music("PI"),

	Postcard_book_or_pack("PJ"),

	/**
	 * Poster for retail sale – see also XF.
	 */
	Poster("PK"),

	/**
	 * Record book (eg ‘birthday book’, ‘baby book’): binding unspecified; may use product form detail codes P201 to P204 to specify binding.
	 */
	Record_book("PL"),

	/**
	 * Wallet or folder (containing loose sheets etc): it is preferable to code the contents and treat ‘wallet’ as packaging (List 80), but if this is not possible the product as a whole may be coded as a ‘wallet’.
	 */
	Wallet_or_folder("PM"),

	Pictures_or_photographs("PN"),

	Wallchart("PO"),

	Stickers("PP"),

	/**
	 * A book-sized (as opposed to poster-sized) sheet, usually in colour or high quality print.
	 */
	Plate_l_mina("PQ"),

	/**
	 * A book with all pages blank for the buyer’s own use; may use product form detail codes P201 to P204 to specify binding.
	 */
	Notebook___blank_book("PR"),

	/**
	 * May use product form detail codes P201 to P204 to specify binding.
	 */
	Organizer("PS"),

	Bookmark("PT"),

	/**
	 * Other printed item not specified by PB to PQ.
	 */
	Other_printed_item("PZ"),

	/**
	 * Presentation unspecified: format of product items must be given in <ProductPart>.
	 */
	Multipleitem_retail_product("SA"),

	/**
	 * Format of product items must be given in <ProductPart>.
	 */
	Multipleitem_retail_product__boxed("SB"),

	/**
	 * Format of product items must be given in <ProductPart>.
	 */
	Multipleitem_retail_product__slipcased("SC"),

	/**
	 * Format of product items must be given in <ProductPart>. Use code XL for a shrink-wrapped pack for trade supply, where the retail items it contains are intended for sale individually.
	 */
	Multipleitem_retail_product__shrinkwrapped("SD"),

	/**
	 * Format of product items must be given in <ProductPart>.
	 */
	Multipleitem_retail_product__loose("SE"),

	/**
	 * Multiple item product where subsidiary product part(s) is/are supplied as enclosures to the primary part, eg a book with a CD packaged in a sleeve glued within the back cover. Format of product items must be given in <ProductPart>.
	 */
	Multipleitem_retail_product__parts_enclosed("SF"),

	/**
	 * Video – detail unspecified.
	 */
	Video("VA"),

	/**
	 * eg Laserdisc.
	 */
	Videodisc("VF"),

	/**
	 * DVD video: specify TV standard in List 78.
	 */
	DVD_video("VI"),

	/**
	 * VHS videotape: specify TV standard in List 78.
	 */
	VHS_video("VJ"),

	/**
	 * Betamax videotape: specify TV standard in List 78.
	 */
	Betamax_video("VK"),

	/**
	 * VideoCD.
	 */
	VCD("VL"),

	/**
	 * Super VideoCD.
	 */
	SVCD("VM"),

	/**
	 * High definition DVD disc, Toshiba HD DVD format.
	 */
	HD_DVD("VN"),

	/**
	 * High definition DVD disc, Sony Blu-ray format.
	 */
	Bluray("VO"),

	/**
	 * Sony Universal Media disc.
	 */
	UMD_Video("VP"),

	/**
	 * Other video format not specified by VB to VP.
	 */
	Other_video_format("VZ"),

	/**
	 * Trade-only material (unspecified).
	 */
	Tradeonly_material("XA"),

	Dumpbin___empty("XB"),

	/**
	 * Dumpbin with contents. ISBN (where applicable) and format of contained items must be given in Product Part.
	 */
	Dumpbin___filled("XC"),

	Counterpack___empty("XD"),

	/**
	 * Counterpack with contents. ISBN (where applicable) and format of contained items must be given in Product Part.
	 */
	Counterpack___filled("XE"),

	/**
	 * Promotional poster for display, not for sale – see also PK.
	 */
	Poster__promotional("XF"),

	Shelf_strip("XG"),

	/**
	 * Promotional piece for shop window display.
	 */
	Window_piece("XH"),

	Streamer("XI"),

	Spinner("XJ"),

	/**
	 * Large scale facsimile of book for promotional display.
	 */
	Large_book_display("XK"),

	/**
	 * A quantity pack with its own product code, for trade supply only: the retail items it contains are intended for sale individually. ISBN (where applicable) and format of contained items must be given in Product Part. For products or product bundles supplied shrink-wrapped for retail sale, use code SD.
	 */
	Shrinkwrapped_pack("XL"),

	/**
	 * Other point of sale material not specified by XB to XL.
	 */
	Other_point_of_sale("XZ"),

	/**
	 * General merchandise – unspecified.
	 */
	General_merchandise("ZA"),

	Doll("ZB"),

	/**
	 * Soft or plush toy.
	 */
	Soft_toy("ZC"),

	Toy("ZD"),

	/**
	 * Board game, or other game (except computer game: see DE).
	 */
	Game("ZE"),

	Tshirt("ZF"),

	/**
	 * Other merchandise not specified by ZB to ZF.
	 */
	Other_merchandise("ZZ");

	public final String code;

	private ProductForms(String code)
	{
		this.code = code;
	}

	private static ProductForms[] values = ProductForms.values();
	public static ProductForms fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductForms item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

