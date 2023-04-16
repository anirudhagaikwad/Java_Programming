package PPT7;

/*
Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.

Examples:

Input: abc, k = 2
Output: 2
Possible substrings are {“ab”, “bc”}

Input: aba, k = 2
Output: 3
Possible substrings are {“ab”, “ba”, “aba”}
*/

// Java program to CountKSubStr number of substrings
// with exactly distinct characters in a given string
import java.util.Arrays;

public class JavaProgram7
{
    // Function to count number of substrings
    // with exactly k unique characters
    int countkDist(String str, int k)
    {
        // Initialize result
        int res = 0;

        int n = str.length();

        // To store seen characters from 'a' to 'z'
        boolean seen[] = new boolean[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int distCount = 0;

            // mark all chars as unseen
            Arrays.fill(seen, false);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (!seen[str.charAt(j) - 'a'])
                    distCount++;

                // mark current char as seen
                seen[str.charAt(j) - 'a'] = true;

                // If distinct character count becomes k,
                // then increment result.
                if (distCount == k)
                    res++;
            }
        }

        return res;
    }

    //    Program
    public static void main(String[] args)
    {
        JavaProgram7 ob = new JavaProgram7();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + ob.countkDist(ch, k));
    }
}

