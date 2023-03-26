package PPT7;
/*
Given n and k, print a string that has n characters. The string should have exactly k distinct characters and no adjacent positions.

Examples:

Input  : n = 5, k = 3
Output :  abcab
Explanation: 3 distinct character a, b, c
and n length string.

Input: 3 2
Output: aba
Explanation: 2 distinct character 'a'
and 'b' and n length string.
*/

import java.io.*;

public class JavaProgram9 {

    // Function to find a string of
    // length n with k distinct characters.
    static String findString(int n, int k) {

        // Initialize result with first k
        // Latin letters
        String res = "";

        for (int i = 0; i < k; i++)
            res = res + (char) ('a' + i);

        // Fill remaining n-k letters by
        // repeating k letters again and
        // again.
        int count = 0;

        for (int i = 0; i < n - k; i++) {
            res = res + (char) ('a' + count);
            count++;

            if (count == k)
                count = 0;
        }

        return res;
    }


    static public void main(String[] args) {

        int n = 5, k = 2;
        System.out.println(findString(n, k));
    }

}