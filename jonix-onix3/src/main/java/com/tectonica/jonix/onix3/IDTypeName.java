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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Identifier type name</h1>
 * <p>
 * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
 * there is no individual ID type code). Must be included when, and only when, the code in the &lt;SenderIDType&gt;
 * element indicates a proprietary scheme. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum 50 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;IDTypeName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b233&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt></tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;IDTypeName&gt; from the schema author:
 *
 * Type of an identifier - the name of the identifier scheme, used when the identifier comes from a proprietary rather
 * than a standard identifier scheme
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyContactIdentifier}&gt;</li>
 * <li>&lt;{@link ResourceIdentifier}&gt;</li>
 * <li>&lt;{@link EventSponsorIdentifier}&gt;</li>
 * <li>&lt;{@link FundingIdentifier}&gt;</li>
 * <li>&lt;{@link ConferenceSponsorIdentifier}&gt;</li>
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
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyContact} ⯈
 * {@link SupplyContactIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link ResourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event} ⯈ {@link EventSponsor} ⯈
 * {@link EventSponsorIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link EventSponsor} ⯈ {@link EventSponsorIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventSponsor} ⯈
 * {@link EventSponsorIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link Funding} ⯈ {@link FundingIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Conference} ⯈ {@link ConferenceSponsor} ⯈
 * {@link ConferenceSponsorIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Imprint} ⯈ {@link ImprintIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link LocationIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link PublisherIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Header} ⯈ {@link Sender} ⯈ {@link SenderIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet}
 * ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Header} ⯈ {@link Addressee} ⯈ {@link AddresseeIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedWork} ⯈ {@link WorkIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedWork} ⯈ {@link WorkIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link PublisherRepresentative} ⯈
 * {@link AgentIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem} ⯈ {@link AVItemIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link EventIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedProduct} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedProduct} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link Tax} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Tax} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link ComparisonProductPrice} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link ComparisonProductPrice} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link PriceCondition} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceCondition} ⯈
 * {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link CollectionIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link AlternativeName} ⯈ {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link AlternativeName}
 * ⯈ {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link AlternativeName} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link ContributorReference} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link NameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link NameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link NameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link NameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link ProductContact} ⯈ {@link ProductContactIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link ProductContact} ⯈
 * {@link ProductContactIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link CopyrightStatement} ⯈ {@link CopyrightOwner} ⯈
 * {@link CopyrightOwnerIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextItem} ⯈ {@link TextItemIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link RecordSourceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier} ⯈ {@link SupplierIdentifier}
 * ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier} ⯈ {@link SupplierIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link PriceIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceIdentifier} ⯈
 * {@link IDTypeName}</li>
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    public Languages language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of IDTypeName. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum 50 characters
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
    public static final IDTypeName EMPTY = new IDTypeName();

    public IDTypeName() {
        exists = false;
    }

    public IDTypeName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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

    public void ifExists(Consumer<IDTypeName> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
