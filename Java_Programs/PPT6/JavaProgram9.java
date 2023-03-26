package PPT6;

/*
Given two integers n and m, where n represent some paintings numbered from 1 to n and m represent some colours 1 to m with unlimited amount. The task is to find the number of ways to paint the paintings such that no two consecutive paintings have the same colors.
Note: Answer must be calculated in modulo 10^9 +7 as answer can be very large.

Examples:
Input: n = 4, m = 2
Output: 2

Input: n = 4, m = 6
Output: 750
*/

class JavaProgram9
{
    static final int modd = 1000000007;

    // Function for finding the power
    static long power(long x, long y, long p)
    {
        long res = 1; // Initialize result

        // Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0)
        {
            // If y is odd, multiply x with result
            if (y % 2 == 1)
            {
                res = (res%p * x%p) % p;
            }

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x%p * x%p) % p;
        }
        return res;
    }

    // Function to calculate the number of ways
    static int ways(int n, int m)
    {
        // Answer must be modulo of 10^9 + 7
        return (int) (power(m - 1, n - 1, modd)
                * m % modd);
    }


    public static void main(String[] args)
    {
        int n = 5, m = 5;
        System.out.println(ways(n, m));

    }
}

