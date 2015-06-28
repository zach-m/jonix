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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 98</b>
 * <p>
 * Description: Product form feature value &#8211; binding or page edge color
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductFormFeatureValueBindingOrPageEdgeColors
{
	Black("BLK"), //

	Blue("BLU"), //

	Brown("BRN"), //

	Burgundy_maroon("BUR"), //

	Cream("CRE"), //

	Four_color("FCO"), //

	Four_color_and_spot_color("FCS"), //

	Gold("GLD"), //

	Green("GRN"), //

	Grey("GRY"), //

	/**
	 * Use &lt;ProductFormFeatureDescription&gt; to add brief details if required.
	 */
	Multicolor("MUL"), //

	Navy_Dark_blue("NAV"), //

	Orange("ORG"), //

	Pink("PNK"), //

	Purple("PUR"), //

	Red("RED"), //

	Sky_Pale_blue("SKY"), //

	Silver("SLV"), //

	Tan_Light_brown("TAN"), //

	Teal_Turquoise_green("TEA"), //

	White("WHI"), //

	Yellow("YEL"), //

	Other("ZZZ");

	public final String value;

	private ProductFormFeatureValueBindingOrPageEdgeColors(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductFormFeatureValueBindingOrPageEdgeColors> map;

	private static Map<String, ProductFormFeatureValueBindingOrPageEdgeColors> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductFormFeatureValueBindingOrPageEdgeColors e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductFormFeatureValueBindingOrPageEdgeColors byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
