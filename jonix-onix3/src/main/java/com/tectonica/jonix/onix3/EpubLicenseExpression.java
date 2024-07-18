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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEpubLicenseExpression;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Digital product license expression composite</h1>
 * <p>
 * An optional composite that carries details of a link to an expression of the license terms, which may be in
 * human-readable or machine-readable form. Repeatable when there is more than one expression of the license.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubLicenseExpression&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;epublicenseexpression&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EpubLicenseExpression&gt; from the schema author:
 *
 * Details of a particular expression of an end user license &#9679; Added at revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EpubLicense}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicense} ⯈ {@link EpubLicenseExpression}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link EpubLicense} ⯈ {@link EpubLicenseExpression}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link EpubLicense} ⯈
 * {@link EpubLicenseExpression}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class EpubLicenseExpression
    implements OnixDataCompositeWithKey<JonixEpubLicenseExpression, LicenseExpressionTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpression";
    public static final String shortname = "epublicenseexpression";

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
    public static final EpubLicenseExpression EMPTY = new EpubLicenseExpression();

    public EpubLicenseExpression() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseExpression(org.w3c.dom.Element element) {
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
                case EpubLicenseExpressionType.refname:
                case EpubLicenseExpressionType.shortname:
                    epubLicenseExpressionType = new EpubLicenseExpressionType(e);
                    break;
                case EpubLicenseExpressionLink.refname:
                case EpubLicenseExpressionLink.shortname:
                    epubLicenseExpressionLink = new EpubLicenseExpressionLink(e);
                    break;
                case EpubLicenseExpressionTypeName.refname:
                case EpubLicenseExpressionTypeName.shortname:
                    epubLicenseExpressionTypeName = new EpubLicenseExpressionTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EpubLicenseExpression&gt; or &lt;epublicenseexpression&gt;) is explicitly provided
     *         in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseExpression> action) {
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

    private EpubLicenseExpressionType epubLicenseExpressionType = EpubLicenseExpressionType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the nature or format of the license expression specified in the
     * &lt;EpubLicenseExpressionLink&gt; element. Mandatory within the &lt;EpubLicenseExpression&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public EpubLicenseExpressionType epubLicenseExpressionType() {
        _initialize();
        return epubLicenseExpressionType;
    }

    private EpubLicenseExpressionLink epubLicenseExpressionLink = EpubLicenseExpressionLink.EMPTY;

    /**
     * <p>
     * The URI for the license expression. Mandatory in each instance of the &lt;EpubLicenseExpression&gt; composite,
     * and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public EpubLicenseExpressionLink epubLicenseExpressionLink() {
        _initialize();
        return epubLicenseExpressionLink;
    }

    private EpubLicenseExpressionTypeName epubLicenseExpressionTypeName = EpubLicenseExpressionTypeName.EMPTY;

    /**
     * <p>
     * A short free-text name for a license expression type, when the code in &lt;EpubLicenseExpressionType&gt; provides
     * insufficient detail – for example when a machine-readable license is expressed using a particular proprietary
     * encoding scheme. Optional and non-repeating, and must be included when (and only when) the
     * &lt;EpubLicenseExpressionType&gt; element indicates the expression is encoded in a proprietary way.
     * </p>
     * JONIX adds: this field is optional
     */
    public EpubLicenseExpressionTypeName epubLicenseExpressionTypeName() {
        _initialize();
        return epubLicenseExpressionTypeName;
    }

    @Override
    public JonixEpubLicenseExpression asStruct() {
        _initialize();
        JonixEpubLicenseExpression struct = new JonixEpubLicenseExpression();
        struct.epubLicenseExpressionType = epubLicenseExpressionType.value;
        struct.epubLicenseExpressionTypeName = epubLicenseExpressionTypeName.value;
        struct.epubLicenseExpressionLink = epubLicenseExpressionLink.value;
        return struct;
    }

    @Override
    public LicenseExpressionTypes structKey() {
        return epubLicenseExpressionType().value;
    }
}
