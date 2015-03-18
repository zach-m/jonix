package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 48
 * 
 * @author Zach Melamed
 * 
 */
public enum MeasureTypes
{
	/**
	 * For a book, the spine height when standing on a shelf. For a folded map, the height when folded. In general, the height of a product in the form in which it is presented or packaged for retail sale.
	 */
	Height("01"),

	/**
	 * For a book, the horizontal dimension of the cover when standing upright. For a folded map, the width when folded. In general, the width of a product in the form in which it is presented or packaged for retail sale.
	 */
	Width("02"),

	/**
	 * For a book, the thickness of the spine. For a folded map, the thickness when folded. In general, the thickness or depth of a product in the form in which it is presented or packaged for retail sale.
	 */
	Thickness("03"),

	/**
	 * Not recommended for general use.
	 */
	Page_trim_height("04"),

	/**
	 * Not recommended for general use.
	 */
	Page_trim_width("05"),

	Unit_weight("08"),

	/**
	 * Of a globe, for example.
	 */
	Diameter_sphere("09"),

	/**
	 * The height of a folded or rolled sheet map, poster etc when unfolded.
	 */
	Unfolded_unrolled_sheet_height("10"),

	/**
	 * The width of a folded or rolled sheet map, poster etc when unfolded.
	 */
	Unfolded_unrolled_sheet_width("11"),

	/**
	 * The diameter of the cross-section of a tube or cylinder, usually carrying a rolled sheet product. Use 01 “height” for the height or length of the tube.
	 */
	Diameter_tube_or_cylinder("12"),

	/**
	 * The length of a side of the cross-section of a long triangular or square package, usually carrying a rolled sheet product. Use 01 “height” for the height or length of the package.
	 */
	Rolled_sheet_package_side_measure("13");

	public final String code;

	private MeasureTypes(String code)
	{
		this.code = code;
	}

	private static MeasureTypes[] values = MeasureTypes.values();
	public static MeasureTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (MeasureTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

