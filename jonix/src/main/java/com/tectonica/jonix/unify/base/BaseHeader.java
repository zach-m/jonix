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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.unify.UnifiedHeader;

import java.io.Serializable;
import java.util.List;

/**
 * Contains the essential information included in ONIX &lt;Header&gt;.
 * <p>
 * Provided as part of the 'base' suite of classes whose goal is to extract the most important information from an ONIX
 * source (be it ONIX2 or ONIX3) and make it available for other various uses (print in a tabular format, etc.). The
 * classes of the 'basic' bridge the gap between ONIX versions, and provide a unified view of the content, allowing the
 * user to write a version-agnostic code.
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseHeader implements UnifiedHeader, Serializable {
    public transient OnixHeader rawHeader;

    public String fromCompany;
    public String fromPerson;
    public String fromEmail;
    public List<String> toCompanies;
    public String sentDate;

    @Override
    public OnixHeader getRawHeader() {
        return rawHeader;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FromCompany: ").append(fromCompany).append("\n");
        sb.append("FromPerson:  ").append(fromPerson).append("\n");
        sb.append("FromEmail:   ").append(fromEmail).append("\n");
        sb.append("ToCompany:   ").append(toCompanies).append("\n");
        sb.append("SentDate:    ").append(sentDate);
        return sb.toString();
    }
}
