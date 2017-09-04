package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BaseInfo;

/**
 * ONIX3 concrete implementation for {@link BaseInfo}
 *
 * @author Zach Melamed
 */
public class BaseInfo3 extends BaseInfo {
    private static final long serialVersionUID = 1L;

    public BaseInfo3(Product product) {
        recordReference = product.recordReference().value;
        notificationType = product.notificationType().value;
        productIds = product.productIdentifiers().asStructs();
    }
}
