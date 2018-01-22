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

package com.tectonica.jonix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a source (either a {@link File} or an {@link InputStream}) containing ONIX records.
 * <p>
 * While iterating over records with {@link JonixRecords}, this object is accessible via the {@link JonixRecord#source}
 * passed to the caller with each ONIX record. It can be used to query the details of the current source, such as its
 * (auto-detected) ONIX version, its ONIX Header (if provided), and of course the file/stream behind it.
 * <p>
 * Also, it provides a key-value map, that the caller can use during iteration for applicative purposes.
 */
public class JonixSource {
    // final and mandatory fields, representing the essence of the source

    /**
     * Mandatory, non-null member, represented by this source (even it the user passed a {@link File} object)
     */
    public final InputStream stream;

    /**
     * The {@link File} represented by this source (possibly <code>null</code> if {@link InputStream} was used directly)
     */
    public final File file;

    // set externally AFTER construction
    OnixVersion onixVersion;

    // set externally AFTER construction (if available)
    OnixHeader header;

    /**
     * Per-source key-value store, for the convenience of the user when processing multiple sources.
     * Can be read-from and written-to with {@link #configValue(String)} and {@link #configure(String, Object)}.
     */
    private Map<String, Object> localConfig;

    // internal, packaged-protected variable, managed during iteration over the source
    // TODO: this could be problematic in presence of concurrency and/or multiple-iterators. Currently not an issue
    // TODO: as this is a package-protected class, but Rethink a little.
    int productsProcessed = 0;

    JonixSource(InputStream stream) {
        this.stream = Objects.requireNonNull(stream);
        this.file = null;
    }

    JonixSource(File file) throws FileNotFoundException {
        this.stream = new FileInputStream(file);
        this.file = file;
    }

    public boolean isStreamBased() {
        return (file == null);
    }

    public String sourceName() {
        return file != null ? file.getAbsolutePath() : stream.toString();
    }

    public Optional<OnixHeader> header() {
        return Optional.ofNullable(header);
    }

    public OnixVersion onixVersion() {
        return onixVersion;
    }

    public int productsProcessedCount() {
        return productsProcessed;
    }

    public <T> JonixSource configure(String id, T value) {
        if (localConfig == null) {
            localConfig = new HashMap<>();
        }
        localConfig.put(id, value);
        return this;
    }

    public Object configValue(String id) {
        if (localConfig == null) {
            return null;
        }
        return localConfig.get(id);
    }
}
