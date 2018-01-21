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

package com.tectonica.jonix.codegen.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DOM {
    public static Element firstElemChild(Node node) {
        return firstElemChild(node, null);
    }

    public static Element firstElemChild(Node node, String nodeName) {
        final NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node item = childNodes.item(i);
            if ((item.getNodeType() == Node.ELEMENT_NODE)
                && (nodeName == null || nodeName.equals(item.getNodeName()))) {
                return (Element) item;
            }
        }
        return null;
    }

    public static Element firstElemChild(Node node, String nodeName, String attrName, String attrValue) {
        final NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node item = childNodes.item(i);
            if ((item.getNodeType() == Node.ELEMENT_NODE)
                && (nodeName == null || nodeName.equals(item.getNodeName()))) {
                final Element elem = (Element) item;
                if (elem.getAttribute(attrName).equals(attrValue)) {
                    return elem;
                }
            }
        }
        return null;
    }

    public static Element nextElemChild(Node node) {
        return nextElemChild(node, null);
    }

    public static Element nextElemChild(Node node, String nodeName) {
        Node item = node.getNextSibling();
        while (item != null
            && !((item.getNodeType() == Node.ELEMENT_NODE) && (nodeName == null || nodeName.equals(item
            .getNodeName())))) {
            item = item.getNextSibling();
        }
        return (Element) item;
    }

    public static interface ElementListener {
        void onElement(Element element);
    }

    public static void forElementsOf(Node node, ElementListener worker) {
        forElementsOf(node, null, worker);
    }

    public static void forElementsOf(Node node, String nodeName, ElementListener worker) {
        for (Element element = firstElemChild(node, nodeName); element != null; element = nextElemChild(element,
            nodeName)) {
            worker.onElement(element);
        }
    }

    public static String getChildText(Node node) {
        if (node == null) {
            return null;
        }

        StringBuilder str = new StringBuilder();
        Node child = node.getFirstChild();
        while (child != null) {
            short type = child.getNodeType();
            if (type == Node.TEXT_NODE) {
                str.append(child.getNodeValue());
            } else if (type == Node.CDATA_SECTION_NODE) {
                str.append(getChildText(child));
            }
            child = child.getNextSibling();
        }

        return str.toString();
    }

    public static String getChildXHTML(Node node, boolean strip) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
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

    public static void ensureTagNames(final Element firstChild, final List<String> allowedTagNames) {
        if (firstChild == null || allowedTagNames == null || allowedTagNames.size() == 0) {
            return;
        }

        Set<String> allowedTagNamesSet = new HashSet<>(allowedTagNames);
        Element child = firstChild;
        do {
            final String nonContentType = child.getNodeName();
            if (!allowedTagNamesSet.contains(nonContentType)) { // TODO: account for case-insensitivity
                throw new RuntimeException("we only expect one content node");
            }
        }
        while ((child = DOM.nextElemChild(child)) != null);
    }

}
