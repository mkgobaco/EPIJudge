package epi;

import epi.test_framework.TestUtils;
import epi.test_framework.TimedExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class BstFromSortedArrayTest extends BaseTest{

    static Class testClass = BstFromSortedArray.class;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException {
        setup(testClass);
    }

    @Test
    public void buildMinHeightBSTFromSortedArrayWrapper() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method func = testClass.getDeclaredMethod("buildMinHeightBSTFromSortedArrayWrapper",
                TimedExecutor.class, List.class);

        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            Integer result = (Integer) TestUtils.runTest(func, testCase, timeoutSeconds);
            String expected = testCase.get(testCase.size()-1);
            //SerializationTraits retValueTraits = TraitsFactory.getTraits(func.getGenericReturnType());
            assertEquals(Integer.valueOf(expected), result);
            log.debug("expected={}", Integer.valueOf(expected));
            log.debug("actual  ={}", result);

        }
    }
}