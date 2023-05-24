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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.Jonix;
import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.OnixProduct;

public interface CustomUnifier<P extends UnifiedProduct, H extends UnifiedHeader, R extends UnifiedRecord<P>> {
    default P unifiedProduct(OnixProduct onixProduct) {
        switch (onixProduct.onixVersion()) {
            case ONIX2:
                P product2 = extractProduct2(Jonix.toProduct2(onixProduct));
                product2.rawProduct = onixProduct;
                return product2;
            case ONIX3:
                P product3 = extractProduct3(Jonix.toProduct3(onixProduct));
                product3.rawProduct = onixProduct;
                return product3;
            default:
                throw new UnsupportedOperationException(
                    "Wrong Product class passed: " + onixProduct.getClass().getName());
        }
    }

    default H unifiedHeader(OnixHeader onixHeader) {
        switch (onixHeader.onixVersion()) {
            case ONIX2:
                return extractHeader2(Jonix.toHeader2(onixHeader));
            case ONIX3:
                return extractHeader3(Jonix.toHeader3(onixHeader));
            default:
                throw new UnsupportedOperationException(
                    "Wrong Product class passed: " + onixHeader.getClass().getName());
        }
    }

    R unifiedRecord(JonixRecord record);

    P extractProduct2(com.tectonica.jonix.onix2.Product onixProduct2);

    P extractProduct3(com.tectonica.jonix.onix3.Product onixProduct3);

    H extractHeader2(com.tectonica.jonix.onix2.Header onixHeader);

    H extractHeader3(com.tectonica.jonix.onix3.Header onixHeader);
}
