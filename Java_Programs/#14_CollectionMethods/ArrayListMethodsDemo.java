import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class ArrayListMethodsDemo {

    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> fruits = new ArrayList<>();

        // Adding elements to the ArrayList using add()
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        // Printing the ArrayList
        System.out.println("ArrayList: " + fruits);

        // Accessing elements using get()
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        // Setting element at a specific index using set()
        fruits.set(1, "Cherry");
        System.out.println("Updated ArrayList: " + fruits);

        // Checking if an element is present using contains()
        boolean containsMango = fruits.contains("Mango");
        System.out.println("Contains Mango? " + containsMango);

        // Getting the size of the ArrayList using size()
        int size = fruits.size();
        System.out.println("Size of ArrayList: " + size);

        // Removing an element using remove()
        boolean removed = fruits.remove("Apple");
        System.out.println("Removed Apple? " + removed);
        System.out.println("ArrayList after removal: " + fruits);

        // Sorting the ArrayList using Collections.sort()
        Collections.sort(fruits);
        System.out.println("Sorted ArrayList: " + fruits);

// Sorting the ArrayList in descending order
        Collections.sort(fruits, Collections.reverseOrder());
        
        // Reversing the order of elements using Collections.reverse()
        Collections.reverse(fruits);
        System.out.println("Reversed ArrayList: " + fruits);

        // Creating a shallow copy of the ArrayList using clone()
       // List<String> copy = new ArrayList<>(fruits);
        //System.out.println("Copied ArrayList: " + copy);
        //List<String> copy = (List<String>) fruits.clone();
        //System.out.println("Copied ArrayList: " + copy);

        // Checking if the ArrayList is empty using isEmpty()
        boolean empty = fruits.isEmpty();
        System.out.println("Is ArrayList empty? " + empty);

        // Clearing the ArrayList using clear()
        fruits.clear();
        System.out.println("Cleared ArrayList: " + fruits);

        // Using iterator() to iterate over the elements
        fruits.add("Grapes");
        fruits.add("Pineapple");
        Iterator<String> iterator = fruits.iterator();
        System.out.print("ArrayList elements using iterator(): ");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Finding the last index of an element using lastIndexOf()
        fruits.add("Grapes");
        fruits.add("Pineapple");
        int lastIndex = fruits.lastIndexOf("Grapes");
        System.out.println("Last index of 'Grapes': " + lastIndex);

        // Removing multiple elements using removeAll()
        List<String> removeList = new ArrayList<>();
        removeList.add("Grapes");
        removeList.add("Pineapple");
        fruits.removeAll(removeList);
        System.out.println("ArrayList after removing 'Grapes' and 'Pineapple': " + fruits);

        // Adding all elements from another collection using addAll()
        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("Strawberry");
        moreFruits.add("Watermelon");
        fruits.addAll(moreFruits);
        System.out.println("ArrayList after adding more fruits: " + fruits);

        // Using spliterator() to split the ArrayList into multiple parts
        Spliterator<String> spliterator = fruits.spliterator();
        System.out.print("ArrayList elements using spliterator(): ");
        spliterator.forEachRemaining((fruit) -> System.out.print(fruit + " "));
        System.out.println();

        // Converting ArrayList to an Array using toArray()
        String[] fruitArray = fruits.toArray(new String[0]);
        System.out.print("Array elements from ArrayList using toArray(): ");
        for (String fruit : fruitArray) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Converting ArrayList to a Typed Array using toArray(T[] a)
        String[] typedArray = fruits.toArray(new String[fruits.size()]);
        System.out.print("Typed Array elements from ArrayList using toArray(T[] a): ");
        for (String fruit : typedArray) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}

/*
An ArrayList in Java is a dynamic data structure that allows you to store and manipulate a collection of elements. It is a part of the Java Collections Framework and is implemented as a resizable array.

Here are some key features and characteristics of ArrayList:

Dynamic Size: Unlike regular arrays, ArrayLists can grow or shrink in size dynamically. They automatically resize themselves as elements are added or removed.

Indexed Access: Elements in an ArrayList are accessed using an index. The index starts from 0 for the first element and goes up to size-1 for the last element.

Ordered Collection: ArrayList maintains the order of elements based on the insertion sequence. The position of an element remains constant unless it is explicitly modified.

Random Access: ArrayList provides efficient random access to elements. You can directly access any element by its index in constant time, O(1).

Heterogeneous Elements: An ArrayList can hold elements of different types, such as integers, strings, objects, etc. However, it is recommended to use generics to specify the type of elements in order to ensure type safety.

Null Elements and Duplicates: ArrayList allows null elements and can also store duplicate values. You can have multiple occurrences of the same element in an ArrayList.

Operations and Methods: ArrayList provides various methods to perform common operations like adding, removing, updating, searching, and iterating over elements. Some commonly used methods include add(), remove(), get(), set(), size(), contains(), clear(), etc.

Performance: ArrayList provides fast access to elements using indexes, but inserting or removing elements in the middle of the list or at the beginning can be relatively slower compared to LinkedList. The time complexity for most operations is O(1), except for inserting or removing elements at arbitrary positions, which takes O(n) time due to element shifting.

It's important to note that ArrayList is not synchronized, meaning it is not thread-safe by default. If you require thread-safe operations on an ArrayList in a multi-threaded environment, you can use the Collections.synchronizedList() method to obtain a synchronized (thread-safe) version of the ArrayList.
*/

/*
`Spliterator` is a Java interface introduced in Java 8 as part of the Stream API. The name "Spliterator" stands for "split-iterator," and it represents an object that can traverse and split elements of a data source into multiple parts for parallel processing.

The `Spliterator` interface provides a consistent and efficient way to traverse elements of a data source such as a `List`, `Set`, or `Array` by splitting it into multiple sub-parts. It supports both sequential and parallel processing of elements.

The primary methods defined in the `Spliterator` interface are:

- `boolean tryAdvance(Consumer<? super T> action)`: Performs the given action on the next element in the data source, if available. It returns `true` if there are more elements remaining, or `false` if the end of the data source is reached.
- `void forEachRemaining(Consumer<? super T> action)`: Performs the given action on the remaining elements of the data source.
- `Spliterator<T> trySplit()`: Splits the data source into two parts, allowing for parallel processing. It returns a new `Spliterator` that represents the split-off portion of the data source, or `null` if the data source cannot be split further.
- `long estimateSize()`: Returns an estimate of the number of elements remaining to be processed.
- `int characteristics()`: Returns a bitmask indicating the characteristics of the `Spliterator`, such as whether it is ordered, sized, or sorted.

By using a `Spliterator`, you can process elements in parallel or perform other operations like filtering, mapping, and reducing using the Stream API. It provides an efficient way to divide the workload across multiple threads or processors for improved performance in certain scenarios.
*/
