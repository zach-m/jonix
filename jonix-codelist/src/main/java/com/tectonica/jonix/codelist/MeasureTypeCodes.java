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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Measure type code
 */
public enum MeasureTypeCodes
{
	/**
	 * For a book, the spine height when standing on a shelf. For a folded map, the height when folded. In general, the height of a product
	 * in the form in which it is presented or packaged for retail sale.
	 */
	Height("01"), //

	/**
	 * For a book, the horizontal dimension of the cover when standing upright. For a folded map, the width when folded. In general, the
	 * width of a product in the form in which it is presented or packaged for retail sale.
	 */
	Width("02"), //

	/**
	 * For a book, the thickness of the spine. For a folded map, the thickness when folded. In general, the thickness or depth of a product
	 * in the form in which it is presented or packaged for retail sale.
	 */
	Thickness("03"), //

	/**
	 * Not recommended for general use.
	 */
	Page_trim_height("04"), //

	/**
	 * Not recommended for general use.
	 */
	Page_trim_width("05"), //

	Unit_weight("08"), //

	/**
	 * Of a globe, for example.
	 */
	Diameter_sphere("09"), //

	/**
	 * The height of a folded or rolled sheet map, poster etc when unfolded.
	 */
	Unfolded_unrolled_sheet_height("10"), //

	/**
	 * The width of a folded or rolled sheet map, poster etc when unfolded.
	 */
	Unfolded_unrolled_sheet_width("11"), //

	/**
	 * The diameter of the cross-section of a tube or cylinder, usually carrying a rolled sheet product. Use 01 “height” for the height or
	 * length of the tube.
	 */
	Diameter_tube_or_cylinder("12"), //

	/**
	 * The length of a side of the cross-section of a long triangular or square package, usually carrying a rolled sheet product. Use 01
	 * “height” for the height or length of the package.
	 */
	Rolled_sheet_package_side_measure("13");

	public final String value;

	private MeasureTypeCodes(String value)
	{
		this.value = value;
	}

	private static Map<String, MeasureTypeCodes> map;

	private static Map<String, MeasureTypeCodes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (MeasureTypeCodes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static MeasureTypeCodes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
