package PPT10;

/* Java program to demonstrate multiple inheritance
 in interfaces
 */

import java.io.*;

interface infA {
    void geekName();
}

interface infB {
    void geekInstitute();
}

interface infc extends infA, infB {
    void geekBranch();
}

// class implements both interfaces and provides
// implementation to the method.
class JavaProgram14 implements infc {
    public void geekName() { System.out.println("Aditya"); }

    public void geekInstitute()
    {
        System.out.println("VIIT");
    }

    public void geekBranch() { System.out.println("CSE"); }

    public static void main(String[] args)
    {
        JavaProgram14 ob1 = new JavaProgram14();

        // calling the method implemented
        // within the class.
        ob1.geekName();
        ob1.geekInstitute();
        ob1.geekBranch();
    }
}
