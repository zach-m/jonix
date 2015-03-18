package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 90
 * 
 * @author Zach Melamed
 * 
 */
public enum ReligiousTextFeatures
{
	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Academic_year("01"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Catechistic_year("02"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Liturgical_year("03"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Advent_and_Christmas("04"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Blessings("05"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Scholastic_cycles("06"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Confirmation_and_Holy_Communion("07"),

	/**
	 * For example, summer camps and other youth recreational activities: use with code 01 in <ReligiousTextFeatureType>.
	 */
	Summer_activites("08"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Easter("09"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Lent("10"),

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Marian_themes("11");

	public final String code;

	private ReligiousTextFeatures(String code)
	{
		this.code = code;
	}

	private static ReligiousTextFeatures[] values = ReligiousTextFeatures.values();
	public static ReligiousTextFeatures fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ReligiousTextFeatures item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

