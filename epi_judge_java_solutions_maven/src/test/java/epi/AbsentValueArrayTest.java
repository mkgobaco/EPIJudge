package epi;

import epi.test_framework.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class AbsentValueArrayTest extends BaseTest{

    static Class testClass = AbsentValueArray.class;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException, NoSuchMethodException {
        setup(testClass);
    }

    @Test
    public void findMissingElement() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method func = testClass.getDeclaredMethod("findMissingElement", Iterable.class);

        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            Integer result = (Integer) TestUtils.runTest(func, testCase);
            Integer expected = Integer.valueOf(testCase.get(testCase.size()-1));
            assertEquals(expected, result, 0.000001);
            log.debug("{} {}", expected, result);

        }
    }
}