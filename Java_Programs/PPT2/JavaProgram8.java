package PPT2;
/*
Problem Statement: Given two integers m and n. The goal is simply to swap their values in the memory block and writing the java code demonstrating approaches.

Illustration:

Input  : m=9, n=5
Output : m=5, n=9

Input  : m=15, n=5
Output : m=5, n=15
*/


import java.util.*;

class JavaProgram8 {
    public static void main(String[] args)
    {
        // Random integer values
        int m = 9, n = 5;
        System.out.println("Value of m is " + m
                + " and Value of n is " + n);
       // Swapping the values
        int temp = m;
        m = n;
        n = temp;
        System.out.println("Value of m is " + m
                + " and Value of n is " + n);
    }
}

