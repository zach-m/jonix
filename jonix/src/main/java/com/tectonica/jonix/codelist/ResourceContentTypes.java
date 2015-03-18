package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 158
 * 
 * @author Zach Melamed
 * 
 */
public enum ResourceContentTypes
{
	Front_cover("01"),

	Back_cover("02"),

	/**
	 * Not limited to front or back.
	 */
	Cover___pack("03"),

	/**
	 * Photograph or portrait of contributor(s).
	 */
	Contributor_picture("04"),

	Series_image___artwork("05"),

	Series_logo("06"),

	Product_image___artwork("07"),

	Product_logo("08"),

	Publisher_logo("09"),

	Imprint_logo("10"),

	Contributor_interview("11"),

	/**
	 * Contributor presentation and/or commentary.
	 */
	Contributor_presentation("12"),

	Contributor_reading("13"),

	/**
	 * Link to a schedule in iCalendar format.
	 */
	Contributor_event_schedule("14"),

	/**
	 * For example: sample chapter text, page images, screenshots.
	 */
	Sample_content("15"),

	/**
	 * A ‘look inside’ feature presented as a small embeddable application.
	 */
	Widget("16"),

	/**
	 * Use the <TextContent> composite for review quotes carried in the ONIX record. Use the <CitedContent> composite for a third-party review which is referenced from the ONIX record. Use <SupportingResource> only for a review which is offered for reproduction as part of promotional material for the product.
	 */
	Review("17"),

	Other_commentary___discussion("18"),

	Reading_group_guide("19"),

	Teachers_guide("20"),

	/**
	 * Feature article provided by publisher.
	 */
	Feature_article("21"),

	/**
	 * Fictional character ‘interview’.
	 */
	Character__interview("22"),

	Wallpaper___screensaver("23"),

	Press_release("24"),

	/**
	 * A table of contents held on a webpage, not in the ONIX record.
	 */
	Table_of_contents("25"),

	/**
	 * A promotional video, similar to a movie trailer (sometimes referred to as a ‘book trailer’).
	 */
	Trailer("26"),

	/**
	 * Intended ONLY for transitional use, where ONIX 2.1 records referencing existing thumbnail assets of unknown pixel size are being re-expressed in ONIX 3.0. Use code 01 for all new cover assets, and where the pixel size of older assets is known.
	 */
	Cover_thumbnail("27"),

	/**
	 * The full content of the product (or the product itself), supplied for example to support full-text search.
	 */
	Full_content("28"),

	/**
	 * Includes cover, back cover, spine and – where appropriate – any flaps.
	 */
	Full_cover("29"),

	Master_brand_logo("30");

	public final String code;

	private ResourceContentTypes(String code)
	{
		this.code = code;
	}

	private static ResourceContentTypes[] values = ResourceContentTypes.values();
	public static ResourceContentTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ResourceContentTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

