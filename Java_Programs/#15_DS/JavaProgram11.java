package PPT15;
/*
A stack permutation is a permutation of objects in the given input queue which is done by transferring elements from the input queue to the output queue with the help of a stack and the built-in push and pop functions.

The rules are:
-Only dequeue from the input queue.
-Use inbuilt push, and pop functions in the single stack.
-Stack and input queue must be empty at the end.
-Only enqueue to the output queue.

There are a huge number of permutations possible using a stack for a single input queue.
Given two arrays, both of unique elements. One represents the input queue and the other represents the output queue. Our task is to check if the given output is possible through stack permutation.

Input: arr1[] = [ 1, 2, 3 ] , arr2[] = [ 2, 1, 3 ]
Output: YES
Explanation:
push 1 from input to stack
push 2 from input to stack
pop 2 from stack to output
pop 1 from stack to output
push 3 from input to stack
pop 3 from stack to output

Input: arr1[] = [ 1, 2, 3 ] , arr2[] = [ 3, 1, 2 ]
Output: Not Possible

*/
import java.util.Stack;
class JavaProgram11 {
    // function to check if input array is permutable to output array
    static Boolean checkStackPermutation(int ip[], int op[],
                                         int n)
    {
        // we will be pushing elements from input array to stack uptill top of our stack matches with first element of output array
        Stack<Integer> s = new Stack<Integer>();

        // will maintain a variable j to iterate on output array
        int j = 0;

        // will iterate one by one in input array
        for (int i = 0; i < n; i++) {
            // pushed an element from input array to stack
            s.push(ip[i]);
            // if our stack isn't empty and top matches with
            // output array then we will keep popping out
            // from stack uptill top matches with output array
            while (!s.isEmpty() && s.peek() == op[j]) {
                s.pop();
                // increasing j so next time we can compare next element in output array
                j++;
            }
        }

        // if output array was a correct permutation of input array then by now our stack should be empty
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }


    public static void main(String args[])
    {
        // Input Array
        int input[] = { 4, 5, 6, 7, 8 };

        // Output Array
        int output[] = { 8, 7, 6, 5, 4 };

        int n = 5;

        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }
}

