package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 62
 * 
 * @author Zach Melamed
 * 
 */
public enum TaxRates
{
	/**
	 * Specifies that tax is applied at a higher rate than standard.
	 */
	Higher_rate("H"),

	/**
	 * Under Italian tax rules, VAT on books may be paid at source by the publisher, and subsequent transactions through the supply chain are tax-exempt.
	 */
	Tax_paid_at_source_Italy("P"),

	/**
	 * Specifies that tax is applied at a lower rate than standard.
	 */
	Lower_rate("R"),

	Standard_rate("S"),

	Zerorated("Z");

	public final String code;

	private TaxRates(String code)
	{
		this.code = code;
	}

	private static TaxRates[] values = TaxRates.values();
	public static TaxRates fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TaxRates item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

