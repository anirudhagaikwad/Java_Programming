package PPT5;
/*
Given an array arr[] of size N and an integer K. The task is to find the operations required to update the array such that it is possible to move from index 0 to index N – 1 when any index j can be visited from index i if index j is adjacent to index i and abs(arr[i] – arr[j]) ≤ K. In a single operation, any element of the array can be incremented or decremented by 1.

Examples:

Input: arr[] = {1, 2, 5, 9}, K = 2
Output: 4
Operation 1: arr[2] = arr[2] – 1
Operation 2: arr[3] = arr[3] – 3
The new array becomes arr[] = {1, 2, 4, 6}
which satisfies the given condition.

Input: arr[] = {-2, 0, 1, 4}, K = 5
Output: 0
*/

import java.util.*;

class JavaProgram11
{
    // Function to return the count of operations required to update
// the array such that it is possible to move from index 0 to index n - 1
    static int countOp(int arr[], int n, int k)
    {
        int operations = 0;
        for (int i = 1; i < n; i++)
        {

            // Current element needs to be updated
            if (Math.abs(arr[i] - arr[i - 1]) > k)
            {

                // Get the absolute difference
                int absDiff = Math.abs(arr[i] - arr[i - 1]);

                // The value which needs to
                // be added or subtracted
                int currOp = absDiff - k;

                // Add value to arr[i]
                if (arr[i] < arr[i - 1])
                    arr[i] += currOp;

                    // Subtract value from arr[i]
                else
                    arr[i] -= currOp;

                // Update the operations
                operations += currOp;
            }
        }
        return operations;
    }


    static public void main (String []arg)
    {
        int arr[] = { 1, 2, 5, 9 };
        int n = arr.length;
        int k = 2;

        System.out.println(countOp(arr, n, k));
    }
}

