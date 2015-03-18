package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 29
 * 
 * @author Zach Melamed
 * 
 */
public enum AudienceCodeTypes
{
	/**
	 * Using a code from List 28.
	 */
	ONIX_audience_codes("01"),

	Proprietary("02"),

	/**
	 * Motion Picture Association of America rating applied to movies.
	 */
	MPAA_rating("03"),

	/**
	 * British Board of Film Classification rating applied to movies.
	 */
	BBFC_rating("04"),

	/**
	 * German FSK (Freiwillige Selbstkontrolle der Filmwirtschaft) rating applied to movies.
	 */
	FSK_rating("05"),

	/**
	 * French Canadian audience code list, used by BTLF for Memento.
	 */
	BTLF_audience_code("06"),

	/**
	 * Audience code used by Electre (France).
	 */
	Electre_audience_code("07"),

	/**
	 * Spain: educational audience and material type code of the Asociación Nacional de Editores de Libros y Material de Enseñanza.
	 */
	ANELE_Tipo("08"),

	/**
	 * Code list used to specify reading levels for children’s books, used in Flanders, and formerly in the Netherlands – see also code 18.
	 */
	AVI("09"),

	/**
	 * German USK (Unterhaltungssoftware Selbstkontrolle) rating applied to video or computer games.
	 */
	USK_rating("10"),

	/**
	 * Audience code used in Flanders.
	 */
	AWS("11"),

	/**
	 * Type of school: codelist maintained by VdS Bildungsmedien eV, the German association of educational media publishers.
	 */
	Schulform("12"),

	/**
	 * School region: codelist maintained by VdS Bildungsmedien eV, the German association of educational media publishers, indicating where products are licensed to be used in schools.
	 */
	Bundesland("13"),

	/**
	 * Occupation: codelist for vocational training materials, maintained by VdS Bildungsmedien eV, the German association of educational media publishers.
	 */
	Ausbildungsberuf("14"),

	/**
	 * Finnish school or college level.
	 */
	Suomalainen_kouluasteluokitus("15"),

	/**
	 * UK Publishers Association, Children’s Book Group, coded indication of intended reader age, carried on book covers.
	 */
	CBG_age_guidance("16"),

	/**
	 * Audience code used in Nielsen Book Services.
	 */
	Nielsen_Book_audience_code("17"),

	/**
	 * Code list used to specify reading levels for children’s books, used in the Netherlands – see also code 09.
	 */
	AVI_revised("18"),

	/**
	 * Lexile measure (the Lexile measure in <AudienceCodeValue> may optionally be prefixed by the Lexile code). Examples might be ‘880L’, ‘AD0L’ or ‘HL600L’.
	 */
	Lexile_measure("19"),

	/**
	 * Fry readability metric based on number of sentences and syllables per 100 words. Expressed as a number from 1 to 15 in <AudienceCodeValue>.
	 */
	Fry_Readability_score("20"),

	/**
	 * Children’s audience code (対象読者), two-digit encoding of intended target readership from 0–2 years up to High School level.
	 */
	Japanese_Childrens_audience_code("21"),

	/**
	 * Publisher's rating indicating suitability for an particular adult audience, using a code from List 203.
	 */
	ONIX_Adult_audience_rating("22"),

	/**
	 * Code A1 to C2 indicating standardised level of language learning or teaching material, from beginner to advanced, used in EU.
	 */
	Common_European_Framework_for_Language_Learning("23");

	public final String code;

	private AudienceCodeTypes(String code)
	{
		this.code = code;
	}

	private static AudienceCodeTypes[] values = AudienceCodeTypes.values();
	public static AudienceCodeTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AudienceCodeTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

