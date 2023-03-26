package PPT7;
/*
The task at hand involves manipulating a string S of length N, given as input. The string is subjected to a series of B swaps, each performed according to the following procedure: The character at position i is swapped with the character located C positions ahead of it, or (i + C)%N. This swapping process is repeated B times, with each iteration starting from the next position in the string. In other words, after one swap is performed, the next swap begins with the character immediately following the previous one. The result of the B swaps is the final string, which is the desired output of the program.

Examples:

Input : S = "ABCDEFGH", B = 4, C = 3;
Output:  DEFGBCAH
Explanation:
         after 1st swap: DBCAEFGH
         after 2nd swap: DECABFGH
         after 3rd swap: DEFABCGH
         after 4th swap: DEFGBCAH

Input : S = "ABCDE", B = 10, C = 6;
Output : ADEBC
Explanation:
         after 1st swap: BACDE
         after 2nd swap: BCADE
         after 3rd swap: BCDAE
         after 4th swap: BCDEA
         after 5th swap: ACDEB
         after 6th swap: CADEB
         after 7th swap: CDAEB
         after 8th swap: CDEAB
         after 9th swap: CDEBA
         after 10th swap: ADEBC
*/

class JavaProgram8 {
    // method to swap characters in the string 's'
    String swapChars(String s, int c, int b)
    {
        int n = s.length();
        // to handle cases where c is greater than the
        // length of string 's'
        c = c % n;
        if (c == 0) {
            // return the original string if c is 0
            return s;
        }
        int f = b / n;
        int r = b % n;
        // split the string into two parts, left and right
        String left = s.substring(0, c);
        String right = s.substring(c);
        // rotate the left part
        left = rotateLeft(left, (n % c) * f % c);
        // rotate the right part
        right = rotateLeft(right, c * f % (n - c));
        // concatenate the left and right parts to get the
        // rotated string
        char[] a = (left + right).toCharArray();
        // perform the swap operation
        for (int i = 0; i < r; i++) {
            int j = (i + c) % n;
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        // return the final rotated string
        return new String(a);
    }

    // method to rotate a string 's' to the left by 'p' positions
    String rotateLeft(String s, int p)
    {
        return s.substring(p) + s.substring(0, p);
    }

    public static void main(String args[])
    {
        // test the 'swapChars' method with a sample string
        String s1 = "ABCDEFGHIJK";
        int b = 1000;
        int c = 3;
        String s2 = new JavaProgram8().swapChars(s1, c, b);
        System.out.println(s2);
    }
}

