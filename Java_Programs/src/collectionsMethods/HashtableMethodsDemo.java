package collectionsMethods;
import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableMethodsDemo {
    public static void main(String[] args) {
        // Create a new Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // Add key-value pairs to the Hashtable using the put() method
        hashtable.put(1, "apple");
        hashtable.put(2, "banana");
        hashtable.put(3, "orange");

        // Display the Hashtable
        System.out.println("Hashtable: " + hashtable);

        // Get the value associated with a key using the get() method
        String value = hashtable.get(2);
        System.out.println("Value associated with key 2: " + value);

        // Check if the Hashtable contains a specific key using the containsKey() method
        boolean containsKey = hashtable.containsKey(3);
        System.out.println("Does Hashtable contain key 3? " + containsKey);

        // Check if the Hashtable contains a specific value using the containsValue() method
        boolean containsValue = hashtable.containsValue("apple");
        System.out.println("Does Hashtable contain value 'apple'? " + containsValue);

        // Get the number of key-value pairs in the Hashtable using the size() method
        int size = hashtable.size();
        System.out.println("Size of Hashtable: " + size);

        // Remove a key-value pair from the Hashtable using the remove() method
        String removedValue = hashtable.remove(1);
        System.out.println("Removed value: " + removedValue);

        // Display the Hashtable
        System.out.println("Hashtable: " + hashtable);

        // Iterate over the keys in the Hashtable using the keys() method and Enumeration
        System.out.println("Iterating over keys in Hashtable:");
        Enumeration<Integer> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            System.out.println("Key: " + key);
        }

        // Iterate over the values in the Hashtable using the elements() method and Enumeration
        System.out.println("Iterating over values in Hashtable:");
        Enumeration<String> values = hashtable.elements();
        while (values.hasMoreElements()) {
            String element = values.nextElement();
            System.out.println("Value: " + element);
        }

        // Clear the Hashtable using the clear() method
        hashtable.clear();
        System.out.println("Cleared Hashtable: " + hashtable);
    }
}

/*
In Java, `Hashtable` is a class that represents a hashtable, which is a data structure used for storing key-value pairs. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `Hashtable`:

1. Key-Value Pairs: `Hashtable` stores data in the form of key-value pairs. Each key must be unique within the `Hashtable`, and the value associated with a key can be retrieved using that key.

2. Synchronization: `Hashtable` is a synchronized implementation of the `Map` interface. This means that it is thread-safe for concurrent access. Synchronization ensures that multiple threads can safely access and modify the `Hashtable` without causing data inconsistencies or concurrency issues. However, this synchronization can introduce some performance overhead.

3. Null Values and Null Keys: `Hashtable` does not allow null values or null keys. If you try to store a null value or null key, a `NullPointerException` will be thrown.

4. Hashing: `Hashtable` internally uses a hashing technique to store and retrieve elements efficiently. It computes a hash code for each key and uses this hash code to determine the bucket where the key-value pair should be stored. This allows for constant-time complexity for key-based operations on average.

5. Implementation: `Hashtable` is implemented as an array of linked lists, where each array index corresponds to a bucket. Each bucket contains a linked list of key-value pairs that hash to the same bucket index. In case of collisions (when two different keys hash to the same index), separate chaining is used to handle collisions by storing multiple entries in the same bucket.

6. Size and Empty Checks: The `size()` method returns the number of key-value pairs in the `Hashtable`, while the `isEmpty()` method checks if the `Hashtable` is empty by returning a boolean value.

7. Usage: `Hashtable` is useful in scenarios where you need a thread-safe and synchronized collection to store key-value pairs. It is commonly used in multithreaded applications or situations where concurrent access to the data structure is required.

When should you use `Hashtable`?

- When you need a thread-safe and synchronized implementation of a map to store key-value pairs.
- When you require a data structure that allows efficient lookup and retrieval of values based on keys.
- When you want to ensure data consistency and avoid concurrency issues in a multi-threaded environment.

However, it's important to note that if you don't require thread-safety, you can consider using other map implementations such as `HashMap` or `LinkedHashMap`, which are not synchronized and provide better performance in non-concurrent scenarios.
*/
