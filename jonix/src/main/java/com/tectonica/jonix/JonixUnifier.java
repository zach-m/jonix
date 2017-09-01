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

import com.tectonica.jonix.extract.JonixUnifiedExtractor;

/**
 * Implementation of this class is required by extractors whose goal is to facilitate reading from both ONIX2 and ONIX3
 * sources, and represent their data in in a single pair of classes (header + product), as opposed to a pair for each
 * ONIX version. When such extractors (sub-classing from {@link JonixUnifiedExtractor}) receive an XML record
 * representing a header or a product, they will call one of the four fundamental methods defined in the interface,
 * depending on the case. The resulting objects, whose classes are H or P (for header and product, respectively) may
 * take as much information as they need from the raw source and retain it internally, but they should not retain ONIX2
 * data apart from ONIX3, as this would defeat the purpose of unification.
 * <p>
 * Once unified, it's easier to handle the data later (for writing output files, sorting, searching, etc.)
 * <p>
 * Jonix provides a whole suite of unified classes representing the most 'basic' pieces of ONIX data. This suite is
 * extensible and customizable. A global unifier for this suite is {@link Jonix#BASIC_UNIFIER}.
 */
public interface JonixUnifier<H, P> {
    H createFrom(com.tectonica.jonix.onix2.Header header);

    H createFrom(com.tectonica.jonix.onix3.Header header);

    P createFrom(com.tectonica.jonix.onix2.Product product);

    P createFrom(com.tectonica.jonix.onix3.Product product);

    /**
     * returns a canonical name for the given product, used mostly for logging. It can be the product's ID, title, etc.
     */
    String labelOf(P product);
}
