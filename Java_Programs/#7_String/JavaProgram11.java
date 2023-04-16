package PPT7;
/*
Given string str of size N consists of lower-case English alphabets. The task is to find the arrangement of the characters of the string such that no two adjacent characters are neighbors in English alphabets. In case of multiple answers print any of them. If no such arrangement is possible then print -1.

Examples:

Input: str = “aabcd”
Output: bdaac
No two adjacent characters are neighbours in English alphabets.
Input: str = “aab”
Output: -1

*/

import java.util.*;

class JavaProgram11
{

    // Function that returns true if the
    // current arrangement is valid
    static boolean check(String s)
    {
        for (int i = 0; i + 1 < s.length(); ++i)
        {
            if (Math.abs(s.charAt(i) -
                    s.charAt(i + 1)) == 1)
            {
                return false;
            }
        }
        return true;
    }

    // Function to rearrange the characters of
    // the string such that no two neighbours
    // in the English alphabets appear together
    static void Rearrange(String str)
    {

        // To store the odd and the
        // even positioned characters
        String odd = "", even = "";

        // Traverse through the array
        for (int i = 0; i < str.length(); ++i)
        {
            if (str.charAt(i) % 2 == 0)
            {
                even += str.charAt(i);
            }
            else
            {
                odd += str.charAt(i);
            }
        }

        // Sort both the strings
        odd = sort(odd);
        even = sort(even);

        // Check possibilities
        if (check(odd + even))
        {
            System.out.print(odd + even);
        }
        else if (check(even + odd))
        {
            System.out.print(even + odd);
        }
        else
        {
            System.out.print(-1);
        }
    }

    // Method to sort a string alphabetically
    public static String sort(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    public static void main(String[] args)
    {
        String str = "aabcd";

        Rearrange(str);
    }
}

