package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 149
 * 
 * @author Zach Melamed
 * 
 */
public enum TitleElementLevels
{
	/**
	 * The title element refers to an individual product.
	 */
	Product("01"),

	/**
	 * The title element refers to the top level of a bibliographic collection.
	 */
	Collection_level("02"),

	/**
	 * The title element refers to an intermediate level of a bibliographic collection that comprises two or more ‘sub-collections’.
	 */
	Subcollection("03"),

	/**
	 * The title element refers to a content item within a product, eg a work included in a combined or ‘omnibus’ edition, or a chapter in a book.
	 */
	Content_item("04"),

	/**
	 * The title element names a master brand where the use of the brand spans multiple collections and product forms, and possibly multiple imprints and publishers. Used only for branded media properties such as children’s character properties.
	 */
	Master_brand("05");

	public final String code;

	private TitleElementLevels(String code)
	{
		this.code = code;
	}

	private static TitleElementLevels[] values = TitleElementLevels.values();
	public static TitleElementLevels fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TitleElementLevels item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

