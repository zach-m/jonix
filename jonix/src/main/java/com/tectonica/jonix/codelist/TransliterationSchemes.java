package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 138
 * 
 * @author Zach Melamed
 * 
 */
public enum TransliterationSchemes
{
	/**
	 * Transliteration of Cyrillic characters – Slavic languages.
	 */
	Finnish_standard_SFS_4900("SFS4900"),

	/**
	 * Transliteration and transcription of Greek characters.
	 */
	Finnish_standard_SFS_5807("SFS5807"),

	/**
	 * Transliteration of Arabic characters.
	 */
	Finnish_standard_SFS_5755("SFS5755"),

	/**
	 * Transliteration of Hebrew characters.
	 */
	Finnish_standard_SFS_5824("SFS3602"),

	/**
	 * Documentation – Romanization of Japanese (kana script).
	 */
	ISO_3602("ISO3602"),

	/**
	 * Information and documentation – Romanization of Chinese.
	 */
	ISO_7098("ISO7098");

	public final String code;

	private TransliterationSchemes(String code)
	{
		this.code = code;
	}

	private static TransliterationSchemes[] values = TransliterationSchemes.values();
	public static TransliterationSchemes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TransliterationSchemes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

