package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 36
 * 
 * @author Zach Melamed
 * 
 */
public enum FrontCoverImageFileFormats
{
	GIF("02"),

	JPEG("03"),

	TIF("05");

	public final String code;

	private FrontCoverImageFileFormats(String code)
	{
		this.code = code;
	}

	private static FrontCoverImageFileFormats[] values = FrontCoverImageFileFormats.values();
	public static FrontCoverImageFileFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (FrontCoverImageFileFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

