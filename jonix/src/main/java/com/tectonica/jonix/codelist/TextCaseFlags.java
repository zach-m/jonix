package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 14
 * 
 * @author Zach Melamed
 * 
 */
public enum TextCaseFlags
{
	/**
	 * Default.
	 */
	Undefined("00"),

	/**
	 * Initial capitals on first word and subsequently on proper names only, eg “The conquest of Mexico”.
	 */
	Sentence_case("01"),

	/**
	 * Initial capitals on first word and on all significant words thereafter, eg “The Conquest of Mexico”.
	 */
	Title_case("02"),

	/**
	 * For example, “THE CONQUEST OF MEXICO”.
	 */
	All_capitals("03");

	public final String code;

	private TextCaseFlags(String code)
	{
		this.code = code;
	}

	private static TextCaseFlags[] values = TextCaseFlags.values();
	public static TextCaseFlags fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextCaseFlags item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

