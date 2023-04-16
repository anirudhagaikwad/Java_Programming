package PPT7;
// Java program to swap two strings without using a temporary
// variable.
import java.util.*;

class JavaProgram15
{
    public static void main(String args[])
    {
        // Declare two strings
        String a = "Hello";
        String b = "World";

        // Print String before swapping
        System.out.println("Strings before swap: a = " +
                a + " and b = "+b);

        // append 2nd string to 1st
        a = a + b;

        // store initial string a in string b
        b = a.substring(0,a.length()-b.length());

        // store initial string b in string a
        a = a.substring(b.length());

        // print String after swapping
        System.out.println("Strings after swap: a = " +
                a + " and b = " + b);
    }
}
