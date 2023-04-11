package PPT2;
/*
Given two integers M and N, the task is to find the minimum number of tiles of size 2 * 1 that can be placed on an M * N grid such that the following conditions are satisfied:

Each tile must completely cover 2 squares of the board.
No pair of tiles may overlap.
Each tile lies must be placed entirely inside the board. It is allowed to touch the edges of the board.
If it is not possible to cover the entire board, print -1

Input: N = 2, M = 4
Output: 4
Explanation: 4 tiles of dimension 2 * 1. Place each tile in one column.

Input: N = 3, M = 3
Output: -1
*/

import java.io.*;

class JavaProgram4 {

    // Function to count tiles of dimensions
    // 2 x 1 that can be placed in a grid of
    // dimensions M * N as per given conditions
    static int numberOfTiles(int n, int m)
    {
        if (n % 2 == 1) {
            return -1;
        }
        // Number of tiles required
        return (m * n) / 2;
    }

    public static void main(String[] args)
    {
        int n = 2, m = 4;
        System.out.println(
                numberOfTiles(n, m));
    }
}

