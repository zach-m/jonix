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
 * <h1>Publishing date composite</h1>
 * <p>
 * A group of data elements which together specify a date associated with the publishing of the product. Optional, but
 * where known, at least a date of publication <em>must</em> be specified <em>either</em> here (as a ‘global’ pub date)
 * <em>or</em> in &lt;MarketPublishingDetail&gt; (P.25). Other dates related to the publishing of a product can be sent
 * in further repeats of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublishingDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;publishingdate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PublishingDate&gt; from the schema author:
 *
 * Date of the specified role relating to the lifecycle of the product, eg publication date, out-of-print date &#9679;
 * Removed &lt;DateFormat&gt; at release 3.1 &#9679; Modified cardinality of &lt;DateFormat&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link PublishingDate}</li>
 * </ul>
 */
public class PublishingDate
    implements OnixDataCompositeWithKey<JonixPublishingDate, PublishingDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublishingDate";
    public static final String shortname = "publishingdate";

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
    public static final PublishingDate EMPTY = new PublishingDate();

    public PublishingDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PublishingDate(org.w3c.dom.Element element) {
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
                case PublishingDateRole.refname:
                case PublishingDateRole.shortname:
                    publishingDateRole = new PublishingDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PublishingDate&gt; or &lt;publishingdate&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublishingDate> action) {
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

    private PublishingDateRole publishingDateRole = PublishingDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date, <i>eg</i> publication date, announcement date, latest
     * reprint date. Mandatory in each occurrence of the &lt;PublishingDate&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public PublishingDateRole publishingDateRole() {
        _initialize();
        return publishingDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;PublishingDateRole&gt; field. Mandatory in each occurrence of the
     * &lt;PublishingDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the
     * attribute is missing, then the default format is YYYYMMDD.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixPublishingDate asStruct() {
        _initialize();
        JonixPublishingDate struct = new JonixPublishingDate();
        struct.publishingDateRole = publishingDateRole.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PublishingDateRoles structKey() {
        return publishingDateRole().value;
    }
}
