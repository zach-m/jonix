/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import com.tectonica.jonix.onix3.Imprint;
import com.tectonica.jonix.unify.base.BaseImprint;

/**
 * ONIX3 concrete implementation for {@link BaseImprint}
 *
 * @author Zach Melamed
 */
public class BaseImprint3 extends BaseImprint {
    private static final long serialVersionUID = 1L;

    public BaseImprint3(Imprint imprint) {
        extract(imprint, this);
    }

    public static void extract(Imprint imprint, BaseImprint dest) {
        // TODO: we should at least read one required field (unlike ImprintName)
        dest.imprintName = imprint.imprintName().value;
    }
}