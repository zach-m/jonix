package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 89
 * 
 * @author Zach Melamed
 * 
 */
public enum ReligiousTextFeatureTypes
{
	/**
	 * A church season or activity for which a religious text is intended.
	 */
	Church_season_or_activity("01");

	public final String code;

	private ReligiousTextFeatureTypes(String code)
	{
		this.code = code;
	}

	private static ReligiousTextFeatureTypes[] values = ReligiousTextFeatureTypes.values();
	public static ReligiousTextFeatureTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ReligiousTextFeatureTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

