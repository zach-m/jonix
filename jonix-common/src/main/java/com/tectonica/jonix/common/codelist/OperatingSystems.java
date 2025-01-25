/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 176 (Operating system)
 */
interface CodeList176 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 176</b>
 * <p>
 * Description: Operating system
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist176">ONIX
 *      Codelist 176 in Reference Guide</a>
 */
public enum OperatingSystems implements OnixCodelist, CodeList176 {
    /**
     * An Open Source mobile device operating system originally developed by Google and supported by the Open Handset
     * Alliance
     */
    Android("01", "Android"),

    /**
     * A proprietary operating system supplied by Research In Motion for its BlackBerry handheld devices
     */
    BlackBerry_OS("02", "BlackBerry OS"),

    /**
     * A proprietary operating system based on Mac OS X supplied by Apple for its iPhone, iPad and iPod Touch handheld
     * devices
     */
    iOS("03", "iOS"),

    /**
     * An operating system based on the Linux kernel
     */
    Linux("04", "Linux"),

    /**
     * Proprietary 'Classic' operating system supplied by Apple on Macintosh computers up to 2002. Deprecated - use code
     * 13 for all Mac OS versions
     */
    Mac_OS("05", "Mac OS"),

    /**
     * Proprietary 'OS X' operating system supplied by Apple on Macintosh computers from 2001/2002. Deprecated - use
     * code 13 for all Mac OS versions
     */
    Mac_OS_X("06", "Mac OS X"),

    /**
     * A proprietary operating system (AKA Garnet OS) originally developed for handheld devices
     */
    Palm_OS("07", "Palm OS"),

    /**
     * A proprietry Linux-based operating system for handheld devices, originally developed by Palm (now owned by LG)
     */
    webOS("08", "webOS"),

    /**
     * An operating system for hand-held devices, originally developed as a proprietary system, but planned to become
     * wholly Open Source by 2010
     */
    Symbian("09", "Symbian"),

    /**
     * A proprietary operating system supplied by Microsoft
     */
    Windows("10", "Windows"),

    /**
     * A proprietary operating system (AKA Windows Embedded Compact, WinCE) supplied by Microsoft for small-scale
     * devices
     */
    Windows_CE("11", "Windows CE"),

    /**
     * A proprietary operating system supplied by Microsoft for mobile devices
     */
    Windows_Mobile("12", "Windows Mobile"),

    /**
     * A proprietary operating system supplied by Apple on Macintosh computers
     */
    Mac_OS_("13", "Mac OS"),

    /**
     * A proprietary operating system supplied by Microsoft for mobile devices, successor to Windows Mobile
     */
    Windows_Phone_7("14", "Windows Phone 7");

    public final String code;
    public final String description;

    OperatingSystems(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, OperatingSystems> map;

    private static Map<String, OperatingSystems> map() {
        Map<String, OperatingSystems> result = map;
        if (result == null) {
            synchronized (OperatingSystems.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (OperatingSystems e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static OperatingSystems byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<OperatingSystems> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
