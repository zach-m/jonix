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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixProduct;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixBarcode;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixRecordSourceIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1><h2>ONIX for Books Product record</h2><p>Every ONIX message must contain either one or more
 * &lt;Product&gt; composites or a single &lt;NoProduct/&gt; empty element.</p><h3 class="nobreak">Product
 * composite</h3><p>A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and
 * ending with an XML label &lt;/Product&gt;. The entire group of data elements which is enclosed between these two
 * labels constitutes an ONIX product record. The product record is the fundamental unit within an ONIX Product
 * Information message. In almost every case, each product record describes an individually tradable item; and in all
 * circumstances, each tradable item identified by a recognized product identifier should be described by one, and only
 * one, ONIX product record.</p><p>In ONIX 3.0, a &lt;Product&gt; record has a mandatory ‘preamble’ comprising data
 * element Groups P.1 and P.2, and carrying data that identifies the record and the product to which it refers. This is
 * followed by up to six ‘blocks’, each optional, some of which are repeatable.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Product&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;product&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Product implements OnixProduct, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Product";
    public static final String shortname = "product";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Product EMPTY = new Product();

    public Product() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Product(org.w3c.dom.Element element) {
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
                case RecordReference.refname:
                case RecordReference.shortname:
                    recordReference = new RecordReference(e);
                    break;
                case NotificationType.refname:
                case NotificationType.shortname:
                    notificationType = new NotificationType(e);
                    break;
                case DeletionText.refname:
                case DeletionText.shortname:
                    deletionTexts = JPU.addToList(deletionTexts, new DeletionText(e));
                    break;
                case RecordSourceType.refname:
                case RecordSourceType.shortname:
                    recordSourceType = new RecordSourceType(e);
                    break;
                case RecordSourceIdentifier.refname:
                case RecordSourceIdentifier.shortname:
                    recordSourceIdentifiers = JPU.addToList(recordSourceIdentifiers, new RecordSourceIdentifier(e));
                    break;
                case RecordSourceName.refname:
                case RecordSourceName.shortname:
                    recordSourceName = new RecordSourceName(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case Barcode.refname:
                case Barcode.shortname:
                    barcodes = JPU.addToList(barcodes, new Barcode(e));
                    break;
                case DescriptiveDetail.refname:
                case DescriptiveDetail.shortname:
                    descriptiveDetail = new DescriptiveDetail(e);
                    break;
                case CollateralDetail.refname:
                case CollateralDetail.shortname:
                    collateralDetail = new CollateralDetail(e);
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
                case ProductSupply.refname:
                case ProductSupply.shortname:
                    productSupplys = JPU.addToList(productSupplys, new ProductSupply(e));
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * (this field is required)
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * (this field is required)
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private ListOfOnixElement<DeletionText, String> deletionTexts = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<DeletionText, String> deletionTexts() {
        _initialize();
        return deletionTexts;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier, NameCodeTypes>
        recordSourceIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier, NameCodeTypes> recordSourceIdentifiers() {
        _initialize();
        return recordSourceIdentifiers;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes() {
        _initialize();
        return barcodes;
    }

    private DescriptiveDetail descriptiveDetail = DescriptiveDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public DescriptiveDetail descriptiveDetail() {
        _initialize();
        return descriptiveDetail;
    }

    private CollateralDetail collateralDetail = CollateralDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public CollateralDetail collateralDetail() {
        _initialize();
        return collateralDetail;
    }

    private ContentDetail contentDetail = ContentDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public ContentDetail contentDetail() {
        _initialize();
        return contentDetail;
    }

    private PublishingDetail publishingDetail = PublishingDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public PublishingDetail publishingDetail() {
        _initialize();
        return publishingDetail;
    }

    private RelatedMaterial relatedMaterial = RelatedMaterial.EMPTY;

    /**
     * (this field is optional)
     */
    public RelatedMaterial relatedMaterial() {
        _initialize();
        return relatedMaterial;
    }

    private List<ProductSupply> productSupplys = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ProductSupply> productSupplys() {
        _initialize();
        return productSupplys;
    }
}
