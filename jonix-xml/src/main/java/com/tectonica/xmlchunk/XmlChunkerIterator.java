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

package com.tectonica.xmlchunk;

import org.w3c.dom.Element;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

//CHECKSTYLE:OFF
/**
 * An iterator for XML data extraction, intended for XML source that has the following properties:
 * <p>
 * <ul> <li>May be infinitely large (can't be held in memory in its entirety) <li>Has a repetitive structure, where
 * sub-XML records of interest are all located at some constant depth/level </ul>
 * <p>
 * The XML source will be broken into 'chunks', each representing one XML sub-tree positioned at the target depth
 * (assuming it is small enough to fit in memory). The chunk will be returned by this iterator's {@link #next()} method
 * as an in-memory DOM {@link Element}.
 * <p>
 * For example, given the following XML:
 * <p>
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;Level1&gt;
 *     &lt;Level2a&gt;
 *         ..
 *         &lt;Level3a&gt;
 *             ..
 *             &lt;Level4&gt;
 *                 ..
 *             &lt;/Level4&gt;
 *             ..
 *         &lt;/Level3a&gt;
 *
 *         &lt;Level3b&gt;
 *             ..
 *         &lt;/Level3b&gt;
 *         ..
 *     &lt;/Level2a&gt;
 *
 *     &lt;Level2b&gt;
 *     ..
 *     &lt;/Level2b&gt;
 * &lt;/Level1&gt; *
 * </pre>
 * <p>
 * Requesting a target depth of 2 would yield two chunks, {@code <Level2a>..</Level2a>} (including its entire sub-tree),
 * and {@code <Level2b>..</Level2b>}.
 *
 * @author Zach Melamed
 */
//CHECKSTYLE:ON
public class XmlChunkerIterator implements Iterator<Element> {
    private final XmlChunkerContext ctx;
    private Element nextChunk;

    public XmlChunkerIterator(InputStream is, String encoding, int targetDepth) throws XMLStreamException {
        ctx = new XmlChunkerContext(is, encoding, targetDepth);
        nextChunk = ctx.nextChunk();
    }

    @Override
    public boolean hasNext() {
        return (nextChunk != null);
    }

    @Override
    public Element next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Element chunk = nextChunk;
        try {
            nextChunk = ctx.nextChunk();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return chunk;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}