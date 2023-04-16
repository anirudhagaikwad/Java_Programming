package PPT5;
/*
Given an array arr[] of size N ( N is even ), the task is to construct an array B[] such that the sum of B[i] XOR PrefixXor[i], where 1 ≤ i ≤ N is even and is divisible by the first N/2 elements of arr[].

PrefixXor[] array is an array where each element will indicate the XOR of all elements from 1st element to the current index element.

Examples:

Input: N = 4, arr[] = {2, 6, 1, 5}
Output: B[] = {0, 6, 3, 6}
Explanation: Since, prefix array is prefixXor[] = {2, 4, 5, 0}, (2 ^ 0) + (4 ^ 6) + (5 ^ 3) + (0^6) = 2 + 2 + 6 + 6 = 16, which is even and divisible by 8.

*/

import java.util.*;

class JavaProgram12 {

    // Function to generates valid array according to the given conditions
    public static void valid_array_formation(int N,
                                             int arr[])
    {
        int prefix_xor[] = new int[N];
        prefix_xor[0] = arr[0];

        // Calculating the prefix xor array
        for (int i = 1; i < N; i++) {
            prefix_xor[i] = prefix_xor[i - 1] ^ arr[i];
        }

        int B[] = new int[N];

        // Pointer to extract which element
        // is to be extracted from array a
        int pointer = 0;

        int difference = 0;

        for (int i = 0; i < N; i++) {

            // If difference becomes 2 then we
            // increment the pointer
            if (difference == 2) {
                pointer++;
                difference = 0;
            }

            // B[i] i calculated accordingly
            B[i] = prefix_xor[i] ^ arr[pointer];
            difference++;
        }

        for (int i = 0; i < N; i++) {

            // Printing the required array b
            System.out.print(B[i] + " ");
        }

        System.out.println();
    }


    public static void main(String args[])
    {

        // Test case 1
        int N = 4;
        int arr1[] = { 2, 6, 1, 5 };

        // Function call
        valid_array_formation(N, arr1);

        // Test case 2
        N = 6;
        int arr2[] = { 2, 5, 3, 4, 6, 1 };

        // Function call
        valid_array_formation(N, arr2);
    }
}

