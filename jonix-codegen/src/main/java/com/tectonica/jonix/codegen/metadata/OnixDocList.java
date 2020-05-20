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

import com.tectonica.jonix.codegen.util.XML;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class OnixDocList extends ArrayList<OnixDoc> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnixDocList.class);

    public final Set<String> allTags = new TreeSet<>();

    public OnixDocList(Document doc) {
        super();

        // we generate our documentation by looking at all the elements in the spec-HTML that are part of a
        // key-value table (technically a <dl> tag), where the key is "Reference Name" (hence the value is the ONIX
        // class name of the element/composite)
        final Elements dts = doc.select("dt.referencename");

        for (Element dt : dts) {
            // each "referencename" dt should be a child of a <dl>, which in itself is a child of a <section>,
            // containing the documentation for the ONIX class.
            // so we start with some basic verifications

            // verify that the <dt> is inside a <dl>
            final Element dl = dt.parent();
            if (!"dl".equals(dl.tagName())) {
                throw new RuntimeException("expected <dl>, found " + dl.outerHtml());
            }

            // verify that the <dl> is inside a <section>
            final Element section = dl.parent();
            if (!"section".equals(section.tagName())) {
                throw new RuntimeException("expected <section>, found " + section.outerHtml());
            }

            // verify that the <section> pertains to an ONIX composite/element
            if (!isOnixCompositeOrElement(section)) {
                throw new RuntimeException("section that is neither an element nor a composite found: "
                    + section.outerHtml().substring(0, 200));
            }

            // we start constructing our documentation object
            final OnixDoc onixDoc = new OnixDoc();

            Set<String> sectionTags = section.classNames();
            onixDoc.tags = sectionTags;
            allTags.addAll(sectionTags);

            // the content of the <section> preceding the <dl> starts with the title of the ONIX class, and continues
            // with a free text description. We will read this content backwards, from the <dl> to the title.
            StringBuilder escapedDescription = new StringBuilder();
            Element p = dl;
            while ((p = p.previousElementSibling()) != null) {

                String tag = p.tagName();
                boolean titleReached = "h5".equals(tag) || "h4".equals(tag) || "h3".equals(tag);
                if (!titleReached) {
                    // as long as we haven't hit the heading tag with the title, we accumulate the description
                    escapedDescription.insert(0, p.outerHtml()); // we use insert, as we process contents backwards

                } else {
                    // title has been hit
                    String title = p.text();

                    // if exists, strip away preceding group markers (e.g. "PR.2.4" or "P.25.11f")
                    if (title.startsWith("PR.") || title.startsWith("MH.")
                        || title.startsWith("P.") || title.startsWith("H.")) {
                        int i = title.indexOf(" ");
                        onixDoc.title = title.substring(i + 1);
                        onixDoc.groupMarker = title.substring(0, i);
                    } else {
                        onixDoc.title = title;
                    }

                    // nothing interesting above the title
                    break;
                }
            }
            onixDoc.escapedDescription = escapedDescription.toString();

            // we're done with the free-text part, now we extract the <dl>, which is a key-value table with two types
            // of elements for each 'detail': <dt> containing a key, and (one or more) <dd> containing values
            onixDoc.details = new ArrayList<>();
            OnixDoc.Detail onixDocDetail = null;
            for (Element detail : dl.children()) {
                final String tag = detail.tagName();
                if (tag.equals("dt")) {
                    // this is the 'key' part of the detail
                    // we start by figuring out the type of the key (should be mapped to OnixDoc.DetailType)
                    String detailName = detail.className();
                    int spaceIndex = detailName.indexOf(" ");
                    if (spaceIndex > 0) {
                        LOGGER.warn("Ignoring secondary class(es): '{}'", detailName.substring(spaceIndex + 1));
                        detailName = detailName.substring(0, spaceIndex);
                    }
                    onixDocDetail = new OnixDoc.Detail(detailName);
                    if (onixDocDetail.detailType == OnixDoc.DetailType.unknown) {
                        LOGGER.warn("Unknown detailType: '{}' (of text '{}') in '{}'",
                            detailName, detail.text(), onixDoc.title);
                    }
                    // done processing the <dt> part
                    onixDoc.details.add(onixDocDetail);
                } else {
                    // this is the 'value' part of the onixDocDetail we've just created (upon <dt> processing)
                    if (!tag.equals("dd")) {
                        throw new RuntimeException("expecting only <dt> or <dd> under the <dl>, found " + tag);
                    }
                    if (onixDocDetail == null) {
                        throw new RuntimeException("inside <dl>, <dd> was encountered before <dt>");
                    }

                    // we read and (re-) HTML-escape the value, adding <tt> where ONIX used <samp> (for code fragments)
                    String line = detail.text().trim();
                    Element samp = detail.selectFirst("samp");
                    if (samp != null) {
                        String text = samp.text();
                        line = line.replace(text, "$TTs$" + text + "$TTe$");
                    }
                    String escapedLine = XML.escape(line).replace("$TTs$", "<tt>").replace("$TTe$", "</tt>");

                    // if the value pertains to an ONIX class name, some extra handling is needed
                    boolean isOnixClassName = (onixDocDetail.detailType == OnixDoc.DetailType.referencename)
                        || (onixDocDetail.detailType == OnixDoc.DetailType.shorttag);
                    if (isOnixClassName) {
                        // in onix3 documentation, the angle brackets are implemented as style, so we now trim
                        // the explicit brackets in onix2 documentation, so that we can re-add them to both
                        String onixClassName = line.replaceAll("[</>]", "");
                        escapedLine = "<tt>" + XML.escape("<" + onixClassName + ">") + "</tt>";

                        // specifically, we use the <dd> of the reference-name as our onixClassName, for future lookup
                        if (onixDocDetail.detailType == OnixDoc.DetailType.referencename) {
                            onixDoc.onixClassName = onixClassName;

                            // now is also a good opportunity to build the ancestry of composites, by checking the
                            // parent sections
                            List<String> onixClassPath = new ArrayList<>();
                            Element s = section;
                            while (s.tagName().equals("section")) {
                                if (isOnixCompositeOrElement(s)) {
                                    Element refnameDT = s.selectFirst("dl > dt.referencename");
                                    Element refnameDD = refnameDT.nextElementSibling();
                                    if (!refnameDD.tagName().equals("dd")) {
                                        throw new RuntimeException("expected <dd> after <dt.referencename>");
                                    }
                                    String parentClassName = refnameDD.text().replaceAll("[</>]", "");
                                    onixClassPath.add(0, parentClassName); // built bottom-up
                                }
                                s = s.parent();
                            }
                            onixDoc.path = "ONIXMessage/" + String.join("/", onixClassPath);
                        }
                    } else {
                        // like onixClassName, we keep the format in its own field (in addition to being in the details)
                        if (onixDocDetail.detailType == OnixDoc.DetailType.format) {
                            onixDoc.escapedFormat = escapedLine;
                        }
                    }

                    // done processing the <dd> (one or many) part
                    onixDocDetail.escapedLines.add(escapedLine);
                }
            }

            add(onixDoc);
        }

    }

    private boolean isOnixCompositeOrElement(Element section) {
        Set<String> sectionClasses = section.classNames();
        if (sectionClasses.contains("composite") || sectionClasses.contains("element")) {
            return true;
        }
        if ("section3_pr13_subject".equals(section.id())) {
            LOGGER.warn("Ignoring known error in Onix2 doc where section #section3_pr13_subject "
                + "is not classified as 'composite'");
            return true;
        }
        return false;
    }

    public OnixDoc findByGroupMarker(String groupMarker) {
        for (OnixDoc onixDoc : this) {
            if (groupMarker.equals(onixDoc.groupMarker)) {
                return onixDoc;
            }
        }
        return null;
    }

    public String toHtml() {
        StringBuilder sb = new StringBuilder("<html><body>\n");
        sb.append("<head><meta charset='UTF-8'></head>\n");
        for (OnixDoc onixDoc : this) {
            sb.append(onixDoc.toHtml(true)).append("\n");
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    public String toGroupCsv() {
        StringBuilder sb = new StringBuilder("group,path\n");
        for (OnixDoc onixDoc : this) {
            if (onixDoc.groupMarker != null) {
                sb.append(onixDoc.groupMarker).append(',').append(onixDoc.path).append('\n');
            }
        }
        return sb.toString();
    }
}