package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 2
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductCompositions
{
	Singleitem_retail_product("00"),

	/**
	 * Multiple-item product retailed as a whole.
	 */
	Multipleitem_retail_product("10"),

	/**
	 * Used when an ONIX record is required for a collection-as-a-whole, even though it is not currently retailed as such.
	 */
	Multipleitem_collection__retailed_as_separate_parts("11"),

	/**
	 * Product not for retail, and not carrying retail items, eg empty dumpbin, empty counterpack, promotional material.
	 */
	Tradeonly_product("20"),

	/**
	 * Carrying multiple copies for retailing as separate items, eg shrink-wrapped trade pack, filled dumpbin, filled counterpack.
	 */
	Multipleitem_trade_pack("30");

	public final String code;

	private ProductCompositions(String code)
	{
		this.code = code;
	}

	private static ProductCompositions[] values = ProductCompositions.values();
	public static ProductCompositions fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductCompositions item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

