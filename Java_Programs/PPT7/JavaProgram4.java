package PPT7;
/*
Given a string str, find its rank among all its permutations when sorted lexicographically.

Note: The characters a string are all unique.

Examples:

Input: str = “acb”
Output: 2
Explanation: If all the permutations of the string are arranged lexicographically they will be “abc”, “acb”, “bac”, “bca”, “cab”, “cba”. From here it can be clearly that the rank of str is 2.


Input: str = “string”
Output: 598
*/


import java.io.*;
import java.util.*;

class JavaProgram4 {

    // A utility function to find factorial of n
    static int fact(int n)
    {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    // A utility function to count smaller
    // characters on right of arr[low]
    static int findSmallerInRight(String str, int low,
                                  int high)
    {
        int countRight = 0, i;

        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;

        return countRight;
    }

    // A function to find rank of a string in
    // all permutations of characters
    static int findRank(String str)
    {
        int len = str.length();
        int mul = fact(len);
        int rank = 1;
        int countRight;

        for (int i = 0; i < len; ++i) {
            mul /= len - i;

            // Count number of chars smaller
            // than str[i] from str[i+1] to
            // str[len-1]
            countRight
                    = findSmallerInRight(str, i, len - 1);

            rank += countRight * mul;
        }

        return rank;
    }


    public static void main(String[] args)
    {
        String str = "string";

        // Function call
        System.out.println(findRank(str));
    }
}
