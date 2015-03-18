package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 100
 * 
 * @author Zach Melamed
 * 
 */
public enum DiscountCodeTypes
{
	/**
	 * UK publisher’s or distributor’s discount group code in a format specified by BIC to ensure uniqueness.
	 */
	BIC_discount_group_code("01"),

	/**
	 * A publisher’s or supplier’s own code which identifies a trade discount category, the actual discount being set by trading partner agreement (applies to goods supplied on standard trade discounting terms).
	 */
	Proprietary_discount_code("02"),

	/**
	 * Terms code used in the Netherlands book trade.
	 */
	Boeksoort("03"),

	/**
	 * Terms code used in German ONIX applications.
	 */
	German_terms_code("04"),

	/**
	 * A publisher’s or supplier’s own code which identifies a commission rate category, the actual commission rate being set by trading partner agreement (applies to goods supplied on agency terms).
	 */
	Proprietary_commission_code("05"),

	/**
	 * UK publisher’s or distributor’s commission group code in format specified by BIC to ensure uniqueness. Format is identical to BIC discount group code, but indicates a commission rather than a discount (applies to goods supplied on agency terms).
	 */
	BIC_commission_group_code("06");

	public final String code;

	private DiscountCodeTypes(String code)
	{
		this.code = code;
	}

	private static DiscountCodeTypes[] values = DiscountCodeTypes.values();
	public static DiscountCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (DiscountCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

