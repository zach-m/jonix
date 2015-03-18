package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 80
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductPackagingTypes
{
	/**
	 * No packaging, or all smaller items enclosed inside largest item.
	 */
	No_outer_packaging("00"),

	/**
	 * Thin card sleeve, much less rigid than a slip case.
	 */
	Slipsleeve("01"),

	/**
	 * Packaging consisting of formed plastic sealed around each side of the product. Not to be confused with single-sided Blister pack.
	 */
	Clamshell("02"),

	/**
	 * Typical DVD-style packaging, sometimes known as an ‘Amaray’ case.
	 */
	Keep_case("03"),

	/**
	 * Typical CD-style packaging.
	 */
	Jewel_case("05"),

	/**
	 * Individual item, items or set in card box with separate or hinged lid: not to be confused with the commonly-used ‘boxed set’.
	 */
	In_box("09"),

	/**
	 * Slip-case for single item only: German ‘Schuber’.
	 */
	Slipcased("10"),

	/**
	 * Slip-case for multi-volume set: German ‘Kassette’; also commonly referred to as ‘boxed set’.
	 */
	Slipcased_set("11"),

	/**
	 * Rolled in tube or cylinder: eg sheet map or poster.
	 */
	Tube("12"),

	/**
	 * Use for miscellaneous items such as slides, microfiche, when presented in a binder.
	 */
	Binder("13"),

	/**
	 * Use for miscellaneous items such as slides, microfiche, when presented in a wallet or folder.
	 */
	In_wallet_or_folder("14"),

	/**
	 * Long package with triangular cross-section used for rolled sheet maps, posters etc.
	 */
	Long_triangular_package("15"),

	/**
	 * Long package with square cross-section used for rolled sheet maps, posters, etc.
	 */
	Long_square_package("16"),

	Softbox_for_DVD("17"),

	/**
	 * In pouch, eg teaching materials in a plastic bag or pouch.
	 */
	Pouch("18"),

	/**
	 * In duroplastic or other rigid plastic case, eg for a class set.
	 */
	Rigid_plastic_case("19"),

	/**
	 * In cardboard case, eg for a class set.
	 */
	Cardboard_case("20"),

	/**
	 * Use for products or product bundles supplied for retail sale in shrink-wrapped packaging. For shrink-wrapped packs of multiple products for trade supply only, see code XL in List 7.
	 */
	Shrinkwrapped("21"),

	/**
	 * A pack comprising a pre-formed plastic blister and a printed card with a heat-seal coating.
	 */
	Blister_pack("22"),

	/**
	 * A case with carrying handle, typically for a set of educational books and/or learning materials.
	 */
	Carry_case("23");

	public final String code;

	private ProductPackagingTypes(String code)
	{
		this.code = code;
	}

	private static ProductPackagingTypes[] values = ProductPackagingTypes.values();
	public static ProductPackagingTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductPackagingTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

