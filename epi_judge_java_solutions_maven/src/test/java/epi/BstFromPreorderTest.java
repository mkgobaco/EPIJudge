package epi;

import epi.test_framework.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BstFromPreorderTest {

    String testDataFile = null;

    @Before
    public void setup()
    {
        testDataFile = TestUtils.getTestDataFile(BstFromPreorder.class);
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