package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 25
 * 
 * @author Zach Melamed
 * 
 */
public enum IllustrationAndOtherContentTypes
{
	/**
	 * See description in the <IllustrationTypeDescription> element.
	 */
	Unspecified__see_description("00"),

	Illustrations__black_and_white("01"),

	Illustrations__color("02"),

	/**
	 * Including black and white photographs.
	 */
	Halftones__black_and_white("03"),

	/**
	 * Including color photographs.
	 */
	Halftones__color("04"),

	Line_drawings__black_and_white("05"),

	Line_drawings__color("06"),

	Tables__black_and_white("07"),

	Tables__color("08"),

	Illustrations__unspecified("09"),

	/**
	 * Including photographs.
	 */
	Halftones__unspecified("10"),

	Tables__unspecified("11"),

	Line_drawings__unspecified("12"),

	Halftones__duotone("13"),

	Maps("14"),

	Frontispiece("15"),

	Diagrams("16"),

	Figures("17"),

	Charts("18"),

	/**
	 * Recorded music extracts or examples, or complete recorded work(s), accompanying textual or other content.
	 */
	Recorded_music_items("19"),

	/**
	 * Printed music extracts or examples, or complete music score(s), accompanying textual or other content.
	 */
	Printed_music_items("20"),

	/**
	 * To be used in the mathematical sense of a diagram that represents numerical values plotted against an origin and axes, cf codes 16 and 18.
	 */
	Graphs("21"),

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__unspecified("22"),

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__black_and_white("23"),

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__color("24"),

	Index("25"),

	Bibliography("26"),

	/**
	 * Larger-scale inset maps of places or features of interest included in a map product.
	 */
	Inset_maps("27"),

	/**
	 * GPS grids included in a map product.
	 */
	GPS_grids("28");

	public final String code;

	private IllustrationAndOtherContentTypes(String code)
	{
		this.code = code;
	}

	private static IllustrationAndOtherContentTypes[] values = IllustrationAndOtherContentTypes.values();
	public static IllustrationAndOtherContentTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (IllustrationAndOtherContentTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

