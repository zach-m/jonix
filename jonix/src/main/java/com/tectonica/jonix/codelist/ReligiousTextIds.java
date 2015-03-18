package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 88
 * 
 * @author Zach Melamed
 * 
 */
public enum ReligiousTextIds
{
;

	public final String code;

	private ReligiousTextIds(String code)
	{
		this.code = code;
	}

	private static ReligiousTextIds[] values = ReligiousTextIds.values();
	public static ReligiousTextIds fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ReligiousTextIds item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

