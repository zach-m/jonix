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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBarcode;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;
import com.tectonica.jonix.common.struct.JonixRecordSourceIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product composite</h1>
 * <p>
 * A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and ending with an XML
 * label &lt;/Product&gt;. The entire group of data elements which is enclosed between these two labels constitutes an
 * ONIX Product record. The Product record is the fundamental unit within an ONIX Product Information message. In almost
 * every case, each Product record describes an individually tradable item; and in all circumstances, each tradable item
 * identified by a recognized product identifier should be described by one, and only one, ONIX Product record.
 * </p>
 * <p>
 * In ONIX&nbsp;3.0 and later, a Product record has a mandatory ‘preamble’ comprising data Groups P.1 and P.2, and
 * carrying data that identifies the record and the product to which it refers. This is followed by up to eight
 * ‘blocks’, each of which is optional. Of these blocks, Blocks 1 to 5, plus 7 and 8 are not repeatable. Block 6
 * <em>appears</em> to be repeatable, but it is often more useful to think of a singular Block 6 comprising all repeats
 * of its contained &lt;ProductSupply&gt; composites. In special circumstances&nbsp;– with partial (‘Block’) updates and
 * only when &lt;MarketReference&gt; is used to label each individual &lt;ProductSupply&gt; composite&nbsp;–
 * Block&nbsp;6 can be thought of as a truly repeatable block, each repeat consisting of a single &lt;ProductSupply&gt;
 * composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Product&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;product&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Product&gt; from the schema author:
 *
 * Container for details of a single product &#9679; Added &lt;ProductionDetail&gt; (Block 8) at revision 3.0.8 &#9679;
 * Added &lt;PromotionDetail&gt; (Block 7) at revision 3.0.7 &#9679; Modified cardinality of &lt;DeletionText&gt; at
 * revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product}</li>
 * </ul>
 */
public class Product implements OnixProduct, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Product";
    public static final String shortname = "product";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    private final OnixVersion onixVersion;
    private final String onixRelease;

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

    /**
     * This constructor is for backward compatibility. For future proofing, it's recommended to use the other
     * constructor, passing onixRelease label.
     */
    public Product(org.w3c.dom.Element element) {
        this(element, null);
    }

    public Product(org.w3c.dom.Element element, String onixRelease) {
        exists = true;
        initialized = false;
        this.element = element;
        this.onixVersion = OnixVersion.ONIX3;
        this.onixRelease = onixRelease;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    @Override
    public OnixVersion onixVersion() {
        return onixVersion;
    }

    @Override
    public String onixRelease() {
        return onixRelease;
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
                case RecordReference.refname:
                case RecordReference.shortname:
                    recordReference = new RecordReference(e);
                    break;
                case NotificationType.refname:
                case NotificationType.shortname:
                    notificationType = new NotificationType(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case RecordSourceType.refname:
                case RecordSourceType.shortname:
                    recordSourceType = new RecordSourceType(e);
                    break;
                case RecordSourceName.refname:
                case RecordSourceName.shortname:
                    recordSourceName = new RecordSourceName(e);
                    break;
                case DescriptiveDetail.refname:
                case DescriptiveDetail.shortname:
                    descriptiveDetail = new DescriptiveDetail(e);
                    break;
                case CollateralDetail.refname:
                case CollateralDetail.shortname:
                    collateralDetail = new CollateralDetail(e);
                    break;
                case PromotionDetail.refname:
                case PromotionDetail.shortname:
                    promotionDetail = new PromotionDetail(e);
                    break;
                case ContentDetail.refname:
                case ContentDetail.shortname:
                    contentDetail = new ContentDetail(e);
                    break;
                case PublishingDetail.refname:
                case PublishingDetail.shortname:
                    publishingDetail = new PublishingDetail(e);
                    break;
                case RelatedMaterial.refname:
                case RelatedMaterial.shortname:
                    relatedMaterial = new RelatedMaterial(e);
                    break;
                case ProductionDetail.refname:
                case ProductionDetail.shortname:
                    productionDetail = new ProductionDetail(e);
                    break;
                case DeletionText.refname:
                case DeletionText.shortname:
                    deletionTexts = JPU.addToList(deletionTexts, new DeletionText(e));
                    break;
                case RecordSourceIdentifier.refname:
                case RecordSourceIdentifier.shortname:
                    recordSourceIdentifiers = JPU.addToList(recordSourceIdentifiers, new RecordSourceIdentifier(e));
                    break;
                case Barcode.refname:
                case Barcode.shortname:
                    barcodes = JPU.addToList(barcodes, new Barcode(e));
                    break;
                case ProductSupply.refname:
                case ProductSupply.shortname:
                    productSupplys = JPU.addToList(productSupplys, new ProductSupply(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Product&gt; or &lt;product&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Product> action) {
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * <p>
     * For every product, you must choose a single record reference which will uniquely identify the Information record
     * which you send out about that product, and which will remain as its permanent identifier every time you send an
     * update. It doesn’t matter what reference you choose, provided that it is unique and permanent. This record
     * reference doesn’t identify the <em>product</em>&nbsp;– even though you may choose to use the ISBN or another
     * product identifier as a part of your record reference&nbsp;– it identifies <em>your information record about the
     * product</em>, so that the person to whom you are sending an update can match it with what you have previously
     * sent. It is not recommended to use a product identifier as the whole of the record reference. A good way of
     * generating references which are not part of a recognized product identification scheme but which can be
     * guaranteed to be unique is to prefix a product identifier or a meaningless row ID from your internal database
     * with a reversed Internet domain name which is registered to your organization (reversal prevents the record
     * reference appearing to be a resolvable URL). Alternatively, use a UUID.
     * </p>
     * <p>
     * This field is mandatory and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of notification or update which you are sending. Mandatory and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify an identifier of a product in accordance with a particular
     * scheme. Mandatory within &lt;Product&gt;, and repeatable with different identifiers for the same product. As well
     * as standard identifiers, the composite allows proprietary identifiers (for example SKUs assigned by wholesalers
     * or vendors) to be sent as part of the ONIX record.
     * </p>
     * <p>
     * ISBN-13 numbers in their unhyphenated form constitute a range of&nbsp;GTIN-13 numbers that has been reserved for
     * the international book trade. Effective from 1 January 2007, it was agreed by ONIX national groups that it should
     * be <em>mandatory</em> in an ONIX &lt;Product&gt; record for any item carrying an ISBN-13 to include the ISBN-13
     * labelled as a GTIN-13 number (<i>ie</i>&nbsp;as &lt;ProductIDType&gt; code 03), since this is how the ISBN-13
     * will be used in book trade transactions. For many ONIX applications this will also be sufficient.
     * </p>
     * <p>
     * For some ONIX applications, however, particularly when data is to be supplied to the library sector, there may be
     * reasons why the ISBN-13 must <em>also</em> be sent labelled distinctively as an ISBN-13 (<i>ie</i>&nbsp;as
     * &lt;ProductIDType&gt; code 15). Users should consult ‘good practice’ guidelines and/or discuss with their trading
     * partners.
     * </p>
     * <p>
     * Note that for some identifiers such as ISBN, punctuation (typically hyphens or spaces for ISBNs) is used to
     * enhance readability when printed, but the punctuation is dropped when carried in ONIX data. But for other
     * identifiers&nbsp;– for example DOI&nbsp;– the punctuation is an integral part of the identifier and must always
     * be included.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of source which has issued the ONIX record. Optional and non-repeating,
     * independently of the occurrence of any other field.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * <p>
     * The name of the party which issued the record, as free text. Optional and non-repeating, independently of the
     * occurrence of any other field.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private DescriptiveDetail descriptiveDetail = DescriptiveDetail.EMPTY;

    /**
     * <p>
     * The descriptive detail block covers data Groups P.3 to P.13, all of which are essentially part of the factual
     * description of the form and content of a product. The block as a whole is non-repeating. It is mandatory in any
     * &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an
     * update notice which carries only those blocks in which changes have occurred.
     * </p>
     * JONIX adds: this field is optional
     */
    public DescriptiveDetail descriptiveDetail() {
        _initialize();
        return descriptiveDetail;
    }

    private CollateralDetail collateralDetail = CollateralDetail.EMPTY;

    /**
     * <p>
     * The collateral detail block covers data Groups P.14 to P.17, all of which are primarily concerned with
     * information and/or resources which in one way or another support the marketing of the product. The block as a
     * whole is non-repeating.
     * </p>
     * <p>
     * The block is not mandatory within the &lt;Product&gt; record, nor are any of the individual sections mandatory
     * within an occurrence of the block. However, in most circumstances, the block should contain at least one instance
     * of &lt;TextContent&gt;, &lt;CitedContent&gt;, &lt;SupportingResource&gt; or &lt;Prize&gt;. It may be empty
     * <em>only</em> within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when the
     * intention is to remove all previously-supplied collateral material.
     * </p>
     * JONIX adds: this field is optional
     */
    public CollateralDetail collateralDetail() {
        _initialize();
        return collateralDetail;
    }

    private PromotionDetail promotionDetail = PromotionDetail.EMPTY;

    /**
     * <p>
     * The promotion detail block comprises the single data Group P.27. The block as a whole is optional and
     * non-repeating, and is used only when there is a need to describe various promotional events intended to promote
     * the product in a structured way. When used, the block usually consists of one or more instances of
     * &lt;PromotionalEvent&gt;. It may be empty <em>only</em> within a partial or ‘block update’ (Notification or
     * update type&nbsp;04, see&nbsp;P.1.2), when the intention is to remove all previously-supplied promotion detail.
     * </p>
     * JONIX adds: this field is optional
     */
    public PromotionDetail promotionDetail() {
        _initialize();
        return promotionDetail;
    }

    private ContentDetail contentDetail = ContentDetail.EMPTY;

    /**
     * <p>
     * The Content detail block comprises the single data Group&nbsp;P.18. The block as a whole is non-repeating. It is
     * not mandatory within the &lt;Product&gt; record, and is used only when there is a requirement to describe
     * individual chapters or parts within a product in a fully structured way. The more usual ONIX practice is to send
     * a table of contents as text, possibly in XHTML, in Group&nbsp;P.14.
     * </p>
     * <p>
     * When used, the block should normally contain at least one instance of &lt;ContentItem&gt;. It may be empty
     * <em>only</em> within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when the
     * intention is to remove all previously-supplied content detail.
     * </p>
     * JONIX adds: this field is optional
     */
    public ContentDetail contentDetail() {
        _initialize();
        return contentDetail;
    }

    private PublishingDetail publishingDetail = PublishingDetail.EMPTY;

    /**
     * <p>
     * The publishing detail block covers data Groups P.19 to P.21, carrying information on the publisher(s), ‘global’
     * publishing status, and rights attaching to a product. The block as a whole is non-repeating. It is mandatory in
     * any &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an
     * update notice which carries only those blocks in which changes have occurred.
     * </p>
     * JONIX adds: this field is optional
     */
    public PublishingDetail publishingDetail() {
        _initialize();
        return publishingDetail;
    }

    private RelatedMaterial relatedMaterial = RelatedMaterial.EMPTY;

    /**
     * <p>
     * The related material block covers data Groups P.22 and P.23, providing links to related works and related
     * products. The block as a whole is optional and non-repeating.
     * </p>
     * <p>
     * None of the individual sections are mandatory within an occurrence of the block. However, in most circumstances,
     * the block should contain at least one instance of &lt;RelatedWork&gt; or &lt;RelatedProduct&gt;. It may be empty
     * only within a partial or ‘block update’ (Notification or update type&nbsp;04, see&nbsp;P.1.2), when the intention
     * is to remove all previously-supplied information about related works and products.
     * </p>
     * JONIX adds: this field is optional
     */
    public RelatedMaterial relatedMaterial() {
        _initialize();
        return relatedMaterial;
    }

    private ProductionDetail productionDetail = ProductionDetail.EMPTY;

    /**
     * <p>
     * The Production detail block comprises the single data Group P.28. The block as a whole is non-repeating. It is
     * optional within the &lt;Product&gt; record, and is used only when there is a requirement to communicate
     * specification and file manifest detail relating to intermediary services within the supply chain, for example
     * manufacturing on demand, e‑book conversion services or distribution of digital audio. It is not expected to be
     * present in most ONIX messages&nbsp;– though recipients not requiring the data should be able to ignore the entire
     * block if it is supplied.
     * </p>
     * <p>
     * When used, the block should normally contain at least one instance of &lt;ProductionManifest&gt;. It may be empty
     * only within a partial or ‘block update’ (Notification or update type 04, see P.1.2), when the intention is to
     * remove all previously-supplied manifest detail.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductionDetail productionDetail() {
        _initialize();
        return productionDetail;
    }

    private ListOfOnixElement<DeletionText, String> deletionTexts = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text which indicates the reason why an ONIX record is being deleted. Optional and repeatable, and may occur
     * only when the &lt;NotificationType&gt; element carries the code value 05. The <i>language</i> attribute is
     * optional for a single instance of &lt;DeletionText&gt;, but must be included in each instance if
     * &lt;DeletionText&gt; is repeated. Note that it refers to the reason why the <em>record</em> is being deleted, not
     * the reason why a <em>product</em> has been ‘deleted’ (in industries which use this terminology when a product is
     * withdrawn).
     * </p>
     * <p>
     * A product cancellation or abandonment prior to publication, or a product becoming unavailable (<i>eg</i>&nbsp;as
     * a result of being Out of print) are changes of &lt;PublishingStatus&gt; or of &lt;ProductAvailability&gt;, not
     * reasons for deletion.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<DeletionText, String> deletionTexts() {
        _initialize();
        return deletionTexts;
    }

    private ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier,
        NameIdentifierTypes> recordSourceIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(RecordSourceIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of the organization which is the source of the ONIX
     * record. Optional, and repeatable in order to send multiple identifiers for the same organization.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier, NameIdentifierTypes>
        recordSourceIdentifiers() {
        _initialize();
        return recordSourceIdentifiers;
    }

    private ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes = JPU.emptyListOfOnixDataComposite(Barcode.class);

    /**
     * <p>
     * A group of data elements which together specify a barcode type and its position on a product. Optional: expected
     * to be used only in North America. Repeatable if more than one type of barcode is carried on a single product. The
     * absence of this composite does <em>not</em> mean that a product is not bar-coded.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes() {
        _initialize();
        return barcodes;
    }

    private ListOfOnixComposite<ProductSupply> productSupplys = JPU.emptyListOfOnixComposite(ProductSupply.class);

    /**
     * <p>
     * The product supply block covers data Groups P.24 to P.26, specifying a market, the publishing status and
     * representation detail of the product in that market, and the supply arrangements for the product in that market.
     * The &lt;ProductSupply&gt; composite is repeatable within the block to describe multiple markets. At least one
     * occurrence is expected in a &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1
     * indicates that the record is a partial update notice which carries only those blocks in which changes have
     * occurred.
     * </p>
     * <p>
     * Note that for many products with simple supply arrangements and a single market, many details of that market are
     * ‘inherited’ from Block&nbsp;4 and need not be repeated.
     * </p>
     * <p>
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ProductSupply> productSupplys() {
        _initialize();
        return productSupplys;
    }
}
