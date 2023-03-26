package CollectionCRUD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProgram {

    public static void main(String[] args) {

        // Creating an ArrayList of String
        List<String> fruits = new ArrayList<>();

        // Adding new elements to the ArrayList
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("mango");
        fruits.add("orange");
        System.out.println(fruits);

        // Setting element at 1st index
        fruits.set(1, "cherry");

        //  Printing the updated Arraylist
        System.out.println("Updated ArrayList " + fruits);

        // Removing this word element in ArrayList
        fruits.remove("orange");

        // Now printing updated ArrayList
        System.out.println("After the Object Removal "
                + fruits);

        //iterating the elements

        // Using the Get method and the
        // for loop
        for (int i = 0; i < fruits.size(); i++) {

            System.out.print(fruits.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : fruits)
            System.out.print(str + " ");

        // get method
        String n= fruits.get(1);
        System.out.println("at indext 1 number is:"+n);

        // Add elements between two
        fruits.add(2, "Papaya");
        System.out.println(fruits);

        //sorting
        Collections.sort(fruits);
        System.out.println("after sorting :");
        System.out.println(fruits);

        //size of list
        int b = fruits.size();
        System.out.println("The size is :" + b);

    }
}
