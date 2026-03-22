import Zad1_2.Calculator;
import Zad1_2.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void testDivide() {
        int result = Calculator.divide(4,2);

        assertEquals(2,result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10,0));
    }

    @Test
    public void testDivideWithException() {
        assertThrows(DivisionByZeroException.class, () -> Calculator.divideWithException(10,0));
    }

    @Test
    public void testExceptionMessage() {
        DivisionByZeroException exception = assertThrows(DivisionByZeroException.class, () -> {
            Calculator.divideWithException(10, 0);
        });
        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void testIsAdult() {
        assertEquals(true, Calculator.isAdult(18));
        assertEquals(true, Calculator.isAdult(25));

        assertEquals(false, Calculator.isAdult(17));
        assertEquals(false, Calculator.isAdult(10));
    }
}
