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
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAffiliationIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Affiliation identifier composite</h1>
 * <p>
 * A group of data elements which together define an identifier for an organization to which the contributor to the
 * product was affiliated <em>at the time of its creation</em>, and – if the &lt;ProfessionalPosition&gt; element is
 * also present – where the contributor held that position. Optional, and repeatable to specify organization identifiers
 * of different types for the same organization.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AffiliationIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;affiliationidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;AffiliationIdentifier&gt; from the schema author:
 *
 * An identifier which uniquely identifies the affiliate organization &#9679; Added at release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProfessionalAffiliation}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation} ⯈
 * {@link AffiliationIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link ProfessionalAffiliation} ⯈
 * {@link AffiliationIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class AffiliationIdentifier
    implements OnixDataCompositeWithKey<JonixAffiliationIdentifier, NameIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AffiliationIdentifier";
    public static final String shortname = "affiliationidentifier";

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
    public static final AffiliationIdentifier EMPTY = new AffiliationIdentifier();

    public AffiliationIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AffiliationIdentifier(org.w3c.dom.Element element) {
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
                case AffiliationIDType.refname:
                case AffiliationIDType.shortname:
                    affiliationIDType = new AffiliationIDType(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;AffiliationIdentifier&gt; or &lt;affiliationidentifier&gt;) is explicitly provided
     *         in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AffiliationIdentifier> action) {
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

    private AffiliationIDType affiliationIDType = AffiliationIDType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;AffiliationIdentifier&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public AffiliationIDType affiliationIDType() {
        _initialize();
        return affiliationIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in the &lt;AffiliationIDType&gt; element. Mandatory in each
     * occurrence of the composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
     * there is no individual ID type code). Must be included when, and only when, the code in the
     * &lt;AffiliationIDType&gt; element indicates a proprietary scheme. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixAffiliationIdentifier asStruct() {
        _initialize();
        JonixAffiliationIdentifier struct = new JonixAffiliationIdentifier();
        struct.affiliationIDType = affiliationIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameIdentifierTypes structKey() {
        return affiliationIDType().value;
    }
}
