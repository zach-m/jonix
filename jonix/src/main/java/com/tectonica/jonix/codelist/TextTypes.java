package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 153
 * 
 * @author Zach Melamed
 * 
 */
public enum TextTypes
{
	/**
	 * To be used only in circumstances where the parties to an exchange have agreed to include text which (a) is not for general distribution, and (b) cannot be coded elsewhere. If more than one type of text is sent, it must be identified by tagging within the text itself.
	 */
	Senderdefined_text("01"),

	/**
	 * Limited to a maximum of 350 characters.
	 */
	Short_description_annotation("02"),

	/**
	 * Length unrestricted.
	 */
	Description("03"),

	/**
	 * Used for a table of contents sent as a single text field, which may or may not carry structure expressed as XHTML.
	 */
	Table_of_contents("04"),

	/**
	 * Descriptive blurb taken from the back cover and/or flaps.
	 */
	Flap___cover_copy("05"),

	/**
	 * A quote taken from a review of the product or of the work in question where there is no need to take account of different editions.
	 */
	Review_quote("06"),

	/**
	 * A quote taken from a review of a previous edition of the work.
	 */
	Review_quote__previous_edition("07"),

	/**
	 * A quote taken from a review of a previous work by the same author(s) or in the same series.
	 */
	Review_quote__previous_work("08"),

	/**
	 * A quote usually provided by a celebrity to promote a new book, not from a review.
	 */
	Endorsement("09"),

	/**
	 * A promotional phrase which is intended to headline a description of the product.
	 */
	Promotional_headline("10"),

	/**
	 * Text describing a feature of a product to which the publisher wishes to draw attention for promotional purposes.
	 */
	Feature("11"),

	/**
	 * A note referring to all contributors to a product – NOT linked to a single contributor.
	 */
	Biographical_note("12"),

	/**
	 * A statement included by a publisher in fulfillment of contractual obligations, such as a disclaimer, sponsor statement, or legal notice of any sort. Note that the inclusion of such a notice cannot and does not imply that a user of the ONIX record is obliged to reproduce it.
	 */
	Publishers_notice("13"),

	/**
	 * A short excerpt from the work.
	 */
	Excerpt("14"),

	/**
	 * Used for an index sent as a single text field, which may be structured using XHTML.
	 */
	Index("15"),

	/**
	 * (of which the product is a part.) Limited to a maximum of 350 characters.
	 */
	Short_description_annotation_for_collection("16"),

	/**
	 * (of which the product is a part.) Length unrestricted.
	 */
	Description_for_collection("17");

	public final String code;

	private TextTypes(String code)
	{
		this.code = code;
	}

	private static TextTypes[] values = TextTypes.values();
	public static TextTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TextTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

