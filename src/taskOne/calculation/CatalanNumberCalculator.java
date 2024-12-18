package taskOne.calculation;

import java.math.BigInteger;

public class CatalanNumberCalculator {

    // Method for calculating the factorial of a number
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Method for calculating the Nth Catalan number
    public static BigInteger calculate(int N) {
        if (N == 0) {
            return BigInteger.ONE;
        }
        BigInteger numerator = factorial(2 * N); // Calculates the numerator: (2N)!
        BigInteger denominator = factorial(N + 1).multiply(factorial(N)); // Calculates the denominator: (N+1)! * N!
        return numerator.divide(denominator); // Computes C_N = (2N)! / [(N+1)! * N!]
    }
}