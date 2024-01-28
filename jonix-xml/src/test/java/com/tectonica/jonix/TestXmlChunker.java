/*
 * Copyright (C) 2012-2024 Zach Melamed
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

import com.tectonica.xmlchunk.XmlChunker;
import com.tectonica.xmlchunk.XmlUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Element;

import javax.xml.stream.events.StartElement;
import java.io.InputStream;

public class TestXmlChunker {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private static class TagCounter implements XmlChunker.Listener {
        public long preCounter = 0L;
        public long chunkCounter = 0L;

        @Override
        public boolean onChunk(Element element) {
            chunkCounter++;
            return true;
        }

        @Override
        public void onPreTargetStart(int depth, StartElement element) {
            preCounter++;
        }
    }

    @Test
    public void xmlReadParseAndCountAtLevel2() {
        InputStream stream = TestXmlChunker.class.getResourceAsStream("/tester.xml");
        TagCounter tagCounter = new TagCounter();
        XmlChunker.parse(stream, "UTF-8", 2, tagCounter);
        Assert.assertEquals(tagCounter.preCounter, 1L);
        Assert.assertEquals(tagCounter.chunkCounter, 5L);
    }

    @Test
    public void xmlReadParseAndCountAtLevel3() {
        InputStream stream = TestXmlChunker.class.getResourceAsStream("/tester.xml");
        TagCounter tagCounter = new TagCounter();
        XmlChunker.parse(stream, "UTF-8", 3, tagCounter);
        Assert.assertEquals(tagCounter.preCounter, 1L + 5L);
        Assert.assertEquals(tagCounter.chunkCounter, 3L);
    }

    @Test
    @Ignore
    public void xmlReadParseAndThenWriteAsRegeneratedXml() {
        InputStream stream = TestXmlChunker.class.getResourceAsStream("/tester.xml");

        XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener() {
            @Override
            public boolean onChunk(Element element) {
                // turn the DOM element back to XML
                String asXml = XmlUtil.elementToString(element, false);

                System.out.println("\t" + asXml);
                System.out.println("------------------------------------------------------------------------------");

                return true;
            }

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final String localPart = element.getName().getLocalPart();
                System.out.println("FOUND TAG: " + localPart + " @ " + depth);
                System.out.println("------------------------------------------------------------------------------");
            }
        });
    }
}
