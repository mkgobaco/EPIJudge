package epi.test_framework;

import epi.AbsentValueArray;
import org.junit.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class TestUtilsTest {

    @Test
    public void getTestDataFile() {
        String testDataFile = TestUtils.getTestDataFile(AbsentValueArray.class);
        assertEquals("absent_value_array.tsv", testDataFile);
    }

    @Test
    public void splitTsvFile() throws URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource("absent_value_array.tsv").toURI());
        List<List<String>> testData = TestUtils.splitTsvFile(path);
        assertNotNull(testData);
    }

    @Test
    public void splitTsvFileAsResource() throws URISyntaxException {
        List<List<String>> testData = TestUtils.splitTsvFile("absent_value_array.tsv");
        assertNotNull(testData);
    }

}