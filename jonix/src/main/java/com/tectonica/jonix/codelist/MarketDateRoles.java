package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 67
 * 
 * @author Zach Melamed
 * 
 */
public enum MarketDateRoles
{
	/**
	 * The nominal date of publication in this market. If there is a strict embargo on retail sales before the expected date, it should be specified separately as an embargo date.
	 */
	Publication_date("01"),

	/**
	 * If there is an embargo on retail sales in this market before a certain date, the date from which the embargo is lifted and retail sales are permitted.
	 */
	Embargo_date("02");

	public final String code;

	private MarketDateRoles(String code)
	{
		this.code = code;
	}

	private static MarketDateRoles[] values = MarketDateRoles.values();
	public static MarketDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (MarketDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

