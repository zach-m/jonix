package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 77
 * 
 * @author Zach Melamed
 * 
 */
public enum NorthAmericanSchoolOrCollegeGrades
{
	/**
	 * Age typically 0-4 years.
	 */
	Preschool("P"),

	/**
	 * Age typically 5 years.
	 */
	Kindergarten("K"),

	/**
	 * Age typically 6 years.
	 */
	First_Grade("1"),

	/**
	 * Age typically 7 years.
	 */
	Second_Grade("2"),

	/**
	 * Age typically 8 years.
	 */
	Third_Grade("3"),

	/**
	 * Age typically 9 years.
	 */
	Fourth_Grade("4"),

	/**
	 * Age typically 10 years.
	 */
	Fifth_Grade("5"),

	/**
	 * Age typically 11 years.
	 */
	Sixth_Grade("6"),

	/**
	 * Age typically 12 years.
	 */
	Seventh_Grade("7"),

	/**
	 * Age typically 13 years.
	 */
	Eighth_Grade("8"),

	/**
	 * High School Freshman – age typically 14 years.
	 */
	Ninth_Grade("9"),

	/**
	 * High School Sophomore – age typically 15 years.
	 */
	Tenth_Grade("10"),

	/**
	 * High School Junior – age typically 16 years.
	 */
	Eleventh_Grade("11"),

	/**
	 * High School Senior – age typically 17 years.
	 */
	Twelfth_Grade("12"),

	/**
	 * Age typically 18 years.
	 */
	College_Freshman("13"),

	/**
	 * Age typically 19 years.
	 */
	College_Sophomore("14"),

	/**
	 * Age typically 20 years.
	 */
	College_Junior("15"),

	/**
	 * Age typically 21 years.
	 */
	College_Senior("16"),

	/**
	 * Age typically 22+ years.
	 */
	College_Graduate_Student("17");

	public final String code;

	private NorthAmericanSchoolOrCollegeGrades(String code)
	{
		this.code = code;
	}

	private static NorthAmericanSchoolOrCollegeGrades[] values = NorthAmericanSchoolOrCollegeGrades.values();
	public static NorthAmericanSchoolOrCollegeGrades fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (NorthAmericanSchoolOrCollegeGrades item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

