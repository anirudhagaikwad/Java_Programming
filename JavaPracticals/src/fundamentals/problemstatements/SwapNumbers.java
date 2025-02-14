package fundamentals.problemstatements;

public class SwapNumbers {
    public static void swap(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        swap(10, 20);
    }
}
