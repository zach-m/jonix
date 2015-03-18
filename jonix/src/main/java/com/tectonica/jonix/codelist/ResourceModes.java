package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 159
 * 
 * @author Zach Melamed
 * 
 */
public enum ResourceModes
{
	/**
	 * An executable together with data on which it operates.
	 */
	Application("01"),

	/**
	 * A sound recording.
	 */
	Audio("02"),

	/**
	 * A still image.
	 */
	Image("03"),

	/**
	 * Readable text, with or without associated images etc.
	 */
	Text("04"),

	/**
	 * Moving images, with or without accompanying sound.
	 */
	Video("05"),

	/**
	 * A website or other supporting resource delivering content in a variety of modes.
	 */
	Multimode("06");

	public final String code;

	private ResourceModes(String code)
	{
		this.code = code;
	}

	private static ResourceModes[] values = ResourceModes.values();
	public static ResourceModes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ResourceModes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

