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
import com.tectonica.jonix.struct.JonixPrize;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1><h4 class="nobreak">Collateral detail composite</h4><p>The collateral detail block covers data element
 * Groups P.14 to P.17, all of which are primarily concerned with information and/or resources which in one way or
 * another support the marketing of the product. The block as a whole is non-repeating. It is not mandatory within the
 * &lt;Product&gt; record, nor are any of the individual sections mandatory within an occurrence of the block.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;CollateralDetail&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;collateraldetail&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class CollateralDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CollateralDetail";
    public static final String shortname = "collateraldetail";

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
    public static final CollateralDetail EMPTY = new CollateralDetail();

    public CollateralDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CollateralDetail(org.w3c.dom.Element element) {
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
            if (name.equals(TextContent.refname) || name.equals(TextContent.shortname)) {
                textContents = JPU.addToList(textContents, new TextContent(e));
            } else if (name.equals(CitedContent.refname) || name.equals(CitedContent.shortname)) {
                citedContents = JPU.addToList(citedContents, new CitedContent(e));
            } else if (name.equals(SupportingResource.refname) || name.equals(SupportingResource.shortname)) {
                supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
            } else if (name.equals(Prize.refname) || name.equals(Prize.shortname)) {
                prizes = JPU.addToList(prizes, new Prize(e));
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

    private List<TextContent> textContents = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<TextContent> textContents() {
        initialize();
        return textContents;
    }

    private List<CitedContent> citedContents = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<CitedContent> citedContents() {
        initialize();
        return citedContents;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SupportingResource> supportingResources() {
        initialize();
        return supportingResources;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        initialize();
        return prizes;
    }
}
