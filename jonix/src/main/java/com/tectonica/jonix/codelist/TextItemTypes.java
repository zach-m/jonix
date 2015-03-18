package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 42
 * 
 * @author Zach Melamed
 * 
 */
public enum TextItemTypes
{
	/**
	 * A complete work which is published as a content item in a product which carries two or more such works, eg when two or three novels are published in a single omnibus volume.
	 */
	Textual_work("01"),

	/**
	 * Text components such as Preface, Introduction etc which appear as preliminaries to the main body of text content in a product.
	 */
	Front_matter("02"),

	/**
	 * Text components such as Part, Chapter, Section etc which appear as part of the main body of text content in a product.
	 */
	Body_matter("03"),

	/**
	 * Text components such as Index which appear after the main body of text in a product.
	 */
	Back_matter("04"),

	/**
	 * For journals.
	 */
	Serial_item__miscellaneous_or_unspecified("10"),

	/**
	 * For journals.
	 */
	Research_article("11"),

	/**
	 * For journals.
	 */
	Review_article("12"),

	/**
	 * For journals.
	 */
	Letter("13"),

	/**
	 * For journals.
	 */
	Short_communication("14"),

	/**
	 * For journals.
	 */
	Erratum("15"),

	/**
	 * For journals.
	 */
	Abstract("16"),

	/**
	 * For journals.
	 */
	Book_review_or_review_of_other_publication("17"),

	/**
	 * For journals.
	 */
	Editorial("18"),

	/**
	 * For journals.
	 */
	Product_review("19"),

	Index("20"),

	/**
	 * For journals.
	 */
	Obituary("21");

	public final String code;

	private TextItemTypes(String code)
	{
		this.code = code;
	}

	private static TextItemTypes[] values = TextItemTypes.values();
	public static TextItemTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextItemTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

