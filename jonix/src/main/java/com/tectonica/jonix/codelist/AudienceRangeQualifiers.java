package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 30
 * 
 * @author Zach Melamed
 * 
 */
public enum AudienceRangeQualifiers
{
	/**
	 * Values for <AudienceRangeValue> are specified in List 77.
	 */
	US_school_grade_range("11"),

	/**
	 * Values are defined by BIC for England and Wales, Scotland and N Ireland.
	 */
	UK_school_grade("12"),

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Reading_speed__words_per_minute("15"),

	/**
	 * For use up to 30 months only: values in <AudienceRangeValue> must be integers.
	 */
	Interest_age__months("16"),

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Interest_age__years("17"),

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Reading_age__years("18"),

	/**
	 * Spain: combined grade and region code, maintained by the Ministerio de Educación.
	 */
	Spanish_school_grade("19"),

	/**
	 * Norwegian educational grades (4704).
	 */
	Skoletrinn("20"),

	/**
	 * Swedish educational qualifier (code).
	 */
	Niv_("21"),

	Italian_school_grade("22"),

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Schulform("23"),

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Bundesland("24"),

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Ausbildungsberuf("25"),

	/**
	 * Values for <AudienceRangeValue> are specified in List 77.
	 */
	Canadian_school_grade_range("26"),

	Finnish_school_grade_range("27"),

	/**
	 * Lukion kurssi.
	 */
	Finnish_Upper_secondary_school_course("28"),

	/**
	 * Values are P, K, 1–17 (including college-level audiences).
	 */
	Chinese_School_Grade_code("29");

	public final String code;

	private AudienceRangeQualifiers(String code)
	{
		this.code = code;
	}

	private static AudienceRangeQualifiers[] values = AudienceRangeQualifiers.values();
	public static AudienceRangeQualifiers fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AudienceRangeQualifiers item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

