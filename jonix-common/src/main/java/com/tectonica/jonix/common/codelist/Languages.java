/*
 * Copyright (C) 2012-2023 Zach Melamed
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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 74 (Language - based on ISO 639-2/B)
 */
interface CodeList74 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 74</b>
 * <p>
 * Description: Language - based on ISO 639-2/B
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist74">ONIX
 *      Codelist 74 in Reference Guide</a>
 */
public enum Languages implements OnixCodelist, CodeList74 {
    Abkhazian("abk", "Abkhazian"),

    Achinese("ace", "Achinese"),

    Acoli("ach", "Acoli"),

    Adangme("ada", "Adangme"),

    /**
     * (West Circassian)
     */
    Adygei_Adyghe("ady", "Adygei; Adyghe"),

    Afar("aar", "Afar"),

    /**
     * Artificial language
     */
    Afrihili("afh", "Afrihili"),

    Afrikaans("afr", "Afrikaans"),

    /**
     * Collective name
     */
    Afro_Asiatic_languages("afa", "Afro-Asiatic languages"),

    Ainu("ain", "Ainu"),

    /**
     * Macrolanguage
     */
    Akan("aka", "Akan"),

    Akkadian("akk", "Akkadian"),

    /**
     * Macrolanguage
     */
    Albanian("alb", "Albanian"),

    Aleut("ale", "Aleut"),

    /**
     * Collective name
     */
    Algonquian_languages("alg", "Algonquian languages"),

    /**
     * Collective name
     */
    Altaic_languages("tut", "Altaic languages"),

    Amharic("amh", "Amharic"),

    Angika("anp", "Angika"),

    /**
     * Collective name
     */
    Apache_languages("apa", "Apache languages"),

    /**
     * Macrolanguage
     */
    Arabic("ara", "Arabic"),

    Aragonese("arg", "Aragonese"),

    /**
     * ONIX local code, distinct dialect of Occitan (not distinguished from oci by ISO 639-3)
     */
    Aranes("qar", "Aranés"),

    Arapaho("arp", "Arapaho"),

    Arawak("arw", "Arawak"),

    Armenian("arm", "Armenian"),

    Aromanian_Arumanian_Macedo_Romanian("rup", "Aromanian; Arumanian; Macedo-Romanian"),

    /**
     * Collective name
     */
    Artificial_languages("art", "Artificial languages"),

    Assamese("asm", "Assamese"),

    Asturian_Bable_Leonese_Asturleonese("ast", "Asturian; Bable; Leonese; Asturleonese"),

    /**
     * Collective name
     */
    Athapascan_languages("ath", "Athapascan languages"),

    /**
     * Collective name
     */
    Australian_languages("aus", "Australian languages"),

    /**
     * Collective name. ONIX local code, equivalent of aav in ISO 639-5. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Austro_Asiatic_languages("aav", "Austro-Asiatic languages"),

    /**
     * Collective name
     */
    Austronesian_languages("map", "Austronesian languages"),

    Avaric("ava", "Avaric"),

    Avestan("ave", "Avestan"),

    Awadhi("awa", "Awadhi"),

    /**
     * Macrolanguage
     */
    Aymara("aym", "Aymara"),

    /**
     * Macrolanguage
     */
    Azerbaijani("aze", "Azerbaijani"),

    Balinese("ban", "Balinese"),

    /**
     * Collective name
     */
    Baltic_languages("bat", "Baltic languages"),

    /**
     * Macrolanguage
     */
    Baluchi("bal", "Baluchi"),

    Bambara("bam", "Bambara"),

    /**
     * Collective name
     */
    Bamileke_languages("bai", "Bamileke languages"),

    /**
     * Collective name
     */
    Banda_languages("bad", "Banda languages"),

    /**
     * Collective name
     */
    Bantu_languages("bnt", "Bantu languages"),

    Basa("bas", "Basa"),

    Bashkir("bak", "Bashkir"),

    Basque("baq", "Basque"),

    /**
     * Collective name
     */
    Batak_languages("btk", "Batak languages"),

    Beja_Bedawiyet("bej", "Beja; Bedawiyet"),

    Belarusian("bel", "Belarusian"),

    Bemba("bem", "Bemba"),

    Bengali("ben", "Bengali"),

    /**
     * Collective name
     */
    Berber_languages("ber", "Berber languages"),

    Bhojpuri("bho", "Bhojpuri"),

    /**
     * Collective name
     */
    Bihari_languages("bih", "Bihari languages"),

    /**
     * Macrolanguage
     */
    Bikol("bik", "Bikol"),

    Bini_Edo("bin", "Bini; Edo"),

    Bislama("bis", "Bislama"),

    Blin_Bilin("byn", "Blin; Bilin"),

    /**
     * Artificial language
     */
    Blissymbols_Blissymbolics_Bliss("zbl", "Blissymbols; Blissymbolics; Bliss"),

    /**
     * Boro. ONIX local code, equivalent to brx in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Bodo_India("brx", "Bodo (India)"),

    Bosnian("bos", "Bosnian"),

    Braj("bra", "Braj"),

    Breton("bre", "Breton"),

    Buginese("bug", "Buginese"),

    Bulgarian("bul", "Bulgarian"),

    /**
     * ONIX local code, equivalent to bum in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Bulu_Cameroon("bum", "Bulu (Cameroon)"),

    /**
     * Macrolanguage
     */
    Buriat("bua", "Buriat"),

    Burmese("bur", "Burmese"),

    Caddo("cad", "Caddo"),

    /**
     * ONIX local code for Sardinian dialect, equivalent to sro in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Campidanese("sro", "Campidanese"),

    /**
     * ONIX local code, equivalent to yue in ISO 639-3
     */
    Cantonese("yue", "Cantonese"),

    Catalan("cat", "Catalan"),

    /**
     * Collective name
     */
    Caucasian_languages("cau", "Caucasian languages"),

    Cebuano("ceb", "Cebuano"),

    /**
     * Collective name
     */
    Celtic_languages("cel", "Celtic languages"),

    /**
     * Collective name
     */
    Central_American_Indian_languages("cai", "Central American Indian languages"),

    /**
     * ONIX local code, equivalent to tzm in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Central_Atlas_Tamazight("tzm", "Central Atlas Tamazight"),

    Central_Khmer("khm", "Central Khmer"),

    /**
     * ONIX local code, equivalent to ckb in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Central_Kurdish_Sorani("ckb", "Central Kurdish (Sorani)"),

    Chagatai("chg", "Chagatai"),

    /**
     * Collective name
     */
    Chamic_languages("cmc", "Chamic languages"),

    Chamorro("cha", "Chamorro"),

    Chechen("che", "Chechen"),

    Cherokee("chr", "Cherokee"),

    Cheyenne("chy", "Cheyenne"),

    Chibcha("chb", "Chibcha"),

    Chichewa_Chewa_Nyanja("nya", "Chichewa; Chewa; Nyanja"),

    /**
     * ONIX local code, equivalent to cic in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Chickasaw("cic", "Chickasaw"),

    /**
     * Macrolanguage
     */
    Chinese("chi", "Chinese"),

    Chinook_jargon("chn", "Chinook jargon"),

    Chipewyan_Dene_Suline("chp", "Chipewyan; Dene Suline"),

    Choctaw("cho", "Choctaw"),

    Church_Slavic_Old_Slavonic_Church_Slavonic_Old_Bulgarian_Old_Church_Slavonic("chu",
        "Church Slavic; Old Slavonic; Church Slavonic; Old Bulgarian; Old Church Slavonic"),

    Chuukese_Truk("chk", "Chuukese (Truk)"),

    Chuvash("chv", "Chuvash"),

    Classical_Newari_Old_Newari_Classical_Nepal_Bhasa("nwc", "Classical Newari; Old Newari; Classical Nepal Bhasa"),

    Classical_Syriac("syc", "Classical Syriac"),

    Coptic("cop", "Coptic"),

    Cornish("cor", "Cornish"),

    Corsican("cos", "Corsican"),

    /**
     * Macrolanguage
     */
    Cree("cre", "Cree"),

    Creek("mus", "Creek"),

    /**
     * Collective name
     */
    Creoles_and_pidgins("crp", "Creoles and pidgins"),

    /**
     * Collective name
     */
    Creoles_and_pidgins_English_based("cpe", "Creoles and pidgins, English-based"),

    /**
     * Collective name
     */
    Creoles_and_pidgins_French_based("cpf", "Creoles and pidgins, French-based"),

    /**
     * Collective name
     */
    Creoles_and_pidgins_Portuguese_based("cpp", "Creoles and pidgins, Portuguese-based"),

    Crimean_Turkish_Crimean_Tatar("crh", "Crimean Turkish; Crimean Tatar"),

    Croatian("hrv", "Croatian"),

    /**
     * DEPRECATED - use hrv
     */
    Croatian_("scr", "Croatian"),

    /**
     * Collective name
     */
    Cushitic_languages("cus", "Cushitic languages"),

    Czech("cze", "Czech"),

    Dakota("dak", "Dakota"),

    Danish("dan", "Danish"),

    Dargwa("dar", "Dargwa"),

    /**
     * ONIX local code, equivalent to prs in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Dari_Afghan_Persian("prs", "Dari; Afghan Persian"),

    /**
     * Macrolanguage
     */
    Delaware("del", "Delaware"),

    /**
     * Macrolanguage
     */
    Dinka("din", "Dinka"),

    Divehi_Dhivehi_Maldivian("div", "Divehi; Dhivehi; Maldivian"),

    /**
     * Macrolanguage
     */
    Dogri("doi", "Dogri"),

    Dogrib("dgr", "Dogrib"),

    /**
     * Collective name
     */
    Dravidian_languages("dra", "Dravidian languages"),

    Duala("dua", "Duala"),

    Dutch_Middle_ca_1050_1350("dum", "Dutch, Middle (ca. 1050-1350)"),

    Dutch_Flemish("dut", "Dutch; Flemish"),

    Dyula("dyu", "Dyula"),

    Dzongkha("dzo", "Dzongkha"),

    Eastern_Frisian("frs", "Eastern Frisian"),

    Efik("efi", "Efik"),

    Egyptian_Ancient("egy", "Egyptian (Ancient)"),

    Ekajuk("eka", "Ekajuk"),

    Elamite("elx", "Elamite"),

    /**
     * ONIX local code for Italian dialect, equivalent to egl in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Emilian("egl", "Emilian"),

    English("eng", "English"),

    English_Middle_1100_1500("enm", "English, Middle (1100-1500)"),

    English_Old_ca_450_1100("ang", "English, Old (ca. 450-1100)"),

    Erzya("myv", "Erzya"),

    /**
     * Inuit-Yupik-Unangan languages. Collective name. ONIX local code, equivalent of esx in ISO 639-5. Only for use in
     * ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Eskaleut_languages("esx", "Eskaleut languages"),

    /**
     * Artificial language
     */
    Esperanto("epo", "Esperanto"),

    /**
     * Macrolanguage
     */
    Estonian("est", "Estonian"),

    Ethiopic_Geez("gez", "Ethiopic (Ge’ez)"),

    Ewe("ewe", "Ewe"),

    Ewondo("ewo", "Ewondo"),

    Fang("fan", "Fang"),

    Fanti("fat", "Fanti"),

    Faroese("fao", "Faroese"),

    Fijian("fij", "Fijian"),

    Filipino_Pilipino("fil", "Filipino; Pilipino"),

    Finnish("fin", "Finnish"),

    /**
     * Collective name
     */
    Finno_Ugrian_languages("fiu", "Finno-Ugrian languages"),

    Fon("fon", "Fon"),

    French("fre", "French"),

    French_Middle_ca_1400_1600("frm", "French, Middle (ca. 1400-1600)"),

    French_Old_ca_842_1400("fro", "French, Old (ca. 842-1400)"),

    Friulian("fur", "Friulian"),

    Fulah("ful", "Fulah"),

    Ga("gaa", "Gã"),

    Galibi_Carib("car", "Galibi Carib"),

    Galician("glg", "Galician"),

    /**
     * ONIX local code, distinct variant of langue d'o&#239;l (old northern French), not distinguished from fro, or from
     * frm, fre, nrf by ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Gallo("qgl", "Gallo"),

    /**
     * ONIX local code for Sardinian dialect, equivalent to sdn in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Gallurese("sdn", "Gallurese"),

    Ganda("lug", "Ganda"),

    /**
     * ONIX local code, equivalent to grt in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Garo("grt", "Garo"),

    Gayo("gay", "Gayo"),

    /**
     * Macrolanguage
     */
    Gbaya("gba", "Gbaya"),

    Georgian("geo", "Georgian"),

    German("ger", "German"),

    German_Middle_High_ca_1050_1500("gmh", "German, Middle High (ca. 1050-1500)"),

    German_Old_High_ca_750_1050("goh", "German, Old High (ca. 750-1050)"),

    /**
     * Collective name
     */
    Germanic_languages("gem", "Germanic languages"),

    Gilbertese("gil", "Gilbertese"),

    /**
     * Macrolanguage
     */
    Gondi("gon", "Gondi"),

    Gorontalo("gor", "Gorontalo"),

    Gothic("got", "Gothic"),

    /**
     * Macrolanguage
     */
    Grebo("grb", "Grebo"),

    Greek_Ancient_to_1453("grc", "Greek, Ancient (to 1453)"),

    Greek_Modern_1453_("gre", "Greek, Modern (1453-)"),

    /**
     * Macrolanguage
     */
    Guarani("grn", "Guarani"),

    /**
     * ONIX local code, equivalent to nrf in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Guernesiais_Jerriais("nrf", "Guernésiais, Jèrriais"),

    Gujarati("guj", "Gujarati"),

    Gwichin("gwi", "Gwich’in"),

    /**
     * Macrolanguage
     */
    Haida("hai", "Haida"),

    Haitian_Haitian_Creole("hat", "Haitian; Haitian Creole"),

    Hausa("hau", "Hausa"),

    Hawaiian("haw", "Hawaiian"),

    Hebrew("heb", "Hebrew"),

    Herero("her", "Herero"),

    Hiligaynon("hil", "Hiligaynon"),

    /**
     * Collective name
     */
    Himachali_languages_Western_Pahari_languages("him", "Himachali languages; Western Pahari languages"),

    Hindi("hin", "Hindi"),

    Hiri_Motu("hmo", "Hiri Motu"),

    Hittite("hit", "Hittite"),

    /**
     * Collective name. ONIX local code, equivalent of hmx in ISO 639-5. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Hmong_Mien_languages("hmx", "Hmong-Mien languages"),

    /**
     * Macrolanguage
     */
    Hmong_Mong("hmn", "Hmong; Mong"),

    /**
     * ONIX local code, equivalent to hop in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Hopi("hop", "Hopi"),

    Hungarian("hun", "Hungarian"),

    Hupa("hup", "Hupa"),

    Iban("iba", "Iban"),

    Icelandic("ice", "Icelandic"),

    /**
     * Artificial language
     */
    Ido("ido", "Ido"),

    Igbo("ibo", "Igbo"),

    /**
     * Collective name
     */
    Ijo_languages("ijo", "Ijo languages"),

    Iloko("ilo", "Iloko"),

    Inari_Sami("smn", "Inari Sami"),

    /**
     * Collective name
     */
    Indic_languages("inc", "Indic languages"),

    /**
     * Collective name
     */
    Indo_European_languages("ine", "Indo-European languages"),

    Indonesian("ind", "Indonesian"),

    Ingush("inh", "Ingush"),

    /**
     * Artificial language
     */
    Interlingua_International_Auxiliary_Language_Association("ina",
        "Interlingua (International Auxiliary Language Association)"),

    /**
     * Artificial language
     */
    Interlingue_Occidental("ile", "Interlingue; Occidental"),

    /**
     * Western Canadian Inuktitut. ONIX local code, equivalent to ikt in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Inuinnaqtun("ikt", "Inuinnaqtun"),

    /**
     * Macrolanguage
     */
    Inuktitut("iku", "Inuktitut"),

    /**
     * Macrolanguage
     */
    Inupiaq("ipk", "Inupiaq"),

    /**
     * Collective name
     */
    Iranian_languages("ira", "Iranian languages"),

    /**
     * ONIX local code, equivalent to pes in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Iranian_Persian_Parsi("pes", "Iranian Persian; Parsi"),

    Irish("gle", "Irish"),

    Irish_Middle_ca_1100_1550("mga", "Irish, Middle (ca. 1100-1550)"),

    Irish_Old_to_1100("sga", "Irish, Old (to 1100)"),

    /**
     * Collective name
     */
    Iroquoian_languages("iro", "Iroquoian languages"),

    Italian("ita", "Italian"),

    Japanese("jpn", "Japanese"),

    /**
     * Japonic. Collective name. ONIX local code, equivalent of jpx in ISO 639-5. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Japanese_languages("jpx", "Japanese languages"),

    Javanese("jav", "Javanese"),

    /**
     * ONIX local code, equivalent to jow in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Jowulu("jow", "Jowulu"),

    /**
     * Macrolanguage
     */
    Judeo_Arabic("jrb", "Judeo-Arabic"),

    Judeo_Persian("jpr", "Judeo-Persian"),

    /**
     * (East Circassian)
     */
    Kabardian("kbd", "Kabardian"),

    Kabyle("kab", "Kabyle"),

    Kachin_Jingpho("kac", "Kachin; Jingpho"),

    Kalatdlisut_Greenlandic("kal", "Kalâtdlisut; Greenlandic"),

    Kalmyk_Oirat("xal", "Kalmyk; Oirat"),

    Kamba("kam", "Kamba"),

    Kannada("kan", "Kannada"),

    /**
     * Macrolanguage
     */
    Kanuri("kau", "Kanuri"),

    Kara_Kalpak("kaa", "Kara-Kalpak"),

    Karachay_Balkar("krc", "Karachay-Balkar"),

    /**
     * ONIX local code, equivalent to kdr in ISO 639-3
     */
    Karaim("kdr", "Karaim"),

    Karelian("krl", "Karelian"),

    /**
     * Collective name
     */
    Karen_languages("kar", "Karen languages"),

    Kashmiri("kas", "Kashmiri"),

    Kashubian("csb", "Kashubian"),

    Kawi("kaw", "Kawi"),

    Kazakh("kaz", "Kazakh"),

    Khasi("kha", "Khasi"),

    /**
     * Collective name
     */
    Khoisan_languages("khi", "Khoisan languages"),

    Khotanese_Sakan("kho", "Khotanese; Sakan"),

    /**
     * ONIX local code, equivalent to xuu in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Khwedam_Kxoe("xuu", "Khwedam, Kxoe"),

    Kikuyu_Gikuyu("kik", "Kikuyu; Gikuyu"),

    Kimbundu("kmb", "Kimbundu"),

    Kinyarwanda("kin", "Kinyarwanda"),

    Kirghiz_Kyrgyz("kir", "Kirghiz; Kyrgyz"),

    /**
     * Artificial language
     */
    Klingon_tlhIngan_Hol("tlh", "Klingon; tlhIngan-Hol"),

    /**
     * Macrolanguage
     */
    Komi("kom", "Komi"),

    /**
     * Macrolanguage
     */
    Kongo("kon", "Kongo"),

    /**
     * Macrolanguage
     */
    Konkani("kok", "Konkani"),

    Korean("kor", "Korean"),

    /**
     * Macrolanguage
     */
    Kpelle("kpe", "Kpelle"),

    /**
     * Collective name
     */
    Kru_languages("kro", "Kru languages"),

    Kuanyama_Kwanyama("kua", "Kuanyama; Kwanyama"),

    Kumyk("kum", "Kumyk"),

    /**
     * Macrolanguage
     */
    Kurdish("kur", "Kurdish"),

    Kurukh("kru", "Kurukh"),

    Kusaiean_Caroline_Islands("kos", "Kusaiean (Caroline Islands)"),

    Kutenai("kut", "Kutenai"),

    /**
     * ONIX local code, equivalent to fkv in ISO 639-3
     */
    Kvensk("fkv", "Kvensk"),

    Ladino("lad", "Ladino"),

    /**
     * Macrolanguage
     */
    Lahnda("lah", "Lahnda"),

    /**
     * Teton, Teton Sioux. ONIX local code, equivalent to lkt in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Lakota("lkt", "Lakota"),

    Lamba("lam", "Lamba"),

    /**
     * Collective name
     */
    Land_Dayak_languages("day", "Land Dayak languages"),

    Lao("lao", "Lao"),

    Latin("lat", "Latin"),

    /**
     * Macrolanguage
     */
    Latvian("lav", "Latvian"),

    /**
     * ONIX local code, distinct dialect of of Rusyn (not distinguished from rue by ISO 639-3). Only for use in ONIX 3.0
     * or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Lemko("qlk", "Lemko"),

    Lezgian("lez", "Lezgian"),

    /**
     * ONIX local code for Italian dialect, equivalent to lij in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Ligurian("lij", "Ligurian"),

    Limbergan_Limburger_Limburgish("lim", "Limbergan; Limburger; Limburgish"),

    Lingala("lin", "Lingala"),

    Lithuanian("lit", "Lithuanian"),

    Lojban("jbo", "Lojban"),

    /**
     * ONIX local code for Italian dialect, equivalent to lmo in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Lombard("lmo", "Lombard"),

    Low_German_Low_Saxon("nds", "Low German; Low Saxon"),

    Lower_Sorbian("dsb", "Lower Sorbian"),

    Lozi("loz", "Lozi"),

    Luba_Katanga("lub", "Luba-Katanga"),

    Luba_Lulua("lua", "Luba-Lulua"),

    Luiseno("lui", "Luiseño"),

    Lule_Sami("smj", "Lule Sami"),

    Lunda("lun", "Lunda"),

    Luo_Kenya_and_Tanzania("luo", "Luo (Kenya and Tanzania)"),

    Lushai("lus", "Lushai"),

    Luxembourgish_Letzeburgesch("ltz", "Luxembourgish; Letzeburgesch"),

    Macedonian("mac", "Macedonian"),

    Madurese("mad", "Madurese"),

    Magahi("mag", "Magahi"),

    Maithili("mai", "Maithili"),

    Makasar("mak", "Makasar"),

    /**
     * Macrolanguage
     */
    Malagasy("mlg", "Malagasy"),

    /**
     * Macrolanguage
     */
    Malay("may", "Malay"),

    Malayalam("mal", "Malayalam"),

    /**
     * Collective name. ONIX local code, equivalent of poz in ISO 639-5. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Malayo_Polynesian_languages("poz", "Malayo-Polynesian languages"),

    Maltese("mlt", "Maltese"),

    Manchu("mnc", "Manchu"),

    Mandar("mdr", "Mandar"),

    /**
     * ONIX local code, equivalent to cmn in ISO 639-3
     */
    Mandarin("cmn", "Mandarin"),

    /**
     * Macrolanguage
     */
    Mandingo("man", "Mandingo"),

    Manipuri("mni", "Manipuri"),

    /**
     * Collective name
     */
    Manobo_languages("mno", "Manobo languages"),

    Manx("glv", "Manx"),

    Maori("mao", "Maori"),

    Mapudungun_Mapuche("arn", "Mapudungun; Mapuche"),

    Marathi("mar", "Marathi"),

    /**
     * Macrolanguage
     */
    Mari("chm", "Mari"),

    Marshallese("mah", "Marshallese"),

    /**
     * Macrolanguage
     */
    Marwari("mwr", "Marwari"),

    Masai("mas", "Masai"),

    /**
     * Collective name
     */
    Mayan_languages("myn", "Mayan languages"),

    /**
     * ONIX local code, equivalent to fit in ISO 639-3
     */
    Meankieli_Tornedalen_Finnish("fit", "Meänkieli / Tornedalen Finnish"),

    Mende("men", "Mende"),

    Mikmaq_Micmac("mic", "Mi’kmaq; Micmac"),

    /**
     * ONIX local code, equivalent to gml in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Middle_Low_German("gml", "Middle Low German"),

    Minangkabau("min", "Minangkabau"),

    Mirandese("mwl", "Mirandese"),

    Mohawk("moh", "Mohawk"),

    Moksha("mdf", "Moksha"),

    /**
     * DEPRECATED - use rum
     */
    Moldavian_Moldovan("mol", "Moldavian; Moldovan"),

    /**
     * Collective name
     */
    Mon_Khmer_languages("mkh", "Mon-Khmer languages"),

    Mongo_Nkundu("lol", "Mongo-Nkundu"),

    /**
     * Macrolanguage
     */
    Mongolian("mon", "Mongolian"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Montenegrin("cnr", "Montenegrin"),

    Moore_Mossi("mos", "Mooré; Mossi"),

    /**
     * Collective name
     */
    Munda_languages("mun", "Munda languages"),

    /**
     * ONIX local code, equivalent to mwf in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Murrinh_Patha("mwf", "Murrinh-Patha"),

    NKo("nqo", "N’Ko"),

    /**
     * Collective name
     */
    Nahuatl_languages("nah", "Nahuatl languages"),

    Nauruan("nau", "Nauruan"),

    Navajo_Navaho("nav", "Navajo; Navaho"),

    Ndebele_North("nde", "Ndebele, North"),

    Ndebele_South("nbl", "Ndebele, South"),

    Ndonga("ndo", "Ndonga"),

    Neapolitan("nap", "Neapolitan"),

    /**
     * Macrolanguage
     */
    Nepali("nep", "Nepali"),

    /**
     * ONIX local code, distinct and exclusively spoken variation of Spanish, not distinguished from spa (Spanish,
     * Castilian) by ISO 639-3. Neutral Latin American Spanish should be considered a 'shorthand' for spa plus a
     * 'country code' for Latin America - but prefer spa plus the relevant country code for specifically Mexican
     * Spanish, Argentine (Rioplatense) Spanish, Puerto Rican Spanish etc. Neutral Latin American Spanish must only be
     * used with audio material (including the audio tracks of TV, video and film) to indicate use of accent, vocabulary
     * and construction suitable for broad use across Latin America. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Neutral_Latin_American_Spanish("qls", "Neutral Latin American Spanish"),

    Newari_Nepal_Bhasa("new", "Newari; Nepal Bhasa"),

    Nias("nia", "Nias"),

    /**
     * Collective name
     */
    Niger_Kordofanian_languages("nic", "Niger-Kordofanian languages"),

    /**
     * Collective name
     */
    Nilo_Saharan_languages("ssa", "Nilo-Saharan languages"),

    Niuean("niu", "Niuean"),

    Nogai("nog", "Nogai"),

    /**
     * Collective name
     */
    North_American_Indian_languages("nai", "North American Indian languages"),

    Northern_Frisian("frr", "Northern Frisian"),

    Northern_Sami("sme", "Northern Sami"),

    /**
     * Macrolanguage
     */
    Norwegian("nor", "Norwegian"),

    Norwegian_Bokmal("nob", "Norwegian Bokmål"),

    Norwegian_Nynorsk("nno", "Norwegian Nynorsk"),

    /**
     * Collective name
     */
    Nubian_languages("nub", "Nubian languages"),

    Nyamwezi("nym", "Nyamwezi"),

    Nyankole("nyn", "Nyankole"),

    Nyoro("nyo", "Nyoro"),

    Nzima("nzi", "Nzima"),

    Occitan_post_1500("oci", "Occitan (post 1500)"),

    Official_Aramaic_Imperial_Aramaic_700_300_BCE("arc", "Official Aramaic; Imperial Aramaic (700-300 BCE)"),

    /**
     * Macrolanguage
     */
    Ojibwa("oji", "Ojibwa"),

    /**
     * ONIX local code, equivalent to odt in ISO 639-3
     */
    Old_Dutch_Old_Low_Franconian_ca_4001050("odt", "Old Dutch / Old Low Franconian (ca. 400–1050)"),

    Old_Norse("non", "Old Norse"),

    Old_Persian_ca_600_400_B_C_("peo", "Old Persian (ca. 600-400 B.C.)"),

    /**
     * Macrolanguage
     */
    Oriya("ori", "Oriya"),

    /**
     * Macrolanguage
     */
    Oromo("orm", "Oromo"),

    Osage("osa", "Osage"),

    Ossetian_Ossetic("oss", "Ossetian; Ossetic"),

    /**
     * ONIX local code, equivalent to omq in ISO 639-5. Collective name
     */
    Oto_Manguean_languages("omq", "Oto-Manguean languages"),

    /**
     * Collective name
     */
    Otomian_languages("oto", "Otomian languages"),

    Pahlavi("pal", "Pahlavi"),

    Palauan("pau", "Palauan"),

    Pali("pli", "Pali"),

    Pampanga_Kapampangan("pam", "Pampanga; Kapampangan"),

    Pangasinan("pag", "Pangasinan"),

    Panjabi("pan", "Panjabi"),

    Papiamento("pap", "Papiamento"),

    /**
     * Collective name
     */
    Papuan_languages("paa", "Papuan languages"),

    Pedi_Sepedi_Northern_Sotho("nso", "Pedi; Sepedi; Northern Sotho"),

    /**
     * Macrolanguage
     */
    Persian_Farsi("per", "Persian; Farsi"),

    /**
     * Collective name
     */
    Philippine_languages("phi", "Philippine languages"),

    Phoenician("phn", "Phoenician"),

    /**
     * ONIX local code, distinct variant of langue d'o&#239;l (old northern French), equivalent to pcd in ISO 639-3.
     * Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Picard("pcd", "Picard"),

    /**
     * Guajiro. ONIX local code, equivalent of guc in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Wayuu("guc", "Wayuu"),

    /**
     * ONIX local code for Italian dialect, equivalent to pms in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Piedmontese("pms", "Piedmontese"),

    Polish("pol", "Polish"),

    Ponapeian("pon", "Ponapeian"),

    Portuguese("por", "Portuguese"),

    /**
     * Collective name
     */
    Prakrit_languages("pra", "Prakrit languages"),

    Provencal_Old_to_1500("pro", "Provençal, Old (to 1500); Occitan, Old (to 1500)"),

    /**
     * Macrolanguage
     */
    Pushto_Pashto("pus", "Pushto; Pashto"),

    /**
     * Macrolanguage
     */
    Quechua("que", "Quechua"),

    /**
     * Macrolanguage
     */
    Rajasthani("raj", "Rajasthani"),

    Rapanui("rap", "Rapanui"),

    Rarotongan_Cook_Islands_Maori("rar", "Rarotongan; Cook Islands Maori"),

    /**
     * ONIX local code, equivalent to rcf in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Reunion_Creole_French("rcf", "Réunion Creole French"),

    /**
     * ONIX local code for Italian dialect, equivalent to rgl in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Romagnol("rgn", "Romagnol"),

    /**
     * Collective name
     */
    Romance_languages("roa", "Romance languages"),

    Romanian("rum", "Romanian"),

    Romansh("roh", "Romansh"),

    /**
     * Macrolanguage
     */
    Romany("rom", "Romany"),

    Rundi("run", "Rundi"),

    Russian("rus", "Russian"),

    /**
     * Collective name
     */
    Salishan_languages("sal", "Salishan languages"),

    Samaritan_Aramaic("sam", "Samaritan Aramaic"),

    /**
     * Collective name
     */
    Sami_languages("smi", "Sami languages"),

    Samoan("smo", "Samoan"),

    Sandawe("sad", "Sandawe"),

    Sango("sag", "Sango"),

    Sanskrit("san", "Sanskrit"),

    Santali("sat", "Santali"),

    /**
     * ONIX local code for Saramaccan language, equivalent to srm in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Saramaccan("srm", "Saramaccan"),

    /**
     * Macrolanguage
     */
    Sardinian("srd", "Sardinian"),

    Sasak("sas", "Sasak"),

    /**
     * ONIX local code for Sardinian dialect, equivalent to sdc in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sassarese("sdc", "Sassarese"),

    Scots("sco", "Scots"),

    Scottish_Gaelic("gla", "Scottish Gaelic"),

    Selkup("sel", "Selkup"),

    /**
     * Collective name
     */
    Semitic_languages("sem", "Semitic languages"),

    /**
     * DEPRECATED - use srp
     */
    Serbian("scc", "Serbian"),

    Serbian_("srp", "Serbian"),

    Serer("srr", "Serer"),

    Shan("shn", "Shan"),

    Shona("sna", "Shona"),

    Sichuan_Yi_Nuosu("iii", "Sichuan Yi; Nuosu"),

    Sicilian("scn", "Sicilian"),

    Sidamo("sid", "Sidamo"),

    /**
     * Collective name
     */
    Sign_languages("sgn", "Sign languages"),

    Siksika("bla", "Siksika"),

    /**
     * ONIX local code, equivalent to szl in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Silesian("szl", "Silesian"),

    Sindhi("snd", "Sindhi"),

    Sinhala_Sinhalese("sin", "Sinhala; Sinhalese"),

    /**
     * Chinese (family) languages. Collective name. ONIX local code, equivalent of zhx in ISO 639-5. Only for use in
     * ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sinitic_languages("zhx", "Sinitic languages"),

    /**
     * Collective name
     */
    Sino_Tibetan_languages("sit", "Sino-Tibetan languages"),

    /**
     * Collective name
     */
    Siouan_languages("sio", "Siouan languages"),

    Skolt_Sami("sms", "Skolt Sami"),

    /**
     * Macrolanguage
     */
    Slave_Athapascan("den", "Slave (Athapascan)"),

    /**
     * Collective name
     */
    Slavic_languages("sla", "Slavic languages"),

    Slovak("slo", "Slovak"),

    Slovenian("slv", "Slovenian"),

    Sogdian("sog", "Sogdian"),

    Somali("som", "Somali"),

    /**
     * Collective name
     */
    Songhai_languages("son", "Songhai languages"),

    Soninke("snk", "Soninke"),

    /**
     * Collective name
     */
    Sorbian_languages("wen", "Sorbian languages"),

    Sotho_Sesotho("sot", "Sotho; Sesotho"),

    /**
     * Collective name
     */
    South_American_Indian_languages("sai", "South American Indian languages"),

    Southern_Altai("alt", "Southern Altai"),

    Southern_Sami("sma", "Southern Sami"),

    Spanish("spa", "Spanish"),

    Sranan_Tongo("srn", "Sranan Tongo"),

    Standard_Moroccan_Tamazight("zgh", "Standard Moroccan Tamazight"),

    Sukuma("suk", "Sukuma"),

    Sumerian("sux", "Sumerian"),

    Sundanese("sun", "Sundanese"),

    Susu("sus", "Susu"),

    /**
     * Macrolanguage
     */
    Swahili("swa", "Swahili"),

    Swazi_Swati("ssw", "Swazi; Swati"),

    Swedish("swe", "Swedish"),

    Swiss_German_Alemannic_Alsatian("gsw", "Swiss German; Alemannic; Alsatian"),

    /**
     * Macrolanguage
     */
    Syriac("syr", "Syriac"),

    Tagalog("tgl", "Tagalog"),

    Tahitian("tah", "Tahitian"),

    /**
     * Collective name
     */
    Tai_languages("tai", "Tai languages"),

    Tajik_Tajiki_Persian("tgk", "Tajik; Tajiki Persian"),

    /**
     * Macrolanguage
     */
    Tamashek("tmh", "Tamashek"),

    Tamil("tam", "Tamil"),

    /**
     * ONIX local code, equivalent to shi in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Tashelhit_Shilha("shi", "Tashelhit; Shilha"),

    Tatar("tat", "Tatar"),

    Telugu("tel", "Telugu"),

    Temne_Time("tem", "Temne; Time"),

    Terena("ter", "Terena"),

    Tetum("tet", "Tetum"),

    Thai("tha", "Thai"),

    Tibetan("tib", "Tibetan"),

    Tigre("tig", "Tigré"),

    Tigrinya("tir", "Tigrinya"),

    Tiv("tiv", "Tiv"),

    Tlingit("tli", "Tlingit"),

    Tok_Pisin("tpi", "Tok Pisin"),

    Tokelauan("tkl", "Tokelauan"),

    Tonga_Nyasa("tog", "Tonga (Nyasa)"),

    Tongan("ton", "Tongan"),

    /**
     * ONIX local code, equivalent to tsd in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Tsakonian("tsd", "Tsakonian"),

    Tsimshian("tsi", "Tsimshian"),

    Tsonga("tso", "Tsonga"),

    /**
     * AKA Setswana
     */
    Tswana("tsn", "Tswana"),

    Tumbuka("tum", "Tumbuka"),

    /**
     * Collective name
     */
    Tupi_languages("tup", "Tupi languages"),

    Turkish("tur", "Turkish"),

    Turkish_Ottoman("ota", "Turkish, Ottoman"),

    Turkmen("tuk", "Turkmen"),

    Tuvaluan("tvl", "Tuvaluan"),

    Tuvinian("tyv", "Tuvinian"),

    Twi("twi", "Twi"),

    /**
     * ONIX local code, equivalent to tzo in ISO 639-3
     */
    Tzotzil("tzo", "Tzotzil"),

    Udmurt("udm", "Udmurt"),

    Ugaritic("uga", "Ugaritic"),

    Uighur_Uyghur("uig", "Uighur; Uyghur"),

    Ukrainian("ukr", "Ukrainian"),

    Umbundu("umb", "Umbundu"),

    Upper_Sorbian("hsb", "Upper Sorbian"),

    /**
     * Collective name. ONIX local code, equivalent of urj in ISO 639-5. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Uralic_languages("urj", "Uralic languages"),

    Urdu("urd", "Urdu"),

    /**
     * Macrolanguage
     */
    Uzbek("uzb", "Uzbek"),

    Vai("vai", "Vai"),

    /**
     * ONIX local code, distinct dialect of Catalan (not distinguished from cat by ISO 639-3)
     */
    Valencian("qav", "Valencian"),

    Venda("ven", "Venda"),

    /**
     * ONIX local code for Italian dialect, equivalent to vec in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Venetian_Venetan("vec", "Venetian/Venetan"),

    Vietnamese("vie", "Vietnamese"),

    /**
     * Artificial language
     */
    Volapuk("vol", "Volapük"),

    Votic("vot", "Votic"),

    /**
     * Collective name
     */
    Wakashan_languages("wak", "Wakashan languages"),

    /**
     * East Uvean. ONIX local code, equivalent to wls in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Wallisian("wls", "Wallisian"),

    Walloon("wln", "Walloon"),

    Waray("war", "Waray"),

    Washo("was", "Washo"),

    Welsh("wel", "Welsh"),

    Western_Frisian("fry", "Western Frisian"),

    Wolaitta_Wolaytta("wal", "Wolaitta; Wolaytta"),

    Wolof("wol", "Wolof"),

    /**
     * Vilamovian. ONIX local code, equivalent to wym in ISO 639-3. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Wymysorys("wym", "Wymysorys"),

    Xhosa("xho", "Xhosa"),

    Yakut("sah", "Yakut"),

    Yao("yao", "Yao"),

    Yapese("yap", "Yapese"),

    /**
     * Macrolanguage
     */
    Yiddish("yid", "Yiddish"),

    Yoruba("yor", "Yoruba"),

    /**
     * Collective name
     */
    Yupik_languages("ypk", "Yupik languages"),

    /**
     * Collective name
     */
    Zande_languages("znd", "Zande languages"),

    /**
     * Macrolanguage
     */
    Zapotec("zap", "Zapotec"),

    /**
     * Macrolanguage
     */
    Zaza_Dimili_Dimli_Kirdki_Kirmanjki_Zazaki("zza", "Zaza; Dimili; Dimli; Kirdki; Kirmanjki; Zazaki"),

    Zenaga("zen", "Zenaga"),

    /**
     * Macrolanguage
     */
    Zhuang_Chuang("zha", "Zhuang; Chuang"),

    Zulu("zul", "Zulu"),

    Zuni("zun", "Zuni"),

    /**
     * Use where no suitable code is available
     */
    Uncoded_language("mis", "Uncoded language"),

    Undetermined_language("und", "Undetermined language"),

    Multiple_languages("mul", "Multiple languages"),

    No_linguistic_content("zxx", "No linguistic content");

    public final String code;
    public final String description;

    Languages(String code, String description) {
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

    private static volatile Map<String, Languages> map;

    private static Map<String, Languages> map() {
        Map<String, Languages> result = map;
        if (result == null) {
            synchronized (Languages.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (Languages e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static Languages byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<Languages> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
