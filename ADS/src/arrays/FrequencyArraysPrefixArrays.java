package arrays;
/*
Frequency Arrays and Prefix Arrays are two common techniques used in competitive 
programming and algorithmic problem solving to solve a variety of problems.

A frequency array is an array that stores the frequency of each element in a given array. 
For example, if we have an array {1, 2, 2, 3, 3, 3}, the frequency array would be {1, 2, 3}, 
since 1 appears once, 2 appears twice, and 3 appears three times.

A prefix array is an array that stores the prefix sum of elements in a given array. 
For example, if we have an array {1, 2, 3, 4, 5}, the prefix array would be {1, 3, 6, 10, 15}, 
since the ith element in the prefix array is the sum of the first i elements in the input array.
*/

public class FrequencyArraysPrefixArrays {
//Here is an example Java code that calculates the frequency array for an input array:
	public static int[] frequencyArray(int[] arr) {
	    int max = Integer.MIN_VALUE;

	    // Find the maximum element in the array
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] > max) {
	            max = arr[i];
	        }
	    }

	    // Create a frequency array with the size of max+1
	    int[] freq = new int[max+1];

	    // Increment the frequency of each element in the input array
	    for (int i = 0; i < arr.length; i++) {
	        freq[arr[i]]++;
	    }

	    return freq;
	}

//Here is an example Java code that calculates the prefix array for an input array:
	public static int[] prefixArray(int[] arr) {
	    int[] prefix = new int[arr.length];

	    // Calculate the prefix sum for the input array
	    prefix[0] = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	        prefix[i] = prefix[i-1] + arr[i];
	    }

	    return prefix;
	}
	
	
	public static void main(String[] args) {
		String s = "abcba";
	    int k = 2;
	    int maxLen = longestSubstringKDistinct(s, k);
	    System.out.println("The length of the longest substring with at most " + k +
	                       " distinct characters in '" + s + "' is " + maxLen);
	    
	    
	    String t = "ABC";
	    String minWindow = minWindow(s, t);
	    System.out.println("The minimum window substring that contains all the characters in '"
	                       + t + "' in '" + s + "' is '" + minWindow + "'");

	}

/*
Problem 1: Given an array of integers, find the number of pairs (i,j) 
where i < j and arr[i] > arr[j].

Solution: We can use a prefix array to count the number of elements that are less 
than the current element. 
We can then use this count to find the number of pairs where arr[i] > arr[j].
*/
	public static int countInversions(int[] arr) {
	    int[] prefix = prefixArray(arr);
	    int count = 0;

	    for (int i = 0; i < arr.length-1; i++) {
	        for (int j = i+1; j < arr.length; j++) {
	            if (arr[i] > arr[j]) {
	                count += prefix[i] - prefix[j];
	            }
	        }
	    }

	    return count;
	}

/*
Problem 2: 
finding the length of the longest substring that contains at most k distinct characters 
using a sliding window technique and a frequency array:

Solution:
In this code, we maintain a sliding window with two pointers - left and right.
We use a frequency array to store the count of characters in the current window. 
We slide the window to the right until the count of distinct characters in the window is 
less than or equal to k. If the count exceeds k, we move the left pointer to shrink the window 
until the count is reduced to k or less. At each step, we update the maximum length of the 
substring with at most k distinct characters. Finally, we return the maximum length.
*/

public static int longestSubstringKDistinct(String s, int k) {
    int[] freq = new int[128]; // Frequency array to store count of characters
    int left = 0, right = 0; // Two pointers to represent the sliding window
    int count = 0; // Count of distinct characters in the sliding window
    int maxLen = 0; // Maximum length of the substring with at most k distinct characters

    // Slide the window over the string
    while (right < s.length()) {
        char c = s.charAt(right);
        freq[c]++;
        if (freq[c] == 1) {
            count++;
        }
        right++;

        // Shrink the window if it has more than k distinct characters
        while (count > k) {
            char leftChar = s.charAt(left);
            freq[leftChar]--;
            if (freq[leftChar] == 0) {
                count--;
            }
            left++;
        }

        // Update the maximum length of the substring
        maxLen = Math.max(maxLen, right - left);
    }

    return maxLen;
}

/*
Problem 3:
of finding the minimum window substring that contains all the characters in a given 
string t can be solved using a sliding window technique with two pointers and two frequency arrays.

Solution:
In this code, we use two frequency arrays - tFreq to store the count of characters in the string t,
and windowFreq to store the count of characters in the current sliding window. 
We slide the window over the string s until it contains all the characters in t.
If the window contains all the characters in t, we shrink the window to find the minimum window 
substring. We update the minimum window substring whenever the window contains all the characters 
in t and its length is less than the current minimum length. Finally, 
we return the minimum window substring. If no such substring exists, we return an empty string.
*/
public static String minWindow(String s, String t) {
    int[] tFreq = new int[128]; // Frequency array to store count of characters in t
    int[] windowFreq = new int[128]; // Frequency array to store count of characters in the sliding window
    int left = 0, right = 0; // Two pointers to represent the sliding window
    int count = 0; // Count of distinct characters in t in the sliding window
    int minLength = Integer.MAX_VALUE; // Minimum length of the window substring
    int minStart = 0; // Starting index of the minimum window substring

    // Count the frequency of characters in t
    for (char c : t.toCharArray()) {
        tFreq[c]++;
    }

    // Slide the window over the string s
    while (right < s.length()) {
        char c = s.charAt(right);
        windowFreq[c]++;
        if (tFreq[c] > 0 && windowFreq[c] <= tFreq[c]) {
            count++;
        }
        right++;

        // Shrink the window if it contains all the characters in t
        while (count == t.length()) {
            // Update the minimum window substring
            if (right - left < minLength) {
                minLength = right - left;
                minStart = left;
            }

            char leftChar = s.charAt(left);
            windowFreq[leftChar]--;
            if (tFreq[leftChar] > 0 && windowFreq[leftChar] < tFreq[leftChar]) {
                count--;
            }
            left++;
        }
    }

    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
}

}//end class