/*
 * Copyright (C) 2012-2020 Zach Melamed
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

import com.tectonica.jonix.codegen.generator.GenUtil.FieldInfo;
import com.tectonica.jonix.codegen.generator.GenUtil.TypeInfo;
import com.tectonica.jonix.codegen.metadata.Cardinality;
import com.tectonica.jonix.codegen.metadata.OnixAttribute;
import com.tectonica.jonix.codegen.metadata.OnixClassDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixConst;
import com.tectonica.jonix.codegen.metadata.OnixDoc;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OnixClassGen {
    private final String packageName;
    private final File folder;

    private final OnixMetadata ref;
    private final GenUtil genUtil;

    public OnixClassGen(String basePackage, String baseFolder, String subfolder, OnixMetadata ref) {
        this.ref = ref;
        packageName = basePackage + "." + subfolder;
        folder = new File(baseFolder, subfolder);
        genUtil = new GenUtil(ref.unifiedCodelists);
        GenUtil.prepareOutputFolder(folder);
    }

    public void generate(OnixClassDef onixClass) {
        try {
            File javaFile = new File(folder, onixClass.name + ".java");

            try (PrintStream p = new PrintStream(javaFile, "UTF-8")) {
                if (onixClass instanceof OnixCompositeDef) {
                    writeCompositeClass((OnixCompositeDef) onixClass, p);
                } else if (onixClass instanceof OnixElementDef) {
                    writeElementClass((OnixElementDef) onixClass, p);
                } else if (onixClass instanceof OnixFlagDef) {
                    writeFlagClass((OnixFlagDef) onixClass, p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeCompositeClass(OnixCompositeDef composite, PrintStream p) {
        final String markerInterfaceName;

        final boolean isDataComposite = ref.jonixStructs.containsKey(composite.name);
        final OnixStruct struct = ref.unifiedStructs.get(composite.name);
        if (isDataComposite) {
            if (struct == null) {
                markerInterfaceName = "OnixDataCompositeUncommon";
            } else {
                final String structName = "Jonix" + composite.name;

                if (struct.isKeyed()) {
                    OnixCompositeMember keyMember = struct.keyMember.dataMember;
                    OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
                    GenUtil.TypeInfo keyTypeInfo = genUtil.typeInfoOf(keyClass.valueMember.simpleType);
                    markerInterfaceName = String.format("OnixDataCompositeWithKey<%s,%s>", structName,
                        keyTypeInfo.javaType);
                } else {
                    markerInterfaceName = String.format("OnixDataComposite<%s>", structName);
                }
            }
        } else {
            if (composite.name.equalsIgnoreCase("Product")) {
                markerInterfaceName = "OnixProduct";
            } else if (composite.name.equalsIgnoreCase("Header")) {
                markerInterfaceName = "OnixHeader";
            } else {
                markerInterfaceName = "OnixSuperComposite";
            }
        }

        List<OnixCompositeMember> sortedMembers = new ArrayList<>(composite.members);
        sortedMembers.sort((o1, o2) -> Cardinality.displayOrderComparator.compare(o1.cardinality, o2.cardinality));

        p.printf("%s\n", Comments.Copyright);
        p.printf("package %s;\n", packageName);
        p.print("\n");
        p.print("import java.io.Serializable;\n");
        p.print("import java.util.List;\n");
        p.print("import java.util.ArrayList;\n");
        p.print("import java.util.Arrays;\n");
        p.print("import java.util.Collections;\n");
        p.print("\n");
        p.printf("import %s.*;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.OnixComposite.*;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.struct.*;\n", GenUtil.COMMON_PACKAGE);
        p.print("\n");
        p.printf("%s\n", Comments.AutoGen);

        printOnixDocs(p, composite);
        p.printf("public class %s implements %s, Serializable\n", composite.name, markerInterfaceName);
        p.printf("{\n");

        declareConstsAndAttributes(p, composite);

        /////////////////////////////////////////////////////////////////////////////////
        // CONSTRUCTION
        /////////////////////////////////////////////////////////////////////////////////

        p.print("\n");
        printCaptionComment(p, "CONSTRUCTION");

        p.print("\n");
        p.printf("   private boolean initialized;\n");
        p.printf("   private final boolean exists;\n");
        p.printf("   private final org.w3c.dom.Element element;\n");
        p.printf("   public static final %s EMPTY = new %s();\n", composite.name, composite.name);

        // default-constructor
        p.print("\n");
        p.printf("   public %s() {\n", composite.name);
        p.printf("      exists = false;\n");
        p.printf("      element = null;\n");
        p.printf("      initialized = true; "
            + "// so that no further processing will be done on this intentionally-empty object\n");
        p.printf("   }\n");

        // constructor
        p.print("\n");
        p.printf("   public %s(org.w3c.dom.Element element) {\n", composite.name);
        p.printf("      exists = true;\n");
        p.printf("      initialized = false;\n");
        p.printf("      this.element = element;\n");
        setInitializers(composite, p);
        p.printf("   }\n");

        p.print("\n");
        p.printf("   @Override\n");
        p.printf("   public void _initialize() {\n");
        p.printf("      if (initialized) { return; }\n");
        p.printf("      initialized = true;\n");

        p.print("\n");
        p.printf("      JPU.forElementsOf(element, e -> {\n");
        p.printf("         final String name = e.getNodeName();\n");
        p.printf("         switch (name) {\n");
        for (OnixCompositeMember m : sortedMembers) {
            final String className = m.className;
            String field = genUtil.fieldNameFor(className);
            if (!m.cardinality.singular) {
                field += "s";
            }
            p.printf("            case %s.refname:\n", className);
            p.printf("            case %s.shortname:\n", className);
            if (m.cardinality.singular) {
                p.printf("               %s = new %s(e);\n", field, className);
            } else {
                p.printf("               %s = JPU.addToList(%s, new %s(e));\n", field, field, className);
            }
            p.printf("               break;\n");
        }
        p.printf("            default:\n");
        p.printf("               break;\n");
        p.printf("         }\n");

        p.printf("      });\n");

        p.printf("   }\n");

        p.print("\n");
        p.printf("   /**\n");
        p.printf("    * @return whether this tag (&lt;%s&gt; or &lt;%s&gt;) is explicitly provided in the ONIX XML\n",
            composite.name, composite.constValue("shortname"));
        p.printf("    */\n");
        p.printf("   @Override\n");
        p.printf("   public boolean exists() {\n");
        p.printf("      return exists;\n");
        p.printf("   }\n");

        p.print("\n");
        p.printf("   @Override\n");
        p.printf("   public org.w3c.dom.Element getXmlElement() {\n");
        p.printf("      return element;\n");
        p.printf("   }\n");

        /////////////////////////////////////////////////////////////////////////////////
        // MEMBERS
        /////////////////////////////////////////////////////////////////////////////////

        p.print("\n");
        printCaptionComment(p, "MEMBERS");

        for (OnixCompositeMember member : sortedMembers) {
            final FieldInfo fi = genUtil.fieldInfoOf(member, ref);

            // declare member in a private field
            p.print("\n");
            p.printf("   private %s %s = %s;\n", fi.type, fi.name, fi.emptyPhrase);

            // declare public accessor to the member
            p.print("\n");
            p.printf("   /**\n");
            if (member.onixDoc != null) {
                p.printf("    * %s\n", member.onixDoc.escapedDescription);
            }
            p.printf("    * Jonix-Comment: %s\n", fi.comment);
            p.printf("    */\n");
            p.printf("   public %s %s() {\n", fi.type, fi.name);
            p.printf("      _initialize();\n");
            p.printf("      return %s;\n", fi.name);
            p.printf("   }\n");

            // declare direct boolean getter for flag-members
            final OnixFlagDef flag = ref.onixFlags.get(member.className);
            if (flag != null) {
                if (!member.cardinality.singular) {
                    // TODO: this is not the right place to make this validation. move to parsing.
                    throw new RuntimeException("can't handle multiple flags");
                }

                p.print("\n");
                p.printf("   public boolean is%s() {\n", member.className);
                p.printf("      return (%s().exists());\n", fi.name);
                p.printf("   }\n");
            }
        }

        // declare struct provider on composites that can be represented as one
        if (struct != null) {
            final String structName = "Jonix" + composite.name;

            p.print("\n");
            p.printf("   @Override\n");
            p.printf("   public %s asStruct() {\n", structName);
            p.printf("      _initialize();\n");
            p.printf("      %s struct = new %s();\n", structName, structName);

            for (OnixStructMember structMember : struct.allMembers()) {
                final OnixCompositeMember member = structMember.dataMember;
                if (member.onixClass instanceof OnixElementDef) {
                    String targetField = genUtil.fieldNameFor(member.className);
                    String field = targetField;
                    if (!member.cardinality.singular) {
                        field += "s";
                    }
                    boolean transformationNeeded = (structMember.transformationNeededInVersion == ref.onixVersion);
                    if (transformationNeeded) {
                        switch (structMember.transformationType) {
                            case SingularToMultiple:
                                p.printf("      struct.%s = Arrays.asList(%s.value);\n", field, targetField);
                                break;
                            case ChangeClassName:
                                p.printf("      struct.%s = %s.value;\n", field,
                                    genUtil.fieldNameFor(structMember.transformationHint));
                                break;
                            default:
                                p.printf("      struct.%s = JPU.convert%s(%s.value);\n", field,
                                    structMember.transformationType.name(), field);
                        }
                    } else {
                        String caption = (member.cardinality.singular) ? "value" : "values()";
                        p.printf("      struct.%s = %s.%s;\n", field, field, caption);
                    }
                } else {
                    // i.e. (member.onixClass instanceof OnixFlagDef)
                    p.printf("      struct.is%s = is%s();\n", member.className, member.className);
                }
            }

            p.printf("      return struct;\n");
            p.printf("   }\n");

            if (struct.isKeyed()) {
                OnixCompositeMember keyMember = struct.keyMember.dataMember;
                String field = genUtil.fieldNameFor(keyMember.className);
                boolean transformationNeeded = (struct.keyMember.transformationNeededInVersion == ref.onixVersion);
                if (transformationNeeded) {
                    if (struct.keyMember.transformationType == OnixStructMember.TransformationType.ChangeClassName) {
                        field = genUtil.fieldNameFor(struct.keyMember.transformationHint);
                    } else {
                        throw new UnsupportedOperationException(
                            "Still not handling key-transofmration other than ChangeClassName");
                    }
                }
                OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
                TypeInfo keyTypeInfo = genUtil.typeInfoOf(keyClass.valueMember.simpleType);
                p.print("\n");
                p.printf("   @Override\n");
                p.printf("   public %s structKey() {\n", keyTypeInfo.javaType);
                p.printf("      return %s().value;\n", field);
                p.printf("   }\n");
            }
        }

        p.print("}\n");
    }

    private void writeElementClass(OnixElementDef element, PrintStream p) {
        p.printf("%s\n", Comments.Copyright);
        p.printf("package %s;\n", packageName);
        p.print("\n");
        p.print("import java.io.Serializable;\n");
        p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.OnixElement;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
        p.print("\n");
        p.printf("%s\n", Comments.AutoGen);

        // analyze the main value of the element
        final TypeInfo ti = genUtil.typeInfoOf(element.valueMember.simpleType);
        String valueType = element.isSpaceable ? String.format("java.util.Set<%s>", ti.javaType) : ti.javaType;

        printOnixDocs(p, element);
        p.printf("public class %s implements OnixElement<%s>, Serializable\n", element.name, valueType);
        p.printf("{\n");

        declareConstsAndAttributes(p, element);

        p.print("\n");
        printCaptionComment(p, "VALUE MEMBER");

        // declare value
        p.print("\n");
        if (ti.comment != null) {
            p.printf("   /**\n");
            p.printf("   * This is the raw content of %s. Could be null if {@code exists() == false}.\n", element.name);
            p.printf("   * Use {@link #value()} instead if you want to get this as an {@link java.util.Optional}.\n");
            p.printf("   * <p>\n");
            if (element.onixDocs != null) {
                OnixDoc onixDoc = element.onixDocs.get(0); // TODO: first is arbitrary
                if (onixDoc.escapedFormat != null && !onixDoc.escapedFormat.isEmpty()) {
                    p.printf("   * Raw Format: %s<p>\n", onixDoc.escapedFormat);
                }
            }
            p.printf("   * %s\n", ti.comment);
            p.printf("   */\n");
        }
        p.printf("   public %s value;\n", valueType);

        // declare internal accessor to value
        p.print("\n");
        p.printf("   /**\n");
        p.printf("   * Internal API, use the {@link #value()} method or the {@link #value} field instead\n");
        p.printf("   */\n");
        p.printf("   @Override\n");
        p.printf("   public %s _value() {\n", valueType);
        p.printf("      return value;\n");
        p.printf("   }\n");

        p.print("\n");
        printCaptionComment(p, "SERVICES");

        p.print("\n");
        p.printf("   private final boolean exists;\n");
        p.printf("   public static final %s EMPTY = new %s();\n", element.name, element.name);

        // default-constructor
        p.print("\n");
        p.printf("   public %s() {\n", element.name);
        p.printf("      exists = false;\n");
        p.printf("   }\n");

        // constructor
        p.print("\n");
        p.printf("   public %s(org.w3c.dom.Element element) {\n", element.name);
        p.printf("      exists = true;\n");

        setInitializers(element, p);

        p.print("\n");
        if (ti.isXHTML) {
            p.printf("      value = JPU.getChildXHTML(element, true);\n");
        } else if (!element.isSpaceable) {
            if (ti.isPrimitive) {
                p.printf("      value = JPU.getContentAs%s(element);\n", ti.javaType);
            } else {
                p.printf("      value = %s.byCode(JPU.getContentAsString(element));\n", ti.javaType);
            }
        } else {
            p.printf("      value = new java.util.HashSet<>();\n");
            p.printf("      for (String split : JPU.getContentAsString(element).split(\" +\")) {\n");
            if (ti.isPrimitive) {
                p.printf("         value.add(%s.valueOf(split));\n", ti.javaType);
            } else {
                p.printf("         value.add(%s.byCode(split));\n", ti.javaType);
            }
            p.printf("      }\n");
        }

        p.printf("   }\n");

        p.print("\n");
        p.printf("   /**\n");
        p.printf("    * @return whether this tag (&lt;%s&gt; or &lt;%s&gt;) is explicitly provided in the ONIX XML\n",
            element.name, element.constValue("shortname"));
        p.printf("    */\n");
        p.printf("   @Override\n");
        p.printf("   public boolean exists() {\n");
        p.printf("      return exists;\n");
        p.printf("   }\n");

        p.print("}\n");
    }

    private void writeFlagClass(OnixFlagDef flag, PrintStream p) {
        p.printf("%s\n", Comments.Copyright);
        p.printf("package %s;\n", packageName);
        p.print("\n");
        p.print("import java.io.Serializable;\n");
        p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.OnixFlag;\n", GenUtil.COMMON_PACKAGE);
        p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
        p.print("\n");
        p.printf("%s\n", Comments.AutoGen);

        printOnixDocs(p, flag);
        p.printf("public class %s implements OnixFlag, Serializable\n", flag.name);
        p.printf("{\n");

        declareConstsAndAttributes(p, flag);

        p.print("\n");
        printCaptionComment(p, "CONSTRUCTORS");

        p.print("\n");
        p.printf("   private final boolean exists;\n");
        p.printf("   public static final %s EMPTY = new %s();\n", flag.name, flag.name);

        // default-constructor
        p.print("\n");
        p.printf("   public %s() {\n", flag.name);
        p.printf("      exists = false;\n");
        p.printf("   }\n");

        // constructor
        p.print("\n");
        p.printf("   public %s(org.w3c.dom.Element element) {\n", flag.name);
        p.printf("      exists = true;\n");

        setInitializers(flag, p);

        p.printf("   }\n");

        p.print("\n");
        p.printf("   /**\n");
        p.printf("    * @return whether this tag (&lt;%s&gt; or &lt;%s&gt;) is explicitly provided in the ONIX XML\n",
            flag.name, flag.constValue("shortname"));
        p.printf("    */\n");
        p.printf("   @Override\n");
        p.printf("   public boolean exists() {\n");
        p.printf("      return exists;\n");
        p.printf("   }\n");

        p.print("}\n");
    }

    private void printOnixDocs(PrintStream p, OnixClassDef onixClass) {
        p.printf("/**\n");
        List<OnixDoc> onixDocs = onixClass.onixDocs;
        if (onixDocs != null) {
            p.printf(" * %s\n", onixDocs.get(0).toHtml(false)); // TODO: first is arbitrary
            p.printf(" * <p/>\n");
        }

        if (onixClass.parents != null) { // should only happen in "ONIXMessage"
            p.printf(" * This tag may be included in the following composites:\n");
            p.printf(" * <ul>\n");
            onixClass.parents.forEach(parent -> p.printf(" * <li>&lt;{@link %s}&gt;</li>\n", parent.name));
            p.printf(" * </ul>\n");
            p.printf(" * <p/>\n");
        }

        p.printf(" * Possible placements within ONIX message:\n");
        p.printf(" * <ul>\n");
        onixClass.paths.stream()
            .map(path -> "{@link " + path.replaceAll("/", "} ⯈ {@link ") + "}")
            .forEach(path -> p.printf(" * <li>%s</li>\n", path));
        p.printf(" * </ul>\n");

        boolean deprecated = false;
        if (onixDocs != null) {
            Set<String> tags = onixDocs.get(0).tags; // TODO: first is arbitrary
            String since = tags.stream().filter(tag -> tag.startsWith("new")).findFirst().map(
                tag -> "Onix-" + tag.substring(3, 4) + "." + tag.substring(4)).orElse(null);
            deprecated = tags.contains("deprecated");
            if ((since != null) || deprecated) {
                p.printf(" *\n");
            }
            if (since != null) {
                if (since.equals("Onix-2.10")) {
                    since = "Onix-2.1";
                }
                p.printf(" * @since %s\n", since);
            }
            if (deprecated) {
                p.printf(" * @deprecated\n");
            }
        }

        p.print(" */\n");

        if (deprecated) {
            p.print("@Deprecated\n");
        }
    }

    private void declareConstsAndAttributes(PrintStream p, OnixClassDef clz) {
        p.printf("   private static final long serialVersionUID = 1L;\n\n");

        for (OnixConst c : clz.consts) {
            p.printf("   public static final String %s = \"%s\";\n", c.name, c.value);
        }

        p.print("\n");
        printCaptionComment(p, "ATTRIBUTES");
        for (OnixAttribute a : clz.attributes) {
            final TypeInfo ti = genUtil.typeInfoOf(a);
            p.print("\n");
            if (ti.comment != null) {
                p.printf("   /**\n");
                p.printf("    * %s\n", ti.comment);
                p.printf("    */\n");
            }
            p.printf("   public %s %s;\n", ti.javaType, a.name);
        }
    }

    private void setInitializers(OnixClassDef clz, PrintStream p) {
        for (OnixAttribute a : clz.attributes) {
            TypeInfo ti = genUtil.typeInfoOf(a);

            if (ti.isPrimitive) {
                // EXAMPLE: datestamp = JPU.getAttribute(element, "datestamp");
                p.printf("      %s = JPU.getAttribute(element, \"%s\");\n", a.name, a.name);
            } else {
                // EXAMPLE: textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
                p.printf("      %s = %s.byCode(JPU.getAttribute(element, \"%s\"));\n", a.name, ti.javaType, a.name);
            }
        }
    }

    private void printCaptionComment(PrintStream p, String caption) {
        p.print("   /////////////////////////////////////////////////////////////////////////////////\n");
        p.printf("%s\n", "   // " + caption);
        p.print("   /////////////////////////////////////////////////////////////////////////////////\n");
    }
}
