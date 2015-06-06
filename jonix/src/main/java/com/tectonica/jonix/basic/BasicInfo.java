package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

@SuppressWarnings("serial")
public class BasicInfo implements Serializable
{
	public final String recordReference;
	public final NotificationOrUpdateTypes notificationType;
	public final List<JonixProductIdentifier> productIds;

	public BasicInfo(com.tectonica.jonix.onix2.Product product)
	{
		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();
		productIds = product.findProductIdentifiers(null);
	}

	public BasicInfo(com.tectonica.jonix.onix3.Product product)
	{
		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();
		productIds = product.findProductIdentifiers(null);
	}

	public JonixProductIdentifier findProductId(ProductIdentifierTypes requestedType)
	{
		for (JonixProductIdentifier pid : productIds)
		{
			if (pid.productIDType == requestedType)
				return pid;
		}
		return null;
	}
}
