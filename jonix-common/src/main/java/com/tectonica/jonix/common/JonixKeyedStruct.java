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

package com.tectonica.jonix.common;

import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

/**
 * Fundamental interface in {@link com.tectonica.jonix.common Jonix object model}, this interface completes
 * {@link JonixStruct} by representing a <code>Struct</code> that contains a <b>key</b> (i.e. mandatory, unique, and
 * searchable-by field).
 * <p>
 * The key is an enumerated type, and more specifically an {@link OnixCodelist}.
 * <p>
 * To obtain <code>Struct</code> from a keyed Data Composite invoke
 * {@link OnixComposite.OnixDataCompositeWithKey#asStruct()}.
 * <p>
 * To find a <code>Struct</code> by its key, use any of the finder methods in {@link ListOfOnixDataCompositeWithKey}.
 * <p>
 * For example, each ONIX Product may have several Product Identifiers (ISBN-10, ISBN-13, URN, etc.). To find a certain
 * identifier, say ISBN-13, you can look up its struct {@link JonixProductIdentifier} by its key (of type
 * {@link ProductIdentifierTypes}), and once having the struct, use it to get the requested value (the product
 * identifier, <code>idValue</code>):
 * 
 * <pre>
 *     com.tectonica.jonix.onix2.Product product;
 *     ...
 *     ProductIdentifierTypes idType = ProductIdentifierTypes.ISBN_13;
 *     Optional&lt;JonixProductIdentifier&gt; pidStruct = product.productIdentifiers().findAsStruct(idType);
 *     String isbn13 = pidStruct.map(pi -> pi.idValue).orElse(null);
 * </pre>
 */
public interface JonixKeyedStruct<K extends Enum<K> & OnixCodelist> extends JonixStruct {
    K key();
}
