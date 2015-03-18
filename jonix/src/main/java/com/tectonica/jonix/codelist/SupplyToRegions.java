package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 52
 * 
 * @author Zach Melamed
 * 
 */
public enum SupplyToRegions
{
	/**
	 * When the same ISBN is used for open market and UK editions.
	 */
	UK__open_market("004");

	public final String code;

	private SupplyToRegions(String code)
	{
		this.code = code;
	}

	private static SupplyToRegions[] values = SupplyToRegions.values();
	public static SupplyToRegions fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupplyToRegions item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

