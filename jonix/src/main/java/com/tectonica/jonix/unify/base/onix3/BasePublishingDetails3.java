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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.PublishingDateRoles;
import com.tectonica.jonix.onix3.CityOfPublication;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.PublishingDetail;
import com.tectonica.jonix.unify.base.BasePublishingDetails;

import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BasePublishingDetails}
 *
 * @author Zach Melamed
 */
public class BasePublishingDetails3 extends BasePublishingDetails {
    private static final long serialVersionUID = 1L;

    public BasePublishingDetails3(Product product) {
        PublishingDetail pd = product.publishingDetail();
        if (pd.exists()) {
            publicationDate =
                pd.publishingDates().findAsStruct(PublishingDateRoles.Publication_date).map(p -> p.date).orElse(null);
            outOfPrintDate =
                pd.publishingDates().findAsStruct(PublishingDateRoles.Out_of_print_deletion_date).map(p -> p.date)
                    .orElse(null);
            countryOfPublication = pd.countryOfPublication().value;
            cityOfPublication = pickCityOfPublication(product, Languages.English);
        } else {
            publicationDate = null;
            countryOfPublication = null;
            cityOfPublication = null;
        }
    }

    private String pickCityOfPublication(Product product, Languages preferredLanguage) {
        List<CityOfPublication> cops = product.publishingDetail().cityOfPublications();

        if (cops.isEmpty()) {
            return null;
        }

        for (CityOfPublication cop : cops) {
            if (cop.language == null || cop.language == preferredLanguage) {
                return cop.value;
            }
        }
        return cops.get(0).value; // return whatever language we have
    }
}
