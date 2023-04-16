package PPT7;

/*
Given a sorted string S consisting of N lowercase characters, the task is to rearrange characters in the given string such that no two adjacent characters are the same. If it is not possible to rearrange as per the given criteria, then print “-1”.

Examples:

Input: S = “aaabc”
Output: abaca

Input: S = “aa”
Output: -1
*/
class JavaProgram12
{
    static char []S = "aaabc".toCharArray();

    // Function to check if a String S
// contains pair of adjacent
// characters that are equal or not
    static boolean isAdjChar()
    {

        // Traverse the String S
        for (int i = 0; i < S.length - 1; i++)
        {

            // If S[i] and S[i+1] are equal
            if (S[i] == S[i + 1])
                return true;
        }

        // Otherwise, return false
        return false;
    }

    // Function to rearrange characters
// of a String such that no pair of
// adjacent characters are the same
    static void rearrangeStringUtil(int N)
    {

        // Initialize 3 variables
        int i = 0, j = 1, k = 2;

        // Iterate until k < N
        while (k < N) {

            // If S[i] is not equal
            // to S[j]
            if (S[i] != S[j]) {

                // Increment i and j by 1
                i++;
                j++;

                // If j equals k and increment
                // the value of K by 1
                if (j == k) {
                    k++;
                }
            }

            // Else
            else {

                // If S[j] equals S[k]
                if (S[j] == S[k]) {

                    // Increment k by 1
                    k++;
                }

                // Else
                else {

                    // Swap
                    swap(k,j);

                    // Increment i and j
                    // by 1
                    i++;
                    j++;

                    // If j equals k
                    if (j == k) {

                        // Increment k by 1
                        k++;
                    }
                }
            }
        }
    }
    static void swap(int i, int j)
    {
        char temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }
    // Function to rearrange characters
// in a String so that no two
// adjacent characters are same
    static String rearrangeString(int N)
    {

        // If String is already valid
        if (isAdjChar() == false) {
            return String.valueOf(S);
        }

        // If size of the String is 2
        if (S.length == 2)
            return "-1";

        // Function Call
        rearrangeStringUtil(N);

        // Reversing the String
        reverse();

        // Function Call
        rearrangeStringUtil(N);

        // If the String is valid
        if (isAdjChar() == false) {
            return String.valueOf(S);
        }

        // Otherwise
        return "-1";
    }
    static void reverse() {

        int l, r = S.length - 1;
        for (l = 0; l < r; l++, r--) {
            char temp = S[l];
            S[l] = S[r];
            S[r] = temp;
        }
    }

    public static void main(String[] args)
    {

        int N = S.length;
        System.out.print(rearrangeString(N));

    }
}


