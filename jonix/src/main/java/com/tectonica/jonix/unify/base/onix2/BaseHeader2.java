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

import com.tectonica.jonix.onix2.Header;
import com.tectonica.jonix.unify.base.BaseHeader;

import java.util.Collections;

/**
 * ONIX2 concrete implementation for {@link BaseHeader}
 *
 * @author Zach Melamed
 */
public class BaseHeader2 extends BaseHeader {
    private static final long serialVersionUID = 1L;

    public BaseHeader2(Header header) {
        extract(header, this);
    }

    public static void extract(Header header, BaseHeader dest) {
        dest.rawHeader = header;

        dest.fromCompany = header.fromCompany().value;
        dest.fromPerson = header.fromPerson().value;
        dest.fromEmail = header.fromEmail().value;
        dest.toCompanies = header.toCompany().value().map(Collections::singletonList).orElse(null);
        dest.sentDate = header.sentDate().value;
    }
}
