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

package com.tectonica.jonix.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JonixUtil {

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

    private static SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");

    public static Date parseYYYYMMDD(String s) {
        try {
            return (s == null) ? null : yyyymmdd.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
