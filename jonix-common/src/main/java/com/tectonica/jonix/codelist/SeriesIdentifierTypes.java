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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 13</b>
 * <p>
 * Description: Series identifier type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist13">ONIX
 *      Codelist 13 in Reference Guide</a>
 */
public enum SeriesIdentifierTypes implements OnixCodelist
{
	/**
	 * For example, publisher's own series ID
	 */
	Proprietary("01", "Proprietary"), //

	/**
	 * International Standard Serial Number, unhyphenated, 8 digits
	 */
	ISSN("02", "ISSN"), //

	/**
	 * Maintained by the Deutsche Nationalbibliothek
	 */
	German_National_Bibliography_series_ID("03", "German National Bibliography series ID"), //

	/**
	 * Maintained by VLB
	 */
	German_Books_in_Print_series_ID("04", "German Books in Print series ID"), //

	/**
	 * Maintained by Electre Information, France
	 */
	Electre_series_ID("05", "Electre series ID"), //

	/**
	 * Digital Object Identifier (variable length and character set)
	 */
	DOI("06", "DOI"), //

	/**
	 * Use only where the collection (series or set) is available as a single product
	 */
	ISBN_13("15", "ISBN-13"), //

	/**
	 * Uniform Resource Name
	 */
	URN("22", "URN"), //

	/**
	 * French National Bibliography series ID, maintained by the Biblioth&#232;que Nationale de France
	 */
	Identifiant_BNF_des_publications_en_s_rie("29", "Identifiant BNF des publications en série");

	public final String code;
	public final String description;

	private SeriesIdentifierTypes(String code, String description)
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

	private static volatile Map<String, SeriesIdentifierTypes> map;

	private static Map<String, SeriesIdentifierTypes> map()
	{
		Map<String, SeriesIdentifierTypes> result = map;
		if (result == null)
		{
			synchronized (SeriesIdentifierTypes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (SeriesIdentifierTypes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static SeriesIdentifierTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
