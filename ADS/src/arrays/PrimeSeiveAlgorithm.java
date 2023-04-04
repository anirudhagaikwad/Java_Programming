package arrays;

import java.util.Arrays;

/*
 * The prime sieve algorithm is an efficient algorithm for generating all prime numbers up to a given limit. It works by iteratively marking the multiples of each prime number, starting with 2, as composite (i.e., not prime).
 * The remaining unmarked numbers are prime.
 */
public class PrimeSeiveAlgorithm {
/*
In this implementation, we create a boolean array isPrime of size n + 1 and initialize all elements to true. We then explicitly set the first two elements, isPrime[0] and isPrime[1], to false because they are not prime.

We then loop through the array starting from 2 up to the square root of n. For each number i that is prime, we mark all its multiples starting from i*i as composite by setting their corresponding elements in isPrime to false. This is because any number less than i*i that is a multiple of i has already been marked as composite by a smaller prime.

After marking all the multiples of each prime, the remaining unmarked numbers are prime. We then return the isPrime array.

To use this implementation, you can call the primeSieve method with an integer argument n:
*/
	public static boolean[] primeSieve(int n) {
	    boolean[] isPrime = new boolean[n + 1];
	    Arrays.fill(isPrime, true);

	    isPrime[0] = false;
	    isPrime[1] = false;

	    for (int i = 2; i * i <= n; i++) {
	        if (isPrime[i]) {
	            for (int j = i * i; j <= n; j += i) {
	                isPrime[j] = false;
	            }
	        }
	    }

	    return isPrime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] isPrime = primeSieve(20);
		for (int i = 2; i <= 20; i++) {
		    if (isPrime[i]) {
		        System.out.print(i + " ");
		    }
		}

	}

}//end class
