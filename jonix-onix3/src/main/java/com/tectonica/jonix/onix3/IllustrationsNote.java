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

package com.tectonica.jonix.onix3;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextFormats;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Illustrations and other contents note</h1>
 * <p>
 * For books or other text media only, this data element carries text stating the number and type of illustrations. The
 * text may also include other content items, <i>eg</i> maps, bibliography, tables, index <i>etc</i>. Optional, and
 * repeatable if parallel notes are provided in multiple languages. The <i>language</i> attribute is optional for a
 * single instance of &lt;IllustrationsNote&gt;, but must be included in each instance if &lt;IllustrationsNote&gt; is
 * repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 200 characters. XHTML is enabled in this element - see Using
 * XHTML, HTML or XML with ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;IllustrationsNote&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b062&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b062&gt;500 illustrations, 210 in full color&lt;/b062&gt;</td>
 * </tr>
 * </table>
 */
public class IllustrationsNote implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "IllustrationsNote";
	public static final String shortname = "b062";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	public LanguageCodes language;

	public TextFormats textformat;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable length text, suggested maximum length 200 characters. XHTML is enabled in this element - see
	 * Using XHTML, HTML or XML with ONIX text fields
	 * <p>
	 * (type: XHTML)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public IllustrationsNote()
	{}

	public IllustrationsNote(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));

		value = JPU.getChildXHTML(element, true);
	}
}
