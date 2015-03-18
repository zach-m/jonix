package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 24
 * 
 * @author Zach Melamed
 * 
 */
public enum ExtentUnits
{
	/**
	 * Words of natural language text.
	 */
	Words("02"),

	Pages("03"),

	Hours_integer_and_decimals("04"),

	Minutes_integer_and_decimals("05"),

	Seconds_integer_only("06"),

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_HHH("14"),

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_and_minutes_HHHMM("15"),

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_minutes_seconds_HHHMMSS("16"),

	Bytes("17"),

	Kbytes("18"),

	Mbytes("19");

	public final String code;

	private ExtentUnits(String code)
	{
		this.code = code;
	}

	private static ExtentUnits[] values = ExtentUnits.values();
	public static ExtentUnits fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ExtentUnits item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

