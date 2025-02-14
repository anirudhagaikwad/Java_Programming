package fundamentals.problemstatements;

public class CompoundInterestCalculator {
    public static double calculateCompoundInterest(double principal, double rate, int time, int n) {
        return principal * Math.pow((1 + rate / (n * 100)), n * time);
    }

    public static void main(String[] args) {
        double principal = 1000, rate = 5;
        int time = 2, n = 4; // Compounded quarterly
        System.out.println("Compound Interest: " + calculateCompoundInterest(principal, rate, time, n));
    }
}

