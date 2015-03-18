package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 87
 * 
 * @author Zach Melamed
 * 
 */
public enum BibleReferenceLocations
{
	/**
	 * References are printed in a narrow column in the center of the page between two columns of text.
	 */
	Center_column("CCL"),

	/**
	 * References are printed at the foot of the page.
	 */
	Page_end("PGE"),

	/**
	 * References are printed in a column to the side of the scripture.
	 */
	Side_column("SID"),

	/**
	 * References are printed at the end of the applicable verse.
	 */
	Verse_end("VER"),

	/**
	 * The person creating the ONIX record does not know where the references are located.
	 */
	Unknown("UNK"),

	/**
	 * Other locations not otherwise identified.
	 */
	Other("ZZZ");

	public final String code;

	private BibleReferenceLocations(String code)
	{
		this.code = code;
	}

	private static BibleReferenceLocations[] values = BibleReferenceLocations.values();
	public static BibleReferenceLocations fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (BibleReferenceLocations item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

