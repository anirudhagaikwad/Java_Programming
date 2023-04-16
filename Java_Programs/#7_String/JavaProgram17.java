package PPT7;
/*
Given a string str which represents a username,
the task is to validate this username with the help of Regular Expressions.

Example:
Input: str = “Geeksforgeeks_21”
Output: True
Explanation:
The given username satisfies all the conditions mentioned.

Input: str = “Geeksforgeeks?10_2A”
Output: False
Explanation:
The given username is invalid because it consists of invalid character “?”.
* */

import java.util.regex.*;

class JavaProgram17 {

    // Function to validate the username
    public static boolean isValidUsername(String name)
    {

        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (name == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(name);

        // Return if the username
        // matched the ReGex
        return m.matches();
    }

    public static void main(String[] args)
    {

        // Test Case: 1
        String str1 = "vaibhavi879";
        System.out.println(isValidUsername(str1));

        // Test Case: 2
        String str3 = "123sangola";
        System.out.println(isValidUsername(str3));

        // Test Case: 3
        String str5 = "piz";
        System.out.println(isValidUsername(str5));
    }
}
