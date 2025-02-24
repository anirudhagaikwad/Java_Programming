package fundamentals.problemstatements;

/*
## Problem: Fibonacci Sequence Generator  
### Statement:  
Write a Java program using an interface that:  
- Generates the first N Fibonacci numbers.  
- Uses an optimized approach for better efficiency.
🔹 Concepts Used:  
- Recursive and Iterative logic  
- Interfaces for generating sequences 
*/
public class FibonacciGen {

	public static void main(String[] args) {
		  FibonacciGenerator fibGen = new Fibonacci();
	      fibGen.generateFibonacci(10);

	}

}

//Interface defining Fibonacci sequence generation
interface FibonacciGenerator {
 void generateFibonacci(int n);
}

//Implementation class
class Fibonacci implements FibonacciGenerator {
 @Override
 public void generateFibonacci(int n) {
     int first = 0, second = 1;

     System.out.print("Fibonacci Sequence: " + first + ", " + second);
     for (int i = 2; i < n; i++) {
         int next = first + second;
         System.out.print(", " + next);
         first = second;
         second = next;
     }
     System.out.println();
 }
}