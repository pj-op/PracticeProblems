package test_concepts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.InvalidPropertiesFormatException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@PrepareForTest(Calculator.class)
public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void test_addTwoNums() throws Exception {
        Calculator calculator1 = PowerMockito.mock(Calculator.class);
//        PowerMockito.when(calculator1,"addTwoNums").thenReturn(anyInt());
//        PowerMockito.verifyPrivate(calculator1).invoke("addTwoNums");
    }

    @Test
    public void test_addition() throws Exception {
        //when(calculator.calls_private_method(1, 2)).thenReturn(3);
        int res = calculator.calls_private_method(1, 2);
        assertEquals(3, res);
    }

    @Test
    public void test_throwingExceptionForInvalidArgs()
//            throws InvalidPropertiesFormatException
    {
        Assert.assertThrows(InvalidPropertiesFormatException.class, () -> calculator.checkNums(new String("1"), new String("2")));
//        calculator.checkNums(new String("1"), new String("2"));
    }

    @Test
    public void test_shouldNotThrowExceptionForValidArgs() throws InvalidPropertiesFormatException {
        calculator.checkNums(2, 4);
    }

    @Test(expected = InvalidPropertiesFormatException.class)
    public void test_throwingExceptionForInvalidArgs_withMock()
            throws InvalidPropertiesFormatException {
        Calculator calculator1 = mock(Calculator.class);
        doThrow(new InvalidPropertiesFormatException("test")).when(calculator1).checkNums(anyString(), anyString());
        calculator.checkNums(new String("1"), new String("2"));
    }

    @Test
    public void test_void_method_with_args() {
        /*Calculator calculator1 = mock(Calculator.class);
        doAnswer((ans) -> {
            assertEquals(Optional.of(10).get(), ans.getArgument(0));
            return null;
        }).when(calculator1).method_with_params(anyInt());*/

        int a = 10;
        calculator.method_with_params(a);
        assertEquals(10, a);
    }

}