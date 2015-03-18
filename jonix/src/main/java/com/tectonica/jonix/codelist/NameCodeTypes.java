package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 44
 * 
 * @author Zach Melamed
 * 
 */
public enum NameCodeTypes
{
	Proprietary("01"),

	/**
	 * DEPRECATED – use 01.
	 */
	Proprietary_("02"),

	/**
	 * Deutsche Nationalbibliothek publisher identifier.
	 */
	DNB_publisher_identifier("03"),

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
	 * Trading party identifier used in the Netherlands.
	 */
	Centraal_Boekhuis_Relatie_ID("10"),

	/**
	 * Flemish publisher code.
	 */
	Fondscode_Boekenbank("13"),

	/**
	 * Business Identity Code (Finland). See http://www.ytj.fi/ (in Finnish).
	 */
	Ytunnus("15"),

	/**
	 * International Standard Name Identifier. See ‘http://www.isni.org/’.
	 */
	ISNI("16"),

	/**
	 * Personennamendatei – person name authority file used by Deutsche Nationalbibliothek and in other German-speaking countries. See http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favour of the GND.
	 */
	PND("17"),

	/**
	 * A control number assigned to a Library of Congress Name Authority record.
	 */
	LCCN("18"),

	/**
	 * Publisher identifier administered by Japanese ISBN Agency.
	 */
	Japanese_Publisher_identifier("19"),

	/**
	 * Gemeinsame Körperschaftsdatei – Corporate Body Authority File in the German-speaking countries. See http://www.d-nb.de/standardisierung/normdateien/gkd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/gkd.htm (English). DEPRECATED in favour of the GND.
	 */
	GKD("20"),

	/**
	 * Open Researcher and Contributor ID. See ‘http://www.orcid.org/’.
	 */
	ORCID("21"),

	/**
	 * Publisher identifier maintained by the Chinese ISBN Agency (GAPP).
	 */
	GAPP_Publisher_Identifier("22"),

	/**
	 * Identifier for a business organization for VAT purposes, eg within the EU’s VIES system. See http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country. Generally these consist of a two-letter country code followed by the 8–12 digits of the national VAT ID. Some countries include one or two letters within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number for non-EU countries that maintain similar identifiers. Spaces, dashes etc should be omitted.
	 */
	VAT_Identity_Number("23"),

	/**
	 * 4-digit business organization identifier controlled by the Japanese Publication Wholesalers Association.
	 */
	JP_Distribution_Identifier("24"),

	/**
	 * Gemeinsame Normdatei – Joint Authority File in the German-speaking countries. See 'http://www.dnb.de/EN/Standardisierung/Normdaten/GND/gnd_node.html (English)'. Combines the PND, SWD and GKD into a single authority file, and should be used in preference.
	 */
	GND("25");

	public final String code;

	private NameCodeTypes(String code)
	{
		this.code = code;
	}

	private static NameCodeTypes[] values = NameCodeTypes.values();
	public static NameCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (NameCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

