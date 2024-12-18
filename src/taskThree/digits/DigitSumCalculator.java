package taskThree.digits;

public class DigitSumCalculator {
    // Method for calculating the sum of digits in a string representation of a number
    public static int calculateSumOfDigits(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}
