package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 204
 * 
 * @author Zach Melamed
 * 
 */
public enum OnixReturnsConditionss
{
	/**
	 * Unspecified, contact supplier for details.
	 */
	Unspecified("00"),

	/**
	 * The retailer pays for goods only after they are sold by the retailer, and may return excess unsold inventory to the supplier at any time. The goods remain the property of the supplier until they are paid for, even while they are physically located at the retailer.
	 */
	Consignment("01"),

	/**
	 * The retailer is invoiced and pays immediately as in the sale or return model, but any excess unsold inventory cannot be returned to the supplier.
	 */
	Firm_sale("02"),

	/**
	 * Contact supplier for applicable returns authorization process. The retailer is invoiced immediately for the goods and pays within the specified credit period, but can return excess unsold inventory to the supplier for full credit at a later date (some kind of returns authorisation process is normally required, and returns of stripped covers or proof of destruction may be allowed instead).
	 */
	Sale_or_return("03");

	public final String code;

	private OnixReturnsConditionss(String code)
	{
		this.code = code;
	}

	private static OnixReturnsConditionss[] values = OnixReturnsConditionss.values();
	public static OnixReturnsConditionss fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (OnixReturnsConditionss item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

