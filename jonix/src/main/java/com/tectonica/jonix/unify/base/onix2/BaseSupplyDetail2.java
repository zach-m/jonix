/*
 * Copyright (C) 2012-2020 Zach Melamed
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

import com.tectonica.jonix.common.codelist.AvailabilityStatuss;
import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.unify.base.BaseSupplyDetail;

/**
 * ONIX2 concrete implementation for {@link BaseSupplyDetail}
 *
 * @author Zach Melamed
 */
public class BaseSupplyDetail2 extends BaseSupplyDetail {
    private static final long serialVersionUID = 1L;

    public BaseSupplyDetail2(SupplyDetail supplyDetail) {
        extract(supplyDetail, this);
    }

    public static void extract(SupplyDetail supplyDetail, BaseSupplyDetail dest) {
        final AvailabilityStatuss availabilityCode = supplyDetail.availabilityCode().value;
        // NOTE: AvailabilityStatuss is a required field, we essentially bury here a validation error
        dest.supplierRole = supplyDetail.supplierRole().value;
        dest.supplierName = supplyDetail.supplierName().value;
        dest.availability = (availabilityCode == null) ? null : availabilityCode.name();
        dest.prices = new BasePrices2(supplyDetail); // TODO: this is outside of the factory mechanism
    }
}