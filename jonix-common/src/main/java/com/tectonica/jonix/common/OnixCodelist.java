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

package com.tectonica.jonix.common;

/**
 * Fundamental interface in {@link com.tectonica.jonix.common Jonix object model}, representing an ONIX Codelist
 */
public interface OnixCodelist {
    String getCode();

    String getDescription();

    default Pair getPair() {
        return new Pair(getCode(), getDescription());
    }

    class Pair {
        public final String code;
        public final String description;

        public Pair(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }
}
