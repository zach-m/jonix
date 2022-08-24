/*
 * Copyright (C) 2012-2022 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 178 (Supporting resource file format)
 */
interface CodeList178 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 178</b>
 * <p>
 * Description: Supporting resource file format
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist178">ONIX
 *      Codelist 178 in Reference Guide</a>
 */
public enum SupportingResourceFileFormats implements OnixCodelist, CodeList178 {
    /**
     * MPEG 1/2 Audio Layer III file
     */
    MP3("A103", "MP3"),

    /**
     * Waveform Audio file
     */
    WAV("A104", "WAV"),

    /**
     * Proprietary RealNetworks format
     */
    Real_Audio("A105", "Real Audio"),

    /**
     * Windows Media Audio format
     */
    WMA("A106", "WMA"),

    /**
     * Advanced Audio Coding format
     */
    AAC("A107", "AAC"),

    /**
     * Vorbis audio format in the Ogg container
     */
    Ogg_Vorbis("A108", "Ogg/Vorbis"),

    /**
     * Audio Interchange File format
     */
    AIFF("A111", "AIFF"),

    /**
     * Proprietary RealNetworks format. Includes Real Video packaged within a .rm RealMedia container
     */
    Real_Video("D101", "Real Video"),

    /**
     * Quicktime container format (.mov)
     */
    Quicktime("D102", "Quicktime"),

    /**
     * Audio Video Interleave format
     */
    AVI("D103", "AVI"),

    /**
     * Windows Media Video format
     */
    WMV("D104", "WMV"),

    /**
     * MPEG-4 container format (.mp4, .m4a)
     */
    MPEG_4("D105", "MPEG-4"),

    /**
     * Flash Video (.flv, .f4v)
     */
    FLV("D106", "FLV"),

    /**
     * ShockWave (.swf)
     */
    SWF("D107", "SWF"),

    /**
     * 3GPP container format (.3gp, .3g2)
     */
    _3GP("D108", "3GP"),

    /**
     * WebM container format (includes .mkv)
     */
    WebM("D109", "WebM"),

    /**
     * Portable Document File (single page image)
     */
    PDF("D401", "PDF"),

    /**
     * Graphic Interchange File format
     */
    GIF("D501", "GIF"),

    /**
     * Joint Photographic Experts Group format
     */
    JPEG("D502", "JPEG"),

    /**
     * Portable Network Graphics format
     */
    PNG("D503", "PNG"),

    /**
     * Tagged Image File format
     */
    TIFF("D504", "TIFF"),

    /**
     * Windows Bitmap format
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    BMP("D505", "BMP"),

    /**
     * JPEG 2000, improved Joint Photographic Experts Group format
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    JP2("D506", "JP2"),

    /**
     * Adobe Photoshop native file format, PSD or PSB
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    PSD("D507", "PSD"),

    /**
     * Image as Postscript or Encapsulated Postscript file (.ps or .eps)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    EPS("D508", "EPS"),

    /**
     * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum
     * (IDPF) [File extension .epub]
     */
    EPUB("E101", "EPUB"),

    /**
     * HyperText Mark-up Language [File extension .html, .htm]
     */
    HTML("E105", "HTML"),

    /**
     * Portable Document Format (ISO 32000-1:2008) [File extension .pdf]
     */
    PDF_("E107", "PDF"),

    /**
     * Plain text (either ASCII or UTF-8/16 Unicode)
     */
    TXT("E112", "TXT"),

    /**
     * Extensible Hypertext Markup Language [File extension .xhtml, .xht, .xml, .html, .htm]
     */
    XHTML("E113", "XHTML"),

    /**
     * XML Paper Specification
     */
    XPS("E115", "XPS"),

    /**
     * A format proprietary to Amazon for use with its Kindle reading devices or software readers [File extensions .azw,
     * .mobi, .prc]
     */
    Amazon_Kindle("E116", "Amazon Kindle"),

    /**
     * Founder Apabi's proprietary basic e-book format
     */
    CEB("E139", "CEB"),

    /**
     * Founder Apabi's proprietary XML e-book format
     */
    CEBX("E140", "CEBX");

    public final String code;
    public final String description;

    SupportingResourceFileFormats(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, SupportingResourceFileFormats> map;

    private static Map<String, SupportingResourceFileFormats> map() {
        Map<String, SupportingResourceFileFormats> result = map;
        if (result == null) {
            synchronized (SupportingResourceFileFormats.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SupportingResourceFileFormats e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SupportingResourceFileFormats byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
