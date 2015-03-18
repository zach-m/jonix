package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 43
 * 
 * @author Zach Melamed
 * 
 */
public enum TextItemIdTypes
{
	/**
	 * For example, a publisher’s own identifier.
	 */
	Proprietary("01"),

	/**
	 * Formerly known as the EAN-13 (unhyphenated).
	 */
	GTIN13("03"),

	DOI("06"),

	/**
	 * Publisher item identifier.
	 */
	PII("09"),

	/**
	 * For serial items only.
	 */
	SICI("10"),

	/**
	 * (Unhyphenated).
	 */
	ISBN13("15");

	public final String code;

	private TextItemIdTypes(String code)
	{
		this.code = code;
	}

	private static TextItemIdTypes[] values = TextItemIdTypes.values();
	public static TextItemIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextItemIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

