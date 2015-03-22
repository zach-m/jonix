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

package com.tectonica.jonix;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * an all-static Jonix Processing Utility class, assisting in run time processing of the DOM elements.
 * <p>
 * IMPORTANT: don't edit! the auto-generated classes all rely heavily on the methods in this class
 * 
 * @author Zach Melamed
 */
public class JPU
{
	public static Element firstElemChild(Node node)
	{
		final NodeList childNodes = node.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++)
		{
			final Node item = childNodes.item(i);
			if ((item.getNodeType() == Node.ELEMENT_NODE))
				return (Element) item;
		}
		return null;
	}

	public static Element nextElemChild(Node node)
	{
		Node item = node.getNextSibling();
		while (item != null && (item.getNodeType() != Node.ELEMENT_NODE))
			item = item.getNextSibling();
		return (Element) item;
	}

	public static interface ElementListener
	{
		void onElement(Element element);
	}

	public static void forElementsOf(Node node, ElementListener listener)
	{
		for (Element element = firstElemChild(node); element != null; element = nextElemChild(element))
			listener.onElement(element);
	}

	public static String getAttribute(Element element, String name)
	{
		final String value = element.getAttribute(name);
		return value.isEmpty() ? null : value;
	}

	public static String getContentAsString(Element element)
	{
		return getChildText(element);
	}

	public static Integer getContentAsInteger(Element element)
	{
		final String s = getChildText(element);
		return (s.isEmpty() ? null : Integer.valueOf(s));
	}

	public static Double getContentAsDouble(Element element)
	{
		final String s = getChildText(element);
		return (s.isEmpty() ? null : Double.valueOf(s));
	}

	private static String getChildText(Node node)
	{
		if (node == null)
			return null;

		StringBuffer str = new StringBuffer();
		Node child = node.getFirstChild();
		while (child != null)
		{
			short type = child.getNodeType();
			if (type == Node.TEXT_NODE)
				str.append(child.getNodeValue());
			else if (type == Node.CDATA_SECTION_NODE)
				str.append(getChildText(child));
			child = child.getNextSibling();
		}

		return str.toString();
	}

	public static String getChildXHTML(Node node, boolean strip)
	{
		StringWriter sw = new StringWriter();
		try
		{
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		}
		catch (TransformerException e)
		{
			throw new RuntimeException(e);
		}
		final String content = sw.toString();

		if (strip)
		{
			final int beginIndex = content.indexOf(">") + 1;
			final int endIndex = content.lastIndexOf("<");
			if (endIndex > beginIndex)
				return content.substring(beginIndex, endIndex);
		}
		return content;
	}

	public static <T> List<T> addToList(List<T> in, T item)
	{
		List<T> out = (in != null) ? in : new ArrayList<T>();
		out.add(item);
		return out;
	}
}
