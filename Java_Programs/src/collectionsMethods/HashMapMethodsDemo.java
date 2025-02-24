package collectionsMethods;
import java.util.HashMap;
import java.util.Map;

public class HashMapMethodsDemo {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Add key-value pairs to the HashMap using the put() method
        hashMap.put(1, "apple");
        hashMap.put(2, "banana");
        hashMap.put(3, "orange");

        // Display the HashMap
        System.out.println("HashMap: " + hashMap);

        // Get the value associated with a specific key using the get() method
        String value = hashMap.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if the HashMap contains a specific key using the containsKey() method
        boolean containsKey = hashMap.containsKey(3);
        System.out.println("Contains key 3? " + containsKey);

        // Check if the HashMap contains a specific value using the containsValue() method
        boolean containsValue = hashMap.containsValue("banana");
        System.out.println("Contains value 'banana'? " + containsValue);

        // Get the number of key-value mappings in the HashMap using the size() method
        int size = hashMap.size();
        System.out.println("Size of HashMap: " + size);

        // Remove a key-value pair from the HashMap using the remove() method
        String removedValue = hashMap.remove(1);
        System.out.println("Removed value: " + removedValue);

        // Display the HashMap
        System.out.println("HashMap: " + hashMap);

        // Iterate over the keys in the HashMap using the keySet() method
        System.out.println("Iterating over keys in HashMap:");
        for (Integer key : hashMap.keySet()) {
            System.out.println("Key: " + key);
        }

        // Iterate over the values in the HashMap using the values() method
        System.out.println("Iterating over values in HashMap:");
        for (String val : hashMap.values()) {
            System.out.println("Value: " + val);
        }

        // Iterate over the key-value pairs in the HashMap using the entrySet() method
        System.out.println("Iterating over key-value pairs in HashMap:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Clear the HashMap using the clear() method
        hashMap.clear();
        System.out.println("Cleared HashMap: " + hashMap);
    }
}

/*
In Java, `HashMap` is a class that implements the `Map` interface and represents a collection of key-value pairs. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `HashMap`:

1. Key-Value Mapping: `HashMap` allows you to store and retrieve values based on associated keys. Each key-value pair in the `HashMap` is unique, meaning that a key can only have one corresponding value. However, different keys can have the same value.

2. Hashing: `HashMap` uses a hashing mechanism to store and retrieve elements efficiently. When a key-value pair is added to the `HashMap`, the key is hashed to determine its storage location within the underlying data structure. This allows for fast lookup and retrieval of values based on their keys.

3. Performance: `HashMap` provides constant-time performance for basic operations such as `put()`, `get()`, `containsKey()`, and `remove()`. However, the actual performance can be affected by factors such as the number of elements and the quality of the hash function.

4. Ordering: By default, `HashMap` does not guarantee any specific order of its elements. The order in which the key-value pairs are returned during iteration may vary. If you require a specific order, you can use the `LinkedHashMap` class, which maintains the insertion order of elements.

5. Null Values and Keys: `HashMap` allows the inclusion of a single `null` key and multiple `null` values. This means that you can store `null` values and a `null` key in a `HashMap`.

6. Not Thread-Safe: `HashMap` is not synchronized or thread-safe by default. If you need to use it in a multi-threaded environment, you should synchronize access to the `HashMap` externally or consider using the `ConcurrentHashMap` class, which provides thread-safe operations.

7. Iteration: You can iterate over the key-value pairs in a `HashMap` using various methods such as `keySet()`, `values()`, or `entrySet()`. The `keySet()` method returns a `Set` of all the keys, `values()` returns a `Collection` of all the values, and `entrySet()` returns a `Set` of all the key-value pairs as `Map.Entry` objects.

8. Capacity and Load Factor: `HashMap` has an initial capacity, which determines the number of buckets used for storing the elements. Additionally, it has a load factor, which determines when the underlying data structure is resized. When the number of elements exceeds the load factor multiplied by the current capacity, the `HashMap` is automatically resized and rehashed for better performance.

When should you use `HashMap`?

- When you need to store and retrieve values based on unique keys.
- When fast lookup and retrieval of elements are important.
- When the order of elements is not a concern.
- When you don't require thread-safety.

`HashMap` provides a flexible and efficient way to store key-value pairs. It offers fast lookup and retrieval of elements, making it suitable for various applications such as caching, indexing, and data storage.
*/
