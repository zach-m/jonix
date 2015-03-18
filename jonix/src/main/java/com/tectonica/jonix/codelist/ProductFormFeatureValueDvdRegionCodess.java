package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 76
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductFormFeatureValueDvdRegionCodess
{
	/**
	 * DVD or Blu-Ray.
	 */
	All_regions("0"),

	/**
	 * US, US Territories, Canada.
	 */
	DVD_region_1("1"),

	/**
	 * Japan, Europe, South Africa and Middle East (including Egypt).
	 */
	DVD_region_2("2"),

	/**
	 * Southeast Asia, Hong Kong, Macau, South Korea, and Taiwan.
	 */
	DVD_region_3("3"),

	/**
	 * Australia, New Zealand, Pacific Islands, Central America, Mexico, South America and the Caribbean.
	 */
	DVD_region_4("4"),

	/**
	 * Eastern Europe (former Soviet Union), Indian subcontinent, Africa, North Korea and Mongolia.
	 */
	DVD_region_5("5"),

	/**
	 * People’s Republic of China (except Macau and Hong Kong).
	 */
	DVD_region_6("6"),

	/**
	 * Reserved for future use.
	 */
	DVD_region_7("7"),

	/**
	 * International venues: aircraft, cruise ships etc.
	 */
	DVD_region_8("8"),

	/**
	 * North America, Central America, South America, Japan, Taiwan, North Korea, South Korea, Hong Kong, and Southeast Asia.
	 */
	BluRay_region_A("A"),

	/**
	 * Most of Europe, Greenland, French territories, Middle East, Africa, Australia, and New Zealand, plus all of Oceania.
	 */
	BluRay_region_B("B"),

	/**
	 * India, Bangladesh, Nepal, Mainland China, Pakistan, Russia, Ukraine, Belarus, Central, and South Asia.
	 */
	BluRay_region_C("C");

	public final String code;

	private ProductFormFeatureValueDvdRegionCodess(String code)
	{
		this.code = code;
	}

	private static ProductFormFeatureValueDvdRegionCodess[] values = ProductFormFeatureValueDvdRegionCodess.values();
	public static ProductFormFeatureValueDvdRegionCodess fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductFormFeatureValueDvdRegionCodess item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

