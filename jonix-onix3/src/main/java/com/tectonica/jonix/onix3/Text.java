/*
 * Copyright (C) 2012-2023 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextFormats;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supporting text</h1>
 * <p>
 * The text specified in the &lt;TextType&gt; element. Mandatory in each occurrence of the &lt;TextContent&gt;
 * composite, and repeatable when essentially identical text is supplied in multiple languages. The <i>language</i>
 * attribute is optional for a single instance of &lt;Text&gt;, but must be included in each instance if &lt;Text&gt; is
 * repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text. XHTML is enabled in this element - see Using XHTML, HTML, XML, JSON within ONIX text
 * fields. Note that certain Text types impose a strict limit on the number of characters, and such limits do not count
 * the characters of any (X)HTML markup</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Text&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;d104&gt;</tt></td>
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
 * <td><tt>&lt;Text textformat=&quot;05&quot;&gt;&lt;ul&gt;&lt;li&gt;Introduction: aesthetics and modernity; aesthetics and post-modernity&lt;/li&gt;&lt;li&gt;Part 1: Modern philosophy and the emergence of aesthetic theory - Kant: self-consciousness, knowledge and freedom; the unity of the subject; the unification of nature; the purpose of beauty; the limits of beauty&lt;/li&gt;&lt;li&gt;Part 2: German idealism and early German Romanticism: the 'new mythology'; the romantic 'new mythology'&lt;/li&gt;&lt;li&gt;Part 3: Reflections on the subject - Fichte, Holderlin and Novalis&lt;/li&gt;&lt;li&gt;Part 4: Schelling - art as the 'organ of philosophy': the development of consciousness; the structure of the 'system of transcendental idealism'; the aesthetic absolute; mythology, art and language; mythology, language and being&lt;/li&gt;&lt;li&gt;Part 5&#8230;&lt;/li&gt;&lt;/ul&gt;&lt;/Text&gt;</tt>
 * (Table of contents supplied as a list, with XHTML markup)</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;d104 language=&quot;eng&quot;&gt;'The Name of the Rose' is the author's first novel. It is a historical murder mystery set in an Italian monastery in the year 1327, and at the same time, it's an intellectual puzzle weaving semiotics, biblical analysis, medieval studies and literary theory into gripping fiction.&lt;/d104&gt;</tt>
 * &lt;d104 language=&quot;ita&quot;&gt;&#8220;Il nome della rosa&#8221; &#232; il primo romanzo dell'autore. Si tratta
 * di un misterioso omicidio storico ambientato in un monastero italiano nel corso dell'anno 1327, e allo stesso tempo,
 * &#232; un mistero intellettuale che unisce semiotica, analisi biblici, studi medievali e teoria letteraria nella
 * narrativa avvincente.&lt;/d104&gt; (Parallel short description text provided in two languages)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextContent}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link Text}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link Text}</li>
 * </ul>
 */
public class Text implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Text";
    public static final String shortname = "d104";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    public Languages language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of Text. Could be null if {@code exists() == false}. Use {@link #value()} instead if you
     * want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text. XHTML is enabled in this element - see Using XHTML, HTML, XML, JSON within ONIX
     * text fields. Note that certain Text types impose a strict limit on the number of characters, and such limits do
     * not count the characters of any (X)HTML markup
     * <p>
     * (type: XHTML)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final Text EMPTY = new Text();

    public Text() {
        exists = false;
    }

    public Text(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;Text&gt; or &lt;d104&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
