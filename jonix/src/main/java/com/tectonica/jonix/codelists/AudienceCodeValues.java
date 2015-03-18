package com.tectonica.jonix.codelists;

/**
 * List 28
 * 
 * @author Zach Melamed
 *
 */
public enum AudienceCodeValues
{
	General_or_trade("01"),
	
	Children_or_juvenile("02"),
	
	Young_adult("03"),
	
	Primary_and_secondary_or_elementary_and_high_school("04"),
	
	College_or_higher_education("05"),
	
	Professional_and_scholarly("06"),
	
	ELT_or_ESL("07"),
	
	Adult_education("08");
	
	public final String code;

	private AudienceCodeValues(String code)
	{
		this.code = code;
	}

	private static AudienceCodeValues[] values = AudienceCodeValues.values();

	public static AudienceCodeValues fromCode(String code)
	{
		for (AudienceCodeValues item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
