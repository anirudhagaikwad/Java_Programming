package PPT3;
/*
Given two numbers x and y. We have to write a Java Program to Swap the contents of two numbers using Bitwise XOR Operation.

Input 1: x = 5, y = 10
Output : x = 10, y = 5
Explaination :
1. x = x ^ y -> x = 15
2. y = x ^ y -> y = 5
3. x = x ^ y -> x = 10

Input 2: x = 15, y = 20
Output : x = 20, y = 15
*/

import java.io.*;
class JavaProgram8 {
    public static void main(String[] args)
    {
        int x = 5, y = 10;
        // binary equivalent of 5 is 0101
        // binary equivalent of 10 is 1010

        // binary equivalent of x will become 1111 ie x=15
        x = x ^ y;
        // binary equivalent of y will become 0101 ie y=5
        y = x ^ y;
        // binary equivalent of x will become 1010 ie x=10
        x = x ^ y;
        System.out.println("The value of x is " + x
                + " and the value of y is " + y);
    }
}


