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

import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseFactory2;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix3.BaseFactory3;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;

public class BaseUnifier implements CustomUnifier<BaseProduct, BaseHeader, BaseRecord> {
    private final BaseFactory2 baseFactory2;
    private final BaseFactory3 baseFactory3;

    public BaseUnifier() {
        this.baseFactory2 = BaseFactory2.DEFAULT;
        this.baseFactory3 = BaseFactory3.DEFAULT;
    }

    public BaseUnifier(BaseFactory2 baseFactory2, BaseFactory3 baseFactory3) {
        this.baseFactory2 = baseFactory2;
        this.baseFactory3 = baseFactory3;
    }

    @Override
    public BaseRecord unifiedRecord(JonixRecord record) {
        return new BaseRecord(record.source, unifiedProduct(record.product));
    }

    @Override
    public BaseProduct extractProduct2(Product onixProduct2) {
        return new BaseProduct2(onixProduct2, baseFactory2);
    }

    @Override
    public BaseProduct extractProduct3(com.tectonica.jonix.onix3.Product onixProduct3) {
        return new BaseProduct3(onixProduct3, baseFactory3);
    }

    public BaseHeader extractHeader2(com.tectonica.jonix.onix2.Header onixHeader) {
        return new BaseHeader2(onixHeader);
    }

    public BaseHeader extractHeader3(com.tectonica.jonix.onix3.Header onixHeader) {
        return new BaseHeader3(onixHeader);
    }
}
