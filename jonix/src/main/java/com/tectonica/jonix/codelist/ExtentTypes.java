package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 23
 * 
 * @author Zach Melamed
 * 
 */
public enum ExtentTypes
{
	/**
	 * The highest-numbered page in a single numbered sequence of main content, usually the highest Arabic-numbered page in a book; or, for books without page numbers or (rarely) with multiple numbered sequences of main content, the total number of pages that carry the main content of the book. Note that this may include numbered but otherwise blank pages (eg pages inserted to ensure chapters start on a recto page) and may exclude unnumbered (but contentful) pages such as those in inserts/plate sections. Either this or the Content Page count is the preferred page count for most books for the general reader. For books with substantial front and/or back matter, include also Front matter and Back matter page counts, or Total numbered pages. For books with inserts (plate sections), also include Total unnumbered insert page count whenever possible.
	 */
	Main_content_page_count("00"),

	/**
	 * Number of words of natural language text.
	 */
	Number_of_words("02"),

	/**
	 * The total number of numbered (usually Roman-numbered) pages that precede the main content of a book. This usually consists of various title and imprint pages, table of contents, an introduction, preface, foreword, etc.
	 */
	Front_matter_page_count("03"),

	/**
	 * The total number of numbered (usually Roman-numbered) pages that follow the main content of a book. This usually consists of an afterword, appendices, endnotes, index, etc. It excludes blank (or advertising) pages that are present only for convenience of printing and binding.
	 */
	Back_matter_page_count("04"),

	/**
	 * The sum of all Roman- and Arabic-numbered pages. Note that this may include numbered but otherwise blank pages (eg pages inserted to ensure chapters start on a recto page) and may exclude unnumbered (but contentful) pages such as those in inserts/plate sections.
	 */
	Total_numbered_pages("05"),

	/**
	 * The total number of pages in a book, including unnumbered pages, front matter, back matter, etc. This includes any blank pages at the back that carry no content and are present only for convenience of printing and binding.
	 */
	Production_page_count("06"),

	/**
	 * The total number of pages of the book counting the cover as page 1. This page count type should be used only for digital publications delivered with fixed pagination.
	 */
	Absolute_page_count("07"),

	/**
	 * The total number of pages (equivalent to the Content page count) in the print counterpart of a digital product delivered without fixed pagination.
	 */
	Number_of_pages_in_print_counterpart("08"),

	/**
	 * Total duration in time, expressed in the specified extent unit. This is the ‘running time’ equivalent of codes 05 or 11.
	 */
	Duration("09"),

	/**
	 * An estimate of the number of ‘pages’ in a digital product delivered without fixed pagination, and with no print counterpart, given as an indication of the size of the work. Equivalent to code 08, but for exclusively digital products.
	 */
	Notional_number_of_pages_in_digital_product("10"),

	/**
	 * The sum of all Roman- and Arabic-numbered and contentful unnumbered pages. Sum of page counts with codes 00, 03, 04 and 12, and also the sum of 05 and 12.
	 */
	Content_page_count("11"),

	/**
	 * The total number of unnumbered pages with content inserted within the main content of a book – for example inserts/plate sections that are not numbered.
	 */
	Total_unnumbered_insert_page_count("12"),

	/**
	 * Duration in time, expressed in the specified extent units, of introductory matter. This is the ‘running time’ equivalent of code 03, and comprises any significant amount of running time represented by announcements, titles, introduction or other material prefacing the main content.
	 */
	Duration_of_introductory_matter("13"),

	/**
	 * Duration in time, expressed in the specified extent units, of the main content. This is the ‘running time’ equivalent of code 00, and excludes time represented by announcements, titles, introduction or other prefatory material or 'back matter'.
	 */
	Duration_of_main_content("14"),

	/**
	 * The size of a digital file, expressed in the specified extent unit.
	 */
	Filesize("22");

	public final String code;

	private ExtentTypes(String code)
	{
		this.code = code;
	}

	private static ExtentTypes[] values = ExtentTypes.values();
	public static ExtentTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ExtentTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

