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

package com.tectonica.jonix.codegen.metadata;

import com.tectonica.jonix.codegen.util.XML;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class OnixDocList extends ArrayList<OnixDoc> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnixDocList.class);

    public final Set<String> allTags = new TreeSet<>();

    public OnixDocList(Document doc) {
        super();

        final Elements elems = doc.select("dt.referencename");
        elems.remove(0);

        for (Element elem : elems) {
            final Element dl = elem.parent();
            if (!"dl".equals(dl.tagName())) {
                throw new RuntimeException("expected <dl>, found " + dl.outerHtml());
            }

            final Element section = dl.parent();
            if (!"section".equals(section.tagName())) {
                throw new RuntimeException("expected <section>, found " + section.outerHtml());
            }

            try {
                final OnixDoc onixDoc = new OnixDoc();

                onixDoc.tags = section.classNames();
                allTags.addAll(onixDoc.tags);

                // extract the title and description from the elements preceding the <dl> in the <section>
                StringBuilder descriptionHtml = new StringBuilder();
                Element p = dl;
                while ((p = p.previousElementSibling()) != null) {

                    String tag = p.tagName();
                    boolean titleReached = "h5".equals(tag) || "h4".equals(tag) || "h3".equals(tag);
                    if (!titleReached) {
                        // as long as we haven't hit the heading tag with the title, we accumulate the description
                        descriptionHtml.insert(0, p.outerHtml()); // we use insert, as we process tags backwards

                    } else {
                        // title has been hit
                        onixDoc.title = p.text();

                        // if exists, strip away preceding paragraph markers (e.g. "PR.2.4" or "P.25.11f")
                        if (onixDoc.title.startsWith("PR.") || onixDoc.title.startsWith("MH.")
                            || onixDoc.title.startsWith("P.") || onixDoc.title.startsWith("H.")) {
                            int i = onixDoc.title.indexOf(" ");
                            onixDoc.title = onixDoc.title.substring(i + 1);
                        }

                        // nothing interesting above the title
                        break;
                    }
                }
                onixDoc.descriptionHtml = descriptionHtml.toString();

                // extract the details
                onixDoc.details = new ArrayList<>();
                OnixDoc.Detail onixDocDetail = null;
                for (Element detail : dl.children()) {
                    final String tag = detail.tagName();
                    if (tag.equals("dt")) {
                        // this is the 'key' part of the detail
                        // we start by figuring out the type of the key (will be mapped to OnixDoc.DetailType)
                        String detailName = detail.className();
                        int spaceIndex = detailName.indexOf(" ");
                        if (spaceIndex > 0) {
                            LOGGER.warn("Ignoring secondary class '{}'", detailName.substring(spaceIndex + 1));
                            detailName = detailName.substring(0, spaceIndex);
                        }
                        onixDocDetail = new OnixDoc.Detail(detailName);
                        if (onixDocDetail.detailType == OnixDoc.DetailType.unknown) {
                            LOGGER.warn("Unknown detailType: '{}' (of text '{}') in '{}'",
                                detailName, detail.text(), onixDoc.title);
                        }
                        onixDoc.details.add(onixDocDetail);
                    } else {
                        assert onixDocDetail != null;
                        // this is the 'value' part of the detail we've just created
                        String line = detail.text().trim();
                        if (onixDocDetail.detailType == OnixDoc.DetailType.referencename
                            || onixDocDetail.detailType == OnixDoc.DetailType.shorttag) {
                            // in onix3 documentation, the angle brackets are implemented as style, so we now trim
                            // the explicit brackets in onix2 documentation, so that we can re-add them to both
                            String onixClassName = line.replaceAll("[<>]", "");
                            line = "<" + onixClassName + ">";
                            if (onixDocDetail.detailType == OnixDoc.DetailType.referencename) {
                                onixDoc.onixClassName = onixClassName;
                            }
                        } else if (onixDocDetail.detailType == OnixDoc.DetailType.format) {
                            onixDoc.format = XML.escape(line);
                        }
                        onixDocDetail.lines.add(line);
                    }
                }

                add(onixDoc);
            } catch (Exception e) {
                LOGGER.warn("Exception: {}\nIn section: {}\n", e.toString(), section.outerHtml());
            }
        }
    }

    public String toHtml() {
        StringBuilder sb = new StringBuilder("<html><body>\n");
        sb.append("<head><meta charset='UTF-8'></head>\n");
        for (OnixDoc onixDoc : this) {
            sb.append(onixDoc.toHtml()).append("\n");
        }
        sb.append("</body></html>");
        return sb.toString();
    }
}