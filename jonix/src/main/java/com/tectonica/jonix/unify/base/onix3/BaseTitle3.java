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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.TitleDetail;
import com.tectonica.jonix.onix3.TitleElement;
import com.tectonica.jonix.unify.base.BaseTitle;

/**
 * ONIX3 concrete implementation for {@link BaseTitle}
 *
 * @author Zach Melamed
 */
public class BaseTitle3 extends BaseTitle {
    private static final long serialVersionUID = 1L;

    public BaseTitle3(TitleDetail title) {
        extract(title, this);
    }

    public static void extract(TitleDetail title, BaseTitle dest) {
        // TODO: check out the TitleElementLevel of the TitleElement, especially in collections
        TitleElement titleElement = title.titleElements().get(0); // at least 1 is mandatory
        dest.titleType = title.titleType().value;

        // <TitleWithoutPrefix> is mandatory in ONIX-3
        if (titleElement.titleWithoutPrefix().exists()) {
            dest.prefix = titleElement.titlePrefix().value; // might be null if <NoPrefix/>
            dest.titleWithoutPrefix = noBreaks(titleElement.titleWithoutPrefix().value);
        } else {
            dest.prefix = null;
            dest.titleWithoutPrefix = null;
        }

        // <TitleText> is deprecated in ONIX-3, here for backward compatibility
        dest.titleText = noBreaks(titleElement.titleText().value);

        dest.subtitle = noBreaks(titleElement.subtitle().value);
    }
}