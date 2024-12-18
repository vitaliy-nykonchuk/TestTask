package taskThree.app;

import taskThree.calculation.FactorialCalculator;
import taskThree.digits.DigitSumCalculator;

import java.math.BigInteger;

public class FactorialSumApp {

    // Method that runs the entire program
    public static void runApp() {
        int N = 100; // Static value for N

        // Calculating the factorial
        BigInteger factorial = FactorialCalculator.calculateFactorial(N);

        // Calculating the sum of digits in a factorial
        int sumOfDigits = DigitSumCalculator.calculateSumOfDigits(factorial.toString());

        // Outputting the result
        System.out.println("The sum of the digits in " + N + "! is: " + sumOfDigits);
    }
}