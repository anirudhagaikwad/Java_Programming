package PPT3;
/*
Given two integers, find XOR of them without using the XOR
operator, i.e., without using ^

Examples :

Input:  x = 1, y = 2
Output: 3

Input:  x = 3, y = 5
Output: 6
* */

import java.io.*;

class JavaProgram14{

    // Returns XOR of x and y
    static int myXOR(int x, int y)
    {
        // Initialize result
        int res = 0;

        // Assuming 32-bit Integer
        for(int i = 31; i >= 0; i--)
        {

            // Find current bits in x and y
            int b1 = ((x & (1 << i)) == 0 ) ? 0 : 1;
            int b2 = ((y & (1 << i)) == 0 ) ? 0 : 1;

            // If both are 1 then 0 else xor is same as OR
            int xoredBit = ((b1 & b2) != 0) ? 0 : (b1 | b2);

            // Update result
            res <<= 1;
            res |= xoredBit;
        }
        return res;
    }

    public static void main (String[] args)
    {
        int x = 3, y = 5;

        System.out.println("XOR is " + myXOR(x, y));
    }
}


