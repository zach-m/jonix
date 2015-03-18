package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 60
 * 
 * @author Zach Melamed
 * 
 */
public enum UnitOfPricings
{
	/**
	 * Default.
	 */
	Per_copy_of_whole_product("00"),

	Per_page_for_printed_looseleaf_content_only("01");

	public final String code;

	private UnitOfPricings(String code)
	{
		this.code = code;
	}

	private static UnitOfPricings[] values = UnitOfPricings.values();
	public static UnitOfPricings fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UnitOfPricings item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

