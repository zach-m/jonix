module jonix.common {
    requires transitive java.xml;

    exports com.tectonica.jonix.common;
    exports com.tectonica.jonix.common.codelist;
    exports com.tectonica.jonix.common.struct;

    // reflection is not blocked (needed for JSON serialization etc.)
    opens com.tectonica.jonix.common.codelist;
    opens com.tectonica.jonix.common.struct;
}