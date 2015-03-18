package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 169
 * 
 * @author Zach Melamed
 * 
 */
public enum QuantityUnits
{
	/**
	 * The quantity refers to a unit implied by the quantity type.
	 */
	Units("00"),

	Days("07"),

	Weeks("08"),

	Months("09"),

	Years("10");

	public final String code;

	private QuantityUnits(String code)
	{
		this.code = code;
	}

	private static QuantityUnits[] values = QuantityUnits.values();
	public static QuantityUnits fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (QuantityUnits item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

