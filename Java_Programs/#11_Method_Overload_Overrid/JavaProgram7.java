package PPT11;

/*
create a method add() to add various data types values
* */

public class JavaProgram7 {
    //accept integer data value
    public static void add(int a, int b) {
        System.out.println("Hello, this is add method");
        int c = a + b;
        System.out.println("c:" + c);
    }
    //accept double data value
    public static void add(double a, double b) {
        System.out.println("Hello, this is add method");
        double c = a + b;
        System.out.println("c:" + c);
    }

    public static void main(String[] args) {
        JavaProgram7.add(4, 2);
        JavaProgram7.add(4.2, 2.3);

    }
}