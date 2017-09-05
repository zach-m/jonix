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

package com.tectonica.jonix.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

public class GlobScanner {
    public static List<File> scan(File folder, String glob, boolean recursive) throws IOException {
        FileSystem fs = folder.toPath().getFileSystem();
        final PathMatcher matcher = (glob == null || glob.equals("*")) ? null : fs.getPathMatcher("glob:" + glob);

        List<File> files = new ArrayList<>();
        internalScan(folder, matcher, files, recursive);
        return files;
    }

    private static void internalScan(File parentDirectory, PathMatcher matcher, List<File> files, boolean recursive)
        throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(parentDirectory.toPath())) {
            for (Path path : paths) {
                File file = path.toFile();
                if (file.isDirectory()) {
                    if (recursive) {
                        internalScan(file, matcher, files, true);
                    }
                } else {
                    if (matcher == null || matcher.matches(path.getFileName())) {
                        files.add(file);
                    }
                }
            }
        }
    }
}
