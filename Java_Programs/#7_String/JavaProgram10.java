package PPT7;

/*
Given a string str, the task is to print the maximum count of characters which are greater than both its left and right character in any permutation of the string.

Examples:

Input: str = “abc”
Output: 1
Permutations of the string with the count of maximal character in each string are:
abc – 0
acb – 1 Here a < c > b
bac – 0
bca – 1 Here b < c > a
cab – 0
cba – 0

Input: str = “geeks”
Output: 2
The string will be “egesk”

*/

class JavaProgram10 {

    // function to find maximum maximal character in the string
    static int solve(int freq[]) {
        // to store sum of all frequency
        int n = 0;

        // to store maximum frequency
        int max_freq = 0;

        // frequency of the smallest element
        int first = 0;

        // to check if the smallest
        // element have maximum frequency or not
        int flag = 0;

        // Iterate in the string and count frequency
        for (int i = 0; i < 26; i++) {
            n += freq[i];

            // to store frequency of smallest element
            if (freq[i] != 0 && flag == 0) {
                first = freq[i];
                flag = 1;
            }

            // to store maximum frequency
            if (max_freq < freq[i]) {
                max_freq = freq[i];
            }
        }

        // if sum of frequency of all element if 0
        if (n == 0) {
            return 0;
        }

        // if frequency of smallest character
        // if largest frequency
        if (first != max_freq) {
            flag = 1;
        } else {
            flag = 0;
        }

        return Math.min((n - 1) / 2, n - max_freq - flag);
    }

    // Function that counts the frequency of each element
    static void solve(String s) {
        // array to store the frequency of each character
        int freq[] = new int[26];

        // loop to calculate frequency of each character in the given string
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        System.out.println(solve(freq));
    }


    public static void main(String[] args) {
        String s = "geeks";
        solve(s);
    }
}

