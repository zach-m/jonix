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
import javax.xml.stream.events.StartElement;
import java.io.InputStream;

//CHECKSTYLE:OFF
/**
 * An XML data extraction class, intended for XML source that has the following properties:
 * <p>
 * <ul> <li>May be infinitely large (can't be held in memory in its entirety) <li>Has a repetitive structure, where
 * sub-XML records of interest are all located at some constant depth/level <li>Sub-XML records are small enough to be
 * read and parsed in memory </ul>
 * <p>
 * The XML source will be broken into 'chunks', each representing one XML sub-tree positioned at the target depth. The
 * chunk will be passed to the caller as an in-memory DOM {@link Element}.
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
public class XmlChunker {
    /**
     * An interface that the user of {@link XmlChunker} must implement in order to get the 'chunks' extracted from the
     * XML source
     *
     * @author Zach Melamed
     */
    @FunctionalInterface
    public interface Listener {
        /**
         * Fired for elements in the XML source positioned at a level lower than the target depth, giving the user a
         * chance to look at their name and attributes
         *
         * @param depth   level at which the element is positioned
         * @param element the element itself (this is NOT a DOM element)
         */
        default void onPreTargetStart(int depth, StartElement element) {
        }

        /**
         * Fired with an in-memory DOM representation of an XML sub-tree positioned at the target depth
         *
         * @return whether or not to continue to the next chunk (i.e. false means break the parsing)
         */
        boolean onChunk(Element element);
    }

    /**
     * Extracts 'chunks' of an XML source into a user-provided {@link Listener}
     *
     * @param is          the {@link InputStream} of the XML source
     * @param encoding    the text encoding of the XML source (use {@code "UTF-8"} if not sure)
     * @param targetDepth the level at which the chunks are positioned in the XML source
     * @param listener    an implementation of a {@link Listener} for taking the chunks
     */
    public static void parse(InputStream is, String encoding, int targetDepth, Listener listener) {
        try {
            XmlChunkerContext ctx = new XmlChunkerContext(is, encoding, targetDepth);

            Object next;
            while ((next = ctx.nextObject()) != null) {
                if (next instanceof StartElement) {
                    listener.onPreTargetStart(ctx.getDepth(), (StartElement) next);
                } else if (next instanceof Element) {
                    boolean resume = listener.onChunk((Element) next);
                    if (!resume) {
                        break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
