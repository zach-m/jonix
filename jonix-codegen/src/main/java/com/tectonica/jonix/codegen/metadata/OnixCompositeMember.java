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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder( {"className", "cardinality"})
public class OnixCompositeMember implements Comparable<OnixCompositeMember> {
    public String className;
    public Cardinality cardinality;

    @JsonIgnore
    public OnixClassDef onixClass; // added after parsing is over

    @Override
    public int compareTo(OnixCompositeMember other) {
        return className.compareTo(other.className);
    }

    @Override
    public String toString() {
        return className + " [" + cardinality + "]";
    }

    public static OnixCompositeMember create(String className, Cardinality cardinality) {
        OnixCompositeMember member = new OnixCompositeMember();
        member.className = className;
        member.cardinality = cardinality;
        return member;
    }
}