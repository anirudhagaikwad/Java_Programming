package PPT7;
/*
Given a string S consisting of N characters, the task is to find the minimum number of pairs of characters that are required to be swapped such that no two adjacent characters are the same. If it is not possible to do so, then print “-1”.

Examples:

Input: S = “ABAACD”
Output: 1
Explanation: Swapping S[3] and S[4] modifies the given string S to “ABACAD”. Since no two adjacent characters are the same, the minimum number of operations required is 1.

Input: S = “AABA”
Output: -1
*/

import java.util.*;

class JavaProgram13
{
    static int ansSwaps ;

    // Function to check if S
// contains any pair of
// adjacent characters that are same
    static boolean check(char[] S)
    {

        // Traverse the String S
        for (int i = 1; i < S.length; i++) {

            // If current pair of adjacent
            // characters are the same
            if (S[i - 1] == S[i]) {
                return false;
            }
        }

        // Return true
        return true;
    }

    // Utility function to find the minimum number
// of swaps of pair of characters required
// to make all pairs of adjacent characters different
    static void minimumSwaps(char[] S,
                             int swaps, int idx)
    {

        // Check if the required String
        // is formed already
        if (check(S)) {
            ansSwaps = Math.min(ansSwaps, swaps);
        }

        // Traverse the String S
        for (int i = idx;
             i < S.length; i++) {

            for (int j = i + 1;
                 j < S.length; j++) {

                // Swap the characters at i
                // and j position
                swap(S,i,j);
                minimumSwaps(S,
                        swaps + 1, i + 1);

                // Swap for Backtracking
                // Step
                S= swap(S,i,j);
            }
        }
    }
    static char[] swap(char []arr, int i, int j){
        char temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }

    // Function to find the minimum number
// of swaps of pair of characters required
// to make all pairs of adjacent characters different
    static void findMinimumSwaps(char[] S)
    {

        // Stores the resultant minimum
        // number of swaps required
        ansSwaps = Integer.MAX_VALUE;

        // Function call to find the
        // minimum swaps required
        minimumSwaps(S, 0,0);

        // Print the result
        if (ansSwaps == Integer.MAX_VALUE)
            System.out.print("-1");
        else
            System.out.print(ansSwaps);
    }

    public static void main(String[] args)
    {
        String S = "ABAACD";
        findMinimumSwaps(S.toCharArray());

    }
}

