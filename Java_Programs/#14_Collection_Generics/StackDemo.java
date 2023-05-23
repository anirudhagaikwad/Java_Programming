import java.util.EmptyStackException;

class Stack<E> {
    private Object[] stack;
    private int top;
    private int capacity;
    
    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
        this.top = -1;
    }
    
    public void push(E element) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = element;
    }
    
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) stack[top--];
    }
    
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
    }
}

/*
The Stack<E> class is implemented using an array of Object type, allowing it to store elements of any type. It also maintains a top variable to keep track of the index of the top element in the stack, and a capacity variable to specify the maximum capacity of the stack.

The class provides the following operations:

push(E element): Inserts the specified element onto the top of the stack. If the stack is already full, it throws an IllegalStateException.

pop(): Removes and returns the element at the top of the stack. If the stack is empty, it throws an EmptyStackException.

peek(): Returns the element at the top of the stack without removing it. If the stack is empty, it throws an EmptyStackException.

isEmpty(): Checks if the stack is empty and returns a boolean value accordingly.

size(): Returns the number of elements in the stack.



*/
