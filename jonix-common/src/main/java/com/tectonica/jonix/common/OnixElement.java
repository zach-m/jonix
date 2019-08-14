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
 * Fundamental interface in {@link com.tectonica.jonix.common Jonix object model}, representing an ONIX Element (i.e. an
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

    /**
     * helper-method for fluent code, checking if the value is {@code null}, which could happen either if the element
     * itself is missing (in which case {@code exists()} would be {@code false}), or if it's listed but has an empty or
     * invalid value
     */
    default boolean isNull() {
        return _value() == null;
    }

    /**
     * helper-method for fluent code, comparing the ONIX element's value with the given value, using <b>identity</b>
     * (i.e. {@code ==}) operator. This is particularly useful when the value is an {@link OnixCodelist}.
     * <p>
     * The caller doesn't have to worry about the ONIX element's value being {@code null} (which could happen either if
     * the element itself is missing (in which case {@code exists()} would be {@code false}), or if it's listed but has
     * an empty or invalid value)
     *
     * @return {@code true} if the element's value {@code ==} the passed value, {@code false} otherwise
     */
    default boolean is(V value) {
        return _value() == value;
    }

    /**
     * helper-method for fluent code, comparing the ONIX element's value with the given value, using {@code equals()}
     * operation. The caller doesn't have to worry about the ONIX element's value being {@code null} (which could happen
     * either if the element itself is missing (in which case {@code exists()} would be {@code false}), or if it's
     * listed but has an empty or invalid value)
     *
     * @return {@code true} if the element's value {@code equals()} to the passed value, {@code false} otherwise
     */
    default boolean equal(V value) {
        return _value() != null && _value().equals(value);
    }
}