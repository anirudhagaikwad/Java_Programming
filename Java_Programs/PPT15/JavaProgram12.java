package PPT15;

/*
Given a source stack, copy the contents of the source stack to destination stack maintaining the same order without using extra space.

Examples:

Input : Source:- |3|
                 |2|
                 |1|

Output : Destination:- |3|
                       |2|
                       |1|
*/

import java.util.*;

// Define a class for Stack
class Stack {
    private List<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        int topVal = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return topVal;
    }

    public int length() {
        return stack.size();
    }

    public void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
        System.out.println();
    }
}

public class JavaProgram12 {
    public static void main(String[] args) {
        Stack source = new Stack(); // Source Stack
        Stack dest = new Stack(); // Destination Stack

        source.push(1);
        source.push(2);
        source.push(3);

        System.out.println("Source Stack:");
        source.display();

        int count = 0;

        // Reverse the order of the values in source stack
        while (count != source.length() - 1) {
            int topVal = source.pop();
            while (count != source.length()) {
                dest.push(source.pop());
            }
            source.push(topVal);
            while (dest.length() != 0) {
                source.push(dest.pop());
            }
            count += 1;
        }

        // Pop the values from source and push into destination stack
        while (source.length() != 0) {
            dest.push(source.pop());
        }

        System.out.println("Destination Stack:");
        dest.display();
    }
}


