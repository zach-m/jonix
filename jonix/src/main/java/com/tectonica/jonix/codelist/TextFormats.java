package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 34
 * 
 * @author Zach Melamed
 * 
 */
public enum TextFormats
{
	/**
	 * DEPRECATED: use code 06 or 07 as appropriate.
	 */
	ASCII_text("00"),

	SGML("01"),

	/**
	 * Other than XHTML.
	 */
	HTML("02"),

	/**
	 * Other than XHTML.
	 */
	XML("03"),

	/**
	 * DEPRECATED: was formerly assigned both to PDF and to XHTML.
	 */
	PDF("04"),

	XHTML("05"),

	/**
	 * Default: text in the encoding declared at the head of the message or in the XML default (UTF-8 or UTF-16) if there is no explicit declaration.
	 */
	Default_text_format("06"),

	/**
	 * Plain text containing no tags of any kind, except for the tags &amp; and &lt; that XML insists must be used to represent ampersand and less-than characters in text; and with the character set limited to the ASCII range, i.e. valid UTF-8 characters whose character number lies between 32 (space) and 126 (tilde).
	 */
	Basic_ASCII_text("07"),

	/**
	 * Replaces 04 for the <TextFormat> element, but cannot of course be used as a textformat attribute.
	 */
	PDF_("08"),

	Microsoft_rich_text_format_RTF("09"),

	Microsoft_Word_binary_format_DOC("10"),

	/**
	 * Office Open XML file format / OOXML / DOCX.
	 */
	ECMA_376_WordprocessingML("11"),

	/**
	 * ISO Open Document Format.
	 */
	ISO_26300_ODF("12"),

	Corel_Wordperfect_binary_format_DOC("13"),

	/**
	 * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum (IDPF) [File extension .epub].
	 */
	EPUB("14"),

	/**
	 * XML Paper Specification.
	 */
	XPS("15");

	public final String code;

	private TextFormats(String code)
	{
		this.code = code;
	}

	private static TextFormats[] values = TextFormats.values();
	public static TextFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

