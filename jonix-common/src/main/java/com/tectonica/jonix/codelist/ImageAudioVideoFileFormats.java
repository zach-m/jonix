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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 39 (Image/audio/video file format code)
 */
interface CodeList39 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 39</b>
 * <p>
 * Description: Image/audio/video file format code
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist39">ONIX
 * Codelist 39 in Reference Guide</a>
 */
public enum ImageAudioVideoFileFormats implements OnixCodelist, CodeList39 {
    GIF("02", "GIF"), //

    JPEG("03", "JPEG"), //

    PDF("04", "PDF"), //

    TIF("05", "TIF"), //

    RealAudio_28_8("06", "RealAudio 28.8"), //

    /**
     * MPEG-1/2 Audio Layer III file (.mp3)
     */
    MP3("07", "MP3"), //

    /**
     * MPEG-4 container format (.mp4, .m4a)
     */
    MPEG_4("08", "MPEG-4"), //

    /**
     * Portable Network Graphics bitmapped image format (.png)
     */
    PNG("09", "PNG"), //

    /**
     * Windows Media Audio format (.wma)
     */
    WMA("10", "WMA"), //

    /**
     * Advanced Audio Codec format (.aac)
     */
    AAC("11", "AAC"), //

    /**
     * Waveform audio file (.wav)
     */
    WAV("12", "WAV"), //

    /**
     * Audio Interchange File Format (.aiff)
     */
    AIFF("13", "AIFF"), //

    /**
     * Windows Media Video format (.wmv)
     */
    WMV("14", "WMV"), //

    /**
     * Ogg container format (.ogg)
     */
    OGG("15", "OGG"), //

    /**
     * Audio Video Interleaved container format (.avi)
     */
    AVI("16", "AVI"), //

    /**
     * Quicktime container format (.mov)
     */
    MOV("17", "MOV"), //

    /**
     * Flash container format (includes .flv, .swf, .f4v etc)
     */
    Flash("18", "Flash"), //

    /**
     * 3GP container format (.3gp, 3g2)
     */
    _3GP("19", "3GP"), //

    /**
     * WebM container format (includes .webm and .mkv)
     */
    WebM("20", "WebM");

    public final String code;
    public final String description;

    private ImageAudioVideoFileFormats(String code, String description) {
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

    private static volatile Map<String, ImageAudioVideoFileFormats> map;

    private static Map<String, ImageAudioVideoFileFormats> map() {
        Map<String, ImageAudioVideoFileFormats> result = map;
        if (result == null) {
            synchronized (ImageAudioVideoFileFormats.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ImageAudioVideoFileFormats e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ImageAudioVideoFileFormats byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
