package com.tectonica.jonix.codelists;

/**
 * List 5
 * 
 * @author Zach Melamed
 *
 */
public enum ProductIDTypes
{
	Proprietary("01"),

	ISBN10("02"),

	GTIN13("03"),

	UPC("04"),

	ISMN10("05"),

	DOI("06"),

	LCCN("13"),

	GTIN14("14"),

	ISBN13("15"),

	Legal_deposit_number("17"),

	URN("22"),

	OCLC_number("23"),

	Copublisher_ISBN13("24"),

	ISMN13("25"),

	ISBNA("26"),

	JP_ecode("27"),

	OLCC_number("28");

	public final String code;

	private ProductIDTypes(String code)
	{
		this.code = code;
	}

	private static ProductIDTypes[] values = ProductIDTypes.values();

	public static ProductIDTypes fromCode(String code)
	{
		for (ProductIDTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}