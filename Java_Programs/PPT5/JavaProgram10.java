package PPT5;
/*
Given an array arr[] consisting of N integers representing N rods each with a disk of radius arr[i], the task is to check if it is possible to move all disks to a single rod based on the condition that a disk at ith rod can be moved to jth rod only if:

abs(i – j) = 1 and ith rod has only a single disk.
The disk at ith rod has radii less than the top disk of the jth rod or the jth rod is empty.
Examples:

Input: arr[] = {1, 3, 5, 2}, N = 4
Output: YES
Explanation:
One of the possible ways is:
First move the disk of radii 3 at rod 2 to the top of rod 3.
The array arr[] modifies to {1, 0, (5, 3), 2}.
Move the disk of radii 2 at rod 4 to the top of rod 3. The array arr[] modifies to {1, 0, (5, 3, 2), 0}.
Move the disk of radii 1 at rod 1 to top of the rod 2. The array arr[] modifies to {0, 1, (5, 3, 2), 0}.
Now, move the disk of radii 1 at rod 2 to the top of rod 3. The array arr[] modifies to {0, 0, (5, 3, 2, 1), 0}.

Input: arr[] = {4, 1, 2}, N = 3
Output: NO
*/

import java.io.*;
import java.util.*;

class JavaProgram10
{

    // Function to check if it is possible
// to move all disks to a single rod
    static boolean check(int a[], int n)
    {

        // Stores if it is possible to move
        // all disks to a single rod
        boolean flag = false;

        // Traverse the array
        for (int i = 1; i < n - 1; i++)
        {

            // If i-th element is smaller than
            // both its adjacent elements
            if (a[i + 1] > a[i]
                    && a[i] < a[i - 1])
                flag = true;
        }

        // If flag is true
        if (flag)
            return false;

            // Otherwise
        else
            return true;
    }


    public static void main(String[] args)
    {
        int arr[] = { 1, 3, 5, 2 };
        int N = arr.length;

        if (check(arr, N))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}

