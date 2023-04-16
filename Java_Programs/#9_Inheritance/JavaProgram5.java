package PPT9;

// Java Program to Allocate and Initialize Super Class Members Using Constructor.
class Parent
{
    Parent(int a, int b)
    {
        System.out.println(" the super class constructor");
        int z = a + b;
        System.out.println("the super class method ");
        System.out.println("the sum is "+z);
    }
}
public class JavaProgram5 extends Parent
{
    JavaProgram5(int x)
    {
        super(12, 20);
        System.out.println("the sub class constructor ");
        System.out.println(x);
    }
    public static void main(String ... a)
    {
        JavaProgram5 obj = new JavaProgram5(10);
    }
}
