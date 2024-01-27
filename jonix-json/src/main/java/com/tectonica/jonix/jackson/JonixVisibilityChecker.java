/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.tectonica.jonix.common.OnixTag;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class JonixVisibilityChecker implements VisibilityChecker<JonixVisibilityChecker> {

    @Override
    public boolean isFieldVisible(Field f) {
        boolean isPublic = Modifier.isPublic(f.getModifiers());
        if (isPublic) {
            return true;
        }
        boolean isPrivate = Modifier.isPrivate(f.getModifiers());
        if (isPrivate) {
            // private fields that are Onix tags (or list of those) - are the basis for our JSON serialization
            return OnixTag.class.isAssignableFrom(f.getType()) || List.class.isAssignableFrom(f.getType());
        }
        return false;
    }

    @Override
    public boolean isFieldVisible(AnnotatedField f) {
        return isFieldVisible(f.getAnnotated());
    }

    @Override
    public JonixVisibilityChecker with(JsonAutoDetect ann) {
        return null;
    }

    @Override
    public JonixVisibilityChecker with(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withOverrides(JsonAutoDetect.Value vis) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withVisibility(PropertyAccessor method, JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withGetterVisibility(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withIsGetterVisibility(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withSetterVisibility(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withCreatorVisibility(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public JonixVisibilityChecker withFieldVisibility(JsonAutoDetect.Visibility v) {
        return null;
    }

    @Override
    public boolean isGetterVisible(Method m) {
        return false;
    }

    @Override
    public boolean isGetterVisible(AnnotatedMethod m) {
        return false;
    }

    @Override
    public boolean isIsGetterVisible(Method m) {
        return false;
    }

    @Override
    public boolean isIsGetterVisible(AnnotatedMethod m) {
        return false;
    }

    @Override
    public boolean isSetterVisible(Method m) {
        return false;
    }

    @Override
    public boolean isSetterVisible(AnnotatedMethod m) {
        return false;
    }

    @Override
    public boolean isCreatorVisible(Member m) {
        return false;
    }

    @Override
    public boolean isCreatorVisible(AnnotatedMember m) {
        return false;
    }
}
