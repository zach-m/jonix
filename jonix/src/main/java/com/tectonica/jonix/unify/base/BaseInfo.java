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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.List;

/**
 * Bundles together some general information included in an ONIX Product
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseInfo implements Serializable {
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
