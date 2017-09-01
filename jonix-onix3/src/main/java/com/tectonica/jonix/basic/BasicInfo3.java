package com.tectonica.jonix.basic;

import com.tectonica.jonix.onix3.Product;

/**
 * ONIX3 concrete implementation for {@link BasicInfo}
 *
 * @author Zach Melamed
 */
public class BasicInfo3 extends BasicInfo {
    private static final long serialVersionUID = 1L;

    public BasicInfo3(Product product) {
        recordReference = product.recordReference().value;
        notificationType = product.notificationType().value;
        productIds = product.productIdentifiers().asStructs();
    }
}
