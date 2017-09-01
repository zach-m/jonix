package com.tectonica.jonix.basic;

import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.List;

/**
 * Bundles together some general information included in an ONIX product
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicInfo implements Serializable {
    public String recordReference;
    public NotificationOrUpdateTypes notificationType;
    public List<JonixProductIdentifier> productIds;

    public String findProductId(ProductIdentifierTypes requestedType) {
        JonixProductIdentifier jonixProductId = findJonixProductId(requestedType);
        return (jonixProductId == null) ? null : jonixProductId.idValue;
    }

    public JonixProductIdentifier findJonixProductId(ProductIdentifierTypes requestedType) {
        if (productIds != null) {
            for (JonixProductIdentifier pid : productIds) {
                if (pid.productIDType == requestedType) {
                    return pid;
                }
            }
        }
        return null;
    }
}
