package PPT9;

/* Java Program to Illustrate Invocation
of Constructor Calling With Usage
of super Keyword

 */

// Class 1
// Super class
class B {
    int x;

    // Constructor of super class
    B(int _x) { x = _x; }
}

// Class 2
// Sub class
class D extends B {

    int y;

    // Constructor of sub class
    D(int _x, int _y)
    {

        // super keyword refers to super class
        super(_x);
        y = _y;
    }

    // Method of sub class
    void Display()
    {
        // Print statement
        System.out.println("x = " + x + ", y = " + y);
    }
}


public class JavaProgram8 {
    public static void main(String[] args)
    {
        // Creating object of sub class
        // inside main() method
        D d = new D(10, 20);
        // Invoking method inside main() method
        d.Display();
    }
}
