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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixEpubUsageLimit;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Usage constraint composite (digital products)</h1><p>An optional and repeatable group of data elements which
 * together describe a usage constraint on a digital product (or the absence of such a constraint), whether enforced by
 * DRM technical protection, inherent in the platform used, or specified by license agreement.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;EpubUsageConstraint&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;epubusageconstraint&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(EpubUsageType.refname) || name.equals(EpubUsageType.shortname)) {
                epubUsageType = new EpubUsageType(e);
            } else if (name.equals(EpubUsageStatus.refname) || name.equals(EpubUsageStatus.shortname)) {
                epubUsageStatus = new EpubUsageStatus(e);
            } else if (name.equals(EpubUsageLimit.refname) || name.equals(EpubUsageLimit.shortname)) {
                epubUsageLimits = JPU.addToList(epubUsageLimits, new EpubUsageLimit(e));
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

    private EpubUsageType epubUsageType = EpubUsageType.EMPTY;

    /**
     * (this field is required)
     */
    public EpubUsageType epubUsageType() {
        initialize();
        return epubUsageType;
    }

    private EpubUsageStatus epubUsageStatus = EpubUsageStatus.EMPTY;

    /**
     * (this field is required)
     */
    public EpubUsageStatus epubUsageStatus() {
        initialize();
        return epubUsageStatus;
    }

    private ListOfOnixDataComposite<EpubUsageLimit, JonixEpubUsageLimit> epubUsageLimits =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<EpubUsageLimit, JonixEpubUsageLimit> epubUsageLimits() {
        initialize();
        return epubUsageLimits;
    }
}
