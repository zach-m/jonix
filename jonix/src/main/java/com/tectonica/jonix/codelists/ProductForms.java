package com.tectonica.jonix.codelists;

/**
 * List 7
 * 
 * @author Zach Melamed
 *
 */
public enum ProductForms
{
	Unspecified("00"),

	Audio("AA"),

	Audio_cassette("AB"),

	CD_Audio("AC"),

	DAT("AD"),

	Audio_disc("AE"),

	Audio_tape("AF"),

	MiniDisc("AG"),

	CD_Extra("AH"),

	DVD_Audio("AI"),

	Downloadable_audio_file("AJ"),

	Pre_recorded_digital_audio_player("AK"),

	Pre_recorded_SD_card("AL"),

	Other_audio_format("AZ"),

	Book("BA"),

	Hardback("BB"),

	Paperback_or_softback("BC"),

	Loose_leaf("BD"),

	Spiral_bound("BE"),

	Pamphlet("BF"),

	Leather_or_fine_binding("BG"),

	Board_book("BH"),

	Rag_book("BI"),

	Bath_book("BJ"),

	Novelty_book("BK"),

	Slide_bound("BL"),

	Big_book("BM"),

	Part_work_fasciculo("BN"),

	Fold_out_book_or_chart("BO"),

	Foam_book("BP"),

	Other_book_format("BZ"),

	Sheet_map("CA"),

	Sheet_map_folded("CB"),

	Sheet_map_flat("CC"),

	Sheet_map_rolled("CD"),

	Globe("CE"),

	Other_cartographic("CZ"),

	Digital("DA"),

	CD_ROM("DB"),

	CD_I("DC"),

	DVD("DD"),

	Game_cartridge("DE"),

	Diskette("DF"),

	Electronic_book_text("DG"),

	Online_resource("DH"),

	DVD_ROM("DI"),

	Secure_Digital_SD_Memory_Card("DJ"),

	Compact_Flash_Memory_Card("DK"),

	Memory_Stick_Memory_Card("DL"),

	USB_Flash_Drive("DM"),

	Double_sided_CDorDVD("DN"),

	Other_digital("DZ"),

	Film_or_transparency("FA"),

	Film_Deprecated("FB"),

	Slides("FC"),

	OHP_transparencies("FD"),

	Filmstrip("FE"),

	Film("FF"),

	Other_film_or_transparency_format("FZ"),

	Microform("MA"),

	Microfiche("MB"),

	Microfilm("MC"),

	Other_microform("MZ"),

	Miscellaneous_print("PA"),

	Address_book("PB"),

	Calendar("PC"),

	Cards("PD"),

	Copymasters("PE"),

	Diary("PF"),

	Frieze("PG"),

	Kit("PH"),

	Sheet_music("PI"),

	Postcard_book_or_pack("PJ"),

	Poster("PK"),

	Record_book("PL"),

	Wallet_or_folder("PM"),

	Pictures_or_photographs("PN"),

	Wallchart("PO"),

	Stickers("PP"),

	Plate_lamina("PQ"),

	Notebook_or_blank_book("PR"),

	Organizer("PS"),

	Bookmark("PT"),

	Other_printed_item("PZ"),

	Video("VA"),

	Video_VHS_PAL("VB"),

	Video_VHS_NTSC("VC"),

	Video_Betamax_PAL("VD"),

	Video_Betamax_NTSC("VE"),

	Videodisc("VF"),

	Video_VHS_SECAM("VG"),

	Video_Betamax_SECAM("VH"),

	DVD_video("VI"),

	VHS_video("VJ"),

	Betamax_video("VK"),

	VCD("VL"),

	SVCD("VM"),

	HD_DVD("VN"),

	Blu_ray("VO"),

	UMD_Video("VP"),

	Other_video_format("VZ"),

	Mixed_media_product("WW"),

	Multiple_copy_pack("WX"),

	Trade_only_material("XA"),

	Dumpbin_empty("XB"),

	Dumpbin_filled("XC"),

	Counterpack_empty("XD"),

	Counterpack_filled("XE"),

	Poster_promotional("XF"),

	Shelf_strip("XG"),

	Window_piece("XH"),

	Streamer("XI"),

	Spinner("XJ"),

	Large_book_display("XK"),

	Shrink_wrapped_pack("XL"),

	Other_point_of_sale("XZ"),

	General_merchandise("ZA"),

	Doll("ZB"),

	Soft_toy("ZC"),

	Toy("ZD"),

	Game("ZE"),

	T_shirt("ZF"),

	Other_merchandise("ZZ");

	public final String code;

	private ProductForms(String code)
	{
		this.code = code;
	}

	private static ProductForms[] values = ProductForms.values();

	public static ProductForms fromCode(String code)
	{
		for (ProductForms item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
