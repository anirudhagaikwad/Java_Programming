package PPT6;
// write a java program to check power of four using while loop
class JavaProgram5 {
    public static boolean isPowerOfFour(int n) {
        double hi = n;
        while (hi > 1) {
            hi /= 4;
        }
        return hi == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}

