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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEpubUsageLimit;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Usage constraint composite (digital products)</h1>
 * <p>
 * An optional group of data elements which together describe a usage constraint on a digital product (or the absence of
 * such a constraint), whether enforced by DRM technical protection, inherent in the platform used, or specified by
 * license agreement. Repeatable in order to describe multiple constraints on usage.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubUsageConstraint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;epubusageconstraint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubUsageConstraint}</li>
 * </ul>
 */
public class EpubUsageConstraint implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubUsageConstraint";
    public static final String shortname = "epubusageconstraint";

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
    public static final EpubUsageConstraint EMPTY = new EpubUsageConstraint();

    public EpubUsageConstraint() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubUsageConstraint(org.w3c.dom.Element element) {
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
                case EpubUsageType.refname:
                case EpubUsageType.shortname:
                    epubUsageType = new EpubUsageType(e);
                    break;
                case EpubUsageStatus.refname:
                case EpubUsageStatus.shortname:
                    epubUsageStatus = new EpubUsageStatus(e);
                    break;
                case EpubUsageLimit.refname:
                case EpubUsageLimit.shortname:
                    epubUsageLimits = JPU.addToList(epubUsageLimits, new EpubUsageLimit(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EpubUsageConstraint&gt; or &lt;epubusageconstraint&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubUsageConstraint> action) {
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

    private EpubUsageType epubUsageType = EpubUsageType.EMPTY;

    /**
     * <p>
     * An ONIX code specifying a usage of a digital product. Mandatory in each occurrence of the
     * &lt;EpubUsageConstraint&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public EpubUsageType epubUsageType() {
        _initialize();
        return epubUsageType;
    }

    private EpubUsageStatus epubUsageStatus = EpubUsageStatus.EMPTY;

    /**
     * <p>
     * An ONIX code specifying the status of a usage of a digital product, <i>eg</i> permitted without limit, permitted
     * with limit, prohibited. Mandatory in each occurrence of the &lt;EpubUsageConstraint&gt; composite, and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public EpubUsageStatus epubUsageStatus() {
        _initialize();
        return epubUsageStatus;
    }

    private ListOfOnixDataComposite<EpubUsageLimit, JonixEpubUsageLimit> epubUsageLimits =
        JPU.emptyListOfOnixDataComposite(EpubUsageLimit.class);

    /**
     * <p>
     * An optional group of data elements which together specify a quantitative limit on a particular type of usage of a
     * digital product. Repeatable in order to specify two or more limits on the usage type.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<EpubUsageLimit, JonixEpubUsageLimit> epubUsageLimits() {
        _initialize();
        return epubUsageLimits;
    }
}
