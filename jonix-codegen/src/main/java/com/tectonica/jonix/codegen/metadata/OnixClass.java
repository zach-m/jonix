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

package com.tectonica.jonix.codegen.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class OnixClass implements Comparable<OnixClass> {
    public String name;
    public List<OnixConst> consts;
    public List<OnixAttribute> attributes;
    public OnixDoc onixDoc;

    @Override
    public int compareTo(OnixClass other) {
        return name.compareTo(other.name);
    }

    public void add(OnixConst onixConst) {
        if (consts == null) {
            consts = new ArrayList<>();
        }
        consts.add(onixConst);
    }

    public void add(OnixAttribute onixAttribute) {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        attributes.add(onixAttribute);
    }

    public void sortInternally() {
        if (attributes != null) {
            Collections.sort(attributes);
        }
        if (consts != null) {
            Collections.sort(consts);
        }
    }
}