package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 142
 * 
 * @author Zach Melamed
 * 
 */
public enum PositionOnProducts
{
	/**
	 * Position unknown or unspecified.
	 */
	Unknown___unspecified("00"),

	/**
	 * The back cover of a book.
	 */
	Cover_4("01"),

	/**
	 * The inside back cover of a book.
	 */
	Cover_3("02"),

	/**
	 * The inside front cover of a book.
	 */
	Cover_2("03"),

	/**
	 * The front cover of a book.
	 */
	Cover_1("04"),

	/**
	 * The spine of a book.
	 */
	On_spine("05"),

	/**
	 * Used only for boxed products.
	 */
	On_box("06"),

	/**
	 * Used only for products fitted with hanging tags.
	 */
	On_tag("07"),

	/**
	 * Not be used for books unless they are contained within outer packaging.
	 */
	On_bottom("08"),

	/**
	 * Not be used for books unless they are contained within outer packaging.
	 */
	On_back("09"),

	/**
	 * Used only for products packaged in outer sleeves.
	 */
	On_outer_sleeve___back("10"),

	/**
	 * Used only for products packaged in shrink-wrap or other removable wrapping.
	 */
	On_removable_wrapping("11");

	public final String code;

	private PositionOnProducts(String code)
	{
		this.code = code;
	}

	private static PositionOnProducts[] values = PositionOnProducts.values();
	public static PositionOnProducts fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PositionOnProducts item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

