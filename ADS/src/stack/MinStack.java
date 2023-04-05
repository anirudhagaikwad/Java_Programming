package stack;
import java.util.Stack;

/*
A)Implement a stack that can return the minimum element in O(1) time.
*/

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(4);

        System.out.println("Minimum element in the stack: " + minStack.getMin());
        System.out.println("Top element in the stack: " + minStack.top());

        minStack.pop();

        System.out.println("Minimum element in the stack: " + minStack.getMin());
        System.out.println("Top element in the stack: " + minStack.top());
    }

}//end class

/*
One approach to solving this problem is to use two stacks, one to store the elements of the stack and another to store the minimum elements
In this implementation, the push operation checks whether the element being pushed is smaller than or equal to the current minimum element. If it is, it is pushed onto the minStack as well. The pop operation removes the top element from the stack and checks whether it is equal to the current minimum element. If it is, it is also removed from the minStack. The top operation returns the top element of the stack, and the getMin operation returns the top element of the minStack.

*/


