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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 30</b>
 * <p>
 * Description: Audience range qualifier
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist30">ONIX
 *      Codelist 30 in Reference Guide</a>
 */
public enum AudienceRangeQualifiers
{
	/**
	 * Values for &lt;AudienceRangeValue&gt; are specified in List 77
	 */
	US_school_grade_range("11", "US school grade range"), //

	/**
	 * Values are defined by BIC for England and Wales, Scotland and N Ireland
	 */
	UK_school_grade("12", "UK school grade"), //

	/**
	 * Values in &lt;AudienceRangeValue&gt; must be integers
	 */
	Reading_speed_words_per_minute("15", "Reading speed, words per minute"), //

	/**
	 * For use up to 36 months only: values in &lt;AudienceRangeValue&gt; must be integers
	 */
	Interest_age_months("16", "Interest age, months"), //

	/**
	 * Values in &lt;AudienceRangeValue&gt; must be integers
	 */
	Interest_age_years("17", "Interest age, years"), //

	/**
	 * Values in &lt;AudienceRangeValue&gt; must be integers
	 */
	Reading_age_years("18", "Reading age, years"), //

	/**
	 * Spain: combined grade and region code, maintained by the Ministerio de Educaci&#243;n
	 */
	Spanish_school_grade("19", "Spanish school grade"), //

	/**
	 * Norwegian educational level for primary and secondary education
	 */
	Skoletrinn("20", "Skoletrinn"), //

	/**
	 * Swedish educational qualifier (code)
	 */
	Niv_("21", "Nivå"), //

	Italian_school_grade("22", "Italian school grade"), //

	/**
	 * DEPRECATED &#8211; assigned in error: see List 29
	 */
	Schulform("23", "Schulform"), //

	/**
	 * DEPRECATED &#8211; assigned in error: see List 29
	 */
	Bundesland("24", "Bundesland"), //

	/**
	 * DEPRECATED &#8211; assigned in error: see List 29
	 */
	Ausbildungsberuf("25", "Ausbildungsberuf"), //

	/**
	 * Values for &lt;AudienceRangeValue&gt; are specified in List 77
	 */
	Canadian_school_grade_range("26", "Canadian school grade range"), //

	Finnish_school_grade_range("27", "Finnish school grade range"), //

	/**
	 * Lukion kurssi
	 */
	Finnish_Upper_secondary_school_course("28", "Finnish Upper secondary school course"), //

	/**
	 * Values are P, K, 1&#8211;17 (including college-level audiences), see List 227
	 */
	Chinese_School_Grade_range("29", "Chinese School Grade range"), //

	/**
	 * French educational level classification scolomfr-voc-022, used for example on WizWiz.fr. See
	 * http://www.lom-fr.fr/scolomfr/vocabulaires/consultation-des-vocabulaires.html
	 */
	Nomenclature_niveaux("30", "Nomenclature niveaux");

	public final String value;
	public final String label;

	private AudienceRangeQualifiers(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, AudienceRangeQualifiers> map;

	private static Map<String, AudienceRangeQualifiers> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (AudienceRangeQualifiers e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static AudienceRangeQualifiers byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
