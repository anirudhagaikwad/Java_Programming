package CollectionCRUD;


// Importing required classes
import java.io.*;
import java.util.*;

class VectorProgram {

    // Main driver method
    public static void main(String[] arg)
    {

        // Case 1
        // Creating a default vector
        Vector v1 = new Vector();

        // Adding custom elements
        // using add() method
        v1.add(1);
        v1.add(2);
        v1.add("geeks");
        v1.add("forGeeks");
        v1.add(3);

        // Printing the vector elements to the console
        System.out.println("Vector v1 is " + v1);

        // Case 2
        // Creating generic vector
        Vector<Integer> v2 = new Vector<Integer>();

        // Adding custom elements
        // using add() method
        v2.add(1);
        v2.add(2);
        v2.add(3);

        // Printing the vector elements to the console
        System.out.println("Vector v2 is " + v2);

        //updating
        // Using set() method to replace 20 with 50
        System.out.println("The Object that is replaced is: "
                + v1.set(3, "Students"));

        // Displaying the modified vector
        System.out.println("The new Vector is:" + v1);

        //Remove --

        // removing first occurrence element at 1
        v1.remove(1);

        // checking vector
        System.out.println("after removal: " + v1);

        //traversal--
        System.out.println("Traverse:");
        // Using the Get method and the
        // for loop
        for (int i = 0; i < v1.size(); i++) {

            System.out.print(v1.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (Integer i : v2)
            System.out.print(i + " ");


    }
}
