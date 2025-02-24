package examples;

/*
Problem Statement: Enhanced Quadratic Equation Solver
Statement:
Accept three coefficients (a, b, c) of a quadratic equation in the form ax² + bx + c = 0.
Use different types of if statements (if, if-else, nested if, if-else-if ladder, and ternary operator ? :) to determine and categorize the nature of the roots.
Calculate and display the roots if they are real.
Use separate methods to:
Take input
Compute the discriminant
Categorize and print roots
Display results
*/

import java.util.Scanner;

//Class to categorize and compute quadratic equation roots
public class QuadraticEquationSolver_IF_ELSE {
 
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Get coefficients from user
     double[] coefficients = getCoefficients(scanner);
     double a = coefficients[0];
     double b = coefficients[1];
     double c = coefficients[2];

     // Check if it's a quadratic equation using ternary operator
     boolean isQuadratic = (a != 0) ? true : false;

     if (!isQuadratic) {
         System.out.println("Invalid input! 'a' cannot be zero in a quadratic equation.");
     } else {
         double discriminant = computeDiscriminant(a, b, c);
         printRootCategory(a, b, c, discriminant);
     }

     scanner.close();
 }

 /**
  * Method to take user input for coefficients.
  * @param scanner Scanner object for input
  * @return Array of three coefficients [a, b, c]
  */
 public static double[] getCoefficients(Scanner scanner) {
     System.out.print("Enter coefficient a: ");
     double a = scanner.nextDouble();
     System.out.print("Enter coefficient b: ");
     double b = scanner.nextDouble();
     System.out.print("Enter coefficient c: ");
     double c = scanner.nextDouble();
     return new double[]{a, b, c};
 }

 /**
  * Method to compute the discriminant of the quadratic equation.
  * @param a Coefficient 'a'
  * @param b Coefficient 'b'
  * @param c Coefficient 'c'
  * @return Discriminant value
  */
 public static double computeDiscriminant(double a, double b, double c) {
     return (b * b) - (4 * a * c);
 }

 /**
  * Method to determine and display the type of roots based on the discriminant.
  * Uses: `if`, `if-else`, `nested if`, `if-else-if ladder`, and `ternary operator`
  * @param a Coefficient 'a'
  * @param b Coefficient 'b'
  * @param c Coefficient 'c'
  * @param discriminant Discriminant value
  */
 public static void printRootCategory(double a, double b, double c, double discriminant) {
     // Using if-else-if ladder
     if (discriminant > 0) { // Two real and distinct roots
         double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
         double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
         System.out.println("The equation has two real and distinct roots:");
         System.out.println("Root 1: " + root1);
         System.out.println("Root 2: " + root2);
     } else if (discriminant == 0) { // Two real and equal roots
         double root = -b / (2 * a);
         System.out.println("The equation has two real and equal roots:");
         System.out.println("Root: " + root);
     } else { // Nested if for complex (imaginary) roots
         if (discriminant < 0) {
             double realPart = -b / (2 * a);
             double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);

             // Ternary operator to print complex roots in a clean format
             String root1 = realPart + (imaginaryPart > 0 ? " + " : " - ") + Math.abs(imaginaryPart) + "i";
             String root2 = realPart + (imaginaryPart > 0 ? " - " : " + ") + Math.abs(imaginaryPart) + "i";

             System.out.println("The equation has complex (imaginary) roots:");
             System.out.println("Root 1: " + root1);
             System.out.println("Root 2: " + root2);
         }
     }
 }
}


/*
### Understanding Key Terms: Coefficients, Quadratic Equation, and Discriminant  

---

### What are Coefficients?  
- A coefficient is a numerical value that multiplies a variable in an equation.  
- Example: In the equation 3x² + 4x - 5 = 0,  
  - `3` is the coefficient of x²,  
  - `4` is the coefficient of x,  
  - `-5` is the constant term (it doesn’t have a variable).  

📌 In general, for a quadratic equation `ax² + bx + c = 0`:  
- `a`, `b`, and `c` are the coefficients (where `a ≠ 0`).  

---

### What is a Quadratic Equation?  
A quadratic equation is a polynomial equation of degree 2, meaning the highest exponent of `x` is 2.  

🔹 Standard form:  
ax² + bx + c = 0

where:  
- `a`, `b`, and `c` are coefficients,  
- `x` is the variable,  
- `a ≠ 0` (otherwise, it's not a quadratic equation).  

📌 Examples of Quadratic Equations:  
1. x² - 5x + 6 = 0  
2. 2x² + 3x - 2 = 0  
3. 4x² - 8 = 0 (where `b = 0`)  

---

### What is the Discriminant?  
- The discriminant is a mathematical expression that helps us determine the nature of the roots (solutions) of a quadratic equation.  
- It is given by the formula:  
  D = b² - 4ac
  where `a`, `b`, and `c` are the coefficients from the quadratic equation.  

🔹 Why is the Discriminant Important?  
- It tells us how many and what type of roots a quadratic equation has.  

📌 Interpreting the Discriminant (`D`):  
| Discriminant (`D = b² - 4ac`) | Nature of Roots |
|-------------------------------|------------------|
| `D > 0`                       | Two real and distinct roots |
| `D = 0`                       | Two real and equal roots |
| `D < 0`                       | Two complex (imaginary) roots |

🔹 Example Calculations:  
1. Equation: `x² - 5x + 6 = 0`  
   - `a = 1`, `b = -5`, `c = 6`  
   - Discriminant: `(-5)² - 4(1)(6) = 25 - 24 = 1` (D > 0, Two Real Roots)  
2. Equation: `x² - 4x + 4 = 0`  
   - `a = 1`, `b = -4`, `c = 4`  
   - Discriminant: `(-4)² - 4(1)(4) = 16 - 16 = 0` (D = 0, One Real Root)  
3. Equation: `x² + 2x + 5 = 0`  
   - `a = 1`, `b = 2`, `c = 5`  
   - Discriminant: `(2)² - 4(1)(5) = 4 - 20 = -16` (D < 0, Complex Roots)  

---

### Summary
| Concept            | Definition |
|--------------------|--------------|
| Coefficient        | Numbers that multiply variables in an equation (e.g., in `3x² + 4x - 5`, coefficients are `3`, `4`, and `-5`). |
| Quadratic Equation | A polynomial equation of degree 2 in the form `ax² + bx + c = 0`. |
| Discriminant       | The value `b² - 4ac` that determines the nature of the roots of a quadratic equation. |

*/