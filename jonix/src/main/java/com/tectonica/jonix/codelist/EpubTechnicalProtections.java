package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 144
 * 
 * @author Zach Melamed
 * 
 */
public enum EpubTechnicalProtections
{
	/**
	 * Has no technical protection.
	 */
	None("00"),

	/**
	 * Has DRM protection.
	 */
	DRM("01"),

	/**
	 * Has digital watermarking.
	 */
	Digital_watermarking("02"),

	/**
	 * Has DRM protection applied by the Adobe CS4 Content Server Package or by the Adobe ADEPT hosted service.
	 */
	Adobe_DRM("03"),

	/**
	 * FairPlay’ DRM protection applied via Apple proprietary online store.
	 */
	Apple_DRM("04"),

	/**
	 * Has OMA v2 DRM protection applied, as used to protect some mobile phone content.
	 */
	OMA_DRM("05");

	public final String code;

	private EpubTechnicalProtections(String code)
	{
		this.code = code;
	}

	private static EpubTechnicalProtections[] values = EpubTechnicalProtections.values();
	public static EpubTechnicalProtections fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (EpubTechnicalProtections item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

