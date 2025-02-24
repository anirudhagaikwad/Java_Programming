package collectionsMethods;
import java.util.LinkedHashSet;

public class LinkedHashSetMethodsDemo {
    public static void main(String[] args) {
        // Create a new LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet using the add() method
        linkedHashSet.add("apple");
        linkedHashSet.add("banana");
        linkedHashSet.add("orange");

        // Display the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Check if the LinkedHashSet contains a specific element using the contains() method
        boolean containsElement = linkedHashSet.contains("banana");
        System.out.println("Contains element 'banana'? " + containsElement);

        // Get the number of elements in the LinkedHashSet using the size() method
        int size = linkedHashSet.size();
        System.out.println("Size of LinkedHashSet: " + size);

        // Remove an element from the LinkedHashSet using the remove() method
        boolean removed = linkedHashSet.remove("orange");
        System.out.println("Removed element 'orange'? " + removed);

        // Display the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Iterate over the elements in the LinkedHashSet using the iterator() method
        System.out.println("Iterating over elements in LinkedHashSet:");
        for (String element : linkedHashSet) {
            System.out.println(element);
        }

        // Clear the LinkedHashSet using the clear() method
        linkedHashSet.clear();
        System.out.println("Cleared LinkedHashSet: " + linkedHashSet);
    }
}

/*
In Java, `LinkedHashSet` is a class that extends the `HashSet` class and implements the `Set` interface. It represents a collection of elements that are stored in a hash table with a predictable iteration order. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `LinkedHashSet`:

1. Unique Elements: Like other implementations of the `Set` interface, `LinkedHashSet` does not allow duplicate elements. It ensures that each element in the set is unique based on the element's `equals()` method.

2. Hash Table and Linked List: `LinkedHashSet` internally uses a combination of a hash table and a linked list to store and organize the elements. The hash table provides fast element access and the linked list maintains the order of insertion, allowing for predictable iteration order.

3. Order of Insertion: `LinkedHashSet` maintains the order in which elements were inserted into the set. This means that when you iterate over the set or perform operations that involve the order of elements, such as printing or iterating, the elements will be returned in the same order they were added.

4. Performance: `LinkedHashSet` provides constant-time performance (O(1)) for basic operations such as adding, removing, and searching for elements. However, the actual performance may degrade if there are a large number of elements due to hash collisions and resizing of the underlying hash table.

5. Iteration Order: The iteration order of `LinkedHashSet` is the order in which elements were added to the set. This order remains constant unless an element is removed and re-added, which would place it at the end of the iteration order.

6. Null Elements: `LinkedHashSet` allows the inclusion of a single `null` element. You can add `null` to a `LinkedHashSet`, and it will be treated as a unique element. However, you cannot add multiple `null` elements.

7. Usage: `LinkedHashSet` is suitable in scenarios where you need a collection that maintains the insertion order of elements while also providing fast access, removal, and uniqueness checks. It is often used when you want to preserve the order in which elements were added and still benefit from the fast lookup performance of a hash-based data structure.

When should you use `LinkedHashSet`?

- When you need a collection that maintains the order of elements as they are added.
- When you want to ensure unique elements and fast membership checks using the `contains()` method.
- When you need to iterate over the elements in the same order as they were inserted.
- When you require predictable iteration order for consistent behavior in your application.

`LinkedHashSet` combines the features of a hash table and a linked list, providing a predictable iteration order while maintaining fast element access and uniqueness. It is a good choice when you need to maintain the insertion order of elements in a collection and perform efficient operations such as membership checks and iteration.
*/
