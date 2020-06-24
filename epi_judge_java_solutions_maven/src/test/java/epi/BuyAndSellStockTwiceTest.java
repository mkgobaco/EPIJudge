package epi;

import epi.test_framework.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;


@Slf4j
public class BuyAndSellStockTwiceTest extends BaseTest {

    static Class testClass = BuyAndSellStockTwice.class;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException {
        setup(testClass);
    }

    @Test
    public void buyAndSellStockTwice() throws Exception {

        Method func = testClass.getDeclaredMethod("buyAndSellStockTwice", List.class);

        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            Double result = (Double) TestUtils.runTest(func, testCase, timeoutSeconds);
            Double expected = Double.valueOf(testCase.get(testCase.size()-1));
            assertEquals(expected, result, 0.000001);
            //log.debug("{} {}", expected, result);

        }

    }
}