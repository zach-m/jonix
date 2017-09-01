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
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixMediaFile;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Media file composite</h1><p>An optional and repeatable group of data elements which together identify and provide
 * pointers to an image, audio or video file, used here to indicate that there is a new cover or jacket image for a
 * reissue. <strong>Please see Group&nbsp;PR.16 for details.</strong></p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;MediaFile&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;mediafile&gt;</td></tr></table>
 */
public class MediaFile implements OnixDataCompositeWithKey<JonixMediaFile, ImageAudioVideoFileTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MediaFile";
    public static final String shortname = "mediafile";

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
    public static final MediaFile EMPTY = new MediaFile();

    public MediaFile() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public MediaFile(org.w3c.dom.Element element) {
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
            if (name.equals(MediaFileTypeCode.refname) || name.equals(MediaFileTypeCode.shortname)) {
                mediaFileTypeCode = new MediaFileTypeCode(e);
            } else if (name.equals(MediaFileFormatCode.refname) || name.equals(MediaFileFormatCode.shortname)) {
                mediaFileFormatCode = new MediaFileFormatCode(e);
            } else if (name.equals(ImageResolution.refname) || name.equals(ImageResolution.shortname)) {
                imageResolution = new ImageResolution(e);
            } else if (name.equals(MediaFileLinkTypeCode.refname) || name.equals(MediaFileLinkTypeCode.shortname)) {
                mediaFileLinkTypeCode = new MediaFileLinkTypeCode(e);
            } else if (name.equals(MediaFileLink.refname) || name.equals(MediaFileLink.shortname)) {
                mediaFileLink = new MediaFileLink(e);
            } else if (name.equals(TextWithDownload.refname) || name.equals(TextWithDownload.shortname)) {
                textWithDownload = new TextWithDownload(e);
            } else if (name.equals(DownloadCaption.refname) || name.equals(DownloadCaption.shortname)) {
                downloadCaption = new DownloadCaption(e);
            } else if (name.equals(DownloadCredit.refname) || name.equals(DownloadCredit.shortname)) {
                downloadCredit = new DownloadCredit(e);
            } else if (name.equals(DownloadCopyrightNotice.refname) || name.equals(DownloadCopyrightNotice.shortname)) {
                downloadCopyrightNotice = new DownloadCopyrightNotice(e);
            } else if (name.equals(DownloadTerms.refname) || name.equals(DownloadTerms.shortname)) {
                downloadTerms = new DownloadTerms(e);
            } else if (name.equals(MediaFileDate.refname) || name.equals(MediaFileDate.shortname)) {
                mediaFileDate = new MediaFileDate(e);
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

    private MediaFileTypeCode mediaFileTypeCode = MediaFileTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileTypeCode mediaFileTypeCode() {
        initialize();
        return mediaFileTypeCode;
    }

    private MediaFileFormatCode mediaFileFormatCode = MediaFileFormatCode.EMPTY;

    /**
     * (this field is optional)
     */
    public MediaFileFormatCode mediaFileFormatCode() {
        initialize();
        return mediaFileFormatCode;
    }

    private ImageResolution imageResolution = ImageResolution.EMPTY;

    /**
     * (this field is optional)
     */
    public ImageResolution imageResolution() {
        initialize();
        return imageResolution;
    }

    private MediaFileLinkTypeCode mediaFileLinkTypeCode = MediaFileLinkTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileLinkTypeCode mediaFileLinkTypeCode() {
        initialize();
        return mediaFileLinkTypeCode;
    }

    private MediaFileLink mediaFileLink = MediaFileLink.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileLink mediaFileLink() {
        initialize();
        return mediaFileLink;
    }

    private TextWithDownload textWithDownload = TextWithDownload.EMPTY;

    /**
     * (this field is optional)
     */
    public TextWithDownload textWithDownload() {
        initialize();
        return textWithDownload;
    }

    private DownloadCaption downloadCaption = DownloadCaption.EMPTY;

    /**
     * (this field is required)
     */
    public DownloadCaption downloadCaption() {
        initialize();
        return downloadCaption;
    }

    private DownloadCredit downloadCredit = DownloadCredit.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadCredit downloadCredit() {
        initialize();
        return downloadCredit;
    }

    private DownloadCopyrightNotice downloadCopyrightNotice = DownloadCopyrightNotice.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadCopyrightNotice downloadCopyrightNotice() {
        initialize();
        return downloadCopyrightNotice;
    }

    private DownloadTerms downloadTerms = DownloadTerms.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadTerms downloadTerms() {
        initialize();
        return downloadTerms;
    }

    private MediaFileDate mediaFileDate = MediaFileDate.EMPTY;

    /**
     * (this field is optional)
     */
    public MediaFileDate mediaFileDate() {
        initialize();
        return mediaFileDate;
    }

    @Override
    public JonixMediaFile asStruct() {
        initialize();
        JonixMediaFile struct = new JonixMediaFile();
        struct.mediaFileTypeCode = mediaFileTypeCode.value;
        struct.mediaFileFormatCode = mediaFileFormatCode.value;
        struct.imageResolution = imageResolution.value;
        struct.mediaFileLinkTypeCode = mediaFileLinkTypeCode.value;
        struct.mediaFileLink = mediaFileLink.value;
        struct.textWithDownload = textWithDownload.value;
        struct.downloadCaption = downloadCaption.value;
        struct.downloadCredit = downloadCredit.value;
        struct.downloadCopyrightNotice = downloadCopyrightNotice.value;
        struct.downloadTerms = downloadTerms.value;
        struct.mediaFileDate = mediaFileDate.value;
        return struct;
    }

    @Override
    public ImageAudioVideoFileTypes structKey() {
        return mediaFileTypeCode().value;
    }
}
