package PPT13;

/* Java Program to Illustrate Exception Handling
with Method Overriding
Where SuperClass does not declare any exception and
subclass declare checked exception
 */

import java.io.*;

class SuperClass {

    // SuperClass doesn't declare any exception
    void method() {
        System.out.println("SuperClass");
    }
}

// SuperClass inherited by the SubClass
class JavaProgram11 extends SuperClass {

    // method() declaring Checked Exception IOException
    void method() //throws IOException
    {

        // IOException is of type Checked Exception
        // so the compiler will give Error

        System.out.println("SubClass");
    }

    public static void main(String args[]) {
        SuperClass s = new JavaProgram11();
        s.method();
    }
}
