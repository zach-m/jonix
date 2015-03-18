package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 31
 * 
 * @author Zach Melamed
 * 
 */
public enum AudienceRangePrecisions
{
	Exact("01"),

	From("03"),

	To("04");

	public final String code;

	private AudienceRangePrecisions(String code)
	{
		this.code = code;
	}

	private static AudienceRangePrecisions[] values = AudienceRangePrecisions.values();
	public static AudienceRangePrecisions fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AudienceRangePrecisions item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

