package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 176
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductFormFeatureValueOperatingSystems
{
	/**
	 * An Open Source mobile device operating system originally developed by Google and supported by the Open Handset Alliance.
	 */
	Android("01"),

	/**
	 * A proprietary operating system supplied by Research In Motion for its BlackBerry handheld devices.
	 */
	BlackBerry_OS("02"),

	/**
	 * A proprietary operating system based on Mac OS X supplied by Apple for its iPhone, iPad and iPod Touch handheld devices.
	 */
	iOS("03"),

	/**
	 * An operating system based on the Linux kernel.
	 */
	Linux("04"),

	/**
	 * [A proprietary operating system supplied by Apple on Macintosh computers up to 2002] DEPRECATED – use code 13 for all Mac OS versions.
	 */
	Mac_OS("05"),

	/**
	 * [A proprietary operating system supplied by Apple on Macintosh computers from 2001/2002] DEPRECATED – use code 13 for all Mac OS versions.
	 */
	Mac_OS_X("06"),

	/**
	 * A proprietary operating system (AKA Garnet OS) originally developed for handheld devices.
	 */
	Palm_OS("07"),

	/**
	 * A proprietry Linux-based operating system for handheld devices, originally developed by Palm (now owned by HP).
	 */
	webOS("08"),

	/**
	 * An operating system for hand-held devices, originally developed as a proprietary system, but planned to become wholly Open Source by 2010.
	 */
	Symbian("09"),

	/**
	 * A proprietary operating system supplied by Microsoft.
	 */
	Windows("10"),

	/**
	 * A proprietary operating system (AKA Windows Embedded Compact, WinCE) supplied by Microsoft for small-scale devices.
	 */
	Windows_CE("11"),

	/**
	 * A proprietary operating system supplied by Microsoft for mobile devices.
	 */
	Windows_Mobile("12"),

	/**
	 * A proprietary operating system supplied by Apple on Macintosh computers.
	 */
	Mac_OS_("13"),

	/**
	 * A proprietary operating system supplied by Microsoft for mobile devices, successor to Windows Mobile.
	 */
	Windows_Phone_7("14");

	public final String code;

	private ProductFormFeatureValueOperatingSystems(String code)
	{
		this.code = code;
	}

	private static ProductFormFeatureValueOperatingSystems[] values = ProductFormFeatureValueOperatingSystems.values();
	public static ProductFormFeatureValueOperatingSystems fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductFormFeatureValueOperatingSystems item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

