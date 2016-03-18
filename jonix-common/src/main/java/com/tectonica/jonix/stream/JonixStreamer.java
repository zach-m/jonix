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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

/**
 * This is a fundamental class in Jonix. Its role is to read ONIX source(s), and fire two types of events as it parses
 * the ONIX records:
 * <ul>
 * <li> {@code onHeaderElement} - when an ONIX &lt;Header&gt; tag was parsed (once per ONIX source)
 * <li> {@code onProductElement} - when an ONIX &lt;Product&gt; tag was parsed
 * </ul>
 * The events are fired to an <b>extractor</b> - some implementation of {@link JonixExtractor} (passed in the
 * constructor), which does the actual processing of the data when sources are being read by this streamer.
 * <p>
 * When events are fired, they pass a DOM {@link Element} to the extractor, which is the most fundamental form of the
 * ONIX data. Jonix offers several built-in extractors to transform the DOM elements into higher-level objects. Also,
 * when starting to process an ONIX source, its ONIX version is detected (available at {@link #getSourceOnixVersion()})
 * and its product count is being tracked (available at {@link #getProductNo()}).
 * <p>
 * This class basically exposes one public API, {@link #read(InputStream, String)} which takes an {@link InputStream} as
 * the ONIX source (of course it may be called repeatedly). However, if your ONIX input is stored in files and
 * directories, you may benefit from the extra services offered by the subclass {@link JonixFilesStreamer}.
 * <p>
 * The processing of the ONIX sources by this class is based on Jonix's built-in {@link XmlChunker} service, which can
 * read infinitely large sources by handling them in 'chunks'. You may offer your own implementation by overriding
 * {@link JonixStreamer#readSource(InputStream, String)}.
 * 
 * @author Zach Melamed
 */
public class JonixStreamer
{
	protected static final Logger LOG = LoggerFactory.getLogger(JonixStreamer.class);

	protected final JonixExtractor extractor;
	protected int productNo = 0;
	protected JonixOnixVersion sourceOnixVersion = JonixOnixVersion.UNKNOWN;

	/**
	 * provided extractor may be SHARED between streamers
	 * 
	 * @param extractor
	 */
	public JonixStreamer(JonixExtractor extractor)
	{
		if (extractor == null)
			throw new NullPointerException("extractor is required");
		this.extractor = extractor;
	}

	public JonixOnixVersion getSourceOnixVersion()
	{
		return sourceOnixVersion;
	}

	public int getProductNo()
	{
		return productNo;
	}

	// /////////////////////////////////////////////////////////////////////////////////

	protected void readSource(InputStream source, String encoding)
	{
		XmlChunker.parse(new BOMInputStream(source), encoding, 2, new XmlChunkerListener());
	}

	protected class XmlChunkerListener implements XmlChunker.Listener
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

	// ///////////////////////////////////////////////////////////////////////////////

	public void read(final InputStream source)
	{
		read(source, "UTF-8");
	}

	public void read(final InputStream source, final String encoding)
	{
		if (extractor.onBeforeSource(source, this))
		{
			try
			{
				readSource(source, encoding);
			}
			catch (Exception e)
			{
				LOG.error("Couldn't process source " + source + ", encoding: " + encoding, e);
				throw new RuntimeException(e);
			}
			extractor.onAfterSource(this);
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// ACCESSOR FUNCTIONS FOR CUSTOM STREAMERS OUTSIDE THE PACKAGE

	protected void onHeaderElement(Element element)
	{
		extractor.onHeaderElement(element, this);
	}

	protected void onProductElement(Element element)
	{
		extractor.onProductElement(element, this);
	}
}
