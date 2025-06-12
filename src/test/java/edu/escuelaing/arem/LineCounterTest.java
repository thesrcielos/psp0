package edu.escuelaing.arem;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class LineCounterTest {
    @Test
    public void testPhysicalLines() throws IOException {
        Path path = Paths.get("src/test/resources/TestFile1.java");
        int count = LineCounter.countPhysicalLines(path);
        assertEquals(10, count);
    }

    @Test
    public void testLogicalLines() throws IOException {
        Path path = Paths.get("src/test/resources/TestFile1.java");
        int count = LineCounter.countLogicalLines(path);
        assertEquals(5, count);
    }

    @Test
    public void testPhysicalLinesFile2() throws IOException {
        Path path = Paths.get("src/test/resources/TestFile2.java");
        int count = LineCounter.countPhysicalLines(path);
        assertEquals(15, count);
    }

    @Test
    public void testLogicalLinesFile2() throws IOException {
        Path path = Paths.get("src/test/resources/TestFile2.java");
        int count = LineCounter.countLogicalLines(path);
        assertEquals(8, count);
    }

}
