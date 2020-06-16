package epi.test_framework;

import epi.AbsentValueArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtilsTest {

    @Test
    public void getTestDataFile() {
        String testDataFile = TestUtils.getTestDataFile(AbsentValueArray.class);
        assertEquals("absent_value_array.tsv", testDataFile);
    }
}