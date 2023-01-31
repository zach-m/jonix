module jonix.onix2 {
    requires transitive jonix.common;
    requires transitive jonix.xml;

    requires transitive java.xml;

    exports com.tectonica.jonix.onix2;

    opens com.tectonica.jonix.onix2; // reflection is not blocked (needed for JSON serialization etc.)
}