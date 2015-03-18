package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 173
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceDateRoles
{
	/**
	 * Date on which a price becomes effective.
	 */
	From_date("14"),

	/**
	 * Date on which a price ceases to be effective.
	 */
	Until_date("15"),

	/**
	 * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat 06.
	 */
	From__until_date("24");

	public final String code;

	private PriceDateRoles(String code)
	{
		this.code = code;
	}

	private static PriceDateRoles[] values = PriceDateRoles.values();
	public static PriceDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

