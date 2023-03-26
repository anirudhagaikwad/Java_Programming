package PPT14;


// Java Program to illustrate Generic constructors

// Importing input output classes
import java.io.*;

// Class 1
// Generic class
class GenericConstructor {
    // Member variable of this class
    private double v;

    // Constructor of this class where
    // T is typename and t is object
    <T extends Number> GenericConstructor(T t)
    {
        // Converting input number type to double
        // using the doubleValue() method
        v = t.doubleValue();
    }

    // Method of this class
    void show()
    {
        // Print statement whenever method is called
        System.out.println("v: " + v);
    }
}

// Class 2 - Implementation class
// Main class
class JavaPorgram6 {
    // Main driver method
    public static void main(String[] args)
    {
        // Display message
        System.out.println("Number to Double Conversion:");

        // Creating objects of type GenericConstructor i.e
        // og above class and providing custom inputs to
        // constructor as parameters
        GenericConstructor obj1
                = new GenericConstructor(10);
        GenericConstructor obj2
                = new GenericConstructor(136.8F);

        // Calling method - show() on the objects
        // using the dot operator
        obj1.show();
        obj2.show();
    }
}
