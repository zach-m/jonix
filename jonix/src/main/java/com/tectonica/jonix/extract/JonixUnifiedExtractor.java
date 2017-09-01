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

package com.tectonica.jonix.extract;

import com.tectonica.jonix.Jonix;
import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.stream.JonixFilesExtractor;
import com.tectonica.jonix.stream.JonixOnixVersion;
import com.tectonica.jonix.stream.JonixStreamer;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Abstract base-class for extractors whose goal is to facilitate reading from both ONIX2 and ONIX3 sources, and
 * represent their data in in a single pair of classes (header + product), as opposed to a pair for each ONIX version.
 * Jonix provides its own pair of such unified classes, {@link BasicHeader} and {@link BasicProduct}, which you can use
 * as is or extend where applicable.
 *
 * @param <H> class of the unified header
 * @param <P> class of the unified product
 * @author Zach Melamed
 */
public abstract class JonixUnifiedExtractor<H, P> extends JonixFilesExtractor {
    /**
     * fired when a {@code Header} element is encountered in the ONIX file
     *
     * @return whether or not to continue to the processing of the file
     */
    protected boolean onHeader(H header, JonixStreamer streamer) {
        return true;
    }

    /**
     * fired when a {@code Product} element is encountered in the ONIX file
     *
     * @return whether or not to continue to the processing of the file
     */
    protected abstract boolean onProduct(P product, JonixStreamer streamer);

    // ///////////////////////////////////////////////////////////////////////////////

    protected final JonixUnifier<H, P> unifier;
    protected Object rawOnixHeader;
    protected Object rawOnixProduct;

    /**
     * @param unifier use {@link Jonix#BASIC_UNIFIER} for the Jonix 'basic' suite
     */
    public JonixUnifiedExtractor(final JonixUnifier<H, P> unifier) {
        if (unifier == null) {
            throw new NullPointerException("unifier is required");
        }
        this.unifier = unifier;
    }

    @Override
    protected boolean onHeaderElement(Element domHeader, JonixStreamer streamer) {
        final H unifiedHeader;
        if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2) {
            com.tectonica.jonix.onix2.Header rawHeader2 = new com.tectonica.jonix.onix2.Header(domHeader);
            unifiedHeader = unifier.createFrom(rawHeader2);
            rawOnixHeader = rawHeader2;
        } else { // if (isOnix3)
            com.tectonica.jonix.onix3.Header rawHeader3 = new com.tectonica.jonix.onix3.Header(domHeader);
            unifiedHeader = unifier.createFrom(rawHeader3);
            rawOnixHeader = rawHeader3;
        }
        return onHeader(unifiedHeader, streamer);
    }

    @Override
    protected boolean onProductElement(Element domProduct, JonixStreamer streamer) {
        final P unifiedProduct;
        if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2) {
            com.tectonica.jonix.onix2.Product rawProduct2 = new com.tectonica.jonix.onix2.Product(domProduct);
            unifiedProduct = unifier.createFrom(rawProduct2);
            rawOnixProduct = rawProduct2;
        } else { // if (isOnix3)
            com.tectonica.jonix.onix3.Product rawProduct3 = new com.tectonica.jonix.onix3.Product(domProduct);
            unifiedProduct = unifier.createFrom(rawProduct3);
            rawOnixProduct = rawProduct3;
        }
        return onProduct(unifiedProduct, streamer);
    }

    @Override
    protected boolean onBeforeFileList(List<String> fileNames, JonixStreamer streamer) {
        LOG.info("Found {} files..", fileNames.size());
        return true;
    }

    @Override
    protected void onAfterFileList(List<String> processedFileNames, JonixStreamer streamer) {
        LOG.info("** DONE, {} products extracted in total **\n", streamer.getProductNo());
    }

    @Override
    protected boolean onBeforeFile(String fileName, JonixStreamer streamer) {
        LOG.info("opening {}.. ", fileName);
        return true;
    }
}
