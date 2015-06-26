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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * Enum that corresponds to ONIX's <b>CodeList176</b>
 * <p>
 * Product form feature value – operating system
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">http://www.editeur.org/14/code-lists</a>
 */
public enum ProductFormFeatureValueOperatingSystems
{
	/**
	 * An Open Source mobile device operating system originally developed by Google and supported by the Open Handset
	 * Alliance.
	 */
	Android("01"), //

	/**
	 * A proprietary operating system supplied by Research In Motion for its BlackBerry handheld devices.
	 */
	BlackBerry_OS("02"), //

	/**
	 * A proprietary operating system based on Mac OS X supplied by Apple for its iPhone, iPad and iPod Touch handheld
	 * devices.
	 */
	iOS("03"), //

	/**
	 * An operating system based on the Linux kernel.
	 */
	Linux("04"), //

	/**
	 * [A proprietary operating system supplied by Apple on Macintosh computers up to 2002] DEPRECATED – use code 13 for
	 * all Mac OS versions.
	 */
	Mac_OS("05"), //

	/**
	 * [A proprietary operating system supplied by Apple on Macintosh computers from 2001/2002] DEPRECATED – use code 13
	 * for all Mac OS versions.
	 */
	Mac_OS_X("06"), //

	/**
	 * A proprietary operating system (AKA Garnet OS) originally developed for handheld devices.
	 */
	Palm_OS("07"), //

	/**
	 * A proprietry Linux-based operating system for handheld devices, originally developed by Palm (now owned by LG).
	 */
	webOS("08"), //

	/**
	 * An operating system for hand-held devices, originally developed as a proprietary system, but planned to become
	 * wholly Open Source by 2010.
	 */
	Symbian("09"), //

	/**
	 * A proprietary operating system supplied by Microsoft.
	 */
	Windows("10"), //

	/**
	 * A proprietary operating system (AKA Windows Embedded Compact, WinCE) supplied by Microsoft for small-scale
	 * devices.
	 */
	Windows_CE("11"), //

	/**
	 * A proprietary operating system supplied by Microsoft for mobile devices.
	 */
	Windows_Mobile("12"), //

	/**
	 * A proprietary operating system supplied by Apple on Macintosh computers.
	 */
	Mac_OS_("13"), //

	/**
	 * A proprietary operating system supplied by Microsoft for mobile devices, successor to Windows Mobile.
	 */
	Windows_Phone_7("14");

	public final String value;

	private ProductFormFeatureValueOperatingSystems(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductFormFeatureValueOperatingSystems> map;

	private static Map<String, ProductFormFeatureValueOperatingSystems> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductFormFeatureValueOperatingSystems e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductFormFeatureValueOperatingSystems byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
