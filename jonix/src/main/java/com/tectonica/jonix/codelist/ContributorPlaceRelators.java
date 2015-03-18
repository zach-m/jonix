package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 151
 * 
 * @author Zach Melamed
 * 
 */
public enum ContributorPlaceRelators
{
	Born_in("01"),

	Died_in("02"),

	Formerly_resided_in("03"),

	Currently_resides_in("04"),

	Educated_in("05"),

	Worked_in("06"),

	Flourished_in("07"),

	/**
	 * Or nationality. For use with country codes only.
	 */
	Citizen_of("08");

	public final String code;

	private ContributorPlaceRelators(String code)
	{
		this.code = code;
	}

	private static ContributorPlaceRelators[] values = ContributorPlaceRelators.values();
	public static ContributorPlaceRelators fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ContributorPlaceRelators item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

