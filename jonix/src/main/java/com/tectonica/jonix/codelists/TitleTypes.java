package com.tectonica.jonix.codelists;

/**
 * List 15
 * 
 * @author Zach Melamed
 *
 */
public enum TitleTypes
{
	Unspecified("00"),

	Distinctive("01"),

	ISSN_key_title_of_serial("02"),

	Title_in_original_language("03"),

	Title_acronym_or_initialism("04"),

	Abbreviated_title("05"),

	Title_in_other_language("06"),

	Thematic_title_of_journal_issue("07"),

	Former_title("08"),

	Distributor_title("10"),

	Alternative_title_on_cover("11"),

	Alternative_title_on_back("12"),

	Expanded_title("13");

	public final String code;

	private TitleTypes(String code)
	{
		this.code = code;
	}

	private static TitleTypes[] values = TitleTypes.values();

	public static TitleTypes fromCode(String code)
	{
		for (TitleTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}