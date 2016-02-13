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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 96</b>
 * <p>
 * Description: Currency code &#8211; ISO 4217
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum CurrencyCodes
{
	/**
	 * United Arab Emirates
	 */
	UAE_Dirham("AED"), //

	/**
	 * Afghanistan. DEPRECATED, replaced by AFN
	 */
	Afghani("AFA"), //

	/**
	 * Afghanistan (prices normally quoted as integers)
	 */
	Afghani_("AFN"), //

	/**
	 * Albania (prices normally quoted as integers)
	 */
	Lek("ALL"), //

	/**
	 * Armenia (prices normally quoted as integers)
	 */
	Armenian_Dram("AMD"), //

	/**
	 * Cura&#231;ao, Sint Maarten
	 */
	Netherlands_Antillian_Guilder("ANG"), //

	/**
	 * Angola
	 */
	Kwanza("AOA"), //

	/**
	 * Argentina
	 */
	Argentine_Peso("ARS"), //

	/**
	 * Austria. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Schilling("ATS"), //

	/**
	 * Australia, Christmas Island, Cocos (Keeling) Islands, Heard Island and McDonald Islands, Kiribati, Nauru, Norfolk
	 * Island, Tuvalu
	 */
	Australian_Dollar("AUD"), //

	/**
	 * Aruba
	 */
	Aruban_Florin("AWG"), //

	/**
	 * Azerbaijan
	 */
	Azerbaijanian_Manat("AZN"), //

	/**
	 * Bosnia and Herzegovina
	 */
	Convertible_Marks("BAM"), //

	/**
	 * Barbados
	 */
	Barbados_Dollar("BBD"), //

	/**
	 * Bangladesh
	 */
	Taka("BDT"), //

	/**
	 * Belgium. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Belgian_Franc("BEF"), //

	/**
	 * DEPRECATED, replaced by BGN
	 */
	Bulgarian_Lev("BGL"), //

	/**
	 * Bulgaria
	 */
	Bulgarian_Lev_("BGN"), //

	/**
	 * Bahrain (prices normally quoted with 3 decimal places)
	 */
	Bahraini_Dinar("BHD"), //

	/**
	 * Burundi (prices normally quoted as integers)
	 */
	Burundi_Franc("BIF"), //

	/**
	 * Bermuda
	 */
	Bermudian_Dollar("BMD"), //

	/**
	 * Brunei Darussalam
	 */
	Brunei_Dollar("BND"), //

	/**
	 * Bolivia
	 */
	Boliviano("BOB"), //

	/**
	 * Brazil
	 */
	Brazilian_Real("BRL"), //

	/**
	 * Bahamas
	 */
	Bahamian_Dollar("BSD"), //

	/**
	 * Bhutan
	 */
	Ngultrun("BTN"), //

	/**
	 * Botswana
	 */
	Pula("BWP"), //

	/**
	 * Belarus (prices normally quoted as integers). Now replaced by new Belarussian Ruble (BYN): use only for
	 * historical prices that pre-date the introduction of the new Belarussian Ruble
	 */
	Belarussian_Ruble("BYR"), //

	/**
	 * Belarus &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Belarussian_Ruble_("BYN"), //

	/**
	 * Belize
	 */
	Belize_Dollar("BZD"), //

	/**
	 * Canada
	 */
	Canadian_Dollar("CAD"), //

	/**
	 * Congo (Democratic Republic of the)
	 */
	Franc_Congolais("CDF"), //

	/**
	 * Switzerland, Liechtenstein
	 */
	Swiss_Franc("CHF"), //

	/**
	 * Chile (prices normally quoted as integers)
	 */
	Chilean_Peso("CLP"), //

	/**
	 * China
	 */
	Yuan_Renminbi("CNY"), //

	/**
	 * Colombia (prices normally quoted as integers)
	 */
	Colombian_Peso("COP"), //

	/**
	 * Costa Rica (prices normally quoted as integers)
	 */
	Costa_Rican_Colon("CRC"), //

	/**
	 * Deprecated, replaced by RSD
	 */
	Serbian_Dinar("CSD"), //

	/**
	 * Cuba (alternative currency)
	 */
	Cuban_Convertible_Peso("CUC"), //

	/**
	 * Cuba
	 */
	Cuban_Peso("CUP"), //

	/**
	 * Cabo Verde (prices normally quoted as integers)
	 */
	Cabo_Verde_Escudo("CVE"), //

	/**
	 * Cyprus. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Cyprus_Pound("CYP"), //

	/**
	 * Czech Republic
	 */
	Czech_Koruna("CZK"), //

	/**
	 * Germany. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Mark("DEM"), //

	/**
	 * Djibouti (prices normally quoted as integers)
	 */
	Djibouti_Franc("DJF"), //

	/**
	 * Denmark, Faroe Islands, Greenland
	 */
	Danish_Krone("DKK"), //

	/**
	 * Dominican Republic
	 */
	Dominican_Peso("DOP"), //

	/**
	 * Algeria
	 */
	Algerian_Dinar("DZD"), //

	/**
	 * Estonia.Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Kroon("EEK"), //

	/**
	 * Egypt
	 */
	Egyptian_Pound("EGP"), //

	/**
	 * Eritrea
	 */
	Nakfa("ERN"), //

	/**
	 * Spain. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 * (prices normally quoted as integers)
	 */
	Peseta("ESP"), //

	/**
	 * Ethiopia
	 */
	Ethiopian_Birr("ETB"), //

	/**
	 * Eurozone: Andorra, Austria, Belgium, Cyprus, Estonia, Finland, France, Fr Guiana, Fr S Territories, Germany,
	 * Greece, Guadeloupe, Holy See (Vatican City), Ireland, Italy, Latvia, Lithuania, Luxembourg, Martinique, Malta,
	 * Mayotte, Monaco, Montenegro, Netherlands, Portugal, R&#233;union, St Barthelemy, St Martin, St Pierre and
	 * Miquelon, San Marino, Slovakia, Slovenia, Spain
	 */
	Euro("EUR"), //

	/**
	 * Finland. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Markka("FIM"), //

	/**
	 * Fiji
	 */
	Fiji_Dollar("FJD"), //

	/**
	 * Falkland Islands (Malvinas)
	 */
	Falkland_Islands_Pound("FKP"), //

	/**
	 * France. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Franc("FRF"), //

	/**
	 * United Kingdom, Isle of Man, Channel Islands, South Georgia, South Sandwich Islands
	 */
	Pound_Sterling("GBP"), //

	/**
	 * Georgia
	 */
	Lari("GEL"), //

	/**
	 * Deprecated, replaced by GHS
	 */
	Ghana_Cedi("GHC"), //

	/**
	 * Ghana
	 */
	Ghana_Cedi_("GHS"), //

	/**
	 * Gibraltar
	 */
	Gibraltar_Pound("GIP"), //

	/**
	 * Gambia
	 */
	Dalasi("GMD"), //

	/**
	 * Guinea (prices normally quoted as integers)
	 */
	Guinea_Franc("GNF"), //

	/**
	 * Greece. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Drachma("GRD"), //

	/**
	 * Guatemala
	 */
	Quetzal("GTQ"), //

	/**
	 * Now replaced by the CFA Franc BCEAO XOF use only for historical prices that pre-date use of the CFA Franc
	 */
	Guinea_Bissau_Peso("GWP"), //

	/**
	 * Guyana (prices normally quoted as integers)
	 */
	Guyana_Dollar("GYD"), //

	/**
	 * Hong Kong
	 */
	Hong_Kong_Dollar("HKD"), //

	/**
	 * Honduras
	 */
	Lempira("HNL"), //

	/**
	 * Croatia
	 */
	Kuna("HRK"), //

	/**
	 * Haiti
	 */
	Gourde("HTG"), //

	/**
	 * Hungary (prices normally quoted as integers)
	 */
	Forint("HUF"), //

	/**
	 * Indonesia (prices normally quoted as integers)
	 */
	Rupiah("IDR"), //

	/**
	 * Ireland. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Punt("IEP"), //

	/**
	 * Israel
	 */
	New_Israeli_Sheqel("ILS"), //

	/**
	 * India, Bhutan (prices normally quoted as integers)
	 */
	Indian_Rupee("INR"), //

	/**
	 * Iraq (prices normally quoted as integers)
	 */
	Iraqi_Dinar("IQD"), //

	/**
	 * Iran (Islamic Republic of) (prices normally quoted as integers)
	 */
	Iranian_Rial("IRR"), //

	/**
	 * Iceland (prices normally quoted as integers)
	 */
	Iceland_Krona("ISK"), //

	/**
	 * italy. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 * (prices normally quoted as integers)
	 */
	Lira("ITL"), //

	/**
	 * Jamaica
	 */
	Jamaican_Dollar("JMD"), //

	/**
	 * Jordan (prices normally quoted with 3 decimal places)
	 */
	Jordanian_Dinar("JOD"), //

	/**
	 * Japan (prices normally quoted as integers)
	 */
	Yen("JPY"), //

	/**
	 * Kenya
	 */
	Kenyan_Shilling("KES"), //

	/**
	 * Kyrgyzstan
	 */
	Som("KGS"), //

	/**
	 * Cambodia
	 */
	Riel("KHR"), //

	/**
	 * Comoros (prices normally quoted as integers)
	 */
	Comoro_Franc("KMF"), //

	/**
	 * Korea (Democratic People&#8217;s Republic of) (prices normally quoted as integers)
	 */
	North_Korean_Won("KPW"), //

	/**
	 * Korea (Republic of) (prices normally quoted as integers)
	 */
	Won("KRW"), //

	/**
	 * Kuwait (prices normally quoted with 3 decimal places)
	 */
	Kuwaiti_Dinar("KWD"), //

	/**
	 * Cayman Islands
	 */
	Cayman_Islands_Dollar("KYD"), //

	/**
	 * Kazakstan
	 */
	Tenge("KZT"), //

	/**
	 * Lao People&#8217;s Democratic Republic (prices normally quoted as integers)
	 */
	Kip("LAK"), //

	/**
	 * Lebanon (prices normally quoted as integers)
	 */
	Lebanese_Pound("LBP"), //

	/**
	 * Sri Lanka
	 */
	Sri_Lanka_Rupee("LKR"), //

	/**
	 * Liberia
	 */
	Liberian_Dollar("LRD"), //

	/**
	 * Lesotho
	 */
	Loti("LSL"), //

	/**
	 * Lithuania. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Litus("LTL"), //

	/**
	 * Luxembourg. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro (prices normally quoted as integers)
	 */
	Luxembourg_Franc("LUF"), //

	/**
	 * Latvia. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Latvian_Lats("LVL"), //

	/**
	 * Libyan Arab Jamahiriya (prices normally quoted with 3 decimal places)
	 */
	Libyan_Dinar("LYD"), //

	/**
	 * Morocco, Western Sahara
	 */
	Moroccan_Dirham("MAD"), //

	/**
	 * Moldova, Republic of
	 */
	Moldovan_Leu("MDL"), //

	/**
	 * Madagascar (prices normally quoted with 0 or 1 decimal place &#8211; 1 iraimbilanja = Ar0.2)
	 */
	Malagasy_Ariary("MGA"), //

	/**
	 * Now replaced by the Ariary (MGA) (prices normally quoted as integers)
	 */
	Malagasy_Franc("MGF"), //

	/**
	 * Macedonia (former Yugoslav Republic of)
	 */
	Denar("MKD"), //

	/**
	 * Myanmar (prices normally quoted as integers)
	 */
	Kyat("MMK"), //

	/**
	 * Mongolia (prices normally quoted as integers)
	 */
	Tugrik("MNT"), //

	/**
	 * Macau
	 */
	Pataca("MOP"), //

	/**
	 * Mauritania (0 or 1 &#8211; 1 khoums = UM0.2)
	 */
	Ouguiya("MRO"), //

	/**
	 * Malta. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the Euro
	 */
	Maltese_Lira("MTL"), //

	/**
	 * Mauritius (prices normally quoted as integers)
	 */
	Mauritius_Rupee("MUR"), //

	/**
	 * Maldives
	 */
	Rufiyaa("MVR"), //

	/**
	 * Malawi
	 */
	Kwacha("MWK"), //

	/**
	 * Mexico
	 */
	Mexican_Peso("MXN"), //

	/**
	 * Malaysia
	 */
	Malaysian_Ringgit("MYR"), //

	/**
	 * Mozambique
	 */
	Mozambique_Metical("MZN"), //

	/**
	 * Namibia
	 */
	Namibia_Dollar("NAD"), //

	/**
	 * Nigeria
	 */
	Naira("NGN"), //

	/**
	 * Nicaragua
	 */
	Cordoba_Oro("NIO"), //

	/**
	 * Netherlands. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Guilder("NLG"), //

	/**
	 * Norway, Bouvet Island, Svalbard and Jan Mayen
	 */
	Norwegian_Krone("NOK"), //

	/**
	 * Nepal
	 */
	Nepalese_Rupee("NPR"), //

	/**
	 * New Zealand, Cook Islands, Niue, Pitcairn, Tokelau
	 */
	New_Zealand_Dollar("NZD"), //

	/**
	 * Oman (prices normally quoted with 3 decimal places)
	 */
	Rial_Omani("OMR"), //

	/**
	 * Panama
	 */
	Balboa("PAB"), //

	/**
	 * Peru
	 */
	Nuevo_Sol("PEN"), //

	/**
	 * Papua New Guinea
	 */
	Kina("PGK"), //

	/**
	 * Philippines
	 */
	Philippine_Peso("PHP"), //

	/**
	 * Pakistan (prices normally quoted as integers)
	 */
	Pakistan_Rupee("PKR"), //

	/**
	 * Poland
	 */
	Zloty("PLN"), //

	/**
	 * Portugal. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Escudo("PTE"), //

	/**
	 * Paraguay (prices normally quoted as integers)
	 */
	Guarani("PYG"), //

	/**
	 * Qatar
	 */
	Qatari_Rial("QAR"), //

	/**
	 * Deprecated, replaced by RON
	 */
	Romanian_Old_Leu("ROL"), //

	/**
	 * Romania
	 */
	Romanian_Leu("RON"), //

	/**
	 * Serbia (prices normally quoted as integers)
	 */
	Serbian_Dinar_("RSD"), //

	/**
	 * Russian Federation
	 */
	Russian_Ruble("RUB"), //

	/**
	 * DEPRECATED, replaced by RUB
	 */
	Russian_Ruble_("RUR"), //

	/**
	 * Rwanda (prices normally quoted as integers)
	 */
	Rwanda_Franc("RWF"), //

	/**
	 * Saudi Arabia
	 */
	Saudi_Riyal("SAR"), //

	/**
	 * Solomon Islands
	 */
	Solomon_Islands_Dollar("SBD"), //

	/**
	 * Seychelles
	 */
	Seychelles_Rupee("SCR"), //

	/**
	 * Now replaced by the Sudanese Pound (SDG)
	 */
	Sudanese_Dinar("SDD"), //

	/**
	 * Sudan
	 */
	Sudanese_Pound("SDG"), //

	/**
	 * Sweden
	 */
	Swedish_Krona("SEK"), //

	/**
	 * Singapore
	 */
	Singapore_Dollar("SGD"), //

	/**
	 * Saint Helena
	 */
	Saint_Helena_Pound("SHP"), //

	/**
	 * Slovenia. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Tolar("SIT"), //

	/**
	 * Slovakia. Now replaced by the Euro (EUR): use only for historical prices that pre-date the introduction of the
	 * Euro
	 */
	Slovak_Koruna("SKK"), //

	/**
	 * Sierra Leone (prices normally quoted as integers)
	 */
	Leone("SLL"), //

	/**
	 * Somalia (prices normally quoted as integers)
	 */
	Somali_Shilling("SOS"), //

	/**
	 * Suriname
	 */
	Surinam_Dollar("SRD"), //

	/**
	 * DEPRECATED, replaced by SRD
	 */
	Suriname_Guilder("SRG"), //

	/**
	 * S&#227;o Tome and Principe (prices normally quoted as integers)
	 */
	Dobra("STD"), //

	/**
	 * El Salvador
	 */
	El_Salvador_Colon("SVC"), //

	/**
	 * Syrian Arab Republic (prices normally quoted as integers)
	 */
	Syrian_Pound("SYP"), //

	/**
	 * Swaziland
	 */
	Lilangeni("SZL"), //

	/**
	 * Thailand
	 */
	Baht("THB"), //

	/**
	 * Tajikistan
	 */
	Somoni("TJS"), //

	/**
	 * Deprecated, replaced by TMT (prices normally quoted as integers)
	 */
	Turkmenistan_Manat("TMM"), //

	/**
	 * Turkmenistan
	 */
	Turkmenistan_New_Manat("TMT"), //

	/**
	 * Tunisia (prices normally quoted with 3 decimal places)
	 */
	Tunisian_Dinar("TND"), //

	/**
	 * Tonga
	 */
	Pa_anga("TOP"), //

	/**
	 * Deprecated. Timor-Leste now uses the US Dollar
	 */
	Timor_Escudo("TPE"), //

	/**
	 * Deprecated, replaced by TRY (prices normally quoted as integers)
	 */
	Turkish_Lira_old("TRL"), //

	/**
	 * Turkey, from 1 January 2005
	 */
	Turkish_Lira("TRY"), //

	/**
	 * Trinidad and Tobago
	 */
	Trinidad_and_Tobago_Dollar("TTD"), //

	/**
	 * Taiwan (Province of China)
	 */
	New_Taiwan_Dollar("TWD"), //

	/**
	 * Tanzania (United Republic of) (prices normally quoted as integers)
	 */
	Tanzanian_Shilling("TZS"), //

	/**
	 * Ukraine
	 */
	Hryvnia("UAH"), //

	/**
	 * Uganda (prices normally quoted as integers)
	 */
	Uganda_Shilling("UGX"), //

	/**
	 * United States, American Samoa, Bonaire, Sint Eustatius and Saba, British Indian Ocean Territory, Ecuador, El
	 * Salvador, Guam, Haiti, Marshall Is, Micronesia (Federated States of), Northern Mariana Is, Palau, Panama, Puerto
	 * Rico, Timor-Leste, Turks and Caicos Is, US Minor Outlying Is, Virgin Is (British), Virgin Is (US)
	 */
	US_Dollar("USD"), //

	/**
	 * Uruguay
	 */
	Peso_Uruguayo("UYU"), //

	/**
	 * Uzbekistan (prices normally quoted as integers)
	 */
	Uzbekistan_Sum("UZS"), //

	/**
	 * Deprecated, replaced by VEF
	 */
	Bolivar("VEB"), //

	/**
	 * Venezuela
	 */
	Bolivar_fuerte("VEF"), //

	/**
	 * Viet Nam (prices normally quoted as integers)
	 */
	Dong("VND"), //

	/**
	 * Vanuatu (prices normally quoted as integers)
	 */
	Vatu("VUV"), //

	/**
	 * Samoa
	 */
	Tala("WST"), //

	/**
	 * Cameroon, Central African Republic, Chad, Congo, Equatorial Guinea, Gabon (prices normally quoted as integers)
	 */
	CFA_Franc_BEAC("XAF"), //

	/**
	 * Anguilla, Antigua and Barbuda, Dominica, Grenada, Montserrat, Saint Kitts and Nevis, Saint Lucia, Saint Vincent
	 * and the Grenadines
	 */
	East_Caribbean_Dollar("XCD"), //

	/**
	 * Benin, Burkina Faso, C&#244;te D&#8217;Ivoire, Guinea-Bissau, Mali, Niger, Senegal, Togo (prices normally quoted
	 * as integers)
	 */
	CFA_Franc_BCEAO("XOF"), //

	/**
	 * French Polynesia, New Caledonia, Wallis and Futuna (prices normally quoted as integers)
	 */
	CFP_Franc("XPF"), //

	/**
	 * Yemen (prices normally quoted as integers)
	 */
	Yemeni_Rial("YER"), //

	/**
	 * DEPRECATED, replaced by CSD
	 */
	Yugoslavian_Dinar("YUM"), //

	/**
	 * South Africa, Namibia, Lesotho
	 */
	Rand("ZAR"), //

	/**
	 * Zambia. Deprecated, replaced with ZMW (prices normally quoted as integers)
	 */
	Kwacha_("ZMK"), //

	/**
	 * Zambia
	 */
	Zambian_Kwacha("ZMW"), //

	/**
	 * Deprecated, replaced with ZWL (prices normally quoted as integers)
	 */
	Zimbabwe_Dollar("ZWD"), //

	/**
	 * Zimbabwe
	 */
	Zimbabwe_Dollar_("ZWL");

	public final String value;

	private CurrencyCodes(String value)
	{
		this.value = value;
	}

	private static Map<String, CurrencyCodes> map;

	private static Map<String, CurrencyCodes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (CurrencyCodes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static CurrencyCodes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
