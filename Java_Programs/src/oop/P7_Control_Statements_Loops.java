package oop;
/*
## 1. What are Loops?  
Loops in Java are used to execute a block of code repeatedly as long as a specified condition is `true`. 
This helps avoid redundant code and makes programs efficient.  
---
## Types of Loops in Java  
Java supports the following types of loops:  
### 1. `for` Loop  
- Used when the number of iterations is known beforehand.  
- Consists of initialization, condition, and increment/decrement in a single line.  

for (initialization; condition; increment/decrement) {
    // Code to execute in each iteration
}

- Initialization: Executes only once before the loop starts.  
- Condition: If `true`, loop executes; if `false`, it terminates.  
- Increment/Decrement: Modifies loop control variable after each iteration.  

---

### 2. `while` Loop  
- Used when the number of iterations is not known beforehand.  
- The loop executes only if the condition is true before entering the loop.  

while (condition) {
    // Code to execute in each iteration
}

- Condition: Evaluated before each iteration. If `true`, the loop executes; otherwise, it stops.  

---

### 3. `do-while` Loop  
- Similar to `while` loop but executes at least once, even if the condition is `false`.  
- Condition is checked after executing the loop body.  

do {
    // Code to execute at least once
} while (condition);

- Condition: Checked after executing the loop body. If `true`, the loop continues; otherwise, it stops.  

---

### 4. Enhanced `for` Loop (for-each loop)  
- Special loop designed for iterating over arrays or collections.  
- Eliminates the need for explicit indexing (`i`) or iterator handling.  


for (dataType variable : collection) {
    // Code to execute for each element
}

- `variable`: Represents each element of the collection.  
- `collection`: The array or collection to iterate over.  

---

## Nested Loops in Java  
- A loop inside another loop is called a nested loop.  
- The inner loop executes completely for every single iteration of the outer loop.  

for (initialization; condition; increment/decrement) {
    for (initialization; condition; increment/decrement) {
        // Code to execute inside the nested loop
    }
}

- Can be used with `while`, `do-while`, and `for` loops.  

---

## 4. Summary of Loops in Java  

| Loop Type       | Use Case                              | Condition Checked        | Executes at Least Once? | Suitable for |
|-----------------|---------------------------------------|--------------------------|-------------------------|--------------|
| `for` loop      | When iterations are known             | Before each iteration    | No                      | Counting-based loops |
| `while` loop    | When iterations are unknown           | Before each iteration    | No                      | Condition-based loops |
| `do-while` loop | When at least one execution is needed | After first execution    | Yes                     | User-driven loops |
| `for-each` loop | Iterating over collections            | Not required (automatic) | No                      | Arrays, Lists, Sets |

---

*/
import java.util.Scanner;
public class P7_Control_Statements_Loops {
	    // Method 1: Factorial calculation using a for loop
	    public static int calculateFactorial(int num) {
	        int factorial = 1;
	        for (int i = 1; i <= num; i++) { // Loop from 1 to num
	            factorial *= i; // Multiply factorial by i
	        }
	        return factorial;
	    }

	    // Method 2: Fibonacci series using a while loop
	    public static void printFibonacci(int n) {
	        int first = 0, second = 1, next;
	        int count = 0;
	        System.out.print("Fibonacci Series: ");
	        while (count < n) { // Generate n Fibonacci numbers
	            System.out.print(first + " ");
	            next = first + second; // Next Fibonacci number
	            first = second;
	            second = next;
	            count++;
	        }
	        System.out.println();
	    }

	    // Method 3: Reverse a number using a do-while loop
	    public static int reverseNumber(int num) {
	        int reversed = 0;
	        do {
	            int digit = num % 10; // Extract last digit
	            reversed = reversed * 10 + digit; // Append digit to reversed number
	            num /= 10; // Remove last digit
	        } while (num > 0); // Continue until num becomes 0
	        return reversed;
	    }

	    // Method 4: Print even numbers from an array using an enhanced for loop
	    public static void printEvenNumbers(int[] numbers) {
	        System.out.print("Even Numbers: ");
	        for (int num : numbers) { // Enhanced for loop iterating over array
	            if (num % 2 == 0) {
	                System.out.print(num + " "); // Print even numbers
	            }
	        }
	        System.out.println();
	    }

	    // Main method to execute and test the loop demonstrations
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // 1. Factorial Calculation using for loop
	        System.out.print("Enter a number to calculate factorial: ");
	        int num = scanner.nextInt();
	        System.out.println("Factorial of " + num + " is: " + calculateFactorial(num));

	        // 2. Fibonacci Series using while loop
	        System.out.print("Enter number of Fibonacci terms: ");
	        int n = scanner.nextInt();
	        printFibonacci(n);

	        // 3. Reverse a number using do-while loop
	        System.out.print("Enter a number to reverse: ");
	        int numberToReverse = scanner.nextInt();
	        System.out.println("Reversed Number: " + reverseNumber(numberToReverse));

	        // 4. Print even numbers using enhanced for loop
	        int[] numbersArray = {10, 23, 34, 45, 56, 67, 78, 89, 90};
	        printEvenNumbers(numbersArray);

	        scanner.close();
	    }
	}

