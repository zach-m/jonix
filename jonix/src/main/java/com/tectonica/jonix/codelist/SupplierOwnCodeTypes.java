package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 165
 * 
 * @author Zach Melamed
 * 
 */
public enum SupplierOwnCodeTypes
{
	/**
	 * A rating applied by a supplier (typically a wholesaler) to indicate its assessment of the expected or actual sales performance of a product.
	 */
	Suppliers_sales_classification("01"),

	/**
	 * A supplier’s coding of the eligibility of a product for a bonus scheme on overall sales.
	 */
	Suppliers_bonus_eligibility("02"),

	/**
	 * A rating applied by the publisher to indicate a sales category (eg backlist/frontlist, core stock etc). Use only when the publisher is not the ‘supplier’.
	 */
	Publishers_sales_classification("03"),

	/**
	 * A classification applied by a supplier to a product sold on Agency terms, to indicate that retail price restrictions are applicable.
	 */
	Suppliers_pricing_restriction_classification("04");

	public final String code;

	private SupplierOwnCodeTypes(String code)
	{
		this.code = code;
	}

	private static SupplierOwnCodeTypes[] values = SupplierOwnCodeTypes.values();
	public static SupplierOwnCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupplierOwnCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

