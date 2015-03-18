package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 154
 * 
 * @author Zach Melamed
 * 
 */
public enum ContentAudiences
{
	/**
	 * Any audience.
	 */
	Unrestricted("00"),

	/**
	 * Distribution by agreement between the parties to the ONIX exchange (this value is provided to cover applications where ONIX content includes material which is not for general distribution).
	 */
	Restricted("01"),

	/**
	 * Distributors, bookstores, publisher’s own staff etc.
	 */
	Booktrade("02"),

	Endcustomers("03"),

	Librarians("04"),

	Teachers("05"),

	Students("06"),

	/**
	 * Press or other media.
	 */
	Press("07"),

	/**
	 * Where a specially formatted description is required for this audience.
	 */
	Shopping_comparison_service("08");

	public final String code;

	private ContentAudiences(String code)
	{
		this.code = code;
	}

	private static ContentAudiences[] values = ContentAudiences.values();
	public static ContentAudiences fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ContentAudiences item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

