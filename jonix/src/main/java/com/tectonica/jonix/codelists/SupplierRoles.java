package com.tectonica.jonix.codelists;

/**
 * List 93
 * 
 * @author Zach Melamed
 *
 */
public enum SupplierRoles
{
	Unspecified("00"),

	Publisher_to_retailers("01"),

	Publishers_exclusive_distributor_to_retailers("02"),

	Publishers_non_exclusive_distributor_to_retailers("03"),

	Wholesaler("04"),

	Sales_agent("05"),

	Publishers_distributor_to_retailers("06"),

	POD_supplier("07"),

	Retailer("08"),

	Publisher_to_end_customers("09"),

	Exclusive_distributor_to_end_customers("10"),

	Non_exclusive_distributor_to_end_customers("11"),

	Distributor_to_end_customers("12");

	public final String code;

	private SupplierRoles(String code)
	{
		this.code = code;
	}

	private static SupplierRoles[] values = SupplierRoles.values();

	public static SupplierRoles fromCode(String code)
	{
		for (SupplierRoles item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
