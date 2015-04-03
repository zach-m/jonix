/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList21
 * <p>
 * Edition type code
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum EditionTypes
{
	/**
	 * Content has been shortened: use for abridged, shortened, concise, condensed.
	 */
	Abridged_edition("ABR"), //

	/**
	 * Version of a play or script intended for use of those directly involved in a production, usually including full stage directions in
	 * addition to the text of the script.
	 */
	Acting_edition("ACT"), //

	/**
	 * Content has been adapted to serve a different purpose or audience, or from one medium to another: use for dramatization, novelization
	 * etc. Use <EditionStatement> to describe the exact nature of the adaptation.
	 */
	Adapted_edition("ADP"), //

	/**
	 * Do not use. This code is now DEPRECATED, but is retained in the list for reasons of backwards compatibility.
	 */
	Alternate("ALT"), //

	/**
	 * Content is augmented by the addition of notes.
	 */
	Annotated_edition("ANN"), //

	/**
	 * Both languages should be specified in the ‘Language’ group. Use MLL for an edition in more than two languages.
	 */
	Bilingual_edition("BLL"), //

	/**
	 * Braille edition.
	 */
	Braille_edition("BRL"), //

	/**
	 * An edition in which two or more works also published separately are combined in a single volume; AKA ‘omnibus’ edition.
	 */
	Combined_volume("CMB"), //

	/**
	 * Content includes critical commentary on the text.
	 */
	Critical_edition("CRI"), //

	/**
	 * Content was compiled for a specified educational course.
	 */
	Coursepack("CSP"), //

	/**
	 * A digital product that, at the time of publication, has or had no print counterpart and that is or was not expected to have a print
	 * counterpart for a reasonable time (recommended at least 30 days following publication).
	 */
	Digital_original("DGO"), //

	/**
	 * Use for e-publications that have been enhanced with additional text, speech, other audio, video, interactive or other content.
	 */
	Enhanced_edition("ENH"), //

	/**
	 * Content has been enlarged or expanded from that of a previous edition.
	 */
	Enlarged_edition("ENL"), //

	/**
	 * ‘Offensive’ content has been removed.
	 */
	Expurgated_edition("EXP"), //

	/**
	 * Exact reproduction of the content and format of a previous edition.
	 */
	Facsimile_edition("FAC"), //

	/**
	 * A collection of writings published in honor of a person, an institution or a society.
	 */
	Festschrift("FST"), //

	/**
	 * Content includes extensive illustrations which are not part of other editions.
	 */
	Illustrated_edition("ILL"), //

	/**
	 * Large print edition, print sizes 14 to 19 pt – see also ULP.
	 */
	Large_type_large_print_edition("LTE"), //

	/**
	 * A printed edition in a type size too small to be read without a magnifying glass.
	 */
	Microprint_edition("MCP"), //

	/**
	 * An edition published to coincide with the release of a film, TV program, or electronic game based on the same work. Use
	 * <EditionStatement> to describe the exact nature of the tie-in.
	 */
	Media_tie_in("MDT"), //

	/**
	 * All languages should be specified in the ‘Language’ group. Use BLL for a bilingual edition.
	 */
	Multilingual_edition("MLL"), //

	/**
	 * Where no other information is given, or no other coded type is applicable.
	 */
	New_edition("NED"), //

	/**
	 * A limited edition in which each copy is individually numbered.
	 */
	Edition_with_numbered_copies("NUM"), //

	/**
	 * In the US, a book that was previously bound, normally as a paperback, and has been rebound with a library-quality hardcover binding
	 * by a supplier other than the original publisher. See also the <Publisher> and <RelatedProduct> composites for other aspects of the
	 * treatment of prebound editions in ONIX.
	 */
	Prebound_edition("PRB"), //

	/**
	 * Content has been revised from that of a previous edition.
	 */
	Revised_edition("REV"), //

	/**
	 * An edition intended specifically for use in schools.
	 */
	School_edition("SCH"), //

	/**
	 * An edition that uses simplified language (Finnish ‘Selkokirja’).
	 */
	Simplified_language_edition("SMP"), //

	/**
	 * Use for anniversary, collectors’, de luxe, gift, limited (but unnumbered), autographed edition. Use <EditionStatement> to describe
	 * the exact nature of the special edition.
	 */
	Special_edition("SPE"), //

	/**
	 * Where a text is available in both student and teacher’s editions.
	 */
	Student_edition("STU"), //

	/**
	 * Where a text is available in both student and teacher’s editions; use also for instructor’s or leader’s editions.
	 */
	Teacher_s_edition("TCH"), //

	/**
	 * Where a title has also been published in an abridged edition; also for audiobooks, regardless of whether an abridged audio version
	 * also exists.
	 */
	Unabridged_edition("UBR"), //

	/**
	 * For print sizes 20pt and above, and with typefaces designed for the visually impaired – see also LTE.
	 */
	Ultra_large_print_edition("ULP"), //

	/**
	 * Content previously considered ‘offensive’ has been restored.
	 */
	Unexpurgated_edition("UXP"), //

	/**
	 * Content includes notes by various commentators, and/or includes and compares several variant texts of the same work.
	 */
	Variorum_edition("VAR");

	public final String value;

	private EditionTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, EditionTypes> map;

	private static Map<String, EditionTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (EditionTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static EditionTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
