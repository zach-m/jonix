package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 170
 * 
 * @author Zach Melamed
 * 
 */
public enum DiscountTypes
{
;

	public final String code;

	private DiscountTypes(String code)
	{
		this.code = code;
	}

	private static DiscountTypes[] values = DiscountTypes.values();
	public static DiscountTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (DiscountTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

