package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 203
 * 
 * @author Zach Melamed
 * 
 */
public enum OnixAdultAudienceRatings
{
	Unrated("00"),

	/**
	 * The publisher states that the product is suitable for any adult audience.
	 */
	Any_adult_audience("01"),

	/**
	 * The publisher warns the content may offend parts of the adult audience (for any reason).
	 */
	Content_warning("02"),

	/**
	 * The publisher warns the product includes content of an explicit sexual nature.
	 */
	Content_warning_sex("03"),

	/**
	 * The publisher warns the product includes content of a violent nature.
	 */
	Content_warning_violence("04"),

	/**
	 * The publisher warns the product includes content involving misuse of drugs.
	 */
	Content_warning_drugtaking("05"),

	/**
	 * The publisher warns the product includes extreme / offensive / explicit language.
	 */
	Content_warning_language("06"),

	/**
	 * The publisher warns the product includes content involving intolerance of particular groups (eg religious, ethnic, racial, social).
	 */
	Content_warning_intolerance("07");

	public final String code;

	private OnixAdultAudienceRatings(String code)
	{
		this.code = code;
	}

	private static OnixAdultAudienceRatings[] values = OnixAdultAudienceRatings.values();
	public static OnixAdultAudienceRatings fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (OnixAdultAudienceRatings item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

