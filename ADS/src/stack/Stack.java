package stack;

/*
In this example, we create a new Stack object with a maximum capacity of 5 and insert 5 elements into the stack. We then print the initial stack using the printStack helper method.

Next, we update the element at index 2 to have a value of 35, and print the updated stack.

We then delete the top element of the stack and print the stack again.

Finally, we search for the element with a value of 20 in the stack, and print the result of the search.
*/
public class Stack {
    private int[] data;
    private int top;

    public Stack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public void insert(int value) {
        if (top == data.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        top++;
        data[top] = value;
    }

    public void update(int index, int value) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        data[index] = value;
    }

    public int delete() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        int value = data[top];
        top--;
        return value;
    }

    public int search(int value) {
        for (int i = top; i >= 0; i--) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.insert(10);
        stack.insert(20);
        stack.insert(30);
        stack.insert(40);
        stack.insert(50);

        System.out.println("Initial Stack: ");
        printStack(stack);

        stack.update(2, 35);
        System.out.println("After updating element at index 2: ");
        printStack(stack);

        stack.delete();
        System.out.println("After deleting top element: ");
        printStack(stack);

        int index = stack.search(20);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }
    }

    private static void printStack(Stack stack) {
        int top = stack.top;
        while (top >= 0) {
            System.out.println(stack.data[top]);
            top--;
        }
    }

}//end class

/*
The Stack class has a private integer array called data that stores the elements of the stack, and an integer top that tracks the index of the top element. The constructor takes an integer argument that specifies the maximum capacity of the stack.

The insert method takes an integer value as input and adds it to the top of the stack. If the stack is already full, it throws a RuntimeException.

The update method takes an integer index and a new integer value as input, and updates the element at the specified index in the stack with the new value. If the index is out of bounds, it throws an IndexOutOfBoundsException.

The delete method removes and returns the top element of the stack. If the stack is empty, it throws a RuntimeException.

The search method takes an integer value as input and returns the index of the first occurrence of that value in the stack, starting from the top. If the value is not found, it returns -1.

Overall, this implementation provides a basic implementation of a stack data structure in Java with insert, update, delete, and search methods.
*/