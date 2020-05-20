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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.common.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Subject;
import com.tectonica.jonix.unify.base.BaseSubject;
import com.tectonica.jonix.unify.base.BaseSubjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ONIX2 concrete implementation for {@link BaseSubjects}
 *
 * @author Zach Melamed
 */
public class BaseSubjects2 extends BaseSubjects {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    private final transient BaseFactory2 factory;

    public BaseSubjects2(Product product) {
        this(product, BaseFactory2.DEFAULT);
    }

    public BaseSubjects2(Product product, BaseFactory2 factory) {
        this.factory = factory;
        this.product = product;
    }

    @Override
    protected Map<SubjectSchemeIdentifiers, List<BaseSubject>> initialize() {
        Map<SubjectSchemeIdentifiers, List<BaseSubject>> map = new HashMap<>();
        String bisacMainSubject = product.basicMainSubject().value;
        if (bisacMainSubject != null) {
            addKV(map, new BaseSubject2(SubjectSchemeIdentifiers.BISAC_Subject_Heading, bisacMainSubject, null),
                false);
        }

        String bicMainSubject = product.bicMainSubject().value;
        if (bicMainSubject != null) {
            addKV(map, new BaseSubject2(SubjectSchemeIdentifiers.BIC_subject_category, bicMainSubject, null), false);
        }

        for (Subject subject : product.subjects()) {
            addKV(map, new BaseSubject2(subject), false);
        }
        return map;
    }
}
