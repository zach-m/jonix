package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 179
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceCodeTypes
{
	/**
	 * A publisher or retailer’s proprietary code list which identifies particular codes with particular price points, price tiers or bands.
	 */
	Proprietary("01"),

	/**
	 * Price Code scheme for Finnish Pocket Books (Pokkareiden hintaryhmä). Price codes expressed as letters A–J in <PriceCode>.
	 */
	Finnish_Pocket_Book_price_code("02");

	public final String code;

	private PriceCodeTypes(String code)
	{
		this.code = code;
	}

	private static PriceCodeTypes[] values = PriceCodeTypes.values();
	public static PriceCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

