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

package com.tectonica.jonix.util;

import com.tectonica.jonix.JonixRecords;
import com.tectonica.jonix.OnixProduct;
import com.tectonica.jonix.tabulate.FieldTabulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class SimpleUniqueCollector {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleUniqueCollector.class);

    public final FieldTabulator<OnixProduct> idTabulator;

    public SimpleUniqueCollector(FieldTabulator<OnixProduct> idTabulator) {
        this.idTabulator = Objects.requireNonNull(idTabulator);
    }

    /**
     * a wrapper for Product with some extra information needed for sorting and filtering
     */
    public static class ProductInfo {
        public final List<String> id;
        public final Calendar timestamp;
        public final OnixProduct product;

        private ProductInfo(List<String> id, Calendar timestamp, OnixProduct product) {
            this.id = id;
            this.timestamp = timestamp;
            this.product = product;
        }
    }

    private Calendar lastFileTimestamp;
    private List<ProductInfo> uniqueProducts;
    private boolean changed;

    public void read(JonixRecords records) {

        records.onSourceStart(source -> {
            lastFileTimestamp = JonixUtil.extractTimstampFromFileName(source.file.getAbsolutePath());

            // if we couldn't extract the timestamp from the file's name, we fall back to its modification date
            if (lastFileTimestamp == null) {
                lastFileTimestamp = new GregorianCalendar();
                lastFileTimestamp.setTimeInMillis(source.file.lastModified());
            }
        });

        uniqueProducts = new ArrayList<>();
        changed = false;

        records.stream().forEach(record -> {
            List<String> idData = idTabulator.extractFrom(record.product);
            if (idData != null) {
                uniqueProducts.add(new ProductInfo(idData, lastFileTimestamp, record.product));
                changed = true;
            }
        });
    }
    // ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Returns a filtered list of products, that includes - for each product-ID - only the one with the latest
     * time-stamp (as extracted from its file name or modification-time)
     */
    public List<ProductInfo> getUniqueProducts() {
        /*
         * sorts by descending order of timestamp. This will leave only the latest timestamp (per each product-id)
         * when the products are filtered
         */
        return getUniqueProducts((p1, p2) -> -p1.timestamp.compareTo(p2.timestamp));
    }

    /**
     * Returns a filtered list of products, where each product-ID appears once
     *
     * @param comparator a custom {@link Comparator} for ordering products with identical IDs. Among all such products,
     *                   the one that compares to be the 'smallest' will be picked when the list is filtered
     */
    public List<ProductInfo> getUniqueProducts(final Comparator<ProductInfo> comparator) {
        if (changed) {
            LOGGER.info("Sorting {} products..", uniqueProducts.size());
            uniqueProducts.sort((p1, p2) -> {
                int result = JonixUtil.compareList(p1.id, p2.id);
                if (result == 0) { // with the same id, we leave it for the caller to decide
                    return comparator.compare(p1, p2);
                }
                return result;
            });

            LOGGER.info("Compacting..");
            List<String> lastId = null;
            ListIterator<ProductInfo> iter = uniqueProducts.listIterator();
            while (iter.hasNext()) {
                ProductInfo pi = iter.next();
                if (pi.id.equals(lastId)) {
                    iter.remove();
                } else {
                    lastId = pi.id;
                }
            }
            changed = false;
        }
        return uniqueProducts;
    }
}
