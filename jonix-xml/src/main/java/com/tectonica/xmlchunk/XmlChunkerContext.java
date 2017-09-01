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

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stax.StAXSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class XmlChunkerContext {
    static final XMLInputFactory inputFactory;
    static final TransformerFactory transformerFactory;
    static final XmlChunkerEndDocument endDocumentEvent = new XmlChunkerEndDocument();

    static {
        inputFactory = XMLInputFactory.newInstance();

        // no need to validate, or even try to access, the remote DTD file
        inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

        // no need to validate internal entities - this is important because ONIX files are designed to contain HTML
        // sections inside them. these sections may include entities (such as '&nbsp;') that aren't XML-compatible
        inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

        // this is our Transformer of choice
        System.setProperty("javax.xml.transform.TransformerFactory",
            "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
        transformerFactory = TransformerFactory.newInstance();
    }

    private int depth;
    private List<XMLEvent> events;
    private XMLEventReader reader;
    private XMLEvent startDocumentEvent;
    private int targetDepth;

    XmlChunkerContext(InputStream is, String encoding, int targetDepth) throws XMLStreamException {
        depth = -1;
        events = null;
        reader = inputFactory.createXMLEventReader(is, encoding);
        startDocumentEvent = null;
        this.targetDepth = targetDepth;
    }

    int getDepth() {
        return depth;
    }

    Element nextChunk() throws XMLStreamException {
        Object next;
        while ((next = nextObject()) != null) {
            if (next instanceof Element) {
                return (Element) next;
            }
        }
        return null;
    }

    Object nextObject() throws XMLStreamException {
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            Object retVal = null;

            if (event.isStartDocument()) {
                depth = 0;
                startDocumentEvent = event;
            } else if (depth < 0) {
                continue;
            }

            if (event.isStartElement()) {
                depth++;
                if (depth < targetDepth) {
                    retVal = event.asStartElement();
                } else if (depth == targetDepth) {
                    events = new ArrayList<>();
                }
            }

            if (events != null) {
                events.add(event);
            }

            if (event.isEndElement()) {
                if (depth == targetDepth) {
                    retVal = elementFromEvents();
                    events = null;
                }
                depth--;
            }

            if (retVal != null) {
                return retVal;
            }
        }
        return null;
    }

    private Element elementFromEvents() throws XMLStreamException {
        List<XMLEvent> domEvents = new ArrayList<>();
        domEvents.add(startDocumentEvent);
        domEvents.addAll(events);
        domEvents.add(endDocumentEvent);

        XmlChunkerReader xmlEventReader = new XmlChunkerReader(domEvents, reader);

        DOMResult dom = new DOMResult();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new StAXSource(xmlEventReader), dom);
            return (Element) dom.getNode().getFirstChild();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}