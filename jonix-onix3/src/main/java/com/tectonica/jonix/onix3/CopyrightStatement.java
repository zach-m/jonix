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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright statement composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together represent a copyright or neighbouring right
 * statement for the product. At least one &lt;CopyrightYear&gt; or one instance of the &lt;CopyrightOwner&gt; composite
 * must be sent within an instance of the composite, but it is recommended that all elements in the composite are
 * explicitly populated. The Copyright statement may be repeated to provide a full structured rights statement listing
 * year(s) and rights holder(s).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CopyrightStatement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;copyrightstatement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CopyrightStatement&gt; from the schema author:
 *
 * Details of a copyright or neighbouring rights statement &#9679; Modified cardinality of &lt;CopyrightYear&gt; at
 * revision 3.0.7 &#9679; Added &lt;CopyrightType&gt; at revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link CopyrightStatement}</li>
 * </ul>
 */
public class CopyrightStatement implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightStatement";
    public static final String shortname = "copyrightstatement";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final CopyrightStatement EMPTY = new CopyrightStatement();

    public CopyrightStatement() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CopyrightStatement(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case CopyrightYear.refname:
                case CopyrightYear.shortname:
                    copyrightYears = JPU.addToList(copyrightYears, new CopyrightYear(e));
                    break;
                case CopyrightType.refname:
                case CopyrightType.shortname:
                    copyrightType = new CopyrightType(e);
                    break;
                case CopyrightOwner.refname:
                case CopyrightOwner.shortname:
                    copyrightOwners = JPU.addToList(copyrightOwners, new CopyrightOwner(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CopyrightStatement&gt; or &lt;copyrightstatement&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CopyrightStatement> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixElement<CopyrightYear, String> copyrightYears = ListOfOnixElement.empty();

    /**
     * <p>
     * The copyright year as it appears in a copyright statement on the product. Optional in each occurrence of the
     * &lt;CopyrightStatement&gt; composite but may be omitted only if &lt;CopyrightOwner&gt; is present, and repeatable
     * if several years or periods are listed.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<CopyrightYear, String> copyrightYears() {
        _initialize();
        return copyrightYears;
    }

    private CopyrightType copyrightType = CopyrightType.EMPTY;

    /**
     * <p>
     * An optional ONIX code indicating the type of right covered by the statement, typically a copyright or
     * neighbouring right. If omitted, the default is that the statement represents a copyright.
     * </p>
     * JONIX adds: this field is optional
     */
    public CopyrightType copyrightType() {
        _initialize();
        return copyrightType;
    }

    private ListOfOnixComposite<CopyrightOwner> copyrightOwners = JPU.emptyListOfOnixComposite(CopyrightOwner.class);

    /**
     * <p>
     * A repeatable group of data elements which together name a copyright owner. Optional, but may be omitted only if
     * &lt;CopyrightYear&gt; is present. Each occurrence of the &lt;CopyrightOwner&gt; composite must carry a single
     * name (personal or corporate), or an identifier, or both.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<CopyrightOwner> copyrightOwners() {
        _initialize();
        return copyrightOwners;
    }
}
