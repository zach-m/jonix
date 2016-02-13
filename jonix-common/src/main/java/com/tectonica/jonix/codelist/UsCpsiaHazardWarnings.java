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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 143</b>
 * <p>
 * Description: US CPSIA hazard warning code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist143">ONIX
 *      Codelist 143 in Reference Guide</a>
 */
public enum UsCpsiaHazardWarnings
{
	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_Small_parts_Not_for_children_under_3_yrs_("01",
			"WARNING: CHOKING HAZARD – Small parts | Not for children under 3 yrs."), //

	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_Children_under_8_yrs_can_choke_or_suffocate_on_uninflated_or_broken_balloons_Adult_supervision_required_Keep_uninflated_balloons_from_children_Discard_broken_balloons_at_once_(
			"02",
			"WARNING: CHOKING HAZARD – Children under 8 yrs. can choke or suffocate on uninflated or broken balloons. Adult supervision required | Keep uninflated balloons from children. Discard broken balloons at once."), //

	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_This_toy_is_a_small_ball_Not_for_children_under_3_yrs_("03",
			"WARNING: CHOKING HAZARD – This toy is a small ball | Not for children under 3 yrs."), //

	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_Toy_contains_a_small_ball_Not_for_children_under_3_yrs_("04",
			"WARNING: CHOKING HAZARD – Toy contains a small ball | Not for children under 3 yrs."), //

	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_This_toy_is_a_marble_Not_for_children_under_3_yrs_("05",
			"WARNING: CHOKING HAZARD – This toy is a marble | Not for children under 3 yrs."), //

	/**
	 * Required on applicable products sold in the US
	 */
	WARNING_CHOKING_HAZARD_Toy_contains_a_marble_Not_for_children_under_3_yrs_("06",
			"WARNING: CHOKING HAZARD – Toy contains a marble | Not for children under 3 yrs."), //

	/**
	 * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
	 */
	No_choking_hazard_warning_necessary("07", "No choking hazard warning necessary"), //

	/**
	 * Required on applicable products sold in the US. Should be accompanied by additional text: Swallowed magnets can
	 * stick together across intestines causing serious infections and death. Seek immediate medical attention if
	 * magnet(s) are swallowed or inhaled &lt;p&gt;NOTE: Introduced in Onix3
	 */
	WARNING_MAGNET_HAZARD_Product_contains_a("11", "WARNING: MAGNET HAZARD – Product contains (a) small magnet(s)");

	public final String value;
	public final String label;

	private UsCpsiaHazardWarnings(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, UsCpsiaHazardWarnings> map;

	private static Map<String, UsCpsiaHazardWarnings> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (UsCpsiaHazardWarnings e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static UsCpsiaHazardWarnings byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
