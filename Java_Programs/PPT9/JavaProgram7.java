package PPT9;

// Java Program to Illustrate Unsupportance of
// Multiple Inheritance

// Importing input output classes
import java.io.*;

// Class 1
// First Parent class
class Parent1 {

    // Method inside first parent class
    void fun() {

        // Print statement if this method is called
        System.out.println("Parent1");
    }
}

// Class 2
// Second Parent Class
class Parent2 {

    // Method inside first parent class
    void fun() {

        // Print statement if this method is called
        System.out.println("Parent2");
    }
}

// Class 3
// Trying to be child of both the classes
class JavaProgram7 //extends Parent1, Parent2 (---ERROR---)
{
    public static void main(String args[]) {

        // Creating object of class in main() method
        JavaProgram7 t = new JavaProgram7();

        // Trying to call above functions of class where
        // Error is thrown as this class is inheriting
        // multiple classes
        //t.fun(); (ERROR after uncomment)
    }
}
