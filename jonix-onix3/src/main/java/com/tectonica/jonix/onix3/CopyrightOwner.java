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
import com.tectonica.jonix.struct.JonixCopyrightOwnerIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright owner composite</h1><p>A repeatable group of data elements which together name a copyright owner.
 * Optional, so that a copyright statement can be limited to &lt;CopyrightYear&gt;. Each occurrence of the
 * &lt;CopyrightOwner&gt; composite must carry a single name (personal or corporate), or an identifier, or
 * both.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;CopyrightOwner&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;copyrightowner&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class CopyrightOwner implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightOwner";
    public static final String shortname = "copyrightowner";

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
    public static final CopyrightOwner EMPTY = new CopyrightOwner();

    public CopyrightOwner() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CopyrightOwner(org.w3c.dom.Element element) {
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
            if (name.equals(CopyrightOwnerIdentifier.refname) || name.equals(CopyrightOwnerIdentifier.shortname)) {
                copyrightOwnerIdentifiers = JPU.addToList(copyrightOwnerIdentifiers, new CopyrightOwnerIdentifier(e));
            } else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname)) {
                personName = new PersonName(e);
            } else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname)) {
                corporateName = new CorporateName(e);
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

    private ListOfOnixDataCompositeWithKey<CopyrightOwnerIdentifier, JonixCopyrightOwnerIdentifier, NameCodeTypes>
        copyrightOwnerIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<CopyrightOwnerIdentifier, JonixCopyrightOwnerIdentifier, NameCodeTypes> copyrightOwnerIdentifiers() {
        initialize();
        return copyrightOwnerIdentifiers;
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
