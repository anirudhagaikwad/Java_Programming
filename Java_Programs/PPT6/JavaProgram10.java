package PPT6;
/*
Binary right angle triangle consists of only 0’s and 1’s in alternate positions.
Examples :


Input : 4
Output :
         0
         1    0
         0    1    0
         1    0    1    0

Input : 3
Output :
         0
         1    0
         0    1    0
*/

import java.io.*;
public class JavaProgram10
{

    // function to print binary right angle triangle
    static void binaryRightAngleTriangle(int n)
    {

        // declare row and column
        int row, col;

        for (row = 0; row < n; row++)
        {
            for (col = 0; col <= row; col++)
            {
                if (((row + col) % 2) == 0)
                    System.out.print("0");
                else
                    System.out.print("1");

                System.out.print("\t");
            }

            System.out.print("\n");
        }
    }

    public static void main (String[] args)
    {
        // no. of rows to be printed
        int n = 4;

        binaryRightAngleTriangle(n);
    }
}

