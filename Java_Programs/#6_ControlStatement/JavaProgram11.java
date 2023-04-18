package PPT6;
/*
Given two integer N and K, the task is to find the permutation P of first N natural numbers such that there are exactly K elements which satisfies the condition GCD(P[i], i) > 1 for all 1 ≤ i ≤ N.
Examples:


Input: N = 3, K = 1
Output: 2 1 3
GCD(P[1], 1) = GCD(2, 1) = 1
GCD(P[2], 2) = GCD(1, 2) = 1
GCD(P[3], 3) = GCD(3, 3) = 3
There is exactly 1 element such that GCD(P[i], i) > 1
Input: N = 5, K = 2
Output: 3 1 2 4 5
*/


class JavaProgram11
{

    // Function to find permutation(p) of first N
    // natural numbers such that there are exactly K
    // elements of permutation such that GCD(p[i], i)>1
    static void Permutation(int n, int k)
    {
        int[] p = new int[n + 1];

        // First place all the numbers
        // in their respective places
        for (int i = 1; i <= n; i++)
            p[i] = i;

        // Modify for first n-k integers
        for (int i = 1; i < n - k; i++)
            p[i + 1] = i;

        // In first index place n-k
        p[1] = n - k;

        // Print the permutation
        for (int i = 1; i <= n; i++)
            System.out.print(p[i] + " ");
    }


    public static void main(String[] args)
    {
        int n = 5, k = 2;
        Permutation(n, k);
    }
}

