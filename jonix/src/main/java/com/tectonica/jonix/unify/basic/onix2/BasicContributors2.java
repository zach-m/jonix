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

package com.tectonica.jonix.unify.basic.onix2;

import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.unify.basic.BasicContributor;
import com.tectonica.jonix.unify.basic.BasicContributors;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX2 concrete implementation for {@link BasicContributors}
 *
 * @author Zach Melamed
 */
public class BasicContributors2 extends BasicContributors {
    private static final long serialVersionUID = 1L;

    private final transient List<Contributor> contributors;

    public BasicContributors2(Product product) {
        contributors = product.contributors();
    }

    public BasicContributors2(Series series) {
        contributors = series.contributors();
    }

    @Override
    protected List<BasicContributor> initialize() {
        List<BasicContributor> list = new ArrayList<>();
        for (Contributor contributor : contributors) {
            list.add(new BasicContributor2(contributor));
        }
        sortBySequence(list);
        return list;
    }
}
