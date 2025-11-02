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
 * marker interface to assist in IDE navigation to code-list 85 (Bible purpose)
 */
interface CodeList85 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 85</b>
 * <p>
 * Description: Bible purpose
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist85">ONIX
 *      Codelist 85 in Reference Guide</a>
 */
public enum BiblePurposes implements OnixCodelist, CodeList85 {
    /**
     * A Bible (or selected Biblical text) designed for presentation from a religious organization
     */
    Award("AW", "Award"),

    /**
     * A Bible (or selected Biblical text) designed to be a gift to commemorate a child's birth
     */
    Baby("BB", "Baby"),

    /**
     * A special gift Bible (or selected Biblical text) designed for the bride on her wedding day. Usually white
     */
    Bride("BR", "Bride"),

    /**
     * A text Bible (or selected Biblical text) designed in presentation and readability for a child
     */
    Childrens("CH", "Children’s"),

    /**
     * A Bible (or selected Biblical text) specifically intended as a gift or keepsake for a child's Christening or
     * baptism, often with personalization features like a presentation page, space to record milestones, and sometimes
     * even illustrations or stories tailored for young children. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Christening_Baptism_gift("CT", "Christening / Baptism gift"),

    /**
     * A small Bible (or selected Biblical text) with a trim height of five inches or less
     */
    Compact("CM", "Compact"),

    /**
     * A Bible (or selected Biblical text) designed to be used in the confirmation reading or as a gift to a confirmand
     */
    Confirmation("CF", "Confirmation"),

    /**
     * A Bible (or selected Biblical text) which includes text conveying cross-references to related scripture passages
     */
    Cross_reference("CR", "Cross-reference"),

    /**
     * A Bible (or selected Biblical text) laid out to provide readings for each day of the year
     */
    Daily_readings("DR", "Daily readings"),

    /**
     * A Bible (or selected Biblical text) containing devotional content together with the scripture
     */
    Devotional("DV", "Devotional"),

    /**
     * A Bible (or selected Biblical text) containing family record pages and / or additional study material for family
     * devotion
     */
    Family("FM", "Family"),

    /**
     * A Bible or (selected Biblical text) specifically intended as a gift or keepsake for a communicant's first
     * communion. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    First_communion("FC", "First communion"),

    /**
     * A standard Bible (or selected Biblical text) of any version with no distinguishing characteristics beyond the
     * canonical text
     */
    General_Text("GT", "General / Text"),

    /**
     * A Bible (or selected Biblical text) designed for gift or presentation, often including a presentation page
     */
    Gift("GF", "Gift"),

    /**
     * A Bible (or selected Biblical text) designed with extra space in the margins or on dedicated pages for notes,
     * personal reflections or creative expression. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Journaling_notetaking("JN", "Journaling / notetaking"),

    /**
     * A large Bible (or selected Biblical text) with large print designed for use in reading scriptures in public
     * worship from either the pulpit or lectern. Usually in a fine binding and elaborately decorated
     */
    Lectern_Pulpit("LP", "Lectern / Pulpit"),

    /**
     * A Bible (or selected Biblical text) especially designed with helps and study guides oriented to the adult male
     */
    Mens("MN", "Men’s"),

    /**
     * A Bible (or selected Biblical text) designed for distribution to those outside of the church, often at a lower
     * cost or in a more accessible format. They are intended to be shared with people who may not already own a Bible,
     * and frequently feature helpful resources like introductions to key concepts, guidance on common questions, and
     * explanations of salvation for those exploring faith or new believers. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Outreach("OT", "Outreach"),

    /**
     * A Bible (or selected Biblical text) intended as a practical resource for pastors, offering guidance and tools for
     * various aspects of ministry. It typically includes additional articles, sermon outlines, and special service
     * templates, alongside standard Biblical text. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pastoral("PA", "Pastoral"),

    /**
     * Usually inexpensive but sturdy, a Bible (or selected Biblical text) designed for use in church pews
     */
    Pew("PW", "Pew"),

    /**
     * A Bible (or selected Biblical text) specifically designed with features that are helpful for public speaking and
     * delivering sermons, including a larger font size, wider margins for taking notes, and a layout that makes it easy
     * to locate verses quickly. Smaller and le. Only for use in ONIX 3.0 or laterss elaborately-decorated than a Pulpit
     * Bible
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Preaching("PR", "Preaching"),

    /**
     * A Bible (or selected Biblical text) designed for use in primary school
     */
    Primary_school("PS", "Primary school"),

    /**
     * A Bible (or selected Biblical text) laid out as single-column text, with no footnotes or verse numbers, like a
     * 'normal' book. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Readers("RD", "Reader’s"),

    /**
     * A Bible (or selected Biblical text) including texts in Greek and / or Hebrew and designed for scholarly study
     */
    Scholarly("SC", "Scholarly"),

    Slimline("SL", "Slimline"),

    /**
     * A Bible (or selected Biblical text) with study articles and helps especially for use in the classroom
     */
    Student("ST", "Student"),

    /**
     * A Bible (or selected Biblical text) with many extra features, e.g. book introductions, dictionary, concordance,
     * references, maps, etc, to help readers better understand the scripture
     */
    Study("SU", "Study"),

    /**
     * A special gift Bible (or selected Biblical text) designed as a gift to the couple on their wedding day
     */
    Wedding_gift("WG", "Wedding gift"),

    /**
     * A devotional or study Bible (or selected Biblical text) with helps targeted at the adult woman
     */
    Womens("WM", "Women’s"),

    /**
     * A Bible (or selected Biblical text) containing special study and devotional helps designed specifically for the
     * needs of teenagers or young adults
     */
    Youth_Teen("YT", "Youth / Teen");

    public final String code;
    public final String description;

    BiblePurposes(String code, String description) {
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

    private static volatile Map<String, BiblePurposes> map;

    private static Map<String, BiblePurposes> map() {
        Map<String, BiblePurposes> result = map;
        if (result == null) {
            synchronized (BiblePurposes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BiblePurposes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BiblePurposes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BiblePurposes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
