package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 152
 * 
 * @author Zach Melamed
 * 
 */
public enum IllustratedNotIllustrateds
{
	/**
	 * Not illustrated.
	 */
	No("01"),

	/**
	 * Illustrated.
	 */
	Yes("02");

	public final String code;

	private IllustratedNotIllustrateds(String code)
	{
		this.code = code;
	}

	private static IllustratedNotIllustrateds[] values = IllustratedNotIllustrateds.values();
	public static IllustratedNotIllustrateds fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (IllustratedNotIllustrateds item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

