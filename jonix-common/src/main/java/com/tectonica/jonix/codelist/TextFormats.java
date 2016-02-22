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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 34</b>
 * <p>
 * Description: Text format code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist34">ONIX
 *      Codelist 34 in Reference Guide</a>
 */
public enum TextFormats implements OnixCodelist
{
	/**
	 * DEPRECATED: use code 06 or 07 as appropriate
	 */
	ASCII_text("00", "ASCII text"), //

	SGML("01", "SGML"), //

	/**
	 * Other than XHTML
	 */
	HTML("02", "HTML"), //

	/**
	 * Other than XHTML
	 */
	XML("03", "XML"), //

	/**
	 * DEPRECATED: was formerly assigned both to PDF and to XHTML
	 */
	PDF("04", "PDF"), //

	XHTML("05", "XHTML"), //

	/**
	 * Default: text in the encoding declared at the head of the message or in the XML default (UTF-8 or UTF-16) if
	 * there is no explicit declaration
	 */
	Default_text_format("06", "Default text format"), //

	/**
	 * Plain text containing no tags of any kind, except for the tags &amp;amp; and &amp;lt; that XML insists must be
	 * used to represent ampersand and less-than characters in text; and with the character set limited to the ASCII
	 * range, i.e. valid UTF-8 characters whose character number lies between 32 (space) and 126 (tilde)
	 */
	Basic_ASCII_text("07", "Basic ASCII text"), //

	/**
	 * Replaces 04 for the &lt;TextFormat&gt; element, but cannot of course be used as a textformat attribute
	 */
	PDF_("08", "PDF"), //

	Microsoft_rich_text_format_RTF("09", "Microsoft rich text format (RTF)"), //

	Microsoft_Word_binary_format_DOC("10", "Microsoft Word binary format (DOC)"), //

	/**
	 * Office Open XML file format / OOXML / DOCX
	 */
	ECMA_376_WordprocessingML("11", "ECMA 376 WordprocessingML"), //

	/**
	 * ISO Open Document Format
	 */
	ISO_26300_ODF("12", "ISO 26300 ODF"), //

	Corel_Wordperfect_binary_format_DOC("13", "Corel Wordperfect binary format (DOC)"), //

	/**
	 * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum
	 * (IDPF) [File extension .epub]
	 */
	EPUB("14", "EPUB"), //

	/**
	 * XML Paper Specification
	 */
	XPS("15", "XPS");

	public final String code;
	public final String description;

	private TextFormats(String code, String description)
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

	private static Map<String, TextFormats> map;

	private static Map<String, TextFormats> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (TextFormats e : values())
				map.put(e.code, e);
		}
		return map;
	}

	public static TextFormats byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
