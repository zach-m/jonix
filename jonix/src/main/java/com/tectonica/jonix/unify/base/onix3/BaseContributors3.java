/*
 * Copyright (C) 2012-2024 Zach Melamed
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

import com.tectonica.jonix.onix3.Contributor;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BaseContributor;
import com.tectonica.jonix.unify.base.BaseContributors;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BaseContributors}
 *
 * @author Zach Melamed
 */
public class BaseContributors3 extends BaseContributors {
    private static final long serialVersionUID = 1L;

    private final transient List<Contributor> contributors;

    private final transient BaseFactory3 factory;

    public BaseContributors3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BaseContributors3(Product product, BaseFactory3 factory) {
        this.factory = factory;
        contributors = product.descriptiveDetail().contributors();
    }

    public BaseContributors3(com.tectonica.jonix.onix3.Collection collection) {
        this(collection, BaseFactory3.DEFAULT);
    }

    public BaseContributors3(com.tectonica.jonix.onix3.Collection collection, BaseFactory3 factory) {
        this.factory = factory;
        contributors = collection.contributors();
    }

    @Override
    protected List<BaseContributor> initialize() {
        List<BaseContributor> list = Helper.createList(contributors, factory.baseContributorFactory);
        sortBySequence(list);
        return list;
    }
}
