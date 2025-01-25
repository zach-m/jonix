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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEpubLicenseExpression;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Digital product license composite</h1>
 * <p>
 * An optional and non-repeatable composite carrying the name or title of the license governing use of the product, and
 * a link to the license terms in eye-readable or machine-readable form.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubLicense&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;epublicense&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EpubLicense&gt; from the schema author:
 *
 * Details of an end user license agreement for a digital product &#9679; Added at revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicense}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link EpubLicense}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link EpubLicense}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class EpubLicense implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicense";
    public static final String shortname = "epublicense";

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
    public static final EpubLicense EMPTY = new EpubLicense();

    public EpubLicense() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicense(org.w3c.dom.Element element) {
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
                case EpubLicenseName.refname:
                case EpubLicenseName.shortname:
                    epubLicenseNames = JPU.addToList(epubLicenseNames, new EpubLicenseName(e));
                    break;
                case EpubLicenseExpression.refname:
                case EpubLicenseExpression.shortname:
                    epubLicenseExpressions = JPU.addToList(epubLicenseExpressions, new EpubLicenseExpression(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EpubLicense&gt; or &lt;epublicense&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicense> action) {
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

    private ListOfOnixElement<EpubLicenseName, String> epubLicenseNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name or title of the license. Mandatory in any &lt;EpubLicense&gt; composite, and repeatable to provide the
     * license name in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;EpubLicenseName&gt;, but must be included in each instance if &lt;EpubLicenseName&gt; is repeated.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<EpubLicenseName, String> epubLicenseNames() {
        _initialize();
        return epubLicenseNames;
    }

    private ListOfOnixDataCompositeWithKey<EpubLicenseExpression, JonixEpubLicenseExpression,
        LicenseExpressionTypes> epubLicenseExpressions =
            JPU.emptyListOfOnixDataCompositeWithKey(EpubLicenseExpression.class);

    /**
     * <p>
     * An optional composite that carries details of a link to an expression of the license terms, which may be in
     * human-readable or machine-readable form. Repeatable when there is more than one expression of the license.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EpubLicenseExpression, JonixEpubLicenseExpression, LicenseExpressionTypes>
        epubLicenseExpressions() {
        _initialize();
        return epubLicenseExpressions;
    }
}
