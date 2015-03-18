package com.tectonica.jonix.codelists;

/**
 * List 13
 * 
 * @author Zach Melamed
 *
 */
public enum SeriesIDTypes
{
	Proprietary("01"),
	
	ISSN("02"),

	German_National_Bibliography_series_ID("03"),

	German_Books_in_Print_series_ID("04"),

	Electre_series_ID("05"),

	DOI("06"),

	ISBN_13("15"),

	URN("22");

	public final String code;

	private SeriesIDTypes(String code)
	{
		this.code = code;
	}

	private static SeriesIDTypes[] values = SeriesIDTypes.values();

	public static SeriesIDTypes fromCode(String code)
	{
		for (SeriesIDTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
