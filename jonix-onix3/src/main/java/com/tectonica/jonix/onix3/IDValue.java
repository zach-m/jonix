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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

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
 * <li>&lt;{@link SupplyContactIdentifier}&gt;</li>
 * <li>&lt;{@link ResourceIdentifier}&gt;</li>
 * <li>&lt;{@link EventSponsorIdentifier}&gt;</li>
 * <li>&lt;{@link AffiliationIdentifier}&gt;</li>
 * <li>&lt;{@link FundingIdentifier}&gt;</li>
 * <li>&lt;{@link ImprintIdentifier}&gt;</li>
 * <li>&lt;{@link LocationIdentifier}&gt;</li>
 * <li>&lt;{@link PublisherIdentifier}&gt;</li>
 * <li>&lt;{@link SenderIdentifier}&gt;</li>
 * <li>&lt;{@link SalesOutletIdentifier}&gt;</li>
 * <li>&lt;{@link AddresseeIdentifier}&gt;</li>
 * <li>&lt;{@link WorkIdentifier}&gt;</li>
 * <li>&lt;{@link AgentIdentifier}&gt;</li>
 * <li>&lt;{@link AVItemIdentifier}&gt;</li>
 * <li>&lt;{@link EventIdentifier}&gt;</li>
 * <li>&lt;{@link ProductIdentifier}&gt;</li>
 * <li>&lt;{@link CollectionIdentifier}&gt;</li>
 * <li>&lt;{@link NameIdentifier}&gt;</li>
 * <li>&lt;{@link ProductContactIdentifier}&gt;</li>
 * <li>&lt;{@link CopyrightOwnerIdentifier}&gt;</li>
 * <li>&lt;{@link TextItemIdentifier}&gt;</li>
 * <li>&lt;{@link RecordSourceIdentifier}&gt;</li>
 * <li>&lt;{@link SupplierIdentifier}&gt;</li>
 * <li>&lt;{@link PriceIdentifier}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyContact} ⯈
 * {@link SupplyContactIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event} ⯈ {@link EventSponsor} ⯈
 * {@link EventSponsorIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link EventSponsor} ⯈ {@link EventSponsorIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventSponsor} ⯈
 * {@link EventSponsorIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation} ⯈
 * {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link ProfessionalAffiliation} ⯈
 * {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈
 * {@link ProfessionalAffiliation} ⯈ {@link AffiliationIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Publisher} ⯈ {@link Funding} ⯈
 * {@link FundingIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link Funding} ⯈ {@link FundingIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Imprint} ⯈ {@link ImprintIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link LocationIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Publisher} ⯈ {@link PublisherIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link PublisherIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Header} ⯈ {@link Sender} ⯈ {@link SenderIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet}
 * ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Header} ⯈ {@link Addressee} ⯈ {@link AddresseeIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedWork} ⯈ {@link WorkIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedWork} ⯈ {@link WorkIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link PublisherRepresentative} ⯈
 * {@link AgentIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem} ⯈ {@link AVItemIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link EventIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedProduct} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedProduct} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Tax} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link ComparisonProductPrice} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceCondition} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link CollectionIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link AlternativeName} ⯈ {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link AlternativeName}
 * ⯈ {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link ContributorReference} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link NameIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link NameIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link NameIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link ProductContact} ⯈ {@link ProductContactIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link ProductContact} ⯈
 * {@link ProductContactIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CopyrightStatement} ⯈
 * {@link CopyrightOwner} ⯈ {@link CopyrightOwnerIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link CopyrightStatement} ⯈ {@link CopyrightOwner} ⯈
 * {@link CopyrightOwnerIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextItem} ⯈ {@link TextItemIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link RecordSourceIdentifier} ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier} ⯈ {@link SupplierIdentifier}
 * ⯈ {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier} ⯈ {@link SupplierIdentifier} ⯈
 * {@link IDValue}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceIdentifier} ⯈
 * {@link IDValue}</li>
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of IDValue. Could be null if {@code exists() == false}. Use {@link #value()} instead if
     * you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: According to the identifier type specified in &lt;SenderIDType&gt;
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
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
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;IDValue&gt; or &lt;b244&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<IDValue> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
