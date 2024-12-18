package taskOne.app;

import taskOne.calculation.CatalanNumberCalculator;
import taskOne.input.UserInputHandler;

import java.math.BigInteger;

public class CatalanExpressionApp {

    // Method that runs the entire program
    public static void runApp() {

        // Reading input data
        int N = UserInputHandler.readInput();

        // Calculate the Catalan number
        BigInteger result = CatalanNumberCalculator.calculate(N);

        // Outputting the result
        System.out.println("The number of valid bracket expressions for N = " + N + " : " + result);
    }
}