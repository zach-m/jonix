package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 66
 * 
 * @author Zach Melamed
 * 
 */
public enum BisacReturnableIndicators
{
	No__not_returnable("N"),

	Yes__returnable__full_copies_only("Y"),

	Yes__returnable__stripped_cover("S"),

	/**
	 * Contact publisher for requirements and/or authorization.
	 */
	Conditional("C");

	public final String code;

	private BisacReturnableIndicators(String code)
	{
		this.code = code;
	}

	private static BisacReturnableIndicators[] values = BisacReturnableIndicators.values();
	public static BisacReturnableIndicators fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (BisacReturnableIndicators item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

