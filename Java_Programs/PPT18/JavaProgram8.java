package PPT18;
/*
Given an array of distinct positive numbers, the task is to calculate the number of subsets (or subsequences) from the array such that each subset contains consecutive numbers.

Examples:

Input :  arr[] = {100, 56, 5, 6, 102, 58,
                            101, 57, 7, 103, 59}
Output : 3
{5, 6, 7}, { 56, 57, 58, 59}, {100, 101, 102, 103}
are 3 subset in which numbers are consecutive.
*/


import java.util.*;
class JavaProgram8 {

    // Returns count of subsets with consecutive numbers
    static int numofsubset(int arr[], int n)
    {
        // Sort the array so that elements
        // which are consecutive in nature
        // became consecutive in the array.
        Arrays.sort(arr);

        // Initialize result
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            // Check if there is beginning
            // of another subset of
            // consecutive number
            if (arr[i] + 1 != arr[i + 1])
                count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int arr[] = { 100, 56, 5, 6, 102, 58, 101,
                57, 7, 103, 59 };
        int n = arr.length;
        System.out.println(numofsubset(arr, n));
    }
}

