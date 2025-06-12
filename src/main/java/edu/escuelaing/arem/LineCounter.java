package edu.escuelaing.arem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Utility class for counting lines in a source code file.
 *
 * <p>Provides methods to count:
 * <ul>
 *   <li>Physical lines: All lines in a file, including empty lines and comments.</li>
 *   <li>Logical lines of code (LOC): Non-empty, non-comment lines.</li>
 * </ul>
 *
 * <p>Note: This implementation does not fully parse block comments across multiple lines.
 * It only excludes lines starting with common comment prefixes.
 *
         * @author
 *     Diego Armando Macia Diaz
 */
public class LineCounter {

    /**
     * Counts the total number of physical lines in a given file.
     *
     * <p>This includes all lines regardless of whether they are blank, comments, or actual code.
     *
     * @param file the path to the source code file
     * @return the total number of lines in the file
     * @throws IOException if an I/O error occurs reading the file
     */
    public static int countPhysicalLines(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return (int) lines.count();
        }
    }

    /**
     * Counts the logical lines of code in a file. Logical lines exclude:
     * <ul>
     *   <li>Empty lines</li>
     *   <li>Lines starting with <code>//</code></li>
     *   <li>Lines starting with <code>/*</code>, <code>*</code> or <code>*&#47;</code></li>
            * </ul>
            *
            * @param file the path to the file
     * @return number of logical lines
     * @throws IOException if an I/O error occurs
     */
    public static int countLogicalLines(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return (int) lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .filter(line -> !line.startsWith("//"))
                    .filter(line -> !line.startsWith("/*") && !line.startsWith("*") && !line.startsWith("*/"))
                    .count();
        }
    }
}