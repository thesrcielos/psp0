package edu.escuelaing.arem;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class for file-related operations.
 *
 * <p>Provides methods to search for Java source files within a directory
 * and its subdirectories.
 *
 * <p>Currently supports:
 * <ul>
 *   <li>Finding all <code>.java</code> files recursively in a given path.</li>
 * </ul>
 *
 * @author
 *     Diego Armando Macia Diaz
 */
public class FileUtils {

    /**
     * Recursively finds all Java source files under the given directory path.
     *
     * <p>Searches for files that end with ".java" and ensures they are regular files
     * (not directories or symbolic links).
     *
     * @param path the path to the root directory from which the search will begin
     * @return a list of {@link Path} objects representing Java source files
     * @throws IOException if the given path does not exist or an I/O error occurs
     */
    public static List<Path> findJavaFiles(String path) throws IOException {
        Path startPath = Paths.get(path);
        if (!Files.exists(startPath)) {
            throw new IOException("Path not found: " + path);
        }

        try (Stream<Path> stream = Files.walk(startPath)) {
            return stream
                    .filter(p -> p.toString().endsWith(".java"))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
    }
}