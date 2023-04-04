package binarySearch;

public class BinarySearchExamples {
/*
A)Search in Rotated Sorted Array I
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 0 times.
Given the sorted rotated array nums of non-unique elements, return true if target is in nums, or false if it is not in nums.
*/
	public boolean search(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        int mid = (left + right) / 2;
	        if (nums[mid] == target) {
	            return true;
	        }
	        if (nums[mid] == nums[left] && nums[mid] == nums[right]) { // handle duplicates
	            left++;
	            right--;
	        } else if (nums[mid] >= nums[left]) { // left side is sorted
	            if (target >= nums[left] && target < nums[mid]) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        } else { // right side is sorted
	            if (target > nums[mid] && target <= nums[right]) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	    }
	    return false;
	}

	/*
	the array may contain duplicate elements. The key idea is to use binary search to find the pivot index as in the previous problem, but now we need to handle the case where the middle element is equal to the leftmost and rightmost elements. In this case, we cannot determine which side of the pivot is sorted, so we increment the left index and decrement the right index until we find a non-duplicate element. Then we proceed with binary search as in the previous problem. The time complexity of this solution is O(n) in the worst case where all elements are the same, but in practice it should be much faster.
	*/


/*
B)Search in Rotated Sorted Array II
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 0 times.
Given the sorted rotated array nums of unique elements, return the index of target if it is in nums, or -1 if it is not in nums.
*/
	public int searchRotatedArray(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        int mid = (left + right) / 2;
	        if (nums[mid] == target) {
	            return mid;
	        }
	        if (nums[mid] >= nums[left]) { // left side is sorted
	            if (target >= nums[left] && target < nums[mid]) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        } else { // right side is sorted
	            if (target > nums[mid] && target <= nums[right]) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	    }
	    return -1;
	}

	/*
	we are asked to find the index of a target element in a rotated sorted array. The key idea is to use binary search to find the pivot index as in the previous problem, and then perform binary search on the left or right side of the pivot depending on whether the target is greater or smaller than the first element of the array. We keep narrowing down the search range by comparing the target with the middle element until we find the target or exhaust the search range. The time complexity of this solution is O(log n), where n is the length of the array.
	*/

	
/*
C)Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 0 times.
Return the minimum element of this array.
*/
	public int findMin(int[] nums) {
	    int left = 0, right = nums.length - 1;
	    while (left < right) {
	        int mid = (left + right) / 2;
	        if (nums[mid] > nums[right]) { // pivot is on the right side
	            left = mid + 1;
	        } else { // pivot is on the left side or mid
	            right = mid;
	        }
	    }
	    return nums[left];
	}

	/*
	This problem requires us to find the minimum element in a rotated sorted array. The key idea is to use binary search to find the pivot index, which is the index where the array is rotated. Once we find the pivot, the minimum element is the element at the pivot index. To find the pivot index, we compare the middle element with the rightmost element. If the middle element is greater than the rightmost element, it means the pivot is on the right side of the middle element. Otherwise, the pivot is on the left side or at the middle element. We keep narrowing down the search range by comparing the middle element with the rightmost element until we find the pivot. The time complexity of this solution is O(log n), where n is the length of the array.
	*/

	
/*
D)Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
*/
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int m = nums1.length, n = nums2.length;
	    if (m > n) return findMedianSortedArrays(nums2, nums1); // ensure nums1 is the smaller array
	    int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
	    while (imin <= imax) {
	        int i = (imin + imax) / 2;
	        int j = halfLen - i;
	        if (i < m && nums2[j-1] > nums1[i]) {
	            imin = i + 1;
	        } else if (i > 0 && nums1[i-1] > nums2[j]) {
	            imax = i - 1;
	        } else { // i is perfect
	            int maxLeft = 0;
	            if (i == 0) {
	                maxLeft = nums2[j-1];
	            } else if (j == 0) {
	                maxLeft = nums1[i-1];
	            } else {
	                maxLeft = Math.max(nums1[i-1], nums2[j-1]);
	            }
	            if ((m + n) % 2 == 1) {
	                return maxLeft;
	            }
	            int minRight = 0;
	            if (i == m) {
	                minRight = nums2[j];
	            } else if (j == n) {
	                minRight = nums1[i];
	            } else {
	                minRight = Math.min(nums1[i], nums2[j]);
	            }
	            return (maxLeft + minRight) / 2.0;
	        }
	    }
	    return -1; // never reach here
	}

	/*
	This problem is a classic example of the application of binary search in a sorted array. The key idea is to find a partition of the two arrays such that the elements on the left side are smaller than the elements on the right side. The median of the two arrays is the average of the two middle elements if the total length is even, or the middle element if the total length is odd. To find the partition, we use binary search to search for the right index i in the smaller array such that the left side of the partition has i elements, and the right side of the partition has (m + n + 1) / 2 - i elements. We compare the elements around the partition to ensure that the left side is smaller than the right side. Once we find the partition, we can calculate the median based on the maximum element on the left side and the minimum element on the right side.
	*/
	
	
	public static void main(String[] args) {
	    BinarySearchExamples problems = new BinarySearchExamples();
	    int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
	    System.out.println(problems.search(nums1, 3)); // expected output: 
	    System.out.println(problems.search(nums1, 8)); // expected output: 
	    
	    int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
	    System.out.println(problems.searchRotatedArray(nums2, 0)); // expected output: 
	    System.out.println(problems.searchRotatedArray(nums2, 3)); // expected output: 
	    
	    int[] nums3 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
	    System.out.println(problems.findMin(nums3)); // expected output: 
	    System.out.println(problems.findMin(nums1)); // expected output: 
	    
	    int[] nums4 = {1, 3, 1, 1, 1};
	    System.out.println(problems.findMedianSortedArrays(nums4, nums1)); // expected output: 
	    System.out.println(problems.findMedianSortedArrays(nums4, nums3)); // expected output: 
	}


}//end class
