package com.tectonica.jonix.basic;

import com.tectonica.jonix.onix2.Product;

/**
 * ONIX2 concrete implementation for {@link BasicInfo}
 *
 * @author Zach Melamed
 */
public class BasicInfo2 extends BasicInfo {
    private static final long serialVersionUID = 1L;

    public BasicInfo2(Product product) {
        recordReference = product.recordReference().value;
        notificationType = product.notificationType().value;
        productIds = product.productIdentifiers().asStructs(); // TODO: lazy
    }
}
