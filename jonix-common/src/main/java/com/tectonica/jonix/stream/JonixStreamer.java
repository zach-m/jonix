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

package com.tectonica.jonix.stream;

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.w3c.dom.Element;

import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

/**
 * an implementation of streamer based on the {@link XmlChunker} class, with file/folder support
 * 
 * @author zach
 */
public class JonixStreamer extends JonixAbstractFileStreamer
{
	public JonixStreamer(JonixExtractor extractor)
	{
		super(extractor);
	}

	protected void readSource(InputStream source, String encoding)
	{
		XmlChunker.parse(new BOMInputStream(source), encoding, 2, listener);
	}

	private XmlChunker.Listener listener = new XmlChunker.Listener()
	{
		@Override
		public void onPreTargetStart(int depth, StartElement element)
		{
			if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
				throw new RuntimeException("source doesn't start with the mandatory <ONIXMessage> tag");
			final Attribute release = element.getAttributeByName(new QName("release"));
			boolean onix2 = (release == null || release.getValue().startsWith("2"));
			boolean onix3 = (release != null && release.getValue().startsWith("3"));
			if (onix2)
				sourceOnixVersion = JonixOnixVersion.ONIX2;
			else if (onix3)
				sourceOnixVersion = JonixOnixVersion.ONIX3;
			else
				throw new RuntimeException("source doesn't comply with neither ONIX2 nor ONIX3");
		}

		@Override
		public void onChunk(Element element)
		{
			final String nodeName = element.getNodeName();
			if (nodeName.equalsIgnoreCase("Header"))
			{
				onHeaderElement(element);
			}
			else if (nodeName.equalsIgnoreCase("Product"))
			{
				++productNo;
				onProductElement(element);
			}
		}
	};
}
