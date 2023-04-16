package PPT15;
/*
Given an array arr[] of distinct positive elements, the task is to find the number of unique pairs (a, b) such that a is the maximum and b is the second maximum element of some subarray of the given array.
Examples:


Input: arr[] = {1, 2, 3}
Output: 2
{1, 2}, {2, 3}, {1, 2, 3} are the subarrays and the pairs
satisfying given conditions are (2, 1) and (3, 2) only.
Input: arr[] = {4, 1, 2}
Output: 3

*/

import java.util.*;

class JavaProgram5
{
    // Function to return the count of the required pairs
    static int countPairs(int arr[], int n)
    {

        // Calculating the valid pairs in forward direction
        int forward[] = new int[n];
        Stack<Integer> sForward = new Stack<Integer>();
        for (int i = 0; i < n; i++)
        {
            while (!sForward.empty()
                    && arr[i] > arr[(Integer)sForward.peek()])
            {
                forward[(Integer)sForward.peek()] = 1;
                sForward.pop();
            }
            sForward.push(i);
        }

        // Calculating the valid pairs in backward direction
        int backward [] = new int[n] ;
        Stack<Integer> sBackward = new Stack<Integer>() ;
        for (int i = n - 1; i >= 0; i--)
        {
            while (!sBackward.empty()
                    && arr[i] > arr[(Integer)sBackward.peek()])
            {
                backward[(Integer)sBackward.peek()] = 1;
                sBackward.pop();
            }
            sBackward.push(i);
        }

        // Calculating the total number of pairs
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            res += forward[i] + backward[i];
        }
        return res;
    }


    public static void main (String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        System.out.println(countPairs(arr, n));
    }
}


