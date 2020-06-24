package epi;

import epi.test_framework.GenericTestHandler;
import epi.test_framework.TestOutput;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


@Slf4j
public class BuyAndSellStockTwiceTest {
    static String testDataFile = null;
    static List<List<String>> testData = null;
    static List<String> testColumns = null;
    static Method func = null;
    static List<Type> paramTypes = null;
    static List<SerializationTraits> paramTraits = null;
    static Boolean hasExecutionHook = false;

    @BeforeClass
    public static void setup() throws URISyntaxException, NoSuchMethodException {
        testDataFile = TestUtils.getTestDataFile(BuyAndSellStockTwice.class);
        testData = TestUtils.splitTsvFile(testDataFile);
        testColumns = TestUtils.getColumns(testData);
        func = BuyAndSellStockTwice.class.getDeclaredMethod("buyAndSellStockTwice", List.class);
        paramTypes = List.of(func.getGenericParameterTypes());

        if (paramTypes.size() >= 1 &&
                paramTypes.get(0).equals(TimedExecutor.class)) {
            hasExecutionHook = true;
            paramTypes = paramTypes.subList(1, paramTypes.size());
        }
        paramTraits = paramTypes.stream()
                .map(TraitsFactory::getTraits)
                .collect(Collectors.toList());
    }

    @Test
    public void buyAndSellStockTwice() throws Exception {

        GenericTestHandler genericTestHandler = new GenericTestHandler(
                func
                , null, null)
                ;
        //genericTestHandler.parseSignature(testColumns);
        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            List<Object> parsed = TestUtils.getParsed(paramTraits, testCase, 1000L);
            //List<Object> parsed = genericTestHandler.getParsed(testCase, 1000L);

            Double result = (Double) func.invoke(null, parsed.toArray());
            Double expected = Double.valueOf(testCase.get(testCase.size()-1));
            assertEquals(expected, result, 0.000001);
            log.debug("{} {}", expected, result);
            //TestOutput output = genericTestHandler.runTest(1000L, testCase);

        }

    }
}