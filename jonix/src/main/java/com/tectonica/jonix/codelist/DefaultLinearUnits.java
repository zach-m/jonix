package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 94
 * 
 * @author Zach Melamed
 * 
 */
public enum DefaultLinearUnits
{
	/**
	 * Millimeters are the preferred metric unit of length.
	 */
	Centimeters("cm"),

	Inches_US("in"),

	Millimeters("mm");

	public final String code;

	private DefaultLinearUnits(String code)
	{
		this.code = code;
	}

	private static DefaultLinearUnits[] values = DefaultLinearUnits.values();
	public static DefaultLinearUnits fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (DefaultLinearUnits item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

