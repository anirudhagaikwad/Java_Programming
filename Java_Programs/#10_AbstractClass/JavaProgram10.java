package PPT10;


// Java program to show that interfaces can have default implementation methods from JDK 1.8 onwards

interface In1
{
    final int a = 10;
    default void display()
    {
        System.out.println("hello");
    }
}

// A class that implements the interface.
class JavaProgram10 implements In1
{

    public static void main (String[] args)
    {
        JavaProgram10 t = new JavaProgram10();
        t.display();
    }
}
