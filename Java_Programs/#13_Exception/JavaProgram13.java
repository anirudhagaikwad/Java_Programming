package PPT13;

/* Java Program to Illustrate Exception Handling
with Method Overriding
Where SuperClass declares an exception and
SubClass declares a child exception
of the SuperClass declared Exception
 */

import java.io.*;

class Base {

    // SuperClass declares an exception
    void method() throws RuntimeException
    {
        System.out.println("SuperClass");
    }
}

// SuperClass inherited by the SubClass
class JavaProgram13 extends Base {

    // SubClass declaring a child exception
    // of RuntimeException
    void method() throws ArithmeticException
    {

        // ArithmeticException is a child exception
        // of the RuntimeException
        // So the compiler won't give an error
        System.out.println("SubClass");
    }

    public static void main(String args[])
    {
        Base s = new JavaProgram13();
        s.method();
    }
}

