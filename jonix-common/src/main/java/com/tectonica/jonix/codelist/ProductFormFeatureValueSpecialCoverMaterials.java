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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 99</b>
 * <p>
 * Description: Product form feature value - special cover material
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist99">ONIX
 *      Codelist 99 in Reference Guide</a>
 */
public enum ProductFormFeatureValueSpecialCoverMaterials implements OnixCodelist
{
	/**
	 * Pigskin
	 */
	Berkshire_leather("01", "Berkshire leather"), //

	Calfskin("02", "Calfskin"), //

	/**
	 * Calf split or sheep split
	 */
	French_Morocco("03", "French Morocco"), //

	/**
	 * Goatskin
	 */
	Morocco("04", "Morocco"), //

	Bonded_buffalo_grain("05", "Bonded buffalo grain"), //

	Bonded_calf_grain("06", "Bonded calf grain"), //

	Bonded_Cordova("07", "Bonded Cordova"), //

	Bonded_eelskin("08", "Bonded eelskin"), //

	Bonded_Ostraleg("09", "Bonded Ostraleg"), //

	Bonded_ostrich("10", "Bonded ostrich"), //

	Bonded_reptile_grain("11", "Bonded reptile grain"), //

	Bonded_leather("12", "Bonded leather"), //

	Cowhide("13", "Cowhide"), //

	Eelskin("14", "Eelskin"), //

	Kivar("15", "Kivar"), //

	/**
	 * An imitation leather binding material
	 */
	Leatherflex("16", "Leatherflex"), //

	Moleskin("17", "Moleskin"), //

	Softhide_leather("18", "Softhide leather"), //

	Metal("19", "Metal"), //

	/**
	 * German 'Samt'
	 */
	Velvet("20", "Velvet"), //

	/**
	 * Spanish 'n&#225;car'
	 */
	Mother_of_pearl("21", "Mother-of-pearl"), //

	Papyrus("22", "Papyrus"), //

	/**
	 * An imitation cloth binding material
	 */
	G_ltex("23", "Géltex"), //

	/**
	 * An imitation leather binding material
	 */
	Guaflex("24", "Guaflex"), //

	/**
	 * An imitation made of any non-leather material &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Imitation_leather("25", "Imitation leather"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Pigskin("26", "Pigskin"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Goatskin("27", "Goatskin");

	public final String code;
	public final String description;

	private ProductFormFeatureValueSpecialCoverMaterials(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static volatile Map<String, ProductFormFeatureValueSpecialCoverMaterials> map;

	private static Map<String, ProductFormFeatureValueSpecialCoverMaterials> map()
	{
		Map<String, ProductFormFeatureValueSpecialCoverMaterials> result = map;
		if (result == null)
		{
			synchronized (ProductFormFeatureValueSpecialCoverMaterials.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (ProductFormFeatureValueSpecialCoverMaterials e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static ProductFormFeatureValueSpecialCoverMaterials byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
