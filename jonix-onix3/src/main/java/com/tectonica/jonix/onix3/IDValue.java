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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Identifier value</h1>
 * <p>
 * An identifier of the type specified in the &lt;SenderIDType&gt; element. Mandatory in each occurrence of the
 * &lt;SenderIdentifier&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>According to the identifier type specified in &lt;SenderIDType&gt;</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;IDValue&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b244&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt></tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SupplyContactIdentifier&gt;</li>
 * <li>&lt;EventSponsorIdentifier&gt;</li>
 * <li>&lt;FundingIdentifier&gt;</li>
 * <li>&lt;ConferenceSponsorIdentifier&gt;</li>
 * <li>&lt;ImprintIdentifier&gt;</li>
 * <li>&lt;LocationIdentifier&gt;</li>
 * <li>&lt;PublisherIdentifier&gt;</li>
 * <li>&lt;SenderIdentifier&gt;</li>
 * <li>&lt;SalesOutletIdentifier&gt;</li>
 * <li>&lt;AddresseeIdentifier&gt;</li>
 * <li>&lt;WorkIdentifier&gt;</li>
 * <li>&lt;AgentIdentifier&gt;</li>
 * <li>&lt;AVItemIdentifier&gt;</li>
 * <li>&lt;ProductIdentifier&gt;</li>
 * <li>&lt;CollectionIdentifier&gt;</li>
 * <li>&lt;NameIdentifier&gt;</li>
 * <li>&lt;ProductContactIdentifier&gt;</li>
 * <li>&lt;CopyrightOwnerIdentifier&gt;</li>
 * <li>&lt;TextItemIdentifier&gt;</li>
 * <li>&lt;RecordSourceIdentifier&gt;</li>
 * <li>&lt;SupplierIdentifier&gt;</li>
 * <li>&lt;PriceIdentifier&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplyContact ⯈ SupplyContactIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Event ⯈ EventSponsor ⯈ EventSponsorIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Publisher ⯈ Funding ⯈ FundingIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Conference ⯈ ConferenceSponsor ⯈ ConferenceSponsorIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Imprint ⯈ ImprintIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Stock ⯈ LocationIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Publisher ⯈ PublisherIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Header ⯈ Sender ⯈ SenderIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ Market ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier
 * ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Header ⯈ Addressee ⯈ AddresseeIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedMaterial ⯈ RelatedWork ⯈ WorkIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ RelatedWork ⯈ WorkIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ PublisherRepresentative ⯈ AgentIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ AVItem ⯈ AVItemIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ ProductPart ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedMaterial ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ Tax ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ Tax ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ ComparisonProductPrice ⯈
 * ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ ComparisonProductPrice ⯈ ProductIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceCondition ⯈ ProductIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceCondition ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ CollectionIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ AlternativeName ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ NameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ ProductContact ⯈ ProductContactIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ ProductContact ⯈ ProductContactIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ CopyrightStatement ⯈ CopyrightOwner ⯈ CopyrightOwnerIdentifier ⯈
 * IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ TextItem ⯈ TextItemIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ RecordSourceIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ NewSupplier ⯈ SupplierIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Supplier ⯈ SupplierIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceIdentifier ⯈ IDValue</li>
 * </ul>
 */
public class IDValue implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "IDValue";
    public static final String shortname = "b244";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: According to the identifier type specified in &lt;SenderIDType&gt;
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final IDValue EMPTY = new IDValue();

    public IDValue() {
        exists = false;
    }

    public IDValue(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;IDValue&gt; or &lt;b244&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
