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

package com.tectonica.jonix.codegen.generator;

import com.tectonica.jonix.codegen.metadata.Cardinality;
import com.tectonica.jonix.codegen.metadata.OnixAttribute;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;

import java.io.File;
import java.util.Map;

public class GenUtil {
    public static final String COMMON_PACKAGE = "com.tectonica.jonix";

    public static class TypeInfo {
        String javaType;
        String comment;
        boolean isPrimitive;
        boolean isXHTML;
    }

    private final Map<String, OnixSimpleType> unifiedCodelists;

    public GenUtil(Map<String, OnixSimpleType> unifiedCodelists) {
        this.unifiedCodelists = unifiedCodelists;
    }

    /**
     * makes sure a target folder exists and empty
     */
    public static void prepareOutputFolder(File dir) {
        dir.mkdirs();
        for (File file : dir.listFiles()) {
            file.delete();
        }
    }

    public TypeInfo typeInfoOf(OnixSimpleType simpleType) {
        return typeInfoOf(simpleTypeNameOf(simpleType), simpleType.primitiveType.javaType, simpleType.enumName);
    }

    public TypeInfo typeInfoOf(OnixAttribute attr) {
        return typeInfoOf(simpleTypeNameOf(attr.simpleType), attr.primitiveType.javaType, attr.getEnumName());
    }

    private String simpleTypeNameOf(OnixSimpleType simpleType) {
        if (simpleType == null) {
            return null;
        }
        // de-reference alias
        return (simpleType.enumAliasFor == null) ? simpleType.name : simpleType.enumAliasFor;
    }

    private TypeInfo typeInfoOf(String simpleTypeName, String primitiveJavaType, String enumName) {
        // in case the enumName in the question has been "renamed" (i.e. we chose the enumName of the
        // other side during codelist unification) we adjust to new (unified) enumName
        if (simpleTypeName != null) {
            OnixSimpleType unifiedSimpleType = unifiedCodelists.get(simpleTypeName);
            if (unifiedSimpleType != null) {
                enumName = unifiedSimpleType.enumName;
            }
        }

        TypeInfo result = new TypeInfo();
        result.isXHTML = OnixSimpleType.XHTML.name.equals(simpleTypeName);
        result.javaType = result.isXHTML ? null : enumName;
        result.isPrimitive = (result.javaType == null);
        result.comment = null;
        if (result.javaType == null) { // i.e. neither XHTML nor enum
            result.javaType = primitiveJavaType;
            if ((simpleTypeName != null)) {
                result.comment = "(type: " + simpleTypeName + ")";
            }
        }
        return result;
    }

    public static class FieldInfo {
        String name;
        String type;
        String comment;
        String valueType;
        String emptyPhrase;
        String structName;
    }

    public FieldInfo fieldInfoOf(OnixCompositeMember member, OnixMetadata ref) {
        FieldInfo result = new FieldInfo();
        result.name = fieldNameFor(member.className);
        result.type = member.className;
        result.comment = commentFor(member.cardinality);
        if (member.cardinality.singular) {
            result.emptyPhrase = String.format("%s.EMPTY", result.type);
        } else {
            result.name += "s";
            OnixElementDef element = ref.onixElements.get(member.className);
            if (element != null) {
                // this is a list of elements
                final TypeInfo ti = typeInfoOf(element.valueMember.simpleType);
                result.valueType = ti.javaType;
                if (element.isSpaceable) {
                    result.valueType = "java.util.Set<" + result.valueType + ">";
                }
                result.type = String.format("ListOfOnixElement<%s, %s>", result.type, result.valueType);
                result.emptyPhrase = "ListOfOnixElement.empty()";
            } else {
                // this is a list of data-composites
                final OnixStruct struct = ref.unifiedStructs.get(member.className);
                if (struct != null) {
                    result.structName = "Jonix" + member.className;
                    if (struct.isKeyed()) {
                        OnixCompositeMember keyMember = struct.keyMember.dataMember;
                        OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
                        TypeInfo keyTypeInfo = typeInfoOf(keyClass.valueMember.simpleType);
                        result.type = String.format("ListOfOnixDataCompositeWithKey<%s,%s,%s>", result.type,
                            result.structName, keyTypeInfo.javaType);
                        result.emptyPhrase = "ListOfOnixDataCompositeWithKey.emptyKeyed()";
                    } else {
                        result.type = String.format("ListOfOnixDataComposite<%s,%s>", result.type, result.structName);
                        result.emptyPhrase = "ListOfOnixDataComposite.empty()";
                    }
                } else {
                    result.type = String.format("List<%s>", result.type);
                    result.emptyPhrase = "Collections.emptyList()";
                }
            }
        }
        return result;
    }

    public String fieldNameFor(String propertyName) {
        // find the first lower-case character
        int i = 0;
        for (; i < propertyName.length(); i++) {
            if (Character.isLowerCase(propertyName.charAt(i))) {
                break;
            }
        }

        // "text" --> "text" (nothing to do)
        if (i == 0) {
            return propertyName;
        }

        // "TextFormat" --> "textFormat"
        if (i == 1) {
            return propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);
        }

        // "ISBN" --> "isbn"
        if (i == propertyName.length()) {
            return propertyName.toLowerCase();
        }

        // "IDTypeName" --> "idTypeName"
        return propertyName.substring(0, i - 1).toLowerCase() + propertyName.substring(i - 1);
    }

    private String commentFor(Cardinality cardinality) {
        switch (cardinality) {
            case Required:
                return "this field is required";
            case Optional:
                return "this field is optional";
            case OneOrMore:
                return "this list is required to contain at least one item";
            case ZeroOrMore:
                return "this list may be empty";
            default:
                throw new RuntimeException();
        }
    }
}
