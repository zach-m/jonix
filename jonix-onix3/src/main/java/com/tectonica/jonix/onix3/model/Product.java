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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class Product
{
	public static final String refname = "Product";
	public static final String shortname = "product";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public RecordReference recordReference; // Required
	public NotificationType notificationType; // Required
	public List<DeletionText> deletionTexts; // ZeroOrMore
	public RecordSourceType recordSourceType; // Optional
	public List<RecordSourceIdentifier> recordSourceIdentifiers; // ZeroOrMore
	public RecordSourceName recordSourceName; // Optional
	public List<ProductIdentifier> productIdentifiers; // OneOrMore
	public List<Barcode> barcodes; // ZeroOrMore
	public DescriptiveDetail descriptiveDetail; // Optional
	public CollateralDetail collateralDetail; // Optional
	public ContentDetail contentDetail; // Optional
	public PublishingDetail publishingDetail; // Optional
	public RelatedMaterial relatedMaterial; // Optional
	public List<ProductSupply> productSupplys; // ZeroOrMore

	public static Product fromDoc(org.w3c.dom.Element element)
	{
		final Product x = new Product();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(RecordReference.refname) || name.equalsIgnoreCase(RecordReference.shortname))
					x.recordReference = RecordReference.fromDoc(element);
				else if (name.equalsIgnoreCase(NotificationType.refname) || name.equalsIgnoreCase(NotificationType.shortname))
					x.notificationType = NotificationType.fromDoc(element);
				else if (name.equalsIgnoreCase(DeletionText.refname) || name.equalsIgnoreCase(DeletionText.shortname))
					x.deletionTexts = DU.addToList(x.deletionTexts, DeletionText.fromDoc(element));
				else if (name.equalsIgnoreCase(RecordSourceType.refname) || name.equalsIgnoreCase(RecordSourceType.shortname))
					x.recordSourceType = RecordSourceType.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceIdentifier.refname) || name.equalsIgnoreCase(RecordSourceIdentifier.shortname))
					x.recordSourceIdentifiers = DU.addToList(x.recordSourceIdentifiers, RecordSourceIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(RecordSourceName.refname) || name.equalsIgnoreCase(RecordSourceName.shortname))
					x.recordSourceName = RecordSourceName.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductIdentifier.refname) || name.equalsIgnoreCase(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(Barcode.refname) || name.equalsIgnoreCase(Barcode.shortname))
					x.barcodes = DU.addToList(x.barcodes, Barcode.fromDoc(element));
				else if (name.equalsIgnoreCase(DescriptiveDetail.refname) || name.equalsIgnoreCase(DescriptiveDetail.shortname))
					x.descriptiveDetail = DescriptiveDetail.fromDoc(element);
				else if (name.equalsIgnoreCase(CollateralDetail.refname) || name.equalsIgnoreCase(CollateralDetail.shortname))
					x.collateralDetail = CollateralDetail.fromDoc(element);
				else if (name.equalsIgnoreCase(ContentDetail.refname) || name.equalsIgnoreCase(ContentDetail.shortname))
					x.contentDetail = ContentDetail.fromDoc(element);
				else if (name.equalsIgnoreCase(PublishingDetail.refname) || name.equalsIgnoreCase(PublishingDetail.shortname))
					x.publishingDetail = PublishingDetail.fromDoc(element);
				else if (name.equalsIgnoreCase(RelatedMaterial.refname) || name.equalsIgnoreCase(RelatedMaterial.shortname))
					x.relatedMaterial = RelatedMaterial.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductSupply.refname) || name.equalsIgnoreCase(ProductSupply.shortname))
					x.productSupplys = DU.addToList(x.productSupplys, ProductSupply.fromDoc(element));
			}
		});

		return x;
	}
}
