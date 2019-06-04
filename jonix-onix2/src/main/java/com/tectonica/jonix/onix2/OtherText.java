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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixOtherText;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Other text composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify and either include, or provide pointers to,
 * text related to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;OtherText&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;othertext&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContentItem&gt;</li>
 * <li>&lt;SubSeriesRecord&gt;</li>
 * <li>&lt;MainSeriesRecord&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ OtherText</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ OtherText</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ OtherText</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ OtherText</li>
 * </ul>
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

    /**
     * @return whether this tag (&lt;OtherText&gt; or &lt;othertext&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TextTypeCode textTypeCode = TextTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of text which is sent in the &lt;Text&gt; element, or referenced in the
     * &lt;TextLink&gt; element. Mandatory in each occurrence of the &lt;OtherText&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextTypeCode textTypeCode() {
        _initialize();
        return textTypeCode;
    }

    private TextFormat textFormat = TextFormat.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the format of text which is sent in the &lt;Text&gt; element, or referenced in the
     * &lt;TextLink&gt; element. Optional and non-repeating. <strong>It is now possible to use a “textformat” attribute
     * in the &lt;Text&gt; element for this purpose, and this is the recommended practise when the text is sent in the
     * ONIX record. The &lt;TextFormat&gt; element may still be used when the text is held outside the ONIX record, and
     * referenced by the &lt;TextLink&gt; element.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextFormat textFormat() {
        _initialize();
        return textFormat;
    }

    private Text text = Text.EMPTY;

    /**
     * <p>
     * The text specified in the &lt;TextTypeCode&gt; element, if it is suitable to be sent in full as part of the ONIX
     * record. Either the &lt;Text&gt; element or both of the &lt;TextLinkType&gt; and &lt;TextLink&gt; elements must be
     * present in any occurrence of the &lt;OtherText&gt; composite. Non-repeating.
     * </p>
     * <p>
     * The &lt;Text&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Text text() {
        _initialize();
        return text;
    }

    private TextLinkType textLinkType = TextLinkType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of link which is given in the &lt;TextLink&gt; element.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextLinkType textLinkType() {
        _initialize();
        return textLinkType;
    }

    private TextLink textLink = TextLink.EMPTY;

    /**
     * <p>
     * A link to the text item specified in the &lt;TextTypeCode&gt; element, using the link type specified in
     * &lt;TextLinkType&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextLink textLink() {
        _initialize();
        return textLink;
    }

    private TextAuthor textAuthor = TextAuthor.EMPTY;

    /**
     * <p>
     * The name of the author of text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element,
     * <em>eg</em> if it is a review or promotional quote.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextAuthor textAuthor() {
        _initialize();
        return textAuthor;
    }

    private TextSourceCorporate textSourceCorporate = TextSourceCorporate.EMPTY;

    /**
     * <p>
     * The name of a company or corporate body responsible for the text sent in the &lt;Text&gt; element, or referenced
     * in the &lt;TextLink&gt; element, <em>eg</em> if it is part of a Reading Group Guide. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextSourceCorporate textSourceCorporate() {
        _initialize();
        return textSourceCorporate;
    }

    private TextSourceTitle textSourceTitle = TextSourceTitle.EMPTY;

    /**
     * <p>
     * The title of a publication from which the text sent in the &lt;Text&gt; element, or referenced in the
     * &lt;TextLink&gt; element, was taken, <em>eg</em> if it is a review quote. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextSourceTitle textSourceTitle() {
        _initialize();
        return textSourceTitle;
    }

    private TextPublicationDate textPublicationDate = TextPublicationDate.EMPTY;

    /**
     * <p>
     * The date on which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, was
     * published. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextPublicationDate textPublicationDate() {
        _initialize();
        return textPublicationDate;
    }

    private StartDate startDate = StartDate.EMPTY;

    /**
     * <p>
     * The date from which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, is
     * intended to be used, <em>eg</em> for date-limited promotions. Optional and non-repeating, but either both or
     * neither of &lt;StartDate&gt; and &lt;EndDate&gt; must be present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public StartDate startDate() {
        _initialize();
        return startDate;
    }

    private EndDate endDate = EndDate.EMPTY;

    /**
     * <p>
     * The date until which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, is
     * intended to be used, <em>eg</em> for date-limited promotions. Optional and non-repeating, but either both or
     * neither of &lt;StartDate&gt; and &lt;EndDate&gt; must be present.
     * </p>
     * Jonix-Comment: this field is optional
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
