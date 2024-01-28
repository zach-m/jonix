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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 161 (Resource form)
 */
interface CodeList161 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 161</b>
 * <p>
 * Description: Resource form
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_64.html#codelist161">ONIX
 *      Codelist 161 in Reference Guide</a>
 */
public enum ResourceForms implements OnixCodelist, CodeList161 {
    /**
     * A resource that may be accessed by a hyperlink. The current host (eg the ONIX sender, who may be the publisher)
     * will provide ongoing hosting services for the resource for the active life of the product (or at least until the
     * Until Date specified in &lt;ContentDate&gt;). The ONIX recipient may embed the URL in a consumer facing-website
     * (eg as the src attribute in an &lt;img&gt; link), and need not host an independent copy of the resource
     */
    Linkable_resource("01", "Linkable resource"),

    /**
     * A file that may be downloaded on demand for third-party use. The ONIX sender will host a copy of the resource
     * until the specified Until Date, but only for the ONIX recipient's direct use. The ONIX recipient should download
     * a copy of the resource, and must host an independent copy of the resource if it is used on a consumer-facing
     * website. Special attention should be paid to the 'Last Updated' &lt;ContentDate&gt; to ensure the independent
     * copy of the resource is kept up to date
     */
    Downloadable_file("02", "Downloadable file"),

    /**
     * An application which is supplied in a form which can be embedded into a third-party webpage. As type 02, except
     * the resource contains active content such as JavaScript, Flash, etc
     */
    Embeddable_application("03", "Embeddable application");

    public final String code;
    public final String description;

    ResourceForms(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static ResourceForms byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ResourceForms e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<ResourceForms> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
