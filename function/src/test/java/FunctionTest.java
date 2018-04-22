import com.gost.group.CalculatedFunction;
import com.gost.group.Factorial;
import com.gost.group.ParallelStreamFactorial;
import org.junit.*;

import java.math.BigInteger;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class FunctionTest {
    private BiFunction сalculatedFunction;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before NumberPrinterTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After NumberPrinterTest.class");
    }

    @Before
    public void initTest() {
        сalculatedFunction = new CalculatedFunction();
    }

    @Test
    public void testFactorial() throws Exception {
        Factorial factorial = new ParallelStreamFactorial();
        assertEquals(BigInteger.ONE, factorial.calculate(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() throws Exception {
        Factorial factorial = new ParallelStreamFactorial();
        factorial.calculate(-5);
    }

    @Test
    public void testCalculatedFunction() throws Exception {
        Factorial factorial = new ParallelStreamFactorial();
        CalculatedFunction calculatedFunction = new CalculatedFunction(factorial);
        assertEquals(BigInteger.valueOf(35), calculatedFunction.apply(7l, 3l));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatedFunctionWrongArgument() throws Exception {
        Factorial factorial = new ParallelStreamFactorial();
        CalculatedFunction calculatedFunction = new CalculatedFunction(factorial);
        calculatedFunction.apply(5l, 6l);
    }

}
