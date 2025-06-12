package edu.escuelaing.arem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Main application class to count lines in Java source files.
 *
 * <p>This program is executed from the command line with two arguments:
 * <ul>
 *     <li><b>phy</b>: Count physical lines (including comments and blanks)</li>
 *     <li><b>loc</b>: Count logical lines of code (excluding comments and blanks)</li>
 * </ul>
 * followed by a path to a file or directory. If a directory is provided,
 * it will recursively process all <code>.java</code> files inside.
 *
 * <p><b>Example usage:</b>
 * <pre>
 *     java App phy src/
 *     java App loc MyClass.java
 * </pre>
 *
 * <p>Outputs the total count of lines matching the selected mode.
 *
 * @author
 *     Diego Armando Macia Diaz
 */
public class App {
    /**
     * Entry point for the line counting application.
     *
     * @param args command-line arguments: mode ("phy" or "loc") and path to a file or directory
     * @throws IOException if an I/O error occurs while reading files
     */
    public static void main( String[] args ) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java CountLines [phy|loc] <fileOrDirectory>");
            System.exit(1);
        }

        String mode = args[0];
        String path = args[1];
        List<Path> files = FileUtils.findJavaFiles(path);

        int total = 0;
        for (Path file : files) {
            if ("phy".equals(mode)) {
                total += LineCounter.countPhysicalLines(file);
            } else if ("loc".equals(mode)) {
                total += LineCounter.countLogicalLines(file);
            } else {
                System.err.println("Invalid mode: " + mode);
                System.exit(1);
            }
        }

        System.out.printf("Total %s: %d\n", mode.toUpperCase(), total);
    }

}