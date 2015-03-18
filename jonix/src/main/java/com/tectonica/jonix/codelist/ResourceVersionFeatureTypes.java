package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 162
 * 
 * @author Zach Melamed
 * 
 */
public enum ResourceVersionFeatureTypes
{
	/**
	 * Resource Version Feature Value carries a code from List 178.
	 */
	File_format("01"),

	/**
	 * Resource Version Feature Value carries an integer.
	 */
	Image_height_in_pixels("02"),

	/**
	 * Resource Version Feature Value carries an integer.
	 */
	Image_width_in_pixels("03"),

	/**
	 * Resource Version Feature Value carries the filename of the supporting resource.
	 */
	Filename("04"),

	/**
	 * Resource Version Feature Value carries a decimal number only, suggested no more than 2 significant digits (eg 1.7, not 1.7462).
	 */
	Approximate_download_file_size_in_megabytes("05"),

	/**
	 * MD5 hash value of the resource file. <ResourceVersionFeatureValue> should contain the hash value (as 32 hexadecimal digits). Can be used as a cryptographic check on the integrity of a resource after it has been retrieved.
	 */
	MD5_hash_value("06"),

	/**
	 * Resource Version Feature Value carries a integer number only (eg 1831023).
	 */
	Exact_download_file_size_in_bytes("07");

	public final String code;

	private ResourceVersionFeatureTypes(String code)
	{
		this.code = code;
	}

	private static ResourceVersionFeatureTypes[] values = ResourceVersionFeatureTypes.values();
	public static ResourceVersionFeatureTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ResourceVersionFeatureTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

