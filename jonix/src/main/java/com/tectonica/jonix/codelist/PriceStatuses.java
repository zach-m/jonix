package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 61
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceStatuses
{
	/**
	 * Default.
	 */
	Unspecified("00"),

	Provisional("01"),

	Firm("02");

	public final String code;

	private PriceStatuses(String code)
	{
		this.code = code;
	}

	private static PriceStatuses[] values = PriceStatuses.values();
	public static PriceStatuses fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceStatuses item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

