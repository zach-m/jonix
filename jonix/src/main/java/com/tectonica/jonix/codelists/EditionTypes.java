package com.tectonica.jonix.codelists;

/**
 * List 21
 * 
 * @author Zach Melamed
 *
 */
public enum EditionTypes
{
	Abridged("ABR"),

	Acting_edtion("ACT"),

	Adapted("ADP"),

	Alternate("ALT"),

	Annotated("ANN"),

	Bilingual_edition("BLL"),

	Braille("BRL"),

	Combined_volume("CMB"),

	Critical("CRI"),

	Coursepack("CSP"),

	Digital_original("DGO"),

	Enhanced("ENH"),

	Enlarged("ENL"),

	Expurgated("EXP"),

	Facsimile("FAC"),

	Festschrift("FST"),

	Illustrated("ILL"),

	Large_type_or_large_print("LTE"),

	Microprint("MCP"),

	Media_tie_in("MDT"),

	Multilingual_edition("MLL"),

	New_edition("NED"),

	Edition_with_numbered_copies("NUM"),

	Prebound_edition("PRB"),

	Revised("REV"),

	School_edition("SCH"),

	Simplified_language_edition("SMP"),

	Special_edition("SPE"),

	Student_edition("STU"),

	Teachers_edition("TCH"),

	Unabridged("UBR"),

	Ultra_large_print("ULP"),

	Unexpurgated("UXP"),

	Variorum("VAR");

	public final String code;

	private EditionTypes(String code)
	{
		this.code = code;
	}

	private static EditionTypes[] values = EditionTypes.values();

	public static EditionTypes fromCode(String code)
	{
		for (EditionTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
