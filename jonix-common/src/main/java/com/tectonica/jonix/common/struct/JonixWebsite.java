/*
 * Copyright (C) 2012-2022 Zach Melamed
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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.WebsiteRoles;

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;Website></code> and Onix3
 * <code>&lt;Website></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixWebsite implements JonixStruct, Serializable {
    public static final JonixWebsite EMPTY = new JonixWebsite();

    /**
     * Raw Format: Variable length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML or XML with ONIX text fields
     * <p>
     * (type: XHTML)
     */
    public List<String> websiteDescriptions;

    /**
     * Raw Format: Uniform Resource Locator, expressed in full URI syntax in accordance with W3C standards, suggested
     * maximum length 300 characters. Note that non-ASCII characters, spaces and a handful of other special characters
     * should be 'URL-encoded'
     * <p>
     * (type: dt.NonEmptyURI)
     */
    public List<String> websiteLinks;

    public WebsiteRoles websiteRole;
}
