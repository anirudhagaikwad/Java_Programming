package PPT11;

//Java program to illustrate method overloading in varargs

public class JavaProgram9
{
    public static void main(String[] args)
    {
        fun();
    }

    //varargs method with float datatype
    static void fun(float... x)
    {
        System.out.println("float varargs");
    }

    //varargs method with int datatype
    static void fun(int... x)
    {
        System.out.println("int varargs");
    }

    //varargs method with double datatype
    static void fun(double... x)
    {
        System.out.println("double varargs");
    }
}
