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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Title;
import com.tectonica.jonix.unify.base.BaseTitle;

/**
 * ONIX2 concrete implementation for {@link BaseTitle}
 *
 * @author Zach Melamed
 */
public class BaseTitle2 extends BaseTitle {
    private static final long serialVersionUID = 1L;

    public BaseTitle2(Title title) {
        extract(title, this);
    }

    public static void extract(Title title, BaseTitle dest) {
        dest.titleType = title.titleType().value;
        dest.titleText = noBreaks(title.titleText().value);
        dest.titleWithoutPrefix = noBreaks(title.titleWithoutPrefix().value);
        dest.subtitle = noBreaks(title.subtitle().value);
    }
}