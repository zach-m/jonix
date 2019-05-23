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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ONIX primitive type. This type belongs to either one of the following distinct groups:
 * <ul>
 * <li>Data types - e.g. String, PositiveInteger, NonEmptyString, TimeOrDuration, etc.</li>
 * <li>Enumerated types - these are Onix <a href="https://www.editeur.org/14/Code-Lists/">Codelists</a></li>
 * </ul>
 * Given instance of this class, use {@link #isEnum()} to tell which group it belongs to.
 */
@JsonPropertyOrder(
    {"name", "primitiveType", "description", "comment", "isList", "enum", "enumName", "enumCodelistIssue",
        "enumAliasFor", "enumValues"})
public class OnixSimpleType implements Comparable<OnixSimpleType> {
    public static final OnixSimpleType XHTML =
        new OnixSimpleType("XHTML", Primitive.String, "Free XHTML content", null);

    /**
     * the official ONIX name of the type, as named in the XSD tag {@code <xs:simpleType name="??">}
     */
    public final String name;

    /**
     * the data-type that will be used to represent the simpleType in the generated class
     */
    public Primitive primitiveType;

    /**
     * description of the simpleType (aka annotation)
     */
    public String description;

    /**
     * additional comment for Javadocs
     */
    public String comment;

    /**
     * determines whether the type allows a list of values (rather than a single value)
     */
    public boolean isList;

    /**
     * (enum-type only): the Java Enum name to be used in the generated code; otherwise - null
     */
    public String enumName;

    /**
     * (enum-type only): the codelist version from which this enum was parsed
     */
    public String enumCodelistIssue;

    /**
     * (enum-type only): In some rare cases, the enum is just an alias for another enum, e.g. "CountryCodeList" ->
     * "List91"
     */
    public String enumAliasFor;

    /**
     * (enum-type only): the list of allowed values for this enum (for each, we have title, code, and explanation)
     */
    public List<OnixEnumValue> enumValues;

    public boolean isEnum() {
        return (enumValues != null);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return (primitiveType == null) && (description == null) && (comment == null) && (enumName == null) &&
            (enumCodelistIssue == null) && (enumAliasFor == null) && !isList;
    }

    public OnixSimpleType(String name) {
        this.name = name;
    }

    private OnixSimpleType(String name, Primitive dataType, String description, List<OnixEnumValue> enumValues) {
        this.name = name;
        this.primitiveType = dataType;
        this.description = description;
        this.enumValues = enumValues;
    }

    public void setAsAliasFor(OnixSimpleType enumType) {
        if (!enumType.isEnum()) {
            throw new RuntimeException("aliasing is not allowed for non-enum " + enumType);
        }

        if (!isEmpty()) {
            throw new RuntimeException("aliasing is not allowed on initialized type: " + this);
        }

        primitiveType = enumType.primitiveType;
        description = enumType.description;
        comment = enumType.comment;
        isList = enumType.isList;
        enumName = enumType.enumName;
        enumCodelistIssue = enumType.enumCodelistIssue;
        enumAliasFor = enumType.name;
        enumValues = enumType.enumValues;
    }

    public static OnixSimpleType cloneFrom(OnixSimpleType other) {
        OnixSimpleType ost = new OnixSimpleType(other.name);
        ost.primitiveType = other.primitiveType;
        ost.description = other.description;
        ost.comment = other.comment;
        ost.isList = other.isList;
        ost.enumName = other.enumName;
        ost.enumCodelistIssue = other.enumCodelistIssue;
        ost.enumAliasFor = other.enumAliasFor;
        ost.enumValues = new ArrayList<>(other.enumValues); // new array, same items
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
        return String.format("%s (%s) = '%s', values=%s'", name, primitiveType, description, enumValues);
    }

    /**
     * comparator for unification processes; relevant when comparing types from different versions of ONIX. in such
     * cases all that matters is the raw name.
     */
    @Override
    public int compareTo(OnixSimpleType other) {
        return name.compareTo(other.name);
    }
}