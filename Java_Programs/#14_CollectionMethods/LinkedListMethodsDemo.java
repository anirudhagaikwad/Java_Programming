import java.util.LinkedList;
import java.util.Spliterator;
import java.util.Iterator;

public class LinkedListMethodsDemo {

    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding elements to the LinkedList using add()
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        // Printing the LinkedList
        System.out.println("LinkedList: " + linkedList);

        // Adding an element at the beginning using addFirst()
        linkedList.addFirst("Avocado");
        System.out.println("LinkedList after adding at the beginning: " + linkedList);

        // Adding an element at the end using addLast()
        linkedList.addLast("Elderberry");
        System.out.println("LinkedList after adding at the end: " + linkedList);

        // Getting the first element using getFirst()
        String firstElement = linkedList.getFirst();
        System.out.println("First element: " + firstElement);

        // Getting the last element using getLast()
        String lastElement = linkedList.getLast();
        System.out.println("Last element: " + lastElement);

        // Removing the first element using removeFirst()
        linkedList.removeFirst();
        System.out.println("LinkedList after removing the first element: " + linkedList);

        // Removing the last element using removeLast()
        linkedList.removeLast();
        System.out.println("LinkedList after removing the last element: " + linkedList);

        // Checking if an element is present using contains()
        boolean containsBanana = linkedList.contains("Banana");
        System.out.println("Contains 'Banana'? " + containsBanana);

        // Getting the size of the LinkedList using size()
        int size = linkedList.size();
        System.out.println("Size of LinkedList: " + size);

        // Removing an element using remove()
        boolean removed = linkedList.remove("Cherry");
        System.out.println("Removed 'Cherry'? " + removed);
        System.out.println("LinkedList after removal: " + linkedList);

        // Reversing the order of elements using descendingIterator()
        System.out.print("LinkedList elements in reverse order: ");
        Iterator iter=linkedList.descendingIterator();
        while (iter.hasNext()) {
            
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // Clearing the LinkedList using clear()
        linkedList.clear();
        System.out.println("Cleared LinkedList: " + linkedList);

        // Checking if the LinkedList is empty using isEmpty()
        boolean empty = linkedList.isEmpty();
        System.out.println("Is LinkedList empty? " + empty);
        
          // Adding an element at the beginning using push()
        linkedList.push("Grapes");
        System.out.println("LinkedList after pushing an element: " + linkedList);

        // Removing and retrieving the first element using pollFirst()
        String polledElement = linkedList.pollFirst();
        System.out.println("Polled element: " + polledElement);
        System.out.println("LinkedList after polling the first element: " + linkedList);

        // Using spliterator() to split the LinkedList into multiple parts
        Spliterator<String> spliterator = linkedList.spliterator();
        System.out.print("LinkedList elements using spliterator(): ");
        spliterator.forEachRemaining((element) -> System.out.print(element + " "));
        System.out.println();
        
         // Converting LinkedList to an array using toArray()
        Object[] array = linkedList.toArray();
        System.out.print("Array elements from LinkedList using toArray(): ");
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Converting LinkedList to a Typed Array using toArray(T[] a)
        String[] typedArray = linkedList.toArray(new String[linkedList.size()]);
        System.out.print("Typed Array elements from LinkedList using toArray(T[] a): ");
        for (String element : typedArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

/*
LinkedList is a class in Java that implements the List interface and provides a linked list data structure. It stores elements in a sequential manner where each element is represented by a node containing the element itself and references to the previous and next nodes. This structure allows for efficient insertion, deletion, and manipulation of elements within the list.

Here are some key points to understand about LinkedList:

1. Linked Structure: LinkedList is implemented as a doubly linked list, meaning that each node in the list has references to both the previous and next nodes. This allows for easy traversal in both directions.

2. Dynamic Size: LinkedList is a dynamic data structure, meaning that it can grow or shrink dynamically as elements are added or removed. Unlike arrays, LinkedList does not require a fixed size and can expand or contract as needed.

3. Insertion and Removal: LinkedList provides efficient insertion and removal operations. Insertion and removal at the beginning or end of the list are generally fast since it involves updating the references of neighboring nodes. However, accessing elements at arbitrary positions in the list can be slower compared to random access data structures like arrays.

4. Iteration: LinkedList supports both forward and backward iteration. It provides methods like `getFirst()` and `getLast()` to access the first and last elements of the list, as well as iterators to iterate over the elements in the list.

5. Manipulation: LinkedList offers methods to manipulate the list, such as adding elements at the beginning or end (`addFirst()`, `addLast()`), removing elements (`removeFirst()`, `removeLast()`), and more. These operations can be performed efficiently due to the linked structure.

6. Flexibility: LinkedList allows for the storage of elements of any type. It can store objects of any class and also allows for storing `null` values.

7. Performance Considerations: While LinkedList provides efficient insertion and removal operations, random access to elements (accessing elements at arbitrary positions) can be slower compared to other data structures like ArrayList. This is because LinkedList requires traversing the list from the beginning or end to reach the desired position.

LinkedList is useful in scenarios where frequent insertion or removal operations are required at the beginning or end of the list, as these operations have a constant time complexity. It is also beneficial when there is a need for efficient manipulation of elements within the list.

However, if random access to elements or frequent access by index is required, ArrayList may be a more suitable choice as it provides faster access times. The choice between LinkedList and ArrayList depends on the specific requirements of the application and the operations performed on the list.
*/
