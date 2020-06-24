package epi;

import epi.test_framework.GenericTestHandler;
import epi.test_framework.TestUtils;
import epi.test_framework.TimedExecutor;
import epi.test_framework.serialization_traits.SerializationTraits;
import epi.test_framework.serialization_traits.TraitsFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


@Slf4j
public class BuyAndSellStockTwiceTest {

    static Class testClass = BuyAndSellStockTwice.class;
    static String testDataFile = null;
    static List<List<String>> testData = null;
    static List<String> testColumns = null;
    static Method func = null;

    @BeforeClass
    public static void setup() throws URISyntaxException, NoSuchMethodException {
        testDataFile = TestUtils.getTestDataFile(testClass);
        testData = TestUtils.splitTsvFile(testDataFile);
        testColumns = TestUtils.getColumns(testData);
        func = BuyAndSellStockTwice.class.getDeclaredMethod("buyAndSellStockTwice", List.class);
    }

    @Test
    public void buyAndSellStockTwice() throws Exception {

        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            Double result = (Double) TestUtils.runTest(func, testCase);
            Double expected = Double.valueOf(testCase.get(testCase.size()-1));
            assertEquals(expected, result, 0.000001);
            //log.debug("{} {}", expected, result);

        }

    }
}