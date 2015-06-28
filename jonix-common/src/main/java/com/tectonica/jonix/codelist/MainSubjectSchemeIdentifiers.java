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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 26</b>
 * <p>
 * Description: Main subject scheme identifier code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum MainSubjectSchemeIdentifiers
{
	/**
	 * Dewey Decimal Classification.
	 */
	Dewey("01"), //

	Abridged_Dewey("02"), //

	/**
	 * US Library of Congress classification.
	 */
	LC_classification("03"), //

	/**
	 * US Library of Congress subject heading.
	 */
	LC_subject_heading("04"), //

	/**
	 * US National Library of Medicine medical classification.
	 */
	NLM_classification("05"), //

	/**
	 * US National Library of Medicine Medical subject heading.
	 */
	MeSH_heading("06"), //

	/**
	 * US National Agricultural Library subject heading.
	 */
	NAL_subject_heading("07"), //

	/**
	 * Getty Art and Architecture Thesaurus heading.
	 */
	AAT("08"), //

	/**
	 * Universal Decimal Classification.
	 */
	UDC("09"), //

	/**
	 * BISAC Subject Headings are used in the North American market to categorize books based on topical content. They
	 * serve as a guideline for shelving books in physical stores and browsing books in online stores. See
	 * &#8216;https://www.bisg.org/complete-bisac-subject-headings-2013-edition&#8217;.
	 */
	BISAC_Subject_Heading("10"), //

	/**
	 * A geographical qualifier used with a BISAC subject category.
	 */
	BISAC_region_code("11"), //

	/**
	 * For all BIC subject codes and qualifiers, see
	 * &#8216;http://www.bic.org.uk/7/BIC-Standard-Subject-Categories/&#8217;.
	 */
	BIC_subject_category("12"), //

	BIC_geographical_qualifier("13"), //

	BIC_language_qualifier_language_as_subject("14"), //

	BIC_time_period_qualifier("15"), //

	BIC_educational_purpose_qualifier("16"), //

	BIC_reading_level_and_special_interest_qualifier("17"), //

	/**
	 * Used for German National Bibliography since 2004 (100 subjects). Is different from value 30. See
	 * http://www.d-nb.de/service/pdf/ddc_wv_aktuell.pdf (in German) or
	 * http://www.d-nb.de/eng/service/pdf/ddc_wv_aktuell_eng.pdf (English).
	 */
	DDC_Sachgruppen_der_Deutschen_Nationalbibliografie("18"), //

	LC_fiction_genre_heading("19"), //

	/**
	 * Where multiple keywords or keyword phrases are sent in a single instance of the &lt;SubjectHeadingText&gt;
	 * element, it is recommended that they should be separated by semi-colons (this is consistent with Library of
	 * Congress preferred practice).
	 */
	Keywords("20"), //

	/**
	 * See &#8216;http://www.bic.org.uk/8/Children&#8217;s-Books-Marketing-Classifications/&#8217;.
	 */
	BIC_children_s_book_marketing_category("21"), //

	/**
	 * BISAC Merchandising Themes are used in addition to BISAC Subject Headings to denote an audience to which a work
	 * may be of particular appeal, a time of year or event for which a work may be especially appropriate, or to
	 * further describe fictional works that have been subject-coded by genre.
	 */
	BISAC_Merchandising_Theme("22"), //

	Publisher_s_own_category_code("23"), //

	/**
	 * As specified in &lt;SubjectSchemeName&gt;.
	 */
	Proprietary_subject_scheme("24"), //

	/**
	 * Latin America.
	 */
	Tabla_de_materias_ISBN("25"), //

	/**
	 * See http://info.vlb.de/files/wgsneuversion2_0.pdf (in German).
	 */
	Warengruppen_Systematik_des_deutschen_Buchhandels("26"), //

	/**
	 * Schlagwortnormdatei &#8211; Subject Headings Authority File in the German-speaking countries. See
	 * http://www.d-nb.de/standardisierung/normdateien/swd.htm (in German) and
	 * http://www.d-nb.de/eng/standardisierung/normdateien/swd.htm (English). DEPRECATED in favour of the GND.
	 */
	SWD("27"), //

	/**
	 * Subject classification used by Electre (France).
	 */
	Th_mes_Electre("28"), //

	/**
	 * France. A four-digit number, see http://www.clil.org/information/documentation.html (in French). The first digit
	 * identifies the version of the scheme.
	 */
	CLIL("29"), //

	/**
	 * Deutsche Bibliothek subject groups. Used for German National Bibliography until 2003 (65 subjects). Is different
	 * from value 18. See &#8216;http://www.d-nb.de/service/pdf/ddc_wv_alt_neu.pdf&#8217;.
	 */
	DNB_Sachgruppen("30"), //

	/**
	 * Nederlandse Uniforme Genre-Indeling (former Dutch book trade classification).
	 */
	NUGI("31"), //

	/**
	 * Nederlandstalige Uniforme Rubrieksindeling (Dutch book trade classification, from 2002),see
	 * http://www.boek.nl/nur (in Dutch).
	 */
	NUR("32"), //

	/**
	 * ECPA Christian Product Category Book Codes, consisting of up to three x 3-letter blocks, for Super Category,
	 * Primary Category and Sub-Category. See &#8216;http://www.ecpa.org/ECPA/cbacategories.xls&#8217;.
	 */
	ECPA_Christian_Book_Category("33"), //

	/**
	 * Schema Indeling Systematische Catalogus Openbare Bibliotheken (Dutch library classification).
	 */
	SISO("34"), //

	/**
	 * A modified Dewey Decimal Classification used in the Republic of Korea.
	 */
	Korean_Decimal_Classification_KDC("35"), //

	/**
	 * German Translation of Dewey Decimal Classification 22. Also known as DDC 22 ger. See
	 * &#8216;http://www.ddc-deutsch.de/produkte/uebersichten/&#8217;.
	 */
	DDC_Deutsch_22("36"), //

	/**
	 * Norwegian book trade product categories (Bokgrupper) administered by the Norwegian Publishers Association
	 * (http://www.forleggerforeningen.no/).
	 */
	Bokgrupper("37"), //

	/**
	 * Norwegian bookselling subject categories (Bokhandelens varegrupper) administered by the Norwegian Booksellers
	 * Association (http://bokhandlerforeningen.no/).
	 */
	Varegrupper("38"), //

	/**
	 * Norwegian school curriculum version. Deprecated.
	 */
	L_replaner("39"), //

	/**
	 * Japanese subject classification scheme.
	 */
	Nippon_Decimal_Classification("40"), //

	/**
	 * BookSelling Qualifier: Russian book trade classification.
	 */
	BSQ("41"), //

	/**
	 * Spain: subject coding scheme of the Asociaci&#243;n Nacional de Editores de Libros y Material de Ense&#241;anza.
	 */
	ANELE_Materias("42"), //

	/**
	 * Codes for Norwegian &#8216;utdanningsprogram&#8217; used in secondary education. See: http://www.udir.no/.
	 * (Formerly &#8216;Skolefag&#8217;.)
	 */
	Utdanningsprogram("43"), //

	/**
	 * Codes for Norwegian &#8216;programfag&#8217; used in secondary education. See http://www.udir.no/. (Formerly
	 * &#8216;Videreg&#229;ende&#8217;.)
	 */
	Programfag("44"), //

	/**
	 * Norwegian list of categories for books and other material used in education.
	 */
	Undervisningsmateriell("45"), //

	/**
	 * Norwegian version of Dewey Decimal Classification.
	 */
	Norsk_DDK("46"), //

	/**
	 * Swedish bookselling subject categories.
	 */
	Varugrupper("47"), //

	/**
	 * Swedish classification scheme.
	 */
	SAB("48"), //

	/**
	 * Swedish bookselling educational subject type.
	 */
	L_romedelstyp("49"), //

	/**
	 * Swedish publishers preliminary subject classification.
	 */
	F_rhandsbeskrivning("50"), //

	/**
	 * Controlled subset of UDC codes used by the Spanish ISBN Agency.
	 */
	Spanish_ISBN_UDC_subset("51"), //

	/**
	 * Subject categories defined by El Corte Ingl&#233;s and used widely in the Spanish book trade.
	 */
	ECI_subject_categories("52"), //

	/**
	 * Classificazione commerciale editoriale (Italian book trade subject category based on BIC). CCE documentation
	 * available at &#8216;http://www.ie-online.it/CCE2_2.0.pdf&#8217;.
	 */
	Soggetto_CCE("53"), //

	Qualificatore_geografico_CCE("54"), //

	Qualificatore_di_lingua_CCE("55"), //

	Qualificatore_di_periodo_storico_CCE("56"), //

	Qualificatore_di_livello_scolastico_CCE("57"), //

	Qualificatore_di_et_di_lettura_CCE("58"), //

	/**
	 * Subject code list of the German association of educational media publishers.
	 */
	VdS_Bildungsmedien_F_cher("59"), //

	/**
	 * Norwegian primary and secondary school subject categories (fagkoder), see &quot;http://www.udir.no/&quot;.
	 */
	Fagkoder("60"), //

	/**
	 * Journal of Economic Literature classification scheme.
	 */
	JEL_classification("61"), //

	/**
	 * National Library of Canada subject heading (English).
	 */
	CSH("62"), //

	/**
	 * R&#233;pertoire de vedettes-mati&#232;re (Biblioth&#232;que et Archives Canada et Biblioth&#232;que de
	 * l&#8217;Universit&#233; Laval) (French).
	 */
	RVM("63"), //

	/**
	 * Yleinen suomalainen asiasanasto: Finnish General Thesaurus. See http://onki.fi/fi/browser/ (in Finnish).
	 */
	YSA("64"), //

	/**
	 * Allm&#228;n tesaurus p&#229; svenska: Swedish translation of the Finnish General Thesaurus. See
	 * http://onki.fi/fi/browser/ (in Finnish).
	 */
	All_rs("65"), //

	/**
	 * Yleisten kirjastojen luokitusj&#228;rjestelm&#228;: Finnish Public Libraries Classification System. See
	 * http://ykl.kirjastot.fi/ (in Finnish).
	 */
	YKL("66"), //

	/**
	 * Musiikin asiasanasto: Finnish Music Thesaurus. See http://onki.fi/fi/browser/ (in Finnish).
	 */
	MUSA("67"), //

	/**
	 * Specialtesaurus f&#246;r musik: Swedish translation of the Finnish Music Thesaurus. See
	 * http://onki.fi/fi/browser/ (in Finnish).
	 */
	CILLA("68"), //

	/**
	 * Fiktiivisen aineiston asiasanasto: Finnish thesaurus for fiction. See http://kaunokki.kirjastot.fi/ (in Finnish).
	 */
	Kaunokki("69"), //

	/**
	 * Specialtesaurus f&#246;r fiktivt material: Swedish translation of the Finnish thesaurus for fiction. See
	 * http://kaunokki.kirjastot.fi/sv-FI/ (in Finnish).
	 */
	Bella("70"), //

	/**
	 * Yleinen suomalainen ontologia: Finnish General Upper Ontology. See http://onki.fi/fi/browser/ (In Finnish).
	 */
	YSO("71"), //

	/**
	 * Finnish Place Ontology. See http://onki.fi/fi/browser/ (in Finnish).
	 */
	Paikkatieto_ontologia("72"), //

	/**
	 * Finnish book trade categorisation.
	 */
	Suomalainen_kirja_alan_luokitus("73"), //

	/**
	 * Sears List of Subject Headings.
	 */
	Sears("74"), //

	/**
	 * BIC E4Libraries Category Headings, see
	 * &#8216;http://www.bic.org.uk/51/E4libraries-Subject-Category-Headings/&#8217;.
	 */
	BIC_E4L("75"), //

	/**
	 * Code Sujet Rayon: subject categories used by bookstores in France.
	 */
	CSR("76"), //

	/**
	 * Finnish school subject categories.
	 */
	Suomalainen_oppiaineluokitus("77"), //

	/**
	 * See &#8216;http://www.asahi-net.or.jp/~ax2s-kmtn/ref/ccode.html&#8217; (in Japanese).
	 */
	Japanese_book_trade_C_Code("78"), //

	Japanese_book_trade_Genre_Code("79"), //

	/**
	 * Finnish fiction genre classification. See http://ykl.kirjastot.fi/fi-FI/lisaluokat/ (in Finnish).
	 */
	Fiktiivisen_aineiston_lis_luokitus("80"), //

	/**
	 * Location defined by postal code. Format is two-letter country code (from List 91), space, postal code. Note some
	 * postal codes themselves contain spaces, eg &#8220;GB N7 9DP&#8221; or &#8220;US 10125&#8221;.
	 */
	Postal_code("85"), //

	/**
	 * ID number for geographical place, as defined at http://www.geonames.org (eg 2825297 is Stuttgart, Germany, see
	 * http://www.geonames.org/2825297).
	 */
	GeoNames_ID("86"), //

	/**
	 * Used for classification of academic and specialist publication in German-speaking countries. See
	 * http://www.newbooks-services.com/de/top/unternehmensportrait/klassifikation-und-mapping.html (German) and
	 * http://www.newbooks-services.com/en/top/about-newbooks/classification-mapping.html (English).
	 */
	NewBooks_Subject_Classification("87"), //

	/**
	 * Gemeinsame Normdatei &#8211; Joint Authority File in the German-speaking countries. See
	 * http://www.dnb.de/EN/Standardisierung/Normdaten/GND/gnd_node.html (English). Combines the PND, SWD and GKD into a
	 * single authority file, and should be used in preference to the older codes.
	 */
	GND("91"), //

	/**
	 * UK Standard Library Categories, the successor to BIC&#8217;s E4L classification scheme.
	 */
	BIC_UKSLC("92"), //

	Thema_subject_category("93"), //

	Thema_geographical_qualifier("94"), //

	Thema_language_qualifier("95"), //

	Thema_time_period_qualifier("96"), //

	Thema_educational_purpose_qualifier("97"), //

	Thema_interest_age_special_interest_qualifier("98"), //

	Thema_style_qualifier("99"), //

	/**
	 * Swedish subject categories maintained by Bokrondellen.
	 */
	_mnesord("A2"), //

	/**
	 * Polish Statistical Book and E-book Classification.
	 */
	Statystyka_Ksi_ek_Papierowych_M_wionych_I_Elektronicznych("A3"), //

	/**
	 * Common Core State Standards curriculum alignment, for links to US educational standards. &lt;SubjectCode&gt; uses
	 * the full dot notation. See &#8216;http://www.corestandards.org/developers-and-publishers&#8217;.
	 */
	CCSS("A4"), //

	/**
	 * French library classification.
	 */
	Rameau("A5"), //

	/**
	 * French educational subject classification, used for example on WizWiz.fr. See
	 * &#8216;http://www.kiosque-edu.com/html/onix/Nomenclature_disciplines.csv&#8217;.
	 */
	Nomenclature_discipline_scolaire("A6"), //

	/**
	 * International Standard Industry Classification, a classification of economic activities. Use for books that are
	 * about a particular industry or economic activity. See &#8216;http://unstats.un.org/unsd/cr/registry/isic-
	 * 4.asp&#8217;. &lt;SubjectCode&gt; should be a single letter denoting an ISIC section OR a 2-, 3- or 4-digit
	 * number denoting an ISIC division, group or class.
	 */
	ISIC("A7"), //

	/**
	 * Library of Congress Children&#8217;s Subject Headings: LCSHAC supplementary headings for Children&#8217;s books
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	LC_Children_s_Subject_Headings("A8"), //

	/**
	 * Swedish bookselling educational subject. &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Ny_L_romedel("A9");

	public final String value;

	private MainSubjectSchemeIdentifiers(String value)
	{
		this.value = value;
	}

	private static Map<String, MainSubjectSchemeIdentifiers> map;

	private static Map<String, MainSubjectSchemeIdentifiers> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (MainSubjectSchemeIdentifiers e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static MainSubjectSchemeIdentifiers byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
