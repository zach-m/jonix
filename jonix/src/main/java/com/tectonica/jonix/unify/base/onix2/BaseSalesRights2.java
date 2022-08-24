/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import com.tectonica.jonix.onix2.SalesRights;
import com.tectonica.jonix.unify.base.BaseSalesRights;

/**
 * ONIX2 concrete implementation for {@link BaseSalesRights}
 *
 * @author Zach Melamed
 */
public class BaseSalesRights2 extends BaseSalesRights {
    private static final long serialVersionUID = 1L;

    public BaseSalesRights2(SalesRights salesRights) {
        extract(salesRights, this);
    }

    public static void extract(SalesRights salesRights, BaseSalesRights dest) {
        dest.salesRightsType = salesRights.salesRightsType().value;
        dest.countries = salesRights.rightsCountrys().values();
        dest.regions = salesRights.rightsTerritory().value;
        dest.rightRegions = salesRights.rightsRegions().values();
        dest.countriesExcluded = null;
        dest.regionsExcluded = null;
    }
}