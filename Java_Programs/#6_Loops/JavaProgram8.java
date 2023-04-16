package PPT6;
/*
Given an integer N and a 2D array cost[][3], where cost[i][0], cost[i][1], and cost[i][2] is the cost of painting ith house with colors red, blue, and green respectively, the task is to find the minimum cost to paint all the houses such that no two adjacent houses have the same color.

Examples:

Input: N = 3, cost[][3] = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}}
Output: 10
Explanation:
Paint house 0 as blue. Cost = 2. Paint house 1 as green. Cost = 5. Paint house 2 as blue. Cost = 3.
Therefore, the total cost = 2 + 5 + 3 = 10.

*/

import java.io.*;
import java.lang.*;
import java.util.*;

class JavaProgram8 {

    // Function to find the minimum cost of coloring the houses such that no //two adjacent houses has the same color
    static void minCost(int costs[][], int N)
    {

        // Corner Case
        if (N == 0)
            return;

        // Auxiliary 2D dp array
        int dp[][] = new int[N][3];

        // Base Case
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < N; i++) {

            // If current house is colored with red the take min cost of
            // previous houses colored with (blue and green)
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2])
                    + costs[i][0];

            // If current house is colored with blue the take min cost of
            // previous houses colored with (red and green)
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2])
                    + costs[i][1];

            // If current house is colored  with green the take min cost of
            // previous houses colored with (red and blue)
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1])
                    + costs[i][2];
        }

        // Print the min cost of the
        // last painted house
        System.out.println(
                Math.min(dp[N - 1][0],
                        Math.min(dp[N - 1][1], dp[N - 1][2])));
    }


    public static void main(String[] args)
    {

        int costs[][] = { { 14, 2, 11 },
                { 11, 14, 5 },
                { 14, 3, 10 } };

        int N = costs.length;

        // Function Call
        minCost(costs, N);
    }
}
