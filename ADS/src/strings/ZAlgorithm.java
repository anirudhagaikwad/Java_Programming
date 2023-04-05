package strings;

import java.util.ArrayList;
import java.util.List;

/*
The Z algorithm is a string matching algorithm that finds all occurrences of a pattern string within a larger text string. It does this by computing a Z array, which is an array of integers that describes the lengths of the longest common prefixes between the pattern and all suffixes of the text.
*/
public class ZAlgorithm {

    public static int[] computeZArray(String text) {
        int n = text.length();
        int[] z = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && text.charAt(right - left) == text.charAt(right)) {
                    right++;
                }
                z[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (z[k] < right - i + 1) {
                    z[i] = z[k];
                } else {
                    left = i;
                    while (right < n && text.charAt(right - left) == text.charAt(right)) {
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        return z;
    }

    public static List<Integer> findPattern(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        String s = pattern + "$" + text;
        int[] z = computeZArray(s);
        for (int i = 0; i < z.length; i++) {
            if (z[i] == pattern.length()) {
                indices.add(i - pattern.length() - 1);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        String text = "ABC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        List<Integer> indices = findPattern(text, pattern);
        System.out.println("Pattern found at indices: " + indices);
    }
}//end class

/*In this implementation, the computeZArray method is used to create the Z array for the given text string. This array is used in the findPattern method to efficiently search for the pattern within the text.

The computeZArray method works by iterating through the text string and building up the Z array incrementally. At each position i in the text, the algorithm checks if i is outside the current Z box (i > right). If it is, the algorithm performs a naive comparison of the text starting at i with the text starting at position 0 to find the length of the longest common prefix. This length is stored in the z array at position i, and the left and right boundaries of the current Z box are updated. If i is inside the current Z box, the algorithm uses a previously computed value to fill in the z array at position i, either by copying a value from a corresponding position in the Z array or by performing a partial comparison of the text.

The findPattern method uses the Z array to search for the pattern within the text. It first concatenates the pattern and text strings, separated by a unique character (in this implementation, $). It then computes the Z array for the concatenated string and looks for positions in the Z array where the value is equal to the length of the pattern. These positions correspond to matches of the pattern within the text. The method returns a list of all such positions.

Overall, the Z algorithm is an efficient way to find all occurrences of a pattern string within a larger text string, and it can be particularly useful when the pattern is long and the text is relatively short.
*/


