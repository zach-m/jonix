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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;

/**
 * This class provides static services for converting version-specific ONIX data into its version-less equivalent from
 * the <code>com.tectonica.jonix.unify.base</code> package.
 */
public class JonixUnifier {

    private static final BaseUnifier baseUnifier = new BaseUnifier();

    public static BaseRecord unifyRecord(JonixRecord record) {
        return unifyRecord(record, baseUnifier);
    }

    public static <P extends UnifiedProduct, H extends UnifiedHeader, R extends UnifiedRecord<P>> R unifyRecord(
        JonixRecord record, CustomUnifier<P, H, R> customUnifier) {
        return customUnifier.unifiedRecord(record);
    }

    public static BaseProduct unifyProduct(OnixProduct onixProduct) {
        return unifyProduct(onixProduct, baseUnifier);
    }

    public static <P extends UnifiedProduct, H extends UnifiedHeader, R extends UnifiedRecord<P>> P unifyProduct(
        OnixProduct onixProduct, CustomUnifier<P, H, R> customUnifier) {
        return customUnifier.unifiedProduct(onixProduct);
    }

    public static BaseHeader unifyHeader(OnixHeader onixHeader) {
        return unifyHeader(onixHeader, baseUnifier);
    }

    public static <P extends UnifiedProduct, H extends UnifiedHeader, R extends UnifiedRecord<P>> H unifyHeader(
        OnixHeader onixHeader, CustomUnifier<P, H, R> customUnifier) {
        return customUnifier.unifiedHeader(onixHeader);
    }
}
