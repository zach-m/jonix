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

package com.tectonica.jonix.codegen.metadata;

public enum Cardinality {
    Optional(true, true), //
    Required(false, true), //
    ZeroOrMore(true, false), //
    OneOrMore(false, false);

    public final boolean omittable;
    public final boolean singular;

    private Cardinality(boolean omittable, boolean singular) {
        this.omittable = omittable;
        this.singular = singular;
    }

    private static Cardinality of(boolean omittable, boolean singular) {
        for (Cardinality cardinality : values()) {
            if (cardinality.omittable == omittable && cardinality.singular == singular) {
                return cardinality;
            }
        }

        return null;
    }

    public static Cardinality of(String minOccurs, String maxOccurs) {
        if (minOccurs == null || minOccurs.isEmpty()) {
            minOccurs = "1";
        }
        if (maxOccurs == null || maxOccurs.isEmpty()) {
            maxOccurs = "1";
        }

        final boolean omittable = "0".equals(minOccurs);
        final boolean singular = "1".equals(maxOccurs);
        final Cardinality cardinality = Cardinality.of(omittable, singular);

        if (cardinality == null) {
            throw new RuntimeException("Internal error where minOccurs=" + minOccurs + ", and maxOccurs=" + maxOccurs);
        }

        return cardinality;
    }

    public Cardinality mergeWith(Cardinality other) {
        if (other == null) {
            return this;
        }

        final boolean omittable = this.omittable || other.omittable;
        final boolean singular = this.singular && other.singular;
        final Cardinality cardinality = Cardinality.of(omittable, singular);

        if (cardinality == null) {
            throw new RuntimeException("Internal error where omittable=" + omittable + ", and singular=" + singular);
        }

        return cardinality;
    }
}