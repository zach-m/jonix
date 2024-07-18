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
 * marker interface to assist in IDE navigation to code-list 12 (Trade category)
 */
interface CodeList12 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 12</b>
 * <p>
 * Description: Trade category
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_66.html#codelist12">ONIX
 *      Codelist 12 in Reference Guide</a>
 */
public enum TradeCategorys implements OnixCodelist, CodeList12 {
    /**
     * An edition from a UK publisher sold only in territories where exclusive rights are not held. Rights details
     * should be carried in PR.21 (in ONIX 2.1) OR P.21 (in ONIX 3.0 or later) as usual
     */
    UK_open_market_edition("01", "UK open market edition"),

    /**
     * In UK, an edition intended primarily for airside sales in UK airports, though it may be available for sale in
     * other territories where exclusive rights are not held. Rights details should be carried in PR.21 (in ONIX 2.1) OR
     * P.21 (in ONIX 3.0 or later) as usual
     */
    Airport_edition("02", "Airport edition"),

    /**
     * In Germany, a special printing sold at a lower price than the regular hardback
     */
    Sonderausgabe("03", "Sonderausgabe"),

    /**
     * In countries where recognised as a distinct trade category, eg France &#171;&#160;livre de poche&#160;&#187;,
     * Germany ,Taschenbuch', Italy &#171;tascabile&#187;, Spain &#171;libro de bolsillo&#187;
     */
    Pocket_book("04", "Pocket book"),

    /**
     * Edition produced solely for sale in designated export markets
     */
    International_edition_US("05", "International edition (US)"),

    /**
     * Audio product sold in special durable packaging and with a replacement guarantee for the contained cassettes or
     * CDs for a specified shelf-life
     */
    Library_audio_edition("06", "Library audio edition"),

    /**
     * An edition from a US publisher sold only in territories where exclusive rights are not held. Rights details
     * should be carried in PR.21 (in ONIX 2.1) OR P.21 (in ONIX 3.0 or later) as usual
     */
    US_open_market_edition("07", "US open market edition"),

    /**
     * In France, a category of book that has a particular legal status, claimed by the publisher
     */
    Livre_scolaire_declare_par_lediteur("08", "Livre scolaire, déclaré par l’éditeur"),

    /**
     * In France, a category of book that has a particular legal status, designated independently of the publisher
     */
    Livre_scolaire_non_specifie("09", "Livre scolaire (non spécifié)"),

    /**
     * Edition published for sale only with a newspaper or periodical
     */
    Supplement_to_newspaper("10", "Supplement to newspaper"),

    /**
     * In Spain, a school textbook for which there is no fixed or suggested retail price and which is supplied by the
     * publisher on terms individually agreed with the bookseller
     */
    Precio_libre_textbook("11", "Precio libre textbook"),

    /**
     * For editions sold only through newsstands/newsagents
     */
    News_outlet_edition("12", "News outlet edition"),

    /**
     * In the US and Canada, a book that is published primarily for use by students in school or college education as a
     * basis for study. Textbooks published for the elementary and secondary school markets are generally purchased by
     * school districts for the use of students. Textbooks published for the higher education market are generally
     * adopted for use in particular classes by the instructors of those classes. Textbooks are usually not marketed to
     * the general public, which distinguishes them from trade books. Note that trade books adopted for course use are
     * not considered to be textbooks (though a specific education edition of a trade title may be)
     */
    US_textbook("13", "US textbook"),

    /**
     * 'Short' e-book (sometimes also called a 'single'), typically containing a single short story, an essay or piece
     * of long-form journalism
     */
    E_book_short("14", "E-book short"),

    /**
     * In countries where recognised as a distinct trade category, eg Italy &#171;supertascabile&#187;. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Superpocket_book("15", "Superpocket book"),

    /**
     * Category of books, usually hardcover and of a large format (A4 or larger) and printed on high-quality paper,
     * where the primary features are illustrations, and these are more important than text. Sometimes called
     * 'coffee-table books' or 'art books' in English. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Beau_livre("16", "Beau-livre"),

    /**
     * Category of audio products typically distinguished by being free of charge (but which may be monetised through
     * advertising content) and episodic. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Podcast("17", "Podcast"),

    /**
     * Category of books or e-books which are single issues of a periodical publication, sold as independent products.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Periodical("18", "Periodical"),

    /**
     * Publisher's or supplier's catalog (when treated as a product in its own right). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Catalog("19", "Catalog"),

    /**
     * Category of books containing a linked group of plates, tables, diagrams, lists, often but not always combined
     * with maps or a geographical theme or approach. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Atlas("20", "Atlas");

    public final String code;
    public final String description;

    TradeCategorys(String code, String description) {
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

    private static volatile Map<String, TradeCategorys> map;

    private static Map<String, TradeCategorys> map() {
        Map<String, TradeCategorys> result = map;
        if (result == null) {
            synchronized (TradeCategorys.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TradeCategorys e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TradeCategorys byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<TradeCategorys> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
