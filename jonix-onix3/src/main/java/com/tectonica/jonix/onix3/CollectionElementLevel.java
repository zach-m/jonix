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

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Collection title element level</h1>
 * <p>
 * An ONIX code indicating the level of the collection title element (collection level or sub-collection level) to which
 * the identifier in the &lt;IDValue&gt; element is assigned. Optional in each occurrence of the
 * &lt;CollectionIdentifier&gt; composite, and non-repeating.
 * </p>
 * <p>
 * When used, the specified level must match the level of a &lt;TitleElement&gt; within the same Collection composite,
 * or –&nbsp;is there is no &lt;TitleDetail&gt; within the Collection composite&nbsp;– the level of a
 * &lt;TitleElement&gt; within Group&nbsp;P.6.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length text, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 149 Note that codes 01, 04 cannot be used.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CollectionElementLevel&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x586&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x586&gt;03&lt;/x586&gt;</tt> (Identifier is assigned to the sub-collection)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CollectionElementLevel&gt; from the schema author:
 *
 * Hierarchical level of collection title element to which an identifier applies &#9679; Added at release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CollectionIdentifier}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link CollectionIdentifier} ⯈
 * {@link CollectionElementLevel}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class CollectionElementLevel implements OnixElement<TitleElementLevels>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CollectionElementLevel";
    public static final String shortname = "x586";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public TitleElementLevels value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public TitleElementLevels __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CollectionElementLevel EMPTY = new CollectionElementLevel();

    public CollectionElementLevel() {
        exists = false;
    }

    public CollectionElementLevel(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = TitleElementLevels.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;CollectionElementLevel&gt; or &lt;x586&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CollectionElementLevel> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
