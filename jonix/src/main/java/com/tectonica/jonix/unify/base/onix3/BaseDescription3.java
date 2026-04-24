/*
 * Copyright (C) 2012-2026 Zach Melamed
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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.common.codelist.ExtentUnits;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.ProductForms;
import com.tectonica.jonix.onix3.AudienceRange;
import com.tectonica.jonix.onix3.DescriptiveDetail;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BaseDescription;

import java.util.Comparator;
import java.util.Optional;

/**
 * ONIX3 concrete implementation for {@link BaseDescription}
 *
 * @author Zach Melamed
 */
public class BaseDescription3 extends BaseDescription {
    private static final long serialVersionUID = 1L;

    public BaseDescription3(Product product) {
        extract(product, this);
    }

    public static void extract(Product product, BaseDescription dest) {
        DescriptiveDetail dd = product.descriptiveDetail();
        if (dd.exists()) {
            dest.editionType = dd.editionTypes().firstValue().orElse(null);
            dest.editionNumber = dd.editionNumber().value;
            ProductForms productFormValue = dd.productForm().value;
            dest.productForm = (productFormValue == null) ? null : productFormValue.description;
            dest.numberOfPages = pageCount(dd).map(Object::toString).orElse(null);
            dest.languages = dd.languages().asStructs();
            dest.audiences = dd.audiences().asStructs();
            dest.audienceDescription = dd.audienceDescriptions().stream() //
                .filter(ad -> ad.language == null || ad.language == Languages.English) //
                .map(ad -> ad.value) //
                .findFirst().orElse(null);
            dest.audienceRange = dd.audienceRanges().first().map(AudienceRange::asStruct).orElse(null);
        }
    }

    public static Optional<Integer> pageCount(DescriptiveDetail dd) {
        return dd.extents().stream()
            // pick only Extents with ExtentUnit of "Pages"
            .filter(e -> e.extentUnit().value().map(u -> u == ExtentUnits.Pages).orElse(false))
            // of those, take the one with the lowest (more primary) ExtentType value (e.g. prefer "00" over "06")
            .min(Comparator.comparingInt(e -> e.extentType().value().map(Enum::ordinal).orElse(Integer.MAX_VALUE)))
            // return the ExtentValue, which is defined as Double for the general case
            .flatMap(e -> e.extentValue().value())
            // As we've taken a unit of type "Pages", we expect it to be an integer
            .map(Double::intValue);
    }
}
