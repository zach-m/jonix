package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 93
 * 
 * @author Zach Melamed
 * 
 */
public enum SupplierRoles
{
	/**
	 * Default.
	 */
	Unspecified("00"),

	/**
	 * Publisher as supplier to retail trade outlets.
	 */
	Publisher_to_retailers("01"),

	Publishers_exclusive_distributor_to_retailers("02"),

	Publishers_nonexclusive_distributor_to_retailers("03"),

	/**
	 * Wholesaler supplying retail trade outlets.
	 */
	Wholesaler("04"),

	/**
	 * DEPRECATED – use <MarketRepresentation> (ONIX 2.1) or <MarketPublishingDetail> (ONIX 3.0) to specify a sales agent.
	 */
	Sales_agent("05"),

	/**
	 * In a specified supply territory. Use only where exclusive/non-exclusive status is not known. Prefer 02 or 03 as appropriate, where possible.
	 */
	Publishers_distributor_to_retailers("06"),

	/**
	 * Where a POD product is supplied to retailers and/or consumers direct from a POD source.
	 */
	POD_supplier("07"),

	Retailer("08"),

	/**
	 * Publisher as supplier direct to consumers and/or institutional customers.
	 */
	Publisher_to_endcustomers("09"),

	/**
	 * Intermediary as exclusive distributor direct to consumers and/or institutional customers.
	 */
	Exclusive_distributor_to_endcustomers("10"),

	/**
	 * Intermediary as non-exclusive distributor direct to consumers and/or institutional customers.
	 */
	Nonexclusive_distributor_to_endcustomers("11"),

	/**
	 * Use only where exclusive/non-exclusive status is not known. Prefer 10 or 11 as appropriate, where possible.
	 */
	Distributor_to_endcustomers("12");

	public final String code;

	private SupplierRoles(String code)
	{
		this.code = code;
	}

	private static SupplierRoles[] values = SupplierRoles.values();
	public static SupplierRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupplierRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

