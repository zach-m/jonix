/*
 * Copyright (C) 2012-2025 Zach Melamed
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
 * <h1>Promotion detail composite</h1>
 * <p>
 * The promotion detail block comprises the single data Group P.27. The block as a whole is optional and non-repeating,
 * and is used only when there is a need to describe various promotional events intended to promote the product in a
 * structured way. When used, the block usually consists of one or more instances of &lt;PromotionalEvent&gt;. It may be
 * empty <em>only</em> within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when
 * the intention is to remove all previously-supplied promotion detail.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PromotionDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;promotiondetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PromotionDetail&gt; from the schema author:
 *
 * Block 7, container for data describing events arranged to promote the product (eg readings, author signings) &#9679;
 * Added at revision 3.0.7
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PromotionDetail}</li>
 * </ul>
 *
 * @since Onix-3.07
 */
public class PromotionDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PromotionDetail";
    public static final String shortname = "promotiondetail";

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
    public static final PromotionDetail EMPTY = new PromotionDetail();

    public PromotionDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PromotionDetail(org.w3c.dom.Element element) {
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
                case PromotionalEvent.refname:
                case PromotionalEvent.shortname:
                    promotionalEvents = JPU.addToList(promotionalEvents, new PromotionalEvent(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PromotionDetail&gt; or &lt;promotiondetail&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PromotionDetail> action) {
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

    private ListOfOnixComposite<PromotionalEvent> promotionalEvents =
        JPU.emptyListOfOnixComposite(PromotionalEvent.class);

    /**
     * <p>
     * An group of data elements which together describe a promotional event or series of event occurrences such as an
     * author tour. Optional in any occurrence of the &lt;PromotionDetail&gt; composite, but it may be omitted only
     * within a partial or ‘block update’ (Notification or update type 04, see&nbsp;P.1.2) when the intention is to
     * remove all previously supplied promotional event detail. When used normally, it is repeatable to describe
     * multiple events linked to promotion of the product.
     * </p>
     * <p>
     * The promotional event composite must contain at least one &lt;EventOccurrence&gt;. It may optionally contain one
     * or more contributors to the event, listing those that are also contributors to the product using
     * &lt;ContributorReference&gt; and those that are <em>not</em> contributors to the product using
     * &lt;Contributor&gt;. If there are no contributors to the event of either type, an optional &lt;NoContributor/&gt;
     * flag may be included instead.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<PromotionalEvent> promotionalEvents() {
        _initialize();
        return promotionalEvents;
    }
}
