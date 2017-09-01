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
import com.tectonica.jonix.codelist.LanguageCodes;
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
 * <h1>Title composite</h1><p>A repeatable group of data elements which together give the text of a title of a content
 * item and specify its type, used here to give alternate forms of title for a content item. <strong>Please see
 * Group&nbsp;PR.7 for details.</strong></p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Title&gt;</td></tr><tr><td>Short tag</td><td>&lt;title&gt;</td></tr></table>
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

    public LanguageCodes language;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TitleType titleType = TitleType.EMPTY;

    /**
     * (this field is required)
     */
    public TitleType titleType() {
        initialize();
        return titleType;
    }

    private AbbreviatedLength abbreviatedLength = AbbreviatedLength.EMPTY;

    /**
     * (this field is optional)
     */
    public AbbreviatedLength abbreviatedLength() {
        initialize();
        return abbreviatedLength;
    }

    private TextCaseFlag textCaseFlag = TextCaseFlag.EMPTY;

    /**
     * (this field is optional)
     */
    public TextCaseFlag textCaseFlag() {
        initialize();
        return textCaseFlag;
    }

    private TitleText titleText = TitleText.EMPTY;

    /**
     * (this field is required)
     */
    public TitleText titleText() {
        initialize();
        return titleText;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlePrefix titlePrefix() {
        initialize();
        return titlePrefix;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        initialize();
        return titleWithoutPrefix;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * (this field is optional)
     */
    public Subtitle subtitle() {
        initialize();
        return subtitle;
    }

    @Override
    public JonixTitle asStruct() {
        initialize();
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
