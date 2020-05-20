/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileFormats;
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileLinkTypes;
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents Onix2 <code>&lt;MediaFile></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixMediaFile implements JonixKeyedStruct<ImageAudioVideoFileTypes>, Serializable {
    public static final JonixMediaFile EMPTY = new JonixMediaFile();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public ImageAudioVideoFileTypes mediaFileTypeCode;

    public ImageAudioVideoFileFormats mediaFileFormatCode;

    /**
     * Raw Format: Variable-length integer, suggested maximum length 6 digits
     * <p>
     * (type: NonEmptyString)
     */
    public String imageResolution;

    public ImageAudioVideoFileLinkTypes mediaFileLinkTypeCode;

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String mediaFileLink;

    /**
     * Raw Format: Variable-length text, suggested maximum length 1,000 characters (XHTML is enabled in this element -
     * see ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String textWithDownload;

    /**
     * Raw Format: Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element - see
     * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String downloadCaption;

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element - see
     * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String downloadCredit;

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element - see
     * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String downloadCopyrightNotice;

    /**
     * Raw Format: Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element - see
     * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String downloadTerms;

    /**
     * Raw Format: Fixed-length, 8 numeric digits, YYYYMMDD
     * <p>
     * (type: NonEmptyString)
     */
    public String mediaFileDate;

    @Override
    public ImageAudioVideoFileTypes key() {
        return mediaFileTypeCode;
    }
}
