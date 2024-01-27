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

package com.tectonica.jonix.common;

/**
 * Fundamental interface in {@link com.tectonica.jonix.common Jonix object model}, merely marking a Jonix
 * <code>Struct</code>.
 * <p>
 * The idea of a <code>Struct</code> is to represent an ONIX Data Composite (i.e. an ONIX item that contains several
 * fields, but no nested ONIX items) as a simple Java object. One of the biggest advantages of such <code>Struct</code>
 * is that it's ONIX-version agnostic (i.e. Onix2 and Onix3 create the exact same class) - which allows easy development
 * of cross-version processing. Another important feature is that in many cases one of the fields in the
 * <code>Struct</code> acts as a <b>key</b> (i.e. mandatory, unique, and searchable-by). This useful trait is captured
 * by {@link JonixKeyedStruct}.
 * <p>
 * To obtain <code>Struct</code> from any Data Composite invoke {@link OnixComposite.OnixDataComposite#asStruct()}.
 */
public interface JonixStruct {
}
