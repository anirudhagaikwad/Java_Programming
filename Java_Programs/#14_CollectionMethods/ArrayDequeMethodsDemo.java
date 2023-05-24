import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class ArrayDequeMethodsDemo {
    public static void main(String[] args) {
        // Create a new ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add elements to the front of the deque using the addFirst() method
        deque.addFirst("apple");
        deque.addFirst("banana");
        deque.addFirst("orange");

        // Display the deque
        System.out.println("ArrayDeque: " + deque);

        // Add elements to the end of the deque using the addLast() method
        deque.addLast("grape");
        deque.addLast("kiwi");
        deque.addLast("melon");

        // Display the deque
        System.out.println("ArrayDeque: " + deque);

        // Get the first element of the deque using the getFirst() method
        String firstElement = deque.getFirst();
        System.out.println("First element: " + firstElement);

        // Get the last element of the deque using the getLast() method
        String lastElement = deque.getLast();
        System.out.println("Last element: " + lastElement);

        // Remove and return the first element of the deque using the removeFirst() method
        String removedFirst = deque.removeFirst();
        System.out.println("Removed first element: " + removedFirst);

        // Remove and return the last element of the deque using the removeLast() method
        String removedLast = deque.removeLast();
        System.out.println("Removed last element: " + removedLast);

        // Display the deque
        System.out.println("ArrayDeque: " + deque);

        // Check if the deque contains a specific element using the contains() method
        boolean containsApple = deque.contains("apple");
        System.out.println("Contains 'apple'? " + containsApple);

        // Get the size of the deque using the size() method
        int size = deque.size();
        System.out.println("Size of ArrayDeque: " + size);

        // Check if the deque is empty using the isEmpty() method
        boolean isEmpty = deque.isEmpty();
        System.out.println("ArrayDeque is empty? " + isEmpty);
        
        // Get and remove the first element of the deque using the poll() method
        String polledElement = deque.poll();
        System.out.println("Polled element: " + polledElement);

        // Add an element to the front of the deque using the offerFirst() method
        deque.offerFirst("peach");
        System.out.println("ArrayDeque after offering 'peach' at the front: " + deque);

        // Remove the first occurrence of an element using the removeFirstOccurrence() method
        boolean removed = deque.removeFirstOccurrence("banana");
        System.out.println("Removed 'banana'? " + removed);
        System.out.println("ArrayDeque after removing 'banana': " + deque);

        // Traverse the deque using the iterator() method
        System.out.println("Traversing ArrayDeque using iterator():");
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // Split the deque into multiple parts using the spliterator() method
        Spliterator<String> spliterator1 = deque.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        // Traverse and print elements from the first spliterator
        System.out.println("Traversing first spliterator:");
        spliterator1.forEachRemaining(System.out::println);

        // Traverse and print elements from the second spliterator
        System.out.println("Traversing second spliterator:");
        spliterator2.forEachRemaining(System.out::println);

        // Get an array containing all elements of the deque using the toArray() method
        Object[] array = deque.toArray();
        System.out.println("Array representation of ArrayDeque: ");
        for (Object element : array) {
            System.out.println(element);
        }

        // Get an array containing all elements of the deque using the toArray(T[] a) method
        String[] stringArray = deque.toArray(new String[0]);
        System.out.println("String array representation of ArrayDeque: ");
        for (String element : stringArray) {
            System.out.println(element);
        }

        // Traverse the deque in reverse order using the descendingIterator() method
        System.out.println("Traversing ArrayDeque in reverse order using descendingIterator():");
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            String element = descendingIterator.next();
            System.out.println(element);
        }

        // Remove all elements from the deque using the clear() method
        deque.clear();
        System.out.println("Cleared ArrayDeque: " + deque);
    }
}

/*
In Java, `ArrayDeque` is a class that implements the `Deque` interface and represents a resizable double-ended queue. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `ArrayDeque`:

1. Double-Ended Queue: `ArrayDeque` is a double-ended queue, which means that elements can be added or removed from both ends of the queue. You can insert elements at the front (`addFirst()`) or at the end (`addLast()`) of the queue. Similarly, you can remove elements from the front (`removeFirst()`) or from the end (`removeLast()`) of the queue.

2. Resizable Array: Internally, `ArrayDeque` uses a dynamically resizing array to store its elements. This allows it to adjust the capacity of the deque as elements are added or removed. When the deque reaches its maximum capacity, it automatically expands the array to accommodate more elements.

3. Null Values: `ArrayDeque` allows the inclusion of a single `null` value. You can add `null` to an `ArrayDeque`, and it will be treated as a regular element. If you attempt to add `null` again, it will still be considered as a single element.

4. Performance: `ArrayDeque` provides constant-time performance for the basic operations of adding and removing elements at both ends (`addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`). This makes it an efficient choice for scenarios where elements need to be inserted or removed frequently from both ends.

5. Not Thread-Safe: `ArrayDeque` is not thread-safe. If you need to use it in a multi-threaded environment, you should synchronize access to the deque externally or consider using the `ConcurrentLinkedDeque` class, which provides thread-safe operations.

6. Random Access: Unlike some other queue implementations, `ArrayDeque` does not provide random access to elements. To access elements at specific positions, you need to use iterator-based traversal or convert the deque to an array using the `toArray()` method.

7. Implementation of `Deque`: `ArrayDeque` implements the `Deque` interface, which extends the `Queue` interface. This means that `ArrayDeque` inherits all the methods of both interfaces, allowing you to perform various queue and deque operations such as peeking, polling, and iterating.

When should you use `ArrayDeque`?

- When you need to efficiently add or remove elements at both ends of the deque.
- When you don't require random access to elements.
- When you need a dynamic and resizable queue implementation.

`ArrayDeque` provides a flexible and efficient data structure for scenarios that require a double-ended queue. It offers constant-time performance for adding and removing elements at both ends, making it suitable for various queue and deque operations.
*/
