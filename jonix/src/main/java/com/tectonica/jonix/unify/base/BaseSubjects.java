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

import com.tectonica.jonix.common.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.unify.base.util.LazyMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;Subject&gt; that may exist in an ONIX Product
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseSubjects extends LazyMap<SubjectSchemeIdentifiers, List<BaseSubject>> {
    protected void addKV(Map<SubjectSchemeIdentifiers, List<BaseSubject>> map, BaseSubject subject,
                         boolean insertFirst) {
        List<BaseSubject> items = map.get(subject.subjectSchemeIdentifier);
        if (items == null) {
            map.put(subject.subjectSchemeIdentifier, items = new ArrayList<>());
        }
        if (insertFirst) {
            items.add(0, subject);
        } else {
            items.add(subject);
        }
    }

    public List<BaseSubject> findSubjects(SubjectSchemeIdentifiers requestedScheme) {
        List<BaseSubject> items = get(requestedScheme);
        if (items == null) {
            return Collections.emptyList();
        }
        return items;
    }
}
