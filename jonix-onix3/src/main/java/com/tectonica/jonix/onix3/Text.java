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
 * <h1>Text</h1>
 * <p>
 * The text specified in the &lt;TextType&gt; element. Mandatory in each occurrence of the &lt;TextContent&gt;
 * composite, and repeatable when essentially identical text is supplied in multiple languages. The <i>language</i>
 * attribute is optional for a single instance of &lt;Text&gt;, but must be included in each instance if &lt;Text&gt; is
 * repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text. XHTML is enabled in this element - see Using XHTML, HTML or XML with ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Text&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;d104&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;Text textformat=&quot;05&quot;&gt;&lt;ul&gt;&lt;li&gt;Introduction: aesthetics and modernity; aesthetics and
 * post-modernity&lt;/li&gt;&lt;li&gt;Part 1: Modern philosophy and the emergence of aesthetic theory - Kant:
 * self-consciousness, knowledge and freedom; the unity of the subject; the unification of nature; the purpose of
 * beauty; the limits of beauty&lt;/li&gt;&lt;li&gt;Part 2: German idealism and early German Romanticism: the 'new
 * mythology'; the romantic 'new mythology'&lt;/li&gt;&lt;li&gt;Part 3: Reflections on the subject - Fichte, Holderlin
 * and Novalis&lt;/li&gt;&lt;li&gt;Part 4: Schelling - art as the 'organ of philosophy': the development of
 * consciousness; the structure of the 'system of transcendental idealism'; the aesthetic absolute; mythology, art and
 * language; mythology, language and being&lt;/li&gt;&lt;li&gt;Part 5&#8230;&lt;/li&gt;&lt;/ul&gt;&lt;/Text&gt; (Table
 * of contents supplied as a list, with XHTML markup)</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>&lt;d104 language=&quot;eng&quot;&gt;'The Name of the Rose' is the author's first novel. It is a historical
 * murder mystery set in an Italian monastery in the year 1327, an intellectual mystery weaving semiotics, biblical
 * analysis, medieval studies and literary theory into gripping fiction.&lt;/d104&gt; &lt;d104
 * language=&quot;ita&quot;&gt;'Il nome della rosa' &#232; il primo romanzo dell'autore. Si tratta di un misterioso
 * omicidio storico ambientato in un monastero italiano nel corso dell'anno 1327, un mistero intellettuale che unisce
 * semiotica, analisi biblici, studi medievali e teoria letteraria nella narrativa avvincente.&lt;/d104&gt; (Parallel
 * short description text provided in two languages)</td>
 * </tr>
 * </table>
 */
public class Text implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Text";
	public static final String shortname = "d104";

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
	 * Raw Format: Variable length text. XHTML is enabled in this element - see Using XHTML, HTML or XML with ONIX text
	 * fields
	 * <p>
	 * (type: XHTML)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Text()
	{}

	public Text(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));

		value = JPU.getChildXHTML(element, true);
	}
}
