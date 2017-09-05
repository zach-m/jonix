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

package com.tectonica.jonix.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple extension of {@link JonixStreamer} that adds some APIs for handling ONIX sources stored in files and
 * directories (and not just {@link InputStream} as the parent). It accepts file names and file lists, as well as
 * directory names for pattern-based scanning.
 * <p>
 * In its constructor it takes a {@link JonixFilesExtractor} which is a corresponding extension to the basic {@link
 * JonixExtractor}, adding file-related events.
 *
 * @author Zach Melamed
 */
public class JonixFilesStreamer extends JonixStreamer {
    public JonixFilesStreamer(JonixFilesExtractor extractor) {
        super(extractor);
    }

    private JonixFilesExtractor extractor() {
        return (JonixFilesExtractor) extractor;
    }

    // /////////////////////////////////////////////////////////////////////////////

    public void read(final String fileName) {
        read(fileName, extractor().onGetFileEncoding(fileName, this));
    }

    public void read(final String fileName, String encoding) {
        final FileInputStream fos;
        try {
            fos = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            LOG.error("Couldn't read from '" + fileName + "', encoding: " + encoding, e);
            throw new RuntimeException(e);
        }
        read(fos, encoding); // outside the try{} to avoid double catching
    }

    public void read(List<String> fileNames) {
        if (extractor().onBeforeFileList(fileNames, this)) {
            List<String> processedFileNames = new ArrayList<>();
            for (String fileName : fileNames) {
                try {
                    if (!extractor().onBeforeFile(fileName, this)) {
                        continue;
                    }
                    read(fileName);
                    processedFileNames.add(fileName);
                } catch (Exception ignored) {
                    // we move on to the next file
                }
            }
            extractor().onAfterFileList(processedFileNames, this);
        }
    }

    /**
     * @param rootLocation may be a directory or a file
     * @param pattern      pattern of files to be included, provided in 'glob' format
     */
    public void readFolder(final String rootLocation, final String pattern) {
        try {
            read(findFiles(rootLocation, pattern));
        } catch (IOException e) {
            LOG.error("Couldn't read folder '" + rootLocation + "', pattern: " + pattern, e);
            throw new RuntimeException(e);
        }
    }

    public static List<String> findFiles(final String rootLocation, final String pattern) throws IOException {
        final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        final List<String> fileNames = new ArrayList<>();
        Files.walkFileTree(Paths.get(rootLocation), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path name = file.getFileName();
                if (name != null && matcher.matches(name)) {
                    fileNames.add(file.toAbsolutePath().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return fileNames;
    }
}
