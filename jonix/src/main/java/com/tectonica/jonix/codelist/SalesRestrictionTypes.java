package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 71
 * 
 * @author Zach Melamed
 * 
 */
public enum SalesRestrictionTypes
{
	/**
	 * Restriction must be described in <SalesRestrictionDetail> (ONIX 2.1) or <SalesRestrictionNote> (ONIX 3.0).
	 */
	Unspecified___see_text("00"),

	/**
	 * For sale only through designated retailer. Retailer must be identified or named in an instance of the <SalesOutlet> composite. Use only when it is not possible to assign the more explicit code 04 or 05.
	 */
	Retailer_exclusive___own_brand("01"),

	/**
	 * For editions sold only though office supplies wholesalers. Retailer(s) and/or distributor(s) may be identified or named in an instance of the <SalesOutlet> composite.
	 */
	Office_supplies_edition("02"),

	/**
	 * For an ISBN that is assigned for a publisher’s internal purposes.
	 */
	Internal_publisher_use_only__do_not_list("03"),

	/**
	 * For sale only through designated retailer, though not under retailer’s own brand/imprint. Retailer must be identified or named in an instance of the <SalesOutlet> composite.
	 */
	Retailer_exclusive("04"),

	/**
	 * For sale only through designated retailer under retailer’s own brand/imprint. Retailer must be identified or named in an instance of the <SalesOutlet> composite.
	 */
	Retailer_own_brand("05"),

	/**
	 * For sale to libraries only; not for sale through retail trade.
	 */
	Library_edition("06"),

	/**
	 * For sale directly to schools only; not for sale through retail trade.
	 */
	Schools_only_edition("07"),

	/**
	 * Indexed for the German market – in Deutschland indiziert.
	 */
	Indiziert("08"),

	/**
	 * Expected to apply in particular to digital products for consumer sale where the publisher does not permit the product to be supplied to libraries who provide an ebook loan service.
	 */
	Not_for_sale_to_libraries("09"),

	/**
	 * For editions sold only through newsstands/newsagents.
	 */
	News_outlet_edition("10");

	public final String code;

	private SalesRestrictionTypes(String code)
	{
		this.code = code;
	}

	private static SalesRestrictionTypes[] values = SalesRestrictionTypes.values();
	public static SalesRestrictionTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SalesRestrictionTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

