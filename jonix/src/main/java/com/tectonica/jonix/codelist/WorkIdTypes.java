package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 16
 * 
 * @author Zach Melamed
 * 
 */
public enum WorkIdTypes
{
	Proprietary("01"),

	/**
	 * 10-character ISBN of manifestation of work, when this is the only work identifier available – now DEPRECATED in ONIX for Books, except where providing historical information for compatibility with legacy systems. It should only be used in relation to products published before 2007 – when ISBN-13 superseded it – and should never be used as the ONLY identifier (it should always be accompanied by the correct GTIN-13 / ISBN-13 of the manifestation of the work).
	 */
	ISBN10("02"),

	/**
	 * Digital Object Identifier (variable length and character set).
	 */
	DOI("06"),

	/**
	 * International Standard Text Code (16 characters: numerals and letters A-F, unhyphenated).
	 */
	ISTC("11"),

	/**
	 * 13-character ISBN of manifestation of work, when this is the only work identifier available.
	 */
	ISBN13("15"),

	/**
	 * International Standard Recording Code.
	 */
	ISRC("18");

	public final String code;

	private WorkIdTypes(String code)
	{
		this.code = code;
	}

	private static WorkIdTypes[] values = WorkIdTypes.values();
	public static WorkIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (WorkIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

