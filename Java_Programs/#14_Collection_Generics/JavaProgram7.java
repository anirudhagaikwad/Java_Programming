package PPT14;


// Java Program to illustrate Generic interfaces

// Importing java input output classes
import java.io.*;

// An interface that extends Comparable
interface MinMax<T extends Comparable<T> > {
    // Declaring abstract methods
    // Method with no body is abstract method
    T min();
    T max();
}

// Class 1 - Sub-class
// class extending Comparable and implementing interface
class MyClass<T extends Comparable<T> >
        implements MinMax<T> {

    // Member variable of 'MyClass' class
    T[] values;

    // Constructor of 'MyClass' class
    MyClass(T[] obj) { values = obj; }

    // Now, defining min() and max() methods
    // for MimMax interface computation

    // Defining abstract min() method
    public T min()
    {
        // 'T' is typename and 'o1' is object_name
        T o1 = values[0];

        // Iterating via for loop over elements using
        // length() method to get access of minimum element
        for (int i = 1; i < values.length; i++)
            if (values[i].compareTo(o1) < 0)
                o1 = values[i];

        // Return the minimum element in an array
        return o1;
    }

    // Defining abstract max() method
    public T max()
    {
        // 'T' is typename and 'o1' is object_name
        T o1 = values[0];

        // Iterating via for loop over elements using
        // length() method to get access of minimum element
        for (int i = 1; i < values.length; i++)
            if (values[i].compareTo(o1) > 0)
                o1 = values[i];

        // Return the maximum element in an array
        return o1;
    }
}

// Class 2 - Main class
// Implementation class
class JavaProgram7 {

    public static void main(String[] args)
    {
        // Custom entries in an array
        Integer arr[] = { 3, 6, 2, 8, 6 };

        // Create an object of type as that of above class
        // by declaring Integer type objects, and
        // passing above array to constructor
        MyClass<Integer> obj1 = new MyClass<Integer>(arr);

        // Calling min() and max() methods over object, and

        // printing the minimum value from array elements
        System.out.println("Minimum value: " + obj1.min());

        // printing the maximum value from array elements
        System.out.println("Maximum value: " + obj1.max());
    }
}
