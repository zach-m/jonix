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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.onix2.CityOfPublication;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BasePublishingDetails;

/**
 * ONIX2 concrete implementation for {@link BasePublishingDetails}
 *
 * @author Zach Melamed
 */
public class BasePublishingDetails2 extends BasePublishingDetails {
    private static final long serialVersionUID = 1L;

    public BasePublishingDetails2(Product product) {
        publicationDate = product.publicationDate().value;
        outOfPrintDate = product.outOfPrintDate().value;
        countryOfPublication = product.countryOfPublication().value;
        cityOfPublication = pickCityOfPublication(product, Languages.English);
    }

    public static String pickCityOfPublication(Product product, Languages preferredLanguage) {
        for (CityOfPublication cop : product.cityOfPublications()) {
            if (cop.language == null || cop.language == preferredLanguage) {
                return cop.value;
            }
        }
        return product.cityOfPublications().firstValue().orElse(null); // return whatever language we have
    }
}
