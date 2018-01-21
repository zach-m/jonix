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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.FrontCoverImageFileFormats;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Front cover image file format code</h1><p>An ONIX code which specifies the image file format used for the front
 * cover image. JPEG, GIF and TIF are supported. The data element group consisting of &lt;CoverImageFormatCode&gt;,
 * &lt;CoverImageLinkTypeCode&gt;, and &lt;CoverImageLink&gt; is optional and non-repeating, but if any one of the three
 * elements is present, all three must be present.</p><p><strong>The &lt;MediaFile&gt; composite on the next page
 * provides a more general method of handling cover images, and is to be preferred.</strong></p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two numeric digits</td></tr><tr><td>Codelist</td><td>List
 * 36</td></tr><tr><td>Reference name</td><td>&lt;CoverImageFormatCode&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;f111&gt;</td></tr><tr><td>Example</td><td>&lt;CoverImageFormatCode&gt;03&lt;/CoverImageFormatCode&gt;&#160;&#160;&#160;&#160;JPEG</td></tr></table>
 */
public class CoverImageFormatCode implements OnixElement<FrontCoverImageFileFormats>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CoverImageFormatCode";
    public static final String shortname = "f111";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public FrontCoverImageFileFormats value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public FrontCoverImageFileFormats _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CoverImageFormatCode EMPTY = new CoverImageFormatCode();

    public CoverImageFormatCode() {
        exists = false;
    }

    public CoverImageFormatCode(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = FrontCoverImageFileFormats.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
