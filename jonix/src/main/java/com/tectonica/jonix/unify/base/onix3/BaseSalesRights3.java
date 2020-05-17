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

import com.tectonica.jonix.onix3.SalesRights;
import com.tectonica.jonix.onix3.Territory;
import com.tectonica.jonix.unify.base.BaseSalesRights;

import java.util.Arrays;

/**
 * ONIX3 concrete implementation for {@link BaseSalesRights}
 *
 * @author Zach Melamed
 */
public class BaseSalesRights3 extends BaseSalesRights {
    private static final long serialVersionUID = 1L;

    public BaseSalesRights3(SalesRights salesRights) {
        extract(salesRights, this);
    }

    public static void extract(SalesRights salesRights, BaseSalesRights dest) {
        Territory territory = salesRights.territory();
        dest.salesRightsType = salesRights.salesRightsType().value;
        dest.countries = Arrays.asList(territory.countriesIncluded().value);
        dest.regions = territory.regionsIncluded().value;
        dest.rightRegions = null;
        dest.countriesExcluded = territory.countriesExcluded().value;
        dest.regionsExcluded = territory.regionsExcluded().value;
    }
}