package PPT18;

/*
Sort even-placed elements in increasing and odd-placed in decreasing order

Input:  arr[] = {0, 1, 2, 3, 4, 5, 6, 7}
Output: arr[] = {0, 2, 4, 6, 7, 5, 3, 1}
Even-place elements : 0, 2, 4, 6
Odd-place elements : 1, 3, 5, 7

*/

import java.util.*;

class JavaProgram6 {

    static void bitonicGenerator(int arr[], int n)
    {
        // create evenArr[] and oddArr[]
        Vector<Integer> evenArr = new Vector<Integer>();
        Vector<Integer> oddArr = new Vector<Integer>();

        // Put elements in oddArr[] and evenArr[] as
        // per their position
        for (int i = 0; i < n; i++) {
            if (i % 2 != 1) {
                evenArr.add(arr[i]);
            }
            else {
                oddArr.add(arr[i]);
            }
        }

        // sort evenArr[] in ascending order
        // sort oddArr[] in descending order
        Collections.sort(evenArr);
        Collections.sort(oddArr, Collections.reverseOrder());

        int i = 0;
        for (int j = 0; j < evenArr.size(); j++) {
            arr[i++] = evenArr.get(j);
        }
        for (int j = 0; j < oddArr.size(); j++) {
            arr[i++] = oddArr.get(j);
        }
    }


    public static void main(String[] args)
    {
        int arr[] = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 };
        int n = arr.length;
        bitonicGenerator(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

