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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.common.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.onix3.Collection;
import com.tectonica.jonix.unify.base.BaseCollection;
import com.tectonica.jonix.unify.base.util.LazyList;

import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BaseCollection}
 *
 * @author Zach Melamed
 */
public class BaseCollection3 extends BaseCollection {
    private static final long serialVersionUID = 1L;

    public BaseCollection3(Collection c) {
        extract(c, this);
    }

    public static void extract(Collection c, BaseCollection dest) {
        dest.titles = new BaseTitles3(c);
        dest.mainTitle = (dest.titles.size() > 0) ? dest.titles.get(0).titleText : null;

        // TODO: also look at Collection -> TitleDetail -> TitleElement -> PartNumber
        dest.numberWithinSeries = (c.collectionSequences().isEmpty()) ? null
            : c.collectionSequences().get(0).collectionSequenceNumber().value;

        dest.seriesIdentifiers = new LazyList<JonixCollectionIdentifier>() {
            @Override
            protected List<JonixCollectionIdentifier> initialize() {
                return c.collectionIdentifiers().asStructs();
            }
        };
        dest.contributors = new BaseContributors3(c);
    }
}