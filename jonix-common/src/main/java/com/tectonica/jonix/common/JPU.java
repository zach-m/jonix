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

package com.tectonica.jonix.common;

import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * JPU (Jonix Processing Utility) is an all-static internal utility class, assisting in run time processing of the DOM
 * elements. Shouldn't be accessed normally by users.
 * <p>
 * IMPORTANT: Beware editing! the auto-generated classes all rely heavily on the methods in this class
 *
 * @author Zach Melamed
 */
public class JPU {
    public static Element firstElemChild(Node node) {
        final NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node item = childNodes.item(i);
            if ((item.getNodeType() == Node.ELEMENT_NODE)) {
                return (Element) item;
            }
        }
        return null;
    }

    public static Element nextElemChild(Node node) {
        Node item = node.getNextSibling();
        while (item != null && (item.getNodeType() != Node.ELEMENT_NODE)) {
            item = item.getNextSibling();
        }
        return (Element) item;
    }

    @FunctionalInterface
    public interface ElementListener {
        void onElement(Element element);
    }

    public static void forElementsOf(Node node, ElementListener listener) {
        for (Element element = firstElemChild(node); element != null; element = nextElemChild(element)) {
            listener.onElement(element);
        }
    }

    public static String getAttribute(Element element, String name) {
        final String value = element.getAttribute(name);
        return value.isEmpty() ? null : value;
    }

    public static String getContentAsString(Element element) {
        return getChildText(element);
    }

    @SuppressWarnings("ConstantConditions")
    public static Integer getContentAsInteger(Element element) {
        final String s = getChildText(element);
        return (s.isEmpty() ? null : Integer.valueOf(s));
    }

    @SuppressWarnings("ConstantConditions")
    public static Double getContentAsDouble(Element element) {
        final String s = getChildText(element);
        return (s.isEmpty() ? null : Double.valueOf(s));
    }

    private static String getChildText(Node node) {
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

        return str.toString().trim();
    }

    //static {
    //    System.setProperty("javax.xml.transform.TransformerFactory",
    //        "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
    //}
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public static String getChildXHTML(Node node, boolean strip) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = transformerFactory.newTransformer(); // TODO: check if the instance can be singleton
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

    public static <T> List<T> addToList(List<T> in, T item) {
        List<T> out = (in.size() > 0) ? in : new ArrayList<>();
        out.add(item);
        return out;
    }

    public static <E extends OnixElement<V>, V> ListOfOnixElement<E, V> addToList(ListOfOnixElement<E, V> in, E item) {
        ListOfOnixElement<E, V> out = (in.size() > 0) ? in : new ListOfOnixElement<>();
        out.add(item);
        return out;
    }

    public static <C extends OnixDataComposite<S>, S extends JonixStruct> ListOfOnixDataComposite<C, S> addToList(
        ListOfOnixDataComposite<C, S> in, C item) {
        ListOfOnixDataComposite<C, S> out = (in.size() > 0) ? in : new ListOfOnixDataComposite<>();
        out.add(item);
        return out;
    }

    public static <C extends OnixDataCompositeWithKey<S, K>,
        S extends JonixKeyedStruct<K>,
        K extends Enum<K> & OnixCodelist> ListOfOnixDataCompositeWithKey<C, S, K> addToList(
        ListOfOnixDataCompositeWithKey<C, S, K> in, C item) {
        ListOfOnixDataCompositeWithKey<C, S, K> out = (in.size() > 0) ? in : new ListOfOnixDataCompositeWithKey<>();
        out.add(item);
        return out;
    }

    public static Integer convertStringToInteger(String s) {
        return (s == null) ? null : Integer.parseInt(s.trim());
    }

    /**
     * converts if possible, but returns null if the string isn't an integer
     */
    public static Integer convertStringToIntegerSafe(String s) {
        try {
            return convertStringToInteger(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double convertStringToDouble(String s) {
        return (s == null) ? null : Double.parseDouble(s.trim());
    }

    /**
     * deals with all sorts of extra-characters that may come along with a double, such as currency symbol, quotes,
     * etc.
     */
    public static Double convertStringToDoubleSafe(String s) {
        try {
            return convertStringToDouble(s);
        } catch (NumberFormatException e) {
            s = s.trim();

            if (s.isEmpty()) {
                return null;
            }

            if (Character.getType(s.charAt(0)) == Character.CURRENCY_SYMBOL) {
                return convertStringToDoubleSafe(s.substring(1));
            }

            final boolean quoted1 = s.startsWith("'") && s.endsWith("'");
            final boolean quoted2 = s.startsWith("\"") && s.endsWith("\"");
            final boolean quoted3 = s.startsWith("`") && s.endsWith("`");
            if (quoted1 || quoted2 || quoted3) {
                return convertStringToDoubleSafe(s.substring(1, s.length() - 1));
            }

            return null;
        }
    }
}
