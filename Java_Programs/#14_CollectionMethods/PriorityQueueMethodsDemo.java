import java.util.PriorityQueue;

public class PriorityQueueMethodsDemo {
    public static void main(String[] args) {
        // Create a new PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements to the PriorityQueue using the add() method
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(8);

        // Display the PriorityQueue
        System.out.println("PriorityQueue: " + priorityQueue);

        // Get the top element of the PriorityQueue without removing it using the peek() method
        Integer topElement = priorityQueue.peek();
        System.out.println("Top element: " + topElement);

        // Get the number of elements in the PriorityQueue using the size() method
        int size = priorityQueue.size();
        System.out.println("Size of PriorityQueue: " + size);

        // Remove the top element from the PriorityQueue using the poll() method
        Integer removedElement = priorityQueue.poll();
        System.out.println("Removed element: " + removedElement);

        // Display the PriorityQueue
        System.out.println("PriorityQueue: " + priorityQueue);

        // Check if the PriorityQueue contains a specific element using the contains() method
        boolean containsElement = priorityQueue.contains(5);
        System.out.println("Does PriorityQueue contain 5? " + containsElement);

        // Iterate over the elements in the PriorityQueue using the iterator() method
        System.out.println("Iterating over elements in PriorityQueue:");
        for (Integer element : priorityQueue) {
            System.out.println("Element: " + element);
        }

        // Convert the PriorityQueue to an array using the toArray() method
        Object[] array = priorityQueue.toArray();
        System.out.println("PriorityQueue as array: " + java.util.Arrays.toString(array));

        // Clear the PriorityQueue using the clear() method
        priorityQueue.clear();
        System.out.println("Cleared PriorityQueue: " + priorityQueue);
    }
}

/*
In Java, `PriorityQueue` is a class that represents an unbounded priority queue. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `PriorityQueue`:

1. Priority-Based Ordering: `PriorityQueue` orders its elements based on their priority. The priority is determined either by the natural ordering of the elements (if they implement the `Comparable` interface) or by a custom `Comparator` provided at construction time. The elements with higher priority are dequeued first.

2. Implementation: `PriorityQueue` is implemented as a priority heap, which is a complete binary tree with the property that the priority of each parent node is higher than or equal to the priorities of its children. This heap structure allows for efficient insertion and removal of elements, ensuring that the element with the highest priority is always at the front of the queue.

3. Duplicate Elements: `PriorityQueue` allows duplicate elements. Elements with the same priority are ordered based on their insertion order.

4. Size and Empty Checks: The `size()` method returns the number of elements in the `PriorityQueue`, while the `isEmpty()` method checks if the queue is empty by returning a boolean value.

5. Element Insertion: Elements can be inserted into the `PriorityQueue` using the `add(element)` or `offer(element)` methods. These methods insert the element at an appropriate position based on its priority.

6. Element Retrieval and Removal: The `peek()` method retrieves the element with the highest priority without removing it from the queue. The `poll()` method retrieves and removes the element with the highest priority from the queue. Both methods return `null` if the queue is empty.

7. Usage: `PriorityQueue` is commonly used in scenarios where elements need to be processed in a specific order based on their priority. It is useful in various applications such as task scheduling, event-driven systems, and graph algorithms like Dijkstra's algorithm.

When should you use `PriorityQueue`?

- When you need a collection that orders elements based on their priority.
- When you want to retrieve and remove elements in a specific order, such as the smallest or largest element first.
- When you require efficient insertion and removal of elements in logarithmic time complexity (O(log n)).
- When you need a data structure that automatically maintains the order of elements as they are added.

It's important to note that `PriorityQueue` is not thread-safe. If you need to use a priority queue in a concurrent environment, you can use the `PriorityBlockingQueue` class, which provides thread-safe operations.

Keep in mind that the performance characteristics of a `PriorityQueue` are influenced by the choice of element ordering and the complexity of the `Comparator` or natural ordering logic.
*/
