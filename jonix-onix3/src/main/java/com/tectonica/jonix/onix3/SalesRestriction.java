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
 * <h1>Sales restriction composite</h1>
 * <p>
 * A group of data elements which together identify a non-territorial sales restriction which a publisher applies to a
 * product within a particular territory. Optional, and repeatable if more than a single restriction applies.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesRestriction&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesrestriction&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SalesRestriction&gt; from the schema author:
 *
 * Details of a non-geographical restriction on sales, applicable with the associated sales rights territory or market
 * &#9679; Deprecated P.21.11-21.18 at revision 3.0.2, in favour of using &lt;SalesRestriction within
 * &lt;SalesRights&gt; (P.21.5a) &#9679; Modified cardinality of &lt;SalesRestrictionNote&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * <li>&lt;{@link Market}&gt;</li>
 * <li>&lt;{@link SalesRights}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRestriction}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class SalesRestriction implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRestriction";
    public static final String shortname = "salesrestriction";

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
    public static final SalesRestriction EMPTY = new SalesRestriction();

    public SalesRestriction() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRestriction(org.w3c.dom.Element element) {
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
                case SalesRestrictionType.refname:
                case SalesRestrictionType.shortname:
                    salesRestrictionType = new SalesRestrictionType(e);
                    break;
                case StartDate.refname:
                case StartDate.shortname:
                    startDate = new StartDate(e);
                    break;
                case EndDate.refname:
                case EndDate.shortname:
                    endDate = new EndDate(e);
                    break;
                case SalesOutlet.refname:
                case SalesOutlet.shortname:
                    salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
                    break;
                case SalesRestrictionNote.refname:
                case SalesRestrictionNote.shortname:
                    salesRestrictionNotes = JPU.addToList(salesRestrictionNotes, new SalesRestrictionNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SalesRestriction&gt; or &lt;salesrestriction&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SalesRestriction> action) {
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

    private SalesRestrictionType salesRestrictionType = SalesRestrictionType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies a non-territorial sales restriction. Mandatory in each occurrence of the
     * &lt;SalesRestriction&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SalesRestrictionType salesRestrictionType() {
        _initialize();
        return salesRestrictionType;
    }

    private StartDate startDate = StartDate.EMPTY;

    /**
     * <p>
     * The date from which a sales restriction is effective. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public StartDate startDate() {
        _initialize();
        return startDate;
    }

    private EndDate endDate = EndDate.EMPTY;

    /**
     * <p>
     * The date until which a sales restriction is effective. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public EndDate endDate() {
        _initialize();
        return endDate;
    }

    private ListOfOnixComposite<SalesOutlet> salesOutlets = JPU.emptyListOfOnixComposite(SalesOutlet.class);

    /**
     * <p>
     * An optional group of data elements which together identify a sales outlet to which a restriction is linked. Each
     * occurrence of the composite must include a &lt;SalesOutletIdentifier&gt; composite or a &lt;SalesOutletName&gt;
     * or both. Repeatable in order to identify multiple sales outlets subject to the restriction.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SalesOutlet> salesOutlets() {
        _initialize();
        return salesOutlets;
    }

    private ListOfOnixElement<SalesRestrictionNote, String> salesRestrictionNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * A free text field describing an ‘unspecified’ restriction, or giving more explanation of a coded restriction
     * type. Optional, and repeatable if parallel text is provided in multiple languages. The <i>language</i> attribute
     * is optional for a single instance of &lt;SalesRestrictionNote&gt;, but must be included in each instance if
     * &lt;SalesRestrictionNote&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<SalesRestrictionNote, String> salesRestrictionNotes() {
        _initialize();
        return salesRestrictionNotes;
    }
}
