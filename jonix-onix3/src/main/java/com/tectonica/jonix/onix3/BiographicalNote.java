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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextFormats;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Biographical note</h1><p>A biographical note about a contributor to the product. (See the &lt;TextContent&gt;
 * composite in Group&nbsp;P.14 for a biographical note covering all contributors to a product in a single text.)
 * Optional, and repeatable to provide parallel biographical notes in multiple languages. The <i>language</i> attribute
 * is optional for a single instance of &lt;BiographicalNote&gt;, but must be included in each instance if
 * &lt;BiographicalNote&gt; is repeated. May occur with a person name or with a corporate name. A biographical note in
 * ONIX should <em>always</em> contain the name of the person or body concerned, and it should <em>always</em> be
 * presented as a piece of continuous text consisting of full sentences. Some recipients of ONIX data feeds will not
 * accept text which has embedded URLs. A contributor website link can be sent using the &lt;Website&gt; composite
 * below.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable-length text, no suggested maximum length
 * (since there is no suggested length for the text in a &lt;TextContent&gt; composite, where a biographical note can
 * alternatively be sent). XHTML is enabled in this element - see Using XHTML, HTML or XML with ONIX text
 * fields</td></tr><tr><td>Reference name</td><td>&lt;BiographicalNote&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b044&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr><tr><td>Attributes</td><td>language,
 * textformat</td></tr><tr><td>Example</td><td>&lt;b044 language=&quot;eng&quot; textformat=&quot;05&quot;&gt;&lt;p&gt;&lt;strong&gt;Umberto
 * Eco&lt;/strong&gt;, professor of semiotics at the University of Bologna, and author of &lt;em&gt;The Name Of The
 * Rose&lt;/em&gt; and &lt;em&gt;Foucault's Pendulum&lt;/em&gt;, is one of the world's bestselling
 * novelists.&lt;/p&gt;&lt;p&gt;As well as novels, he also writes children's books and academic
 * works.&lt;/p&gt;&lt;/b044&gt; &lt;b044 language=&quot;ita&quot; textformat=&quot;05&quot;&gt;&lt;p&gt;&lt;strong&gt;Umberto
 * Eco&lt;/strong&gt;, professore di semiotica all'Universit&#224; di Bologna e autore di &lt;em&gt;Il nome della
 * rosa&lt;/em&gt; e &lt;em&gt;Il pendolo di Foucault&lt;/em&gt;, &#232; uno dei romanzieri pi&#249; venduto al
 * mondo.&lt;/p&gt;&lt;p&gt;Cos&#236; come romanzi, lui scrive anche libri per bambini e opere
 * accademici.&lt;/p&gt;&lt;/b044&gt; (text is marked up with XHTML, and both English and Italian versions are
 * provided)</td></tr><tr><td></td><td>&lt;b044&gt;Umberto Eco, professor of semiotics at the University of Bologna, and
 * author of 'The Name Of The Rose' and 'Foucault's Pendulum', is one of the world's bestselling novelists. As well as
 * novels, he also writes children's books and academic works.&lt;/b044&gt; (text is not marked
 * up)</td></tr><tr><td>Notes</td><td>Beware of biographical notes including phrases such as 'her latest work
 * is&#8230;', as they are somewhat time-sensitive, and consider the use of the datestamp attribute if such phrases
 * cannot be avoided.</td></tr></table>
 */
public class BiographicalNote implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BiographicalNote";
    public static final String shortname = "b044";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    public LanguageCodes language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable-length text, no suggested maximum length (since there is no suggested length for the text in
     * a &lt;TextContent&gt; composite, where a biographical note can alternatively be sent). XHTML is enabled in this
     * element - see Using XHTML, HTML or XML with ONIX text fields<p> (type: XHTML)
     */
    public String value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final BiographicalNote EMPTY = new BiographicalNote();

    public BiographicalNote() {
        exists = false;
    }

    public BiographicalNote(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
