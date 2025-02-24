package collectionsMethods;
/*

## 1. Introduction to Collection Framework  
The Java Collection Framework (JCF) is a unified architecture for managing and manipulating collections 
of objects. It provides reusable data structures and algorithms, reducing the need for custom implementations.  

### Purpose of Collection Framework:  
- Provides efficient data structures.  
- Eliminates the need for boilerplate code.  
- Supports sorting, searching, and iteration.  
- Enhances code reusability and performance.  
- Offers thread-safe collections.  

---

## 2. Collection Framework Hierarchy  

```
java.util.Collection (Interface)  
│  
├── java.util.List (Interface)  
│   ├── java.util.ArrayList (Class)  
│   ├── java.util.LinkedList (Class)  
│   ├── java.util.Vector (Class)  
│   ├── java.util.Stack (Class)  
│  
├── java.util.Queue (Interface)  
│   ├── java.util.PriorityQueue (Class)  
│   ├── java.util.LinkedList (Class)  
│  
├── java.util.Deque (Interface)  
│   ├── java.util.ArrayDeque (Class)  
│   ├── java.util.LinkedList (Class)  
│  
└── java.util.Set (Interface)  
    ├── java.util.HashSet (Class)  
    ├── java.util.LinkedHashSet (Class)  
    ├── java.util.TreeSet (Class)  
```

```
java.util.Map (Interface)  
│  
├── java.util.HashMap (Class)  
├── java.util.LinkedHashMap (Class)  
├── java.util.TreeMap (Class)  
├── java.util.Hashtable (Class)  
└── java.util.WeakHashMap (Class)  
```

---

## 3. Interfaces in Collection Framework  

| Interface | Description |
|--------------|----------------|
| `Collection<E>` | Root interface of all collection classes. |
| `List<E>` | Ordered collection allowing duplicate elements. |
| `Set<E>` | Unordered collection with unique elements. |
| `Queue<E>` | Follows FIFO (First-In-First-Out) order. |
| `Deque<E>` | Double-ended queue (allows insertion/removal from both ends). |
| `Map<K, V>` | Key-value pair storage. |

---

## 4. List Implementations  

### ArrayList
- Uses a dynamic array.
- Fast random access (`O(1)`) but slow insertion/removal (`O(n)`).
- Not synchronized.

Use Case: Best for read-heavy operations, like caching.

---

### LinkedList
- Uses a doubly linked list.
- Fast insertion/removal (`O(1)`) but slow access (`O(n)`).
- Implements both `List` and `Deque`.

Use Case: Best for applications requiring frequent insertions/deletions.

---

### Vector
- Similar to `ArrayList` but synchronized.
- Thread-safe.

Use Case: Suitable for multi-threaded applications.

---

### Stack
- Follows LIFO (Last-In-First-Out).
- Extends `Vector`.

Use Case: Used for expression evaluation, undo-redo operations.

---

## 5. Set Implementations  

### HashSet
- Uses a hash table for fast lookups (`O(1)`).
- Does not maintain order.

Use Case: Storing unique elements (e.g., a list of user IDs).

---

### LinkedHashSet
- Maintains insertion order.
- Slightly slower than `HashSet`.

Use Case: Keeping unique items while maintaining order (e.g., caching systems).

---

### TreeSet
- Implemented using a Red-Black Tree.
- Sorted set (`O(log n)` operations).

Use Case: Used when a sorted unique collection is needed.

---

## 6. Queue and Deque Implementations  

### PriorityQueue
- Elements are sorted based on natural ordering or a custom `Comparator`.
- Not thread-safe.

Use Case: Implementing priority-based task scheduling.

---

### ArrayDeque
- Faster than `Stack` and `LinkedList`.
- Supports both FIFO and LIFO.

Use Case: Used as a deque or stack replacement.

---

## 7. Map Implementations  

### HashMap
- Stores key-value pairs using a hash table (`O(1)`).
- Allows one null key.

Use Case: Fast lookup of data, like caching user sessions.

---

### LinkedHashMap
- Maintains insertion order.

Use Case: Storing frequently used items in an ordered manner.

---

### TreeMap
- Implemented using Red-Black Tree.
- Sorted map (`O(log n)`).

Use Case: Sorting data dynamically (e.g., sorting stock prices).

---

### Hashtable
- Thread-safe but slower.
- Does not allow `null` keys.

Use Case: Used in legacy multi-threaded applications.

---

## 8. Comparisons of Collection Types  

| Feature | ArrayList | LinkedList | HashSet | TreeSet | HashMap | TreeMap |
|------------|--------------|---------------|-------------|-------------|-------------|-------------|
| Ordering | Yes (index-based) | Yes (linked order) | No | Yes (sorted) | No | Yes (sorted) |
| Duplicates | Yes | Yes | No | No | Keys: No, Values: Yes | Keys: No, Values: Yes |
| Performance | Fast (`O(1)`) | Slow (`O(n)`) | Fast (`O(1)`) | Slow (`O(log n)`) | Fast (`O(1)`) | Slow (`O(log n)`) |

---

## 9. Synchronization and Thread Safety in Collections  

### Legacy Synchronized Classes
- Vector  
- Hashtable  

### Modern Synchronization Approaches
- ConcurrentHashMap – Thread-safe alternative to `HashMap`.
- CopyOnWriteArrayList – Thread-safe alternative to `ArrayList`.
- BlockingQueue – Used in concurrent processing.

---

## 10. Real-World Use Cases Table  

| Use Case | Best Collection to Use | Reason |
|-------------|---------------------------|------------|
| Unique users in a system | `HashSet` | Fast lookup and uniqueness. |
| Leaderboard rankings | `TreeSet` | Sorted order and uniqueness. |
| Task queue for background jobs | `PriorityQueue` | Prioritization of jobs. |
| Browser history | `Stack` | LIFO order. |
| Cache with limited size | `LinkedHashMap` | Maintains insertion order with fast lookups. |
| Thread-safe data store | `ConcurrentHashMap` | Efficient thread-safe map. |

---

## 11. Collection Utility Classes (`java.util.Collections`)  
Java provides utility methods for working with collections.

| Method | Description |
|-----------|----------------|
| `sort(List<T> list)` | Sorts a list. |
| `reverse(List<T> list)` | Reverses elements in a list. |
| `max(Collection<T> col)` | Returns the max element. |
| `min(Collection<T> col)` | Returns the min element. |
| `synchronizedList(List<T> list)` | Converts a list to a thread-safe list. |
| `unmodifiableList(List<T> list)` | Creates an immutable list. |

---

## 12. Advantages of Collection Framework  
- Reusability – Pre-built implementations save development time.  
- Efficiency – Optimized data structures improve performance.  
- Thread Safety – Provides concurrent utilities for multi-threading.  
- Scalability – Can handle large amounts of data.  

---

## 13. When to Use Collection Framework?  
| Scenario | Best Collection |
|-------------|------------------|
| Fast lookup | `HashMap`, `HashSet` |
| Sorted order | `TreeSet`, `TreeMap` |
| FIFO processing | `Queue` |
| LIFO processing | `Stack`, `Deque` |
| Multi-threaded access | `ConcurrentHashMap`, `CopyOnWriteArrayList` |

---

## Conclusion  
The Java Collection Framework provides a powerful and flexible set of classes and interfaces for handling 
data efficiently. It supports various use cases like caching, queueing, sorting, and searching, making it 
an essential part of Java development. 🚀
 */
public class CollectionFremwork {

}
