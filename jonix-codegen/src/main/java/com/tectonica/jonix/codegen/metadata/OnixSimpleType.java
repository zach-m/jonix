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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder( {"name", "primitiveType", "comment", "enum", "enumName", "enumAliasFor", "enumValues"})
public class OnixSimpleType implements Comparable<OnixSimpleType> {
    public static final OnixSimpleType XHTML = OnixSimpleType.create("XHTML", Primitive.String, "Free XHTML content",
        null);

    public String name;
    public Primitive primitiveType;
    public String comment;
    public String enumName;
    public String enumAliasFor;
    public List<OnixEnumValue> enumValues;

    public boolean isEnum() {
        return (enumValues != null);
    }

    public static OnixSimpleType create(String name, Primitive dataType, String comment,
                                        List<OnixEnumValue> enumValues) {
        OnixSimpleType ost = new OnixSimpleType();
        ost.name = name;
        ost.primitiveType = dataType;
        ost.comment = comment;
        ost.enumValues = enumValues;
        return ost;
    }

    public void aliasFrom(OnixSimpleType enumType) {
        if (!enumType.isEnum()) {
            throw new RuntimeException("alias is not allowed for " + enumType);
        }

        primitiveType = enumType.primitiveType;
        comment = enumType.comment;
        enumAliasFor = enumType.name;
        enumName = enumType.enumName;
        enumValues = enumType.enumValues;
    }

    public static OnixSimpleType cloneFrom(OnixSimpleType other) {
        OnixSimpleType ost = new OnixSimpleType();
        ost.name = other.name;
        ost.primitiveType = other.primitiveType;
        ost.comment = other.comment;
        ost.enumAliasFor = other.enumAliasFor;
        ost.enumName = other.enumName;
        ost.enumValues = new ArrayList<OnixEnumValue>(other.enumValues); // new array, same items
        return ost;
    }

    public void add(OnixEnumValue onixEnumValue) {
        if (enumValues == null) {
            enumValues = new ArrayList<>();
        }
        enumValues.add(onixEnumValue);
    }

    @Override
    public String toString() {
        return name + " (" + primitiveType + ") = '" + comment + "', values=" + enumValues + "'";
    }

    @Override
    public int compareTo(OnixSimpleType other) {
        return name.compareTo(other.name);
    }
}