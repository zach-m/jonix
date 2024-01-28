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

package com.tectonica.jonix.util;

import com.tectonica.jonix.common.OnixProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JonixUtil {

    // TODO: test heavily
    private String productToString(OnixProduct product) {
        if (product instanceof com.tectonica.jonix.onix2.Product) {
            com.tectonica.jonix.onix2.Product p2 = (com.tectonica.jonix.onix2.Product) product;
            return Stream.concat(
                p2.titles().findAll().stream()
                    .map(title -> String.format("%s='%s'", title.titleType(), title.titleText())),
                p2.productIdentifiers().findAll().stream()
                    .map(pid -> String.format("%s=%s", pid.productIDType().value, pid.idValue().value))
            ).collect(Collectors.joining(", ", "[", "]"));
        } else if (product instanceof com.tectonica.jonix.onix3.Product) {
            com.tectonica.jonix.onix3.Product p3 = (com.tectonica.jonix.onix3.Product) product;
            return Stream.concat(
                p3.descriptiveDetail().titleDetails().stream().map(td -> String
                    .format("%s='%s'", td.titleType(), td.titleElements().first().map(te -> te.titleText().value))),
                p3.productIdentifiers().findAll().stream()
                    .map(pid -> String.format("%s=%s", pid.productIDType().value, pid.idValue().value))
            ).collect(Collectors.joining(", ", "[", "]"));
        } else {
            return product.getClass().getName();
        }
    }

    /**
     * simple auxiliary function to be statically imported into your code when calling lookup services in the various
     * onix classes (that take a set as an input parameter)
     */
    @SafeVarargs
    public static <T> Set<T> setOf(T... items) {
        return new HashSet<>(Arrays.asList(items));
    }

    public static String contributorDisplayName(String personName, String personNameKey, String personNameBeforeKey,
                                                String personNameInverted, String corporateName) {
        if (personName != null) {
            return personName;
        }

        if (personNameKey != null) {
            if (personNameBeforeKey != null) {
                return personNameBeforeKey + " " + personNameKey;
            }
            return personNameKey;
        }

        if (personNameBeforeKey != null) {
            return personNameBeforeKey;
        }

        if (personNameInverted != null) {
            return personNameInverted;
        }

        return corporateName;
    }

    private static final SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat yyyymm = new SimpleDateFormat("yyyyMM");
    private static final SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");

    public static Date parseYYYYMMDD(String s) {
        if (s == null) {
            return null;
        }
        try {
            switch (s.length()) {
                case 4:
                    return yyyy.parse(s);
                case 6:
                    return yyyymm.parse(s);
                case 8:
                    return yyyymmdd.parse(s);
                default:
                    return null; // date format is not in one of the supported lengths
            }
        } catch (ParseException e) {
            // throw new RuntimeException(e);
            return null; // date format was supposed to be parsable, but is probably corrupt
        }
    }
}
