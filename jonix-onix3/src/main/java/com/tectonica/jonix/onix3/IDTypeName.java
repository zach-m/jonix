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
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Identifier type name</h1><p>A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is
 * not a standard and for which there is no individual ID type code). Must be included when, and only when, the code in
 * the &lt;SenderIDType&gt; element indicates a proprietary scheme. Optional and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum 50
 * characters</td></tr><tr><td>Reference name</td><td><tt>&lt;IDTypeName&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b233&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>language</td></tr><tr><td>Example</td><td><tt></tt></td></tr></table>
 * <p>&nbsp;</p>
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
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplyContact ⯈ SupplyContactIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Event ⯈ EventSponsor ⯈ EventSponsorIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Publisher ⯈ Funding ⯈ FundingIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Conference ⯈ ConferenceSponsor ⯈ ConferenceSponsorIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Imprint ⯈ ImprintIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Stock ⯈ LocationIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ Publisher ⯈ PublisherIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Header ⯈ Sender ⯈ SenderIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ Market ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Header ⯈ Addressee ⯈ AddresseeIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedMaterial ⯈ RelatedWork ⯈ WorkIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ RelatedWork ⯈ WorkIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ PublisherRepresentative ⯈ AgentIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ AVItem ⯈ AVItemIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ ProductPart ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedMaterial ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ Tax ⯈ ProductIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ Tax ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ ComparisonProductPrice ⯈
 * ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ ComparisonProductPrice ⯈ ProductIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceCondition ⯈ ProductIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceCondition ⯈ ProductIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ CollectionIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ AlternativeName ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ AlternativeName ⯈ NameIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ NameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ ProductContact ⯈ ProductContactIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ ProductContact ⯈ ProductContactIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ CopyrightStatement ⯈ CopyrightOwner ⯈ CopyrightOwnerIdentifier ⯈
 * IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ TextItem ⯈ TextItemIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ RecordSourceIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ NewSupplier ⯈ SupplierIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Supplier ⯈ SupplierIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceIdentifier ⯈ IDTypeName</li>
 * </ul>
 */
public class IDTypeName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "IDTypeName";
    public static final String shortname = "b233";

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

    public Languages language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum 50 characters<p> (type: dt.NonEmptyString)
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
    public static final IDTypeName EMPTY = new IDTypeName();

    public IDTypeName() {
        exists = false;
    }

    public IDTypeName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;IDTypeName&gt; or &lt;b233&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
