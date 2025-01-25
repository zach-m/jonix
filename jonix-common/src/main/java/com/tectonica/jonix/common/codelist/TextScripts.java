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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 121 (Text script - based on ISO 15924)
 */
interface CodeList121 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 121</b>
 * <p>
 * Description: Text script - based on ISO 15924
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist121">ONIX
 *      Codelist 121 in Reference Guide</a>
 */
public enum TextScripts implements OnixCodelist, CodeList121 {
    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Adlam("Adlm", "Adlam"),

    /**
     * Script is not supported by Unicode
     */
    Afaka("Afak", "Afaka"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Caucasian_Albanian("Aghb", "Caucasian Albanian"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Ahom_Tai_Ahom("Ahom", "Ahom, Tai Ahom"),

    Arabic("Arab", "Arabic"),

    /**
     * Typographic variant of Arabic. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Arabic_Nastaliq_variant("Aran", "Arabic (Nastaliq variant)"),

    /**
     * Ancient/historic script
     */
    Imperial_Aramaic("Armi", "Imperial Aramaic"),

    Armenian("Armn", "Armenian"),

    /**
     * Ancient/historic script
     */
    Avestan("Avst", "Avestan"),

    Balinese("Bali", "Balinese"),

    Bamun("Bamu", "Bamun"),

    /**
     * Ancient/historic script
     */
    Bassa_Vah("Bass", "Bassa Vah"),

    Batak("Batk", "Batak"),

    Bengali_Bangla("Beng", "Bengali (Bangla)"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Bhaiksuki("Bhks", "Bhaiksuki"),

    /**
     * Script is not supported by Unicode
     */
    Blissymbols("Blis", "Blissymbols"),

    Bopomofo("Bopo", "Bopomofo"),

    /**
     * Ancient/historic script
     */
    Brahmi("Brah", "Brahmi"),

    Braille("Brai", "Braille"),

    Buginese("Bugi", "Buginese"),

    Buhid("Buhd", "Buhid"),

    Chakma("Cakm", "Chakma"),

    Unified_Canadian_Aboriginal_Syllabics("Cans", "Unified Canadian Aboriginal Syllabics"),

    /**
     * Ancient/historic script
     */
    Carian("Cari", "Carian"),

    Cham("Cham", "Cham"),

    Cherokee("Cher", "Cherokee"),

    /**
     * Khw&#257;rezmian. Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Chorasmian("Chrs", "Chorasmian"),

    /**
     * Script is not supported by Unicode
     */
    Cirth("Cirt", "Cirth"),

    /**
     * Ancient/historic script
     */
    Coptic("Copt", "Coptic"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Cypro_Minoan("Cpmn", "Cypro-Minoan"),

    /**
     * Ancient/historic script
     */
    Cypriot("Cprt", "Cypriot"),

    Cyrillic("Cyrl", "Cyrillic"),

    /**
     * Ancient/historic, typographic variant of Cyrillic
     */
    Cyrillic_Old_Church_Slavonic_variant("Cyrs", "Cyrillic (Old Church Slavonic variant)"),

    Devanagari_Nagari("Deva", "Devanagari (Nagari)"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Dives_Akuru("Diak", "Dives Akuru"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Dogra("Dogr", "Dogra"),

    Deseret_Mormon("Dsrt", "Deseret (Mormon)"),

    Duployan_shorthand_Duployan_stenography("Dupl", "Duployan shorthand, Duployan stenography"),

    /**
     * Script is not supported by Unicode
     */
    Egyptian_demotic("Egyd", "Egyptian demotic"),

    /**
     * Script is not supported by Unicode
     */
    Egyptian_hieratic("Egyh", "Egyptian hieratic"),

    /**
     * Ancient/historic script
     */
    Egyptian_hieroglyphs("Egyp", "Egyptian hieroglyphs"),

    /**
     * Ancient/historic script
     */
    Elbasan("Elba", "Elbasan"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Elymaic("Elym", "Elymaic"),

    Ethiopic_Geez("Ethi", "Ethiopic (Ge‘ez)"),

    /**
     * Georgian in Unicode
     */
    Khutsuri_Asomtavruli_and_Khutsuri("Geok", "Khutsuri (Asomtavruli and Khutsuri)"),

    Georgian_Mkhedruli_and_Mtavruli("Geor", "Georgian (Mkhedruli and Mtavruli)"),

    /**
     * Ancient/historic script
     */
    Glagolitic("Glag", "Glagolitic"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Gunjala_Gondi("Gong", "Gunjala Gondi"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Masaram_Gondi("Gonm", "Masaram Gondi"),

    /**
     * Ancient/historic script
     */
    Gothic("Goth", "Gothic"),

    /**
     * Ancient/historic script
     */
    Grantha("Gran", "Grantha"),

    Greek("Grek", "Greek"),

    Gujarati("Gujr", "Gujarati"),

    Gurmukhi("Guru", "Gurmukhi"),

    /**
     * See Hani, Bopo. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Han_with_Bopomofo("Hanb", "Han with Bopomofo"),

    Hangul_Hangul_Hangeul("Hang", "Hangul (Hangŭl, Hangeul)"),

    Han_Hanzi_Kanji_Hanja("Hani", "Han (Hanzi, Kanji, Hanja)"),

    Hanunoo_Hanunoo("Hano", "Hanunoo (Hanunóo)"),

    /**
     * Subset of Hani
     */
    Han_Simplified_variant("Hans", "Han (Simplified variant)"),

    /**
     * Subset of Hani
     */
    Han_Traditional_variant("Hant", "Han (Traditional variant)"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Hatran("Hatr", "Hatran"),

    Hebrew("Hebr", "Hebrew"),

    Hiragana("Hira", "Hiragana"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Anatolian_Hieroglyphs_Luwian_Hieroglyphs_Hittite_Hieroglyphs("Hluw",
        "Anatolian Hieroglyphs (Luwian Hieroglyphs, Hittite Hieroglyphs)"),

    Pahawh_Hmong("Hmng", "Pahawh Hmong"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nyiakeng_Puachue_Hmong("Hmnp", "Nyiakeng Puachue Hmong"),

    /**
     * See Hira, Kana
     */
    Japanese_syllabaries_alias_for_Hiragana_Katakana("Hrkt", "Japanese syllabaries (alias for Hiragana + Katakana)"),

    /**
     * Ancient/historic script
     */
    Old_Hungarian_Hungarian_Runic("Hung", "Old Hungarian (Hungarian Runic)"),

    /**
     * Script is not supported by Unicode
     */
    Indus_Harappan("Inds", "Indus (Harappan)"),

    /**
     * Ancient/historic script
     */
    Old_Italic_Etruscan_Oscan_etc_("Ital", "Old Italic (Etruscan, Oscan, etc.)"),

    /**
     * Subset of Hang. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Jamo_alias_for_Jamo_subset_of_Hangul("Jamo", "Jamo (alias for Jamo subset of Hangul)"),

    Javanese("Java", "Javanese"),

    /**
     * See Hani, Hira and Kana
     */
    Japanese_alias_for_Han_Hiragana_Katakana("Jpan", "Japanese (alias for Han + Hiragana + Katakana)"),

    /**
     * Script is not supported by Unicode
     */
    Jurchen("Jurc", "Jurchen"),

    Kayah_Li("Kali", "Kayah Li"),

    Katakana("Kana", "Katakana"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Kawi("Kawi", "Kawi"),

    /**
     * Ancient/historic script
     */
    Kharoshthi("Khar", "Kharoshthi"),

    Khmer("Khmr", "Khmer"),

    /**
     * Ancient/historic script
     */
    Khojki("Khoj", "Khojki"),

    /**
     * Script is not supported by Unicode. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Khitan_large_script("Kitl", "Khitan large script"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Khitan_small_script("Kits", "Khitan small script"),

    Kannada("Knda", "Kannada"),

    /**
     * See Hani and Hang
     */
    Korean_alias_for_Hangul_Han("Kore", "Korean (alias for Hangul + Han)"),

    /**
     * Script is not supported by Unicode
     */
    Kpelle("Kpel", "Kpelle"),

    /**
     * Ancient/historic script
     */
    Kaithi("Kthi", "Kaithi"),

    Tai_Tham_Lanna("Lana", "Tai Tham (Lanna)"),

    Lao("Laoo", "Lao"),

    /**
     * Typographic variant of Latin
     */
    Latin_Fraktur_variant("Latf", "Latin (Fraktur variant)"),

    /**
     * Typographic variant of Latin
     */
    Latin_Gaelic_variant("Latg", "Latin (Gaelic variant)"),

    Latin("Latn", "Latin"),

    /**
     * Script is not supported by Unicode. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Leke("Leke", "Leke"),

    Lepcha_Rong("Lepc", "Lepcha (Róng)"),

    Limbu("Limb", "Limbu"),

    /**
     * Ancient/historic script
     */
    Linear_A("Lina", "Linear A"),

    /**
     * Ancient/historic script
     */
    Linear_B("Linb", "Linear B"),

    Lisu_Fraser("Lisu", "Lisu (Fraser)"),

    /**
     * Script is not supported by Unicode
     */
    Loma("Loma", "Loma"),

    /**
     * Ancient/historic script
     */
    Lycian("Lyci", "Lycian"),

    /**
     * Ancient/historic script
     */
    Lydian("Lydi", "Lydian"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Mahajani("Mahj", "Mahajani"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Makasar("Maka", "Makasar"),

    Mandaic_Mandaean("Mand", "Mandaic, Mandaean"),

    /**
     * Ancient/historic script
     */
    Manichaean("Mani", "Manichaean"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Marchen("Marc", "Marchen"),

    /**
     * Script is not supported by Unicode
     */
    Mayan_hieroglyphs("Maya", "Mayan hieroglyphs"),

    /**
     * Script is not supported by Unicode. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Medefaidrin_Oberi_Okaime_Oberi_kaim("Medf", "Medefaidrin (Oberi Okaime, Oberi Ɔkaimɛ)"),

    Mende_Kikakui("Mend", "Mende Kikakui"),

    /**
     * Ancient/historic script
     */
    Meroitic_Cursive("Merc", "Meroitic Cursive"),

    /**
     * Ancient/historic script
     */
    Meroitic_Hieroglyphs("Mero", "Meroitic Hieroglyphs"),

    Malayalam("Mlym", "Malayalam"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Modi_Modi("Modi", "Modi, Moḍī"),

    /**
     * Includes Clear, Manchu scripts
     */
    Mongolian("Mong", "Mongolian"),

    /**
     * Script is not supported by Unicode
     */
    Moon_Moon_code_Moon_script_Moon_type("Moon", "Moon (Moon code, Moon script, Moon type)"),

    Mro_Mru("Mroo", "Mro, Mru"),

    Meitei_Mayek_Meithei_Meetei("Mtei", "Meitei Mayek (Meithei, Meetei)"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Multani("Mult", "Multani"),

    Myanmar_Burmese("Mymr", "Myanmar (Burmese)"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nag_Mundari("Nagm", "Nag Mundari"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nandinagari("Nand", "Nandinagari"),

    /**
     * Ancient/historic script
     */
    Old_North_Arabian_Ancient_North_Arabian("Narb", "Old North Arabian (Ancient North Arabian)"),

    /**
     * Ancient/historic script
     */
    Nabatean("Nbat", "Nabatean"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Newa_Newar_Newari_Nepala_lipi("Newa", "Newa, Newar, Newari, Nepāla lipi"),

    /**
     * Script is not supported by Unicode
     */
    Nakhi_Geba_Na_Khi_Ggo_baw_Naxi_Geba("Nkgb", "Nakhi Geba (’Na-’Khi ²Ggŏ-¹baw, Naxi Geba)"),

    NKo("Nkoo", "N’Ko"),

    Nushu("Nshu", "Nüshu"),

    /**
     * Ancient/historic script
     */
    Ogham("Ogam", "Ogham"),

    Ol_Chiki_Ol_Cemet_Ol_Santali("Olck", "Ol Chiki (Ol Cemet’, Ol, Santali)"),

    /**
     * Ancient/historic script
     */
    Old_Turkic_Orkhon_Runic("Orkh", "Old Turkic, Orkhon Runic"),

    Oriya_Odia("Orya", "Oriya (Odia)"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Osage("Osge", "Osage"),

    Osmanya("Osma", "Osmanya"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Old_Uyghur("Ougr", "Old Uyghur"),

    /**
     * Ancient/historic script
     */
    Palmyrene("Palm", "Palmyrene"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pau_Cin_Hau("Pauc", "Pau Cin Hau"),

    /**
     * Ancient/historic script
     */
    Old_Permic("Perm", "Old Permic"),

    /**
     * Ancient/historic script
     */
    Phags_pa("Phag", "Phags-pa"),

    /**
     * Ancient/historic script
     */
    Inscriptional_Pahlavi("Phli", "Inscriptional Pahlavi"),

    /**
     * Ancient/historic script
     */
    Psalter_Pahlavi("Phlp", "Psalter Pahlavi"),

    /**
     * Script is not supported by Unicode
     */
    Book_Pahlavi("Phlv", "Book Pahlavi"),

    /**
     * Ancient/historic script
     */
    Phoenician("Phnx", "Phoenician"),

    /**
     * Script is not supported by Unicode. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Klingon_KLI_plqaD("Piqd", "Klingon (KLI plqaD)"),

    Miao_Pollard("Plrd", "Miao (Pollard)"),

    /**
     * Ancient/historic script
     */
    Inscriptional_Parthian("Prti", "Inscriptional Parthian"),

    Reserved_for_private_use_start("Qaaa", "Reserved for private use (start)"),

    /**
     * ONIX local code for graphical symbols used in augmentative and alternative communication and education, not
     * listed in ISO 15924. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Picture_Communication_Symbols_PCS("Qabp", "Picture Communication Symbols (PCS)"),

    /**
     * ONIX local code for graphical symbols used in augmentative and alternative communication and education, not
     * listed in ISO 15924. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Widgit_symbols("Qabw", "Widgit symbols"),

    Reserved_for_private_use_end("Qabx", "Reserved for private use (end)"),

    Rejang_Redjang_Kaganga("Rjng", "Rejang (Redjang, Kaganga)"),

    /**
     * Script is not supported by Unicode
     */
    Rongorongo("Roro", "Rongorongo"),

    /**
     * Ancient/historic script
     */
    Runic("Runr", "Runic"),

    Samaritan("Samr", "Samaritan"),

    /**
     * Script is not supported by Unicode
     */
    Sarati("Sara", "Sarati"),

    /**
     * Ancient/historic script
     */
    Old_South_Arabian("Sarb", "Old South Arabian"),

    Saurashtra("Saur", "Saurashtra"),

    SignWriting("Sgnw", "SignWriting"),

    Shavian_Shaw("Shaw", "Shavian (Shaw)"),

    Sharada_Sarada("Shrd", "Sharada, Śāradā"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Siddham_Siddham_Siddhamatrka("Sidd", "Siddham, Siddhaṃ, Siddhamātṛkā"),

    Khudawadi_Sindhi("Sind", "Khudawadi, Sindhi"),

    Sinhala("Sinh", "Sinhala"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Sogdian("Sogd", "Sogdian"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Old_Sogdian("Sogo", "Old Sogdian"),

    Sora_Sompeng("Sora", "Sora Sompeng"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Soyombo("Soyo", "Soyombo"),

    Sundanese("Sund", "Sundanese"),

    Syloti_Nagri("Sylo", "Syloti Nagri"),

    Syriac("Syrc", "Syriac"),

    /**
     * Typographic variant of Syriac
     */
    Syriac_Estrangelo_variant("Syre", "Syriac (Estrangelo variant)"),

    /**
     * Typographic variant of Syriac
     */
    Syriac_Western_variant("Syrj", "Syriac (Western variant)"),

    /**
     * Typographic variant of Syriac
     */
    Syriac_Eastern_variant("Syrn", "Syriac (Eastern variant)"),

    Tagbanwa("Tagb", "Tagbanwa"),

    Takri_Takri_Tankri("Takr", "Takri, Ṭākrī, Ṭāṅkrī"),

    Tai_Le("Tale", "Tai Le"),

    New_Tai_Lue("Talu", "New Tai Lue"),

    Tamil("Taml", "Tamil"),

    /**
     * Ancient/historic script
     */
    Tangut("Tang", "Tangut"),

    Tai_Viet("Tavt", "Tai Viet"),

    Telugu("Telu", "Telugu"),

    /**
     * Script is not supported by Unicode
     */
    Tengwar("Teng", "Tengwar"),

    Tifinagh_Berber("Tfng", "Tifinagh (Berber)"),

    Tagalog_Baybayin_Alibata("Tglg", "Tagalog (Baybayin, Alibata)"),

    Thaana("Thaa", "Thaana"),

    Thai("Thai", "Thai"),

    Tibetan("Tibt", "Tibetan"),

    Tirhuta("Tirh", "Tirhuta"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Tangsa("Tnsa", "Tangsa"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Toto("Toto", "Toto"),

    /**
     * Ancient/historic script
     */
    Ugaritic("Ugar", "Ugaritic"),

    Vai("Vaii", "Vai"),

    /**
     * Script is not supported by Unicode
     */
    Visible_Speech("Visp", "Visible Speech"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Vithkuqi("Vith", "Vithkuqi"),

    Warang_Citi_Varang_Kshiti("Wara", "Warang Citi (Varang Kshiti)"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Wancho("Wcho", "Wancho"),

    /**
     * Script is not supported by Unicode
     */
    Woleai("Wole", "Woleai"),

    /**
     * Ancient/historic script
     */
    Old_Persian("Xpeo", "Old Persian"),

    /**
     * Ancient/historic script
     */
    Cuneiform_Sumero_Akkadian("Xsux", "Cuneiform, Sumero-Akkadian"),

    /**
     * Ancient/historic script. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Yezidi("Yezi", "Yezidi"),

    Yi("Yiii", "Yi"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Zanabazar_Square_Zanabazarin_Dorboljin_Useg_Xewtee_Dorboljin_Bicig_Horizontal_Square_Script("Zanb",
        "Zanabazar Square (Zanabazarin Dörböljin Useg, Xewtee Dörböljin Bicig, Horizontal Square Script)"),

    /**
     * Not a script in Unicode
     */
    Mathematical_notation("Zmth", "Mathematical notation"),

    /**
     * Not a script in Unicode. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Symbols_Emoji_variant("Zsye", "Symbols (Emoji variant)"),

    /**
     * Not a script in Unicode
     */
    Symbols("Zsym", "Symbols"),

    /**
     * Not a script in Unicode
     */
    Code_for_unwritten_documents("Zxxx", "Code for unwritten documents"),

    Code_for_inherited_script("Zinh", "Code for inherited script"),

    Code_for_undetermined_script("Zyyy", "Code for undetermined script"),

    Code_for_uncoded_script("Zzzz", "Code for uncoded script");

    public final String code;
    public final String description;

    TextScripts(String code, String description) {
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

    private static volatile Map<String, TextScripts> map;

    private static Map<String, TextScripts> map() {
        Map<String, TextScripts> result = map;
        if (result == null) {
            synchronized (TextScripts.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TextScripts e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TextScripts byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<TextScripts> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
