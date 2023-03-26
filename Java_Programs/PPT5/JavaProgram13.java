package PPT5;

/*
Given an array A[] of N integers such that A[0] + A[1] + A[2] + … A[N – 1] = 0. The task is to generate an array B[] such that B[i] is either ⌊A[i] / 2⌋ or ⌈A[i] / 2⌉ for all valid i and B[0] + B[1] + B[2] + … + B[N – 1] = 0.

Examples:

Input: A[] = {1, 2, -5, 3, -1}
Output: 0 1 -2 1 0
Input: A[] = {3, -5, -7, 9, 2, -2}
Output: 1 -2 -4 5 1 -1

*/

import java.util.*;
import java.lang.*;

class JavaProgram13
{

    static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Function to generate and print
// the required array
    static void generateArr(int arr[], int n)
    {

        // To switch the ceil and floor
        // function alternatively
        boolean flip = true;

        // For every element of the array
        for (int i = 0; i < n; i++)
        {

            // If the number is odd then print the ceil
            // or floor value after division by 2
            if ((arr[i] & 1) != 0)
            {

                // Use the ceil and floor alternatively
                if (flip ^= true)
                    System.out.print((int)(Math.ceil(arr[i] /
                            2.0)) + " ");
                else
                    System.out.print((int)(Math.floor(arr[i] /
                            2.0)) + " ");
            }

            // If arr[i] is even then it will
            // be completely divisible by 2
            else
            {
                System.out.print(arr[i] / 2 +" ");
            }
        }
    }

    public static void main(String []args)
    {
        int arr[] = { 3, -5, -7, 9, 2, -2 };
        int n = arr.length;

        generateArr(arr, n);
    }
}


