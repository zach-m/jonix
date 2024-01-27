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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixWorkIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related work composite (content item)</h1>
 * <p>
 * A group of data elements which together describe a work which has a specified relationship to a content item.
 * Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RelatedWork&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;relatedwork&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link RelatedMaterial}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedWork}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedWork}</li>
 * </ul>
 */
public class RelatedWork implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RelatedWork";
    public static final String shortname = "relatedwork";

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
    public static final RelatedWork EMPTY = new RelatedWork();

    public RelatedWork() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public RelatedWork(org.w3c.dom.Element element) {
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
                case WorkRelationCode.refname:
                case WorkRelationCode.shortname:
                    workRelationCode = new WorkRelationCode(e);
                    break;
                case WorkIdentifier.refname:
                case WorkIdentifier.shortname:
                    workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;RelatedWork&gt; or &lt;relatedwork&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RelatedWork> action) {
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

    private WorkRelationCode workRelationCode = WorkRelationCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the nature of the relationship between a product and a work. Mandatory in each
     * occurrence of the &lt;RelatedWork&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public WorkRelationCode workRelationCode() {
        _initialize();
        return workRelationCode;
    }

    private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers =
        JPU.emptyListOfOnixDataCompositeWithKey(WorkIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of a work in accordance with a specified scheme.
     * Mandatory in each occurrence of the &lt;RelatedWork&gt; composite, and repeatable if two or more identifiers for
     * the same work are sent using different identifier schemes (<i>eg</i> ISTC and DOI).
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers() {
        _initialize();
        return workIdentifiers;
    }
}
