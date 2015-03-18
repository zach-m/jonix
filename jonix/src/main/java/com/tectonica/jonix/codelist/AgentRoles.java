package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 69
 * 
 * @author Zach Melamed
 * 
 */
public enum AgentRoles
{
	/**
	 * Publisher’s exclusive sales agent in a specified territory.
	 */
	Exclusive_sales_agent("05"),

	/**
	 * Publisher’s non-exclusive sales agent in a specified territory.
	 */
	Nonexclusive_sales_agent("06"),

	/**
	 * Publisher for a specified territory.
	 */
	Local_publisher("07"),

	/**
	 * Publisher’s sales agent in a specific territory. Use only where exclusive / non-exclusive status is not known. Prefer 05 or 06 as appropriate, where possible.
	 */
	Sales_agent("08");

	public final String code;

	private AgentRoles(String code)
	{
		this.code = code;
	}

	private static AgentRoles[] values = AgentRoles.values();
	public static AgentRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AgentRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

