package epi;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HanoiTest {

    @Test
    public void computeTowerHanoi() {
        List<List<Integer>> table = Hanoi.computeTowerHanoi(10);
        /*
        int count=0;
        for (List<Integer> row: table) {
            System.out.print(count+":");
            for (Integer cell: row) {
                System.out.print(cell);
                System.out.print(" ");
            }
            System.out.println();
            count++;
        }
         */
        assertEquals(1, table.get(100).get(0).intValue());
        assertEquals(0, table.get(100).get(1).intValue());
    }
}