package epi;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BstFromPreorderTest {

    @Test
    public void rebuildBSTFromPreorder() {
        BstNode<Integer> root =  BstFromPreorder.rebuildBSTFromPreorder(Arrays.asList(new Integer[]{1, 2, 3}));
        assertNotNull(root);
    }
}