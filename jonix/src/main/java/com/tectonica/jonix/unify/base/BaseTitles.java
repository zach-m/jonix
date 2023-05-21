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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.unify.base.util.LazyList;

import java.util.List;

/**
 * A {@link List} containing the multiple instances of ONIX2 &lt;Title&gt; / ONIX3 &lt;TitleDetail&gt; that may exist
 * in a product or a collection (series)
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseTitles extends LazyList<BaseTitle> {
    public String findTitleText(TitleTypes requestedType) {
        BaseTitle title = findTitle(requestedType);
        return (title == null) ? null : title.titleText;
    }

    public BaseTitle findTitle(TitleTypes requestedType) {
        for (BaseTitle title : this) {
            if (title.titleType == requestedType) {
                return title;
            }
        }
        return null;
    }
}
