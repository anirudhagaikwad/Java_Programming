package PPT10;

// Java Program to Illustrates Use of Abstract Class and Method.

abstract class Calculation
{
    float a = 12, b = 6, c;
    abstract void add();
    void subtract()
    {
        c = a - b;
        System.out.println("Result:"+c);
    }
    abstract void multiply();
    void divide()
    {
        c = a / b;
        System.out.println("Result:"+c);
    }
}
public class JavaProgram3 extends Calculation
{
    void add()
    {
        c = a + b;
        System.out.println("Result:"+c);
    }
    void multiply()
    {
        c = a * b;
        System.out.println("Result:"+c);
    }
    public static void main(String[] args)
    {
        JavaProgram3 obj = new JavaProgram3();
        obj.add();
        obj.subtract();
        obj.multiply();
        obj.divide();
    }
}