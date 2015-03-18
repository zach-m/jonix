package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 39
 * 
 * @author Zach Melamed
 * 
 */
public enum ImageAudioVideoFileFormats
{
	GIF("02"),

	JPEG("03"),

	PDF("04"),

	TIF("05"),

	RealAudio_28_8("06"),

	/**
	 * MPEG-1/2 Audio Layer III file (.mp3).
	 */
	MP3("07"),

	/**
	 * MPEG-4 container format (.mp4, .m4a).
	 */
	MPEG4("08"),

	/**
	 * Portable Network Graphics bitmapped image format (.png).
	 */
	PNG("09"),

	/**
	 * Windows Media Audio format (.wma).
	 */
	WMA("10"),

	/**
	 * Advanced Audio Codec format (.aac).
	 */
	AAC("11"),

	/**
	 * Waveform audio file (.wav).
	 */
	WAV("12"),

	/**
	 * Audio Interchange File Format (.aiff).
	 */
	AIFF("13"),

	/**
	 * Windows Media Video format (.wmv).
	 */
	WMV("14"),

	/**
	 * Ogg container format (.ogg).
	 */
	OGG("15"),

	/**
	 * Audio Video Interleaved container format (.avi).
	 */
	AVI("16"),

	/**
	 * Quicktime container format (.mov).
	 */
	MOV("17"),

	/**
	 * Flash container format (includes .flv, .swf, .f4v etc).
	 */
	Flash("18"),

	/**
	 * 3GP container format (.3gp, 3g2).
	 */
	_3GP("19"),

	/**
	 * WebM container format (includes .webm and .mkv).
	 */
	WebM("20");

	public final String code;

	private ImageAudioVideoFileFormats(String code)
	{
		this.code = code;
	}

	private static ImageAudioVideoFileFormats[] values = ImageAudioVideoFileFormats.values();
	public static ImageAudioVideoFileFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ImageAudioVideoFileFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

