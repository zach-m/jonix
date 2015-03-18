package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 178
 * 
 * @author Zach Melamed
 * 
 */
public enum SupportingResourceFileFormats
{
	/**
	 * MPEG 1/2 Audio Layer III file.
	 */
	MP3("A103"),

	/**
	 * Waveform Audio file.
	 */
	WAV("A104"),

	/**
	 * Proprietary RealNetworks format.
	 */
	Real_Audio("A105"),

	/**
	 * Windows Media Audio format.
	 */
	WMA("A106"),

	/**
	 * Advanced Audio Coding format.
	 */
	AAC("A107"),

	/**
	 * Audio Interchange File format.
	 */
	AIFF("A111"),

	/**
	 * Proprietary RealNetworks format. Includes Real Video packaged within a .rm RealMedia container.
	 */
	Real_Video("D101"),

	/**
	 * Quicktime container format (.mov).
	 */
	Quicktime("D102"),

	/**
	 * Audio Video Interleave format.
	 */
	AVI("D103"),

	/**
	 * Windows Media Video format.
	 */
	WMV("D104"),

	/**
	 * MPEG-4 container format (.mp4, .m4a).
	 */
	MPEG4("D105"),

	/**
	 * Flash Video (.flv, .f4v).
	 */
	FLV("D106"),

	/**
	 * ShockWave (.swf).
	 */
	SWF("D107"),

	/**
	 * 3GPP container format (.3gp, .3g2).
	 */
	_3GP("D108"),

	/**
	 * WebM container format (includes .mkv).
	 */
	WebM("D109"),

	/**
	 * Portable Document File format.
	 */
	PDF("D401"),

	/**
	 * Graphic Interchange File format.
	 */
	GIF("D501"),

	/**
	 * Joint Photographic Experts Group format.
	 */
	JPEG("D502"),

	/**
	 * Portable Network Graphics format.
	 */
	PNG("D503"),

	/**
	 * Tagged Image File format.
	 */
	TIFF("D504"),

	/**
	 * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum (IDPF) [File extension .epub].
	 */
	EPUB("E101"),

	/**
	 * HyperText Mark-up Language [File extension .html, .htm].
	 */
	HTML("E105"),

	/**
	 * Portable Document Format (ISO 32000-1:2008) [File extension .pdf].
	 */
	PDF_("E107"),

	/**
	 * Extensible Hypertext Markup Language [File extension .xhtml, .xht, .xml, .html, .htm].
	 */
	XHTML("E113"),

	/**
	 * XML Paper Specification.
	 */
	XPS("E115"),

	/**
	 * Founder Apabi’s proprietary basic e-book format.
	 */
	CEB("E139"),

	/**
	 * Founder Apabi’s proprietary XML e-book format.
	 */
	CEBX("E140");

	public final String code;

	private SupportingResourceFileFormats(String code)
	{
		this.code = code;
	}

	private static SupportingResourceFileFormats[] values = SupportingResourceFileFormats.values();
	public static SupportingResourceFileFormats fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (SupportingResourceFileFormats item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

