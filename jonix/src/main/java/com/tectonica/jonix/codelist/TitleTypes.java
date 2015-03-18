package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 15
 * 
 * @author Zach Melamed
 * 
 */
public enum TitleTypes
{
	Undefined("00"),

	/**
	 * The full text of the distinctive title of the item, without abbreviation or abridgement. For books, where the title alone is not distinctive, elements may be taken from a set or series title and part number etc to create a distinctive title. Where the item is an omnibus edition containing two or more works by the same author, and there is no separate combined title, a distinctive title may be constructed by concatenating the individual titles, with suitable punctuation, as in “Pride and prejudice / Sense and sensibility / Northanger Abbey”.
	 */
	Distinctive_title_book("01"),

	/**
	 * Serials only.
	 */
	ISSN_key_title_of_serial("02"),

	/**
	 * Where the subject of the ONIX record is a translated item.
	 */
	Title_in_original_language("03"),

	/**
	 * For serials: an acronym or initialism of Title Type 01, eg “JAMA”, “JACM”.
	 */
	Title_acronym_or_initialism("04"),

	/**
	 * An abbreviated form of Title Type 01.
	 */
	Abbreviated_title("05"),

	/**
	 * A translation of Title Type 01 into another language.
	 */
	Title_in_other_language("06"),

	/**
	 * Serials only: when a journal issue is explicitly devoted to a specified topic.
	 */
	Thematic_title_of_journal_issue("07"),

	/**
	 * Books or serials: when an item was previously published under another title.
	 */
	Former_title("08"),

	/**
	 * For books: the title carried in a book distributor’s title file: frequently incomplete, and may include elements not properly part of the title.
	 */
	Distributors_title("10"),

	/**
	 * An alternative title that appears on the cover of a book.
	 */
	Alternative_title_on_cover("11"),

	/**
	 * An alternative title that appears on the back of a book.
	 */
	Alternative_title_on_back("12"),

	/**
	 * An expanded form of the title, eg the title of a school text book with grade and type and other details added to make the title meaningful, where otherwise it would comprise only the curriculum subject. This title type is required for submissions to the Spanish ISBN Agency.
	 */
	Expanded_title("13");

	public final String code;

	private TitleTypes(String code)
	{
		this.code = code;
	}

	private static TitleTypes[] values = TitleTypes.values();
	public static TitleTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TitleTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

