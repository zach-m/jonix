/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.PublishingStatuss;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publishing status</h1>
 * <p>
 * An ONIX code which identifies the status of a published product. Optional and non-repeating, but required if
 * publishing status is <em>not</em> identified at market level in &lt;MarketPublishingDetail&gt; (P.25).
 * </p>
 * <p>
 * Where the element is sent by a sender who is not the publisher, based on information that has been previously
 * supplied by the publisher, it is strongly recommended that it should carry a <i>datestamp</i> attribute to indicate
 * its likely reliability. See <a href="#message_attributes">Section 1</a> for further details of the <i>datestamp</i>
 * attribute.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 64</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublishingStatus&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b394&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;PublishingStatus&gt;02&lt;/PublishingStatus&gt;</tt> (Forthcoming)</td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>Note the typical progression of publishing status, from announcement to out-of-print, through the life cycle of a
 * product. The pale shaded area shows when the product is 'orderable' from the publisher or the publisher's
 * distributor, though if the product is 'Forthcoming' (and is later postponed indefinitely or cancelled) or the product
 * 'Out of stock indefinitely', the order may not be fulfilled. Statuses 'Withdrawn', 'Recalled' are not shown on the
 * diagram, but would normally be preceded by 'Active'. Statuses 'No longer our product' and 'Unknown' are also not
 * shown. In exceptional circumstances, products that are 'Out of print' are occasionally reactivated, returned to
 * 'Active' status, via a reprint or print-on-demand decision, and a 'Cancelled' product may be reviewed and the title
 * re-announced: [out of stock, no reprint orders pending] [out of stock, no reprint orders pending] Out of print (07)
 * announce Forthcoming (02) publish on time? publish on time? [publish] [publish] Active (04) Out of stock
 * indefinitely, RUC (06) [reprint] [reprint] [no reprint] [no reprint] postpone? Cancelled (01) [abandon] [abandon] new
 * date set? new date set? reprint? reprint? Postponed indefinitely (03) [abandon] [abandon] intend to publish? intend
 * to publish? [new date] [no new date] [no new date] [new date set] [new date set] Remaindered (10) [out of stock]
 * [excess stock] This element and the equivalent &lt;MarketPublishingStatus&gt; in P.25 are frequently confused with
 * &lt;ProductAvailability&gt; in P.26. The latter describes whether the product is available from a particular supplier
 * (eg a distributor or wholesaler) - it is an attribute of the supply chain - whereas the publishing status of a
 * product describes decisions made solely by the publisher or the publisher's representative in a market. For example,
 * a publisher may decide that a product is 'out of print' even while there are many copies available in the supply
 * chain - the OP decision would be reflected in &lt;PublishingStatus&gt; while the continued availability of copies
 * would be reflected in &lt;ProductAvailability&gt;.</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link PublishingStatus}</li>
 * </ul>
 */
public class PublishingStatus implements OnixElement<PublishingStatuss>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublishingStatus";
    public static final String shortname = "b394";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public PublishingStatuss value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public PublishingStatuss __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PublishingStatus EMPTY = new PublishingStatus();

    public PublishingStatus() {
        exists = false;
    }

    public PublishingStatus(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = PublishingStatuss.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;PublishingStatus&gt; or &lt;b394&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublishingStatus> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
