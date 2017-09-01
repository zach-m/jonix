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

@JsonPropertyOrder( {"containingComposite", "keyed", "keyMember", "members"})
public class OnixStruct implements Comparable<OnixStruct> {
    public final OnixCompositeDef containingComposite;

    /**
     * key member refers to a mandatory enum field of the struct
     */
    public OnixStructMember keyMember = null;

    public List<OnixStructMember> members = new ArrayList<>();

    public OnixStruct(OnixCompositeDef containingComposite) {
        this.containingComposite = containingComposite;
    }

    public boolean isKeyed() {
        return (keyMember != null);
    }

    public OnixSimpleType keyEnumType() {
        return (keyMember == null) ? null : ((OnixElementDef) keyMember.dataMember.onixClass).valueMember.simpleType;
    }

    public List<OnixStructMember> allMembers() {
        if (keyMember == null) {
            return members;
        }
        List<OnixStructMember> list = new ArrayList<>(members.size() + 1);
        list.add(keyMember);
        list.addAll(members);
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("struct " + containingComposite.name).append("\n");
        if (keyMember != null) {
            OnixElementMember km = ((OnixElementDef) keyMember.dataMember.onixClass).valueMember;
            sb.append("   [key] - ").append(km.simpleType.enumName).append("\n");
        }
        for (OnixStructMember member : members) {
            OnixElementMember vm = ((OnixElementDef) member.dataMember.onixClass).valueMember;
            final OnixSimpleType simpleType = vm.simpleType;
            String javaType = (simpleType.enumName != null) ? simpleType.enumName : simpleType.primitiveType.javaType;
            if (!member.dataMember.cardinality.singular) {
                javaType = "List<" + javaType + ">";
            }
            sb.append("         - ").append(javaType).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(OnixStruct other) {
        return containingComposite.name.compareTo(other.containingComposite.name);
    }
}