package PPT2;
/*
Given two integers L and R where L ≤ R, the task is to find
an integer K such that:

L ≤ K ≤ R.
All the digits of K are distinct.
The value of the expression (L – K) * (K – R) is maximum.

If multiple answers exist then choose the larger value for K.

Examples:
Input: L = 5, R = 10
Output: 8
Input: L = 50, R = 60
Output: 56
*/

class JavaProgram5
{

    static int MAX = 10;

    // Function that returns true if x contains all distinct digits
    static boolean distinctDigits(int x)
    {
        boolean []present = new boolean[MAX];

        while (x > 0)
        {

            // Last digit of x
            int digit = x % 10;

            // If current digit has
            // appeared before
            if (present[digit])
                return false;

            // Mark the current digit
            // to present
            present[digit] = true;

            // Remove the last digit
            x /= 10;
        }

        return true;
    }

    // Function to return the required value of k
    static int findK(int l, int r)
    {

        // To store the maximum value for the given expression
        int maxExp = Integer.MIN_VALUE;
        int k = -1;
        for (int i = l; i <= r; i++)
        {

            // If i contains all distinct digits
            if (distinctDigits(i))
            {
                int exp = (l - i) * (i - r);

                /* If the value of the expression is also maximum then update k and the expression */
                if (exp >= maxExp)
                {
                    k = i;
                    maxExp = exp;
                }
            }
        }

        return k;
    }

    public static void main(String[] args)
    {
        int l = 50, r = 60;

        System.out.print(findK(l, r));

    }
}

