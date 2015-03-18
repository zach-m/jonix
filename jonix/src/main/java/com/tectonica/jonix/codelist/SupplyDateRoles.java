package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 166
 * 
 * @author Zach Melamed
 * 
 */
public enum SupplyDateRoles
{
	/**
	 * If there is an embargo on retail sales before a certain date, the date from which the embargo is lifted and retail sales are permitted.
	 */
	Embargo_date("02"),

	/**
	 * The date on which physical stock is expected to be available to be shipped to retailers, or a digital product is expected to be released.
	 */
	Expected_availability_date("08"),

	/**
	 * Last date when returns will be accepted, generally for a product which is being remaindered or put out of print.
	 */
	Last_date_for_returns("18"),

	/**
	 * Latest date on which an order may be placed for guaranteed delivery prior to the publication date. May or may not be linked to a special reservation or pre-publication price.
	 */
	Reservation_order_deadline("25");

	public final String code;

	private SupplyDateRoles(String code)
	{
		this.code = code;
	}

	private static SupplyDateRoles[] values = SupplyDateRoles.values();
	public static SupplyDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupplyDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

