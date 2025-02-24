package collectionsMethods;
import java.util.Vector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VectorMethodsDemo {

    public static void main(String[] args) {
        // Creating a Vector
        Vector<String> colors = new Vector<>();

        // Adding elements to the Vector using add()
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // Printing the Vector
        System.out.println("Vector: " + colors);

        // Accessing elements using get()
        String firstColor = colors.get(0);
        System.out.println("First color: " + firstColor);

        // Setting element at a specific index using set()
        colors.set(1, "Yellow");
        System.out.println("Updated Vector: " + colors);

        // Checking if an element is present using contains()
        boolean containsBlue = colors.contains("Blue");
        System.out.println("Contains Blue? " + containsBlue);

        // Getting the size of the Vector using size()
        int size = colors.size();
        System.out.println("Size of Vector: " + size);

        // Removing an element using remove()
        boolean removed = colors.remove("Red");
        System.out.println("Removed Red? " + removed);
        System.out.println("Vector after removal: " + colors);

        // Checking if the Vector is empty using isEmpty()
        boolean empty = colors.isEmpty();
        System.out.println("Is Vector empty? " + empty);

        // Clearing the Vector using clear()
        colors.clear();
        System.out.println("Cleared Vector: " + colors);

        // Adding all elements from another collection using addAll()
        Vector<String> moreColors = new Vector<>();
        moreColors.add("Orange");
        moreColors.add("Purple");
        colors.addAll(moreColors);
        System.out.println("Vector after adding more colors: " + colors);

        // Getting the index of an element using indexOf()
        int index = colors.indexOf("Purple");
        System.out.println("Index of 'Purple': " + index);

        // Reversing the order of elements using reverse()
        Collections.reverse(colors);
        System.out.println("Reversed Vector: " + colors);
        
        // Sorting the Vector in ascending order        
        Collections.sort(colors);
        System.out.println("Vector in ascending order: " + colors);

        // Sorting the Vector in descending order
        Collections.sort(colors, Collections.reverseOrder());
        System.out.println("Vector in descending order: " + colors);

        // Converting Vector to an Array using toArray()
        String[] colorArray = colors.toArray(new String[0]);
        System.out.print("Array elements from Vector using toArray(): ");
        for (String color : colorArray) {
            System.out.print(color + " ");
        }
        System.out.println();

        
    }
}

/*
The Vector class in Java is a part of the Java Collections Framework and is an implementation of a dynamic array. It is similar to an array but provides additional functionality, such as automatic resizing, that makes it more flexible and convenient to use.

Some key features of the Vector class include:

Dynamic Size: A Vector can grow or shrink dynamically as elements are added or removed. It automatically handles resizing of the underlying array to accommodate the elements.

Indexed Access: Elements in a Vector can be accessed using an index, just like in an array. You can retrieve, modify, or remove elements at specific positions using methods such as get(index), set(index, element), and remove(index).

Ordered Collection: Vector maintains the order of elements, preserving the order in which they were added. Iterating over a Vector will return the elements in the same order.

Thread-Safe: Unlike ArrayList, Vector is synchronized, which means it provides inherent thread-safety. It can be safely used in multi-threaded environments, but this synchronization comes with a performance overhead.

Legacy Class: The Vector class has been available since the early versions of Java and is considered part of the legacy collections. It is still maintained for backward compatibility reasons, but in most cases, the ArrayList class is preferred due to its better performance.
*/

