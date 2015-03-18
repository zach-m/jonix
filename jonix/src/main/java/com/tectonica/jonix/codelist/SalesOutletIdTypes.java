package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 102
 * 
 * @author Zach Melamed
 * 
 */
public enum SalesOutletIdTypes
{
	Proprietary("01"),

	/**
	 * DEPRECATED – use code 03.
	 */
	BIC_sales_outlet_ID_code("02"),

	/**
	 * From List 139.
	 */
	ONIX_sales_outlet_ID_code("03");

	public final String code;

	private SalesOutletIdTypes(String code)
	{
		this.code = code;
	}

	private static SalesOutletIdTypes[] values = SalesOutletIdTypes.values();
	public static SalesOutletIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SalesOutletIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

