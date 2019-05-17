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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.JonixSource;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;

import java.util.Optional;

public class BaseRecord {
    public final JonixSource source;
    public final BaseProduct product;

    public BaseRecord(JonixSource source, BaseProduct product) {
        this.source = source;
        this.product = product;
    }

    public Optional<BaseHeader> header() {
        return source.header().map(JonixUnifier::unifyHeader);
    }

    @Override
    public String toString() {
        return String.format("{source=%s, product=%s}", source, product);
    }
}
