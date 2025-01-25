/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.tectonica.jonix.onix3.Collection;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.TitleDetail;
import com.tectonica.jonix.unify.base.BaseTitle;
import com.tectonica.jonix.unify.base.BaseTitles;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BaseTitles}
 *
 * @author Zach Melamed
 */
public class BaseTitles3 extends BaseTitles {
    private static final long serialVersionUID = 1L;

    private final transient List<TitleDetail> titles;

    private final transient BaseFactory3 factory;

    public BaseTitles3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BaseTitles3(Product product, BaseFactory3 factory) {
        this.factory = factory;
        titles = product.descriptiveDetail().titleDetails();
    }

    public BaseTitles3(Collection collection) {
        this(collection, BaseFactory3.DEFAULT);
    }

    public BaseTitles3(Collection collection, BaseFactory3 factory) {
        this.factory = factory;
        titles = collection.titleDetails();
    }

    @Override
    protected List<BaseTitle> initialize() {
        return Helper.createList(titles, factory.baseTitleFactory);
    }
}
