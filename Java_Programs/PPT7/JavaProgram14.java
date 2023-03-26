package PPT7;
/*
Given a string S consisting of lowercase English alphabets, the task is to find the longest substring from the given string such that no two adjacent characters are neighbouring English alphabets.

Examples:

Input: S = “aabdml”
Output: “bdm”
Explanation: Substring “bdm” is the longest substring which satisfies the given condition.

Input: S = “abc”
Output: “a”
Explanation: Substrings “a”, “b”, “c” satisfies the given condition. Print any one of them.
*/

import java.io.*;
class JavaProgram14
{

    // Function to find the longest substring
// satisfying the given condition
    static void findSubstring(String S)
    {

        // Stores all temporary substrings
        String T = "";

        // Stores the longest substring
        String ans = "";

        // Stores the length
        // of the substring T
        int l = 0;

        // Stores the first
        // character of string S
        T += S.charAt(0);

        // Traverse the string
        for (int i = 1; i < S.length(); i++) {

            // If the absolute difference is 1
            if (Math.abs(S.charAt(i) - S.charAt(i - 1))
                    == 1) {

                // Update the length of
                // substring T
                l = T.length();

                // Update the longest substring
                if (l > ans.length()) {
                    ans = T;
                }

                T = "";
                T += S.charAt(i);
            }

            // Otherwise, stores the current
            // character
            else {
                T += S.charAt(i);
            }
        }

        // Again checking for
        // longest substring
        // and update accordingly
        l = T.length();
        if (l > ans.length()) {
            ans = T;
        }

        // Print the longest substring
        System.out.println(ans);
    }


    public static void main(String[] args)
    {

        // Given string
        String S = "aabdml";

        // Function call to find
        // the longest substring
        // satisfying given condition
        findSubstring(S);
    }
}

