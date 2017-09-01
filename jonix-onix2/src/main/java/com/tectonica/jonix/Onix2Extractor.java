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

import com.tectonica.jonix.onix2.Header;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.stream.JonixFilesExtractor;
import com.tectonica.jonix.stream.JonixStreamer;
import org.w3c.dom.Element;

/**
 * Simple abstract extractor for ONIX2-only sources. Can be used like that
 * <p>
 * <pre>
 * JonixFilesStreamer streamer = new JonixFilesStreamer(new Onix2Extractor()
 * {
 *  &#064;Override
 *  protected void onProduct(Product product, JonixStreamer streamer)
 *    {
 *      // do something with the product..
 *    }
 * });
 *
 * InputStream is = // your ONIX source
 * streamer.read(is);
 * </pre>
 * <p>
 * Subclasses need to override {@link #onProduct(Product, JonixStreamer)} and optionally {@link #onHeader(Header,
 * JonixStreamer)}.
 */
public abstract class Onix2Extractor extends JonixFilesExtractor {
    /**
     * fired when a {@code Header} element is encountered in the ONIX file
     *
     * @return whether or not to continue to the processing of the file
     */
    protected boolean onHeader(Header header, JonixStreamer streamer) {
        return true;
    }

    /**
     * fired when a {@code Product} element is encountered in the ONIX file
     *
     * @return whether or not to continue to the processing of the file
     */
    protected abstract boolean onProduct(Product product, JonixStreamer streamer);

    // ///////////////////////////////////////////////////////////////////////////////

    @Override
    protected boolean onHeaderElement(Element domHeader, JonixStreamer streamer) {
        return onHeader(new Header(domHeader), streamer);
    }

    @Override
    protected boolean onProductElement(Element domProduct, JonixStreamer streamer) {
        return onProduct(new Product(domProduct), streamer);
    }
}
