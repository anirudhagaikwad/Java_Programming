package PPT19;
/*
Given an array, how to check if the given array represents a Binary Max-Heap.
Examples:

Input:  arr[] = {90, 15, 10, 7, 12, 2}
Output: True
The given array represents below tree
       90
     /    \
   15      10
  /  \     /
 7    12  2
The tree follows max-heap property as every
node is greater than all of its descendants.

Input:  arr[] = {9, 15, 10, 7, 12, 11}
Output: False
The given array represents below tree
       9
     /    \
   15      10
  /  \     /
 7    12  11
The tree doesn't follows max-heap property 9 is
smaller than 15 and 10, and 10 is smaller than 11.
*/


class JavaProgram10
{

    // Returns true if arr[i..n-1] represents a max-heap
    static boolean isHeap(int arr[],
                          int i, int n)
    {
        // If (2 * i) + 1 >= n, then leaf node, so return true
        if (i >= (n - 1) / 2)
        {
            return true;
        }

        // If an internal node and is greater than its
        // children, and same is  recursively true for the children
        if (arr[i] >= arr[2 * i + 1]
                && arr[i] >= arr[2 * i + 2]
                && isHeap(arr, 2 * i + 1, n)
                && isHeap(arr, 2 * i + 2, n))
        {
            return true;
        }

        return false;
    }


    public static void main(String[] args)
    {
        int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        if (isHeap(arr, 0, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}

