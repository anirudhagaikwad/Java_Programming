package fundamentals.problemstatements;

public class PowerCalculator {
    public static double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        System.out.println("Power: " + power(2, 5));
    }
}
