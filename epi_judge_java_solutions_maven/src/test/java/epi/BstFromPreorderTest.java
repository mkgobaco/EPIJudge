package epi;

import epi.test_framework.TestUtils;
import epi.test_framework.serialization_traits.SerializationTraits;
import epi.test_framework.serialization_traits.TraitsFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class BstFromPreorderTest extends BaseTest{

    static Class testClass = BstFromPreorder.class;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException {
        setup(testClass);
    }

    @Test
    public void rebuildBSTFromPreorder1() {
        BstNode<Integer> root =  BstFromPreorder.rebuildBSTFromPreorder(Arrays.asList(new Integer[]{1, 2, 3}));
        assertNotNull(root);
    }

    @Test
    public void rebuildBSTFromPreorder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method func = testClass.getDeclaredMethod("rebuildBSTFromPreorder", List.class);

        for (int ii = 1; ii < testData.size(); ii++) {
            List<String> testCase = testData.get(ii);
            testCase = testCase.subList(0, testCase.size()-1);

            BstNode result = (BstNode) TestUtils.runTest(func, testCase, timeoutSeconds);
            String expected = testCase.get(testCase.size()-1);
            SerializationTraits retValueTraits = TraitsFactory.getTraits(func.getGenericReturnType());
            assertEquals(retValueTraits.parse(expected), result);
            log.debug("expected={}", retValueTraits.parse(expected));
            log.debug("actual  ={}", result);

        }
    }
}