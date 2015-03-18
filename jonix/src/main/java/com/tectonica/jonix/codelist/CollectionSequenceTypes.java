package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 197
 * 
 * @author Zach Melamed
 * 
 */
public enum CollectionSequenceTypes
{
	/**
	 * A short explanatory label for the sequence should be provided in <CollectionSequenceTypeName>.
	 */
	Proprietary("01"),

	/**
	 * Order as specified by the title, eg by volume or part number sequence, provided for confirmation.
	 */
	Title_order("02"),

	/**
	 * Order of publication of products within the collection.
	 */
	Publication_order("03"),

	/**
	 * Order defined by a continuing narrative or temporal sequence within products in the collection. Applicable to either fiction or to non-fiction (eg within a collection of history textbooks).
	 */
	Temporal_narrative_order("04"),

	/**
	 * Original publication order, for a republished collection or collected works originally published outside a collection.
	 */
	Original_publication_order("05");

	public final String code;

	private CollectionSequenceTypes(String code)
	{
		this.code = code;
	}

	private static CollectionSequenceTypes[] values = CollectionSequenceTypes.values();
	public static CollectionSequenceTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (CollectionSequenceTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

