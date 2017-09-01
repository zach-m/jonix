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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright statement composite</h1><p>An optional and repeatable group of data elements which together represent a
 * copyright or neighbouring right statement for the product. Either the copyright year alone, or a structured rights
 * statement listing year(s) and rights holder(s), may be sent as an instance of the composite.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;CopyrightStatement&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;copyrightstatement&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class CopyrightStatement implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightStatement";
    public static final String shortname = "copyrightstatement";

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
    public static final CopyrightStatement EMPTY = new CopyrightStatement();

    public CopyrightStatement() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CopyrightStatement(org.w3c.dom.Element element) {
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
            switch (name) {
                case CopyrightType.refname:
                case CopyrightType.shortname:
                    copyrightType = new CopyrightType(e);
                    break;
                case CopyrightYear.refname:
                case CopyrightYear.shortname:
                    copyrightYears = JPU.addToList(copyrightYears, new CopyrightYear(e));
                    break;
                case CopyrightOwner.refname:
                case CopyrightOwner.shortname:
                    copyrightOwners = JPU.addToList(copyrightOwners, new CopyrightOwner(e));
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

    private CopyrightType copyrightType = CopyrightType.EMPTY;

    /**
     * (this field is optional)
     */
    public CopyrightType copyrightType() {
        initialize();
        return copyrightType;
    }

    private ListOfOnixElement<CopyrightYear, String> copyrightYears = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<CopyrightYear, String> copyrightYears() {
        initialize();
        return copyrightYears;
    }

    private List<CopyrightOwner> copyrightOwners = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<CopyrightOwner> copyrightOwners() {
        initialize();
        return copyrightOwners;
    }
}
