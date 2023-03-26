package PPT10;


/*Java program to demonstrate that a class can
implement multiple interfaces
 */

import java.io.*;
interface intfA
{
    void m1();
}

interface intfB
{
    void m2();
}

// class implements both interfaces
// and provides implementation to the method.
class sample implements intfA, intfB
{
    @Override
    public void m1()
    {
        System.out.println("Welcome: inside the method m1");
    }

    @Override
    public void m2()
    {
        System.out.println("Welcome: inside the method m2");
    }
}

class JavaProgram13
{
    public static void main (String[] args)
    {
        sample ob1 = new sample();

        // calling the method implemented
        // within the class.
        ob1.m1();
        ob1.m2();
    }
}
