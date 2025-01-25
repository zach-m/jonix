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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.unify.base.BaseContributor;

import java.util.HashSet;

/**
 * ONIX2 concrete implementation for {@link BaseContributor}
 *
 * @author Zach Melamed
 */
public class BaseContributor2 extends BaseContributor {
    private static final long serialVersionUID = 1L;

    public BaseContributor2(Contributor c) {
        extract(c, this);
    }

    public static void extract(Contributor c, BaseContributor dest) {
        dest.contributorRoles = c.contributorRoles().valuesInto(new HashSet<>());
        dest.sequenceNumber = c.sequenceNumber().value;
        dest.personName = c.personName().value;
        dest.personNameKey = c.keyNames().value;
        dest.personNameBeforeKey = c.namesBeforeKey().value;
        dest.personNameInverted = c.personNameInverted().value;
        dest.corporateName = c.corporateName().value;
        dest.biographicalNote = c.biographicalNote().value;
    }
}