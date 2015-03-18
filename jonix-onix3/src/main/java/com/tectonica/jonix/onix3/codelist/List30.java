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
 * Audience range qualifier
 */
public enum List30
{
	/**
	 * Values for <AudienceRangeValue> are specified in List 77.
	 */
	US_school_grade_range("11"), //

	/**
	 * Values are defined by BIC for England and Wales, Scotland and N Ireland.
	 */
	UK_school_grade("12"), //

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Reading_speed__words_per_minute("15"), //

	/**
	 * For use up to 36 months only: values in <AudienceRangeValue> must be integers.
	 */
	Interest_age__months("16"), //

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Interest_age__years("17"), //

	/**
	 * Values in <AudienceRangeValue> must be integers.
	 */
	Reading_age__years("18"), //

	/**
	 * Spain: combined grade and region code, maintained by the Ministerio de Educación.
	 */
	Spanish_school_grade("19"), //

	/**
	 * Norwegian educational level for primary and secondary education
	 */
	Skoletrinn("20"), //

	/**
	 * Swedish educational qualifier (code).
	 */
	Niv_("21"), //

	Italian_school_grade("22"), //

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Schulform("23"), //

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Bundesland("24"), //

	/**
	 * DEPRECATED – assigned in error: see List 29.
	 */
	Ausbildungsberuf("25"), //

	/**
	 * Values for <AudienceRangeValue> are specified in List 77.
	 */
	Canadian_school_grade_range("26"), //

	Finnish_school_grade_range("27"), //

	/**
	 * Lukion kurssi.
	 */
	Finnish_Upper_secondary_school_course("28"), //

	/**
	 * Values are P, K, 1–17 (including college-level audiences).
	 */
	Chinese_School_Grade_code("29"), //

	/**
	 * French educational level classification, used for example on WizWiz.fr. See
	 * http://www.kiosque-edu.com/html/onix/Nomenclature_niveaux.csv’.
	 */
	Nomenclature_niveaux("30");

	public final String value;

	private List30(String value)
	{
		this.value = value;
	}

	private static Map<String, List30> map;

	private static Map<String, List30> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List30 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List30 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
