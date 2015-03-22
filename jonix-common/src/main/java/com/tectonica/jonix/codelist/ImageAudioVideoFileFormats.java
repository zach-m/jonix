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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList39
 * <p>
 * Image/audio/video file format code
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum ImageAudioVideoFileFormats
{
	GIF("02"), //

	JPEG("03"), //

	PDF("04"), //

	TIF("05"), //

	RealAudio_28_8("06"), //

	/**
	 * MPEG-1/2 Audio Layer III file (.mp3).
	 */
	MP3("07"), //

	/**
	 * MPEG-4 container format (.mp4, .m4a).
	 */
	MPEG_4("08"), //

	/**
	 * Portable Network Graphics bitmapped image format (.png).
	 */
	PNG("09"), //

	/**
	 * Windows Media Audio format (.wma).
	 */
	WMA("10"), //

	/**
	 * Advanced Audio Codec format (.aac).
	 */
	AAC("11"), //

	/**
	 * Waveform audio file (.wav).
	 */
	WAV("12"), //

	/**
	 * Audio Interchange File Format (.aiff).
	 */
	AIFF("13"), //

	/**
	 * Windows Media Video format (.wmv).
	 */
	WMV("14"), //

	/**
	 * Ogg container format (.ogg).
	 */
	OGG("15"), //

	/**
	 * Audio Video Interleaved container format (.avi).
	 */
	AVI("16"), //

	/**
	 * Quicktime container format (.mov).
	 */
	MOV("17"), //

	/**
	 * Flash container format (includes .flv, .swf, .f4v etc).
	 */
	Flash("18"), //

	/**
	 * 3GP container format (.3gp, 3g2).
	 */
	_3GP("19"), //

	/**
	 * WebM container format (includes .webm and .mkv).
	 */
	WebM("20");

	public final String value;

	private ImageAudioVideoFileFormats(String value)
	{
		this.value = value;
	}

	private static Map<String, ImageAudioVideoFileFormats> map;

	private static Map<String, ImageAudioVideoFileFormats> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ImageAudioVideoFileFormats e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ImageAudioVideoFileFormats byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
