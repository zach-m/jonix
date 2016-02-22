package com.tectonica.jonix.basic;

import com.tectonica.jonix.basic.BasicInfo;
import com.tectonica.jonix.onix3.Product;

/**
 * ONIX3 concrete implementation for {@link BasicInfo}
 * 
 * @author Zach Melamed
 */
public class BasicInfo3 extends BasicInfo
{
	private static final long serialVersionUID = 1L;

	public BasicInfo3(Product product)
	{
		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();
		productIds = product.findProductIdentifiers(null);
	}
}
