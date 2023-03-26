package PPT11;

// Java Program to Access Super Class in a Method Overriding.
class Base
{
    void get()
    {
        System.out.println(" Base class method via Super keyword");
    }
}
class JavaProgram4 extends Base
{
    void get()
    {
        super.get();
        System.out.println("Child class method");
    }
    public static void main(String... a)
    {
        JavaProgram4 obj1 = new JavaProgram4();
        obj1.get();
    }
}