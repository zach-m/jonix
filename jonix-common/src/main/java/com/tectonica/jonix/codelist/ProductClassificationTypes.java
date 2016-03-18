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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 9</b>
 * <p>
 * Description: Product classification type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist9">ONIX
 *      Codelist 9 in Reference Guide</a>
 */
public enum ProductClassificationTypes implements OnixCodelist
{
	/**
	 * World Customs Organization Harmonized Commodity Coding and Description System
	 */
	WCO_Harmonized_System("01", "WCO Harmonized System"), //

	/**
	 * UN Standard Product and Service Classification
	 */
	UNSPSC("02", "UNSPSC"), //

	/**
	 * UK Revenue and Customs classifications, based on the Harmonized System
	 */
	HMRC("03", "HMRC"), //

	/**
	 * German export trade classification, based on the Harmonised System
	 */
	Warenverzeichnis_f_r_die_Au_enhandelsstatistik("04", "Warenverzeichnis für die Außenhandelsstatistik"), //

	/**
	 * EU TARIC codes, an extended version of the Harmonized System
	 */
	TARIC("05", "TARIC"), //

	/**
	 * Centraal Boekhuis free classification field for publishers
	 */
	Fondsgroep("06", "Fondsgroep"), //

	/**
	 * A product category (not a subject classification) assigned by the sender
	 */
	Sender_s_product_category("07", "Sender’s product category"), //

	/**
	 * Product classification maintained by the Chinese General Administration of Press and Publication
	 * (http://www.gapp.gov.cn)
	 */
	GAPP_Product_Class("08", "GAPP Product Class"), //

	/**
	 * Statistical Classification of Products by Activity in the European Economic Community, see
	 * http://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_NOM_DTL&amp;StrNom=CPA_2008. Up to six
	 * digits, with one or two periods. For example, printed children's books are '58.11.13', but the periods are
	 * normally ommited in ONIX
	 */
	CPA("09", "CPA"), //

	/**
	 * Mercosur/Mercosul Common Nomenclature, based on the Harmonised System
	 */
	NCM("10", "NCM"), //

	/**
	 * Typologie de march&#233; g&#233;r&#233; par Electre (Market segment code maintained by Electre)
	 */
	Electre_genre("50", "Electre genre");

	public final String code;
	public final String description;

	private ProductClassificationTypes(String code, String description)
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

	private static volatile Map<String, ProductClassificationTypes> map;

	private static Map<String, ProductClassificationTypes> map()
	{
		Map<String, ProductClassificationTypes> result = map;
		if (result == null)
		{
			synchronized (ProductClassificationTypes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (ProductClassificationTypes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static ProductClassificationTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
