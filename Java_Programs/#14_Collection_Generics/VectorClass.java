/*
The Vector class in Java is a part of the Java Collections Framework and is an implementation of a dynamic array. It is similar to an array but provides additional functionality, such as automatic resizing, that makes it more flexible and convenient to use.

Some key features of the Vector class include:

Dynamic Size: A Vector can grow or shrink dynamically as elements are added or removed. It automatically handles resizing of the underlying array to accommodate the elements.

Indexed Access: Elements in a Vector can be accessed using an index, just like in an array. You can retrieve, modify, or remove elements at specific positions using methods such as get(index), set(index, element), and remove(index).

Ordered Collection: Vector maintains the order of elements, preserving the order in which they were added. Iterating over a Vector will return the elements in the same order.

Thread-Safe: Unlike ArrayList, Vector is synchronized, which means it provides inherent thread-safety. It can be safely used in multi-threaded environments, but this synchronization comes with a performance overhead.

Legacy Class: The Vector class has been available since the early versions of Java and is considered part of the legacy collections. It is still maintained for backward compatibility reasons, but in most cases, the ArrayList class is preferred due to its better performance.
*/
import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");

        System.out.println("Elements: " + vector);
        System.out.println("Size: " + vector.size());
        System.out.println("Element at index 1: " + vector.get(1));

        vector.remove(0);
        System.out.println("Elements after removal: " + vector);
    }
}

