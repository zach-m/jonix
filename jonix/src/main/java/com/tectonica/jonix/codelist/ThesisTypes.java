package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 72
 * 
 * @author Zach Melamed
 * 
 */
public enum ThesisTypes
{
	/**
	 * Professorial dissertation (thesis for postdoctoral lecturing qualification).
	 */
	Habilitationsschrift("01"),

	/**
	 * Doctoral thesis.
	 */
	Dissertationsschrift("02"),

	/**
	 * State examination thesis.
	 */
	Staatsexamensarbeit("03"),

	/**
	 * Magisters degree thesis.
	 */
	Magisterarbeit("04"),

	/**
	 * Diploma degree thesis.
	 */
	Diplomarbeit("05"),

	/**
	 * Bachelors degree thesis.
	 */
	Bachelorarbeit("06"),

	/**
	 * Masters degree thesis.
	 */
	Masterarbeit("07");

	public final String code;

	private ThesisTypes(String code)
	{
		this.code = code;
	}

	private static ThesisTypes[] values = ThesisTypes.values();
	public static ThesisTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ThesisTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

