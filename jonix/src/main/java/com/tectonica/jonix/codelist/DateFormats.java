package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 55
 * 
 * @author Zach Melamed
 * 
 */
public enum DateFormats
{
	/**
	 * Year month day (default).
	 */
	YYYYMMDD("00"),

	/**
	 * Year and month.
	 */
	YYYYMM("01"),

	/**
	 * Year and week number.
	 */
	YYYYWW("02"),

	/**
	 * Year and quarter (Q = 1, 2, 3, 4).
	 */
	YYYYQ("03"),

	/**
	 * Year and season (S = 1, 2, 3, 4, with 1 = “Spring”).
	 */
	YYYYS("04"),

	/**
	 * Year.
	 */
	YYYY("05"),

	/**
	 * Spread of exact dates.
	 */
	YYYYMMDDYYYYMMDD("06"),

	/**
	 * Spread of months.
	 */
	YYYYMMYYYYMM("07"),

	/**
	 * Spread of week numbers.
	 */
	YYYYWWYYYYWW("08"),

	/**
	 * Spread of quarters.
	 */
	YYYYQYYYYQ("09"),

	/**
	 * Spread of seasons.
	 */
	YYYYSYYYYS("10"),

	/**
	 * Spread of years.
	 */
	YYYYYYYY("11"),

	/**
	 * For complex, approximate or uncertain dates.
	 */
	Text_string("12"),

	/**
	 * Exact time. Use ONLY when exact times with hour/minute precision are relevant. By default, time is local. Alternatively, the time may be suffixed with an optional ‘Z’ for UTC times, or with ‘+’ or ‘-’ and an hhmm timezone offset from UTC. Times without a timezone are ‘rolling’ local times, times qualified with a timezone (using Z, + or -) specify a particular instant in time.
	 */
	YYYYMMDDThhmm("13"),

	/**
	 * Exact time. Use ONLY when exact times with second precision are relevant. By default, time is local. Alternatively, the time may be suffixed with an optional ‘Z’ for UTC times, or with ‘+’ or ‘-’ and an hhmm timezone offset from UTC. Times without a timezone are ‘rolling’ local times, times qualified with a timezone (using Z, + or -) specify a particular instant in time.
	 */
	YYYYMMDDThhmmss("14"),

	/**
	 * Year month day (Hijri calendar).
	 */
	YYYYMMDD_H("20"),

	/**
	 * Year and month (Hijri calendar).
	 */
	YYYYMM_H("21"),

	/**
	 * Year (Hijri calendar).
	 */
	YYYY_H("25"),

	/**
	 * For complex, approximate or uncertain dates (Hijri calendar), text would usually be in Arabic script.
	 */
	Text_string_H("32");

	public final String code;

	private DateFormats(String code)
	{
		this.code = code;
	}

	private static DateFormats[] values = DateFormats.values();
	public static DateFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (DateFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

