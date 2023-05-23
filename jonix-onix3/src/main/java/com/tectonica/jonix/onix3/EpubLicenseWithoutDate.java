/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link EpubLicenseWithoutDate}</li>
 * </ul>
 */
public class EpubLicenseWithoutDate implements OnixSuperComposite, Serializable {
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
    public static final EpubLicenseWithoutDate EMPTY = new EpubLicenseWithoutDate();

    public EpubLicenseWithoutDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseWithoutDate(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;EpubLicenseWithoutDate&gt; or &lt;epublicense&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseWithoutDate> action) {
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
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<EpubLicenseName, String> epubLicenseNames() {
        _initialize();
        return epubLicenseNames;
    }

    private ListOfOnixDataCompositeWithKey<EpubLicenseExpression, JonixEpubLicenseExpression,
        LicenseExpressionTypes> epubLicenseExpressions =
            JPU.emptyListOfOnixDataCompositeWithKey(EpubLicenseExpression.class);

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EpubLicenseExpression, JonixEpubLicenseExpression, LicenseExpressionTypes>
        epubLicenseExpressions() {
        _initialize();
        return epubLicenseExpressions;
    }
}
