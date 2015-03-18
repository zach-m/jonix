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

/**
 * Region code
 */
public enum List49
{
	Australian_Capital_Territory("AU-CT"), //

	New_South_Wales("AU-NS"), //

	Northern_Territory("AU-NT"), //

	Queensland("AU-QL"), //

	South_Australia("AU-SA"), //

	Tasmania("AU-TS"), //

	Victoria("AU-VI"), //

	Western_Australia("AU-WA"), //

	Alberta("CA-AB"), //

	British_Columbia("CA-BC"), //

	Manitoba("CA-MB"), //

	New_Brunswick("CA-NB"), //

	Newfoundland_and_Labrador("CA-NL"), //

	Nova_Scotia("CA-NS"), //

	Northwest_Territories("CA-NT"), //

	Nunavut("CA-NU"), //

	Ontario("CA-ON"), //

	Prince_Edward_Island("CA-PE"), //

	Quebec("CA-QC"), //

	Saskatchewan("CA-SK"), //

	Yukon_Territory("CA-YT"), //

	Canary_Islands("ES-CN"), //

	/**
	 * Airside outlets at UK international airports only.
	 */
	UK_airside("GB-AIR"), //

	/**
	 * All UK airports, including both airside and other outlets.
	 */
	UK_airports("GB-APS"), //

	/**
	 * DEPRECATED, replaced by country codes GG – Guernsey, and JE – Jersey.
	 */
	Channel_Islands("GB-CHA"), //

	England("GB-ENG"), //

	/**
	 * UK excluding Northern Ireland.
	 */
	England__Wales__Scotland("GB-EWS"), //

	/**
	 * DEPRECATED, replaced by country code IM – Isle of Man.
	 */
	Isle_of_Man("GB-IOM"), //

	Northern_Ireland("GB-NIR"), //

	Scotland("GB-SCT"), //

	Wales("GB-WLS"), //

	/**
	 * Airside outlets at Irish international airports only.
	 */
	Ireland_airside("IE-AIR"), //

	Agrigento("IT-AG"), //

	Alessandria("IT-AL"), //

	Ancona("IT-AN"), //

	Aosta("IT-AO"), //

	Arezzo("IT-AR"), //

	Ascoli_Piceno("IT-AP"), //

	Asti("IT-AT"), //

	Avellino("IT-AV"), //

	Bari("IT-BA"), //

	Barletta_Andria_Trani("IT-BT"), //

	Belluno("IT-BL"), //

	Benevento("IT-BN"), //

	Bergamo("IT-BG"), //

	Biella("IT-BI"), //

	Bologna("IT-BO"), //

	Bolzano("IT-BZ"), //

	Brescia("IT-BS"), //

	Brindisi("IT-BR"), //

	Cagliari("IT-CA"), //

	Caltanissetta("IT-CL"), //

	Campobasso("IT-CB"), //

	Carbonia_Iglesias("IT-CI"), //

	Caserta("IT-CE"), //

	Catania("IT-CT"), //

	Catanzaro("IT-CZ"), //

	Chieti("IT-CH"), //

	Como("IT-CO"), //

	Cosenza("IT-CS"), //

	Cremona("IT-CR"), //

	Crotone("IT-KR"), //

	Cuneo("IT-CN"), //

	Enna("IT-EN"), //

	Fermo("IT-FM"), //

	Ferrara("IT-FE"), //

	Firenze("IT-FI"), //

	Foggia("IT-FG"), //

	Forl__Cesena("IT-FC"), //

	Frosinone("IT-FR"), //

	Genova("IT-GE"), //

	Gorizia("IT-GO"), //

	Grosseto("IT-GR"), //

	Imperia("IT-IM"), //

	Isernia("IT-IS"), //

	La_Spezia("IT-SP"), //

	L_Aquila("IT-AQ"), //

	Latina("IT-LT"), //

	Lecce("IT-LE"), //

	Lecco("IT-LC"), //

	Livorno("IT-LI"), //

	Lodi("IT-LO"), //

	Lucca("IT-LU"), //

	Macerata("IT-MC"), //

	Mantova("IT-MN"), //

	Massa_Carrara("IT-MS"), //

	Matera("IT-MT"), //

	Medio_Campidano("IT-VS"), //

	Messina("IT-ME"), //

	Milano("IT-MI"), //

	Modena("IT-MO"), //

	Monza_e_Brianza("IT-MB"), //

	Napoli("IT-NA"), //

	Novara("IT-NO"), //

	Nuoro("IT-NU"), //

	Ogliastra("IT-OG"), //

	Olbia_Tempio("IT-OT"), //

	Oristano("IT-OR"), //

	Padova("IT-PD"), //

	Palermo("IT-PA"), //

	Parma("IT-PR"), //

	Pavia("IT-PV"), //

	Perugia("IT-PG"), //

	Pesaro_e_Urbino("IT-PU"), //

	Pescara("IT-PE"), //

	Piacenza("IT-PC"), //

	Pisa("IT-PI"), //

	Pistoia("IT-PT"), //

	Pordenone("IT-PN"), //

	Potenza("IT-PZ"), //

	Prato("IT-PO"), //

	Ragusa("IT-RG"), //

	Ravenna("IT-RA"), //

	Reggio_Calabria("IT-RC"), //

	Reggio_Emilia("IT-RE"), //

	Rieti("IT-RI"), //

	Rimini("IT-RN"), //

	Roma("IT-RM"), //

	Rovigo("IT-RO"), //

	Salerno("IT-SA"), //

	Sassari("IT-SS"), //

	Savona("IT-SV"), //

	Siena("IT-SI"), //

	Siracusa("IT-SR"), //

	Sondrio("IT-SO"), //

	Taranto("IT-TA"), //

	Teramo("IT-TE"), //

	Terni("IT-TR"), //

	Torino("IT-TO"), //

	Trapani("IT-TP"), //

	Trento("IT-TN"), //

	Treviso("IT-TV"), //

	Trieste("IT-TS"), //

	Udine("IT-UD"), //

	Varese("IT-VA"), //

	Venezia("IT-VE"), //

	Verbano_Cusio_Ossola("IT-VB"), //

	Vercelli("IT-VC"), //

	Verona("IT-VR"), //

	Vibo_Valentia("IT-VV"), //

	Vicenza("IT-VI"), //

	Viterbo("IT-VT"), //

	Kosovo_Metohija("RS-KM"), //

	Vojvodina("RS-VO"), //

	Republic_of_Adygeya("RU-AD"), //

	Republic_of_Altay("RU-AL"), //

	Republic_of_Bashkortostan("RU-BA"), //

	Republic_of_Buryatiya("RU-BU"), //

	Chechenskaya_Republic("RU-CE"), //

	Chuvashskaya_Republic("RU-CU"), //

	Republic_of_Dagestan("RU-DA"), //

	Republic_of_Ingushetiya("RU-IN"), //

	Kabardino_Balkarskaya_Republic("RU-KB"), //

	Republic_of_Kalmykiya("RU-KL"), //

	Karachayevo_Cherkesskaya_Republic("RU-KC"), //

	Republic_of_Kareliya("RU-KR"), //

	Republic_of_Khakasiya("RU-KK"), //

	Republic_of_Komi("RU-KO"), //

	Republic_of_Mariy_El("RU-ME"), //

	Republic_of_Mordoviya("RU-MO"), //

	Republic_of_Sakha__Yakutiya_("RU-SA"), //

	Republic_of_Severnaya_Osetiya_Alaniya("RU-SE"), //

	Republic_of_Tatarstan("RU-TA"), //

	Republic_of_Tyva__Tuva_("RU-TY"), //

	Udmurtskaya_Republic("RU-UD"), //

	Altayskiy_Administrative_Territory("RU-ALT"), //

	Kamchatskiy_Administrative_Territory("RU-KAM"), //

	Khabarovskiy_Administrative_Territory("RU-KHA"), //

	Krasnodarskiy_Administrative_Territory("RU-KDA"), //

	Krasnoyarskiy_Administrative_Territory("RU-KYA"), //

	Permskiy_Administrative_Territory("RU-PER"), //

	Primorskiy_Administrative_Territory("RU-PRI"), //

	Stavropol_skiy_Administrative_Territory("RU-STA"), //

	Zabaykal_skiy_Administrative_Territory("RU-ZAB"), //

	Amurskaya_Administrative_Region("RU-AMU"), //

	Arkhangel_skaya_Administrative_Region("RU-ARK"), //

	Astrakhanskaya_Administrative_Region("RU-AST"), //

	Belgorodskaya_Administrative_Region("RU-BEL"), //

	Bryanskaya_Administrative_Region("RU-BRY"), //

	Chelyabinskaya_Administrative_Region("RU-CHE"), //

	Irkutskaya_Administrative_Region("RU-IRK"), //

	Ivanovskaya_Administrative_Region("RU-IVA"), //

	Kaliningradskaya_Administrative_Region("RU-KGD"), //

	Kaluzhskaya_Administrative_Region("RU-KLU"), //

	Kemerovskaya_Administrative_Region("RU-KEM"), //

	Kirovskaya_Administrative_Region("RU-KIR"), //

	Kostromskaya_Administrative_Region("RU-KOS"), //

	Kurganskaya_Administrative_Region("RU-KGN"), //

	Kurskaya_Administrative_Region("RU-KRS"), //

	Leningradskaya_Administrative_Region("RU-LEN"), //

	Lipetskaya_Administrative_Region("RU-LIP"), //

	Magadanskaya_Administrative_Region("RU-MAG"), //

	Moskovskaya_Administrative_Region("RU-MOS"), //

	Murmanskaya_Administrative_Region("RU-MUR"), //

	Nizhegorodskaya_Administrative_Region("RU-NIZ"), //

	Novgorodskaya_Administrative_Region("RU-NGR"), //

	Novosibirskaya_Administrative_Region("RU-NVS"), //

	Omskaya_Administrative_Region("RU-OMS"), //

	Orenburgskaya_Administrative_Region("RU-ORE"), //

	Orlovskaya_Administrative_Region("RU-ORL"), //

	Penzenskaya_Administrative_Region("RU-PNZ"), //

	Pskovskaya_Administrative_Region("RU-PSK"), //

	Rostovskaya_Administrative_Region("RU-ROS"), //

	Ryazanskaya_Administrative_Region("RU-RYA"), //

	Sakhalinskaya_Administrative_Region("RU-SAK"), //

	Samarskaya_Administrative_Region("RU-SAM"), //

	Saratovskaya_Administrative_Region("RU-SAR"), //

	Smolenskaya_Administrative_Region("RU-SMO"), //

	Sverdlovskaya_Administrative_Region("RU-SVE"), //

	Tambovskaya_Administrative_Region("RU-TAM"), //

	Tomskaya_Administrative_Region("RU-TOM"), //

	Tul_skaya_Administrative_Region("RU-TUL"), //

	Tverskaya_Administrative_Region("RU-TVE"), //

	Tyumenskaya_Administrative_Region("RU-TYU"), //

	Ul_yanovskaya_Administrative_Region("RU-ULY"), //

	Vladimirskaya_Administrative_Region("RU-VLA"), //

	Volgogradskaya_Administrative_Region("RU-VGG"), //

	Vologodskaya_Administrative_Region("RU-VLG"), //

	Voronezhskaya_Administrative_Region("RU-VOR"), //

	Yaroslavskaya_Administrative_Region("RU-YAR"), //

	Moskva_City("RU-MOW"), //

	Sankt_Peterburg_City("RU-SPE"), //

	Yevreyskaya_Autonomous_Administrative_Region("RU-YEV"), //

	Chukotskiy_Autonomous_District("RU-CHU"), //

	Khanty_Mansiyskiy_Autonomous_District("RU-KHM"), //

	Nenetskiy_Autonomous_District("RU-NEN"), //

	Yamalo_Nenetskiy_Autonomous_District("RU-YAN"), //

	Alaska("US-AK"), //

	Alabama("US-AL"), //

	Arkansas("US-AR"), //

	Arizona("US-AZ"), //

	California("US-CA"), //

	Colorado("US-CO"), //

	Connecticut("US-CT"), //

	District_of_Columbia("US-DC"), //

	Delaware("US-DE"), //

	Florida("US-FL"), //

	Georgia("US-GA"), //

	Hawaii("US-HI"), //

	Iowa("US-IA"), //

	Idaho("US-ID"), //

	Illinois("US-IL"), //

	Indiana("US-IN"), //

	Kansas("US-KS"), //

	Kentucky("US-KY"), //

	Louisiana("US-LA"), //

	Massachusetts("US-MA"), //

	Maryland("US-MD"), //

	Maine("US-ME"), //

	Michigan("US-MI"), //

	Minnesota("US-MN"), //

	Missouri("US-MO"), //

	Mississippi("US-MS"), //

	Montana("US-MT"), //

	North_Carolina("US-NC"), //

	North_Dakota("US-ND"), //

	Nebraska("US-NE"), //

	New_Hampshire("US-NH"), //

	New_Jersey("US-NJ"), //

	New_Mexico("US-NM"), //

	Nevada("US-NV"), //

	New_York("US-NY"), //

	Ohio("US-OH"), //

	Oklahoma("US-OK"), //

	Oregon("US-OR"), //

	Pennsylvania("US-PA"), //

	Rhode_Island("US-RI"), //

	South_Carolina("US-SC"), //

	South_Dakota("US-SD"), //

	Tennessee("US-TN"), //

	Texas("US-TX"), //

	Utah("US-UT"), //

	Virginia("US-VA"), //

	Vermont("US-VT"), //

	Washington("US-WA"), //

	Wisconsin("US-WI"), //

	West_Virginia("US-WV"), //

	Wyoming("US-WY"), //

	/**
	 * Countries geographically within continental Europe which use the Euro as their sole currency. At the time of writing, this is a
	 * synonym for “AT BE CY EE FI FR DE ES GR IE IT LU LV MT NL PT SI SK” (the official Eurozone 18), plus “AD MC SM VA ME” (other
	 * Euro-using countries in continental Europe). Note some other territories using the Euro, but outside continental Europe are excluded
	 * from this list, and may need to be specified separately. Only valid in ONIX 3, and only within P.26. Use of an explicit list of
	 * countries instead of ECZ is strongly encouraged.
	 */
	Eurozone("ECZ"), //

	/**
	 * World except as otherwise specified. NOT USED in ONIX 3.
	 */
	Rest_of_world("ROW"), //

	World("WORLD");

	public final String value;

	private List49(String value)
	{
		this.value = value;
	}

	private static Map<String, List49> map;

	private static Map<String, List49> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List49 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List49 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
