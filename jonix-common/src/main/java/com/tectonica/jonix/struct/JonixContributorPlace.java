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

package com.tectonica.jonix.struct;

import com.tectonica.jonix.JonixStruct;
import com.tectonica.jonix.codelist.ContributorPlaceRelators;
import com.tectonica.jonix.codelist.Countrys;
import com.tectonica.jonix.codelist.Regions;

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixContributorPlace implements JonixStruct, Serializable {
    public static JonixContributorPlace EMPTY = new JonixContributorPlace();

    public ContributorPlaceRelators contributorPlaceRelator;

    public Countrys countryCode;

    public Regions regionCode;

    /**
     * Raw Format: Variable length text, suggested maximum length 100 characters <p> (type: dt.NonEmptyString)
     */
    public List<String> locationNames;
}
