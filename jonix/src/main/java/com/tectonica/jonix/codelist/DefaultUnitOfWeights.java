package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 95
 * 
 * @author Zach Melamed
 * 
 */
public enum DefaultUnitOfWeights
{
	Pounds_US("lb"),

	Grams("gr"),

	Ounces_US("oz");

	public final String code;

	private DefaultUnitOfWeights(String code)
	{
		this.code = code;
	}

	private static DefaultUnitOfWeights[] values = DefaultUnitOfWeights.values();
	public static DefaultUnitOfWeights fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (DefaultUnitOfWeights item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

