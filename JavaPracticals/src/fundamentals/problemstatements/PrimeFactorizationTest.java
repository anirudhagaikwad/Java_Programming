package fundamentals.problemstatements;
/*
## Problem: Prime Factorization  
### Statement:  
Create a Java program using an interface that:  
- Finds and prints all prime factors of a number.  

🔹 Concepts Used:  
- Mathematical factorization  
- Efficient prime number checks  
*/
public class PrimeFactorizationTest {

	public static void main(String[] args) {
		 PrimeFactorizer factorizer = new PrimeFactorization();
	     factorizer.findPrimeFactors(56);

	}

}

//Interface defining prime factorization method
interface PrimeFactorizer {
 void findPrimeFactors(int number);
}

//Implementation class
class PrimeFactorization implements PrimeFactorizer {
 @Override
 public void findPrimeFactors(int number) {
     System.out.print("Prime Factors of " + number + ": ");
     
     // Print the number of times 2 divides the number
     while (number % 2 == 0) {
         System.out.print(2 + " ");
         number /= 2;
     }

     // Check for odd prime factors
     for (int i = 3; i <= Math.sqrt(number); i += 2) {
         while (number % i == 0) {
             System.out.print(i + " ");
             number /= i;
         }
     }

     // If the number itself is prime and greater than 2
     if (number > 2) {
         System.out.print(number);
     }
     System.out.println();
 }
}