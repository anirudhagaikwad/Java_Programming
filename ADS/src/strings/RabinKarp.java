package strings;
import java.util.ArrayList;
import java.util.List;
/*
The Rabin-Karp algorithm is a string matching algorithm that uses hashing to quickly search for a pattern within a larger text string. It works by computing a hash value for the pattern and for all substrings of the text of the same length as the pattern. If the hash values match, the algorithm performs a full comparison of the pattern and the substring to confirm the match. 
*/

public class RabinKarp {

    private static final int PRIME = 101;

    public static List<Integer> findPattern(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        long patternHash = hash(pattern);
        long textHash = hash(text.substring(0, m));
        long h = pow(PRIME, m - 1);
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && pattern.equals(text.substring(i, i + m))) {
                indices.add(i);
            }
            if (i < n - m) {
                textHash = rehash(text, textHash, i, i + m, h);
            }
        }
        return indices;
    }

    private static long hash(String str) {
        int n = str.length();
        long h = 0;
        for (int i = 0; i < n; i++) {
            h += str.charAt(i) * pow(PRIME, n - i - 1);
        }
        return h;
    }

    private static long rehash(String str, long hash, int oldIndex, int newIndex, long h) {
        long newHash = hash - str.charAt(oldIndex) * h;
        newHash = newHash * PRIME;
        newHash = newHash + str.charAt(newIndex) * pow(PRIME, 0);
        return newHash;
    }

    private static long pow(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        List<Integer> indices = findPattern(text, pattern);
        if (indices.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + indices);
        }
    }
}

/*
In this implementation, the findPattern method is used to search for the pattern within the text string. The algorithm uses two helper methods, hash and rehash, to compute and update the hash values as it searches.

The hash method computes a hash value for a given string using the Rabin-Karp hash function. This function simply adds up the ASCII values of the characters in the string, weighted by successive powers of a prime number (in this implementation, 101).

The rehash method updates a hash value when a new character is added or removed from the text. It first subtracts the value of the character being removed from the current hash value, then divides the result by the prime number used in the hash function. Finally, it adds the value of the character being added, weighted by the appropriate power of the prime number.

The findPattern method uses these hash functions to compute the initial hash values for the pattern and the first substring of the text. It then compares the hash values and the actual strings at each position in the text, moving one character at a time. If the hash values and strings match, the method adds the index of the match to a list of indices. Finally, the method updates the hash value for the next substring of the text by calling the rehash method.

Overall, the Rabin-Karp algorithm is a relatively simple and efficient way to search for a pattern within a text string. 
*/