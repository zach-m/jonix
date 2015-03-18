package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 160
 * 
 * @author Zach Melamed
 * 
 */
public enum ResourceFeatureTypes
{
	/**
	 * Credit that must be displayed when a resource is used (eg ‘Photo Jerry Bauer’ or ‘© Magnum Photo’). Credit text should be carried in <FeatureNote>.
	 */
	Required_credit("01"),

	/**
	 * Explanatory caption that may accompany a resource (eg use to identify an author in a photograph). Caption text should be carried in <FeatureNote>.
	 */
	Caption("02"),

	/**
	 * Copyright holder of resource (indicative only, as the resource can be used without consultation). Copyright text should be carried in <FeatureNote>.
	 */
	Copyright_holder("03"),

	/**
	 * Approximate length in minutes of an audio or video resource. <FeatureValue> should contain the length of time as an integer number of minutes.
	 */
	Length_in_minutes("04");

	public final String code;

	private ResourceFeatureTypes(String code)
	{
		this.code = code;
	}

	private static ResourceFeatureTypes[] values = ResourceFeatureTypes.values();
	public static ResourceFeatureTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ResourceFeatureTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

