package PPT17;
/*
Given a string and a character, the task is to make a function which counts the occurrence of the given character in the string using Stream API.

Examples:

Input: str = "geeksforgeeks", c = 'e'
Output: 4
'e' appears four times in str.

Input: str = "abccdefgaa", c = 'a'
Output: 3
'a' appears three times in str.

*/

class JavaProgram4 {

    // Method that returns the count of the given
    // character in the string
    public static long count(String s, char ch)
    {

        return s.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static void main(String args[])
    {
        String str = "mania";
        char c = 'a';
        System.out.println(count(str, c));
    }
}

