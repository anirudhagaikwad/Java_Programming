package arrays;
/*
The Pigeonhole Principle is a fundamental concept in mathematics that states that if you have more pigeons than pigeonholes, then at least one pigeonhole must have more than one pigeon. It is often used to prove the existence of a solution or a certain property in combinatorial problems.

In computer science, the Pigeonhole Principle has many applications, such as in algorithm analysis, hashing, and scheduling. For example, in hashing, the Pigeonhole Principle implies that if you have more keys than hash buckets, then at least one bucket must contain multiple keys.
*/

public class PigeonholePrinciple {
/*
This implementation checks if an integer array nums contains any duplicate values using the Pigeonhole Principle. It creates a boolean array seen of length n, where n is the length of nums. It then loops through each element in nums and checks if it has been seen before by checking the corresponding value in seen. If the value has been seen before, then there is a duplicate and the method returns true. If no duplicates are found, the method returns false.

Overall, the Pigeonhole Principle is a powerful tool that can be used in a variety of computational problems.	
*/
	public static boolean hasDuplicate(int[] nums) {
	    int n = nums.length;
	    boolean[] seen = new boolean[n];
	    for (int num : nums) {
	        if (seen[num]) {
	            return true;
	        }
	        seen[num] = true;
	    }
	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,10};
	    boolean hasDuplicate = hasDuplicate(nums);
	    System.out.println("Array has duplicate values: " + hasDuplicate);
	}

}
