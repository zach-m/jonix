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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 11</b>
 * <p>
 * Description: Epublication format code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist11">ONIX
 *      Codelist 11 in Reference Guide</a>
 */
public enum EpublicationFormats
{
	HTML("01", "HTML"), //

	PDF("02", "PDF"), //

	/**
	 * '.LIT' file format used by Microsoft Reader software
	 */
	Microsoft_Reader("03", "Microsoft Reader"), //

	RocketBook("04", "RocketBook"), //

	Rich_text_format_RTF("05", "Rich text format (RTF)"), //

	Open_Ebook_Publication_Structure_OEBPS("06", "Open Ebook Publication Structure (OEBPS) format standard"), //

	XML("07", "XML"), //

	SGML("08", "SGML"), //

	/**
	 * '.EXE' file format used when an epublication is delivered as a self-executing package of software and content
	 */
	EXE("09", "EXE"), //

	/**
	 * '.TXT' file format
	 */
	ASCII("10", "ASCII"), //

	/**
	 * Proprietary file format used for the MobiPocket reader software
	 */
	MobiPocket_format("11", "MobiPocket format");

	public final String value;
	public final String label;

	private EpublicationFormats(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, EpublicationFormats> map;

	private static Map<String, EpublicationFormats> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (EpublicationFormats e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static EpublicationFormats byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
