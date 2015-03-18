package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 37
 * 
 * @author Zach Melamed
 * 
 */
public enum FrontCoverImageFileLinkTypes
{
	URL("01"),

	DOI("02"),

	PURL("03"),

	URN("04"),

	FTP_address("05"),

	filename("06");

	public final String code;

	private FrontCoverImageFileLinkTypes(String code)
	{
		this.code = code;
	}

	private static FrontCoverImageFileLinkTypes[] values = FrontCoverImageFileLinkTypes.values();
	public static FrontCoverImageFileLinkTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (FrontCoverImageFileLinkTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

