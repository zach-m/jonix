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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Name code type
 */
public enum NameCodeTypes
{
	Proprietary("01"), //

	/**
	 * DEPRECATED – use 01.
	 */
	Proprietary_("02"), //

	/**
	 * Deutsche Nationalbibliothek publisher identifier.
	 */
	DNB_publisher_identifier("03"), //

	B_rsenverein_Verkehrsnummer("04"), //

	German_ISBN_Agency_publisher_identifier("05"), //

	/**
	 * GS1 global location number (formerly EAN location number).
	 */
	GLN("06"), //

	/**
	 * Book trade Standard Address Number – US, UK etc.
	 */
	SAN("07"), //

	/**
	 * MARC code list for organizations – see ‘http://www.loc.gov/marc/organizations/orgshome.html’
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	MARC_organization_code("08"), //

	/**
	 * Trading party identifier used in the Netherlands.
	 */
	Centraal_Boekhuis_Relatie_ID("10"), //

	/**
	 * Flemish publisher code.
	 */
	Fondscode_Boekenbank("13"), //

	/**
	 * Business Identity Code (Finland). See http://www.ytj.fi/ (in Finnish).
	 */
	Y_tunnus("15"), //

	/**
	 * International Standard Name Identifier. See ‘http://www.isni.org/’.
	 */
	ISNI("16"), //

	/**
	 * Personennamendatei – person name authority file used by Deutsche Nationalbibliothek and in other German-speaking countries. See
	 * http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm
	 * (English). DEPRECATED in favour of the GND.
	 */
	PND("17"), //

	/**
	 * A control number assigned to a Library of Congress Name Authority record.
	 */
	LCCN("18"), //

	/**
	 * Publisher identifier administered by Japanese ISBN Agency.
	 */
	Japanese_Publisher_identifier("19"), //

	/**
	 * Gemeinsame Körperschaftsdatei – Corporate Body Authority File in the German-speaking countries. See
	 * http://www.d-nb.de/standardisierung/normdateien/gkd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/gkd.htm
	 * (English). DEPRECATED in favour of the GND.
	 */
	GKD("20"), //

	/**
	 * Open Researcher and Contributor ID. See ‘http://www.orcid.org/’.
	 */
	ORCID("21"), //

	/**
	 * Publisher identifier maintained by the Chinese ISBN Agency (GAPP).
	 */
	GAPP_Publisher_Identifier("22"), //

	/**
	 * Identifier for a business organization for VAT purposes, eg within the EU’s VIES system. See
	 * http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country. Generally these
	 * consist of a two-letter country code followed by the 8–12 digits of the national VAT ID. Some countries include one or two letters
	 * within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number for non-EU countries that maintain similar
	 * identifiers. Spaces, dashes etc should be omitted.
	 */
	VAT_Identity_Number("23"), //

	/**
	 * 4-digit business organization identifier controlled by the Japanese Publication Wholesalers Association.
	 */
	JP_Distribution_Identifier("24"), //

	/**
	 * Gemeinsame Normdatei – Joint Authority File in the German-speaking countries. See
	 * http://www.dnb.de/EN/Standardisierung/Normdaten/GND/gnd_node.html (English). Combines the PND, SWD and GKD into a single authority
	 * file, and should be used in preference.
	 */
	GND("25"), //

	/**
	 * Dunn and Bradstreet Universal Numbering System, see ‘www.dnb.co.uk/dandb-duns-number’.
	 */
	DUNS("26"), //

	/**
	 * Ringgold organizational identifier, see ‘http://www.ringgold.com/pages/identify.html’.
	 */
	Ringgold_ID("27"), //

	/**
	 * French Electre publisher identifier.
	 */
	Identifiant_Editeur_Electre("28"), //

	/**
	 * French Electre imprint Identifier.
	 */
	Identifiant_Marque_Electre("30"), //

	/**
	 * DOI used in CrossRef’s Fundref list of academic research funding bodies, for example "10.13039/100004440“ (Wellcome Trust). See
	 * ‘http://www.crossref.org/fundref/fundref_registry.html’.
	 */
	FundRef_DOI("32");

	public final String value;

	private NameCodeTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, NameCodeTypes> map;

	private static Map<String, NameCodeTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (NameCodeTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static NameCodeTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
