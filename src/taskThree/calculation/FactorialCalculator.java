package taskThree.calculation;

import java.math.BigInteger;

public class FactorialCalculator {
    // Method for calculating the factorial of a number
    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
