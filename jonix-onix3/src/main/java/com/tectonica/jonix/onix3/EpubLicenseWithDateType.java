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
 * Technical notes about &lt;EpubLicenseWithDateType&gt; from the schema author:
 *
 * Details of an end user license agreement for a digital product &#9679; Extends complexType &lt;EpubLicenseType&gt;
 * &#9679; Added &lt;EpubLicenseDate&gt; at release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link TextContent}&gt;</li>
 * <li>&lt;{@link ResourceVersion}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType}</li>
 * </ul>
 */
public class EpubLicenseWithDateType implements OnixSuperComposite, Serializable {
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
    public static final EpubLicenseWithDateType EMPTY = new EpubLicenseWithDateType();

    public EpubLicenseWithDateType() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseWithDateType(org.w3c.dom.Element element) {
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
                case EpubLicenseDate.refname:
                case EpubLicenseDate.shortname:
                    epubLicenseDates = JPU.addToList(epubLicenseDates, new EpubLicenseDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EpubLicenseWithDateType&gt; or &lt;epublicense&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseWithDateType> action) {
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
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EpubLicenseExpression, JonixEpubLicenseExpression, LicenseExpressionTypes>
        epubLicenseExpressions() {
        _initialize();
        return epubLicenseExpressions;
    }

    private ListOfOnixDataCompositeWithKey<EpubLicenseDate, JonixEpubLicenseDate,
        EpublicationLicenseDateRoles> epubLicenseDates = JPU.emptyListOfOnixDataCompositeWithKey(EpubLicenseDate.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EpubLicenseDate, JonixEpubLicenseDate, EpublicationLicenseDateRoles>
        epubLicenseDates() {
        _initialize();
        return epubLicenseDates;
    }
}
