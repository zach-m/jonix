package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 141
 * 
 * @author Zach Melamed
 * 
 */
public enum BarcodeIndicators
{
	Not_barcoded("00"),

	Barcoded__scheme_unspecified("01"),

	GTIN13("02"),

	GTIN13_5_US_dollar_price_encoded("03"),

	GTIN13_5_CAN_dollar_price_encoded("04"),

	GTIN13_5_no_price_encoded("05"),

	/**
	 * AKA item/price.
	 */
	UPC12_itemspecific("06"),

	/**
	 * AKA item/price.
	 */
	UPC12_5_itemspecific("07"),

	/**
	 * AKA price/item.
	 */
	UPC12_pricepoint("08"),

	/**
	 * AKA price/item.
	 */
	UPC12_5_pricepoint("09");

	public final String code;

	private BarcodeIndicators(String code)
	{
		this.code = code;
	}

	private static BarcodeIndicators[] values = BarcodeIndicators.values();
	public static BarcodeIndicators fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (BarcodeIndicators item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

