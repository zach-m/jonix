package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 168
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceConditionQuantityTypes
{
	/**
	 * The price condition quantity represents a time period.
	 */
	Time_period("01"),

	/**
	 * The price condition quantity is a number of updates.
	 */
	Number_of_updates("02");

	public final String code;

	private PriceConditionQuantityTypes(String code)
	{
		this.code = code;
	}

	private static PriceConditionQuantityTypes[] values = PriceConditionQuantityTypes.values();
	public static PriceConditionQuantityTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceConditionQuantityTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

