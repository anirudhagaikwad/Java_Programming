package fundamentals;

import java.util.Scanner;

public class JavaControlStatement_IF_ELSE {
/*
 *  if(condition){// if block}
 *  
 */
	void controlStatements_if_then(int age) {
		/*
		 * The if-then statements is the most basic of all control flow statements ,it tells program to exexute a certain section of code only if a particular test evaluates to true.
		 */
		if(age>18) {
			System.out.println("You are eligible for voting..");
		}	
	}
	
	
	void controlStatements_if_then_else(int age) {
		/*
		 * if_then_else provides secondary path of execution when if clause evaluates false
		 */
		if(age>18) {
			System.out.println("You are eligible for voting..");
		}	
		else {
			System.out.println("You are not eligible for voting..");
		}
	}
	
	
	void controlStatements_if_else_if(float percentage) {
		/*
		 * It contains multiple condition and execute if any condition is true otherwise execute else block
		 */
		char grade;
		if(percentage>=90) {grade='A';}
		else if(percentage>=80) {grade='B';}
		else if(percentage>=70) {grade='C';}
		else if(percentage>=60) {grade='D';}
		else if(percentage>=50) {grade='E';}
		else{ grade='F'; System.out.println("Fail...");}
		System.out.println("Grade = "+grade);
		
	}
	
	
	void controlStatements_nestedIf(int age,float weight) {
		/* nested if statement is a if inside another if */
		if(age>18) {if(weight>50) {System.out.println("Pass Fitness...");}}
		else {System.out.println("Age not match...");}
	}
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your Age : ");
        int age=scan.nextInt();
		JavaControlStatement_IF_ELSE obj=new JavaControlStatement_IF_ELSE();
		obj.controlStatements_if_then(age);
		obj.controlStatements_if_then_else(age);
		System.out.println("Enter Percentage : ");
		float percentage = scan.nextFloat();
		obj.controlStatements_if_else_if(percentage);
		System.out.println("Enter Your Weight : ");
		float weight = scan.nextFloat();
		obj.controlStatements_nestedIf(age, weight);
		
	} //main()

}//JavaControlStatement_IF_ELSE
