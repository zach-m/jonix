package com.tectonica.jonix.codegen.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tectonica.jonix.codegen.util.XML;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonPropertyOrder( {"tags", "title", "descriptionHtml", "details"})
public class OnixDoc {
    public enum DetailType {
        format("Format"), //
        codelist("Codelist"), //
        referencename("Reference name"), //
        shorttag("Short tag"), //
        example("Example"), //
        cardinality("Cardinality"), // onix3 only
        attributes("Attributes"), // onix3 only
        notes("Notes"), // onix3 only
        unknown(""); //

        public final String label;

        private DetailType(String label) {
            this.label = label;
        }
    }

    @JsonPropertyOrder( {"detailType", "lines"})
    public static class Detail {
        public DetailType detailType;
        public List<String> lines;

        public Detail() {
        }

        public Detail(String detailName) {
            try {
                detailType = DetailType.valueOf(detailName);
            } catch (IllegalArgumentException e) {
                detailType = DetailType.unknown;
            }
            lines = new ArrayList<>();
        }
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////

    @JsonIgnore
    public String onixClassName;

    @JsonIgnore
    public String format;

    // ONIX2: [new211, new212, deprecated, element, new210, new213, new214, composite]
    // ONIX3: [deprecated, element, new302, composite, new301]
    public Set<String> tags;

    public String title;

    public String descriptionHtml;

    public List<OnixDoc.Detail> details;

    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append(title).append("</h1>");
        //sb.append("<h2>").append(tags.toString()).append("</h2>");
        sb.append(descriptionHtml);
        sb.append("<table border='1' cellpadding='3'>");
        for (OnixDoc.Detail detail : details) {
            if (detail.lines.size() == 0) {
                continue;
            }

            boolean first = true;
            for (String line : detail.lines) {
                if (line.isEmpty()) {
                    continue;
                }

                sb.append("<tr>");

                // first column
                sb.append("<td>");
                if (first) {
                    sb.append(detail.detailType.label);
                    first = false;
                }
                sb.append("</td>");

                // second column
                sb.append("<td>");
                sb.append(XML.escape(line));
                sb.append("</td>");

                sb.append("</tr>");
            }
        }
        sb.append("</table>");
        return sb.toString();
    }
}