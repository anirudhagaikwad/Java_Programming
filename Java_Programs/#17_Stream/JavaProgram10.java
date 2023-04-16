package PPT17;
/*
Given a String, the task is to convert it into a List of Characters in Java.

Examples:

Input: String = "pizza"
Output: [p, i, z, z, a]


*/

import java.util.*;

class JavaProgram10 {

    // Function to convert String
    // to List of Characters
    public static List<Character>
    convertStringToCharList(String str)
    {

        // Create an empty List of character
        List<Character> chars = new ArrayList<>();

        // For each character in the String
        // add it to the List
        for (char ch : str.toCharArray()) {

            chars.add(ch);
        }

        // return the List
        return chars;
    }

    public static void main(String[] args)
    {

        // Get the String to be converted
        String str = "pizza";

        // Get the List of Character
        List<Character>
                chars = convertStringToCharList(str);

        // Print the list of characters
        System.out.println(chars);
    }
}


