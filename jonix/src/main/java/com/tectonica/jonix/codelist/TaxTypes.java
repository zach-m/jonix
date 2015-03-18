package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 171
 * 
 * @author Zach Melamed
 * 
 */
public enum TaxTypes
{
	/**
	 * Value added tax (TVA, IVA, MwSt etc).
	 */
	VAT("01"),

	/**
	 * General sales tax.
	 */
	GST("02");

	public final String code;

	private TaxTypes(String code)
	{
		this.code = code;
	}

	private static TaxTypes[] values = TaxTypes.values();
	public static TaxTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TaxTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

