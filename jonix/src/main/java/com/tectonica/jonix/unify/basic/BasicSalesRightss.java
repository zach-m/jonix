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

package com.tectonica.jonix.unify.basic;

import com.tectonica.jonix.codelist.SalesRightsTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;SalesRights&gt; that may exist in an ONIX product
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicSalesRightss extends LazyList<BasicSalesRights> {
    public List<BasicSalesRights> findSalesRights(Set<SalesRightsTypes> requestedTypes) {
        List<BasicSalesRights> matches = new ArrayList<>();
        for (BasicSalesRights salesRights : this) {
            if (requestedTypes.contains(salesRights.salesRightsType)) {
                matches.add(salesRights);
            }
        }
        return matches;
    }
}
