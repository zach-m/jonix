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

public class JonixSource {
    // final and mandatory fields, representing the essence of the source
    public final InputStream stream;
    public final File file;

    // optional information, set after construction during iteration
    OnixVersion onixVersion;
    OnixHeader header;

    // for the convenience of the user // TODO: maybe add APIs? or have it lazily created?
    public final Map<String, Object> localConfig = new HashMap<>();

    // internal, packaged-protected variable, managed by the during iteration over the source
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

    public String getSourceName() {
        return file != null ? file.getAbsolutePath() : stream.toString();
    }

    public Optional<OnixHeader> header() {
        return Optional.ofNullable(header);
    }

    public Optional<OnixVersion> onixVersion() {
        return Optional.ofNullable(onixVersion);
    }

    public int productsProcessedCount() {
        return productsProcessed;
    }
}
