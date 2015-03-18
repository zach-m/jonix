package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 99
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductFormFeatureValueSpecialCoverMaterials
{
	/**
	 * Pigskin.
	 */
	Berkshire_leather("01"),

	Calfskin("02"),

	/**
	 * Calf split or sheep split.
	 */
	French_Morocco("03"),

	/**
	 * Goatskin.
	 */
	Morocco("04"),

	Bonded_buffalo_grain("05"),

	Bonded_calf_grain("06"),

	Bonded_Cordova("07"),

	Bonded_eelskin("08"),

	Bonded_Ostraleg("09"),

	Bonded_ostrich("10"),

	Bonded_reptile_grain("11"),

	Bonded_leather("12"),

	Cowhide("13"),

	Eelskin("14"),

	Kivar("15"),

	/**
	 * An imitation leather binding material.
	 */
	Leatherflex("16"),

	Moleskin("17"),

	Softhide_leather("18"),

	Metal("19"),

	/**
	 * German ‘Samt’.
	 */
	Velvet("20"),

	/**
	 * Spanish ‘nácar’.
	 */
	Motherofpearl("21"),

	Papyrus("22"),

	/**
	 * An imitation cloth binding material.
	 */
	G_ltex("23"),

	/**
	 * An imitation leather binding material.
	 */
	Guaflex("24");

	public final String code;

	private ProductFormFeatureValueSpecialCoverMaterials(String code)
	{
		this.code = code;
	}

	private static ProductFormFeatureValueSpecialCoverMaterials[] values = ProductFormFeatureValueSpecialCoverMaterials.values();
	public static ProductFormFeatureValueSpecialCoverMaterials fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductFormFeatureValueSpecialCoverMaterials item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

