package strings;
/*
The Knuth-Morris-Pratt (KMP) algorithm is a string matching algorithm that searches for the occurrence of a pattern string within a larger text string. It does this by using a pre-processing step to build a partial match table, which is used to avoid unnecessary comparisons during the search phase. 
*/
public class KMP {

    public static int[] buildPartialMatchTable(String pattern) {
        int[] table = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    public static int findPattern(String text, String pattern) {
        int[] table = buildPartialMatchTable(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        int index = findPattern(text, pattern);
        System.out.println("Pattern found at index: " + index);
    }
}

/*
In this implementation, the buildPartialMatchTable method is used to create the partial match table for the given pattern. This table is used in the findPattern method to efficiently search for the pattern within the text.

The buildPartialMatchTable method works by iterating through the pattern string and building up the table incrementally. At each position i in the pattern, the algorithm checks if the character at i matches the character at the current position j in the partial match table. If they match, the value of j is incremented, and the current entry in the table is set to j. If they don't match, the algorithm repeatedly looks up the value of j in the table until it finds a position where the character matches, or j reaches 0.

The findPattern method uses the partial match table to search for the pattern within the text. It starts at the beginning of the text string and repeatedly compares characters in the text to the corresponding characters in the pattern, using the partial match table to skip over unnecessary comparisons. When it finds a match, it returns the index of the first character of the pattern in the text. If the pattern is not found, it returns -1.

Overall, the KMP algorithm is an efficient way to search for a pattern within a larger text string, with a worst-case time complexity of O(n+m), where n is the length of the text and m is the length of the pattern.
*/