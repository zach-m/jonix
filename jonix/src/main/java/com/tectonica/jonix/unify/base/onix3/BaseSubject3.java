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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.onix3.SubjectHeadingText;
import com.tectonica.jonix.unify.base.BaseSubject;

/**
 * ONIX3 concrete implementation for {@link BaseSubject}
 *
 * @author Zach Melamed
 */
public class BaseSubject3 extends BaseSubject {
    private static final long serialVersionUID = 1L;

    public BaseSubject3(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode,
                        String subjectHeadingText) {
        super(subjectSchemeIdentifier, subjectCode, subjectHeadingText);
    }

    public BaseSubject3(Subject s) {
        extract(s, this);
    }

    public static void extract(Subject s, BaseSubject dest) {
        dest.subjectSchemeIdentifier = s.subjectSchemeIdentifier().value;
        dest.subjectCode = s.subjectCode().value;
        dest.subjectHeadingText = pickSubjectHeadingText(s);
    }

    private static String pickSubjectHeadingText(Subject subject) {
        if (!subject.subjectHeadingTexts().isEmpty()) {
            for (SubjectHeadingText sht : subject.subjectHeadingTexts()) {
                if (sht.language == null || sht.language == Languages.English) {
                    return sht.value;
                }
            }
            return subject.subjectHeadingTexts().get(0).value; // return whatever language we have
        }
        return null;
    }
}