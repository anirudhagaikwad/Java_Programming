package collectionsMethods;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMethodsDemo {
    public static void main(String[] args) {
        // Create a new LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Add key-value pairs to the LinkedHashMap using the put() method
        linkedHashMap.put("apple", 10);
        linkedHashMap.put("banana", 5);
        linkedHashMap.put("orange", 7);

        // Display the LinkedHashMap
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Check if the LinkedHashMap contains a specific key using the containsKey() method
        boolean containsKey = linkedHashMap.containsKey("banana");
        System.out.println("Contains key 'banana'? " + containsKey);

        // Get the value associated with a specific key using the get() method
        int value = linkedHashMap.get("apple");
        System.out.println("Value for key 'apple': " + value);

        // Get the number of key-value mappings in the LinkedHashMap using the size() method
        int size = linkedHashMap.size();
        System.out.println("Size of LinkedHashMap: " + size);

        // Remove a key-value pair from the LinkedHashMap using the remove() method
        int removedValue = linkedHashMap.remove("orange");
        System.out.println("Removed value: " + removedValue);

        // Display the LinkedHashMap
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Iterate over the keys in the LinkedHashMap using the keySet() method
        System.out.println("Iterating over keys in LinkedHashMap:");
        for (String key : linkedHashMap.keySet()) {
            System.out.println("Key: " + key);
        }

        // Iterate over the values in the LinkedHashMap using the values() method
        System.out.println("Iterating over values in LinkedHashMap:");
        for (int val : linkedHashMap.values()) {
            System.out.println("Value: " + val);
        }

        // Iterate over the key-value pairs in the LinkedHashMap using the entrySet() method
        System.out.println("Iterating over key-value pairs in LinkedHashMap:");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Clear the LinkedHashMap using the clear() method
        linkedHashMap.clear();
        System.out.println("Cleared LinkedHashMap: " + linkedHashMap);
    }
}

/*
In Java, `LinkedHashMap` is a class that extends the `HashMap` class and implements the `Map` interface. It represents a collection of key-value pairs that are stored in a hash table with a predictable iteration order based on the insertion order. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `LinkedHashMap`:

1. Key-Value Mapping: Like other implementations of the `Map` interface, `LinkedHashMap` allows you to store and retrieve values based on associated keys. Each key in the map is unique, and it can only have one corresponding value. However, different keys can have the same value.

2. Hash Table and Linked List: `LinkedHashMap` internally uses a combination of a hash table and a doubly-linked list to store and organize the key-value pairs. The hash table provides fast element access and the linked list maintains the order of insertion, allowing for predictable iteration order based on the order of key-value mappings.

3. Iteration Order: The iteration order of `LinkedHashMap` is the order in which key-value mappings were added to the map. This means that when you iterate over the map or perform operations that involve the order of key-value mappings, such as printing or iterating, the mappings will be returned in the same order they were added.

4. Performance: `LinkedHashMap` provides constant-time performance (O(1)) for basic operations such as adding, removing, and searching for key-value mappings. The actual performance may degrade if there are a large number of mappings due to hash collisions and resizing of the underlying hash table.

5. Null Keys and Values: `LinkedHashMap` allows the inclusion of a single `null` key and multiple `null` values. You can add a `null` key or `null` values to a `LinkedHashMap`, and they will be treated as unique elements.

6. Usage: `LinkedHashMap` is suitable in scenarios where you need a collection that maintains the order of key-value mappings as they are added while also providing fast access and modification operations. It is often used when you want to preserve the insertion order of mappings and still benefit from the fast lookup performance of a hash-based data structure.

When should you use `LinkedHashMap`?

- When you need a collection that maintains the order of key-value mappings as they are added.
- When you want to ensure unique keys and fast retrieval of values associated with keys using the `get()` method.
- When you require predictable iteration order for consistent behavior in your application.
- When you need to perform operations such as iteration, removal, or modification based on the insertion order of key-value mappings.

`LinkedHashMap` combines the features of a hash table and a linked list, providing a predictable iteration order while maintaining fast access and modification of key-value mappings. It is a good choice when you need to maintain the insertion order of mappings in a collection and perform efficient operations such as retrieval, iteration, and removal based on the keys.
*/
