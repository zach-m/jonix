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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BasePublisher;
import com.tectonica.jonix.unify.base.BasePublishers;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BasePublishers}
 *
 * @author Zach Melamed
 */
public class BasePublishers3 extends BasePublishers {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    private final transient BaseFactory3 factory;

    public BasePublishers3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BasePublishers3(Product product, BaseFactory3 factory) {
        this.factory = factory;
        this.product = product;
    }

    @Override
    protected List<BasePublisher> initialize() {
        return Helper.createList(product.publishingDetail().publishers(), factory.basePublisherFactory);
    }
}
