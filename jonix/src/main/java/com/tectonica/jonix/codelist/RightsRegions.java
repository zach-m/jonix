package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 47
 * 
 * @author Zach Melamed
 * 
 */
public enum RightsRegions
{
	World("000"),

	World_except_territories_specified_elsewhere_in_rights_statements("001"),

	UK_airports("002"),

	/**
	 * Use when an open market edition is published under its own ISBN.
	 */
	UK__open_market("003");

	public final String code;

	private RightsRegions(String code)
	{
		this.code = code;
	}

	private static RightsRegions[] values = RightsRegions.values();
	public static RightsRegions fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (RightsRegions item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

