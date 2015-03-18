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

package com.tectonica.jonix.onix2.codelist;

import java.util.Map;
import java.util.HashMap;

/**
 * Currency code – ISO 4217
 */
public enum List96
{
	/**
	 * United Arab Emirates.
	 */
	UAE_Dirham("AED"), //

	/**
	 * DEPRECATED, replaced by AFN.
	 */
	Afghani("AFA"), //

	/**
	 * Afghanistan (0).
	 */
	Afghani_("AFN"), //

	/**
	 * Albania (0).
	 */
	Lek("ALL"), //

	/**
	 * Armenia (0).
	 */
	Armenian_Dram("AMD"), //

	/**
	 * Curaçao, Sint Maarten.
	 */
	Netherlands_Antillian_Guilder("ANG"), //

	/**
	 * Angola.
	 */
	Angolan_Kwanza("AOA"), //

	/**
	 * Argentina.
	 */
	Argentine_Peso("ARS"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Austria__Schilling("ATS"), //

	/**
	 * Australia, Christmas Island, Cocos (Keeling) Islands, Heard Island and McDonald Islands, Kiribati, Nauru, Norfolk Island, Tuvalu.
	 */
	Australian_Dollar("AUD"), //

	/**
	 * Aruba.
	 */
	Aruban_Florin("AWG"), //

	/**
	 * Azerbaijan.
	 */
	Azerbaijanian_Manat("AZN"), //

	/**
	 * Bosnia and Herzegovina.
	 */
	Convertible_Marks("BAM"), //

	/**
	 * Barbados.
	 */
	Barbados_Dollar("BBD"), //

	/**
	 * Bangladesh.
	 */
	Taka("BDT"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Belgium__Franc("BEF"), //

	/**
	 * DEPRECATED, replaced by BGN.
	 */
	Lev("BGL"), //

	/**
	 * Bulgaria.
	 */
	Lev_("BGN"), //

	/**
	 * Bahrain (3).
	 */
	Bahraini_Dinar("BHD"), //

	/**
	 * Burundi (0).
	 */
	Burundi_Franc("BIF"), //

	/**
	 * Bermuda.
	 */
	Bermuda_Dollar("BMD"), //

	/**
	 * Brunei Darussalam.
	 */
	Brunei_Dollar("BND"), //

	/**
	 * Bolivia.
	 */
	Boliviano("BOB"), //

	/**
	 * Brazil.
	 */
	Brazilian_Real("BRL"), //

	/**
	 * Bahamas.
	 */
	Bahamian_Dollar("BSD"), //

	/**
	 * Bhutan.
	 */
	Ngultrun("BTN"), //

	/**
	 * Botswana.
	 */
	Pula("BWP"), //

	/**
	 * Belarus (0).
	 */
	Belarussian_Ruble("BYR"), //

	/**
	 * Belize.
	 */
	Belize_Dollar("BZD"), //

	/**
	 * Canada.
	 */
	Canadian_Dollar("CAD"), //

	/**
	 * Congo (Democratic Republic of the).
	 */
	Franc_Congolais("CDF"), //

	/**
	 * Switzerland, Liechtenstein.
	 */
	Swiss_Franc("CHF"), //

	/**
	 * Chile (0).
	 */
	Chilean_Peso("CLP"), //

	/**
	 * China.
	 */
	Yuan_Renminbi("CNY"), //

	/**
	 * Colombia (0).
	 */
	Colombian_Peso("COP"), //

	/**
	 * Costa Rica (0).
	 */
	Costa_Rican_Colon("CRC"), //

	/**
	 * Deprecated, replaced by RSD.
	 */
	Serbian_Dinar("CSD"), //

	/**
	 * Cuba (alternative currency).
	 */
	Cuban_Convertible_Peso("CUC"), //

	/**
	 * Cuba.
	 */
	Cuban_Peso("CUP"), //

	/**
	 * Cape Verde (0).
	 */
	Cape_Verde_Escudo("CVE"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Cyprus_Pound("CYP"), //

	/**
	 * Czech Republic.
	 */
	Czech_Koruna("CZK"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Germany__Mark("DEM"), //

	/**
	 * Djibouti (0).
	 */
	Djibouti_Franc("DJF"), //

	/**
	 * Denmark, Faroe Islands, Greenland.
	 */
	Danish_Krone("DKK"), //

	/**
	 * Dominican Republic.
	 */
	Dominican_Peso("DOP"), //

	/**
	 * Algeria.
	 */
	Algerian_Dinar("DZD"), //

	/**
	 * Estonia – now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Kroon("EEK"), //

	/**
	 * Egypt.
	 */
	Egyptian_Pound("EGP"), //

	/**
	 * Eritrea.
	 */
	Nakfa("ERN"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro (0).
	 */
	Spain__Peseta("ESP"), //

	/**
	 * Ethiopia.
	 */
	Ethiopian_Birr("ETB"), //

	/**
	 * Eurozone: Andorra, Austria, Belgium, Cyprus, Estonia, Finland, France, Fr Guiana, Fr S Territories, Germany, Greece, Guadeloupe, Holy
	 * See (Vatican City), Ireland, Italy, Luxembourg, Latvia, Martinique, Malta, Mayotte, Monaco, Montenegro, Netherlands, Portugal,
	 * Réunion, St Pierre and Miquelon, San Marino, Spain.
	 */
	Euro("EUR"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Finland__Markka("FIM"), //

	/**
	 * Fiji.
	 */
	Fiji_Dollar("FJD"), //

	/**
	 * Falkland Islands (Malvinas).
	 */
	Falkland_Islands_Pound("FKP"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	France__Franc("FRF"), //

	/**
	 * United Kingdom, Isle of Man, Channel Islands, South Georgia, South Sandwich Islands, British Indian Ocean Territory.
	 */
	Pound_Sterling("GBP"), //

	/**
	 * Georgia.
	 */
	Lari("GEL"), //

	/**
	 * Deprecated, replaced by GHS.
	 */
	Cedi("GHC"), //

	/**
	 * Ghana.
	 */
	Cedi_("GHS"), //

	/**
	 * Gibraltar.
	 */
	Gibraltar_Pound("GIP"), //

	/**
	 * Gambia.
	 */
	Dalasi("GMD"), //

	/**
	 * Guinea (0).
	 */
	Guinea_Franc("GNF"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Greece__Drachma("GRD"), //

	/**
	 * Guatemala.
	 */
	Quetzal("GTQ"), //

	/**
	 * Now replaced by the CFA Franc BCEAO XOF use only for historical prices that pre-date use of the CFA Franc.
	 */
	Guinea_Bissau_Peso("GWP"), //

	/**
	 * Guyana (0).
	 */
	Guyana_Dollar("GYD"), //

	/**
	 * Hong Kong, Macao.
	 */
	Hong_Kong_Dollar("HKD"), //

	/**
	 * Honduras.
	 */
	Lempira("HNL"), //

	/**
	 * Croatia.
	 */
	Croatian_Kuna("HRK"), //

	/**
	 * Haiti.
	 */
	Gourde("HTG"), //

	/**
	 * Hungary (0).
	 */
	Forint("HUF"), //

	/**
	 * Indonesia (0).
	 */
	Rupiah("IDR"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Ireland__Punt("IEP"), //

	/**
	 * Israel.
	 */
	Israeli_Sheqel("ILS"), //

	/**
	 * India (0).
	 */
	Indian_Rupee("INR"), //

	/**
	 * Iraq (0).
	 */
	Iraqi_Dinar("IQD"), //

	/**
	 * Iran (Islamic Republic of) (0).
	 */
	Iranian_Rial("IRR"), //

	/**
	 * Iceland (0).
	 */
	Iceland_Krona("ISK"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro (0).
	 */
	Italy__Lira("ITL"), //

	/**
	 * Jamaica.
	 */
	Jamaican_Dollar("JMD"), //

	/**
	 * Jordan (3).
	 */
	Jordanian_Dinar("JOD"), //

	/**
	 * Japan (0).
	 */
	Yen("JPY"), //

	/**
	 * Kenya.
	 */
	Kenyan_Shilling("KES"), //

	/**
	 * Kyrgyzstan.
	 */
	Som("KGS"), //

	/**
	 * Cambodia.
	 */
	Riel("KHR"), //

	/**
	 * Comoros (0).
	 */
	Comoro_Franc("KMF"), //

	/**
	 * Korea (Democratic People’s Republic of) (0).
	 */
	North_Korean_Won("KPW"), //

	/**
	 * Korea (Republic of) (0).
	 */
	Won("KRW"), //

	/**
	 * Kuwait (3).
	 */
	Kuwaiti_Dinar("KWD"), //

	/**
	 * Cayman Islands.
	 */
	Cayman_Islands_Dollar("KYD"), //

	/**
	 * Kazakstan.
	 */
	Tenge("KZT"), //

	/**
	 * Lao People’s Democratic Republic (0).
	 */
	Kip("LAK"), //

	/**
	 * Lebanon (0).
	 */
	Lebanese_Pound("LBP"), //

	/**
	 * Sri Lanka.
	 */
	Sri_Lanka_Rupee("LKR"), //

	/**
	 * Liberia.
	 */
	Liberian_Dollar("LRD"), //

	/**
	 * Lesotho.
	 */
	Loti("LSL"), //

	/**
	 * Lithuania.
	 */
	Lithuanian_Litus("LTL"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro (0).
	 */
	Luxembourg__Franc("LUF"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Latvian_Lats("LVL"), //

	/**
	 * Libyan Arab Jamahiriya (3).
	 */
	Libyan_Dinar("LYD"), //

	/**
	 * Morocco, Western Sahara.
	 */
	Moroccan_Dirham("MAD"), //

	/**
	 * Moldova, Republic of.
	 */
	Moldovan_Leu("MDL"), //

	/**
	 * Madagascar (0 or 1 – 1 iraimbilanja = Ar0.2).
	 */
	Ariary("MGA"), //

	/**
	 * Now replaced by the Ariary (MGA) (0).
	 */
	Malagasy_Franc("MGF"), //

	/**
	 * Macedonia (former Yugoslav Republic of).
	 */
	Denar("MKD"), //

	/**
	 * Myanmar (0).
	 */
	Kyat("MMK"), //

	/**
	 * Mongolia (0).
	 */
	Tugrik("MNT"), //

	/**
	 * Macau.
	 */
	Pataca("MOP"), //

	/**
	 * Mauritania (0 or 1 – 1 khoums = UM0.2).
	 */
	Ouguiya("MRO"), //

	/**
	 * Malta – now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Maltese_Lira("MTL"), //

	/**
	 * Mauritius (0).
	 */
	Mauritius_Rupee("MUR"), //

	/**
	 * Maldives.
	 */
	Rufiyaa("MVR"), //

	/**
	 * Malawi.
	 */
	Kwacha("MWK"), //

	/**
	 * Mexico.
	 */
	Mexican_Peso("MXN"), //

	/**
	 * Malaysia.
	 */
	Malaysian_Ringgit("MYR"), //

	/**
	 * Mozambique.
	 */
	Metical("MZN"), //

	/**
	 * Namibia.
	 */
	Namibia_Dollar("NAD"), //

	/**
	 * Nigeria.
	 */
	Naira("NGN"), //

	/**
	 * Nicaragua.
	 */
	Cordoba_Oro("NIO"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Netherlands__Guilder("NLG"), //

	/**
	 * Norway, Bouvet Island, Svalbard and Jan Mayen.
	 */
	Norwegian_Krone("NOK"), //

	/**
	 * Nepal.
	 */
	Nepalese_Rupee("NPR"), //

	/**
	 * New Zealand, Cook Islands, Niue, Pitcairn, Tokelau.
	 */
	New_Zealand_Dollar("NZD"), //

	/**
	 * Oman (3).
	 */
	Rial_Omani("OMR"), //

	/**
	 * Panama.
	 */
	Balboa("PAB"), //

	/**
	 * Peru.
	 */
	Nuevo_Sol("PEN"), //

	/**
	 * Papua New Guinea.
	 */
	Kina("PGK"), //

	/**
	 * Philippines.
	 */
	Philippine_Peso("PHP"), //

	/**
	 * Pakistan (0).
	 */
	Pakistan_Rupee("PKR"), //

	/**
	 * Poland.
	 */
	Zloty("PLN"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Portugal__Escudo("PTE"), //

	/**
	 * Paraguay (0).
	 */
	Guarani("PYG"), //

	/**
	 * Qatar.
	 */
	Qatari_Rial("QAR"), //

	/**
	 * Deprecated, replaced by RON.
	 */
	Old_Leu("ROL"), //

	/**
	 * Romania.
	 */
	New_Leu("RON"), //

	/**
	 * Serbia (0).
	 */
	Serbian_Dinar_("RSD"), //

	/**
	 * Russian Federation.
	 */
	Russian_Ruble("RUB"), //

	/**
	 * DEPRECATED, replaced by RUB.
	 */
	Russian_Ruble_("RUR"), //

	/**
	 * Rwanda (0).
	 */
	Rwanda_Franc("RWF"), //

	/**
	 * Saudi Arabia.
	 */
	Saudi_Riyal("SAR"), //

	/**
	 * Solomon Islands.
	 */
	Solomon_Islands_Dollar("SBD"), //

	/**
	 * Seychelles.
	 */
	Seychelles_Rupee("SCR"), //

	/**
	 * Now replaced by the Sudanese Pound (SDG).
	 */
	Sudanese_Dinar("SDD"), //

	/**
	 * Sudan.
	 */
	Sudanese_Pound("SDG"), //

	/**
	 * Sweden.
	 */
	Swedish_Krona("SEK"), //

	/**
	 * Singapore.
	 */
	Singapore_Dollar("SGD"), //

	/**
	 * Saint Helena.
	 */
	Saint_Helena_Pound("SHP"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Tolar("SIT"), //

	/**
	 * Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro.
	 */
	Slovak_Koruna("SKK"), //

	/**
	 * Sierra Leone (0).
	 */
	Leone("SLL"), //

	/**
	 * Somalia (0).
	 */
	Somali_Shilling("SOS"), //

	/**
	 * Suriname.
	 */
	Surinam_Dollar("SRD"), //

	/**
	 * DEPRECATED, replaced by SRD.
	 */
	Suriname_Guilder("SRG"), //

	/**
	 * São Tome and Principe (0).
	 */
	Dobra("STD"), //

	/**
	 * El Salvador.
	 */
	El_Salvador_Colon("SVC"), //

	/**
	 * Syrian Arab Republic (0).
	 */
	Syrian_Pound("SYP"), //

	/**
	 * Swaziland.
	 */
	Lilangeni("SZL"), //

	/**
	 * Thailand.
	 */
	Baht("THB"), //

	/**
	 * Tajikistan.
	 */
	Somoni("TJS"), //

	/**
	 * Deprecated, replaced by TMT (0).
	 */
	Manat("TMM"), //

	/**
	 * Turkmenistan.
	 */
	Manat_("TMT"), //

	/**
	 * Tunisia (3).
	 */
	Tunisian_Dinar("TND"), //

	/**
	 * Tonga.
	 */
	Pa_anga("TOP"), //

	/**
	 * NO LONGER VALID, Timor-Leste now uses the US Dollar.
	 */
	Timor_Escudo("TPE"), //

	/**
	 * Deprecated, replaced by TRY (0).
	 */
	Turkish_Lira__old_("TRL"), //

	/**
	 * Turkey, from 1 January 2005.
	 */
	Turkish_Lira__new_("TRY"), //

	/**
	 * Trinidad and Tobago.
	 */
	Trinidad_and_Tobago_Dollar("TTD"), //

	/**
	 * Taiwan (Province of China).
	 */
	New_Taiwan_Dollar("TWD"), //

	/**
	 * Tanzania (United Republic of) (0).
	 */
	Tanzanian_Shilling("TZS"), //

	/**
	 * Ukraine.
	 */
	Hryvnia("UAH"), //

	/**
	 * Uganda (0).
	 */
	Uganda_Shilling("UGX"), //

	/**
	 * United States, American Samoa, British Indian Ocean Territory, Ecuador, Guam, Marshall Is, Micronesia (Federated States of), Northern
	 * Mariana Is, Palau, Puerto Rico, Timor-Leste, Turks and Caicos Is, US Minor Outlying Is, Virgin Is (British), Virgin Is (US).
	 */
	US_Dollar("USD"), //

	/**
	 * Uruguay.
	 */
	Peso_Uruguayo("UYU"), //

	/**
	 * Uzbekistan (0).
	 */
	Uzbekistan_Sum("UZS"), //

	/**
	 * Deprecated, replaced by VEF.
	 */
	Bolivar("VEB"), //

	/**
	 * Venezuela.
	 */
	Bolivar_fuerte("VEF"), //

	/**
	 * Viet Nam (0).
	 */
	Dong("VND"), //

	/**
	 * Vanuatu (0).
	 */
	Vatu("VUV"), //

	/**
	 * Samoa.
	 */
	Tala("WST"), //

	/**
	 * Cameroon, Central African Republic, Chad, Congo, Equatorial Guinea, Gabon (0).
	 */
	CFA_Franc_BEAC("XAF"), //

	/**
	 * Anguilla, Antigua and Barbuda, Dominica, Grenada, Montserrat, Saint Kitts and Nevis, Saint Lucia, Saint Vincent and the Grenadines.
	 */
	East_Caribbean_Dollar("XCD"), //

	/**
	 * Benin, Burkina Faso, Côte D’Ivoire, Guinea-Bissau, Mali, Niger, Senegal, Togo (0).
	 */
	CFA_Franc_BCEAO("XOF"), //

	/**
	 * French Polynesia, New Caledonia, Wallis and Futuna (0).
	 */
	CFP_Franc("XPF"), //

	/**
	 * Yemen (0).
	 */
	Yemeni_Rial("YER"), //

	/**
	 * DEPRECATED, replaced by CSD.
	 */
	Yugoslavian_Dinar("YUM"), //

	/**
	 * South Africa.
	 */
	Rand("ZAR"), //

	/**
	 * Deprecated, replaced with ZMW (0).
	 */
	Kwacha_("ZMK"), //

	/**
	 * Zambia.
	 */
	Zambian_Kwacha("ZMW"), //

	/**
	 * Deprecated, replaced with ZWL (0).
	 */
	Zimbabwe_Dollar("ZWD"), //

	/**
	 * Zimbabwe.
	 */
	Zimbabwe_Dollar_("ZWL");

	public final String value;

	private List96(String value)
	{
		this.value = value;
	}

	private static Map<String, List96> map;

	private static Map<String, List96> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List96 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List96 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
