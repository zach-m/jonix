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

import com.tectonica.jonix.common.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.common.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.unify.base.BaseCollection;
import com.tectonica.jonix.unify.base.util.LazyList;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX2 concrete implementation for {@link BaseCollection}
 *
 * @author Zach Melamed
 */
public class BaseCollection2 extends BaseCollection {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("serial")
    public BaseCollection2(Series c) {
        extract(c, this);
    }

    public static void extract(Series c, BaseCollection dest) {
        dest.mainTitle = c.titleOfSeries().value;
        dest.numberWithinSeries = c.numberWithinSeries().value;
        dest.seriesIdentifiers = new LazyList<>() {
            @Override
            protected List<JonixCollectionIdentifier> initialize() {
                return sidsToCids(c.seriesIdentifiers().asStructs());
            }
        };
        dest.titles = new BaseTitles2(c);
        dest.contributors = new BaseContributors2(c);
    }

    private static List<JonixCollectionIdentifier> sidsToCids(List<JonixSeriesIdentifier> sids) {
        if (sids == null) {
            return null;
        }

        List<JonixCollectionIdentifier> result = new ArrayList<>();
        for (JonixSeriesIdentifier sid : sids) {
            JonixCollectionIdentifier cid = new JonixCollectionIdentifier();
            cid.collectionIDType = sid.seriesIDType;
            cid.idTypeName = sid.idTypeName;
            cid.idValue = sid.idValue;
            result.add(cid);
        }
        return result;
    }
}