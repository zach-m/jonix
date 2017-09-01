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

import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.stream.JonixStreamer;

import java.util.Collection;

public class JonixInMemExtractor<H, P> extends JonixUnifiedExtractor<H, P> {
    protected Collection<P> products;

    /**
     * initializes an exporter which will read records into a collection
     */
    public JonixInMemExtractor(JonixUnifier<H, P> unifier, Collection<P> collection) {
        super(unifier);
        if (collection == null) {
            throw new NullPointerException();
        }
        this.products = collection;
    }

    @Override
    protected boolean onProduct(P product, JonixStreamer streamer) {
        products.add(product);
        return true;
    }
}
