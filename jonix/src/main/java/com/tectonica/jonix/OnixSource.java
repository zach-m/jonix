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

public class OnixSource {
    final InputStream stream;

    public final Optional<File> file;
    public OnixVersion onixVersion;
    public Optional<OnixHeader> header = Optional.empty();
    public final Map<String, Object> config = new HashMap<>();

    OnixSource(InputStream stream) {
        this.stream = Objects.requireNonNull(stream);
        this.file = Optional.empty();
    }

    OnixSource(File file) throws FileNotFoundException {
        this.stream = new FileInputStream(file);
        this.file = Optional.of(file);
    }

    public boolean isStreamBased() {
        return (!file.isPresent());
    }

    public String getSourceName() {
        return file.map(File::getAbsolutePath).orElse(stream.toString());
    }
}
