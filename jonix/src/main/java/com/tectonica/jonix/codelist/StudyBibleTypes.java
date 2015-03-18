package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 84
 * 
 * @author Zach Melamed
 * 
 */
public enum StudyBibleTypes
{
	/**
	 * Contains the work of Howard Clark Kee including a summary of the development of the canon, introductions to the books, notes and cross references. Originally published in 1993, NRSV.
	 */
	Cambridge_Annotated("CAM"),

	/**
	 * A project of Tyndale House Publishers and Zondervan intended to help readers apply the Bible to daily living. Living Bible, King James, New International, NASB.
	 */
	Life_Application("LIF"),

	/**
	 * A King James version study Bible with notes by James Macarthur first published in 1997.
	 */
	Macarthur("MAC"),

	/**
	 * A study Bible originally published in the 1960s and based on the RSV / NRSV.
	 */
	Oxford_Annotated("OXF"),

	/**
	 * Norwegian study Bible, New Testament.
	 */
	Studiebibel__Det_Nye_testamentet("NNT"),

	/**
	 * Published in 1991 and based on the New Revised Standard version.
	 */
	New_Oxford_Annotated("NOX"),

	/**
	 * Norwegian study Bible.
	 */
	Norsk_studiebibel("NSB"),

	/**
	 * Based on the work of Charles C. Ryrie. King James, NI, NASB.
	 */
	Ryrie("RYR"),

	/**
	 * A study Bible based on the early 20th century work of C.I. Scofield. Based on the King James version.
	 */
	Scofield("SCO"),

	/**
	 * A transdenominational study Bible for persons from the Pentecostal/Charismatic traditions.
	 */
	Spirit_Filled("SPR");

	public final String code;

	private StudyBibleTypes(String code)
	{
		this.code = code;
	}

	private static StudyBibleTypes[] values = StudyBibleTypes.values();
	public static StudyBibleTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (StudyBibleTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

