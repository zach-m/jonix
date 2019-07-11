module jonix {
    requires transitive jonix.common;
    requires transitive jonix.onix2;
    requires transitive jonix.onix3;
    requires transitive jonix.xml;

    requires java.xml;
    requires slf4j.api;

    exports com.tectonica.jonix;
    exports com.tectonica.jonix.unify;
    exports com.tectonica.jonix.unify.base;
    exports com.tectonica.jonix.unify.base.util;
    exports com.tectonica.jonix.unify.base.onix2;
    exports com.tectonica.jonix.unify.base.onix3;
    exports com.tectonica.jonix.tabulate;
    exports com.tectonica.jonix.util;
    exports com.tectonica.jonix.experimental;
}