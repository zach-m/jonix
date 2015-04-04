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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixRecordSourceIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Product implements JonixComposite, Serializable
{
	public static final String refname = "Product";
	public static final String shortname = "product";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
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

	public Product()
	{}

	public Product(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
					recordReference = new RecordReference(element);
				else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
					notificationType = new NotificationType(element);
				else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
					deletionTexts = JPU.addToList(deletionTexts, new DeletionText(element));
				else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
					recordSourceType = new RecordSourceType(element);
				else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
					recordSourceIdentifiers = JPU.addToList(recordSourceIdentifiers, new RecordSourceIdentifier(element));
				else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
					recordSourceName = new RecordSourceName(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(Barcode.refname) || name.equals(Barcode.shortname))
					barcodes = JPU.addToList(barcodes, new Barcode(element));
				else if (name.equals(DescriptiveDetail.refname) || name.equals(DescriptiveDetail.shortname))
					descriptiveDetail = new DescriptiveDetail(element);
				else if (name.equals(CollateralDetail.refname) || name.equals(CollateralDetail.shortname))
					collateralDetail = new CollateralDetail(element);
				else if (name.equals(ContentDetail.refname) || name.equals(ContentDetail.shortname))
					contentDetail = new ContentDetail(element);
				else if (name.equals(PublishingDetail.refname) || name.equals(PublishingDetail.shortname))
					publishingDetail = new PublishingDetail(element);
				else if (name.equals(RelatedMaterial.refname) || name.equals(RelatedMaterial.shortname))
					relatedMaterial = new RelatedMaterial(element);
				else if (name.equals(ProductSupply.refname) || name.equals(ProductSupply.shortname))
					productSupplys = JPU.addToList(productSupplys, new ProductSupply(element));
			}
		});
	}

	public String getRecordReferenceValue()
	{
		return (recordReference == null) ? null : recordReference.value;
	}

	public NotificationOrUpdateTypes getNotificationTypeValue()
	{
		return (notificationType == null) ? null : notificationType.value;
	}

	public List<String> getDeletionTextValues()
	{
		if (deletionTexts != null)
		{
			List<String> list = new ArrayList<>();
			for (DeletionText i : deletionTexts)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public RecordSourceTypes getRecordSourceTypeValue()
	{
		return (recordSourceType == null) ? null : recordSourceType.value;
	}

	public String getRecordSourceNameValue()
	{
		return (recordSourceName == null) ? null : recordSourceName.value;
	}

	public JonixRecordSourceIdentifier findRecordSourceIdentifier(NameCodeTypes recordSourceIDType)
	{
		if (recordSourceIdentifiers != null)
		{
			for (RecordSourceIdentifier x : recordSourceIdentifiers)
			{
				if (x.getRecordSourceIDTypeValue() == recordSourceIDType)
					return x.asJonixRecordSourceIdentifier();
			}
		}
		return null;
	}

	public List<JonixRecordSourceIdentifier> findRecordSourceIdentifiers(java.util.Set<NameCodeTypes> recordSourceIDTypes)
	{
		if (recordSourceIdentifiers != null)
		{
			List<JonixRecordSourceIdentifier> matches = new ArrayList<>();
			for (RecordSourceIdentifier x : recordSourceIdentifiers)
			{
				if (recordSourceIDTypes == null || recordSourceIDTypes.contains(x.getRecordSourceIDTypeValue()))
					matches.add(x.asJonixRecordSourceIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixProductIdentifier findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asJonixProductIdentifier();
			}
		}
		return null;
	}

	public List<JonixProductIdentifier> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<JonixProductIdentifier> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asJonixProductIdentifier());
			}
			return matches;
		}
		return null;
	}
}
