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

    private static final String SPECS_3_0_06_DIR = "/xsd/onix3.0_2019-04-26_rev06_codelist45/";

    public static final OnixSpecs SPECS_3_0_06_REF = new OnixSpecs(
        OnixVersion.Onix3,
        false,
        SPECS_3_0_06_DIR + "ONIX_BookProduct_3.0_reference.xsd",
        SPECS_3_0_06_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_06_DIR + "ONIX_for_Books_Format_Specification_3.0.6.html",
        "45"
    );

    public static final OnixSpecs SPECS_3_0_06_SHORT = new OnixSpecs(
        OnixVersion.Onix3,
        true,
        SPECS_3_0_06_DIR + "ONIX_BookProduct_3.0_short.xsd",
        SPECS_3_0_06_DIR + "ONIX_BookProduct_CodeLists.xsd",
        SPECS_3_0_06_DIR + "ONIX_for_Books_Format_Specification_3.0.6.html",
        "45"
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
