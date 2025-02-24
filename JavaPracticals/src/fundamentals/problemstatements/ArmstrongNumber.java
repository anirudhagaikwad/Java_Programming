package fundamentals.problemstatements;

/*
## Problem: Check Armstrong Number for Any Base  
### Statement:  
Develop a Java program using an interface that:
Checks if a number is an Armstrong number in a given base.
An Armstrong number satisfies:
sum of each digit raised to the power of total digits=original number
sum of each digit raised to the power of total digits=original number
Concepts Used:
Mathematical calculations
Interfaces for checking properties 
*/

//Interface defining Armstrong number check
interface ArmstrongChecker {
 boolean isArmstrong(int number, int base);
}

//Implementation class
public class ArmstrongNumber implements ArmstrongChecker {
 @Override
 public boolean isArmstrong(int number, int base) {
     int sum = 0, temp = number, digits = 0;

     // Count the number of digits in the given base
     while (temp > 0) {
         temp /= base;
         digits++;
     }

     temp = number;
     // Compute the Armstrong sum
     while (temp > 0) {
         int remainder = temp % base;
         sum += Math.pow(remainder, digits);
         temp /= base;
     }

     return sum == number;
 }
 
 public static void main(String[] args) {
     ArmstrongChecker checker = (ArmstrongChecker) new ArmstrongNumber();
     int number = 153, base = 10;

     if (checker.isArmstrong(number, base)) {
         System.out.println(number + " is an Armstrong number in base " + base);
     } else {
         System.out.println(number + " is NOT an Armstrong number in base " + base);
     }
 }
}