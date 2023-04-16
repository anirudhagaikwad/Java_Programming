package PPT19;

/*
Given a max heap, find the minimum element present in the heap.

Examples:

Input :     100
           /    \
          75     50
         /  \    / \
       55   10  2  40
Output : 2

*/

import java.util.*;
import java.lang.*;

class JavaProgram13 {

    // Function to find the minimum element in a max heap
    static int findMinimumElement(int heap[], int n)
    {
        int minimumElement = heap[n / 2];

        for (int i = 1 + n / 2; i < n; ++i)
            minimumElement
                    = Math.min(minimumElement, heap[i]);

        return minimumElement;
    }

    public static void main(String args[])
    {
        // Number of nodes
        int n = 10;
        // heap represents the following max heap:
        //	 20
        //	 / \
        //	 18	 10
        // / \ / \
        // 12	 9 9 3
        // / \ /
        // 5 6 8
        int heap[] = new int[] { 20, 18, 10, 12, 9,
                9, 3, 5, 6, 8 };

        System.out.println(findMinimumElement(heap, n));
    }
}
