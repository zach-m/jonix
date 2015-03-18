package com.tectonica.jonix.codelists;

/**
 * List 10
 * 
 * @author Zach Melamed
 *
 */
public enum EpubTypes
{
	Epublication_content_package("000"),

	HTML("001"),

	PDF("002"),

	PDF_Merchant("003"),

	Adobe_Ebook_Reader("004"),

	Microsoft_Reader_Level_1_or_Level_3("005"),

	Microsoft_Reader_Level_5("006"),

	NetLibrary("007"),

	MetaText("008"),

	MightyWords("009"),

	eReader_AKA_Palm_Reader("010"),

	Softbook("011"),

	RocketBook("012"),

	Gemstar_REB_1100("013"),

	Gemstar_REB_1200("014"),

	Franklin_eBookman("015"),

	Books24x7("016"),

	DigitalOwl("017"),

	Handheldmed("018"),

	WizeUp("019"),

	TK3("020"),

	Litraweb("021"),

	MobiPocket("022"),

	Open_Ebook("023"),

	Town_Compass_DataViewer("024"),

	TXT("025"),

	ExeBook("026"),

	Sony_BBeB("027"),

	VitalSource_Bookshelf("028"),

	EPUB("029"),

	MyiLibrary("030"),

	Kindle("031"),

	Google_Edition("032"),

	Vook("033"),

	DXReader("034"),

	EBL("035"),

	Ebrary("036"),

	iSilo("037"),

	Plucker("038"),

	VitalBook("039"),

	Book_app_for_iOS("040"),

	Android_app("041"),

	Other_app("042"),

	XPS("043"),

	iBook("044"),

	ePIB("045"),

	Multiple_formats("098"),

	Unspecified("099");

	public final String code;

	private EpubTypes(String code)
	{
		this.code = code;
	}

	private static EpubTypes[] values = EpubTypes.values();

	public static EpubTypes fromCode(String code)
	{
		for (EpubTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
