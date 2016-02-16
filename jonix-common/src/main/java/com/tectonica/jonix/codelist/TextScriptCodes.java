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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 121</b>
 * <p>
 * Description: Text script code - ISO 15924
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist121">ONIX
 *      Codelist 121 in Reference Guide</a>
 */
public enum TextScriptCodes
{
	/**
	 * Script is not supported by Unicode
	 */
	Afaka("Afak", "Afaka"), //

	Arabic("Arab", "Arabic"), //

	Imperial_Aramaic("Armi", "Imperial Aramaic"), //

	Armenian("Armn", "Armenian"), //

	Avestan("Avst", "Avestan"), //

	Balinese("Bali", "Balinese"), //

	Bamun("Bamu", "Bamun"), //

	/**
	 * Script is not supported by Unicode
	 */
	Bassa_Vah("Bass", "Bassa Vah"), //

	Batak("Batk", "Batak"), //

	Bengali("Beng", "Bengali"), //

	/**
	 * Script is not supported by Unicode
	 */
	Blissymbols("Blis", "Blissymbols"), //

	Bopomofo("Bopo", "Bopomofo"), //

	Brahmi("Brah", "Brahmi"), //

	Braille("Brai", "Braille"), //

	Buginese("Bugi", "Buginese"), //

	Buhid("Buhd", "Buhid"), //

	/**
	 * Script is not supported by Unicode
	 */
	Chakma("Cakm", "Chakma"), //

	Unified_Canadian_Aboriginal_Syllabics("Cans", "Unified Canadian Aboriginal Syllabics"), //

	Carian("Cari", "Carian"), //

	Cham("Cham", "Cham"), //

	Cherokee("Cher", "Cherokee"), //

	/**
	 * Script is not supported by Unicode
	 */
	Cirth("Cirt", "Cirth"), //

	Coptic("Copt", "Coptic"), //

	Cypriot("Cprt", "Cypriot"), //

	Cyrillic("Cyrl", "Cyrillic"), //

	/**
	 * Script is not supported by Unicode
	 */
	Cyrillic_Old_Church_Slavonic_variant("Cyrs", "Cyrillic (Old Church Slavonic variant)"), //

	Devanagari_Nagari("Deva", "Devanagari (Nagari)"), //

	Deseret_Mormon("Dsrt", "Deseret (Mormon)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Duployan_shorthand_Duployan_stenography("Dupl", "Duployan shorthand, Duployan stenography"), //

	/**
	 * Script is not supported by Unicode
	 */
	Egyptian_demotic("Egyd", "Egyptian demotic"), //

	/**
	 * Script is not supported by Unicode
	 */
	Egyptian_hieratic("Egyh", "Egyptian hieratic"), //

	Egyptian_hieroglyphs("Egyp", "Egyptian hieroglyphs"), //

	/**
	 * Script is not supported by Unicode
	 */
	Elbasan("Elba", "Elbasan"), //

	Ethiopic_Ge_ez("Ethi", "Ethiopic (Ge‘ez)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Khutsuri_Asomtavruli_and_Khutsuri("Geok", "Khutsuri (Asomtavruli and Khutsuri)"), //

	Georgian_Mkhedruli("Geor", "Georgian (Mkhedruli)"), //

	Glagolitic("Glag", "Glagolitic"), //

	Gothic("Goth", "Gothic"), //

	/**
	 * Script is not supported by Unicode
	 */
	Grantha("Gran", "Grantha"), //

	Greek("Grek", "Greek"), //

	Gujarati("Gujr", "Gujarati"), //

	Gurmukhi("Guru", "Gurmukhi"), //

	Hangul_Hang_l_Hangeul("Hang", "Hangul (Hangŭl, Hangeul)"), //

	Han_Hanzi_Kanji_Hanja("Hani", "Han (Hanzi, Kanji, Hanja)"), //

	Hanunoo_Hanun_o("Hano", "Hanunoo (Hanunóo)"), //

	Han_Simplified_variant("Hans", "Han (Simplified variant)"), //

	Han_Traditional_variant("Hant", "Han (Traditional variant)"), //

	Hebrew("Hebr", "Hebrew"), //

	Hiragana("Hira", "Hiragana"), //

	/**
	 * Script is not supported by Unicode
	 */
	Pahawh_Hmong("Hmng", "Pahawh Hmong"), //

	Japanese_syllabaries_alias_for_Hiragana_Katakana("Hrkt", "Japanese syllabaries (alias for Hiragana + Katakana)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Old_Hungarian("Hung", "Old Hungarian"), //

	/**
	 * Script is not supported by Unicode
	 */
	Indus_Harappan("Inds", "Indus (Harappan)"), //

	Old_Italic_Etruscan_Oscan_etc_("Ital", "Old Italic (Etruscan, Oscan, etc.)"), //

	Javanese("Java", "Javanese"), //

	Japanese_syllabaries_alias_for_Han_Hiragana_Katakana("Jpan",
			"Japanese syllabaries (alias for Han + Hiragana + Katakana)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Jurchen("Jurc", "Jurchen"), //

	Kayah_Li("Kali", "Kayah Li"), //

	Katakana("Kana", "Katakana"), //

	Kharoshthi("Khar", "Kharoshthi"), //

	Khmer("Khmr", "Khmer"), //

	Khojki("Khoj", "Khojki"), //

	Kannada("Knda", "Kannada"), //

	Korean_alias_for_Hangul_Han("Kore", "Korean (alias for Hangul + Han)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Kpelle("Kpel", "Kpelle"), //

	Kaithi("Kthi", "Kaithi"), //

	Lanna_Tai_Tham("Lana", "Lanna, Tai Tham"), //

	Lao("Laoo", "Lao"), //

	/**
	 * Script is not supported by Unicode
	 */
	Latin_Fraktur_variant("Latf", "Latin (Fraktur variant)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Latin_Gaelic_variant("Latg", "Latin (Gaelic variant)"), //

	Latin("Latn", "Latin"), //

	Lepcha_R_ng("Lepc", "Lepcha (Róng)"), //

	Limbu("Limb", "Limbu"), //

	/**
	 * Script is not supported by Unicode
	 */
	Linear_A("Lina", "Linear A"), //

	Linear_B("Linb", "Linear B"), //

	Lisu_Fraser("Lisu", "Lisu (Fraser)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Loma("Loma", "Loma"), //

	Lycian("Lyci", "Lycian"), //

	Lydian("Lydi", "Lydian"), //

	Mandaic_Mandaean("Mand", "Mandaic, Mandaean"), //

	/**
	 * Script is not supported by Unicode
	 */
	Manichaean("Mani", "Manichaean"), //

	/**
	 * Script is not supported by Unicode
	 */
	Mayan_hieroglyphs("Maya", "Mayan hieroglyphs"), //

	/**
	 * Script is not supported by Unicode
	 */
	Mende("Mend", "Mende"), //

	/**
	 * Script is not supported by Unicode
	 */
	Meroitic_Cursive("Merc", "Meroitic Cursive"), //

	/**
	 * Script is not supported by Unicode
	 */
	Meroitic_Hieroglyphs("Mero", "Meroitic Hieroglyphs"), //

	Malayalam("Mlym", "Malayalam"), //

	Mongolian("Mong", "Mongolian"), //

	/**
	 * Script is not supported by Unicode
	 */
	Moon_Moon_code_Moon_script_Moon_type("Moon", "Moon (Moon code, Moon script, Moon type)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Mro_Mru("Mroo", "Mro, Mru"), //

	Meitei_Mayek_Meithei_Meetei("Mtei", "Meitei Mayek (Meithei, Meetei)"), //

	Myanmar_Burmese("Mymr", "Myanmar (Burmese)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Old_North_Arabian_Ancient_North_Arabian("Narb", "Old North Arabian (Ancient North Arabian)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Nabatean("Nbat", "Nabatean"), //

	/**
	 * Script is not supported by Unicode
	 */
	Nakhi_Geba_Na_Khi_Gg_baw_Naxi_Geba("Nkgb", "Nakhi Geba (’Na-’Khi ²Ggŏ-¹baw, Naxi Geba)"), //

	N_Ko("Nkoo", "N’Ko"), //

	/**
	 * Script is not supported by Unicode
	 */
	N_shu("Nshu", "Nüshu"), //

	Ogham("Ogam", "Ogham"), //

	Ol_Chiki_Ol_Cemet_Ol_Santali("Olck", "Ol Chiki (Ol Cemet’, Ol, Santali)"), //

	Old_Turkic_Orkhon_Runic("Orkh", "Old Turkic, Orkhon Runic"), //

	Oriya("Orya", "Oriya"), //

	Osmanya("Osma", "Osmanya"), //

	/**
	 * Script is not supported by Unicode
	 */
	Palmyrene("Palm", "Palmyrene"), //

	/**
	 * Script is not supported by Unicode
	 */
	Old_Permic("Perm", "Old Permic"), //

	Phags_pa("Phag", "Phags-pa"), //

	Inscriptional_Pahlavi("Phli", "Inscriptional Pahlavi"), //

	/**
	 * Script is not supported by Unicode
	 */
	Psalter_Pahlavi("Phlp", "Psalter Pahlavi"), //

	/**
	 * Script is not supported by Unicode
	 */
	Book_Pahlavi("Phlv", "Book Pahlavi"), //

	Phoenician("Phnx", "Phoenician"), //

	/**
	 * Script is not supported by Unicode
	 */
	Miao_Pollard("Plrd", "Miao (Pollard)"), //

	Inscriptional_Parthian("Prti", "Inscriptional Parthian"), //

	Reserved_for_private_use_start("Qaaa", "Reserved for private use (start)"), //

	Reserved_for_private_use_end("Qabx", "Reserved for private use (end)"), //

	Rejang_Redjang_Kaganga("Rjng", "Rejang (Redjang, Kaganga)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Rongorongo("Roro", "Rongorongo"), //

	Runic("Runr", "Runic"), //

	Samaritan("Samr", "Samaritan"), //

	/**
	 * Script is not supported by Unicode
	 */
	Sarati("Sara", "Sarati"), //

	Old_South_Arabian("Sarb", "Old South Arabian"), //

	Saurashtra("Saur", "Saurashtra"), //

	/**
	 * Script is not supported by Unicode
	 */
	SignWriting("Sgnw", "SignWriting"), //

	Shavian_Shaw("Shaw", "Shavian (Shaw)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Sharada_rad_("Shrd", "Sharada, Śāradā"), //

	/**
	 * Script is not supported by Unicode
	 */
	Khudawadi_Sindhi("Sind", "Khudawadi, Sindhi"), //

	Sinhala("Sinh", "Sinhala"), //

	/**
	 * Script is not supported by Unicode
	 */
	Sora_Sompeng("Sora", "Sora Sompeng"), //

	Sundanese("Sund", "Sundanese"), //

	Syloti_Nagri("Sylo", "Syloti Nagri"), //

	Syriac("Syrc", "Syriac"), //

	Syriac_Estrangelo_variant("Syre", "Syriac (Estrangelo variant)"), //

	Syriac_Western_variant("Syrj", "Syriac (Western variant)"), //

	Syriac_Eastern_variant("Syrn", "Syriac (Eastern variant)"), //

	Tagbanwa("Tagb", "Tagbanwa"), //

	/**
	 * Script is not supported by Unicode
	 */
	Takri_kr_kr_("Takr", "Takri, Ṭākrī, Ṭāṅkrī"), //

	Tai_Le("Tale", "Tai Le"), //

	New_Tai_Lue("Talu", "New Tai Lue"), //

	Tamil("Taml", "Tamil"), //

	/**
	 * Script is not supported by Unicode
	 */
	Tangut("Tang", "Tangut"), //

	Tai_Viet("Tavt", "Tai Viet"), //

	Telugu("Telu", "Telugu"), //

	/**
	 * Script is not supported by Unicode
	 */
	Tengwar("Teng", "Tengwar"), //

	Tifinagh_Berber("Tfng", "Tifinagh (Berber)"), //

	Tagalog_Baybayin_Alibata("Tglg", "Tagalog (Baybayin, Alibata)"), //

	Thaana("Thaa", "Thaana"), //

	Thai("Thai", "Thai"), //

	Tibetan("Tibt", "Tibetan"), //

	Tiruta("Tirh", "Tiruta"), //

	Ugaritic("Ugar", "Ugaritic"), //

	Vai("Vaii", "Vai"), //

	/**
	 * Script is not supported by Unicode
	 */
	Visible_Speech("Visp", "Visible Speech"), //

	/**
	 * Script is not supported by Unicode
	 */
	Warang_Citi_Varang_Kshiti("Wara", "Warang Citi (Varang Kshiti)"), //

	/**
	 * Script is not supported by Unicode
	 */
	Woleai("Wole", "Woleai"), //

	Old_Persian("Xpeo", "Old Persian"), //

	Cuneiform_Sumero_Akkadian("Xsux", "Cuneiform, Sumero-Akkadian"), //

	Yi("Yiii", "Yi"), //

	Code_for_inherited_script("Zinh", "Code for inherited script"), //

	/**
	 * Script is not supported by Unicode
	 */
	Mathematical_notation("Zmth", "Mathematical notation"), //

	/**
	 * Script is not supported by Unicode
	 */
	Symbols("Zsym", "Symbols"), //

	/**
	 * Script is not supported by Unicode
	 */
	Code_for_unwritten_documents("Zxxx", "Code for unwritten documents"), //

	Code_for_undetermined_script("Zyyy", "Code for undetermined script"), //

	Code_for_uncoded_script("Zzzz", "Code for uncoded script");

	public final String value;
	public final String label;

	private TextScriptCodes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, TextScriptCodes> map;

	private static Map<String, TextScriptCodes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (TextScriptCodes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static TextScriptCodes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
