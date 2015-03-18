package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 198
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductContactRoles
{
	/**
	 * Eg for requests for supply of mutable digital files for conversion to other formats.
	 */
	Accessibility_request_contact("01"),

	Promotional_contact("02");

	public final String code;

	private ProductContactRoles(String code)
	{
		this.code = code;
	}

	private static ProductContactRoles[] values = ProductContactRoles.values();
	public static ProductContactRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductContactRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

