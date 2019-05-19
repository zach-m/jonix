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

package com.tectonica.jonix.codegen;

import com.tectonica.jonix.codegen.generator.GenUtil;
import com.tectonica.jonix.codegen.generator.OnixClassGen;
import com.tectonica.jonix.codegen.generator.OnixEnumGen;
import com.tectonica.jonix.codegen.generator.OnixStructGen;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixElementMember;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember.TransformationType;
import com.tectonica.jonix.codegen.util.ListDiff;
import com.tectonica.jonix.codegen.util.OnixSpecs;
import com.tectonica.jonix.codegen.util.ParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateCode {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateCode.class);

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        final String basePackage = GenUtil.COMMON_PACKAGE;
        final String basePath = new File(".").getAbsolutePath();
        final String relativePath = "/src/main/java/com/tectonica/jonix";

        if (!new File(basePath).exists()) {
            throw new RuntimeException("couldn't find base folder for projects at " + basePath);
        }

        final OnixMetadata ref2 = ParseUtil.parse(OnixSpecs.SPECS_2_1_03_REF);
        final OnixMetadata ref3 = ParseUtil.parse(OnixSpecs.SPECS_3_0_06_REF);

        final Map<String, OnixSimpleType> unifiedCodelists = unifyCodelists(ref2, ref3);
        final Map<String, OnixStruct> unifiedStructs = unifyStructs(ref2, ref3);
        //unifyInterfaces(ref2, ref3);

        // Generate source code
        generateCodelists(basePackage, basePath, relativePath, unifiedCodelists.values());
        generateStructs(basePackage, basePath, relativePath, unifiedCodelists, unifiedStructs.values());
        generateOnix2(basePackage, basePath, relativePath, ref2);
        generateOnix3(basePackage, basePath, relativePath, ref3);

        LOGGER.info("DONE");
    }

    private static void generateCodelists(final String basePackage, final String basePath, final String relativePath,
                                          final Collection<OnixSimpleType> unifiedCodelists) {
        final String codelistHome = basePath + "/jonix-common";
        if (!new File(codelistHome).exists()) {
            throw new RuntimeException("couldn't find jonix-common project at " + codelistHome);
        }

        LOGGER.info("Generating unified codelists..");

        final OnixEnumGen oeg = new OnixEnumGen(basePackage, codelistHome + relativePath, "codelist");
        for (OnixSimpleType codelist : unifiedCodelists) {
            oeg.generate(codelist);
        }
    }

    private static void generateStructs(final String basePackage, final String basePath, final String relativePath,
                                        Map<String, OnixSimpleType> unifiedCodelists,
                                        final Collection<OnixStruct> unifiedStructs) {
        final String codelistHome = basePath + "/jonix-common";
        if (!new File(codelistHome).exists()) {
            throw new RuntimeException("couldn't find jonix-common project at " + codelistHome);
        }

        LOGGER.info("Generating unified structs..");

        final OnixStructGen osg =
            new OnixStructGen(basePackage, codelistHome + relativePath, "struct", unifiedCodelists);
        for (OnixStruct struct : unifiedStructs) {
            osg.generate(struct);
        }
    }

    private static void generateOnix2(final String basePackage, final String basePath, final String relativePath,
                                      final OnixMetadata ref2) {
        final String onix2home = basePath + "/jonix-onix2";
        if (!new File(onix2home).exists()) {
            throw new RuntimeException("couldn't find jonix-onix2 project at " + onix2home);
        }

        LOGGER.info("Generating code for Onix2..");
        generateModel(basePackage, onix2home + relativePath, "onix2", ref2);
    }

    private static void generateOnix3(final String basePackage, final String basePath, final String relativePath,
                                      final OnixMetadata ref3) {
        final String onix3home = basePath + "/jonix-onix3";
        if (!new File(onix3home).exists()) {
            throw new RuntimeException("couldn't find jonix-onix3 project at " + onix3home);
        }

        LOGGER.info("Generating code for Onix3..");
        generateModel(basePackage, onix3home + relativePath, "onix3", ref3);
    }

    private static void generateModel(String basePackage, String baseFolder, String subfolder, OnixMetadata ref) {
        final OnixClassGen ccg = new OnixClassGen(basePackage, baseFolder, subfolder, ref);

        for (OnixCompositeDef composite : ref.onixComposites.values()) {
            ccg.generate(composite);
        }

        for (OnixElementDef element : ref.onixElements.values()) {
            ccg.generate(element);
        }

        for (OnixFlagDef flag : ref.onixFlags.values()) {
            ccg.generate(flag);
        }
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * NOTE: this unification process actually modifies some metadata fields parsed from the XSD and passed here as
     * {@link OnixMetadata}, including comment and enumName
     */
    public static Map<String, OnixSimpleType> unifyCodelists(OnixMetadata ref2, OnixMetadata ref3) {

        final String SPACER = "                                        ";
        final Map<String, OnixSimpleType> unifiedCodelists = new HashMap<>();

        // we iterate over the list of enums from Onix2 and Onix3, matching them by name
        ListDiff.sortAndCompare(ref2.getEnums(), ref3.getEnums(), (enum2, enum3) -> {
            // ignore aliases, we'll generate code out of the types they point to
            if (enum2 != null && enum2.enumAliasFor != null) {
                LOGGER.debug("unifyCodelists: Skipping Onix2's {}, alias for {}", enum2.name, enum2.enumName);
            } else if (enum3 != null && enum3.enumAliasFor != null) {
                LOGGER.debug("unifyCodelists: Skipping Onix3's {}, alias for {}", enum3.name, enum3.enumName);
            } else if (enum2 != null && enum3 != null) {
                // enums with same name found in both sides, we need to create a unified version
                final OnixSimpleType unified = unifiedCodelist(enum2, enum3);
                LOGGER.debug("unifyCodelists: {} {}", SPACER, unified.enumName);
                unifiedCodelists.put(enum3.name, unified);
            } else if (enum2 != null) {
                // enum from Onix2 exists, with no match on Onix3, we add it as is (with a deprecation comment)
                LOGGER.debug("unifyCodelists: [onix2] " + enum2.enumName);
                enum2.comment += "\n<p>" + "NOTE: Deprecated in Onix3"; // TODO: <p> goes through URL-encofing
                unifiedCodelists.put(enum2.name, enum2);
            } else {
                assert enum3 != null;
                // enum from Onix3 exists, with no match on Onix2, we add it as is
                LOGGER.debug("unifyCodelists: {} {} [onix3] {}", SPACER, SPACER, enum3.enumName);
                enum3.comment += "\n<p>" + "NOTE: Introduced in Onix3"; // TODO: <p> goes through URL-encofing
                unifiedCodelists.put(enum3.name, enum3);
            }
            return true;
        });

        // since we might be comparing codelists from different issues (e.g. 36 vs 45), it could happen that the
        // same enumName appears in different issues under different names (=codelist number). for example, the
        // enumName "ProductForms" is under the name "List7" in issue 36, but under the name "List150" in 45.
        // we now cross-compare enumNames, and rename the one that's older (smaller issue number)
        Map<String, Long> counters = unifiedCodelists.values().stream()
            .filter(ost -> ost.isEnum() && ost.enumAliasFor == null)
            .collect(Collectors.groupingBy(ost -> ost.enumName, HashMap::new, Collectors.counting()));
        List<Map.Entry<String, Long>> clashes =
            counters.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList());
        if (clashes.size() > 0) {
            LOGGER.warn("unifyCodelists: enumName clashes at: {}", clashes);
            for (Map.Entry<String, Long> clash : clashes) {
                String enumName = clash.getKey();
                unifiedCodelists.values().stream()
                    .filter(ost -> ost.enumAliasFor == null)
                    .filter(ost -> enumName.equals(ost.enumName))
                    .sorted(Comparator.comparing(o -> Long.parseLong(o.enumCodelistIssue)))
                    .forEach(ost -> {
                        if (clash.getValue() > 1) {
                            String newEnumName = ost.enumName + ost.name;
                            LOGGER.info("unifyCodelists: renaming {}.{} -> {} in issue {}",
                                ost.name, ost.enumName, newEnumName, ost.enumCodelistIssue);
                            ost.enumName = newEnumName;
                            clash.setValue(clash.getValue() - 1L);
                        }
                    });
            }
        }

        ref2.unifiedCodelists = unifiedCodelists;
        ref3.unifiedCodelists = unifiedCodelists;

        return unifiedCodelists;
    }

    private static OnixSimpleType unifiedCodelist(final OnixSimpleType enum2, final OnixSimpleType enum3) {
        final OnixSimpleType result = OnixSimpleType.cloneFrom(enum3);

        // the enums in both sides are sorted by value right from the XSD
        ListDiff.compare(enum2.enumValues, enum3.enumValues, (enumValue2, enumValue3) -> {
            if (enumValue2 != null && enumValue3 != null) {
                //if (!enumValue2.name.equals(enumValue3.name)) {
                //    LOGGER.debug("unifyCodelists: Difference in enumValue: Onix2={}, Onix3={}", enumValue2, enumValue3);
                //}
            } else if (enumValue2 != null) {
                //LOGGER.debug("unifyCodelists: Unique to Onix2: " + enum2.enumName + "." + enumValue2);
                enumValue2.description += "\n<p>" + "NOTE: Deprecated in Onix3"; // TODO: <p> goes through URL-encofing
                result.add(enumValue2);
            } else {
                //LOGGER.debug("unifyCodelists: Unique to Onix3: " + enum3.enumName + "." + enumValue3);
                enumValue3.description += "\n<p>" + "NOTE: Introduced in Onix3"; // TODO: <p> goes through URL-encofing
            }
            return true;
        });
        return result;
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static Map<String, OnixStruct> unifyStructs(final OnixMetadata ref2, final OnixMetadata ref3) {
        final Map<String, OnixStruct> unifiedStructs = new HashMap<>();

        ListDiff.sortAndCompare(ref2.getStructs(), ref3.getStructs(), (struct2, struct3) -> {
            if (struct2 != null && struct3 != null) {
                final OnixStruct unified = unifiedStruct(struct2, struct3, ref2, ref3);
                if (unified != null) {
                    String name = struct3.containingComposite.name;
                    unifiedStructs.put(name, unified);
                }
            } else if (struct2 != null) {
                final String name = struct2.containingComposite.name;
                if (ref3.onixComposites.containsKey(name)) {
                    LOGGER.warn("<" + name + "> is a struct in Onix2 but doesn't qualify for one in Onix3");
                } else {
                    unifiedStructs.put(name, struct2);
                }
            } else {
                final String name = struct3.containingComposite.name;
                if (ref2.onixComposites.containsKey(name)) {
                    LOGGER.warn("<" + name + "> is a struct in Onix3 but doesn't qualify for one in Onix2");
                } else {
                    unifiedStructs.put(name, struct3);
                }
            }
            return true;
        });

        ref2.unifiedStructs = unifiedStructs;
        ref3.unifiedStructs = unifiedStructs;

        return unifiedStructs;
    }

    private static OnixStruct unifiedStruct(final OnixStruct struct2, final OnixStruct struct3,
                                            final OnixMetadata ref2, final OnixMetadata ref3) {
        final String className = struct3.containingComposite.name;
        final OnixStruct unified = new OnixStruct(struct3.containingComposite);

        if (struct2.isKeyed() != struct3.isKeyed()) {
            throw new RuntimeException("Class " + className
                + ", can't be unified into struct as keys are of different searchability: Onix2="
                + struct2.isKeyed() + " Onix3=" + struct3.isKeyed());
        }

        if (struct3.keyMember != null) {
            final String keyName2 = struct2.keyEnumType().name;
            final String keyName3 = struct3.keyEnumType().name;
            if (!keyName2.equals(keyName3)) {
                throw new RuntimeException("Class " + className
                    + ", can't be unified into struct as keys are of different types: Onix2=" + keyName2
                    + " Onix3=" + keyName3);
            }

            unified.keyMember = struct3.keyMember;

            // even though the type of the key may be the same (which is what's really important for us), we deal with
            // the case where the
            // elements' name is different (for example MeasureTypeCode vs MeasureType)
            if (!struct2.keyMember.dataMember.className.equals(struct3.keyMember.dataMember.className)) {
                unified.keyMember.transformationNeededInVersion = ref2.onixVersion;
                unified.keyMember.transformationType = TransformationType.ChangeClassName;
                unified.keyMember.transformationHint = struct2.keyMember.dataMember.className;
            }
        }

        unified.members = new ArrayList<>();

        boolean completed = ListDiff.sortAndCompare(struct2.members, struct3.members,
            (osm2, osm3) -> {
                if (osm2 != null && osm3 != null) {
                    OnixCompositeMember m2 = osm2.dataMember;
                    OnixCompositeMember m3 = osm3.dataMember;
                    if (m2.getClass() != m3.getClass()) { // element vs flag
                        throw new RuntimeException("Can't deal with types collision in " + className + ": "
                            + m2.getClass().getSimpleName() + " vs " + m3.getClass().getSimpleName());
                    }

                    final String memberClassName = m2.className; // = m3.className
                    if (m2.onixClass instanceof OnixElementDef) {
                        OnixElementMember vm2 = ((OnixElementDef) m2.onixClass).valueMember;
                        OnixElementMember vm3 = ((OnixElementDef) m3.onixClass).valueMember;
                        final String javaType2 = vm2.simpleType.primitiveType.javaType;
                        final String javaType3 = vm3.simpleType.primitiveType.javaType;
                        if (!javaType2.equals(javaType3)) {
                            if (javaType2.equals("String") && javaType3.equals("Integer")) {
                                osm3.transformationNeededInVersion = ref2.onixVersion;
                                osm3.transformationType = TransformationType.StringToInteger;
                            } else if (javaType2.equals("String") && javaType3.equals("Double")) {
                                osm3.transformationNeededInVersion = ref2.onixVersion;
                                osm3.transformationType = TransformationType.StringToDouble;
                            } else {
                                LOGGER.warn("<" + className
                                    + "> can't be unified into struct: type mismatch in '"
                                    + memberClassName + "': Onix2=" + javaType2 + " vs Onix3=" + javaType3);
                                return false; // can't unify, we cancel the scanning of the remaining members
                            }
                        }
                        if (m2.cardinality.singular != m3.cardinality.singular) {
                            osm3.transformationNeededInVersion = m2.cardinality.singular ? ref2.onixVersion
                                : ref3.onixVersion;
                            osm3.transformationType = TransformationType.SingularToMultiple;
                        }
                    }
                    unified.members.add(osm3);
                } else if (osm2 != null) {
                    LOGGER.warn("<" + className + "> Onix2 has a unique field '"
                        + osm2.dataMember.className + "' - this field will not be part the unified struct");
                } else {
                    LOGGER.warn("<" + className + "> Onix2 has a unique field '"
                        + osm3.dataMember.className + "' - this field will not be part the unified struct");
                }
                return true;
            });
        return (completed ? unified : null);
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //private static List<OnixCompositeDef> unifyInterfaces(final OnixMetadata ref2, final OnixMetadata ref3) {
    //    final List<OnixCompositeDef> unifiedInterfaces = new ArrayList<>();
    //
    //    ListDiff.sortAndCompare(ref2.getIntfs(), ref3.getIntfs(), new CompareListener<OnixCompositeDef>() {
    //        @Override
    //        public boolean onDiff(final OnixCompositeDef composite2, final OnixCompositeDef composite3) {
    //            LOGGER.warn("---------------------------------------------------------------------------");
    //            if (composite2 != null && composite3 != null) {
    //                LOGGER.warn("non-struct: " + composite2.name + "\n");
    //                ListDiff.sortAndCompare(composite2.members, composite3.members,
    //                    new CompareListener<OnixCompositeMember>() {
    //                        @Override
    //                        public boolean onDiff(OnixCompositeMember m2, OnixCompositeMember m3) {
    //                            if (m2 != null && m3 != null) {
    //                                LOGGER.warn("SHARED: " + m2.className);
    //                            } else if (m2 != null) {
    //                                LOGGER.warn("                    ONIX-2: " + m2.className);
    //                            } else {
    //                                LOGGER.warn("                    ONIX-3: " + m3.className);
    //                            }
    //                            return true;
    //                        }
    //                    });
    //            } else if (composite2 != null) {
    //                LOGGER.warn("Onix2 non-struct: " + composite2.name);
    //            } else {
    //                LOGGER.warn("Onix3 non-struct: " + composite3.name);
    //            }
    //            return true;
    //        }
    //    });
    //
    //    return unifiedInterfaces;
    //}
}
