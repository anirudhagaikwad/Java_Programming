package oop;

import java.util.Scanner;
class ArmStrong {
	void printArmstrong() {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter First Number : ");
	  int low = sc.nextInt();
	  System.out.println("Enter Second Number : ");
	  int high = sc.nextInt();

	  for(int number = low + 1; number < high; ++number) {
	    int digits = 0;
	    int result = 0;
	    int originalNumber = number;

	    // number of digits calculation
	    while (originalNumber != 0) {
	      originalNumber /= 10;
	      ++digits;
	    }

	    originalNumber = number;

	    // result contains sum of nth power of its digits
	    while (originalNumber != 0) {
	      int remainder = originalNumber % 10;
	      result += Math.pow(remainder, digits);
	      originalNumber /= 10;
	    }

	    if (result == number) {
	      System.out.print(number + " ");
	    }
	  }
	  sc.close();
	}
	
	public static void main(String[] args) {
	ArmStrong obj=new ArmStrong();
	obj.printArmstrong();
	}
	}
