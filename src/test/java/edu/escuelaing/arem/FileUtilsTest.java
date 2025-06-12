package edu.escuelaing.arem;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.Assert.*;


public class FileUtilsTest {

    @Test
    public void testFindJavaFilesReturnsCorrectFiles() throws IOException {
        Path tempDir = Files.createTempDirectory("test-dir");
        Path javaFile1 = Files.createFile(tempDir.resolve("Example1.java"));
        Path javaFile2 = Files.createFile(tempDir.resolve("Example2.java"));
        Path txtFile = Files.createFile(tempDir.resolve("notJava.txt"));

        List<Path> javaFiles = FileUtils.findJavaFiles(tempDir.toString());

        assertEquals(2, javaFiles.size());
        assertTrue(javaFiles.contains(javaFile1));
        assertTrue(javaFiles.contains(javaFile2));
        assertFalse(javaFiles.contains(txtFile));

        Files.deleteIfExists(javaFile1);
        Files.deleteIfExists(javaFile2);
        Files.deleteIfExists(txtFile);
        Files.deleteIfExists(tempDir);
    }

}