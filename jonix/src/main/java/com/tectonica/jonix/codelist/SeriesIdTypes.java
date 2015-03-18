package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 13
 * 
 * @author Zach Melamed
 * 
 */
public enum SeriesIdTypes
{
	/**
	 * For example, publisher’s own series ID.
	 */
	Proprietary("01"),

	/**
	 * International Standard Serial Number, unhyphenated, 8 digits.
	 */
	ISSN("02"),

	/**
	 * Maintained by the Deutsche Nationalbibliothek.
	 */
	German_National_Bibliography_series_ID("03"),

	/**
	 * Maintained by VLB.
	 */
	German_Books_in_Print_series_ID("04"),

	/**
	 * Maintained by Electre Information, France.
	 */
	Electre_series_ID("05"),

	/**
	 * Digital Object Identifier (variable length and character set).
	 */
	DOI("06"),

	/**
	 * Use only where the collection (series or set) is available as a single product.
	 */
	ISBN13("15"),

	/**
	 * Uniform Resource Name.
	 */
	URN("22");

	public final String code;

	private SeriesIdTypes(String code)
	{
		this.code = code;
	}

	private static SeriesIdTypes[] values = SeriesIdTypes.values();
	public static SeriesIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SeriesIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

