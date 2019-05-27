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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixTitle;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title composite</h1>
 * <p>
 * A repeatable group of data elements which together give the text of a title, including a subtitle where applicable,
 * and specify its type. <strong>Please see Group&nbsp;PR.7 for details.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Title&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;title&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContentItem&gt;</li>
 * <li>&lt;Set&gt;</li>
 * <li>&lt;SubSeriesRecord&gt;</li>
 * <li>&lt;MainSeriesRecord&gt;</li>
 * <li>&lt;Series&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Title</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Title</li>
 * <li>ONIXMessage ⯈ Product ⯈ Set ⯈ Title</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Title</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Title</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Title</li>
 * </ul>
 */
public class Title implements OnixDataCompositeWithKey<JonixTitle, TitleTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Title";
    public static final String shortname = "title";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Title EMPTY = new Title();

    public Title() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Title(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case TitleType.refname:
                case TitleType.shortname:
                    titleType = new TitleType(e);
                    break;
                case AbbreviatedLength.refname:
                case AbbreviatedLength.shortname:
                    abbreviatedLength = new AbbreviatedLength(e);
                    break;
                case TextCaseFlag.refname:
                case TextCaseFlag.shortname:
                    textCaseFlag = new TextCaseFlag(e);
                    break;
                case TitleText.refname:
                case TitleText.shortname:
                    titleText = new TitleText(e);
                    break;
                case TitlePrefix.refname:
                case TitlePrefix.shortname:
                    titlePrefix = new TitlePrefix(e);
                    break;
                case TitleWithoutPrefix.refname:
                case TitleWithoutPrefix.shortname:
                    titleWithoutPrefix = new TitleWithoutPrefix(e);
                    break;
                case Subtitle.refname:
                case Subtitle.shortname:
                    subtitle = new Subtitle(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Title&gt; or &lt;title&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TitleType titleType = TitleType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of a title. Mandatory in each occurrence of the &lt;Title&gt; composite, and
     * non-repeating. Additional types of title can now be defined by adding code values without requiring a new ONIX
     * release.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleType titleType() {
        _initialize();
        return titleType;
    }

    private AbbreviatedLength abbreviatedLength = AbbreviatedLength.EMPTY;

    /**
     * <p>
     * If the &lt;Title&gt; composite is used to carry an abbreviated title, the length to which the title is
     * abbreviated may be indicated by giving the maximum number of characters (regardless of whether in each specific
     * instance abbreviation has been required in order to meet this limit). The &lt;TitleType&gt; code should indicate
     * the form of the title that has been abbreviated. Optional and non-repeating. If this element is present, the
     * &lt;TitleText&gt; element must be used to carry the abbreviated form. [The option also exists to send an
     * abbreviated title as a separate &lt;TitleType&gt; without using &lt;AbbreviatedLength&gt;, which is simpler, but
     * less informative.]
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AbbreviatedLength abbreviatedLength() {
        _initialize();
        return abbreviatedLength;
    }

    private TextCaseFlag textCaseFlag = TextCaseFlag.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the case in which the text elements in an occurrence of the &lt;Title&gt; composite are
     * sent. The default is “unspecified”. Optional and non-repeating. <strong>Text case can now be indicated by an XML
     * attribute on any text element, and this method is preferred. See <cite>ONIX for Books – Product Information
     * Message – XML Message Specification</cite>, Section 4.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextCaseFlag textCaseFlag() {
        _initialize();
        return textCaseFlag;
    }

    private TitleText titleText = TitleText.EMPTY;

    /**
     * <p>
     * The text of the title specified by the &lt;TitleType&gt; code; and excluding the subtitle, if any. Optional and
     * non-repeating: see text at the head of the &lt;Title&gt; composite for details of valid title text options. The
     * &lt;TitleText&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleText titleText() {
        _initialize();
        return titleText;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * <p>
     * Text at the beginning of a title which is to be ignored for alphabetical sorting. Optional and non-repeating; can
     * only be used if the &lt;TitleWithoutPrefix&gt; element is also present. These two elements may be used in
     * combination in applications where it is necessary to distinguish an initial word or character string which is to
     * be ignored for filing purposes, <em>eg</em> in library systems and in some bookshop databases. The
     * &lt;TitlePrefix&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlePrefix titlePrefix() {
        _initialize();
        return titlePrefix;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * <p>
     * Full text of a title, without abbreviation or abridgement, and without the title prefix; and excluding the
     * subtitle, if any. Optional and non-repeating; can only be used if the &lt;TitlePrefix&gt; element is also
     * present. The &lt;TitleWithoutPrefix&gt; element may carry any of the following ONIX attributes: <i>textformat,
     * language, transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        _initialize();
        return titleWithoutPrefix;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * <p>
     * The full text of a subtitle, if any. “Subtitle” means any added words which appear with the title given in an
     * occurrence of the &lt;Title&gt; composite, and which amplify and explain the title, but which are not considered
     * to be part of the title itself. Optional and non-repeating. The &lt;Subtitle&gt; element may carry any of the
     * following ONIX attributes: <i>textformat, language, transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Subtitle subtitle() {
        _initialize();
        return subtitle;
    }

    @Override
    public JonixTitle asStruct() {
        _initialize();
        JonixTitle struct = new JonixTitle();
        struct.titleType = titleType.value;
        struct.abbreviatedLength = abbreviatedLength.value;
        struct.textCaseFlag = textCaseFlag.value;
        struct.titleText = titleText.value;
        struct.titlePrefix = titlePrefix.value;
        struct.titleWithoutPrefix = titleWithoutPrefix.value;
        struct.subtitle = subtitle.value;
        return struct;
    }

    @Override
    public TitleTypes structKey() {
        return titleType().value;
    }
}
