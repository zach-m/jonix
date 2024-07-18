/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related material composite</h1>
 * <p>
 * The related material block covers data Groups P.22 and P.23, providing links to related works and related products.
 * The block as a whole is optional and non-repeating.
 * </p>
 * <p>
 * None of the individual sections are mandatory within an occurrence of the block. However, in most circumstances, the
 * block should contain at least one instance of &lt;RelatedWork&gt; or &lt;RelatedProduct&gt;. It may be empty only
 * within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when the intention is to
 * remove all previously-supplied information about related works and products.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RelatedMaterial&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;relatedmaterial&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;RelatedMaterial&gt; from the schema author:
 *
 * Block 5, container for elements providing links to closely-related products and works
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link RelatedMaterial}</li>
 * </ul>
 */
public class RelatedMaterial implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RelatedMaterial";
    public static final String shortname = "relatedmaterial";

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
    public static final RelatedMaterial EMPTY = new RelatedMaterial();

    public RelatedMaterial() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public RelatedMaterial(org.w3c.dom.Element element) {
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
                case RelatedWork.refname:
                case RelatedWork.shortname:
                    relatedWorks = JPU.addToList(relatedWorks, new RelatedWork(e));
                    break;
                case RelatedProduct.refname:
                case RelatedProduct.shortname:
                    relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;RelatedMaterial&gt; or &lt;relatedmaterial&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RelatedMaterial> action) {
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

    private ListOfOnixComposite<RelatedWork> relatedWorks = JPU.emptyListOfOnixComposite(RelatedWork.class);

    /**
     * <p>
     * An optional group of data elements which together describe a work which has a specified relationship to the
     * product described in the ONIX record. Repeatable in order to specify multiple works and their various
     * relationships to the product.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<RelatedWork> relatedWorks() {
        _initialize();
        return relatedWorks;
    }

    private ListOfOnixComposite<RelatedProduct> relatedProducts = JPU.emptyListOfOnixComposite(RelatedProduct.class);

    /**
     * <p>
     * An optional group of data elements which together describe a product which has a specified relationship to the
     * product described in the ONIX record. The composite is repeatable in order to specify different products which
     * each have a relationship to the product described.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<RelatedProduct> relatedProducts() {
        _initialize();
        return relatedProducts;
    }
}
