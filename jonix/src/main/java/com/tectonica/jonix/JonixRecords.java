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

import com.tectonica.jonix.unify.BaseRecord;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.util.GlobScanner;
import com.tectonica.xmlchunk.XmlChunkerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import repackaged.org.apache.commons.io.input.BOMInputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.tectonica.jonix.JonixFactory.headerFromElement;
import static com.tectonica.jonix.JonixFactory.productFromElement;

public class JonixRecords implements Iterable<JonixRecord> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JonixRecords.class);

    @FunctionalInterface
    public interface OnSourceEvent {
        void onSource(JonixSource jonixSource);
    }

    private final InputStream inputStream;
    private final List<File> files;
    private final List<OnSourceEvent> onSourceStartEvents = new ArrayList<>();
    private final List<OnSourceEvent> onSourceEndEvents = new ArrayList<>();
    private final Map<String, Object> globalConfig = new HashMap<>();

    private String encoding = "UTF-8";

    /**
     * not to be called directly, used {@link Jonix#source(InputStream)}
     */
    JonixRecords(InputStream inputStream) {
        this.inputStream = Objects.requireNonNull(inputStream);
        this.files = new ArrayList<>();
    }

    /**
     * not to be called directly, used {@link Jonix#source(List)}
     */
    JonixRecords(List<File> files) {
        this.inputStream = null;
        this.files = new ArrayList<>(Objects.requireNonNull(files));
    }

    public JonixRecords source(List<File> files) {
        this.files.addAll(Objects.requireNonNull(files));
        return this;
    }

    public JonixRecords source(File file) {
        this.files.add(Objects.requireNonNull(file));
        return this;
    }

    public JonixRecords source(File folder, String glob, boolean recursive) throws IOException {
        this.files.addAll(GlobScanner.scan(folder, glob, recursive));
        return this;
    }

    public <T> JonixRecords configure(String id, T value) {
        globalConfig.put(id, value);
        return this;
    }

    public Map<String, Object> getConfiguration() {
        return globalConfig;
    }

    public JonixRecords encoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    /**
     * NOTE: can be called more than once to register several event-listeners
     */
    public JonixRecords onSourceStart(OnSourceEvent onSourceStart) {
        this.onSourceStartEvents.add(onSourceStart);
        return this;
    }

    /**
     * NOTE: can be called more than once to register several event-listeners
     */
    public JonixRecords onSourceEnd(OnSourceEvent onSourceEnd) {
        this.onSourceEndEvents.add(onSourceEnd);
        return this;
    }

    public Stream<JonixRecord> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<BaseRecord> streamUnified() {
        return stream().map(JonixUnifier::unifyRecord);
    }

    @Override
    public Iterator<JonixRecord> iterator() {
        return new RecordIterator();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private class RecordIterator implements Iterator<JonixRecord> {
        final List<File> nextFiles;
        JonixSource currentSource;
        Iterator<JonixRecord> currentSourceIterator;
        boolean ignoreException;

        RecordIterator() {
            Boolean failOnException = (Boolean) globalConfig.get("jonix.stream.failOnInvalidFile");
            ignoreException = (failOnException != null && !failOnException);

            nextFiles = files.subList(0, files.size()); // possibly an empty list
            try {
                if (inputStream != null) {
                    currentSourceIterator = sourceIterator(new JonixSource(inputStream));
                }
            } catch (Exception e) {
                handleInvalidFileException(e);
            }
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = (currentSourceIterator != null) && currentSourceIterator.hasNext();

            // if we exhausted the current source, we move on to the next files on the list
            while (!hasNext) {
                // before switching to the next file, fire 'onSourceEnd' event for existing source
                if (currentSource != null) {
                    onSourceEndEvents.forEach(e -> e.onSource(currentSource));
                }

                // if there are no remaining files to open, we can return false, concluding the entire iteration
                if (nextFiles.isEmpty()) {
                    return false;
                }

                // open the next file, which could possibly contain no records to iterate over
                try {
                    File file = nextFiles.remove(0);
                    currentSourceIterator = sourceIterator(new JonixSource(file));
                    hasNext = currentSourceIterator.hasNext();
                } catch (Exception e) {
                    handleInvalidFileException(e);
                }
            }

            return true;
        }

        private void handleInvalidFileException(Exception e) {
            if (ignoreException) {
                LOGGER.warn("Error processing " + currentSource.getSourceName(), e);
            } else {
                throw new RuntimeException(e);
            }
        }

        @Override
        public JonixRecord next() {
            return currentSourceIterator.next();
        }

        Iterator<JonixRecord> sourceIterator(JonixSource jonixSource) throws XMLStreamException {
            currentSource = jonixSource;

            // create iteration context, which holds the XML stream between next() invocations
            final XmlChunkerContext ctx = new XmlChunkerContext(new BOMInputStream(currentSource.stream), encoding, 2);

            // read the first tag in the file, should always be <ONIXMessage>
            StartElement onixMessage = (StartElement) ctx.nextObject();
            // TODO: allow onixMessage = null, and check that it works on empty files
            if (!onixMessage.getName().getLocalPart()
                .equalsIgnoreCase("ONIXMessage")) { // TODO: check if should be 'equals'
                throw new RuntimeException("source doesn't start with the mandatory <ONIXMessage> tag. Found <"
                    + onixMessage.getName().getLocalPart() + ">");
            }

            // given the <ONIXMessage>, determine the ONIX version (provided as an attribute of the tag)
            final Attribute release = onixMessage.getAttributeByName(new QName("release"));
            boolean onix2 = (release == null || release.getValue().startsWith("2"));
            boolean onix3 = (release != null && release.getValue().startsWith("3"));
            if (onix2) {
                currentSource.onixVersion = OnixVersion.ONIX2;
            } else if (onix3) {
                currentSource.onixVersion = OnixVersion.ONIX3;
            } else {
                throw new RuntimeException(
                    "source doesn't comply with either ONIX2 or ONIX3, release is: " + release.getValue());
            }

            // read the first chunk (level-2 element), which should either be a <Product> or <Header>
            Element firstElement = ctx.nextChunk();
            // TODO: allow firstProduct = null, and check that it works on files with not tags under OnixMessage
            boolean hasHeader = firstElement.getNodeName().equalsIgnoreCase("Header");
            if (hasHeader) {
                currentSource.header = headerFromElement(firstElement, currentSource.onixVersion);
            }
            onSourceStartEvents.forEach(e -> e.onSource(currentSource));

            if (hasHeader) {
                // if the first chunk (level-2 element) was a <Header>, the next one must be a <Product>
                firstElement = ctx.nextChunk();
            }

            // TODO: allow firstElement = null, and check that it works on files with only header tag
            // TODO: Handle Onix3's <NoProduct>
            //if (onix3) {
            //    boolean noProduct =
            //        firstElement.getNodeName().equals("NoProduct") || firstElement.getNodeName().equals("x507");
            //}

            if (!firstElement.getNodeName().equalsIgnoreCase("Product")) {
                throw new RuntimeException("expected <Product> tag, found <" + firstElement.getNodeName() + ">");
            }

            // the context now points to the first product in the input-stream, we can start iterate
            final Element firstProduct = firstElement;
            return new Iterator<JonixRecord>() {
                Element nextProduct = firstProduct;

                @Override
                public boolean hasNext() {
                    return (nextProduct != null);
                }

                @Override
                public JonixRecord next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }

                    Element product = nextProduct;
                    try {
                        nextProduct = ctx.nextChunk();
                    } catch (XMLStreamException e) {
                        throw new RuntimeException(e);
                    }

                    // TODO: verify the product is indeed <Product> ?

                    currentSource.productsProcessed++;
                    return new JonixRecord(globalConfig, currentSource,
                        productFromElement(product, currentSource.onixVersion));
                }
            };
        }
    }
}
