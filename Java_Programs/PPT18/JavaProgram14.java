package PPT18;

/*
* Print Binary Equivalent of an Integer using Recursion in Java
Examples:

Input : 1
Output:    1

Input : 12
Output: 1100
* */

import java.util.*;
class JavaProgram14 {

    public static int binaryConv(int n)
    {   //base case
        if (n == 1) {

            return 1;
        }
        return binaryConv(n / 2) * 10 + n % 2;
    }
    public static void main(String[] args)
    {
        int N = 20;
        System.out.println(binaryConv(N));
    }
}
