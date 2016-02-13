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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 99</b>
 * <p>
 * Description: Product form feature value &#8211; special cover material
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductFormFeatureValueSpecialCoverMaterials
{
	/**
	 * Pigskin
	 */
	Berkshire_leather("01"), //

	Calfskin("02"), //

	/**
	 * Calf split or sheep split
	 */
	French_Morocco("03"), //

	/**
	 * Goatskin
	 */
	Morocco("04"), //

	Bonded_buffalo_grain("05"), //

	Bonded_calf_grain("06"), //

	Bonded_Cordova("07"), //

	Bonded_eelskin("08"), //

	Bonded_Ostraleg("09"), //

	Bonded_ostrich("10"), //

	Bonded_reptile_grain("11"), //

	Bonded_leather("12"), //

	Cowhide("13"), //

	Eelskin("14"), //

	Kivar("15"), //

	/**
	 * An imitation leather binding material
	 */
	Leatherflex("16"), //

	Moleskin("17"), //

	Softhide_leather("18"), //

	Metal("19"), //

	/**
	 * German &#8216;Samt&#8217;
	 */
	Velvet("20"), //

	/**
	 * Spanish &#8216;n&#225;car&#8217;
	 */
	Mother_of_pearl("21"), //

	Papyrus("22"), //

	/**
	 * An imitation cloth binding material
	 */
	G_ltex("23"), //

	/**
	 * An imitation leather binding material
	 */
	Guaflex("24"), //

	/**
	 * An imitation made of any non-leather material &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Imitation_leather("25"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Pigskin("26"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Goatskin("27");

	public final String value;

	private ProductFormFeatureValueSpecialCoverMaterials(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductFormFeatureValueSpecialCoverMaterials> map;

	private static Map<String, ProductFormFeatureValueSpecialCoverMaterials> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductFormFeatureValueSpecialCoverMaterials e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductFormFeatureValueSpecialCoverMaterials byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
