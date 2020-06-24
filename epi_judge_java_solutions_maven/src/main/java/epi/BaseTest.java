package epi;

import epi.test_framework.TestUtils;
import org.junit.BeforeClass;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

public class BaseTest {

    static List<List<String>> testData = null;
    //static Class testClass = null;

    public static void setup(Class testClass) throws URISyntaxException, NoSuchMethodException {
        testData = TestUtils.getTestData(testClass);
    }
}
