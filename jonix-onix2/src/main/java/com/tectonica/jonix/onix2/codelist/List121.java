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
 * Text script code – ISO 15924
 */
public enum List121
{
	/**
	 * Script is not supported by Unicode.
	 */
	Afaka("Afak"), //

	Arabic("Arab"), //

	Imperial_Aramaic("Armi"), //

	Armenian("Armn"), //

	Avestan("Avst"), //

	Balinese("Bali"), //

	Bamun("Bamu"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Bassa_Vah("Bass"), //

	Batak("Batk"), //

	Bengali("Beng"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Blissymbols("Blis"), //

	Bopomofo("Bopo"), //

	Brahmi("Brah"), //

	Braille("Brai"), //

	Buginese("Bugi"), //

	Buhid("Buhd"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Chakma("Cakm"), //

	Unified_Canadian_Aboriginal_Syllabics("Cans"), //

	Carian("Cari"), //

	Cham("Cham"), //

	Cherokee("Cher"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Cirth("Cirt"), //

	Coptic("Copt"), //

	Cypriot("Cprt"), //

	Cyrillic("Cyrl"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Cyrillic__Old_Church_Slavonic_variant_("Cyrs"), //

	Devanagari__Nagari_("Deva"), //

	Deseret__Mormon_("Dsrt"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Duployan_shorthand__Duployan_stenography("Dupl"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Egyptian_demotic("Egyd"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Egyptian_hieratic("Egyh"), //

	Egyptian_hieroglyphs("Egyp"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Elbasan("Elba"), //

	Ethiopic__Ge_ez_("Ethi"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Khutsuri__Asomtavruli_and_Khutsuri_("Geok"), //

	Georgian__Mkhedruli_("Geor"), //

	Glagolitic("Glag"), //

	Gothic("Goth"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Grantha("Gran"), //

	Greek("Grek"), //

	Gujarati("Gujr"), //

	Gurmukhi("Guru"), //

	Hangul__Hang_l__Hangeul_("Hang"), //

	Han__Hanzi__Kanji__Hanja_("Hani"), //

	Hanunoo__Hanun_o_("Hano"), //

	Han__Simplified_variant_("Hans"), //

	Han__Traditional_variant_("Hant"), //

	Hebrew("Hebr"), //

	Hiragana("Hira"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Pahawh_Hmong("Hmng"), //

	Japanese_syllabaries__alias_for_Hiragana___Katakana_("Hrkt"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Old_Hungarian("Hung"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Indus__Harappan_("Inds"), //

	Old_Italic__Etruscan__Oscan__etc__("Ital"), //

	Javanese("Java"), //

	Japanese_syllabaries__alias_for_Han___Hiragana___Katakana_("Jpan"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Jurchen("Jurc"), //

	Kayah_Li("Kali"), //

	Katakana("Kana"), //

	Kharoshthi("Khar"), //

	Khmer("Khmr"), //

	Khojki("Khoj"), //

	Kannada("Knda"), //

	Korean__alias_for_Hangul___Han_("Kore"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Kpelle("Kpel"), //

	Kaithi("Kthi"), //

	Lanna__Tai_Tham("Lana"), //

	Lao("Laoo"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Latin__Fraktur_variant_("Latf"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Latin__Gaelic_variant_("Latg"), //

	Latin("Latn"), //

	Lepcha__R_ng_("Lepc"), //

	Limbu("Limb"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Linear_A("Lina"), //

	Linear_B("Linb"), //

	Lisu__Fraser_("Lisu"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Loma("Loma"), //

	Lycian("Lyci"), //

	Lydian("Lydi"), //

	Mandaic__Mandaean("Mand"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Manichaean("Mani"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Mayan_hieroglyphs("Maya"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Mende("Mend"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Meroitic_Cursive("Merc"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Meroitic_Hieroglyphs("Mero"), //

	Malayalam("Mlym"), //

	Mongolian("Mong"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Moon__Moon_code__Moon_script__Moon_type_("Moon"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Mro__Mru("Mroo"), //

	Meitei_Mayek__Meithei__Meetei_("Mtei"), //

	Myanmar__Burmese_("Mymr"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Old_North_Arabian__Ancient_North_Arabian_("Narb"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Nabatean("Nbat"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Nakhi_Geba___Na__Khi__Gg___baw__Naxi_Geba_("Nkgb"), //

	N_Ko("Nkoo"), //

	/**
	 * Script is not supported by Unicode.
	 */
	N_shu("Nshu"), //

	Ogham("Ogam"), //

	Ol_Chiki__Ol_Cemet___Ol__Santali_("Olck"), //

	Old_Turkic__Orkhon_Runic("Orkh"), //

	Oriya("Orya"), //

	Osmanya("Osma"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Palmyrene("Palm"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Old_Permic("Perm"), //

	Phags_pa("Phag"), //

	Inscriptional_Pahlavi("Phli"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Psalter_Pahlavi("Phlp"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Book_Pahlavi("Phlv"), //

	Phoenician("Phnx"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Miao__Pollard_("Plrd"), //

	Inscriptional_Parthian("Prti"), //

	Reserved_for_private_use__start_("Qaaa"), //

	Reserved_for_private_use__end_("Qabx"), //

	Rejang__Redjang__Kaganga_("Rjng"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Rongorongo("Roro"), //

	Runic("Runr"), //

	Samaritan("Samr"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Sarati("Sara"), //

	Old_South_Arabian("Sarb"), //

	Saurashtra("Saur"), //

	/**
	 * Script is not supported by Unicode.
	 */
	SignWriting("Sgnw"), //

	Shavian__Shaw_("Shaw"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Sharada____rad_("Shrd"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Khudawadi__Sindhi("Sind"), //

	Sinhala("Sinh"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Sora_Sompeng("Sora"), //

	Sundanese("Sund"), //

	Syloti_Nagri("Sylo"), //

	Syriac("Syrc"), //

	Syriac__Estrangelo_variant_("Syre"), //

	Syriac__Western_variant_("Syrj"), //

	Syriac__Eastern_variant_("Syrn"), //

	Tagbanwa("Tagb"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Takri____kr______kr_("Takr"), //

	Tai_Le("Tale"), //

	New_Tai_Lue("Talu"), //

	Tamil("Taml"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Tangut("Tang"), //

	Tai_Viet("Tavt"), //

	Telugu("Telu"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Tengwar("Teng"), //

	Tifinagh__Berber_("Tfng"), //

	Tagalog__Baybayin__Alibata_("Tglg"), //

	Thaana("Thaa"), //

	Thai("Thai"), //

	Tibetan("Tibt"), //

	Tiruta("Tirh"), //

	Ugaritic("Ugar"), //

	Vai("Vaii"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Visible_Speech("Visp"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Warang_Citi__Varang_Kshiti_("Wara"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Woleai("Wole"), //

	Old_Persian("Xpeo"), //

	Cuneiform__Sumero_Akkadian("Xsux"), //

	Yi("Yiii"), //

	Code_for_inherited_script("Zinh"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Mathematical_notation("Zmth"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Symbols("Zsym"), //

	/**
	 * Script is not supported by Unicode.
	 */
	Code_for_unwritten_documents("Zxxx"), //

	Code_for_undetermined_script("Zyyy"), //

	Code_for_uncoded_script("Zzzz");

	public final String value;

	private List121(String value)
	{
		this.value = value;
	}

	private static Map<String, List121> map;

	private static Map<String, List121> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List121 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List121 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
