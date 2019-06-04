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

package com.tectonica.jonix.common;

import java.util.Optional;

/**
 * Fundamental interface in {@link com.tectonica.jonix Jonix object model}, representing an ONIX Element (i.e. an
 * element that contains a single value field and possibly some attributes, but nothing else)
 */
public interface OnixElement<V> extends OnixTag {
    V _value();

    /**
     * @return an {@link Optional} wrapping the (single) value included in this object
     */
    default Optional<V> value() {
        return Optional.ofNullable(_value());
    }
}