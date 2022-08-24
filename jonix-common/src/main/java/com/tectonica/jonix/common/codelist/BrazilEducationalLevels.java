/*
 * Copyright (C) 2012-2020 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 238 (Brazil educational level)
 */
interface CodeList238 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 238</b>
 * <p>
 * Description: Brazil educational level
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist238">ONIX
 *      Codelist 238 in Reference Guide</a>
 */
public enum BrazilEducationalLevels implements OnixCodelist, CodeList238 {
    /**
     * Preschool and kindergarten
     */
    Educacao_Infantil("K", "Educação Infantil"),

    /**
     * Elementary school
     */
    Fundamental_I_1_ano("1", "Fundamental I 1º ano"),

    Fundamental_I_2_ano("2", "Fundamental I 2º ano"),

    Fundamental_I_3_ano("3", "Fundamental I 3º ano"),

    Fundamental_I_4_ano("4", "Fundamental I 4º ano"),

    Fundamental_I_5_ano("5", "Fundamental I 5º ano"),

    Fundamental_II_6_ano("6", "Fundamental II 6º ano"),

    Fundamental_II_7_ano("7", "Fundamental II 7º ano"),

    Fundamental_II_8_ano("8", "Fundamental II 8º ano"),

    Fundamental_II_9_ano("9", "Fundamental II 9º ano"),

    /**
     * High school
     */
    Ensino_Medio_1_ano("10", "Ensino Médio 1º ano"),

    Ensino_Medio_2_ano("11", "Ensino Médio 2º ano"),

    Ensino_Medio_3_ano("12", "Ensino Médio 3º ano"),

    /**
     * Technical study at High school, alongside 2nd and 3rd year
     */
    Ensino_Tecnico_Integrado("13", "Ensino Técnico Integrado"),

    /**
     * Technical study at separate institution in parallel with 2nd and 3rd year High school study
     */
    Ensino_Tecnico_Concomitante("14", "Ensino Técnico Concomitante"),

    /**
     * Technical study after completion of High school
     */
    Ensino_Tecnico_Subsequente("15", "Ensino Técnico Subsequente"),

    /**
     * University entrance
     */
    Ensino_pre_vestibular("P", "Ensino pré-vestibular"),

    /**
     * Undergraduate degree level
     */
    Ensino_Superior_Graduacao_Licenciatura_Bacharelado("A", "Ensino Superior Graduação Licenciatura/ Bacharelado"),

    Ensino_Superior_Graduacao_Tecnologia("B", "Ensino Superior Graduação Tecnologia"),

    /**
     * Masters and Doctoral degree level
     */
    Ensino_Superior_Pos_graduacao_Stricto_sensu("D", "Ensino Superior Pós-graduação Stricto sensu"),

    /**
     * Professional qualifications
     */
    Ensino_Superior_Pos_graduacao_Lato_sensu("F", "Ensino Superior Pós-graduação Lato sensu");

    public final String code;
    public final String description;

    BrazilEducationalLevels(String code, String description) {
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

    private static volatile Map<String, BrazilEducationalLevels> map;

    private static Map<String, BrazilEducationalLevels> map() {
        Map<String, BrazilEducationalLevels> result = map;
        if (result == null) {
            synchronized (BrazilEducationalLevels.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BrazilEducationalLevels e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BrazilEducationalLevels byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
