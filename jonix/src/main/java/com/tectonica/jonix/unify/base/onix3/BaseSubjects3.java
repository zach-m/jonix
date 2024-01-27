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

import com.tectonica.jonix.common.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.unify.base.BaseSubject;
import com.tectonica.jonix.unify.base.BaseSubjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ONIX3 concrete implementation for {@link BaseSubjects}
 *
 * @author Zach Melamed
 */
public class BaseSubjects3 extends BaseSubjects {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    private final transient BaseFactory3 factory;

    public BaseSubjects3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BaseSubjects3(Product product, BaseFactory3 factory) {
        this.factory = factory;
        this.product = product;
    }

    @Override
    protected Map<SubjectSchemeIdentifiers, List<BaseSubject>> initialize() {
        Map<SubjectSchemeIdentifiers, List<BaseSubject>> map = new HashMap<>();
        for (Subject subject : product.descriptiveDetail().subjects()) {
            addKV(map, new BaseSubject3(subject), subject.isMainSubject());
        }
        return map;
    }
}
