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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.onix2.AudienceRange;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BaseDescription;

/**
 * ONIX2 concrete implementation for {@link BaseDescription}
 *
 * @author Zach Melamed
 */
public class BaseDescription2 extends BaseDescription {
    private static final long serialVersionUID = 1L;

    public BaseDescription2(Product product) {
        extract(product, this);
    }

    public static void extract(Product product, BaseDescription dest) {
        dest.editionType = product.editionTypeCodes().firstValue().orElse(null);
        dest.editionNumber = JPU.convertStringToInteger(product.editionNumber().value);
        dest.productForm = product.productForm().value().map(fv -> fv.description).orElse(null);
        dest.numberOfPages = product.numberOfPages().value;
        dest.languages = product.languages().asStructs(); // TODO: lazify
        dest.audiences = product.audiences().asStructs(); // TODO: lazify
        dest.audienceRange = product.audienceRanges().first().map(AudienceRange::asStruct).orElse(null);
    }
}
