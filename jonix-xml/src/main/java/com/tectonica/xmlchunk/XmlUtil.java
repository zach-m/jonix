/*
 * Copyright (C) 2012-2026 Zach Melamed
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

package com.tectonica.xmlchunk;

import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class XmlUtil {
    /**
     * Transforms a DOM {@link Element} into an XML text
     *
     * @param elem  the element to transform into text
     * @param strip if true, removes the containing tag of the XML node
     * @return an XML text representation of the given element
     */
    public static String elementToString(Element elem, boolean strip) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = XmlChunkerContext.transformerFactory.newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.transform(new DOMSource(elem), new StreamResult(sw));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        final String content = sw.toString();

        if (strip) {
            final int beginIndex = content.indexOf(">") + 1;
            final int endIndex = content.lastIndexOf("<");
            if (endIndex > beginIndex) {
                return content.substring(beginIndex, endIndex);
            }
        }
        return content;
    }

    /**
     * Transforms an escaped XML into the original, "un-escaped" value (for example turn &amp;lt;Hello&amp;gt; into
     * &lt;Hello&gt;).
     * <p>
     * If the input contains no {@code &} character it is returned as-is (preserving any actual XML markup). Standard
     * entity references ({@code &lt;}, {@code &gt;}, {@code &amp;}, {@code &apos;}, {@code &quot;}) and numeric
     * character references ({@code &#NNN;} / {@code &#xHHH;}) are decoded; unknown named entities are left unchanged.
     *
     * @param escaped the (possibly escaped) XML string
     * @return the un-escaped string
     */
    public static String unescape(String escaped) {
        if (escaped == null || !escaped.contains("&")) {
            return escaped;
        }
        StringBuilder sb = new StringBuilder(escaped.length());
        int i = 0;
        while (i < escaped.length()) {
            if (escaped.charAt(i) == '&') {
                int end = escaped.indexOf(';', i + 1);
                if (end > i) {
                    String decoded = decodeXmlRef(escaped.substring(i + 1, end));
                    if (decoded != null) {
                        sb.append(decoded);
                        i = end + 1;
                        continue;
                    }
                }
            }
            sb.append(escaped.charAt(i));
            i++;
        }
        return sb.toString();
    }

    private static String decodeXmlRef(String ref) {
        switch (ref) {
            case "lt":
                return "<";
            case "gt":
                return ">";
            case "amp":
                return "&";
            case "apos":
                return "'";
            case "quot":
                return "\"";
            default:
                if (ref.startsWith("#")) {
                    try {
                        int codePoint =
                            (ref.startsWith("#x") || ref.startsWith("#X")) ? Integer.parseInt(ref.substring(2), 16)
                                : Integer.parseInt(ref.substring(1));
                        return new String(Character.toChars(codePoint));
                    } catch (IllegalArgumentException e) {
                        return null;
                    }
                }
                return null; // unknown named entity — leave as-is
        }
    }
}
