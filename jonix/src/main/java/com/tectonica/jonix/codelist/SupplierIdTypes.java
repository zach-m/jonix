package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 92
 * 
 * @author Zach Melamed
 * 
 */
public enum SupplierIdTypes
{
	Proprietary("01"),

	/**
	 * DEPRECATED – use 01.
	 */
	Proprietary_("02"),

	B_rsenverein_Verkehrsnummer("04"),

	German_ISBN_Agency_publisher_identifier("05"),

	/**
	 * GS1 global location number (formerly EAN location number).
	 */
	GLN("06"),

	/**
	 * Book trade Standard Address Number – US, UK etc.
	 */
	SAN("07"),

	/**
	 * Flemish supplier code.
	 */
	Distributeurscode_Boekenbank("12"),

	/**
	 * Flemish publisher code.
	 */
	Fondscode_Boekenbank("13"),

	/**
	 * Identifier for a business organization for VAT purposes, eg within the EU’s VIES system. See http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country. Generally these consist of a two-letter country code followed by the 8–12 digits of the national VAT ID. Some countries include one or two letters within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number for non-EU countries that maintain similar identifiers. Spaces, dashes etc should be omitted.
	 */
	VAT_Identity_Number("23");

	public final String code;

	private SupplierIdTypes(String code)
	{
		this.code = code;
	}

	private static SupplierIdTypes[] values = SupplierIdTypes.values();
	public static SupplierIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupplierIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

