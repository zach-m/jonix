package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 70
 * 
 * @author Zach Melamed
 * 
 */
public enum StockQuantityCodeTypes
{
	Proprietary("01"),

	/**
	 * Code scheme defined by the Australian Publishers Association.
	 */
	APA_stock_quantity_code("02");

	public final String code;

	private StockQuantityCodeTypes(String code)
	{
		this.code = code;
	}

	private static StockQuantityCodeTypes[] values = StockQuantityCodeTypes.values();
	public static StockQuantityCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (StockQuantityCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

