package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 22
 * 
 * @author Zach Melamed
 * 
 */
public enum LanguageRoles
{
	Language_of_text("01"),

	/**
	 * Where the text in the original language is NOT part of the current product.
	 */
	Original_language_of_a_translated_text("02"),

	/**
	 * Where different from language of text: used mainly for serials.
	 */
	Language_of_abstracts("03"),

	/**
	 * Language to which specified rights apply.
	 */
	Rights_language("04"),

	/**
	 * Language to which specified rights do not apply.
	 */
	Rightsexcluded_language("05"),

	/**
	 * Where the text in the original language is part of a bilingual or multilingual edition.
	 */
	Original_language_in_a_multilingual_edition("06"),

	/**
	 * Where the text in a translated language is part of a bilingual or multilingual edition.
	 */
	Translated_language_in_a_multilingual_edition("07"),

	/**
	 * For example, on a DVD.
	 */
	Language_of_audio_track("08"),

	/**
	 * For example, on a DVD.
	 */
	Language_of_subtitles("09");

	public final String code;

	private LanguageRoles(String code)
	{
		this.code = code;
	}

	private static LanguageRoles[] values = LanguageRoles.values();
	public static LanguageRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (LanguageRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

