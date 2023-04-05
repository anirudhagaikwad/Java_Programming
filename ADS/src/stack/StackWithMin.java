package stack;

/*
B)Design a stack that supports the following operations in O(1) time: push, pop, top, getMin, and size.

The StackWithMin class implements a stack that supports finding the minimum element in constant time. It does so by storing, for each element in the stack, the minimum element seen so far.

The implementation uses a private nested class Node to represent each element in the stack. Each Node has three fields: val (the value of the element), next (a reference to the next Node in the stack), and min (the minimum element seen so far up to this Node).

The StackWithMin class also has fields top (a reference to the top Node in the stack), min (the minimum element seen so far), and size (the size of the stack).

The push() method adds a new element to the top of the stack. It first computes the new minimum element by taking the minimum of the new element and the current minimum element seen so far. It then creates a new Node with the new element, the new minimum, and the current top Node as the next Node. Finally, it sets the top Node to the new Node, updates the minimum element seen so far to the new minimum, and increments the size of the stack.

The pop() method removes the top element from the stack. It simply sets the top Node to the next Node and updates the minimum element seen so far to the minimum of the new top Node.

The top() method returns the value of the top element in the stack. It simply returns the val field of the top Node.

The getMin() method returns the minimum element seen so far in the stack. It simply returns the min field of the top Node.

The size() method returns the size of the stack. It simply returns the size field.
*/

class StackWithMin {
    private Node top;
    private int min;
    private int size;

    private class Node {
        int val;
        Node next;
        int min;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public StackWithMin() {
        top = null;
        min = Integer.MAX_VALUE;
        size = 0;
    }

    public void push(int x) {
        int newMin = Math.min(x, min);
        Node newNode = new Node(x, newMin, top);
        top = newNode;
        min = newMin;
        size++;
    }

    public void pop() {
        if (top == null) return;
        top = top.next;
        min = top.min;
        size--;
    }

    public int top() {
        if (top == null) return -1;
        return top.val;
    }

    public int getMin() {
        if (top == null) return -1;
        return top.min;
    }

    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Minimum element: " + stack.getMin());
        stack.pop();
        System.out.println("Top element after pop: " + stack.top());
        System.out.println("Minimum element after pop: " + stack.getMin());
    }

}//end class

/*
To support all these operations in O(1) time, we can use a linked list implementation of a stack and store some additional information about the minimum element and the size of the stack. 

In this implementation, we use a Node class to represent each element in the stack. Each node stores the element value, the minimum element value seen so far, and a reference to the next node in the stack. When we push a new element onto the stack, we calculate the new minimum element value and store it in the min field of the StackWithMin class. We also update the size of the stack. When we pop an element, we simply remove the top node from the stack.

*/
