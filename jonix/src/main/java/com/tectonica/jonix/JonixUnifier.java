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

import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;

public class JonixUnifier {
    public static BaseProduct unifyProduct(OnixProduct onixProduct) {
        if (onixProduct instanceof com.tectonica.jonix.onix2.Product) {
            return new BaseProduct2((com.tectonica.jonix.onix2.Product) onixProduct);
        }
        if (onixProduct instanceof com.tectonica.jonix.onix3.Product) {
            return new BaseProduct3((com.tectonica.jonix.onix3.Product) onixProduct);
        }
        throw new UnsupportedOperationException();
    }

    public static BaseHeader unifyHeader(OnixHeader onixHeader) {
        if (onixHeader instanceof com.tectonica.jonix.onix2.Header) {
            return new BaseHeader2((com.tectonica.jonix.onix2.Header) onixHeader);
        }
        if (onixHeader instanceof com.tectonica.jonix.onix3.Header) {
            return new BaseHeader3((com.tectonica.jonix.onix3.Header) onixHeader);
        }
        throw new UnsupportedOperationException();
    }
}
