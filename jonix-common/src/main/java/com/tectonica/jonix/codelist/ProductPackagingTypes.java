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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 80</b>
 * <p>
 * Description: Product packaging type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductPackagingTypes
{
	/**
	 * No packaging, or all smaller items enclosed inside largest item.
	 */
	No_outer_packaging("00"), //

	/**
	 * Thin card or soft plastic sleeve, much less rigid than a slip case.
	 */
	Slip_sleeve("01"), //

	/**
	 * Packaging consisting of formed plastic sealed around each side of the product. Not to be confused with
	 * single-sided Blister pack.
	 */
	Clamshell("02"), //

	/**
	 * Typical DVD-style packaging, sometimes known as an &#8216;Amaray&#8217; case.
	 */
	Keep_case("03"), //

	/**
	 * Typical CD-style packaging.
	 */
	Jewel_case("05"), //

	/**
	 * Common CD-style packaging, a card folder with one or more panels incorporating a tray, hub or pocket to hold the
	 * disc(s).
	 */
	Digipak("06"), //

	/**
	 * Individual item, items or set in card box with separate or hinged lid: not to be confused with the commonly-used
	 * &#8216;boxed set&#8217;.
	 */
	In_box("09"), //

	/**
	 * Slip-case for single item only: German &#8216;Schuber&#8217;.
	 */
	Slip_cased("10"), //

	/**
	 * Slip-case for multi-volume set: German &#8216;Kassette&#8217;; also commonly referred to as &#8216;boxed
	 * set&#8217;.
	 */
	Slip_cased_set("11"), //

	/**
	 * Rolled in tube or cylinder: eg sheet map or poster.
	 */
	Tube("12"), //

	/**
	 * Use for miscellaneous items such as slides, microfiche, when presented in a binder.
	 */
	Binder("13"), //

	/**
	 * Use for miscellaneous items such as slides, microfiche, when presented in a wallet or folder.
	 */
	In_wallet_or_folder("14"), //

	/**
	 * Long package with triangular cross-section used for rolled sheet maps, posters etc.
	 */
	Long_triangular_package("15"), //

	/**
	 * Long package with square cross-section used for rolled sheet maps, posters, etc.
	 */
	Long_square_package("16"), //

	Softbox_for_DVD("17"), //

	/**
	 * In pouch, eg teaching materials in a plastic bag or pouch.
	 */
	Pouch("18"), //

	/**
	 * In duroplastic or other rigid plastic case, eg for a class set.
	 */
	Rigid_plastic_case("19"), //

	/**
	 * In cardboard case, eg for a class set.
	 */
	Cardboard_case("20"), //

	/**
	 * Use for products or product bundles supplied for retail sale in shrink-wrapped packaging. For shrink-wrapped
	 * packs of multiple products for trade supply only, see code XL in List 7.
	 */
	Shrink_wrapped("21"), //

	/**
	 * A pack comprising a pre-formed plastic blister and a printed card with a heat-seal coating.
	 */
	Blister_pack("22"), //

	/**
	 * A case with carrying handle, typically for a set of educational books and/or learning materials.
	 */
	Carry_case("23");

	public final String value;

	private ProductPackagingTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductPackagingTypes> map;

	private static Map<String, ProductPackagingTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductPackagingTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductPackagingTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
