package collectionsMethods;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

public class HashSetMethodsDemo {
    public static void main(String[] args) {
        // Create a new HashSet
        HashSet<String> set = new HashSet<>();

        // Add elements to the HashSet using the add() method
        set.add("apple");
        set.add("banana");
        set.add("orange");

        // Display the HashSet
        System.out.println("HashSet: " + set);

        // Iterate over the HashSet using the iterator() method
        System.out.println("Traversing HashSet using iterator():");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // Split the HashSet into multiple parts using the spliterator() method
        Spliterator<String> spliterator1 = set.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        // Traverse and print elements from the first spliterator
        System.out.println("Traversing first spliterator:");
        spliterator1.forEachRemaining(System.out::println);

        // Traverse and print elements from the second spliterator
        System.out.println("Traversing second spliterator:");
        spliterator2.forEachRemaining(System.out::println);
        
         // Check if the HashSet contains a specific element using the contains() method
        boolean containsApple = set.contains("apple");
        System.out.println("Contains 'apple'? " + containsApple);

        // Remove an element from the HashSet using the remove() method
        boolean removedBanana = set.remove("banana");
        System.out.println("Removed 'banana'? " + removedBanana);

        // Get the size of the HashSet using the size() method
        int size = set.size();
        System.out.println("Size of HashSet: " + size);

        // Check if the HashSet is empty using the isEmpty() method
        boolean isEmpty = set.isEmpty();
        System.out.println("HashSet is empty? " + isEmpty);
        
   // Remove all elements from the HashSet using the clear() method
        set.clear();
        System.out.println("Cleared HashSet: " + set);      
    }
}

/*
In Java, `HashSet` is a class that implements the `Set` interface and represents an unordered collection of unique elements. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `HashSet`:

1. Unique Elements: `HashSet` does not allow duplicate elements. It ensures that each element in the set is unique. If an attempt is made to add a duplicate element, it will be ignored and not added to the set.

2. Unordered Collection: `HashSet` does not guarantee any specific order of elements. The elements are stored in an internal structure that provides fast access and retrieval but does not preserve the order of insertion.

3. Hashing Mechanism: `HashSet` uses a hashing mechanism to store and retrieve elements efficiently. It computes the hash code of each element and uses it to determine the bucket (internal storage location) where the element will be stored. This allows for fast access and searching.

4. Null Values: `HashSet` allows the inclusion of a single `null` value. You can add `null` to a `HashSet`, and it will be treated as a unique element. If you attempt to add `null` again, it will still be considered as a single element.

5. Performance: `HashSet` provides constant-time performance for the basic operations like adding, removing, and checking for containment (`add()`, `remove()`, and `contains()` methods). However, the actual performance may vary based on factors like the number of elements and hash collisions.

6. Iteration: `HashSet` supports iteration over its elements using iterators. You can obtain an iterator using the `iterator()` method, which allows you to traverse the elements in no specific order.

7. Backed by Hash Table: Internally, `HashSet` is backed by a hash table, which is an array of linked lists. Each element is stored in a linked list node based on its hash code. This data structure ensures efficient insertion, removal, and lookup operations.

When should you use `HashSet`?

- When you need to store a collection of unique elements and order is not important.
- When you want fast access, insertion, and removal operations, and you don't need to maintain the order of elements.
- When you need to efficiently check for the existence of an element in the set.

Remember that since `HashSet` does not preserve the insertion order, if you require a specific ordering, you can use `LinkedHashSet`, which maintains the order of elements based on insertion.

Overall, `HashSet` provides a convenient and efficient way to work with a collection of unique elements in Java.
*/
