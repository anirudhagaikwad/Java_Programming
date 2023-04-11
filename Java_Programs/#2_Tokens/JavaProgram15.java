package PPT2;

/*
Given a character in Java, your task is to
write a Java program to convert this given character into an integer.

Examples:

Input  : ch = '3'
Output : 3
Input  : ch = '9'
Output : 9

* */
public class JavaProgram15 {

    public static void main(String[] args) {
        // Initializing a character
        char ch = '3';

        // Printing the character value
        System.out.println("char value: " + ch);

        // Converting character to its integer value
        int a = ch - '0';

        // Printing the integer value
        System.out.println("int value: " + a);
    }
}
