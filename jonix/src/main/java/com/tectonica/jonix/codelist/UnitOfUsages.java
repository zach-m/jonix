package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 147
 * 
 * @author Zach Melamed
 * 
 */
public enum UnitOfUsages
{
	/**
	 * Maximum number of copies that may be made of a permitted extract.
	 */
	Copies("01"),

	/**
	 * Maximum number of characters in a permitted extract for a specified usage.
	 */
	Characters("02"),

	/**
	 * Maximum number of words in a permitted extract for a specified usage.
	 */
	Words("03"),

	/**
	 * Maximum number of pages in a permitted extract for a specified usage.
	 */
	Pages("04"),

	/**
	 * Maximum percentage of total content in a permitted extract for a specified usage.
	 */
	Percentage("05"),

	/**
	 * Maximum number of devices in ‘share group’.
	 */
	Devices("06"),

	/**
	 * Maximum number of concurrent users. NB where the number of concurrent users is specifically not limited, set the number of concurrent users to zero.
	 */
	Concurrent_users("07"),

	/**
	 * Maximum percentage of total content which may be used in a specified usage per time period; the time period being specified as another EpubUsageQuantity.
	 */
	Percentage_per_time_period("08"),

	/**
	 * Maximum time period in days.
	 */
	Days("09"),

	/**
	 * Maximum time period in weeks.
	 */
	Weeks("13"),

	/**
	 * Maximum time period in months.
	 */
	Months("14"),

	/**
	 * Maximum number of times a specified usage may occur.
	 */
	Times("10"),

	/**
	 * Page number where allowed usage begins. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type of page numbering should not be used where the e-publication has no fixed pagination). Use with (max number of) Pages, Percentage of content, or End page to specify pages allowed in Preview.
	 */
	Allowed_usage_start_page("11"),

	/**
	 * Page number at which allowed usage ends. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type of page numbering should not be used where the e-publication has no fixed pagination). Use with Start page to specify pages allowed in a preview.
	 */
	Allowed_usage_end_page("12");

	public final String code;

	private UnitOfUsages(String code)
	{
		this.code = code;
	}

	private static UnitOfUsages[] values = UnitOfUsages.values();
	public static UnitOfUsages fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UnitOfUsages item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

