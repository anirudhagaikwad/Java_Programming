package PPT15;
/*
Given three integers N, M and K. The task is to find the number of ways to fill N positions using M colors such that there are exactly K pairs of different adjacent colors.

Examples:

Input: N = 3, M = 2, K = 1
Output: 4
Let the colors be 1 and 2, so the ways are:
1, 1, 2
1, 2, 2
2, 2, 1
2, 1, 1
The above 4 ways have exactly one pair of adjacent elements with different colors.
*/

class JavaProgram3
{
    static final int max=4;

    // Recursive function to find the required number of ways
    static int countWays(int index, int cnt, int dp[][], int n, int m, int k)
    {

        // When all positions are filled
        if (index == n) {

            // If adjacent pairs are exactly K
            if (cnt == k)
                return 1;
            else
                return 0;
        }

        // If already calculated
        if (dp[index][cnt] != -1)
            return dp[index][cnt];

        int ans = 0;

        // Next position filled with same color
        ans += countWays(index + 1, cnt, dp, n, m, k);

        // Next position filled with different color
        // So there can be m-1 different colors
        ans += (m - 1) * countWays(index + 1, cnt + 1, dp, n, m, k);

        return dp[index][cnt] = ans;
    }

    public static void main(String args[])
    {
        int n = 3, m = 3, k = 2;
        int dp[][]= new int [n + 1][max];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<max;j++)
                dp[i][j]=-1;

        System.out.println(m * countWays(1, 0, dp, n, m, k));
    }
}

