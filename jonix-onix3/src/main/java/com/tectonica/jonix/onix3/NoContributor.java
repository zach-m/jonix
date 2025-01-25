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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixFlag;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>“No authorship” indicator</h1>
 * <p>
 * An empty element that provides a positive indication that a collection has no stated authorship. Optional and
 * non-repeating. Must only be sent in a record that has no &lt;Contributor&gt; data in Group P.5.
 * </p>
 * <p>
 * <strong>The &lt;NoContributor/&gt; element is provided here for use only by those ONIX communities whose national
 * practice requires contributors to the collection to be identified at collection level.</strong> It should not be sent
 * in a context where collection contributors are normally identified in Group&nbsp;P.6.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NoContributor&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;n339&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;NoContributor/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;NoContributor&gt; from the schema author:
 *
 * Positive indication that there are no listed contributors to the product &#9679; XML empty element - must not contain
 * data
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * <li>&lt;{@link Collection}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NoContributor}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NoContributor}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link NoContributor}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link NoContributor}</li>
 * </ul>
 *
 * @since Onix-3.04
 */
public class NoContributor implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NoContributor";
    public static final String shortname = "n339";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final NoContributor EMPTY = new NoContributor();

    public NoContributor() {
        exists = false;
    }

    public NoContributor(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;NoContributor&gt; or &lt;n339&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NoContributor> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
