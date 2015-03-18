package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 40
 * 
 * @author Zach Melamed
 * 
 */
public enum ImageAudioVideoFileLinkTypes
{
	URL("01"),

	DOI("02"),

	PURL("03"),

	URN("04"),

	FTP_address("05"),

	filename("06");

	public final String code;

	private ImageAudioVideoFileLinkTypes(String code)
	{
		this.code = code;
	}

	private static ImageAudioVideoFileLinkTypes[] values = ImageAudioVideoFileLinkTypes.values();
	public static ImageAudioVideoFileLinkTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ImageAudioVideoFileLinkTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

