/*
 * Copyright (C) 2012 Zach Melamed
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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPublishingDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publishing date composite</h1><p>A group of data elements which together specify a date associated with the
 * publishing of the product. Optional, but where known, at least a date of publication <em>must</em> be specified
 * <em>either</em> here (as a ‘global’ pub date) <em>or</em> in &lt;MarketPublishingDetail&gt; (P.25). Other dates
 * related to the publishing of a product can be sent in further repeats of the composite.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;PublishingDate&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;publishingdate&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

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
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
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
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PublishingDateRole publishingDateRole = PublishingDateRole.EMPTY;

    /**
     * (this field is required)
     */
    public PublishingDateRole publishingDateRole() {
        _initialize();
        return publishingDateRole;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private Date date = Date.EMPTY;

    /**
     * (this field is required)
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
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PublishingDateRoles structKey() {
        return publishingDateRole().value;
    }
}
