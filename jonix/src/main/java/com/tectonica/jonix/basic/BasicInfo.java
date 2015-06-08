package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/**
 * Bundles together some general information included in an ONIX product
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Product} or a
 * {@link com.tectonica.jonix.onix3.Product}.
 * 
 * @author Zach Melamed
 */
public class BasicInfo implements Serializable
{
	private static final long serialVersionUID = 1L;

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
		if (productIds != null)
		{
			for (JonixProductIdentifier pid : productIds)
			{
				if (pid.productIDType == requestedType)
					return pid;
			}
		}
		return null;
	}
}
