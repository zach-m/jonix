package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 148
 * 
 * @author Zach Melamed
 * 
 */
public enum CollectionTypes
{
	/**
	 * Collection type is not determined.
	 */
	Unspecified_default("00"),

	/**
	 * The collection is a bibliographic collection (eg a series) defined and identified by a publisher, either on the product itself or in product information supplied by the publisher.
	 */
	Publisher_collection("10"),

	/**
	 * The collection has been defined and identified by a party in the metadata supply chain other than the publisher, typically an aggregator.
	 */
	Ascribed_collection("20");

	public final String code;

	private CollectionTypes(String code)
	{
		this.code = code;
	}

	private static CollectionTypes[] values = CollectionTypes.values();
	public static CollectionTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (CollectionTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

