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
 * <h1>Collateral detail composite</h1>
 * <p>
 * The collateral detail block covers data element Groups P.14 to P.17, all of which are primarily concerned with
 * information and/or resources which in one way or another support the marketing of the product. The block as a whole
 * is non-repeating.
 * </p>
 * <p>
 * The block is not mandatory within the &lt;Product&gt; record, nor are any of the individual sections mandatory within
 * an occurrence of the block. However, in most circumstances, the block should contain at least one instance of
 * &lt;TextContent&gt;, &lt;CitedContent&gt;, &lt;SupportingResource&gt; or &lt;Prize&gt;. It may be empty <em>only</em>
 * within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when the intention is to
 * remove all previously-supplied collateral material.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CollateralDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;collateraldetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail</li>
 * </ul>
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
                case TextContent.refname:
                case TextContent.shortname:
                    textContents = JPU.addToList(textContents, new TextContent(e));
                    break;
                case CitedContent.refname:
                case CitedContent.shortname:
                    citedContents = JPU.addToList(citedContents, new CitedContent(e));
                    break;
                case SupportingResource.refname:
                case SupportingResource.shortname:
                    supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
                    break;
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CollateralDetail&gt; or &lt;collateraldetail&gt;) is explicitly provided in the
     * ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private List<TextContent> textContents = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together carry text related to the product, repeatable in order to
     * deliver multiple texts (often of different types, though for some text types there many be multiple instances of
     * that type).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<TextContent> textContents() {
        _initialize();
        return textContents;
    }

    private List<CitedContent> citedContents = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together describe a piece of cited content. The composite is repeatable
     * to describe and link to multiple items of cited material.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<CitedContent> citedContents() {
        _initialize();
        return citedContents;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together describe a supporting resource. The composite is repeatable to
     * describe and link to multiple resources. Note that different forms of the <em>same</em> resource (for example a
     * cover image in separate low and high resolution versions) should be specified in a single instance of the
     * composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together describe a prize or award won by the product or work, and
     * repeatable where it has gained multiple prizes or awards.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        _initialize();
        return prizes;
    }
}
