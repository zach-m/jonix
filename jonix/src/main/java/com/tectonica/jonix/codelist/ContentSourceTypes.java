package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 157
 * 
 * @author Zach Melamed
 * 
 */
public enum ContentSourceTypes
{
	Printed_media("01"),

	Website("02"),

	Radio("03"),

	TV("04");

	public final String code;

	private ContentSourceTypes(String code)
	{
		this.code = code;
	}

	private static ContentSourceTypes[] values = ContentSourceTypes.values();
	public static ContentSourceTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ContentSourceTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

