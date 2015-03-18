package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 41
 * 
 * @author Zach Melamed
 * 
 */
public enum PrizeOrAwardAchievements
{
	Winner("01"),

	/**
	 * Named as being in second place.
	 */
	Runnerup("02"),

	Commended("03"),

	/**
	 * Nominated by the judging process to be one of the final ‘short-list’ from which the winner is selected.
	 */
	Shortlisted("04"),

	/**
	 * Nominated by the judging process to be one of the preliminary ‘long-list’ from which first a short-list and then the winner is selected.
	 */
	Longlisted("05"),

	/**
	 * Or co-winner.
	 */
	Joint_winner("06");

	public final String code;

	private PrizeOrAwardAchievements(String code)
	{
		this.code = code;
	}

	private static PrizeOrAwardAchievements[] values = PrizeOrAwardAchievements.values();
	public static PrizeOrAwardAchievements fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PrizeOrAwardAchievements item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

