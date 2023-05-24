import java.util.TreeSet;

public class TreeSetMethodsDemo {
    public static void main(String[] args) {
        // Create a new TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Add elements to the TreeSet using the add() method
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);

        // Display the TreeSet
        System.out.println("TreeSet: " + treeSet);

        // Check if the TreeSet contains a specific element using the contains() method
        boolean containsElement = treeSet.contains(2);
        System.out.println("Contains element 2? " + containsElement);

        // Get the first element in the TreeSet using the first() method
        int firstElement = treeSet.first();
        System.out.println("First element: " + firstElement);

        // Get the last element in the TreeSet using the last() method
        int lastElement = treeSet.last();
        System.out.println("Last element: " + lastElement);

        // Get the number of elements in the TreeSet using the size() method
        int size = treeSet.size();
        System.out.println("Size of TreeSet: " + size);

        // Remove an element from the TreeSet using the remove() method
        boolean removed = treeSet.remove(2);
        System.out.println("Removed element 2? " + removed);

        // Display the TreeSet
        System.out.println("TreeSet: " + treeSet);

        // Iterate over the elements in the TreeSet using the iterator() method
        System.out.println("Iterating over elements in TreeSet:");
        for (Integer element : treeSet) {
            System.out.println(element);
        }

        // Get a subset of elements from the TreeSet using the subSet() method
        TreeSet<Integer> subSet = (TreeSet<Integer>) treeSet.subSet(5, 8);
        System.out.println("Subset of TreeSet: " + subSet);

        // Get a subset of elements from the TreeSet using the headSet() method
        TreeSet<Integer> headSet = (TreeSet<Integer>) treeSet.headSet(5);
        System.out.println("HeadSet of TreeSet: " + headSet);

        // Get a subset of elements from the TreeSet using the tailSet() method
        TreeSet<Integer> tailSet = (TreeSet<Integer>) treeSet.tailSet(5);
        System.out.println("TailSet of TreeSet: " + tailSet);

        // Clear the TreeSet using the clear() method
        treeSet.clear();
        System.out.println("Cleared TreeSet: " + treeSet);
    }
}

/*
In Java, `TreeSet` is a class that implements the `SortedSet` interface and represents a collection of elements stored in a sorted order. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `TreeSet`:

1. Sorted Order: `TreeSet` maintains the elements in a sorted order. By default, it uses the natural ordering of the elements. Alternatively, you can provide a custom `Comparator` during TreeSet creation to specify a custom sorting order.

2. Unique Elements: `TreeSet` does not allow duplicate elements. It ensures that each element in the set is unique based on the comparison criteria.

3. Red-Black Tree: Internally, `TreeSet` uses a self-balancing binary search tree called a red-black tree to store and organize the elements. This data structure ensures efficient search, insertion, and deletion operations with a time complexity of O(log n).

4. Performance: `TreeSet` provides efficient operations for adding, removing, and searching for elements in a sorted set. However, the performance may degrade if the number of elements becomes significantly large due to the underlying balanced tree structure.

5. Navigable Set: `TreeSet` implements the `NavigableSet` interface, which extends the `SortedSet` interface. This allows you to perform various navigational operations such as finding the closest elements, getting subsets, and performing range-based queries.

6. Null Values: `TreeSet` does not allow `null` elements. All elements must be non-null. If you attempt to add a `null` element, it will throw a `NullPointerException`.

7. Ordering and Comparator: As mentioned earlier, `TreeSet` stores elements in a sorted order. You can rely on the natural ordering of elements or provide a custom `Comparator` to define a specific sorting order. The `Comparator` is used for comparison purposes when inserting, removing, and searching for elements.

8. Iteration and Traversal: You can iterate over the elements in a `TreeSet` using iterators or enhanced for-each loops. The elements will be traversed in the sorted order.

When should you use `TreeSet`?

- When you need a collection that maintains elements in a sorted order.
- When you want to perform efficient searching, insertion, and removal of elements based on their natural or custom order.
- When you need to perform navigational operations such as finding closest elements or getting subsets of elements.
- When duplicate elements should be automatically removed.

`TreeSet` provides a sorted set implementation in Java that ensures elements are maintained in a specific order. It offers efficient operations for adding, removing, and searching elements, making it suitable for scenarios where you need a sorted collection or need to perform navigational operations.
*/
