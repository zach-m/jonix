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

package com.tectonica.jonix;

import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.OnixVersion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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
    private final JonixRecords records;

    /**
     * Mandatory, non-null member, represented by this source (even it the user passed a {@link File} object)
     */
    public final InputStream stream;

    /**
     * The {@link File} represented by this source (possibly <code>null</code> if {@link InputStream} was used
     * directly)
     */
    public final File file;

    // set externally AFTER construction
    OnixVersion onixVersion;

    String onixRelease;

    // set externally AFTER construction (if available)
    OnixHeader header;

    /**
     * Per-source key-value store, for the convenience of the user when processing multiple sources. Can be read-from
     * and written-to with {@link #retrieve(String)} and {@link #store(String, Object)}.
     */
    private Map<String, Object> sourceDict;

    // internal, packaged-protected variable, managed during iteration over the source
    AtomicInteger sourceProductCount = new AtomicInteger(0);

    JonixSource(InputStream stream, JonixRecords records) {
        this.records = Objects.requireNonNull(records);
        this.file = null;
        this.stream = Objects.requireNonNull(stream);
    }

    JonixSource(File file, JonixRecords records) throws IOException {
        this.records = Objects.requireNonNull(records);
        this.file = Objects.requireNonNull(file);
        this.stream = Files.newInputStream(file.toPath());
    }

    public boolean isStreamBased() {
        return (file == null);
    }

    /**
     * @return the absolute path of the file (if this source pertains to a file), or some text label representing the
     *     stream if {@link #isStreamBased()}.
     */
    public String getAbsoluteFilePath() {
        return file != null ? file.getAbsolutePath() : stream.toString();
    }

    public Optional<OnixHeader> header() {
        return Optional.ofNullable(header);
    }

    public OnixVersion onixVersion() {
        return onixVersion;
    }

    public String onixRelease() {
        return onixRelease;
    }

    /**
     * @return the ordinal number of the current product, counting from the beginning of this source
     */
    public int productCount() {
        return sourceProductCount.get();
    }

    /**
     * @return the ordinal number of the current product, counting from the beginning of this stream
     */
    public int productGlobalCount() {
        return records.globalProductCount.get();
    }

    /**
     * Call this in an event triggered by {@code .onSourceStart()} if you wish to skip the current source and move on to
     * the next one
     */
    public void skipSource() {
        records.skipSourceRequested = true;
    }

    /**
     * Stores an object for later use during the streaming OF THIS SOURCE (as opposed to the more general
     * {@link JonixRecords#store(String, Object)} which stores an object for use throughout the entire streaming). The
     * stored object can be retrieved with {@link #retrieve(String)}.
     */
    public <T> JonixSource store(String key, T value) {
        if (sourceDict == null) {
            sourceDict = new HashMap<>();
        }
        sourceDict.put(key, value);
        return this;
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming of the current source, or
     *     {@code null} if the {@code key} doesn't exist
     */
    public <T> T retrieve(String key) {
        if (sourceDict == null) {
            return null;
        }
        return (T) sourceDict.get(key);
    }

    /**
     * @return an object stored with {@link #store(String, Object)} during the streaming of the current source, or
     *     {@code defaultValue} if the {@code key} doesn't exist
     */
    public <T> T retrieve(String key, T defaultValue) {
        if (sourceDict == null) {
            return null;
        }
        return (T) sourceDict.getOrDefault(key, defaultValue);
    }

    @Override
    public String toString() {
        return String.format("[%s / %s]", onixVersion, (file == null) ? "<stream>" : file.getAbsolutePath());
    }
}
