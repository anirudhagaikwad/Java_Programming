package PPT6;
/*
Given an integer array arr[] of size N, find the maximum of the minimums for every window size in the given array.
Note: The window size varies from 1 to N.

Example:

Input: arr[] = {10, 20, 30, 50, 10, 70, 30}
Output: 70, 30, 20, 10, 10, 10, 10

Explanation:
The first element in the output indicates the maximum of minimums of all windows of size 1.
Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10}, {70} and {30}.
Maximum of these minimums is 70
The second element in the output indicates the maximum of minimums of all windows of size 2.
Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10}, and {30}.
Maximum of these minimums is 30
The third element in the output indicates the maximum of minimums of all windows of size 3.
Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}.
Maximum of these minimums is 20
Similarly, other elements of output are computed.

*/

class JavaProgram12 {
    static int arr[] = { 10, 20, 30, 50, 10, 70, 30 };

    static void printMaxOfMin(int n)
    {
        // Consider all windows of different
        // sizes starting from size 1
        for (int k = 1; k <= n; k++) {
            // Initialize max of min for current
            // window size k
            int maxOfMin = Integer.MIN_VALUE;

            // Traverse through all windows of
            // current size k
            for (int i = 0; i <= n - k; i++) {
                // Find minimum of current window
                int min = arr[i];
                for (int j = 1; j < k; j++) {
                    if (arr[i + j] < min)
                        min = arr[i + j];
                }

                // Update maxOfMin if required
                if (min > maxOfMin)
                    maxOfMin = min;
            }

            // Print max of min for current
            // window size
            System.out.print(maxOfMin + " ");
        }
    }


    public static void main(String[] args)
    {
        printMaxOfMin(arr.length);
    }
}


