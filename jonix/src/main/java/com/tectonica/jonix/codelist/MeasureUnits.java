package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 50
 * 
 * @author Zach Melamed
 * 
 */
public enum MeasureUnits
{
	/**
	 * Millimeters are the preferred metric unit of length.
	 */
	Centimeters("cm"),

	Grams("gr"),

	Inches_US("in"),

	/**
	 * Grams are the preferred metric unit of weight.
	 */
	Kilograms("kg"),

	Pounds_US("lb"),

	Millimeters("mm"),

	Ounces_US("oz"),

	Pixels("px");

	public final String code;

	private MeasureUnits(String code)
	{
		this.code = code;
	}

	private static MeasureUnits[] values = MeasureUnits.values();
	public static MeasureUnits fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (MeasureUnits item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

