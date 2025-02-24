package oop;
/*
# Conditional Statements in Java (`if` Statement & Its Types)

## What is an `if` Statement?  
The `if` statement in Java is a conditional control structure used to execute a block of code 
only if a specified condition evaluates to `true`. If the condition is `false`, the block is skipped.
`if` statements control program flow based on conditions.

### Syntax of `if` Statement
if (condition) {
    // Code to execute if condition is true
}
- The condition inside parentheses (`()`) must be a boolean expression (`true` or `false`).
- If the condition is `true`, the block inside `{}` executes.
- If `false`, the block is skipped.

---

### Types of `if` Statements in Java  

### 1. Simple `if` Statement
- It checks a condition, and if `true`, executes the code block.

---

### 2. `if-else` Statement
- If the condition is `true`, one block executes.
- If `false`, another block executes.

---

### 3. `if-else-if` Ladder
- Used when we need to check multiple conditions.
- If the first condition is `false`, it moves to the next `else if` condition.

---

### 4. Nested `if` Statement
- An `if` statement inside another `if` statement.
- Used when multiple dependent conditions need to be checked.

---
## 5. Alternative: Using the Ternary Operator (`?:`)
- A shorter way to write `if-else` statements.
✔ Ternary Operator is useful for simple conditions but not for complex logic.

---

### When to Use `if` Statements?
- Use `if` when only one condition needs to be checked.
- Use `if-else` when you need two options.
- Use `if-else-if` ladder when multiple conditions need to be checked sequentially.
- Use nested `if` when conditions depend on each other.

---

## 4. Key Points About `if` Statements
✔️ The condition inside `if` must be a boolean expression (`true` or `false`).  
✔️ Braces `{}` are optional for single-line statements but recommended for clarity.  
✔️ `if` cannot have a condition with floating-point comparisons due to precision issues.  
✔️ `if-else-if` executes only one block even if multiple conditions are `true`.  

---

*/


import java.util.Scanner;

public class P6_DecisionMakingStatements_IF {

	    // Method 1: Using Simple `if` to check if percentage is 100%
	    public static void checkPerfectScore(double percentage) {
	        if (percentage == 100) {
	            System.out.println("🎉 Perfect Score! You aced it!");
	        }
	    }

	    // Method 2: Using `if-else` to check if the student has passed
	    public static void checkPassStatus(double percentage) {
	        if (percentage >= 50) {
	            System.out.println("✅ Status: Pass");
	        } else {
	            System.out.println("❌ Status: Fail");
	        }
	    }

	    // Method 3: Using `if-else-if` ladder to determine the letter grade
	    public static String getGrade(double percentage) {
	        if (percentage >= 90) {
	            return "A+";
	        } else if (percentage >= 80) {
	            return "A";
	        } else if (percentage >= 70) {
	            return "B";
	        } else if (percentage >= 60) {
	            return "C";
	        } else if (percentage >= 50) {
	            return "D";
	        } else {
	            return "F"; // Fail case
	        }
	    }

	    // Method 4: Using Nested `if` to determine CGPA based on percentage
	    public static double calculateCGPA(double percentage) {
	        double cgpa = 0.0;

	        if (percentage >= 90) {
	            cgpa = 10.0;
	        } else {
	            if (percentage >= 80) {
	                cgpa = 9.0;
	            } else {
	                if (percentage >= 70) {
	                    cgpa = 8.0;
	                } else {
	                    if (percentage >= 60) {
	                        cgpa = 7.0;
	                    } else {
	                        if (percentage >= 50) {
	                            cgpa = 6.0;
	                        } else {
	                            cgpa = 0.0; // Fail case
	                        }
	                    }
	                }
	            }
	        }

	        return cgpa;
	    }

	    // Method 5: Using Ternary Operator to check for distinction (>=75%)
	    public static String checkDistinction(double percentage) {
	        return (percentage >= 75) ? "🏆 Distinction Achieved!" : "Keep Working Hard!";
	    }

	    // Main method to run the program
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input: Total marks obtained and maximum marks
	        System.out.print("Enter total marks obtained: ");
	        int totalMarks = scanner.nextInt();
	        System.out.print("Enter maximum possible marks: ");
	        int maxMarks = scanner.nextInt();

	        // Calculate percentage
	        double percentage = ((double) totalMarks / maxMarks) * 100;
	        System.out.println("\n📊 Results:");
	        System.out.println("Percentage: " + percentage + "%");

	        // Call methods to demonstrate different types of `if` conditions
	        checkPerfectScore(percentage); // Simple if
	        checkPassStatus(percentage); // if-else
	        String grade = getGrade(percentage); // if-else-if ladder
	        System.out.println("Grade: " + grade);
	        double cgpa = calculateCGPA(percentage); // Nested if
	        System.out.println("CGPA: " + cgpa);
	        String distinctionMessage = checkDistinction(percentage); // Ternary operator
	        System.out.println(distinctionMessage);

	        scanner.close();
	    }
	}
