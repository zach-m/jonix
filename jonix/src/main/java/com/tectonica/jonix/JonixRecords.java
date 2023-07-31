/*
 * Copyright (C) 2012-2023 Zach Melamed
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

import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.unify.BaseRecord;
import com.tectonica.jonix.unify.BaseUnifier;
import com.tectonica.jonix.unify.CustomUnifier;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.UnifiedHeader;
import com.tectonica.jonix.unify.UnifiedProduct;
import com.tectonica.jonix.unify.UnifiedRecord;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseFactory2;
import com.tectonica.jonix.unify.base.onix3.BaseFactory3;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class provides the mechanism to scan one or more ONIX sources, and process the ONIX records they contain
 * (typically an ONIX <code>Header</code> followed by one or more ONIX <code>Product</code> records).
 * <p>
 * The normal preparation steps of this class are as follows:
 * <ol>
 * <li>Add one or more ONIX sources</li>
 * <li>Set the expected encoding of the sources (default is <code>UTF-8</code>)</li>
 * <li>Optionally, set event handlers to be fired during processing</li>
 * <li>Optionally, set key-value pairs, which will be accessible conveniently during processing</li>
 * </ol>
 * <p>
 * Example:
 * <pre>
 * JonixRecords records = Jonix
 *     .source(new File("/path/to/folder-with-onix-files"), "*.xml", false)
 *     .source(new File("/path/to/file-with-short-style-onix-2.xml"))
 *     .source(new File("/path/to/file-with-reference-style-onix-3.onx"))
 *     .onSourceStart(src -> { // take a look at:
 *         // src.onixVersion()
 *         // src.header()
 *         // src.sourceName()
 *     })
 *     .onSourceEnd(src -> { // take a look at:
 *         // src.productsProcessedCount()
 *     })
 *     .failOnInvalidFile(false);
 * </pre>
 * <p>
 * Once the {@link JonixRecords} is prepared, processing can be done in several ways:
 * <h2>Iteration</h2>
 * First and foremost, {@link JonixRecords} is an {@link Iterable} of {@link JonixRecord}. Hence, it can be iterated
 * over with a simple <code>for</code> loop.
 * The following loop iterates over the ONIX Products in all sources, and handles them whether they're of version Onix2
 * or Onix3.
 * <pre>
 * for (JonixRecord record : records) {
 *     if (record.product instanceof com.tectonica.jonix.onix3.Product) {
 *         com.tectonica.jonix.onix3.Product product3 = (com.tectonica.jonix.onix3.Product) record.product;
 *         // TODO: process the Onix3 &lt;Product>
 *     } else if (record.product instanceof com.tectonica.jonix.onix2.Product) {
 *         com.tectonica.jonix.onix2.Product product2 = (com.tectonica.jonix.onix2.Product) record.product;
 *         // TODO: process the Onix2 &lt;Product>
 *     } else {
 *         throw new IllegalArgumentException();
 *     }
 * }
 * </pre>
 * To continue this example of low-level handling (staying very close to the structure of the XML data), the following
 * is an elaborate version of the code above, pulling out the ISBN and first contributor from all ONIX Products:
 * <pre>
 * for (JonixRecord record : records) {
 *     String isbn13;
 *     String personName = null;
 *     List&lt;ContributorRoles> roles = null;
 *     if (record.product instanceof com.tectonica.jonix.onix2.Product) {
 *         com.tectonica.jonix.onix2.Product product2 = (com.tectonica.jonix.onix2.Product) record.product;
 *         isbn13 = product2.productIdentifiers()
 *             .find(ProductIdentifierTypes.ISBN_13)
 *             .map(pid -> pid.idValue().value)
 *             .orElse(null);
 *         List&lt;com.tectonica.jonix.onix2.Contributor> contributors = product2.contributors();
 *         if (!contributors.isEmpty()) {
 *             com.tectonica.jonix.onix2.Contributor firstContributor = contributors.get(0);
 *             roles = firstContributor.contributorRoles().values();
 *             personName = firstContributor.personName().value;
 *         }
 *     } else if (record.product instanceof com.tectonica.jonix.onix3.Product) {
 *         com.tectonica.jonix.onix3.Product product3 = (com.tectonica.jonix.onix3.Product) record.product;
 *         isbn13 = product3.productIdentifiers()
 *             .find(ProductIdentifierTypes.ISBN_13)
 *             .map(pid -> pid.idValue().value)
 *             .orElse(null);
 *         List&lt;com.tectonica.jonix.onix3.Contributor> contributors = product3.descriptiveDetail().contributors();
 *         if (!contributors.isEmpty()) {
 *             com.tectonica.jonix.onix3.Contributor firstContributor = contributors.get(0);
 *             roles = firstContributor.contributorRoles().values();
 *             personName = firstContributor.personName().value;
 *         }
 *     } else {
 *         throw new IllegalArgumentException();
 *     }
 *     System.out
 *         .println(String.format("Found ISBN %s, first person is %s, his roles: %s", isbn13, personName, roles));
 * }
 * </pre>
 * <h2>Streaming</h2>
 * It is sometime useful to invoke {@link JonixRecords#stream()} and use the resulting {@link Stream} along with Java 8
 * Streaming APIs to achieve greater readability. The following examples retrieves the Onix3 Products from their sources
 * and stores them in an in-memory {@link List}:
 * <pre>
 * import com.tectonica.jonix.onix3.Product;
 * ...
 * List&lt;Product> products3 = records.stream()
 *     .filter(rec -> rec.product instanceof Product)
 *     .map(rec -> (Product) rec.product)
 *     .collect(Collectors.toList());
 * </pre>
 * <h2>Streaming as Unified Record</h2>
 * One of Jonix's best facilities is the <code>Unification</code> framework, allowing to simplify the treatment in
 * varied sources (Onix2 mixed with Onix3 files) and eliminate some of the intricacies of XML handling.
 * The method {@link JonixRecords#streamUnified()} returns a {@link Stream}, but not of the low-level
 * {@link JonixRecord}s. Instead it streams out {@link BaseRecord}s, that contains typed and unified representation of
 * the most essential data within typical ONIX source. The following examples shows how simple it is to extract data
 * from ONIX source without the inherent complications of ONIX diversity:
 * <pre>
 * Set&lt;PriceTypes> requestedPrices = JonixUtil.setOf(PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax);
 * records.streamUnified()
 *     .map(rec -> rec.product)
 *     .forEach(product -> {
 *         String recordReference = product.info.recordReference;
 *         String isbn13 = product.info.findProductId(ProductIdentifierTypes.ISBN_13);
 *         String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
 *         List&lt;String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
 *         List&lt;BasePrice> prices = product.supplyDetails.findPrices(requestedPrices);
 *         List&lt;String> priceLabels = prices.stream()
 *             .map(bp -> bp.priceAmountAsStr + " " + bp.currencyCode).collect(Collectors.toList());
 *         System.out.println(String.format("Found product ref. %s, ISBN='%s', Title='%s', authors=%s, prices=%s",
 *             recordReference, isbn13, title, authors, priceLabels));
 *     });
 * </pre>
 */
public class JonixRecords implements Iterable<JonixRecord> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JonixRecords.class);
    protected final AtomicInteger globalProductCount = new AtomicInteger(0);
    protected boolean failOnInvalidFile = true;

    @FunctionalInterface
    public interface OnSourceEvent {
        void onSource(JonixSource jonixSource);
    }

    private final InputStream inputStream;
    private final List<File> files;
    private final List<OnSourceEvent> onSourceStartEvents = new ArrayList<>();
    private final List<OnSourceEvent> onSourceEndEvents = new ArrayList<>();
    private final Map<String, Object> globalConfig = new HashMap<>();

    boolean skipSourceRequested;

    private boolean openOnlyHeadersRequested;

    private String encoding = "UTF-8";

    /**
     * not to be called directly, use {@link Jonix#source(InputStream)}
     */
    JonixRecords(InputStream inputStream) {
        this.inputStream = Objects.requireNonNull(inputStream);
        this.files = new ArrayList<>();
    }

    /**
     * not to be called directly, use {@link Jonix#source(List)}
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

    /**
     * This method sets the streaming policy when invalid sources are encountered (e.g. file not found). The default
     * behavior is to stop streaming when such error occurs.
     */
    public JonixRecords failOnInvalidFile(boolean fail) {
        failOnInvalidFile = fail;
        return this;
    }

    /**
     * Stores an object for later use during the streaming process. The stored object can be retrieved with
     * {@link #retrieve(String)}.
     */
    public <T> JonixRecords store(String key, T value) {
        globalConfig.put(key, value);
        return this;
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming, or {@code null} if the
     *     {@code key} doesn't exist
     */
    public <T> T retrieve(String key) {
        return (T) globalConfig.get(key);
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming, or {@code defaultValue} if the
     *     {@code key} doesn't exist
     */
    public <T> T retrieve(String key, T defaultValue) {
        return (T) globalConfig.getOrDefault(key, defaultValue);
    }

    public Map<String, Object> getConfiguration() {
        return globalConfig;
    }

    public JonixRecords encoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    /**
     * Registers a listener for <code>SourceStart</code> event, which occurs when a new source is about to be processed
     * but only after the ONIX version and the (optional) ONIX Header have been parsed. These will be available in the
     * {@link JonixSource} of the {@link OnSourceEvent}.
     * <p>
     * NOTE: this method can be called more than once to register several event-listeners
     */
    public JonixRecords onSourceStart(OnSourceEvent onSourceStart) {
        this.onSourceStartEvents.add(onSourceStart);
        return this;
    }

    /**
     * Registers a listener for <code>SourceEnd</code> event, which occurs when after all records have been processed in
     * the recently opened source. In addition to all the information that was available for event-listeners registered
     * with {@link #onSourceStart(OnSourceEvent)}, the {@link JonixSource} when this event is fired also includes
     * {@link JonixSource#productCount()}, with the final count of ONIX Products processed from the source.
     * <p>
     * NOTE: this method can be called more than once to register several event-listeners
     */
    public JonixRecords onSourceEnd(OnSourceEvent onSourceEnd) {
        this.onSourceEndEvents.add(onSourceEnd);
        return this;
    }

    /**
     * @return a {@link Stream} of records, each containing a new {@code Product} object and a reference to the source
     *     from which it was taken
     */
    public Stream<JonixRecord> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * @return a {@link Stream} of records, each containing a new {@link BaseProduct} object and a reference to the
     *     source from which it was taken
     */
    public Stream<BaseRecord> streamUnified() {
        return stream().map(JonixUnifier::unifyRecord);
    }

    /**
     * @return a {@link Stream} of records, each containing a new {@link BaseProduct} object (which was created using
     *     the given factories) and a reference to the source from which it was taken
     */
    public Stream<BaseRecord> streamUnified(BaseFactory2 baseFactory2, BaseFactory3 baseFactory3) {
        BaseUnifier customBaseUnifier = new BaseUnifier(baseFactory2, baseFactory3);
        return stream().map(record -> JonixUnifier.unifyRecord(record, customBaseUnifier));
    }

    /**
     * @return a {@link Stream} of records, each containing a new custom {@code Product} object (which was created using
     *     the given {@link CustomUnifier}) and a reference to the source from which it was taken
     */
    public <P extends UnifiedProduct, H extends UnifiedHeader, R extends UnifiedRecord<P>> Stream<R> streamUnified(
        CustomUnifier<P, H, R> unifier) {
        return stream().map(record -> JonixUnifier.unifyRecord(record, unifier));
    }

    /**
     * This will "peek" into the {@code Header}s of the indicated ONIX sources, without processing the {@code Product}s.
     * The {@code onSourceStart()} events will be fired as a result, allowing to handle the header information.
     */
    public JonixRecords scanHeaders() {
        openOnlyHeadersRequested = true;
        stream().forEach(jonixRecord -> {
            // do nothing, just open the sources one after the other
        });
        openOnlyHeadersRequested = false;
        return this; // TODO reuse for another stream() might be problematic if constructed from inputStream
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

        RecordIterator() {
            nextFiles = new ArrayList<>(files); // possibly an empty list
            try {
                if (inputStream != null) {
                    currentSourceIterator = sourceIterator(new JonixSource(inputStream, JonixRecords.this));
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
                    if (skipSourceRequested) {
                        skipSourceRequested = false;
                    } else {
                        onSourceEndEvents.forEach(e -> e.onSource(currentSource));
                    }
                }

                // if there are no remaining files to open, we can return false, concluding the entire iteration
                if (nextFiles.isEmpty()) {
                    return false;
                }

                if (retrieve("jonix.stream.break", false)) {
                    return false;
                }

                // open the next file, which could possibly contain no records to iterate over
                try {
                    File file = nextFiles.remove(0);
                    currentSourceIterator = sourceIterator(new JonixSource(file, JonixRecords.this));
                    hasNext = currentSourceIterator != null && currentSourceIterator.hasNext();
                } catch (Exception e) {
                    handleInvalidFileException(e);
                }
            }

            return true;
        }

        private void handleInvalidFileException(Exception e) {
            if (failOnInvalidFile) {
                throw new RuntimeException(e);
            } else {
                LOGGER.warn("Error processing " + currentSource.sourceName(), e);
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
                throw new RuntimeException(
                    "source doesn't start with the mandatory <ONIXMessage> tag. Found <" + onixMessage.getName()
                        .getLocalPart() + ">");
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
            currentSource.onixRelease = release == null ? "2.1" : release.getValue();

            // read the first chunk (level-2 element), which should either be a <Product> or <Header>
            Element firstElement = ctx.nextChunk();
            // TODO: allow firstProduct = null, and check that it works on files with no tags under OnixMessage
            boolean hasHeader = firstElement.getNodeName().equalsIgnoreCase("Header");
            if (hasHeader) {
                currentSource.header =
                    JonixFactory.headerFromElement(firstElement, currentSource.onixVersion, currentSource.onixRelease);
            }

            // fire 'onSourceStart' events, allowing the even handler to skip to the next source
            for (OnSourceEvent e : onSourceStartEvents) {
                e.onSource(currentSource);
                if (skipSourceRequested) {
                    return null;
                }
            }

            if (openOnlyHeadersRequested) {
                return null;
            }

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
                    boolean breakStream = retrieve("jonix.stream.break", false);
                    boolean breakCurrentSource = retrieve("jonix.source.break", false);
                    if (breakStream || breakCurrentSource) {
                        try {
                            currentSource.stream.close();
                        } catch (IOException e) {
                            // ignore
                        }
                        if (breakCurrentSource) {
                            store("jonix.source.break", false); // reset the break for the next stream
                        }
                        return false;
                    }
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
                        // TODO: verify the product is indeed <Product> ?
                        globalProductCount.incrementAndGet();
                        currentSource.sourceProductCount.incrementAndGet();
                    } catch (XMLStreamException e) {
                        throw new RuntimeException(e);
                    }
                    return new JonixRecord(globalConfig, currentSource,
                        JonixFactory.productFromElement(product, currentSource.onixVersion, currentSource.onixRelease));
                }
            };
        }
    }
}
