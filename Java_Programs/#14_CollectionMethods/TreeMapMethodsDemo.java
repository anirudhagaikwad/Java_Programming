import java.util.Map;
import java.util.TreeMap;

public class TreeMapMethodsDemo {
    public static void main(String[] args) {
        // Create a new TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Add key-value pairs to the TreeMap using the put() method
        treeMap.put("apple", 10);
        treeMap.put("banana", 5);
        treeMap.put("orange", 7);

        // Display the TreeMap
        System.out.println("TreeMap: " + treeMap);

        // Check if the TreeMap contains a specific key using the containsKey() method
        boolean containsKey = treeMap.containsKey("banana");
        System.out.println("Contains key 'banana'? " + containsKey);

        // Get the value associated with a specific key using the get() method
        int value = treeMap.get("apple");
        System.out.println("Value for key 'apple': " + value);

        // Get the first key in the TreeMap using the firstKey() method
        String firstKey = treeMap.firstKey();
        System.out.println("First key: " + firstKey);

        // Get the last key in the TreeMap using the lastKey() method
        String lastKey = treeMap.lastKey();
        System.out.println("Last key: " + lastKey);

        // Get the number of key-value mappings in the TreeMap using the size() method
        int size = treeMap.size();
        System.out.println("Size of TreeMap: " + size);

        // Remove a key-value pair from the TreeMap using the remove() method
        int removedValue = treeMap.remove("orange");
        System.out.println("Removed value: " + removedValue);

        // Display the TreeMap
        System.out.println("TreeMap: " + treeMap);

        // Iterate over the keys in the TreeMap using the keySet() method
        System.out.println("Iterating over keys in TreeMap:");
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key);
        }

        // Iterate over the values in the TreeMap using the values() method
        System.out.println("Iterating over values in TreeMap:");
        for (int val : treeMap.values()) {
            System.out.println("Value: " + val);
        }

        // Iterate over the key-value pairs in the TreeMap using the entrySet() method
        System.out.println("Iterating over key-value pairs in TreeMap:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Clear the TreeMap using the clear() method
        treeMap.clear();
        System.out.println("Cleared TreeMap: " + treeMap);
    }
}

/*
In Java, `TreeMap` is a class that implements the `SortedMap` interface and represents a collection of key-value pairs sorted by the keys. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `TreeMap`:

1. Sorted Order: `TreeMap` maintains the elements in a sorted order based on the natural ordering of the keys or a custom comparator provided during TreeMap creation. The keys are arranged in ascending order by default.

2. Key-Value Mapping: `TreeMap` allows you to store and retrieve values based on associated keys. Each key in the TreeMap is unique, meaning that it can only have one corresponding value. However, different keys can have the same value.

3. Red-Black Tree: Internally, `TreeMap` uses a self-balancing binary search tree called a red-black tree to store and organize the key-value pairs. This data structure ensures efficient search, insertion, and deletion operations with a time complexity of O(log n).

4. Performance: `TreeMap` provides efficient operations for adding, removing, and searching for elements based on the keys. The time complexity for basic operations such as `put()`, `get()`, `containsKey()`, and `remove()` is O(log n). However, the actual performance can be affected by factors such as the number of elements and the quality of the comparator.

5. Navigable Map: `TreeMap` implements the `NavigableMap` interface, which extends the `SortedMap` interface. This allows you to perform various navigational operations such as finding the closest keys, getting subsets based on key ranges, and performing range-based queries.

6. Null Keys: `TreeMap` does not allow `null` keys. All keys must be non-null. If you attempt to add a `null` key, it will throw a `NullPointerException`.

7. Null Values: `TreeMap` allows the inclusion of `null` values. This means you can store `null` values associated with keys in a `TreeMap`.

8. Iteration and Traversal: You can iterate over the key-value pairs in a `TreeMap` using iterators or enhanced for-each loops. The elements will be traversed in the sorted order of the keys.

When should you use `TreeMap`?

- When you need a collection that maintains key-value pairs in a sorted order based on the keys.
- When you want efficient searching, insertion, and removal of elements based on the keys.
- When you need to perform navigational operations such as finding closest keys or getting subsets based on key ranges.
- When you require automatic sorting of keys in a collection.

`TreeMap` provides a sorted map implementation in Java that ensures key-value pairs are maintained in a specific order based on the keys. It offers efficient operations for adding, removing, and searching elements, making it suitable for scenarios where you need a sorted collection or need to perform navigational operations based on keys.
*/
