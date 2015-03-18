package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 11
 * 
 * @author Zach Melamed
 * 
 */
public enum EpubFormats
{
	HTML("01"),

	PDF("02"),

	/**
	 * ‘.LIT’ file format used by Microsoft Reader software.
	 */
	Microsoft_Reader("03"),

	RocketBook("04"),

	Rich_text_format_RTF("05"),

	Open_Ebook_Publication_Structure_OEBPS_format_standard("06"),

	XML("07"),

	SGML("08"),

	/**
	 * ‘.EXE’ file format used when an epublication is delivered as a self-executing package of software and content.
	 */
	EXE("09"),

	/**
	 * ‘.TXT’ file format.
	 */
	ASCII("10"),

	/**
	 * Proprietary file format used for the MobiPocket reader software.
	 */
	MobiPocket_format("11");

	public final String code;

	private EpubFormats(String code)
	{
		this.code = code;
	}

	private static EpubFormats[] values = EpubFormats.values();
	public static EpubFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (EpubFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

