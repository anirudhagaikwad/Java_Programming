package PPT13;

/* Java Program to Illustrate Exception Handling
with Method Overriding
Where SuperClass doesn't declare any exception and
SubClass declare Unchecked exception
*/

import java.io.*;

class SuperCls {

    // SuperClass doesn't declare any exception
    void method()
    {
        System.out.println("SuperClass");
    }
}

// SuperClass inherited by the SubClass
class JavaProgram12 extends SuperCls {

    // method() declaring Unchecked Exception ArithmeticException
    void method() throws ArithmeticException
    {

        // ArithmeticException is of type Unchecked Exception
        // so the compiler won't give any error

        System.out.println("SubClass");
    }

    public static void main(String args[])
    {
        SuperCls s = new JavaProgram12();
        s.method();
    }
}

