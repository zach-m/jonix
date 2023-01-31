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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.PublishingRoles;
import com.tectonica.jonix.unify.base.util.LazyList;

import java.util.List;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;Publisher&gt; that may exist in an ONIX Product
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasePublishers extends LazyList<BasePublisher> {
    public String getMainPublisher() {
        BasePublisher candidatePublisher = null;
        // first we look for the main publisher by its role
        for (BasePublisher publisher : this) {
            PublishingRoles role = publisher.publishingRole;
            if (role == PublishingRoles.Publisher) {
                return publisher.publisherName;
            }
            if (role == null && candidatePublisher == null) {
                candidatePublisher = publisher;
            }
        }
        // if no designated publisher found, we return the first un-designated
        if (candidatePublisher != null) {
            return candidatePublisher.publisherName;
        }
        return null;
    }
}
