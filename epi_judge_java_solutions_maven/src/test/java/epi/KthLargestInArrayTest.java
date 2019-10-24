package epi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KthLargestInArrayTest {

    @Test
    public void partitionAroundPivotForTest()
    {
        List<Integer> A = new ArrayList<Integer>( Arrays.asList(5, 3, 1, 7, 2, 4) );

        int result = KthLargestInArray.partitionAroundPivotForTest(0, 5, 5, A, (a, b) -> Integer.compare(b, a));

        assertEquals(2, result);
    }

}