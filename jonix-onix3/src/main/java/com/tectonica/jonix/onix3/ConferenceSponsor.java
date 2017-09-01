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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixConferenceSponsorIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference sponsor composite</h1><p>An optional and repeatable group of data elements which together identify a
 * sponsor of a conference. <em>Either</em> an identifier, <em>or</em> one or other of &lt;PersonName&gt; or
 * &lt;CorporateName&gt;, <em>or</em> both an identifier and a name, must be present in each occurrence of the
 * composite.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ConferenceSponsor&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;conferencesponsor&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ConferenceSponsor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ConferenceSponsor";
    public static final String shortname = "conferencesponsor";

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
    public static final ConferenceSponsor EMPTY = new ConferenceSponsor();

    public ConferenceSponsor() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ConferenceSponsor(org.w3c.dom.Element element) {
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
                case ConferenceSponsorIdentifier.refname:
                case ConferenceSponsorIdentifier.shortname:
                    conferenceSponsorIdentifiers =
                        JPU.addToList(conferenceSponsorIdentifiers, new ConferenceSponsorIdentifier(e));
                    break;
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
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

    private ListOfOnixDataCompositeWithKey<ConferenceSponsorIdentifier, JonixConferenceSponsorIdentifier, NameCodeTypes>
        conferenceSponsorIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ConferenceSponsorIdentifier, JonixConferenceSponsorIdentifier, NameCodeTypes> conferenceSponsorIdentifiers() {
        initialize();
        return conferenceSponsorIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * (this field is optional)
     */
    public PersonName personName() {
        initialize();
        return personName;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * (this field is optional)
     */
    public CorporateName corporateName() {
        initialize();
        return corporateName;
    }
}
