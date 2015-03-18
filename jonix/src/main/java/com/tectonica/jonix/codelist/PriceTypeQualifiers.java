package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 59
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceTypeQualifiers
{
	/**
	 * Price applies to all customers that do not fall within any other group with a specified group-specific qualified price.
	 */
	Unqualified_price("00"),

	/**
	 * Price applies to a designated group membership.
	 */
	Member_subscriber_price("01"),

	/**
	 * Price applies to sales outside the territory in which the supplier is located.
	 */
	Export_price("02"),

	/**
	 * Use in cases where there is no combined price, but a lower price is offered for each part if the whole set / series / collection is purchased (either at one time, as part of a continuing commitment, or in a single purchase).
	 */
	Reduced_price_applicable_when_the_item_is_purchased_as_part_of_a_set_or_series__or_collection("03"),

	/**
	 * In the Netherlands (or any other market where similar arrangements exist): a reduced fixed price available for a limited time on presentation of a voucher or coupon published in a specified medium, eg a newspaper. Should be accompanied by Price Type code 13 and additional detail in <PriceTypeDescription>, and by validity dates in <PriceEffectiveFrom> and <PriceEffectiveUntil> (ONIX 2.1) or in the <PriceDate> composite (ONIX 3.0).
	 */
	Voucher_price("04"),

	/**
	 * Price for individual consumer sale only.
	 */
	Consumer_price("05"),

	/**
	 * Price for sale to libraries or other corporate or institutional customers.
	 */
	Corporate_price("06"),

	/**
	 * Price valid for a specified period prior to publication. Orders placed prior to the end of the period are guaranteed to be delivered to the retailer before the nominal publication date. The price may or may not be different from the ‘normal’ price, which carries no such delivery guarantee. Must be accompanied by a <PriceEffectiveUntil> date (or equivalent <PriceDate> composite in ONIX 3), and should also be accompanied by a ‘normal’ price.
	 */
	Reservation_order_price("07"),

	/**
	 * Temporary ‘Special offer’ price. Must be accompanied by <PriceEffectiveFrom> and <PriceEffectiveUntil> dates (or equivalent <PriceDate> composites in ONIX 3), and may also be accompanied by a ‘normal’ price.
	 */
	Promotional_offer_price("08");

	public final String code;

	private PriceTypeQualifiers(String code)
	{
		this.code = code;
	}

	private static PriceTypeQualifiers[] values = PriceTypeQualifiers.values();
	public static PriceTypeQualifiers fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceTypeQualifiers item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

