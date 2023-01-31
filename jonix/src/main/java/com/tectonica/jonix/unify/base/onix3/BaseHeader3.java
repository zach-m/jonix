/*
 * Copyright (C) 2012-2023 Zach Melamed
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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.Addressee;
import com.tectonica.jonix.onix3.Header;
import com.tectonica.jonix.unify.base.BaseHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BaseHeader}
 *
 * @author Zach Melamed
 */
public class BaseHeader3 extends BaseHeader {
    private static final long serialVersionUID = 1L;

    public BaseHeader3(Header header) {
        extract(header, this);
    }

    public static void extract(Header header, BaseHeader dest) {
        dest.rawHeader = header;

        dest.fromCompany = header.sender().senderName().value;
        dest.fromPerson = header.sender().contactName().value;
        dest.fromEmail = header.sender().emailAddress().value;
        dest.toCompanies = extractToCompanies(header);
        dest.sentDate = header.sentDateTime().value;
    }

    private static List<String> extractToCompanies(Header header) {
        List<String> list = new ArrayList<>();
        for (Addressee addressee : header.addressees()) {
            String toCompany = addressee.addresseeName().value;
            if (toCompany != null) {
                list.add(toCompany);
            }
        }
        return list.size() > 0 ? list : null;
    }
}
