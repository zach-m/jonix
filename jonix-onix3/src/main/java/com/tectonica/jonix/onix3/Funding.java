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
 * <h1>Funding composite</h1>
 * <p>
 * An optional group of data elements which together identify a grant or award provided by the entity specified as a
 * funder in an occurrence of the &lt;Publisher&gt; composite, to subsidize research or publication. Repeatable when the
 * funder provides multiple grants or awards. Used only when &lt;PublishingRole&gt; indicates the role of a funder.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Funding&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;funding&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Funding&gt; from the schema author:
 *
 * Details of funding (eg of a grant, of sponsorship) for the publication or for the underlying research on which the
 * publication is based &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Publisher}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Publisher} ⯈ {@link Funding}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link Funding}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class Funding implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Funding";
    public static final String shortname = "funding";

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
    public static final Funding EMPTY = new Funding();

    public Funding() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Funding(org.w3c.dom.Element element) {
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
                case FundingIdentifier.refname:
                case FundingIdentifier.shortname:
                    fundingIdentifiers = JPU.addToList(fundingIdentifiers, new FundingIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Funding&gt; or &lt;funding&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Funding> action) {
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

    private ListOfOnixDataCompositeWithKey<FundingIdentifier, JonixFundingIdentifier,
        GrantIdentifierTypes> fundingIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(FundingIdentifier.class);

    /**
     * <p>
     * A group of data elements which together identify a particular grant or award. At least one
     * &lt;FundingIdentifier&gt; composite must occur in each instance of the &lt;Funding&gt; composite. Repeatable when
     * the grant or award has multiple identifiers.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<FundingIdentifier, JonixFundingIdentifier, GrantIdentifierTypes>
        fundingIdentifiers() {
        _initialize();
        return fundingIdentifiers;
    }
}
