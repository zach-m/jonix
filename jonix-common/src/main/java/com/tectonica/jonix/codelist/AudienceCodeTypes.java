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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 29</b>
 * <p>
 * Description: Audience code type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum AudienceCodeTypes
{
	/**
	 * Using a code from List 28.
	 */
	ONIX_audience_codes("01"), //

	Proprietary("02"), //

	/**
	 * Motion Picture Association of America rating applied to movies.
	 */
	MPAA_rating("03"), //

	/**
	 * British Board of Film Classification rating applied to movies.
	 */
	BBFC_rating("04"), //

	/**
	 * German FSK (Freiwillige Selbstkontrolle der Filmwirtschaft) rating applied to movies.
	 */
	FSK_rating("05"), //

	/**
	 * French Canadian audience code list, used by BTLF for Memento.
	 */
	BTLF_audience_code("06"), //

	/**
	 * Audience code used by Electre (France).
	 */
	Electre_audience_code("07"), //

	/**
	 * Spain: educational audience and material type code of the Asociaci&#243;n Nacional de Editores de Libros y
	 * Material de Ense&#241;anza.
	 */
	ANELE_Tipo("08"), //

	/**
	 * Code list used to specify reading levels for children&#8217;s books, used in Flanders, and formerly in the
	 * Netherlands &#8211; see also code 18.
	 */
	AVI("09"), //

	/**
	 * German USK (Unterhaltungssoftware Selbstkontrolle) rating applied to video or computer games.
	 */
	USK_rating("10"), //

	/**
	 * Audience code used in Flanders.
	 */
	AWS("11"), //

	/**
	 * Type of school: codelist maintained by VdS Bildungsmedien eV, the German association of educational media
	 * publishers.
	 */
	Schulform("12"), //

	/**
	 * School region: codelist maintained by VdS Bildungsmedien eV, the German association of educational media
	 * publishers, indicating where products are licensed to be used in schools.
	 */
	Bundesland("13"), //

	/**
	 * Occupation: codelist for vocational training materials, maintained by VdS Bildungsmedien eV, the German
	 * association of educational media publishers.
	 */
	Ausbildungsberuf("14"), //

	/**
	 * Finnish school or college level.
	 */
	Suomalainen_kouluasteluokitus("15"), //

	/**
	 * UK Publishers Association, Children&#8217;s Book Group, coded indication of intended reader age, carried on book
	 * covers.
	 */
	CBG_age_guidance("16"), //

	/**
	 * Audience code used in Nielsen Book Services.
	 */
	Nielsen_Book_audience_code("17"), //

	/**
	 * Code list used to specify reading levels for children&#8217;s books, used in the Netherlands &#8211; see also
	 * code 09.
	 */
	AVI_revised("18"), //

	/**
	 * Lexile measure (the Lexile measure in &lt;AudienceCodeValue&gt; may optionally be prefixed by the Lexile code).
	 * Examples might be &#8216;880L&#8217;, &#8216;AD0L&#8217; or &#8216;HL600L&#8217;. Deprecated &#8211; use
	 * &lt;Complexity&gt; instead.
	 */
	Lexile_measure("19"), //

	/**
	 * Fry readability metric based on number of sentences and syllables per 100 words. Expressed as a number from 1 to
	 * 15 in &lt;AudienceCodeValue&gt;. Deprecated &#8211; use &lt;Complexity&gt; instead.
	 */
	Fry_Readability_score("20"), //

	/**
	 * Children&#8217;s audience code (&#23550;&#35937;&#35501;&#32773;), two-digit encoding of intended target
	 * readership from 0&#8211;2 years up to High School level.
	 */
	Japanese_Children_s_audience_code("21"), //

	/**
	 * Publisher&#8217;s rating indicating suitability for an particular adult audience, using a code from List 203.
	 */
	ONIX_Adult_audience_rating("22"), //

	/**
	 * Codes A1 to C2 indicating standardised level of language learning or teaching material, from beginner to
	 * advanced, used in EU.
	 */
	Common_European_Framework_for_Language_Learning("23"), //

	/**
	 * Rating used in Korea to control selling of books and e-books to minors. Current values are 0 (suitable for all)
	 * and 19 (only for sale to ages 19+). See &#8216;http://www.kpec.or.kr/english/&#8217;.
	 */
	Korean_Publication_Ethics_Commission_rating("24"), //

	/**
	 * UK Institute of Education Book Bands for Guided Reading scheme (see http://www.ioe.ac.uk/research/4664.html).
	 * &lt;AudienceCodeValue&gt; is a colour, eg &#8216;Pink A&#8217; or &#8216;Copper&#8217;. Deprecated &#8211; use
	 * &lt;Complexity&gt; instead.
	 */
	IoE_Book_Band("25"), //

	/**
	 * Used for German videos/DVDs with educational or informative content; value for &lt;AudienceCodeValue&gt; must be
	 * either &#8216;Infoprogramm gem&#228;&#223; &#167; 14 JuSchG&#8217; or &#8216;Lehrprogramm gem&#228;&#223; &#167;
	 * 14 JuSchG&#8217;.
	 */
	FSK_Lehr_Infoprogramm("26"), //

	/**
	 * Where this is different from the language of the text of the book recorded in &lt;Language&gt;.
	 * &lt;AudienceCodeValue&gt; should be a value from List 74.
	 */
	Intended_audience_language("27"), //

	/**
	 * Pan European Game Information rating used primarily for video games.
	 */
	PEGI_rating("28"), //

	/**
	 * Code indicating the intended curriculum (eg Naturvetenskapsprogrammet, Estetica programmet) in Swedish higher
	 * secondary education. &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Gymnasieprogram("29");

	public final String value;

	private AudienceCodeTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, AudienceCodeTypes> map;

	private static Map<String, AudienceCodeTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (AudienceCodeTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static AudienceCodeTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
