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

package com.tectonica.jonix.codegen.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonPropertyOrder( {"onixClassName", "tags", "title", "groupMarker", "escapedDescription", "details", "onixClassPath"})
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

        DetailType(String label) {
            this.label = label;
        }
    }

    @JsonPropertyOrder( {"detailType", "escapedLines"})
    public static class Detail {
        public DetailType detailType;
        public List<String> escapedLines = new ArrayList<>();

        public Detail() {
        }

        public Detail(String detailName) {
            try {
                detailType = DetailType.valueOf(detailName);
            } catch (IllegalArgumentException e) {
                detailType = DetailType.unknown;
            }
        }
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////

    public String onixClassName;

    @JsonIgnore
    public String escapedFormat;

    /**
     * Possible values as of Onix-3.06:
     * <ul>
     * <li>ONIX2: [composite, deprecated, element, new210, new211, new212, new213, new214]
     * <li>ONIX3: [composite, deprecated, element, mod304, new301, new302, new303, new304, new305, new306]
     * </ul>
     */
    public Set<String> tags;

    public String title;

    public String groupMarker;

    public String escapedDescription;

    /**
     * key-value pairs, which will be added to the javadocs as a table
     */
    public List<OnixDoc.Detail> details;

    public String path;

    public String toHtml(boolean extended) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append(title).append("</h1>");
        if (extended) {
            sb.append("<p><tt><b>&lt;").append(onixClassName).append("&gt;</b></tt>  ")
                .append(tags).append(" (").append(groupMarker).append(")").append("</p>");
            sb.append("<p><tt><i>").append(path.replaceAll("/", " ⯈ ")).append("</i></tt></p>");
        }
        sb.append(escapedDescription);
        sb.append("<table border='1' cellpadding='3'>");
        for (OnixDoc.Detail detail : details) {
            if (detail.escapedLines.size() == 0) {
                continue;
            }

            boolean first = true;
            for (String line : detail.escapedLines) {
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
                sb.append(line);
                sb.append("</td>");

                sb.append("</tr>");
            }
        }
        sb.append("</table>");
        return sb.toString();
    }
}