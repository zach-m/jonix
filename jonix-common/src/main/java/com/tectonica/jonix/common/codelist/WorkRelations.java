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
 * marker interface to assist in IDE navigation to code-list 164 (Work relation)
 */
interface CodeList164 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 164</b>
 * <p>
 * Description: Work relation
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist164">ONIX
 *      Codelist 164 in Reference Guide</a>
 */
public enum WorkRelations implements OnixCodelist, CodeList164 {
    /**
     * Product A is or includes a manifestation of work X. (There is a direct parent-child relation between work X and
     * the product). The instance of &lt;RelatedWork&gt; must include an identifier for work X
     */
    Manifestation_of("01", "Manifestation of"),

    /**
     * Product A is or includes a manifestation of a work X which is derived (directly) from related work W in one or
     * more of the ways specified in the former ISTC rules. (There is a relationship between a grandparent work W and a
     * parent work X, and between that parent work and the product.) This relation type is intended to enable products
     * with a common 'grandparent' work to be linked without specifying the precise nature of their derivation, and
     * without necessarily assigning an identifier to the product's parent work X. The instance of &lt;RelatedWork&gt;
     * must include an identifier for work W. Codes 20-30 may be used instead to provide details of the derivation of
     * work X from work W
     */
    Derived_from("02", "Derived from"),

    /**
     * Product A is a manifestation of a work X from which related work Y is (directly) derived in one or more of the
     * ways specified in the former ISTC rules. (There is a relationship between a parent work X and a child work Y, and
     * between the parent work X and the product.) The instance of &lt;RelatedWork&gt; must include an identifier for
     * work Y. Codes 40-50 may be used instead to provide details of the derivation of work Y from work X
     */
    Related_work_is_derived_from_this("03", "Related work is derived from this"),

    /**
     * Product A is a manifestation of a work X in the same (bibliographic) collection as related work Z. (There is a
     * relationship between the parent work X and a 'same collection' work Z, and between the parent work X and the
     * product.) The instance of &lt;RelatedWork&gt; must include an identifier for work Z
     */
    Other_work_in_same_bibliographic("04", "Other work in same (bibliographic) collection"),

    /**
     * Product A is a manifestation of a work X by the same contributor(s) as related work Z. (There is a relationship
     * between the parent work X and a work Z where X and Z have at least one contributor in common, and between the
     * parent work X and the product.) The instance of &lt;RelatedWork&gt; must include an identifier for work Z
     */
    Other_work_by_same_contributor("05", "Other work by same contributor"),

    /**
     * Product A is or includes a manifestation of work X. (There is a direct parent-child relation between work X and
     * the product, and work X is original, ie not a derived work of any kind - there is no work W.) The instance of
     * &lt;RelatedWork&gt; must include an identifier for work X. See code 01 if the originality of X is unspecified or
     * unknown
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Manifestation_of_original_work("06", "Manifestation of original work"),

    /**
     * Product A is or includes a manifestation of a work X which is derived directly from related work W by
     * abridgement. (There is a relationship between the grandparent [unabridged] work W and the parent [abridged] work
     * X, and between the parent work X and the product.) The instance of &lt;RelatedWork&gt; must include an identifier
     * for [unabridged] work W. &lt;EditionType&gt; of product A would normally be ABR. See code 02 if the method of
     * derivation of X from W is unknown or unstated. The [abridged] parent work X may be identified using a separate
     * instance of &lt;RelatedWork&gt; with relation code 01
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_abridgement("21", "Derived from by abridgement"),

    /**
     * Product A is or includes a manifestation of a work X which is derived directly from related work W by annotation.
     * The instance of &lt;RelatedWork&gt; must include an identifier for [unannotated] work W. &lt;EditionType&gt; of
     * product X would normally be ANN, VAR etc. See code 02 if the method of derivation of X from W is unknown or
     * unstated. The [annotated] parent work X may be identified using a separate instance of &lt;RelatedWork&gt; with
     * relation code 01
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_annotation("22", "Derived from by annotation"),

    /**
     * The content of the work X has been formed by compilation of work W and another work Z. The instance of
     * &lt;RelatedWork&gt; must include an identifier for work W. &lt;EditionType&gt; of product A may be CMB. Work Z
     * may be identified using a separate instance of &lt;RelatedWork&gt; with code 23. The compiled parent work X may
     * be identified using a separate instance of &lt;Related&gt; work with relation code 01
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_compilation("23", "Derived from by compilation"),

    /**
     * The content of the work W has been augmented by the addition of critical commendary to form work X. The instance
     * of &lt;RelatedWork&gt; must include an identifier for work W. &lt;EditionType&gt; of Product A would normally be
     * CRI
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_criticism("24", "Derived from by criticism"),

    /**
     * The content of the work X is an excerpt from work W. The instance of &lt;RelatedWork&gt; must include an
     * identifier for [complete] work W
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_excerption("25", "Derived from by excerption"),

    /**
     * Offensive or unsuitable text material has been removed from work W to form work X. The instance of
     * &lt;RelatedWork&gt; must include an identifier for [unsuitable] work W. &lt;EditionType&gt; of Product A would
     * normally be EXP
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_expurgation("26", "Derived from by expurgation"),

    /**
     * The content of work W has been augmented by the addition of significant non-textual elements to form work X. The
     * instance of &lt;RelatedWork&gt; must include an identifier for [unaugmented] work W. &lt;EditionType&gt; of
     * product A may be ILL, ENH etc
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_addition_of_non_text_material("27", "Derived from by addition (of non-text material)"),

    /**
     * The content of work W has been revised and/or expanded or enlarged to form work X [including addition, deletion
     * or replacement of text material]. The instance of &lt;RelatedWork&gt; must include an identifier for [unrevised]
     * work W. &lt;EditionType&gt; of product A may be REV, NED, etc, or A may be numbered
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_revision("28", "Derived from by revision"),

    /**
     * The content of work W has been translated into another language to form work X. The instance of
     * &lt;RelatedWork&gt; must include an identifier for [untranslated] work W
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_via_translation("29", "Derived from via translation"),

    /**
     * The content of work W has been adapted [into a different literary form] to form work X. The instance of
     * &lt;RelatedWork&gt; must include an identifier for [unadapted] work W. &lt;EditionType&gt; of product A would
     * normally be ADP, ACT etc
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_via_adaptation("30", "Derived from via adaptation"),

    /**
     * The content of work W has been modified by the removal of significant non-textual elements to form work X. The
     * instance of &lt;RelatedWork&gt; must include an identifier for work W
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Derived_from_by_subtraction_of_non_text_material("31", "Derived from by subtraction (of non-text material)"),

    /**
     * Product A is a manifestation of a work X from which the related work Y is (directly) derived by abridgement.
     * (There is a relationship between the parent [unabridged] work X and the child [abridged] work Y, and between
     * parent work X and the product.) The instance of &lt;RelatedWork&gt; must include the identifier for [abridged]
     * work Y. See code 03 if the method of derivation of Y from X is unknown or unstated. The [unabridged] parent work
     * X may be identified using a separate instance of &lt;RelatedWork&gt; with relation code 01 or 06
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_abridgement("41", "Related work is derived from this by abridgement"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_annotation("42", "Related work is derived from this by annotation"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_compilation("43", "Related work is derived from this by compilation"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_criticism("44", "Related work is derived from this by criticism"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_excerption("45", "Related work is derived from this by excerption"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_expurgation("46", "Related work is derived from this by expurgation"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_addition_of_non_text_material("47",
        "Related work is derived from this by addition (of non-text material)"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_by_revision("48", "Related work is derived from this by revision"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_via_translation("49", "Related work is derived from this via translation"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Related_work_is_derived_from_this_via_adaptation("50", "Related work is derived from this via adaptation"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Derived_from_this_by_subtraction_of_non_text_material("51",
        "Derived from this by subtraction (of non-text material)"),

    /**
     * Product A is or includes a manifestation of an expression of LRM work X. Do not use, except as a workaround for
     * differences between LRM works and expressions, and ONIX works in LRM library practice, and always also include a
     * relationship to an ONIX work using code 01
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Manifestation_of_LRM_work("98", "Manifestation of LRM work"),

    /**
     * Product A is or includes a manifestation of an LRM expression with the same content, same agents and in the same
     * modality (text, audio, video etc) as work X. Do not use, except as a workaround for differences between LRM
     * expressions and ONIX works in LRM library practice, and always also include a relationship to an ONIX work using
     * code 01
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Manifestation_of_LRM_expression("99", "Manifestation of LRM expression");

    public final String code;
    public final String description;

    WorkRelations(String code, String description) {
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

    private static volatile Map<String, WorkRelations> map;

    private static Map<String, WorkRelations> map() {
        Map<String, WorkRelations> result = map;
        if (result == null) {
            synchronized (WorkRelations.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (WorkRelations e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static WorkRelations byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<WorkRelations> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
