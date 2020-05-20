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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.TitleTypes;

import java.io.Serializable;

/**
 * Contains the essential information included in ONIX2 &lt;Title&gt; / ONIX3 &lt;TitleDetail&gt;
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseTitle implements Serializable {
    public TitleTypes titleType;
    public String titleText;
    public String titleWithoutPrefix;
    public String subtitle;

    protected static String noBreaks(String s) {
        return (s == null || s.isEmpty()) ? s : s.replaceAll("[\\t\\n\\r]", " ").trim();
    }
}