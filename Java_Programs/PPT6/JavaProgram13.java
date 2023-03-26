package PPT6;
/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.

Examples :

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6
Explanation: Maximum of 1, 2, 3 is 3
                       Maximum of 2, 3, 1 is 3
                       Maximum of 3, 1, 4 is 4
                       Maximum of 1, 4, 5 is 5
                       Maximum of 4, 5, 2 is 5
                       Maximum of 5, 2, 3 is 5
                       Maximum of 2, 3, 6 is 6

*/
public class JavaProgram13 {

    // Method to find the maximum for each and every contiguous subarray of size K.
    static void printKMax(int arr[], int N, int K)
    {
        int j, max;

        for (int i = 0; i <= N - K; i++) {

            max = arr[i];

            for (j = 1; j < K; j++) {
                if (arr[i + j] > max) //find max
                    max = arr[i + j]; //store max
            }
            System.out.print(max + " ");
        }
    }


    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int K = 3;

        // Function call
        printKMax(arr, arr.length, K);
    }
}

