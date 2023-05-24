import java.util.Stack;

public class StackMethodsDemo {
    public static void main(String[] args) {
        // Create a new Stack
        Stack<String> stack = new Stack<>();

        // Push elements onto the stack using the push() method
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");

        // Display the stack
        System.out.println("Stack: " + stack);

        // Get the top element of the stack without removing it using the peek() method
        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Get the number of elements in the stack using the size() method
        int size = stack.size();
        System.out.println("Size of stack: " + size);

        // Pop the top element from the stack using the pop() method
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Display the stack
        System.out.println("Stack: " + stack);

        // Check if the stack is empty using the empty() method
        boolean isEmpty = stack.empty();
        System.out.println("Is stack empty? " + isEmpty);

        // Search for an element in the stack using the search() method
        int position = stack.search("banana");
        System.out.println("Position of 'banana' in stack: " + position);

        // Clear the stack using the clear() method
        stack.clear();
        System.out.println("Cleared stack: " + stack);
    }
}

/*
In Java, `Stack` is a class that represents a Last-In-First-Out (LIFO) data structure. It is part of the Java Collections Framework and is available in the `java.util` package.

Here are some key characteristics and features of `Stack`:

1. LIFO Behavior: `Stack` follows the LIFO principle, which means that the last element added to the stack is the first one to be removed. Elements are added and removed from the top of the stack.

2. Inheritance: `Stack` is a subclass of the `Vector` class, which provides an array-like implementation of a dynamic array. However, it is recommended to use the `Deque` interface and its implementing class `LinkedList` instead of `Stack`, as they offer better performance and additional functionality.

3. Push and Pop: Elements are added to the top of the stack using the `push()` method and removed from the top using the `pop()` method. The `push()` method inserts an element at the top of the stack, while the `pop()` method removes and returns the topmost element.

4. Peek: The `peek()` method allows you to retrieve the top element of the stack without removing it. It returns the element at the top of the stack but does not modify the stack.

5. Size and Empty Checks: The `size()` method returns the number of elements in the stack, while the `empty()` method checks if the stack is empty by returning a boolean value.

6. Search: The `search(element)` method searches for a specific element in the stack and returns its position (1-based index). If the element is found, its distance from the top of the stack is returned. If the element is not found, `-1` is returned.

7. Usage: `Stack` is commonly used in scenarios where a Last-In-First-Out behavior is required, such as parsing expressions, implementing undo-redo functionality, and solving problems involving recursion or depth-first search algorithms.

When should you use `Stack`?

- When you need to implement a Last-In-First-Out (LIFO) data structure.
- When you want to add elements to the top of the stack and remove them from the top.
- When you require basic stack operations such as push, pop, peek, and empty checks.

It's worth noting that since Java 1.5, the `Deque` interface and its implementing class `LinkedList` provide the same functionality as `Stack`, but with additional methods and better performance. Therefore, it is generally recommended to use `Deque` and `LinkedList` instead of `Stack` for new implementations.
*/
