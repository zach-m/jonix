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
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class OnixDocs extends ArrayList<OnixDoc> {
    private static Logger LOGGER = LoggerFactory.getLogger(OnixDocs.class);

    public final Set<String> allTags = new HashSet<>();

    public OnixDocs() {
        super();
    }

    public OnixDocs(Document doc) {
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

                // find the description and title from the elements preceding the <dl> in the <section>
                onixDoc.descriptionHtml = "";
                Element p = dl;
                while ((p = p.previousElementSibling()) != null) {
                    if ("h5".equals(p.tagName())) {
                        onixDoc.title = p.text();
                        if (onixDoc.title.startsWith("PR.") || onixDoc.title.startsWith("MH.")
                            || onixDoc.title.startsWith("P.") || onixDoc.title.startsWith("H.")) {
                            int i = onixDoc.title.indexOf(" ");
                            onixDoc.title = onixDoc.title.substring(i + 1);
                        }
                    } else {
                        onixDoc.descriptionHtml = p.outerHtml() + onixDoc.descriptionHtml;
                    }
                }

                // find the details
                onixDoc.details = new ArrayList<>();
                OnixDoc.Detail onixDocDetail = null;
                for (Element detail : dl.children()) {
                    final String tag = detail.tagName();
                    if (tag.equals("dt")) {
                        onixDocDetail = new OnixDoc.Detail(detail.className());
                        onixDoc.details.add(onixDocDetail);
                    } else {
                        String line = detail.text().trim();
                        if (onixDocDetail.detailType == OnixDoc.DetailType.referencename
                            || onixDocDetail.detailType == OnixDoc.DetailType.shorttag) {
                            // in onix3 documentation, the angle brackets are as implemented as style
                            String onixClassName = line.replaceAll("(<|>|/)", "");
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
                LOGGER.warn("Exception:  " + e.toString());
                LOGGER.warn("In section: " + section.outerHtml());
                LOGGER.warn("------------------------------------------------------------------");
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