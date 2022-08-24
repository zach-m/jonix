/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.util.List;
import java.util.ListIterator;

public class XmlChunkerReader implements XMLEventReader {
    private final ListIterator<XMLEvent> iter;
    private final XMLEventReader reader;

    public XmlChunkerReader(List<XMLEvent> events, XMLEventReader reader) {
        this.iter = events.listIterator();
        this.reader = reader;
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        return iter.next();
    }

    @Override
    public void remove() {
        iter.remove();
    }

    @Override
    public XMLEvent peek() throws XMLStreamException {
        XMLEvent event = iter.next();
        iter.previous();
        return event;
    }

    @Override
    public String getElementText() throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    @Override
    public XMLEvent nextTag() throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getProperty(String name) throws IllegalArgumentException {
        return reader.getProperty(name);
    }

    @Override
    public void close() throws XMLStreamException {
    }
}
