package com.tectonica.jonix.codelists;

/**
 * List 34
 * 
 * @author Zach Melamed
 *
 */
public enum TextFormats
{
	ASCII("00"),

	SGML("01"),

	HTML("02"),

	XML("03"),

	PDF_Deprecated("04"),

	XHTML("05"),

	Default_text_format("06"),

	Basic_ASCII_text("07"),

	PDF("08"),

	RTF("09"),

	Microsoft_Word("10"),

	ECMA_376_WordprocessingML("11"),

	ISO_26300_ODF("12"),

	Corel_Wordperfect("13"),

	EPUB("14"),

	XPS("15");

	public final String code;

	private TextFormats(String code)
	{
		this.code = code;
	}

	private static TextFormats[] values = TextFormats.values();

	public static TextFormats fromCode(String code)
	{
		for (TextFormats item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
