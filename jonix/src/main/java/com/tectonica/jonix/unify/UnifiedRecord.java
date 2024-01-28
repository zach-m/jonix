/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.JonixSource;

public class UnifiedRecord<P extends UnifiedProduct> {
    private final JonixRecord rawRecord;
    public final JonixSource source;
    public final P product;

    public UnifiedRecord(JonixRecord rawRecord, P product) {
        this.rawRecord = rawRecord;
        this.source = rawRecord.source;
        this.product = product;
    }

    /**
     * call this method to stop streaming products from the current source, and move on to the next one (if listed)
     */
    public void breakCurrentSource() {
        rawRecord.breakCurrentSource();
    }

    /**
     * call this method to stop streaming products from current as well as the next sources (if listed)
     */
    public void breakStream() {
        rawRecord.breakStream();
    }

    /**
     * Stores an object for later use during the streaming process. The stored object can be retrieved with
     * {@link #retrieve(String)}.
     */
    public <T> UnifiedRecord<P> store(String key, T value) {
        rawRecord.store(key, value);
        return this;
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming, or {@code null} if the
     *     {@code key} doesn't exist
     */
    public <T> T retrieve(String key) {
        return rawRecord.retrieve(key);
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming, or {@code defaultValue} if the
     *     {@code key} doesn't exist
     */
    public <T> T retrieve(String key, T defaultValue) {
        return rawRecord.retrieve(key, defaultValue);
    }

    @Override
    public String toString() {
        return String.format("{source=%s, product=%s}", source, product);
    }
}
