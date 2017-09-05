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
                case MediaFileTypeCode.refname:
                case MediaFileTypeCode.shortname:
                    mediaFileTypeCode = new MediaFileTypeCode(e);
                    break;
                case MediaFileFormatCode.refname:
                case MediaFileFormatCode.shortname:
                    mediaFileFormatCode = new MediaFileFormatCode(e);
                    break;
                case ImageResolution.refname:
                case ImageResolution.shortname:
                    imageResolution = new ImageResolution(e);
                    break;
                case MediaFileLinkTypeCode.refname:
                case MediaFileLinkTypeCode.shortname:
                    mediaFileLinkTypeCode = new MediaFileLinkTypeCode(e);
                    break;
                case MediaFileLink.refname:
                case MediaFileLink.shortname:
                    mediaFileLink = new MediaFileLink(e);
                    break;
                case TextWithDownload.refname:
                case TextWithDownload.shortname:
                    textWithDownload = new TextWithDownload(e);
                    break;
                case DownloadCaption.refname:
                case DownloadCaption.shortname:
                    downloadCaption = new DownloadCaption(e);
                    break;
                case DownloadCredit.refname:
                case DownloadCredit.shortname:
                    downloadCredit = new DownloadCredit(e);
                    break;
                case DownloadCopyrightNotice.refname:
                case DownloadCopyrightNotice.shortname:
                    downloadCopyrightNotice = new DownloadCopyrightNotice(e);
                    break;
                case DownloadTerms.refname:
                case DownloadTerms.shortname:
                    downloadTerms = new DownloadTerms(e);
                    break;
                case MediaFileDate.refname:
                case MediaFileDate.shortname:
                    mediaFileDate = new MediaFileDate(e);
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

    private MediaFileTypeCode mediaFileTypeCode = MediaFileTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileTypeCode mediaFileTypeCode() {
        _initialize();
        return mediaFileTypeCode;
    }

    private MediaFileFormatCode mediaFileFormatCode = MediaFileFormatCode.EMPTY;

    /**
     * (this field is optional)
     */
    public MediaFileFormatCode mediaFileFormatCode() {
        _initialize();
        return mediaFileFormatCode;
    }

    private ImageResolution imageResolution = ImageResolution.EMPTY;

    /**
     * (this field is optional)
     */
    public ImageResolution imageResolution() {
        _initialize();
        return imageResolution;
    }

    private MediaFileLinkTypeCode mediaFileLinkTypeCode = MediaFileLinkTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileLinkTypeCode mediaFileLinkTypeCode() {
        _initialize();
        return mediaFileLinkTypeCode;
    }

    private MediaFileLink mediaFileLink = MediaFileLink.EMPTY;

    /**
     * (this field is required)
     */
    public MediaFileLink mediaFileLink() {
        _initialize();
        return mediaFileLink;
    }

    private TextWithDownload textWithDownload = TextWithDownload.EMPTY;

    /**
     * (this field is optional)
     */
    public TextWithDownload textWithDownload() {
        _initialize();
        return textWithDownload;
    }

    private DownloadCaption downloadCaption = DownloadCaption.EMPTY;

    /**
     * (this field is required)
     */
    public DownloadCaption downloadCaption() {
        _initialize();
        return downloadCaption;
    }

    private DownloadCredit downloadCredit = DownloadCredit.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadCredit downloadCredit() {
        _initialize();
        return downloadCredit;
    }

    private DownloadCopyrightNotice downloadCopyrightNotice = DownloadCopyrightNotice.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadCopyrightNotice downloadCopyrightNotice() {
        _initialize();
        return downloadCopyrightNotice;
    }

    private DownloadTerms downloadTerms = DownloadTerms.EMPTY;

    /**
     * (this field is optional)
     */
    public DownloadTerms downloadTerms() {
        _initialize();
        return downloadTerms;
    }

    private MediaFileDate mediaFileDate = MediaFileDate.EMPTY;

    /**
     * (this field is optional)
     */
    public MediaFileDate mediaFileDate() {
        _initialize();
        return mediaFileDate;
    }

    @Override
    public JonixMediaFile asStruct() {
        _initialize();
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
