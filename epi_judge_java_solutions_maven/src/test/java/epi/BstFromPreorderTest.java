package epi;

import epi.test_framework.TestUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BstFromPreorderTest {

    static String testDataFile = null;
    static List<List<String>> testData = null;

    @BeforeClass
    public static void setup() throws URISyntaxException {
        testDataFile = TestUtils.getTestDataFile(BstFromPreorder.class);
        testData = TestUtils.splitTsvFile(testDataFile);
    }

    @Test
    public void getTestDataFile()
    {
        assertEquals("bst_from_preorder.tsv", testDataFile);
    }

    @Test
    public void rebuildBSTFromPreorder() {
        BstNode<Integer> root =  BstFromPreorder.rebuildBSTFromPreorder(Arrays.asList(new Integer[]{1, 2, 3}));
        assertNotNull(root);
    }
}