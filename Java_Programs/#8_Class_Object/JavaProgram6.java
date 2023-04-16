package PPT8;

// java program to initialize instance variable in constructor

public class JavaProgram6
{
    int a,b,c;
    JavaProgram6()
    {
        a = 5;
        b = 6;
    }
    void change()
    {
        a = 15;
        b = 10;
        c = a + b;
    }
    public static void main(String[] args)
    {
        JavaProgram6 obj1 = new JavaProgram6();
        System.out.println("a:"+obj1.a);
        System.out.println("b:"+obj1.b);
        obj1.change();
        System.out.println("New a:"+obj1.a);
        System.out.println("New b:"+obj1.b);
        System.out.println("c:"+obj1.c);
    }
}