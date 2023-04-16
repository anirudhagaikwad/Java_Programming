package PPT5;
/* Given an array of N integers, and a number sum, the task is to find the number of pairs of integers in the array whose sum is equal to sum.

Input:  arr[] = {1, 5, 7, -1}, sum = 6
Output:  2
Explanation: Pairs with sum 6 are (1, 5) and (7, -1).

Input:  arr[] = {1, 5, 7, -1, 5}, sum = 6
Output:  3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).

 */

public class JavaProgram1 {
    public static void main(String args[])
    {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        getPairsCount(arr, sum);
    }

    // Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static void getPairsCount(int[] arr, int sum)
    {

        int count = 0; // Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;

        System.out.printf("Count of pairs is %d", count);
    }
}


