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
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixOtherText;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Other text composite</h1><p>A repeatable group of data elements which together identify, and either include or
 * provide pointers to, text related to a content item. <strong>Please see Group&nbsp;PR.15 for
 * details.</strong></p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;OtherText&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;othertext&gt;</td></tr></table>
 */
public class OtherText implements OnixDataCompositeWithKey<JonixOtherText, OtherTextTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OtherText";
    public static final String shortname = "othertext";

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
    public static final OtherText EMPTY = new OtherText();

    public OtherText() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public OtherText(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
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
                case TextTypeCode.refname:
                case TextTypeCode.shortname:
                    textTypeCode = new TextTypeCode(e);
                    break;
                case TextFormat.refname:
                case TextFormat.shortname:
                    textFormat = new TextFormat(e);
                    break;
                case Text.refname:
                case Text.shortname:
                    text = new Text(e);
                    break;
                case TextLinkType.refname:
                case TextLinkType.shortname:
                    textLinkType = new TextLinkType(e);
                    break;
                case TextLink.refname:
                case TextLink.shortname:
                    textLink = new TextLink(e);
                    break;
                case TextAuthor.refname:
                case TextAuthor.shortname:
                    textAuthor = new TextAuthor(e);
                    break;
                case TextSourceCorporate.refname:
                case TextSourceCorporate.shortname:
                    textSourceCorporate = new TextSourceCorporate(e);
                    break;
                case TextSourceTitle.refname:
                case TextSourceTitle.shortname:
                    textSourceTitle = new TextSourceTitle(e);
                    break;
                case TextPublicationDate.refname:
                case TextPublicationDate.shortname:
                    textPublicationDate = new TextPublicationDate(e);
                    break;
                case StartDate.refname:
                case StartDate.shortname:
                    startDate = new StartDate(e);
                    break;
                case EndDate.refname:
                case EndDate.shortname:
                    endDate = new EndDate(e);
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

    private TextTypeCode textTypeCode = TextTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public TextTypeCode textTypeCode() {
        _initialize();
        return textTypeCode;
    }

    private TextFormat textFormat = TextFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public TextFormat textFormat() {
        _initialize();
        return textFormat;
    }

    private Text text = Text.EMPTY;

    /**
     * (this field is optional)
     */
    public Text text() {
        _initialize();
        return text;
    }

    private TextLinkType textLinkType = TextLinkType.EMPTY;

    /**
     * (this field is required)
     */
    public TextLinkType textLinkType() {
        _initialize();
        return textLinkType;
    }

    private TextLink textLink = TextLink.EMPTY;

    /**
     * (this field is required)
     */
    public TextLink textLink() {
        _initialize();
        return textLink;
    }

    private TextAuthor textAuthor = TextAuthor.EMPTY;

    /**
     * (this field is optional)
     */
    public TextAuthor textAuthor() {
        _initialize();
        return textAuthor;
    }

    private TextSourceCorporate textSourceCorporate = TextSourceCorporate.EMPTY;

    /**
     * (this field is optional)
     */
    public TextSourceCorporate textSourceCorporate() {
        _initialize();
        return textSourceCorporate;
    }

    private TextSourceTitle textSourceTitle = TextSourceTitle.EMPTY;

    /**
     * (this field is optional)
     */
    public TextSourceTitle textSourceTitle() {
        _initialize();
        return textSourceTitle;
    }

    private TextPublicationDate textPublicationDate = TextPublicationDate.EMPTY;

    /**
     * (this field is optional)
     */
    public TextPublicationDate textPublicationDate() {
        _initialize();
        return textPublicationDate;
    }

    private StartDate startDate = StartDate.EMPTY;

    /**
     * (this field is optional)
     */
    public StartDate startDate() {
        _initialize();
        return startDate;
    }

    private EndDate endDate = EndDate.EMPTY;

    /**
     * (this field is optional)
     */
    public EndDate endDate() {
        _initialize();
        return endDate;
    }

    @Override
    public JonixOtherText asStruct() {
        _initialize();
        JonixOtherText struct = new JonixOtherText();
        struct.textTypeCode = textTypeCode.value;
        struct.textFormat = textFormat.value;
        struct.text = text.value;
        struct.textLinkType = textLinkType.value;
        struct.textLink = textLink.value;
        struct.textAuthor = textAuthor.value;
        struct.textSourceCorporate = textSourceCorporate.value;
        struct.textSourceTitle = textSourceTitle.value;
        struct.textPublicationDate = textPublicationDate.value;
        struct.startDate = startDate.value;
        struct.endDate = endDate.value;
        return struct;
    }

    @Override
    public OtherTextTypes structKey() {
        return textTypeCode().value;
    }
}
