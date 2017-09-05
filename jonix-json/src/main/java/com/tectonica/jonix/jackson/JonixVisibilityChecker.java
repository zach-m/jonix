package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.tectonica.jonix.OnixTag;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author Zach Melamed
 * @since 9/5/2017
 */
public class JonixVisibilityChecker implements VisibilityChecker<JonixVisibilityChecker> {

    @Override
    public boolean isFieldVisible(Field f) {
        boolean isPublic = Modifier.isPublic(f.getModifiers());
        if (isPublic) {
            return true;
        }
        boolean isPrivate = Modifier.isPrivate(f.getModifiers());
        return isPrivate &&
            (List.class.isAssignableFrom(f.getType()) || OnixTag.class.isAssignableFrom(f.getType()));
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
