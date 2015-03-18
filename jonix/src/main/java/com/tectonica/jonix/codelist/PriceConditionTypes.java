package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 167
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceConditionTypes
{
	/**
	 * Allows positive indication that there are no conditions.
	 */
	No_conditions("00"),

	/**
	 * Purchase at this price includes specified updates.
	 */
	Includes_updates("01"),

	/**
	 * Purchase at this price requires commitment to purchase specified updates, not included in price.
	 */
	Must_also_purchase_updates("02"),

	/**
	 * Updates may be purchased separately, no minimum commitment required.
	 */
	Updates_available("03"),

	/**
	 * The duration of the rental to which the price applies.
	 */
	Rental_duration("10");

	public final String code;

	private PriceConditionTypes(String code)
	{
		this.code = code;
	}

	private static PriceConditionTypes[] values = PriceConditionTypes.values();
	public static PriceConditionTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceConditionTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

