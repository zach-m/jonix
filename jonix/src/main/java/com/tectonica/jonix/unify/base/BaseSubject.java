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

import java.io.Serializable;

/**
 * Contains the essential information included in ONIX &lt;Subject&gt;
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseSubject implements Serializable {
    public SubjectSchemeIdentifiers subjectSchemeIdentifier;
    public String subjectCode;
    public String subjectHeadingText;

    protected BaseSubject() {
    }

    protected BaseSubject(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode,
                          String subjectHeadingText) {
        this.subjectSchemeIdentifier = subjectSchemeIdentifier;
        this.subjectCode = subjectCode;
        this.subjectHeadingText = subjectHeadingText;
    }
}