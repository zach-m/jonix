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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixKeyedStruct;
import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TextLinkTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents Onix2 <code>&lt;OtherText></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixOtherText implements JonixKeyedStruct<OtherTextTypes>, Serializable {
    public static final JonixOtherText EMPTY = new JonixOtherText();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public OtherTextTypes textTypeCode;

    public TextFormats textFormat;

    /**
     * Raw Format: Variable length text (XHTML is enabled in this element - see ONIX for Books - Product Information
     * Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String text;

    public TextLinkTypes textLinkType;

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String textLink;

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String textAuthor;

    /**
     * Raw Format: Variable-length text, suggested maximum length 200 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String textSourceCorporate;

    /**
     * Raw Format: Variable-length text, suggested maximum length 100 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String textSourceTitle;

    /**
     * Raw Format: Date as four, six or eight digits (YYYY, YYYYMM, YYYYMMDD)
     * <p>
     * (type: NonEmptyString)
     */
    public String textPublicationDate;

    /**
     * Raw Format: Fixed-length, 8 numeric digits, YYYYMMDD
     * <p>
     * (type: NonEmptyString)
     */
    public String startDate;

    /**
     * Raw Format: Fixed-length, 8 numeric digits, YYYYMMDD
     * <p>
     * (type: NonEmptyString)
     */
    public String endDate;

    @Override
    public OtherTextTypes key() {
        return textTypeCode;
    }
}
