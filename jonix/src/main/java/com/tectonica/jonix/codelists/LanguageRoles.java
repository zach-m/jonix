package com.tectonica.jonix.codelists;

/**
 * List 22
 * 
 * @author Zach Melamed
 *
 */
public enum LanguageRoles
{
	Language_of_text("01"),

	Original_language_of_a_translated_text("02"),

	Language_of_abstracts("03"),

	Rights_language("04"),

	Rights_excluded_language("05"),

	Original_language_in_a_multilingual_edition("06"),

	Translated_language_in_a_multilingual_edition("07"),

	Language_of_audio_track("08"),

	Language_of_subtitles("09");

	public final String code;

	private LanguageRoles(String code)
	{
		this.code = code;
	}

	private static LanguageRoles[] values = LanguageRoles.values();

	public static LanguageRoles fromCode(String code)
	{
		for (LanguageRoles item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
