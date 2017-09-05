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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProfessionalAffiliation;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Professional affiliation composite</h1><p>A repeatable group of data elements which together identify a
 * contributor’s professional position and/or affiliation, allowing multiple positions and affiliations to be
 * specified.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ProfessionalAffiliation&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;professionalaffiliation&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProfessionalAffiliation implements OnixDataComposite<JonixProfessionalAffiliation>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProfessionalAffiliation";
    public static final String shortname = "professionalaffiliation";

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
    public static final ProfessionalAffiliation EMPTY = new ProfessionalAffiliation();

    public ProfessionalAffiliation() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProfessionalAffiliation(org.w3c.dom.Element element) {
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
                case ProfessionalPosition.refname:
                case ProfessionalPosition.shortname:
                    professionalPositions = JPU.addToList(professionalPositions, new ProfessionalPosition(e));
                    break;
                case Affiliation.refname:
                case Affiliation.shortname:
                    affiliation = new Affiliation(e);
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

    private ListOfOnixElement<ProfessionalPosition, String> professionalPositions = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ProfessionalPosition, String> professionalPositions() {
        _initialize();
        return professionalPositions;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * (this field is optional)
     */
    public Affiliation affiliation() {
        _initialize();
        return affiliation;
    }

    @Override
    public JonixProfessionalAffiliation asStruct() {
        _initialize();
        JonixProfessionalAffiliation struct = new JonixProfessionalAffiliation();
        struct.affiliation = affiliation.value;
        struct.professionalPositions = professionalPositions.values();
        return struct;
    }
}
