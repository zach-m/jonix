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

import com.tectonica.jonix.codegen.generator.GenUtil.TypeInfo;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixDoc;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;

import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class OnixStructGen {
    private static final String COMMON_PACKAGE = "com.tectonica.jonix";

    private final String packageName;
    private final File folder;
    private final GenUtil genUtil;

    public OnixStructGen(String basePackage, String baseFolder, String subfolder,
                         Map<String, OnixSimpleType> unifiedCodelists) {
        packageName = basePackage + "." + subfolder;
        folder = new File(baseFolder, subfolder);
        genUtil = new GenUtil(unifiedCodelists);
        GenUtil.prepareOutputFolder(folder);
    }

    public void generate(OnixStruct struct) {
        try {
            final String structName = "Jonix" + struct.containingComposite.name;
            File javaFile = new File(folder, structName + ".java");

            try (PrintStream p = new PrintStream(javaFile, "UTF-8")) {
                writeStruct(struct, structName, p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeStruct(OnixStruct struct, String structName, PrintStream p) {
        String structMarkerInterface = "JonixStruct";
        String structKeyQualifier = "";

        OnixCompositeMember keyMember;
        OnixElementDef keyClass;
        TypeInfo keyTypeInfo = null;
        String keyField = null;
        if (struct.isKeyed()) {
            keyMember = struct.keyMember.dataMember;
            keyClass = (OnixElementDef) keyMember.onixClass;
            keyTypeInfo = genUtil.typeInfoOf(keyClass.valueMember.simpleType);
            keyField = genUtil.fieldNameFor(keyMember.className);
            structMarkerInterface = "JonixKeyedStruct";
            structKeyQualifier = "<" + keyTypeInfo.javaType + ">";
        }

        p.printf("%s\n", Comments.Copyright);
        p.printf("package %s;\n", packageName);
        p.print("\n");
        p.print("import java.io.Serializable;\n");
        p.print("import java.util.List;\n");
        p.print("\n");

        p.printf("import %s.%s;\n", COMMON_PACKAGE, structMarkerInterface);
        p.printf("import %s.codelist.*;\n", COMMON_PACKAGE);
        p.print("\n");
        p.printf("%s\n", Comments.AutoGen);
        p.printf("@SuppressWarnings(\"serial\")\n");
        p.printf("public class %s implements %s%s, Serializable\n", structName, structMarkerInterface,
            structKeyQualifier);
        p.printf("{\n");

        p.printf("   public static %s EMPTY = new %s();\n", structName, structName);
        p.print("\n");

        // declare key
        if (struct.isKeyed()) {
            p.printf("   /**\n");
            p.printf("    * the key of this struct (by which it can be looked up)\n");
            if (keyTypeInfo.comment != null) {
                p.printf("    * <p>%s\n", keyTypeInfo.comment);
            }
            p.printf("    */\n");
            p.printf("   public %s %s;\n", keyTypeInfo.javaType, keyField);
            p.print("\n");
        }

        // declare members
        boolean firstField = true;
        for (OnixStructMember structMember : struct.members) {
            final OnixCompositeMember member = structMember.dataMember;
            String field;
            String javaType;
            String comment;
            if (member.onixClass instanceof OnixElementDef) {
                final OnixElementDef memberClass = (OnixElementDef) member.onixClass;
                final TypeInfo ti = genUtil.typeInfoOf(memberClass.valueMember.simpleType);
                field = genUtil.fieldNameFor(member.className);
                javaType = ti.javaType;
                if (memberClass.isSpaceable) {
                    javaType = "java.util.Set<" + javaType + ">";
                }

                comment = ti.comment;
                boolean isEnum = memberClass.valueMember.simpleType.isEnum();
                if (!isEnum) { // no need to provide format information on enums, they are parsed by the system
                    if (memberClass.onixDocs != null) {
                        OnixDoc onixDoc = memberClass.onixDocs.get(0); // TODO: first is arbitrary here
                        if (onixDoc.format != null && !onixDoc.format.isEmpty()) {
                            comment = "Raw Format: " + onixDoc.format + " <p> " + comment;
                        }
                    }
                }
            } else {
                // i.e. (member.onixClass instanceof OnixFlagDef)
                field = "is" + member.className;
                javaType = "boolean";
                comment = "(optional flag)";
            }

            if (!firstField) {
                p.print("\n");
            } else {
                firstField = false;
            }
            if (comment != null) {
                p.printf("   /**\n");
                p.printf("    * %s\n", comment);
                p.printf("    */\n");
            }
            if (member.cardinality.singular) {
                p.printf("   public %s %s;\n", javaType, field);
            } else {
                p.printf("   public List<%s> %ss;\n", javaType, field);
            }
        }

        // declare key
        if (struct.isKeyed()) {
            p.printf("\n");
            p.printf("   @Override\n");
            p.printf("   public %s key() { return %s; }\n", keyTypeInfo.javaType, keyField);
        }

        p.print("}\n");
    }
}
