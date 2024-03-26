package test_concepts;

import java.util.InvalidPropertiesFormatException;

public class Calculator {

    private int addTwoNums(int a, int b) {
        return a + b;
    }

    public void checkNums(Object a, Object b) throws InvalidPropertiesFormatException {
        if (!(a instanceof Integer && b instanceof Integer)) {
            throw new InvalidPropertiesFormatException("Please pass valid args");
        }
    }

    public int calls_private_method(int a, int b) {
        return addTwoNums(a, b);
    }

    public void method_with_params(int a) {
        a += 10;
    }
}
