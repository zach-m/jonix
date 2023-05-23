/*
 * Copyright (C) 2012-2023 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 159 (Resource mode)
 */
interface CodeList159 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 159</b>
 * <p>
 * Description: Resource mode
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist159">ONIX
 *      Codelist 159 in Reference Guide</a>
 */
public enum ResourceModes implements OnixCodelist, CodeList159 {
    /**
     * An executable together with data on which it operates
     */
    Application("01", "Application"),

    /**
     * A sound recording
     */
    Audio("02", "Audio"),

    /**
     * A still image
     */
    Image("03", "Image"),

    /**
     * Readable text, with or without associated images etc
     */
    Text("04", "Text"),

    /**
     * Moving images, with or without accompanying sound
     */
    Video("05", "Video"),

    /**
     * A website or other supporting resource delivering content in a variety of modes
     */
    Multi_mode("06", "Multi-mode");

    public final String code;
    public final String description;

    ResourceModes(String code, String description) {
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

    public static ResourceModes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ResourceModes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<ResourceModes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
