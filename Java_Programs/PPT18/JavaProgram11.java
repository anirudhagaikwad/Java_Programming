package PPT18;
/*
The N queens puzzle is the problem of placing N chess queens on an N×N chessboard so that no two queens threaten each other. Thus, a solution requires that no two queens share the same row, column, or diagonal.

Time complexity should be O(n)
*/
class JavaProgram11
{

    static void breakLine()
    {
        System.out.print("\n---------------------------------\n");
    }
    static int MAX = 10;

    static int arr[] = new int[MAX], no;

    // Function to check queens placement
    static void nQueens(int k, int n)
    {

        for (int i = 1; i <= n; i++)
        {
            if (canPlace(k, i))
            {
                arr[k] = i; //place of queen at 1st col
                if (k == n)
                {
                    //if chess board is over then print solution
                    display(n);
                }
                else
                {
                    nQueens(k + 1, n); //find queen position for next column of board
                }
            }
        }
    }

    // Helper Function to check if queen can be placed
    static boolean canPlace(int k, int i)
    {
        for (int j = 1; j <= k - 1; j++)
        {
            if (arr[j] == i ||
                    (Math.abs(arr[j] - i) == Math.abs(j - k)))
            {
                return false;
            }
        }
        return true;
    }

    // Function to display placed queen
    static void display(int n)
    {
        breakLine();
        System.out.print("Arrangement No. " + ++no);
        breakLine();

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                //check queen placement row wise
                if (arr[i] != j)
                {
                    System.out.print("\t_");
                }
                else
                {
                    System.out.print("\tQ");
                }
            }
            System.out.println("");
        }

        breakLine();
    }


    public static void main(String[] args)
    {
        int n = 4;
        nQueens(1, n);
    }
}

