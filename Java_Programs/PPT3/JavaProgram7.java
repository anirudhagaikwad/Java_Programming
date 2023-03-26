package PPT3;
/* Given two integers, write a function to multiply them without using
multiplication operator.
Russian Peasant (Multiply two numbers using bitwise operators)
 */

import java.io.*;

class JavaProgram7
{
    // Function to multiply two
    // numbers using Russian Peasant method
    static int russianPeasant(int a, int b)
    {
        // initialize result
        int res = 0;

        // While second number doesn't become 1
        while (b > 0)
        {
            // If second number becomes odd,
            // add the first number to result
            if ((b & 1) != 0)
                res = res + a;

            // Double the first number
            // and halve the second number
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }

    // driver program
    public static void main (String[] args)
    {
        System.out.println(russianPeasant(18, 1));
        System.out.println(russianPeasant(20, 12));
    }
}


