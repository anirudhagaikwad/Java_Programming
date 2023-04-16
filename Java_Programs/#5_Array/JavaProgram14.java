package PPT5;

/*
Given a matrix mat[][], the task is to check whether the matrix is valid or not. A valid matrix is the matrix that satisfies the given conditions:

For every row, it must contain a single distinct character.
No two consecutive rows have a character in common.
Examples:

Input: mat[][] = {
{0, 0, 0},
{1, 1, 1},
{0, 0, 2}}
Output: No

The last row doesn’t consist of a single distinct character.

Input: mat[][] = {
{8, 8, 8, 8, 8},
{4, 4, 4, 4, 4},
{6, 6, 6, 6, 6},
{5, 5, 5, 5, 5},
{8, 8, 8, 8, 8}}
Output: Yes

*/

class JavaProgram14
{

    // Storing the size of the matrix
    static final int M = 5, N = 5;

    // Function that returns true if the matrix is valid
    static boolean isPerfect(String board[])
    {
        char m = 0;

        for (int i = 0; i < M; i++)
        {

            // Get the current row
            String s = board[i];

            /* Comparing first element of the row with the element of previous row */
            if (i > 0 && s.charAt(0) == m)
                return false;

            // Checking if all the characters of the
            // current row are same or not
            for (int j = 0; j < N; j++)
            {

                // Storing the first character
                if (j == 0)
                    m = s.charAt(0);

                    // Comparing all the elements
                    // with the first element
                else
                {
                    if (m != s.charAt(j))
                        return false;
                }
            }
        }
        return true;
    }


    public static void main (String[] args)
    {
        String board[] = { "88888", "44444",
                "66666", "55555",
                "88888" };

        if (isPerfect(board))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}


