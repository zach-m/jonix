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

import com.tectonica.jonix.codegen.metadata.OnixEnumValue;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.util.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class OnixEnumGen {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnixEnumGen.class);

    private static final int MIN_FOR_MAP = 8;

    private final String packageName;
    private final File folder;

    public OnixEnumGen(String basePackage, String baseFolder, String subfolder) {
        packageName = basePackage + "." + subfolder;
        folder = new File(baseFolder, subfolder);
        GenUtil.prepareOutputFolder(folder);
    }

    public void generate(OnixSimpleType enumType) {
        if (enumType.enumAliasFor != null) {
            throw new RuntimeException("Alias enum was passed: " + enumType.name + " ==> " + enumType.enumAliasFor);
        }

        if (!enumType.isEnum()) {
            throw new RuntimeException("Non-enum: " + enumType);
        }

        try {
            File javaFile = new File(folder, enumType.enumName + ".java");
            try (PrintStream p = new PrintStream(javaFile, "UTF-8")) {
                writeEnumClass(enumType, p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeEnumClass(OnixSimpleType enumType, PrintStream p) {
        p.printf("%s\n", Comments.Copyright);
        p.printf("package %s;\n", packageName);

        p.print("\n");
        p.print("import com.tectonica.jonix.OnixCodelist;\n");
        if (enumType.enumValues.size() >= MIN_FOR_MAP) {
            p.print("\n");
            p.print("import java.util.Map;\n");
            p.print("import java.util.HashMap;\n");
        }

        p.print("\n");
        p.printf("%s\n", Comments.AutoGen);

        String codelistNum = enumType.name.substring("List".length());
        String codelistDescription = XML.escape(enumType.description);

        p.printf("/**\n");
        p.printf(" * marker interface to assist in IDE navigation to code-list %s (%s)\n", codelistNum,
            codelistDescription);
        p.printf(" */\n");
        p.printf("interface CodeList%s {\n", codelistNum);
        p.printf("}\n");

        p.print("\n");
        p.printf("/**\n");
        p.printf(" * <code>Enum</code> that corresponds to ONIX <b>Codelist %s</b>\n", codelistNum);
        if (enumType.description != null) {
            p.printf(" * <p>\n");
            p.printf(" * Description: %s\n", codelistDescription);
        }
        if (enumType.comment != null) {
            p.printf(" * <p>\n");
            p.printf(" * Jonix-Comment: %s\n", XML.escape(enumType.comment));
        }
        // TODO: instead of the following link, we need to parse the Codelist spec-HTML, and unify it
        String linkGeneral = "https://www.editeur.org/14/Code-Lists/";
        String link = "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/"
            + "ONIX_BookProduct_Codelists_Issue_" + enumType.enumCodelistIssue + ".html#codelist" + codelistNum;
        p.printf(" * \n");
        p.printf(" * @see <a href=\"%s\">About ONIX Codelists</a>\n", linkGeneral);
        p.printf(" * @see <a href=\"%s\">ONIX Codelist %s in Reference Guide</a>\n", link, codelistNum);
        p.printf(" */\n");

        p.printf("public enum " + enumType.enumName + " implements OnixCodelist, CodeList%s\n", codelistNum);
        p.printf("{\n");

        Set<String> tokens = new HashSet<>();
        boolean first = true;
        for (OnixEnumValue ev : enumType.enumValues) {
            String token = enumNameOf(ev.name);
            while (!tokens.add(token)) {
                token += "_";
            }

            if (first) {
                first = false;
            } else {
                p.print(", //\n\n");
            }
            if (ev.description != null || ev.comment != null) {
                p.printf("   /**\n");
                if (ev.description != null) {
                    p.printf("    * %s\n", XML.escape(ev.description));
                }
                if (ev.comment != null && ev.description != null) {
                    p.printf("    * <p>\n");
                }
                if (ev.comment != null) {
                    p.printf("    * Jonix-Comment: %s\n", XML.escape(ev.comment));
                }
                p.printf("    */\n");
            }
            p.printf("   %s(\"%s\", \"%s\")", token, ev.value, ev.name);
        }
        p.print(";\n");

        p.print("\n");
        p.printf("   public final String code;\n");
        p.printf("   public final String description;\n");
        p.print("\n");
        p.printf("   %s(String code, String description)\n", enumType.enumName);
        p.printf("   {\n");
        p.printf("      this.code = code;\n");
        p.printf("      this.description = description;\n");
        p.printf("   }\n");

        p.print("\n");
        p.print("   @Override\n");
        p.print("   public String getCode()\n");
        p.print("   {\n");
        p.print("      return code;\n");
        p.print("   }\n");
        p.print("\n");
        p.print("   @Override\n");
        p.print("   public String getDescription()\n");
        p.print("   {\n");
        p.print("      return description;\n");
        p.print("   }\n");

        if (enumType.enumValues.size() < MIN_FOR_MAP) {
            p.print("\n");
            p.printf("   public static %s byCode(String code)\n", enumType.enumName);
            p.printf("   {\n");
            p.printf("      if (code == null || code.isEmpty()) {\n");
            p.printf("         return null;\n");
            p.printf("      }\n");
            p.printf("      for (%s e : values()) {\n", enumType.enumName);
            p.printf("         if (e.code.equals(code)) {\n");
            p.printf("            return e;\n");
            p.printf("         }\n");
            p.printf("      }\n");
            p.printf("      return null;\n");
            p.printf("   }\n");
        } else {
            p.print("\n");
            p.printf("   private static volatile Map<String, %s> map;\n", enumType.enumName);
            p.print("\n");
            p.printf("   private static Map<String, %s> map()\n", enumType.enumName);
            p.printf("   {\n");
            p.printf("      Map<String, %s> result = map;\n", enumType.enumName);
            p.printf("      if (result == null)\n");
            p.printf("      {\n");
            p.printf("         synchronized(%s.class)\n", enumType.enumName);
            p.printf("         {\n");
            p.printf("            result = map;\n");
            p.printf("            if (result == null)\n");
            p.printf("            {\n");
            p.printf("               result = new HashMap<>();\n");
            p.printf("               for (%s e : values()) {\n", enumType.enumName);
            p.printf("                  result.put(e.code, e);\n");
            p.printf("               }\n");
            p.printf("               map = result;\n");
            p.printf("            }\n");
            p.printf("         }\n");
            p.printf("      }\n");
            p.printf("      return result;\n");
            p.printf("   }\n");
            p.print("\n");
            p.printf("   public static %s byCode(String code)\n", enumType.enumName);
            p.printf("   {\n");
            p.printf("      if (code == null || code.isEmpty()) {\n");
            p.printf("         return null;\n");
            p.printf("      }\n");
            p.printf("      return map().get(code);\n");
            p.printf("   }\n");
        }

        p.print("}\n");
    }

    public String enumNameOf(String rawName) {
        return rawName.replaceAll("(.+?)\\)(.*)", "$1").trim().replaceAll("[^a-zA-Z0-9_]+", "_")
            .replaceAll("^([0-9].*)", "_$1");
    }

    public static void main(String[] args) {
        // TODO: turn into a test
        final OnixEnumGen aux = new OnixEnumGen(null, null, null);
        String s;

        s = "By (photographer)";
        LOGGER.info(s + " --> " + aux.enumNameOf(s));

        s = "Tagalog (Baybayin, Alibata)";
        LOGGER.info(s + " --> " + aux.enumNameOf(s));

        s = "16:10";
        LOGGER.info(s + " --> " + aux.enumNameOf(s));

        s = "Distinctive title (book); Cover title (serial); Title on item (serial content item or reviewed resource)";
        LOGGER.info(s + " --> " + aux.enumNameOf(s));
    }
}
