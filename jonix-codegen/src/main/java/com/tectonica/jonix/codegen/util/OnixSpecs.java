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

package com.tectonica.jonix.codegen.util;

public class OnixSpecs {

    public enum OnixVersion {
        Onix2, Onix3
    }

    private static final String SPECS_2_1_03_DIR = "/xsd/onix2.1_2013-11-15_rev03_codelist36/";
    public static final OnixSpecs SPECS_2_1_03_REF = new OnixSpecs(
        OnixVersion.Onix2,
        false,
        SPECS_2_1_03_DIR + "ONIX_BookProduct_Release2.1_reference.xsd",
        SPECS_2_1_03_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_2_1_03_DIR + "ONIX_for_Books_Format_Specification_2.1.4.html",
        "36"
    );
    public static final OnixSpecs SPECS_2_1_03_SHORT = new OnixSpecs(
        OnixVersion.Onix2,
        true,
        SPECS_2_1_03_DIR + "ONIX_BookProduct_Release2.1_short.xsd",
        SPECS_2_1_03_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_2_1_03_DIR + "ONIX_for_Books_Format_Specification_2.1.4.html",
        "36"
    );

    private static final String SPECS_3_0_07_DIR = "/xsd/onix3.0_2019-10-31_rev07_codelist49/";
    public static final OnixSpecs SPECS_3_0_07_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_07_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_07_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_07_DIR + "ONIX_for_Books_Format_Specification_3.0.7.html",
        "49"
    );
    public static final OnixSpecs SPECS_3_0_07_SHORT = new OnixSpecs(
        OnixVersion.Onix3,
        true,
        SPECS_3_0_07_DIR + "ONIX_BookProduct_3.0_short.xsd",
        SPECS_3_0_07_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_07_DIR + "ONIX_for_Books_Format_Specification_3.0.7.html",
        "49"
    );

    public static final OnixSpecs SPECS_3_0_LATEST_REF = SPECS_3_0_07_REF;
    public static final OnixSpecs SPECS_3_0_LATEST_SHORT = SPECS_3_0_07_SHORT;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String SPECS_3_0_06_DIR = "/xsd/onix3.0_2019-04-26_rev06_codelist45/";
    public static final OnixSpecs SPECS_3_0_06_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_06_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_06_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_06_DIR + "ONIX_for_Books_Format_Specification_3.0.6.html",
        "45"
    );

    private static final String SPECS_3_0_01_DIR = "/xsd/onix3.0_2013-04-24_rev01_codelist23/";
    public static final OnixSpecs SPECS_3_0_01_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_01_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_01_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_01_DIR + "ONIX_for_Books_Format_Specification_3.0.1.html",
        "23"
    );

    private static final String SPECS_3_0_02_DIR = "/xsd/onix3.0_2016-01-24_rev02_codelist32/";
    public static final OnixSpecs SPECS_3_0_02_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_02_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_02_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_02_DIR + "ONIX_for_Books_Format_Specification_3.0.2.html",
        "32"
    );

    private static final String SPECS_3_0_03_DIR = "/xsd/onix3.0_2016-04-25_rev03_codelist38/";
    public static final OnixSpecs SPECS_3_0_03_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_03_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_03_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_03_DIR + "ONIX_for_Books_Format_Specification_3.0.3.html",
        "38"
    );

    private static final String SPECS_3_0_04_DIR = "/xsd/onix3.0_2017-10-26_rev04_codelist42/";
    public static final OnixSpecs SPECS_3_0_04_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_04_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_04_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_04_DIR + "ONIX_for_Books_Format_Specification_3.0.4.html",
        "42"
    );

    private static final String SPECS_3_0_05_DIR = "/xsd/onix3.0_2018-10-26_rev05_codelist44/";
    public static final OnixSpecs SPECS_3_0_05_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_05_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_05_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_05_DIR + "ONIX_for_Books_Format_Specification_3.0.5.html",
        "44"
    );

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final OnixVersion onixVersion;
    public final boolean isShort;
    public final String structureXsd;
    public final String codelistXsd;
    public final String specHtml;
    public final String codelistIssue;

    public OnixSpecs(OnixVersion onixVersion, boolean isShort, String structureXsd, String codelistXsd,
                     String specHtml, String codelistIssue) {
        this.onixVersion = onixVersion;
        this.isShort = isShort;
        this.structureXsd = structureXsd;
        this.codelistXsd = codelistXsd;
        this.specHtml = specHtml;
        this.codelistIssue = codelistIssue;
    }
}
