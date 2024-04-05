/*
 * Copyright (C) 2012-2024 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 29 (Audience code type)
 */
interface CodeList29 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 29</b>
 * <p>
 * Description: Audience code type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist29">ONIX
 *      Codelist 29 in Reference Guide</a>
 */
public enum AudienceCodeTypes implements OnixCodelist, CodeList29 {
    /**
     * Using a code from List 28
     */
    ONIX_audience_codes("01", "ONIX audience codes"),

    /**
     * As specified in &lt;AudienceCodeTypeName&gt;
     */
    Proprietary("02", "Proprietary"),

    /**
     * Motion Picture Association of America rating applied to movies
     */
    MPAA_rating("03", "MPAA rating"),

    /**
     * British Board of Film Classification rating applied to movies
     */
    BBFC_rating("04", "BBFC rating"),

    /**
     * German FSK (Freiwillige Selbstkontrolle der Filmwirtschaft) rating applied to movies
     */
    FSK_rating("05", "FSK rating"),

    /**
     * French Canadian audience code list, used by BTLF for Memento
     */
    BTLF_audience_code("06", "BTLF audience code"),

    /**
     * Audience code used by Electre (France)
     */
    Electre_audience_code("07", "Electre audience code"),

    /**
     * Spain: educational audience and material type code of the Asociaci&#243;n Nacional de Editores de Libros y
     * Material de Ense&#241;anza
     */
    ANELE_Tipo("08", "ANELE Tipo"),

    /**
     * Code list used to specify reading levels for children's books, used in Flanders, and formerly in the Netherlands
     * - see also code 18
     */
    AVI("09", "AVI"),

    /**
     * German USK (Unterhaltungssoftware Selbstkontrolle) rating applied to video or computer games
     */
    USK_rating("10", "USK rating"),

    /**
     * Audience code used in Flanders
     */
    AWS("11", "AWS"),

    /**
     * Type of school: codelist formerly maintained by VdS Bildungsmedien eV, the German association of educational
     * media publishers at http://www.bildungsmedien.de/service/onixlisten/schulform_onix_codelist29_value12_0408.pdf.
     * Deprecated - use Thema educational purpose qualifier (eg 4Z-DE-BA - for German Elementary School) in
     * &lt;Subject&gt; instead
     */
    Schulform("12", "Schulform"),

    /**
     * School region: codelist maintained by VdS Bildungsmedien eV, the German association of educational media
     * publishers, indicating where products are licensed to be used in schools. See
     * http://www.bildungsmedien.de/service/onixlisten/bundesland_onix_codelist29_value13_0408.pdf. Deprecated
     */
    Bundesland("13", "Bundesland"),

    /**
     * Occupation: codelist for vocational training materials formerly maintained by VdS Bildungsmedien eV, the German
     * association of educational media publishers at
     * http://www.bildungsmedien.de/service/onixlisten/ausbildungsberufe_onix_codelist29_value14_0408.pdf. Deprecated -
     * use Thema educational purpose qualifier (eg 4Z-DE-UH - for specific German professional/vocational qualifications
     * and degrees) in &lt;Subject&gt; instead
     */
    Ausbildungsberuf("14", "Ausbildungsberuf"),

    /**
     * Finnish school or college level
     */
    Suomalainen_kouluasteluokitus("15", "Suomalainen kouluasteluokitus"),

    /**
     * UK Publishers Association, Children's Book Group, coded indication of intended reader age, carried on book covers
     */
    CBG_age_guidance("16", "CBG age guidance"),

    /**
     * Audience code used in Nielsen Book Services
     */
    Nielsen_Book_audience_code("17", "Nielsen Book audience code"),

    /**
     * Code list used to specify reading levels for children's books, used in the Netherlands - see also code 09
     */
    AVI_revised("18", "AVI (revised)"),

    /**
     * Lexile measure (the Lexile measure in &lt;AudienceCodeValue&gt; may optionally be prefixed by the Lexile code).
     * Examples might be '880L', 'AD0L' or 'HL600L'. Deprecated - use &lt;Complexity&gt; instead
     */
    Lexile_measure("19", "Lexile measure"),

    /**
     * Fry readability metric based on number of sentences and syllables per 100 words. Expressed as a number from 1 to
     * 15 in &lt;AudienceCodeValue&gt;. Deprecated - use &lt;Complexity&gt; instead
     */
    Fry_Readability_score("20", "Fry Readability score"),

    /**
     * Children's audience code (&#23550;&#35937;&#35501;&#32773;), two-digit encoding of intended target readership
     * from 0-2 years up to High School level
     */
    Japanese_Childrens_audience_code("21", "Japanese Children’s audience code"),

    /**
     * Publisher's rating indicating suitability for a particular adult audience, using a code from List 203. Should
     * only be used when the ONIX Audience code indicates a general adult audience (code 01 from List 28)
     */
    ONIX_Adult_audience_rating("22", "ONIX Adult audience rating"),

    /**
     * Codes A1 to C2 indicating standardised level of language learning or teaching material, from beginner to
     * advanced, defined by the Council of Europe (see http://www.coe.int/lang-CEFR)
     */
    Common_European_Framework_of_Reference_for_Language_Learning_CEFR("23",
        "Common European Framework of Reference for Language Learning (CEFR)"),

    /**
     * Rating used in Korea to control selling of books and e-books to minors. Current values are 0 (suitable for all)
     * and 19 (only for sale to ages 19+). See http://www.kpec.or.kr/english/
     */
    Korean_Publication_Ethics_Commission_rating("24", "Korean Publication Ethics Commission rating"),

    /**
     * UK Institute of Education Book Bands for Guided Reading scheme (see http://www.ioe.ac.uk/research/4664.html).
     * &lt;AudienceCodeValue&gt; is a color, eg 'Pink A' or 'Copper'. Deprecated - use &lt;Complexity&gt; instead
     */
    IoE_Book_Band("25", "IoE Book Band"),

    /**
     * Used for German videos/DVDs with educational or informative content; value for &lt;AudienceCodeValue&gt; must be
     * either 'Infoprogramm gem&#228;&#223; &#167; 14 JuSchG' or 'Lehrprogramm gem&#228;&#223; &#167; 14 JuSchG'
     */
    FSK_Lehr_Infoprogramm("26", "FSK Lehr-/Infoprogramm"),

    /**
     * Where this is different from the language of the text of the book recorded in &lt;Language&gt;.
     * &lt;AudienceCodeValue&gt; should be a value from List 74
     */
    Intended_audience_language("27", "Intended audience language"),

    /**
     * Pan European Game Information rating used primarily for video games
     */
    PEGI_rating("28", "PEGI rating"),

    /**
     * Code indicating the intended curriculum (eg Naturvetenskapsprogrammet, Estetica programmet) in Swedish higher
     * secondary education
     */
    Gymnasieprogram("29", "Gymnasieprogram"),

    /**
     * International Standard Classification of Education levels (2011), eg &lt;AudienceCodeValue&gt; 253 is 'Lower
     * secondary vocational education, level completion without direct access to upper secondary education'. Only for
     * use in ONIX 3.0 or later. See
     * http://uis.unesco.org/en/topic/international-standard-classification-education-isced
     * <p>
     * JONIX adds: Not included in Onix2
     */
    ISCED_2011("30", "ISCED 2011");

    public final String code;
    public final String description;

    AudienceCodeTypes(String code, String description) {
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

    private static volatile Map<String, AudienceCodeTypes> map;

    private static Map<String, AudienceCodeTypes> map() {
        Map<String, AudienceCodeTypes> result = map;
        if (result == null) {
            synchronized (AudienceCodeTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (AudienceCodeTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static AudienceCodeTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<AudienceCodeTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
