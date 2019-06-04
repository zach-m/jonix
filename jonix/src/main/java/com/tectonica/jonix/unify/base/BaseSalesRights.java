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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.Regions;
import com.tectonica.jonix.common.codelist.RightsRegions;
import com.tectonica.jonix.common.codelist.SalesRightsTypes;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Contains the essential information included in ONIX &lt;SalesRights&gt;
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseSalesRights implements Serializable {
    public SalesRightsTypes salesRightsType;
    public List<Set<Countrys>> countries; // TODO: need to be contracted to merely a Set
    public Set<Regions> regions;
    public List<RightsRegions> rightRegions; // only in Onix2
    public Set<Countrys> countriesExcluded; // only in Onix3
    public Set<Regions> regionsExcluded; // only in Onix3
}