package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 172
 * 
 * @author Zach Melamed
 * 
 */
public enum CurrencyZones
{
	/**
	 * Countries that at the time being have the Euro as their national currency. Deprecated in ONIX 3.
	 */
	Eurozone("EUR");

	public final String code;

	private CurrencyZones(String code)
	{
		this.code = code;
	}

	private static CurrencyZones[] values = CurrencyZones.values();
	public static CurrencyZones fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (CurrencyZones item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

