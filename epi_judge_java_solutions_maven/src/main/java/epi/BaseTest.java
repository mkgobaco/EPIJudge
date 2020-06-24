package epi;

import epi.test_framework.TestUtils;
import org.junit.BeforeClass;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

public class BaseTest {

    static List<List<String>> testData = null;
    static Long timeoutSeconds = 1000L;

    public static void setup(Class testClass) throws URISyntaxException {
        testData = TestUtils.getTestData(testClass);

    }
}
