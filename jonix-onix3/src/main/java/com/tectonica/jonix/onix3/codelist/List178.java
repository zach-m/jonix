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

package com.tectonica.jonix.onix3.codelist;

import java.util.HashMap;
import java.util.Map;

/**
 * Supporting resource file format
 */
public enum List178
{
	/**
	 * MPEG 1/2 Audio Layer III file.
	 */
	MP3("A103"), //

	/**
	 * Waveform Audio file.
	 */
	WAV("A104"), //

	/**
	 * Proprietary RealNetworks format.
	 */
	Real_Audio("A105"), //

	/**
	 * Windows Media Audio format.
	 */
	WMA("A106"), //

	/**
	 * Advanced Audio Coding format.
	 */
	AAC("A107"), //

	/**
	 * Audio Interchange File format.
	 */
	AIFF("A111"), //

	/**
	 * Proprietary RealNetworks format. Includes Real Video packaged within a .rm RealMedia container.
	 */
	Real_Video("D101"), //

	/**
	 * Quicktime container format (.mov).
	 */
	Quicktime("D102"), //

	/**
	 * Audio Video Interleave format.
	 */
	AVI("D103"), //

	/**
	 * Windows Media Video format.
	 */
	WMV("D104"), //

	/**
	 * MPEG-4 container format (.mp4, .m4a).
	 */
	MPEG_4("D105"), //

	/**
	 * Flash Video (.flv, .f4v).
	 */
	FLV("D106"), //

	/**
	 * ShockWave (.swf).
	 */
	SWF("D107"), //

	/**
	 * 3GPP container format (.3gp, .3g2).
	 */
	_3GP("D108"), //

	/**
	 * WebM container format (includes .mkv).
	 */
	WebM("D109"), //

	/**
	 * Portable Document File format.
	 */
	PDF("D401"), //

	/**
	 * Graphic Interchange File format.
	 */
	GIF("D501"), //

	/**
	 * Joint Photographic Experts Group format.
	 */
	JPEG("D502"), //

	/**
	 * Portable Network Graphics format.
	 */
	PNG("D503"), //

	/**
	 * Tagged Image File format.
	 */
	TIFF("D504"), //

	/**
	 * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum (IDPF) [File extension
	 * .epub].
	 */
	EPUB("E101"), //

	/**
	 * HyperText Mark-up Language [File extension .html, .htm].
	 */
	HTML("E105"), //

	/**
	 * Portable Document Format (ISO 32000-1:2008) [File extension .pdf].
	 */
	PDF_("E107"), //

	/**
	 * Extensible Hypertext Markup Language [File extension .xhtml, .xht, .xml, .html, .htm].
	 */
	XHTML("E113"), //

	/**
	 * XML Paper Specification.
	 */
	XPS("E115"), //

	/**
	 * A format proprietary to Amazon for use with its Kindle reading devices or software readers [File extensions .azw, .mobi, .prc].
	 */
	Amazon_Kindle("E116"), //

	/**
	 * Founder Apabi’s proprietary basic e-book format.
	 */
	CEB("E139"), //

	/**
	 * Founder Apabi’s proprietary XML e-book format.
	 */
	CEBX("E140");

	public final String value;

	private List178(String value)
	{
		this.value = value;
	}

	private static Map<String, List178> map;

	private static Map<String, List178> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List178 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List178 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
