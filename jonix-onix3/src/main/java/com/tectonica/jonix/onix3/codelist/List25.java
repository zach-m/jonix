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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Illustration and other content type code
 */
public enum List25
{
	/**
	 * See description in the <IllustrationTypeDescription> element.
	 */
	Unspecified__see_description("00"), //

	Illustrations__black_and_white("01"), //

	Illustrations__color("02"), //

	/**
	 * Including black and white photographs.
	 */
	Halftones__black_and_white("03"), //

	/**
	 * Including color photographs.
	 */
	Halftones__color("04"), //

	Line_drawings__black_and_white("05"), //

	Line_drawings__color("06"), //

	Tables__black_and_white("07"), //

	Tables__color("08"), //

	Illustrations__unspecified("09"), //

	/**
	 * Including photographs.
	 */
	Halftones__unspecified("10"), //

	Tables__unspecified("11"), //

	Line_drawings__unspecified("12"), //

	Halftones__duotone("13"), //

	Maps("14"), //

	Frontispiece("15"), //

	Diagrams("16"), //

	Figures("17"), //

	Charts("18"), //

	/**
	 * Recorded music extracts or examples, or complete recorded work(s), accompanying textual or other content.
	 */
	Recorded_music_items("19"), //

	/**
	 * Printed music extracts or examples, or complete music score(s), accompanying textual or other content.
	 */
	Printed_music_items("20"), //

	/**
	 * To be used in the mathematical sense of a diagram that represents numerical values plotted against an origin and axes, cf codes 16
	 * and 18.
	 */
	Graphs("21"), //

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__unspecified("22"), //

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__black_and_white("23"), //

	/**
	 * ‘Plates’ means illustrations that are on separate pages bound into the body of a book.
	 */
	Plates__color("24"), //

	Index("25"), //

	Bibliography("26"), //

	/**
	 * Larger-scale inset maps of places or features of interest included in a map product.
	 */
	Inset_maps("27"), //

	/**
	 * GPS grids included in a map product.
	 */
	GPS_grids("28"), //

	Glossary("29");

	public final String value;

	private List25(String value)
	{
		this.value = value;
	}

	private static Map<String, List25> map;

	private static Map<String, List25> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List25 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List25 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
