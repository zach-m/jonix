/*
 * Copyright (C) 2012-2026 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixImprintIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Imprint or brand composite</h1>
 * <p>
 * An optional group of data elements which together identify an imprint or brand under which the product is placed on
 * the market. The composite must carry at least one of a name identifier, a name or an inverted name, and is repeatable
 * to specify multiple imprints or brands.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Imprint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;imprint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Imprint&gt; from the schema author:
 *
 * Details of the publisher's imprint or branding under which the product is marketed &#9679; Added
 * &lt;ImprintNameInverted&gt; at revision 3.1.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Imprint}</li>
 * </ul>
 */
public class Imprint implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Imprint";
    public static final String shortname = "imprint";

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
    public static final Imprint EMPTY = new Imprint();

    public Imprint() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Imprint(org.w3c.dom.Element element) {
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
                case ImprintIdentifier.refname:
                case ImprintIdentifier.shortname:
                    imprintIdentifiers = JPU.addToList(imprintIdentifiers, new ImprintIdentifier(e));
                    break;
                case ImprintName.refname:
                case ImprintName.shortname:
                    imprintName = new ImprintName(e);
                    break;
                case ImprintNameInverted.refname:
                case ImprintNameInverted.shortname:
                    imprintNameInverted = new ImprintNameInverted(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Imprint&gt; or &lt;imprint&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Imprint> action) {
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

    private ListOfOnixDataCompositeWithKey<ImprintIdentifier, JonixImprintIdentifier,
        NameIdentifierTypes> imprintIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ImprintIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identifier of an imprint name. Optional, but mandatory if the
     * &lt;Imprint&gt; composite carries neither an &lt;ImprintName&gt; nor an &lt;ImprintNameInverted&gt;. The
     * composite is repeatable in order to specify multiple identifiers for the same imprint or brand.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ImprintIdentifier, JonixImprintIdentifier, NameIdentifierTypes>
        imprintIdentifiers() {
        _initialize();
        return imprintIdentifiers;
    }

    private ImprintName imprintName = ImprintName.EMPTY;

    /**
     * <p>
     * The name of an imprint or brand under which the product is issued, presented in normal order as it appears on the
     * product. Mandatory if there is neither an imprint identifier nor an &lt;ImprintNameInverted&gt; in an occurrence
     * of the &lt;Imprint&gt; composite, and expected but optional if an imprint identifier or inverted imprint name is
     * included. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ImprintName imprintName() {
        _initialize();
        return imprintName;
    }

    private ImprintNameInverted imprintNameInverted = ImprintNameInverted.EMPTY;

    /**
     * <p>
     * The name of an imprint or brand under which the product is issued, presented in inverted order, with the element
     * used for alphabetical sorting placed first. Mandatory if there is neither an imprint identifier nor an
     * &lt;ImprintName&gt; but otherwise optional. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ImprintNameInverted imprintNameInverted() {
        _initialize();
        return imprintNameInverted;
    }
}
