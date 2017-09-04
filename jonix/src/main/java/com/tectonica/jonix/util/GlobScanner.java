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

/**
 * @author Zach Melamed
 * @since 9/3/2017
 */
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
