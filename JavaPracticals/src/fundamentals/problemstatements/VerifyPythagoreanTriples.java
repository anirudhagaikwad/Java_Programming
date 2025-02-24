package fundamentals.problemstatements;

/*
## Problem: Verify Pythagorean Triples  
### Statement:  
Write a Java program using an interface that:  
- Checks if three given numbers form a Pythagorean triplet.  

🔹 Concepts Used:  
- Mathematical theorem verification  
- Interfaces for defining checks  
*/
public class VerifyPythagoreanTriples {

	public static void main(String[] args) {
	
		  PythagoreanChecker checker = (PythagoreanChecker) new PythagoreanTest();
	        
	        int a = 3, b = 4, c = 5;
	        if (checker.isPythagoreanTriplet(a, b, c)) {
	            System.out.println(a + ", " + b + ", " + c + " form a Pythagorean triplet");
	        } else {
	            System.out.println(a + ", " + b + ", " + c + " do NOT form a Pythagorean triplet");
	        }
	    }
	}


//Interface defining Pythagorean triplet check
interface PythagoreanChecker {
 boolean isPythagoreanTriplet(int a, int b, int c);
}

//Implementation class
class PythagoreanTest implements PythagoreanChecker {
 @Override
 public boolean isPythagoreanTriplet(int a, int b, int c) {
     int x = a * a, y = b * b, z = c * c;
     return (x + y == z) || (x + z == y) || (y + z == x);
 }
}