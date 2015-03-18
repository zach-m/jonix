package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 174
 * 
 * @author Zach Melamed
 * 
 */
public enum PrintedOnProducts
{
	/**
	 * Price not printed on product.
	 */
	No("01"),

	/**
	 * Price printed on product.
	 */
	Yes("02");

	public final String code;

	private PrintedOnProducts(String code)
	{
		this.code = code;
	}

	private static PrintedOnProducts[] values = PrintedOnProducts.values();
	public static PrintedOnProducts fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PrintedOnProducts item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

