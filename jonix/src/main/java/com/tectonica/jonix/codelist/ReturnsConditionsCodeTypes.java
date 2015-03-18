package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 53
 * 
 * @author Zach Melamed
 * 
 */
public enum ReturnsConditionsCodeTypes
{
	Proprietary("00"),

	/**
	 * Maintained by CLIL (Commission Interprofessionnel du Livre). Returns conditions values in <ReturnsCode> should be taken from the CLIL list.
	 */
	French_book_trade_returns_conditions_code("01"),

	/**
	 * Maintained by BISAC: Returns conditions values in <ReturnsCode> should be taken from List 66.
	 */
	BISAC_Returnable_Indicator_code("02"),

	/**
	 * NOT CURRENTLY USED – BIC has decided that it will not maintain a code list for this purpose, since returns conditions are usually at least partly based on the trading relationship.
	 */
	UK_book_trade_returns_conditions_code("03"),

	/**
	 * Returns conditions values in <ReturnsCode> should be taken from List 204.
	 */
	ONIX_Returns_conditions_code("04");

	public final String code;

	private ReturnsConditionsCodeTypes(String code)
	{
		this.code = code;
	}

	private static ReturnsConditionsCodeTypes[] values = ReturnsConditionsCodeTypes.values();
	public static ReturnsConditionsCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ReturnsConditionsCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

