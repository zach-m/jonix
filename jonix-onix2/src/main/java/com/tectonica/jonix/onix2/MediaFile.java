/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixMediaFile;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Image/audio/video file link composite</h1>
 * <p>
 * A repeatable group of data elements which together identify and provide pointers to, an image, audio or video file
 * related to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MediaFile&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;mediafile&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link Reissue}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link MediaFile}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link MediaFile}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link MediaFile}</li>
 * </ul>
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
                case MediaFileTypeCode.refname:
                case MediaFileTypeCode.shortname:
                    mediaFileTypeCode = new MediaFileTypeCode(e);
                    break;
                case MediaFileLinkTypeCode.refname:
                case MediaFileLinkTypeCode.shortname:
                    mediaFileLinkTypeCode = new MediaFileLinkTypeCode(e);
                    break;
                case MediaFileLink.refname:
                case MediaFileLink.shortname:
                    mediaFileLink = new MediaFileLink(e);
                    break;
                case DownloadCaption.refname:
                case DownloadCaption.shortname:
                    downloadCaption = new DownloadCaption(e);
                    break;
                case MediaFileFormatCode.refname:
                case MediaFileFormatCode.shortname:
                    mediaFileFormatCode = new MediaFileFormatCode(e);
                    break;
                case ImageResolution.refname:
                case ImageResolution.shortname:
                    imageResolution = new ImageResolution(e);
                    break;
                case TextWithDownload.refname:
                case TextWithDownload.shortname:
                    textWithDownload = new TextWithDownload(e);
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

    /**
     * @return whether this tag (&lt;MediaFile&gt; or &lt;mediafile&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MediaFile> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MediaFileTypeCode mediaFileTypeCode = MediaFileTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of image/audio/video file which is linked by the &lt;MediaFileLink&gt;
     * element. Mandatory in each occurrence of the &lt;MediaFile&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public MediaFileTypeCode mediaFileTypeCode() {
        _initialize();
        return mediaFileTypeCode;
    }

    private MediaFileLinkTypeCode mediaFileLinkTypeCode = MediaFileLinkTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of link which is given in the &lt;MediaFileLink&gt; element, for example a
     * URL, DOI, filename <em>etc</em>. Mandatory in each occurrence of the &lt;MediaFile&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public MediaFileLinkTypeCode mediaFileLinkTypeCode() {
        _initialize();
        return mediaFileLinkTypeCode;
    }

    private MediaFileLink mediaFileLink = MediaFileLink.EMPTY;

    /**
     * <p>
     * A link to the image/audio/video file specified by the &lt;MediaFileTypeCode&gt;, using the link type specified by
     * the &lt;MediaFileLinkTypeCode&gt;. Mandatory in each occurrence of the &lt;MediaFile&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public MediaFileLink mediaFileLink() {
        _initialize();
        return mediaFileLink;
    }

    private DownloadCaption downloadCaption = DownloadCaption.EMPTY;

    /**
     * <p>
     * Text of a caption associated with a download file, and intended to be displayed whenever the file content is
     * used. Optional and non-repeating. The &lt;DownloadCaption&gt; element may be sent together with either or both of
     * fields &lt;DownloadCredit&gt;, or &lt;DownloadCopyrightNotice&gt;.
     * </p>
     * JONIX adds: this field is required
     */
    public DownloadCaption downloadCaption() {
        _initialize();
        return downloadCaption;
    }

    private MediaFileFormatCode mediaFileFormatCode = MediaFileFormatCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the format of the image/audio/video file which is linked by the
     * &lt;MediaFileLink&gt; element. For image files, JPEG, GIF and TIF are supported. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MediaFileFormatCode mediaFileFormatCode() {
        _initialize();
        return mediaFileFormatCode;
    }

    private ImageResolution imageResolution = ImageResolution.EMPTY;

    /**
     * <p>
     * The resolution of an image file which is linked by the &lt;MediaFileLink&gt; element, expressed as dots or pixels
     * per inch. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ImageResolution imageResolution() {
        _initialize();
        return imageResolution;
    }

    private TextWithDownload textWithDownload = TextWithDownload.EMPTY;

    /**
     * <p>
     * Unstructured text associated with a file which is available for download, and intended to be displayed whenever
     * the file content is used. Optional and non-repeating. Text may include credits, copyright notice, <em>etc</em>.
     * If this field is sent, the individual elements &lt;DownloadCaption&gt;, &lt;DownloadCredit&gt;, and
     * &lt;DownloadCopyrightNotice&gt; must not be sent, and vice versa.
     * </p>
     * JONIX adds: this field is optional
     */
    public TextWithDownload textWithDownload() {
        _initialize();
        return textWithDownload;
    }

    private DownloadCredit downloadCredit = DownloadCredit.EMPTY;

    /**
     * <p>
     * Text of a personal or corporate credit associated with a download file, and intended to be displayed whenever the
     * file content is used. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public DownloadCredit downloadCredit() {
        _initialize();
        return downloadCredit;
    }

    private DownloadCopyrightNotice downloadCopyrightNotice = DownloadCopyrightNotice.EMPTY;

    /**
     * <p>
     * Text of a copyright notice associated with a download file, and intended to be displayed whenever the file
     * content is used. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public DownloadCopyrightNotice downloadCopyrightNotice() {
        _initialize();
        return downloadCopyrightNotice;
    }

    private DownloadTerms downloadTerms = DownloadTerms.EMPTY;

    /**
     * <p>
     * Text of any terms and conditions associated with a download file. Optional and non-repeating. This field may be
     * sent alone, or with the &lt;TextWithDownload&gt; element, or with any combination of the &lt;DownloadCaption&gt;,
     * &lt;DownloadCredit&gt;, and &lt;DownloadCopyrightNotice&gt; elements.
     * </p>
     * JONIX adds: this field is optional
     */
    public DownloadTerms downloadTerms() {
        _initialize();
        return downloadTerms;
    }

    private MediaFileDate mediaFileDate = MediaFileDate.EMPTY;

    /**
     * <p>
     * The date when the image referenced by the &lt;MediaFileLink&gt; element was last changed. Optional and
     * non-repeating. This element is intended to allow the receiver of an updated ONIX record to determine whether it
     * is necessary to download a new copy of the file.
     * </p>
     * JONIX adds: this field is optional
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
