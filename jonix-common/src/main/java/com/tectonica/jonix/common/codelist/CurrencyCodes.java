/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 96 (Currency code - based on ISO 4217)
 */
interface CodeList96 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 96</b>
 * <p>
 * Description: Currency code - based on ISO 4217
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist96">ONIX
 *      Codelist 96 in Reference Guide</a>
 */
public enum CurrencyCodes implements OnixCodelist, CodeList96 {
    /**
     * United Arab Emirates
     */
    UAE_Dirham("AED", "UAE Dirham"),

    /**
     * Afghanistan. Deprecated, replaced by AFN
     */
    Afghani("AFA", "Afghani"),

    /**
     * Afghanistan (prices normally quoted as integers)
     */
    Afghani_("AFN", "Afghani"),

    /**
     * Albania (prices normally quoted as integers)
     */
    Lek("ALL", "Lek"),

    /**
     * Armenia (prices normally quoted as integers)
     */
    Armenian_Dram("AMD", "Armenian Dram"),

    /**
     * Cura&#231;ao, Sint Maarten
     */
    Netherlands_Antillian_Guilder("ANG", "Netherlands Antillian Guilder"),

    /**
     * Angola
     */
    Kwanza("AOA", "Kwanza"),

    /**
     * Argentina
     */
    Argentine_Peso("ARS", "Argentine Peso"),

    /**
     * Austria. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Schilling("ATS", "Schilling"),

    /**
     * Australia, Christmas Island, Cocos (Keeling) Islands, Heard Island and McDonald Islands, Kiribati, Nauru, Norfolk
     * Island, Tuvalu
     */
    Australian_Dollar("AUD", "Australian Dollar"),

    /**
     * Aruba
     */
    Aruban_Florin("AWG", "Aruban Florin"),

    /**
     * Azerbaijan
     */
    Azerbaijan_Manat("AZN", "Azerbaijan Manat"),

    /**
     * Bosnia and Herzegovina
     */
    Convertible_Marks("BAM", "Convertible Marks"),

    /**
     * Barbados
     */
    Barbados_Dollar("BBD", "Barbados Dollar"),

    /**
     * Bangladesh
     */
    Taka("BDT", "Taka"),

    /**
     * Belgium. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Belgian_Franc("BEF", "Belgian Franc"),

    /**
     * Deprecated, replaced by BGN
     */
    Bulgarian_Lev("BGL", "Bulgarian Lev"),

    /**
     * Bulgaria
     */
    Bulgarian_Lev_("BGN", "Bulgarian Lev"),

    /**
     * Bahrain (prices normally quoted with 3 decimal places)
     */
    Bahraini_Dinar("BHD", "Bahraini Dinar"),

    /**
     * Burundi (prices normally quoted as integers)
     */
    Burundi_Franc("BIF", "Burundi Franc"),

    /**
     * Bermuda
     */
    Bermudian_Dollar("BMD", "Bermudian Dollar"),

    /**
     * Brunei Darussalam
     */
    Brunei_Dollar("BND", "Brunei Dollar"),

    /**
     * Bolivia
     */
    Boliviano("BOB", "Boliviano"),

    /**
     * Brazil
     */
    Brazilian_Real("BRL", "Brazilian Real"),

    /**
     * Bahamas
     */
    Bahamian_Dollar("BSD", "Bahamian Dollar"),

    /**
     * Bhutan
     */
    Ngultrun("BTN", "Ngultrun"),

    /**
     * Botswana
     */
    Pula("BWP", "Pula"),

    /**
     * Belarus (prices normally quoted as integers). Deprecated - now replaced by new Belarussian Ruble (BYN): use only
     * for historical prices that pre-date the introduction of the new Belarussian Ruble
     */
    _Old("BYR", "(Old) Belarussian Ruble"),

    /**
     * Belarus
     */
    Belarussian_Ruble("BYN", "Belarussian Ruble"),

    /**
     * Belize
     */
    Belize_Dollar("BZD", "Belize Dollar"),

    /**
     * Canada
     */
    Canadian_Dollar("CAD", "Canadian Dollar"),

    /**
     * Congo (Democratic Republic of the)
     */
    Franc_Congolais("CDF", "Franc Congolais"),

    /**
     * Switzerland, Liechtenstein
     */
    Swiss_Franc("CHF", "Swiss Franc"),

    /**
     * Chile (prices normally quoted as integers)
     */
    Chilean_Peso("CLP", "Chilean Peso"),

    /**
     * China
     */
    Yuan_Renminbi("CNY", "Yuan Renminbi"),

    /**
     * Colombia (prices normally quoted as integers)
     */
    Colombian_Peso("COP", "Colombian Peso"),

    /**
     * Costa Rica (prices normally quoted as integers)
     */
    Costa_Rican_Colon("CRC", "Costa Rican Colon"),

    /**
     * Deprecated, replaced by RSD
     */
    Serbian_Dinar("CSD", "Serbian Dinar"),

    /**
     * Cuba (alternative currency)
     */
    Cuban_Convertible_Peso("CUC", "Cuban Convertible Peso"),

    /**
     * Cuba
     */
    Cuban_Peso("CUP", "Cuban Peso"),

    /**
     * Cabo Verde (prices normally quoted as integers)
     */
    Cabo_Verde_Escudo("CVE", "Cabo Verde Escudo"),

    /**
     * Cyprus. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Cyprus_Pound("CYP", "Cyprus Pound"),

    /**
     * Czechia
     */
    Czech_Koruna("CZK", "Czech Koruna"),

    /**
     * Germany. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Mark("DEM", "Mark"),

    /**
     * Djibouti (prices normally quoted as integers)
     */
    Djibouti_Franc("DJF", "Djibouti Franc"),

    /**
     * Denmark, Faroe Islands, Greenland
     */
    Danish_Krone("DKK", "Danish Krone"),

    /**
     * Dominican Republic
     */
    Dominican_Peso("DOP", "Dominican Peso"),

    /**
     * Algeria
     */
    Algerian_Dinar("DZD", "Algerian Dinar"),

    /**
     * Estonia.Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Kroon("EEK", "Kroon"),

    /**
     * Egypt
     */
    Egyptian_Pound("EGP", "Egyptian Pound"),

    /**
     * Eritrea
     */
    Nakfa("ERN", "Nakfa"),

    /**
     * Spain. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the introduction
     * of the Euro (prices normally quoted as integers)
     */
    Peseta("ESP", "Peseta"),

    /**
     * Ethiopia
     */
    Ethiopian_Birr("ETB", "Ethiopian Birr"),

    /**
     * Eurozone: Andorra, Austria, Belgium, Croatia, Cyprus, Estonia, Finland, France, Fr Guiana, Fr S Territories,
     * Germany, Greece, Guadeloupe, Holy See (Vatican City), Ireland, Italy, Latvia, Lithuania, Luxembourg, Martinique,
     * Malta, Mayotte, Monaco, Montenegro, Netherlands, Portugal, R&#233;union, St Barthelemy, St Martin, St Pierre and
     * Miquelon, San Marino, Slovakia, Slovenia, Spain
     */
    Euro("EUR", "Euro"),

    /**
     * Finland. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Markka("FIM", "Markka"),

    /**
     * Fiji
     */
    Fiji_Dollar("FJD", "Fiji Dollar"),

    /**
     * Falkland Islands (Malvinas)
     */
    Falkland_Islands_Pound("FKP", "Falkland Islands Pound"),

    /**
     * France. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Franc("FRF", "Franc"),

    /**
     * United Kingdom, Isle of Man, Channel Islands, South Georgia, South Sandwich Islands, British Indian Ocean
     * Territory (de jure)
     */
    Pound_Sterling("GBP", "Pound Sterling"),

    /**
     * Georgia
     */
    Lari("GEL", "Lari"),

    /**
     * Deprecated, replaced by GHS
     */
    Ghana_Cedi("GHC", "Ghana Cedi"),

    /**
     * Ghana
     */
    Ghana_Cedi_("GHS", "Ghana Cedi"),

    /**
     * Gibraltar
     */
    Gibraltar_Pound("GIP", "Gibraltar Pound"),

    /**
     * Gambia
     */
    Dalasi("GMD", "Dalasi"),

    /**
     * Guinea (prices normally quoted as integers)
     */
    Guinean_Franc("GNF", "Guinean Franc"),

    /**
     * Greece. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Drachma("GRD", "Drachma"),

    /**
     * Guatemala
     */
    Quetzal("GTQ", "Quetzal"),

    /**
     * Now replaced by the CFA Franc BCEAO XOF use only for historical prices that pre-date use of the CFA Franc
     */
    Guinea_Bissau_Peso("GWP", "Guinea-Bissau Peso"),

    /**
     * Guyana (prices normally quoted as integers)
     */
    Guyana_Dollar("GYD", "Guyana Dollar"),

    /**
     * Hong Kong
     */
    Hong_Kong_Dollar("HKD", "Hong Kong Dollar"),

    /**
     * Honduras
     */
    Lempira("HNL", "Lempira"),

    /**
     * Croatia. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Kuna("HRK", "Kuna"),

    /**
     * Haiti
     */
    Gourde("HTG", "Gourde"),

    /**
     * Hungary (prices normally quoted as integers)
     */
    Forint("HUF", "Forint"),

    /**
     * Indonesia (prices normally quoted as integers)
     */
    Rupiah("IDR", "Rupiah"),

    /**
     * Ireland. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Punt("IEP", "Punt"),

    /**
     * Israel
     */
    New_Israeli_Sheqel("ILS", "New Israeli Sheqel"),

    /**
     * India, Bhutan (prices normally quoted as integers)
     */
    Indian_Rupee("INR", "Indian Rupee"),

    /**
     * Iraq (prices normally quoted as integers)
     */
    Iraqi_Dinar("IQD", "Iraqi Dinar"),

    /**
     * Iran (Islamic Republic of) (prices normally quoted as integers)
     */
    Iranian_Rial("IRR", "Iranian Rial"),

    /**
     * Iceland (prices normally quoted as integers)
     */
    Iceland_Krona("ISK", "Iceland Krona"),

    /**
     * Italy. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the introduction
     * of the Euro (prices normally quoted as integers)
     */
    Lira("ITL", "Lira"),

    /**
     * Jamaica
     */
    Jamaican_Dollar("JMD", "Jamaican Dollar"),

    /**
     * Jordan (prices normally quoted with 3 decimal places)
     */
    Jordanian_Dinar("JOD", "Jordanian Dinar"),

    /**
     * Japan (prices normally quoted as integers)
     */
    Yen("JPY", "Yen"),

    /**
     * Kenya
     */
    Kenyan_Shilling("KES", "Kenyan Shilling"),

    /**
     * Kyrgyzstan
     */
    Som("KGS", "Som"),

    /**
     * Cambodia
     */
    Riel("KHR", "Riel"),

    /**
     * Comoros (prices normally quoted as integers)
     */
    Comorian_Franc("KMF", "Comorian Franc"),

    /**
     * Korea (Democratic People's Republic of) (prices normally quoted as integers)
     */
    North_Korean_Won("KPW", "North Korean Won"),

    /**
     * Korea (Republic of) (prices normally quoted as integers)
     */
    Won("KRW", "Won"),

    /**
     * Kuwait (prices normally quoted with 3 decimal places)
     */
    Kuwaiti_Dinar("KWD", "Kuwaiti Dinar"),

    /**
     * Cayman Islands
     */
    Cayman_Islands_Dollar("KYD", "Cayman Islands Dollar"),

    /**
     * Kazakstan
     */
    Tenge("KZT", "Tenge"),

    /**
     * Lao People's Democratic Republic (prices normally quoted as integers)
     */
    Lao_Kip("LAK", "Lao Kip"),

    /**
     * Lebanon (prices normally quoted as integers)
     */
    Lebanese_Pound("LBP", "Lebanese Pound"),

    /**
     * Sri Lanka
     */
    Sri_Lanka_Rupee("LKR", "Sri Lanka Rupee"),

    /**
     * Liberia
     */
    Liberian_Dollar("LRD", "Liberian Dollar"),

    /**
     * Lesotho
     */
    Loti("LSL", "Loti"),

    /**
     * Lithuania. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Litus("LTL", "Litus"),

    /**
     * Luxembourg. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro (prices normally quoted as integers)
     */
    Luxembourg_Franc("LUF", "Luxembourg Franc"),

    /**
     * Latvia. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Latvian_Lats("LVL", "Latvian Lats"),

    /**
     * Libyan Arab Jamahiriya (prices normally quoted with 3 decimal places)
     */
    Libyan_Dinar("LYD", "Libyan Dinar"),

    /**
     * Morocco, Western Sahara
     */
    Moroccan_Dirham("MAD", "Moroccan Dirham"),

    /**
     * Moldova, Republic of
     */
    Moldovan_Leu("MDL", "Moldovan Leu"),

    /**
     * Madagascar (prices normally quoted with 0 or 1 decimal place - 1 iraimbilanja = Ar0.2)
     */
    Malagasy_Ariary("MGA", "Malagasy Ariary"),

    /**
     * Now replaced by the Ariary (MGA) (prices normally quoted as integers)
     */
    Malagasy_Franc("MGF", "Malagasy Franc"),

    /**
     * North Macedonia (formerly FYR Macedonia)
     */
    Denar("MKD", "Denar"),

    /**
     * Myanmar (prices normally quoted as integers)
     */
    Kyat("MMK", "Kyat"),

    /**
     * Mongolia (prices normally quoted as integers)
     */
    Tugrik("MNT", "Tugrik"),

    /**
     * Macau
     */
    Pataca("MOP", "Pataca"),

    /**
     * Mauritania (prices normally quoted with 0 or 1 decimal place - 1 khoums = UM0.2). Was interchangeable with MRU
     * (New) Ouguiya at rate of 10:1 until June 2018. Deprecated, use MRU instead
     */
    _Old_("MRO", "(Old) Ouguiya"),

    /**
     * Mauritania (prices normally quoted with 0 or 1 decimal place - 1 khoums = UM0.2). Replaced MRO (old) Ouguiya at
     * rate of 10:1 in June 2018. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Ouguiya("MRU", "Ouguiya"),

    /**
     * Malta. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the introduction
     * of the Euro
     */
    Maltese_Lira("MTL", "Maltese Lira"),

    /**
     * Mauritius (prices normally quoted as integers)
     */
    Mauritius_Rupee("MUR", "Mauritius Rupee"),

    /**
     * Maldives
     */
    Rufiyaa("MVR", "Rufiyaa"),

    /**
     * Malawi
     */
    Malawi_Kwacha("MWK", "Malawi Kwacha"),

    /**
     * Mexico
     */
    Mexican_Peso("MXN", "Mexican Peso"),

    /**
     * Malaysia
     */
    Malaysian_Ringgit("MYR", "Malaysian Ringgit"),

    /**
     * Mozambique
     */
    Mozambique_Metical("MZN", "Mozambique Metical"),

    /**
     * Namibia
     */
    Namibia_Dollar("NAD", "Namibia Dollar"),

    /**
     * Nigeria
     */
    Naira("NGN", "Naira"),

    /**
     * Nicaragua
     */
    Cordoba_Oro("NIO", "Cordoba Oro"),

    /**
     * Netherlands. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Guilder("NLG", "Guilder"),

    /**
     * Norway, Bouvet Island, Svalbard and Jan Mayen
     */
    Norwegian_Krone("NOK", "Norwegian Krone"),

    /**
     * Nepal
     */
    Nepalese_Rupee("NPR", "Nepalese Rupee"),

    /**
     * New Zealand, Cook Islands, Niue, Pitcairn, Tokelau
     */
    New_Zealand_Dollar("NZD", "New Zealand Dollar"),

    /**
     * Oman (prices normally quoted with 3 decimal places)
     */
    Rial_Omani("OMR", "Rial Omani"),

    /**
     * Panama
     */
    Balboa("PAB", "Balboa"),

    /**
     * Peru (formerly Nuevo Sol)
     */
    Sol("PEN", "Sol"),

    /**
     * Papua New Guinea
     */
    Kina("PGK", "Kina"),

    /**
     * Philippines
     */
    Philippine_Peso("PHP", "Philippine Peso"),

    /**
     * Pakistan (prices normally quoted as integers)
     */
    Pakistan_Rupee("PKR", "Pakistan Rupee"),

    /**
     * Poland
     */
    Zoty("PLN", "Złoty"),

    /**
     * Portugal. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Escudo("PTE", "Escudo"),

    /**
     * Paraguay (prices normally quoted as integers)
     */
    Guarani("PYG", "Guarani"),

    /**
     * Qatar
     */
    Qatari_Rial("QAR", "Qatari Rial"),

    /**
     * Deprecated, replaced by RON
     */
    Romanian_Old_Leu("ROL", "Romanian Old Leu"),

    /**
     * Romania
     */
    Romanian_Leu("RON", "Romanian Leu"),

    /**
     * Serbia (prices normally quoted as integers)
     */
    Serbian_Dinar_("RSD", "Serbian Dinar"),

    /**
     * Russian Federation
     */
    Russian_Ruble("RUB", "Russian Ruble"),

    /**
     * Deprecated, replaced by RUB
     */
    Russian_Ruble_("RUR", "Russian Ruble"),

    /**
     * Rwanda (prices normally quoted as integers)
     */
    Rwanda_Franc("RWF", "Rwanda Franc"),

    /**
     * Saudi Arabia
     */
    Saudi_Riyal("SAR", "Saudi Riyal"),

    /**
     * Solomon Islands
     */
    Solomon_Islands_Dollar("SBD", "Solomon Islands Dollar"),

    /**
     * Seychelles
     */
    Seychelles_Rupee("SCR", "Seychelles Rupee"),

    /**
     * Now replaced by the Sudanese Pound (SDG)
     */
    Sudanese_Dinar("SDD", "Sudanese Dinar"),

    /**
     * Sudan
     */
    Sudanese_Pound("SDG", "Sudanese Pound"),

    /**
     * Sweden
     */
    Swedish_Krona("SEK", "Swedish Krona"),

    /**
     * Singapore
     */
    Singapore_Dollar("SGD", "Singapore Dollar"),

    /**
     * Saint Helena
     */
    Saint_Helena_Pound("SHP", "Saint Helena Pound"),

    /**
     * Slovenia. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Tolar("SIT", "Tolar"),

    /**
     * Slovakia. Now replaced by the Euro (EUR). Deprecated - use only for historical prices that pre-date the
     * introduction of the Euro
     */
    Slovak_Koruna("SKK", "Slovak Koruna"),

    /**
     * Sierra Leone (from April 2022). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Leone("SLE", "Leone"),

    /**
     * Sierra Leone (prices normally quoted as integers). Deprecated - gradually replaced by SLE from April 2022, but
     * SLL Leone still usable until December 2023 (SLE is a redenomination of the Leone by a factor of 1,000)
     */
    Leone_("SLL", "Leone"),

    /**
     * Somalia (prices normally quoted as integers)
     */
    Somali_Shilling("SOS", "Somali Shilling"),

    /**
     * Suriname
     */
    Surinam_Dollar("SRD", "Surinam Dollar"),

    /**
     * DEPRECATED, replaced by SRD
     */
    Suriname_Guilder("SRG", "Suriname Guilder"),

    /**
     * S&#227;o Tome and Principe (prices normally quoted as integers). Was interchangeable with STN (New) Dobra at rate
     * of 1000:1 until June 2018. Deprecated, use STN instead
     */
    _Old__("STD", "(Old) Dobra"),

    /**
     * S&#227;o Tome and Principe. Replaced STD (old) Dobra at rate of 1000:1 in June 2018. Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Dobra("STN", "Dobra"),

    /**
     * El Salvador
     */
    El_Salvador_Colon("SVC", "El Salvador Colon"),

    /**
     * Syrian Arab Republic (prices normally quoted as integers)
     */
    Syrian_Pound("SYP", "Syrian Pound"),

    /**
     * Eswatini (formerly known as Swaziland)
     */
    Lilangeni("SZL", "Lilangeni"),

    /**
     * Thailand
     */
    Baht("THB", "Baht"),

    /**
     * Tajikistan
     */
    Somoni("TJS", "Somoni"),

    /**
     * Deprecated, replaced by TMT (prices normally quoted as integers)
     */
    Turkmenistan_Manat("TMM", "Turkmenistan Manat"),

    /**
     * Turkmenistan
     */
    Turkmenistan_New_Manat("TMT", "Turkmenistan New Manat"),

    /**
     * Tunisia (prices normally quoted with 3 decimal places)
     */
    Tunisian_Dinar("TND", "Tunisian Dinar"),

    /**
     * Tonga
     */
    Paanga("TOP", "Pa’anga"),

    /**
     * Deprecated. Timor-Leste now uses the US Dollar
     */
    Timor_Escudo("TPE", "Timor Escudo"),

    /**
     * Deprecated, replaced by TRY (prices normally quoted as integers)
     */
    Turkish_Lira_old("TRL", "Turkish Lira (old)"),

    /**
     * T&#252;rkiye, from 1 January 2005
     */
    Turkish_Lira("TRY", "Turkish Lira"),

    /**
     * Trinidad and Tobago
     */
    Trinidad_and_Tobago_Dollar("TTD", "Trinidad and Tobago Dollar"),

    /**
     * Taiwan (Province of China)
     */
    New_Taiwan_Dollar("TWD", "New Taiwan Dollar"),

    /**
     * Tanzania (United Republic of) (prices normally quoted as integers)
     */
    Tanzanian_Shilling("TZS", "Tanzanian Shilling"),

    /**
     * Ukraine
     */
    Hryvnia("UAH", "Hryvnia"),

    /**
     * Uganda (prices normally quoted as integers)
     */
    Uganda_Shilling("UGX", "Uganda Shilling"),

    /**
     * United States, American Samoa, Bonaire, Sint Eustatius and Saba, British Indian Ocean Territory, Ecuador, El
     * Salvador, Guam, Haiti, Marshall Is, Micronesia (Federated States of), Northern Mariana Is, Palau, Panama, Puerto
     * Rico, Timor-Leste, Turks and Caicos Is, US Minor Outlying Is, Virgin Is (British), Virgin Is (US)
     */
    US_Dollar("USD", "US Dollar"),

    /**
     * Uruguay
     */
    Peso_Uruguayo("UYU", "Peso Uruguayo"),

    /**
     * Uzbekistan (prices normally quoted as integers)
     */
    Uzbekistan_Sum("UZS", "Uzbekistan Sum"),

    /**
     * Deprecated, replaced by VEF
     */
    Bolivar("VEB", "Bolívar"),

    /**
     * Venezuela (formerly Bol&#237;var fuerte). Deprecated, replaced by VES
     */
    Bolivar_("VEF", "Bolívar"),

    /**
     * Venezuela (replaced VEF from August 2018 at rate of 100,000:1, and was redenominated by a further factor of
     * 1,000,000:1 in late 2021). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Bolivar_Soberano("VES", "Bolívar Soberano"),

    /**
     * Viet Nam (prices normally quoted as integers)
     */
    Dong("VND", "Dong"),

    /**
     * Vanuatu (prices normally quoted as integers)
     */
    Vatu("VUV", "Vatu"),

    /**
     * Samoa
     */
    Tala("WST", "Tala"),

    /**
     * Cameroon, Central African Republic, Chad, Congo, Equatorial Guinea, Gabon (prices normally quoted as integers)
     */
    CFA_Franc_BEAC("XAF", "CFA Franc BEAC"),

    /**
     * Anguilla, Antigua and Barbuda, Dominica, Grenada, Montserrat, Saint Kitts and Nevis, Saint Lucia, Saint Vincent
     * and the Grenadines
     */
    East_Caribbean_Dollar("XCD", "East Caribbean Dollar"),

    /**
     * Benin, Burkina Faso, C&#244;te D'Ivoire, Guinea-Bissau, Mali, Niger, Senegal, Togo (prices normally quoted as
     * integers)
     */
    CFA_Franc_BCEAO("XOF", "CFA Franc BCEAO"),

    /**
     * French Polynesia, New Caledonia, Wallis and Futuna (prices normally quoted as integers)
     */
    CFP_Franc("XPF", "CFP Franc"),

    /**
     * Yemen (prices normally quoted as integers)
     */
    Yemeni_Rial("YER", "Yemeni Rial"),

    /**
     * Deprecated, replaced by CSD
     */
    Yugoslavian_Dinar("YUM", "Yugoslavian Dinar"),

    /**
     * South Africa, Namibia, Lesotho
     */
    Rand("ZAR", "Rand"),

    /**
     * Zambia. Deprecated, replaced with ZMW (prices normally quoted as integers)
     */
    Kwacha("ZMK", "Kwacha"),

    /**
     * Zambia
     */
    Zambian_Kwacha("ZMW", "Zambian Kwacha"),

    /**
     * Deprecated, replaced with ZWL (prices normally quoted as integers)
     */
    Zimbabwe_Dollar("ZWD", "Zimbabwe Dollar"),

    /**
     * Zimbabwe. Also known as ZiG. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Zimbabwe_Gold("ZWG", "Zimbabwe Gold"),

    /**
     * Deprecated, replaced by ZWG
     */
    Zimbabwe_Dollar_("ZWL", "Zimbabwe Dollar");

    public final String code;
    public final String description;

    CurrencyCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, CurrencyCodes> map;

    private static Map<String, CurrencyCodes> map() {
        Map<String, CurrencyCodes> result = map;
        if (result == null) {
            synchronized (CurrencyCodes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (CurrencyCodes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static CurrencyCodes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<CurrencyCodes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
