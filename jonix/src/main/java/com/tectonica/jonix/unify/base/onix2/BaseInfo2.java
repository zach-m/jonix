package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BaseInfo;

/**
 * ONIX2 concrete implementation for {@link BaseInfo}
 *
 * @author Zach Melamed
 */
public class BaseInfo2 extends BaseInfo {
    private static final long serialVersionUID = 1L;

    public BaseInfo2(Product product) {
        recordReference = product.recordReference().value;
        notificationType = product.notificationType().value;
        productIds = product.productIdentifiers().asStructs(); // TODO: lazy
    }
}
