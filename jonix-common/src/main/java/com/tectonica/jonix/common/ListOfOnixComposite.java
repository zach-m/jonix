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

package com.tectonica.jonix.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOfOnixComposite<C extends OnixComposite> extends ArrayList<C> {
    private static final long serialVersionUID = 1L;
    final Class<C> clazz;

    ListOfOnixComposite(Class<C> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the {@link Class} of the items in this {@link List}
     */
    public Class<C> itemClass() {
        return clazz;
    }

    public Optional<C> first() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0));
    }

    public C firstOrEmpty() {
        return (size() == 0) ? JPU.newInstance(clazz) : get(0);
    }

    public ListOfOnixComposite<C> filter(Predicate<C> predicate) {
        ListOfOnixComposite<C> matches = new ListOfOnixComposite<>(clazz);
        this.stream().filter(predicate).forEach(matches::add);
        return matches;
    }
}