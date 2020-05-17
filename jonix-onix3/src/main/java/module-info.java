module jonix.onix3 {
    requires transitive jonix.common;
    requires transitive jonix.xml;

    requires java.xml;

    exports com.tectonica.jonix.onix3;

    opens com.tectonica.jonix.onix3; // reflection is not blocked (needed for JSON serialization etc.)
}