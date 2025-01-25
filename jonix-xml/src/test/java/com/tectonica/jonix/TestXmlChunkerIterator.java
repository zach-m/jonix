/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.tectonica.xmlchunk.XmlChunkerIterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

public class TestXmlChunkerIterator {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void xmlReadParseAndCountUsingIterator() throws XMLStreamException {
        InputStream stream = TestXmlChunkerIterator.class.getResourceAsStream("/tester.xml");
        XmlChunkerIterator iter = new XmlChunkerIterator(stream, "UTF-8", 2);
        long count = 0;
        while (iter.hasNext()) {
            count++;
            iter.next();
        }
        Assert.assertEquals(count, 5L);
    }
}
