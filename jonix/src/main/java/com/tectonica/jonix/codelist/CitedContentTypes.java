package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 156
 * 
 * @author Zach Melamed
 * 
 */
public enum CitedContentTypes
{
	/**
	 * The full text of a review in a third-party publication in any medium.
	 */
	Review("01"),

	Bestseller_list("02"),

	/**
	 * Other than a review.
	 */
	Media_mention("03"),

	/**
	 * (North America) Inclusion in a program such as ‘Chicago Reads’, ‘Seattle Reads’.
	 */
	_One_locality__one_book_program("04");

	public final String code;

	private CitedContentTypes(String code)
	{
		this.code = code;
	}

	private static CitedContentTypes[] values = CitedContentTypes.values();
	public static CitedContentTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (CitedContentTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

