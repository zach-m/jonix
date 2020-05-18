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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.onix2.Title;
import com.tectonica.jonix.unify.base.BaseTitle;
import com.tectonica.jonix.unify.base.BaseTitles;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.List;

/**
 * ONIX2 concrete implementation for {@link BaseTitles}
 *
 * @author Zach Melamed
 */
public class BaseTitles2 extends BaseTitles {
    private static final long serialVersionUID = 1L;

    private final transient List<Title> titles;

    private final transient BaseFactory2 factory;

    public BaseTitles2(Product product) {
        this(product, BaseFactory2.DEFAULT);
    }

    public BaseTitles2(Product product, BaseFactory2 factory) {
        this.factory = factory;
        titles = product.titles();
    }

    public BaseTitles2(Series series) {
        this(series, BaseFactory2.DEFAULT);
    }

    public BaseTitles2(Series series, BaseFactory2 factory) {
        this.factory = factory;
        titles = series.titles();
    }

    @Override
    protected List<BaseTitle> initialize() {
        return Helper.createList(titles, factory.baseTitleFactory);
    }
}
