package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 35
 * 
 * @author Zach Melamed
 * 
 */
public enum TextLinkTypes
{
	URL("01"),

	DOI("02"),

	PURL("03"),

	URN("04"),

	FTP_address("05"),

	filename("06");

	public final String code;

	private TextLinkTypes(String code)
	{
		this.code = code;
	}

	private static TextLinkTypes[] values = TextLinkTypes.values();
	public static TextLinkTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextLinkTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

