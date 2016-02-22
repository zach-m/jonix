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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 21</b>
 * <p>
 * Description: Edition type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist21">ONIX
 *      Codelist 21 in Reference Guide</a>
 */
public enum EditionTypes implements OnixCodelist
{
	/**
	 * Content has been shortened: use for abridged, shortened, concise, condensed
	 */
	Abridged_edition("ABR", "Abridged edition"), //

	/**
	 * Version of a play or script intended for use of those directly involved in a production, usually including full
	 * stage directions in addition to the text of the script
	 */
	Acting_edition("ACT", "Acting edition"), //

	/**
	 * Content has been adapted to serve a different purpose or audience, or from one medium to another: use for
	 * dramatization, novelization etc. Use &lt;EditionStatement&gt; to describe the exact nature of the adaptation
	 */
	Adapted_edition("ADP", "Adapted edition"), //

	/**
	 * Do not use. This code is now DEPRECATED, but is retained in the list for reasons of backwards compatibility
	 */
	Alternate("ALT", "Alternate"), //

	/**
	 * Content is augmented by the addition of notes
	 */
	Annotated_edition("ANN", "Annotated edition"), //

	/**
	 * Both languages should be specified in the 'Language' group. Use MLL for an edition in more than two languages
	 */
	Bilingual_edition("BLL", "Bilingual edition"), //

	/**
	 * Braille edition
	 */
	Braille_edition("BRL", "Braille edition"), //

	/**
	 * An edition in which two or more works also published separately are combined in a single volume; AKA 'omnibus'
	 * edition
	 */
	Combined_volume("CMB", "Combined volume"), //

	/**
	 * Content includes critical commentary on the text
	 */
	Critical_edition("CRI", "Critical edition"), //

	/**
	 * Content was compiled for a specified educational course
	 */
	Coursepack("CSP", "Coursepack"), //

	/**
	 * A digital product that, at the time of publication, has or had no print counterpart and that is or was not
	 * expected to have a print counterpart for a reasonable time (recommended at least 30 days following publication)
	 */
	Digital_original("DGO", "Digital original"), //

	/**
	 * Use for e-publications that have been enhanced with additional text, speech, other audio, video, interactive or
	 * other content
	 */
	Enhanced_edition("ENH", "Enhanced edition"), //

	/**
	 * Content has been enlarged or expanded from that of a previous edition
	 */
	Enlarged_edition("ENL", "Enlarged edition"), //

	/**
	 * 'Offensive' content has been removed
	 */
	Expurgated_edition("EXP", "Expurgated edition"), //

	/**
	 * Exact reproduction of the content and format of a previous edition
	 */
	Facsimile_edition("FAC", "Facsimile edition"), //

	/**
	 * A collection of writings published in honor of a person, an institution or a society
	 */
	Festschrift("FST", "Festschrift"), //

	/**
	 * Content includes extensive illustrations which are not part of other editions
	 */
	Illustrated_edition("ILL", "Illustrated edition"), //

	/**
	 * Large print edition, print sizes 14 to 19 pt - see also ULP
	 */
	Large_type_large_print_edition("LTE", "Large type / large print edition"), //

	/**
	 * A printed edition in a type size too small to be read without a magnifying glass
	 */
	Microprint_edition("MCP", "Microprint edition"), //

	/**
	 * An edition published to coincide with the release of a film, TV program, or electronic game based on the same
	 * work. Use &lt;EditionStatement&gt; to describe the exact nature of the tie-in
	 */
	Media_tie_in("MDT", "Media tie-in"), //

	/**
	 * All languages should be specified in the 'Language' group. Use BLL for a bilingual edition
	 */
	Multilingual_edition("MLL", "Multilingual edition"), //

	/**
	 * Where no other information is given, or no other coded type is applicable
	 */
	New_edition("NED", "New edition"), //

	/**
	 * A limited edition in which each copy is individually numbered. Use &lt;EditionStatement&gt; to give details of
	 * the number of copies printed
	 */
	Edition_with_numbered_copies("NUM", "Edition with numbered copies"), //

	/**
	 * In the US, a book that was previously bound, normally as a paperback, and has been rebound with a library-quality
	 * hardcover binding by a supplier other than the original publisher. See also the &lt;Publisher&gt; and
	 * &lt;RelatedProduct&gt; composites for other aspects of the treatment of prebound editions in ONIX
	 */
	Prebound_edition("PRB", "Prebound edition"), //

	/**
	 * Content has been revised from that of a previous edition
	 */
	Revised_edition("REV", "Revised edition"), //

	/**
	 * An edition intended specifically for use in schools
	 */
	School_edition("SCH", "School edition"), //

	/**
	 * An edition that uses simplified language (Finnish 'Selkokirja')
	 */
	Simplified_language_edition("SMP", "Simplified language edition"), //

	/**
	 * Use for anniversary, collectors', de luxe, gift, limited (but prefer codes NUM or UNN as appropriate),
	 * autographed edition. Use &lt;EditionStatement&gt; to describe the exact nature of the special edition
	 */
	Special_edition("SPE", "Special edition"), //

	/**
	 * Where a text is available in both student and teacher's editions
	 */
	Student_edition("STU", "Student edition"), //

	/**
	 * Where a text is available in both student and teacher's editions; use also for instructor's or leader's editions
	 */
	Teacher_s_edition("TCH", "Teacher’s edition"), //

	/**
	 * Where a title has also been published in an abridged edition; also for audiobooks, regardless of whether an
	 * abridged audio version also exists
	 */
	Unabridged_edition("UBR", "Unabridged edition"), //

	/**
	 * For print sizes 20pt and above, and with typefaces designed for the visually impaired - see also LTE
	 */
	Ultra_large_print_edition("ULP", "Ultra large print edition"), //

	/**
	 * A limited edition in which each copy is not individually numbered - but where the actual number of copies is
	 * strictly limited. Use &lt;EditionStatement&gt; to give details of the number of copies printed &lt;p&gt;NOTE:
	 * Introduced in Onix3
	 */
	Edition_with_unnumbered_copies("UNN", "Edition with unnumbered copies"), //

	/**
	 * Content previously considered 'offensive' has been restored
	 */
	Unexpurgated_edition("UXP", "Unexpurgated edition"), //

	/**
	 * Content includes notes by various commentators, and/or includes and compares several variant texts of the same
	 * work
	 */
	Variorum_edition("VAR", "Variorum edition");

	public final String code;
	public final String description;

	private EditionTypes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static Map<String, EditionTypes> map;

	private static Map<String, EditionTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (EditionTypes e : values())
				map.put(e.code, e);
		}
		return map;
	}

	public static EditionTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
