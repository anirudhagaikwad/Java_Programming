package arrays;
/*
 * Kadane's algorithm is a famous algorithm for finding the maximum subarray sum in a given array of integers. 
 * The subarray is defined as a contiguous portion of the array.
 */
public class KadaneAlgorithm {
/*
 * In this implementation, we initialize two variables: maxSoFar and maxEndingHere to the first element of the array. The maxEndingHere variable represents the maximum subarray sum that ends at the current position. The maxSoFar variable represents the maximum subarray sum seen so far.

 * We then loop through the array, starting from the second element. For each element, we update maxEndingHere to be either the current element or the sum of the current element and the previous maxEndingHere. This is because if the sum of the current element and the previous maxEndingHere is greater than the current element alone, we can extend the subarray that ends at the current position. Otherwise, we start a new subarray from the current position.

 * After updating maxEndingHere, we update maxSoFar to be the maximum of its current value and maxEndingHere. This is because we want to keep track of the maximum subarray sum seen so far.

 * Finally, we return maxSoFar, which represents the maximum subarray sum in the array.	
 */
	public static int kadane(int[] arr) {
	    int maxSoFar = arr[0];
	    int maxEndingHere = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
	        maxSoFar = Math.max(maxSoFar, maxEndingHere);
	    }
	    return maxSoFar;
	}


	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int maxSubarraySum = kadane(arr);
		System.out.println(maxSubarraySum); // Output: 7
	}

}//end class
