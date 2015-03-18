package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 101
 * 
 * @author Zach Melamed
 * 
 */
public enum PersonNameIdTypes
{
	Proprietary("01"),

	/**
	 * Personennamendatei – person name authority file used by Deutsche Nationalbibliothek and in other German-speaking countries. See http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favour of the GND.
	 */
	PND("02"),

	/**
	 * Library of Congress control number assigned to a Library of Congress Name Authority record.
	 */
	LCCN("04"),

	/**
	 * International Standard Name Identifier. See ‘http://www.isni.org/’.
	 */
	ISNI("16"),

	/**
	 * Gemeinsame Normdatei – Joint Authority File in the German-speaking countries. See 'http://www.dnb.de/EN/Standardisierung/Normdaten/GND/gnd_node.html (English)'. Combines the PND, SWD and GKD into a single authority file, and should be used in preference.
	 */
	GND("25");

	public final String code;

	private PersonNameIdTypes(String code)
	{
		this.code = code;
	}

	private static PersonNameIdTypes[] values = PersonNameIdTypes.values();
	public static PersonNameIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PersonNameIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

