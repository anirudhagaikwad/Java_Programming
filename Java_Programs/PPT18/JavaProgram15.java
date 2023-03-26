package PPT18;

/*
Given two arrays that have the same values but in a different order and having no duplicate elements in it, we need to make a second array the same as a first array using the minimum number of swaps.

Examples:

Input  : arrA[] = {3, 6, 4, 8},
         arrB[] = {4, 6, 8, 3}
Output : 2
Explanation: we can make arrB to same as arrA in 2 swaps which are shown below, swap 4 with 8,
arrB = {8, 6, 4, 3} swap 8 with 3,   arrB = {3, 6, 4, 8}
* */


import java.io.*;
import java.util.*;

class JavaProgram15
{

    static int minSwapsToSort(int arr[], int n)
    {

        // Create an array of pairs where first
        // element is array element and second element
        // is position of first element
        ArrayList<ArrayList<Integer>> arrPos = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
        {
            arrPos.add(new ArrayList<Integer>(Arrays.asList(arr[i],i)));
        }

        // Sort the array by array element values to
        // get right position of every element as second
        // element of pair.
        Collections.sort(arrPos, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] vis = new boolean[n];

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {

            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrPos.get(i).get(1) == i)
                continue;

            // find out the number of node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;

                // move to next node
                j = arrPos.get(j).get(1);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            ans += (cycle_size - 1);
        }

        // Return result
        return ans;
    }

    // method returns minimum number of swap to make
// array B same as array A
    static int minSwapToMakeArraySame(int a[], int b[], int n)
    {

        // map to store position of elements in array B
        // we basically store element to index mapping.
        Map<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
        {
            mp.put(b[i], i);
        }

        // now we're storing position of array A elements
        // in array B.
        for (int i = 0; i < n; i++)
            b[i] = mp.get(a[i]);

	/* We can uncomment this section to print modified
		b array
		for (int i = 0; i < N; i++)
			cout << b[i] << " ";
		cout << endl; */

        // returning minimum swap for sorting in modified
        // array B as final answer
        return minSwapsToSort(b, n);
    }

    public static void main (String[] args)
    {
        int a[] = {3, 6, 4, 8};
        int b[] = {4, 6, 8, 3};
        int n = a.length;

        System.out.println( minSwapToMakeArraySame(a, b, n));
    }
}

