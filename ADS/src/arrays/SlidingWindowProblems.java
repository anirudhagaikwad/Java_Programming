package arrays;
/*
In computer science and algorithms, "sliding window" refers to a technique or approach to 
solve a problem that involves iterating over an array, string, or other sequence data structure 
by defining a window of fixed size and "sliding" it over the data structure, one position at a time.

The window size is typically defined by the problem requirements and can be of variable length. 
The sliding window approach can be useful for solving problems that involve searching for a subarray, 
substring, or subsequence of specific length or that require comparing subarrays or substrings of 
different lengths.

The sliding window approach can often be more efficient than other approaches that require multiple 
nested loops or other complex operations. 
By limiting the scope of the search to a fixed window size, the sliding window approach can reduce 
the number of comparisons and iterations required to find a solution.
 */

import java.util.Arrays;

public class SlidingWindowProblems {

/* Problem 1: Maximum Sum Subarray of Size K
 * Given an array of integers and a positive integer k, 
 * find the maximum sum of any contiguous subarray of size k.
Solution:
	We can solve this problem by maintaining a sliding window of size K and iterating over the array.
	At each iteration, we remove the first element of the window and add the next element to the 
	window. We keep track of the maximum sum of any subarray of size K encountered so far.	
*/	
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i - k + 1];
            }
        }
        return maxSum;
    }

    /* Problem 2: Count Occurrences of Anagrams
     * Given a string and a pattern, 
     * find the number of occurrences of the pattern as an anagram in the string.
     */
    public static int countAnagramOccurrences(String str, String pattern) {
        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternFreq[pattern.charAt(i) - 'a']++;
        }
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            windowFreq[rightChar - 'a']++;
            if (windowEnd - windowStart + 1 > pattern.length()) {
                char leftChar = str.charAt(windowStart);
                windowFreq[leftChar - 'a']--;
                windowStart++;
            }
            if (Arrays.equals(patternFreq, windowFreq)) {
                count++;
            }
        }
        return count;
    }

    /* Problem 3: Minimum Window Substring
     * Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
     * If there is no such window in s that covers all characters in t, return the empty string "".
     
Solution :
This method uses two frequency arrays, tFreq and windowFreq, to keep track of the count of characters
in the string t and the sliding window, respectively. The windowStart and windowEnd pointers are 
used to represent the sliding window. The minWindowStart and minLength variables keep track of 
the starting index and length of the minimum window substring that contains all the characters in t.

The method first counts the frequency of characters in t using the tFreq array. 
It then slides the window over the string s and counts the frequency of characters in the 
sliding window using the windowFreq array. If the sliding window contains all the characters in t,
the method updates the minimum window substring using the minWindowStart and minLength variables.

The method returns the minimum window substring or an empty string if there is no such window 
in s that covers all characters in t.
*/
    public static String minWindowSubstring(String s, String t) {
        int[] tFreq = new int[26];
        int[] windowFreq = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c >= 'a' && c <= 'z') {
                tFreq[c - 'a']++;
            }
        }
        int windowStart = 0;
        int minWindowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (rightChar >= 'a' && rightChar <= 'z') {
                windowFreq[rightChar - 'a']++;
                if (tFreq[rightChar - 'a'] > 0 && tFreq[rightChar - 'a'] >= windowFreq[rightChar - 'a']) {
                    count++;
                }
                while (count == t.length()) {
                    if (windowEnd - windowStart + 1 < minLength) {
                        minLength = windowEnd - windowStart + 1;
                        minWindowStart = windowStart;
                    }
                    char leftChar = s.charAt(windowStart);
                    if (leftChar >= 'a' && leftChar <= 'z') {
                        windowFreq[leftChar - 'a']--;
                        if (tFreq[leftChar - 'a'] > 0 && tFreq[leftChar - 'a'] > windowFreq[leftChar - 'a']) {
                            count--;
                        }
                    }
                    windowStart++;
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minWindowStart, minWindowStart + minLength);
    }

    public static void main(String[] args) {
        // Problem 1: Maximum Sum Subarray of Size K
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        int maxSum1 = maxSumSubarray(arr1, k1);
        System.out.println("Problem 1 Example:");
        System.out.println("Input: " + Arrays.toString(arr1) + ", k = " + k1);
        System.out.println("Output: " + maxSum1 + "\n");

        // Problem 2: Count Occurrences of Anagrams
        String str2 = "forxxorfxdofr";
        String pattern2 = "for";
        int count2 = countAnagramOccurrences(str2, pattern2);
        System.out.println("Problem 2 Example:");
        System.out.println("Input: str = " + str2 + ", pattern = " + pattern2);
        System.out.println("Output: " + count2 + "\n");

        // Problem 3: Minimum Window Substring
        String str3 = "ADOBECODEBANC";
        String t3 = "ABC";
        String minWindow3 = minWindowSubstring(str3, t3);
        System.out.println("Problem 3 Example:");
        System.out.println("Input: str = " + str3 + ", t = " + t3);
        System.out.println("Output: " + minWindow3);
    }

}