package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 21
 * 
 * @author Zach Melamed
 * 
 */
public enum EditionTypes
{
	/**
	 * Content has been shortened: use for abridged, shortened, concise, condensed.
	 */
	Abridged("ABR"),

	/**
	 * Version of a play or script intended for use of those directly involved in a production, usually including full stage directions in addition to the text of the script.
	 */
	Acting_edtion("ACT"),

	/**
	 * Content has been adapted to serve a different purpose or audience, or from one medium to another: use for dramatization, novelization etc. Use <EditionStatement> to describe the exact nature of the adaptation.
	 */
	Adapted("ADP"),

	/**
	 * Do not use. This code is now DEPRECATED, but is retained in the list for reasons of backwards compatibility.
	 */
	Alternate("ALT"),

	/**
	 * Content is augmented by the addition of notes.
	 */
	Annotated("ANN"),

	/**
	 * Both languages should be specified in the ‘Language’ group. Use MLL for an edition in more than two languages.
	 */
	Bilingual_edition("BLL"),

	/**
	 * Braille edition.
	 */
	Braille("BRL"),

	/**
	 * An edition in which two or more works also published separately are combined in a single volume; AKA ‘omnibus’ edition.
	 */
	Combined_volume("CMB"),

	/**
	 * Content includes critical commentary on the text.
	 */
	Critical("CRI"),

	/**
	 * Content was compiled for a specified educational course.
	 */
	Coursepack("CSP"),

	/**
	 * A digital product which has no print counterpart and is not expected to have a print counterpart.
	 */
	Digital_original("DGO"),

	/**
	 * Use for e-publications that have been enhanced with additional text, speech, other audio, video, interactive or other content.
	 */
	Enhanced("ENH"),

	/**
	 * Content has been enlarged or expanded from that of a previous edition.
	 */
	Enlarged("ENL"),

	/**
	 * ‘Offensive’ content has been removed.
	 */
	Expurgated("EXP"),

	/**
	 * Exact reproduction of the content and format of a previous edition.
	 */
	Facsimile("FAC"),

	/**
	 * A collection of writings published in honor of a person, an institution or a society.
	 */
	Festschrift("FST"),

	/**
	 * Content includes extensive illustrations which are not part of other editions.
	 */
	Illustrated("ILL"),

	/**
	 * Large print edition, print sizes 14 to 19 pt – see also ULP.
	 */
	Large_type___large_print("LTE"),

	/**
	 * A printed edition in a type size too small to be read without a magnifying glass.
	 */
	Microprint("MCP"),

	/**
	 * An edition published to coincide with the release of a film, TV program, or electronic game based on the same work. Use <EditionStatement> to describe the exact nature of the tie-in.
	 */
	Media_tiein("MDT"),

	/**
	 * All languages should be specified in the ‘Language’ group. Use BLL for a bilingual edition.
	 */
	Multilingual_edition("MLL"),

	/**
	 * Where no other information is given, or no other coded type is applicable.
	 */
	New_edition("NED"),

	/**
	 * A limited edition in which each copy is individually numbered.
	 */
	Edition_with_numbered_copies("NUM"),

	/**
	 * In the US, a book that was previously bound, normally as a paperback, and has been rebound with a library-quality hardcover binding by a supplier other than the original publisher. See also the <Publisher> and <RelatedProduct> composites for other aspects of the treatment of prebound editions in ONIX.
	 */
	Prebound_edition("PRB"),

	/**
	 * Content has been revised from that of a previous edition.
	 */
	Revised("REV"),

	/**
	 * An edition intended specifically for use in schools.
	 */
	School_edition("SCH"),

	/**
	 * An edition that uses simplified language (Finnish ‘Selkokirja’).
	 */
	Simplified_language_edition("SMP"),

	/**
	 * Use for anniversary, collectors’, de luxe, gift, limited, numbered, autographed edition. Use <EditionStatement> to describe the exact nature of the special edition.
	 */
	Special_edition("SPE"),

	/**
	 * Where a text is available in both student and teacher’s editions.
	 */
	Student_edition("STU"),

	/**
	 * Where a text is available in both student and teacher’s editions; use also for instructor’s or leader’s editions.
	 */
	Teachers_edition("TCH"),

	/**
	 * Where a title has also been published in an abridged edition; also for audiobooks, regardless of whether an abridged audio version also exists.
	 */
	Unabridged("UBR"),

	/**
	 * For print sizes 20pt and above, and with typefaces designed for the visually impaired – see also LTE.
	 */
	Ultra_large_print("ULP"),

	/**
	 * Content previously considered ‘offensive’ has been restored.
	 */
	Unexpurgated("UXP"),

	/**
	 * Content includes notes by various commentators, and/or includes and compares several variant texts of the same work.
	 */
	Variorum("VAR");

	public final String code;

	private EditionTypes(String code)
	{
		this.code = code;
	}

	private static EditionTypes[] values = EditionTypes.values();
	public static EditionTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (EditionTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

