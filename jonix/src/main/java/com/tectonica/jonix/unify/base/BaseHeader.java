/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.tectonica.jonix.Jonix;
import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.unify.UnifiedHeader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the essential information included in ONIX &lt;Header&gt;.
 * <p>
 * Provided as part of the 'base' suite of classes whose goal is to extract the most important information from an ONIX
 * source (be it ONIX2 or ONIX3) and make it available for other various uses (print in a tabular format, etc.). The
 * classes of the 'basic' bridge the gap between ONIX versions, and provide a unified view of the content, allowing the
 * user to write a version-agnostic code.
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
public abstract class BaseHeader extends UnifiedHeader {
    public String senderName;
    public String senderContactName;
    public String senderEmail;
    public List<String> addressees;
    public String sentDateTime;

    public BaseHeader(OnixHeader rawHeader) {
        super(rawHeader);
    }

    public static BaseHeader headerOf(String onixFileName) {
        List<BaseHeader> holder = new ArrayList<>(1);
        Jonix.source(new File(onixFileName))
            .onSourceStart(src -> src.header().map(Jonix::toBaseHeader).ifPresent(holder::add)).scanHeaders();
        return holder.isEmpty() ? null : holder.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SenderName:        ").append(senderName).append("\n");
        sb.append("SenderContactName: ").append(senderContactName).append("\n");
        sb.append("SenderEmail:       ").append(senderEmail).append("\n");
        sb.append("Addressees:        ").append(addressees).append("\n");
        sb.append("SentDateTime:      ").append(sentDateTime);
        return sb.toString();
    }
}
