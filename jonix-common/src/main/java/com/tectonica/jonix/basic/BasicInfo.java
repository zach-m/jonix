package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/**
 * Bundles together some general information included in an ONIX product
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 * 
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicInfo implements Serializable
{
	public String recordReference;
	public NotificationOrUpdateTypes notificationType;
	public List<JonixProductIdentifier> productIds;

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
