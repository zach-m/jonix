package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 155
 * 
 * @author Zach Melamed
 * 
 */
public enum ContentDateRoles
{
	/**
	 * Nominal date of publication.
	 */
	Publication_date("01"),

	/**
	 * Date when a TV or radio program was / will be broadcast.
	 */
	Broadcast_date("04"),

	/**
	 * Date from which a content item or supporting resource may be referenced or used.
	 */
	From_date("14"),

	/**
	 * Date until which a content item or supporting resource may be referenced or used.
	 */
	Until_date("15"),

	/**
	 * Date when a resource was last changed or updated.
	 */
	Last_updated("17"),

	/**
	 * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat 06.
	 */
	From__until_date("24"),

	/**
	 * Date from which a supporting resource is available for download. Note that this date also implies that it can be immediately displayed to the intended audience, unless a From date (code 14) is also supplied and is later than the Available from date.
	 */
	Available_from("27"),

	/**
	 * Date until which a supporting resource is available for download. Note that this date does not imply it must be removed from display to the intended audience on this date – for this, use Until date (code 15).
	 */
	Available_until("28");

	public final String code;

	private ContentDateRoles(String code)
	{
		this.code = code;
	}

	private static ContentDateRoles[] values = ContentDateRoles.values();
	public static ContentDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ContentDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

