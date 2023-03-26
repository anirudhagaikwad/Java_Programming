package PPT11;

// Java Program to Illustrate Run-time polymorphism

// Importing I/O classes
import java.io.*;

// Class 1 (Parent class)
class GFG1 {
    //name method
    void name() {
        System.out.println("This is the GFG1 class");
    }
}

// Class 2 (Child class)
// Main class extending parent class
public class JavaProgram5 extends GFG1 {

    // Method 1
    void name() {
        // Print statement
        System.out.println("This is the GFG class");
    }

    // Method 2
// Main drive method
    public static void main(String[] args) {

        // Now creating 2 objects with different references and
        // calling the Method 1 over the objects

        // Case 1: GFG1 reference and GFG1 is the object
        GFG1 ob = new GFG1();
        ob.name();

        // Case 2: GFG1 reference and GFG is the object
        GFG1 ob1 = new JavaProgram5();
        ob1.name();
    }
}

