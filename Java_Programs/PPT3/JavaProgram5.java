package PPT3;
/* Java program to check Bleak Number

A number ‘n’ is called Bleak if it cannot be represented as sum of a positive number x and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.

Input : n = 3
Output : false
3 is not Bleak as it can be represented
as 2 + countSetBits(2).

Input : n = 4
Output : true
4 is t Bleak as it cannot be represented
as sum of a number x and countSetBits(x)
for any number x.
*/
import java.io.*;

class JavaProgram5 {

    /* Function to get no of set bits in binary
    representation of passed binary no. */
    static int countSetBits(int x)
    {
        int count = 0;
        while (x != 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }

    // Returns true if n is Bleak
    static boolean isBleak(int n)
    {
        // Check for all numbers 'x' smaller
        // than n. If x + countSetBits(x)
        // becomes n, then n can't be Bleak
        for (int x = 1; x < n; x++)
            if (x + countSetBits(x) == n)
                return false;

        return true;
    }


    public static void main(String args[])
    {
        if (isBleak(3))
            System.out.println("Yes");
        else
            System.out.println("No");
        if (isBleak(4))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}


