package oop;
/*
## Introduction to Lambda Expressions
Lambda expressions are anonymous functions that provide a concise way to express instances of functional interfaces. 
They were introduced in Java 8 to support functional programming, 
allowing developers to write cleaner and more readable code.

### Key Features of Lambda Expressions
- Concise Syntax → Eliminates boilerplate code.
- Improves Readability → Reduces verbosity in defining functions.
- Supports Functional Programming → Works with functional interfaces.
- Enhances Parallel Processing → Used in Stream API.

## Purpose of Lambda Expressions
Lambda expressions are used to:
✅ Improve code readability and reduce boilerplate code.  
✅ Enable functional programming in Java.  
✅ Enhance the use of streams and collections.  
✅ Replace anonymous inner classes for shorter and more concise code.  
✅ Increase parallel processing capabilities in Java.

---

## Types of Lambda Expressions
Lambda expressions can be categorized based on their parameter list and return type:

| Type                       | Syntax | Description |
|----------------------------|-----------|----------------|
| No Parameter Lambda        | `() -> System.out.println("Hello!");` | Used when no input is needed. |
| Single Parameter Lambda    | `x -> x * 2;` | Used when only one input is required. Parentheses are optional. |
| Multiple Parameters Lambda | `(a, b) -> a + b;` | Used when two or more inputs are needed. |
| Lambda with Code Block     | `(a, b) -> { int sum = a + b; return sum; };` | Used when multiple lines of code are required. |
| Lambda with No Return      | `(name) -> System.out.println("Hello, " + name);` | Used when the method does not return a value. |

---

##  Functional Interfaces Used with Lambdas
Lambda expressions require a functional interface (an interface with only one abstract method).  
Some commonly used functional interfaces in Java are:

| Interface | Method | Description |
|--------------|-----------|----------------|
| `Runnable` | `void run();` | Used for multi-threading. |
| `Callable<T>` | `T call();` | Similar to `Runnable` but returns a result. |
| `Comparable<T>` | `int compareTo(T o);` | Used for sorting. |
| `Comparator<T>` | `int compare(T o1, T o2);` | Used for custom sorting logic. |
| `Consumer<T>` | `void accept(T t);` | Performs an operation but does not return a result. |
| `Supplier<T>` | `T get();` | Supplies values without input. |
| `Function<T, R>` | `R apply(T t);` | Takes input and returns a result. |
| `Predicate<T>` | `boolean test(T t);` | Tests conditions and returns `true/false`. |

---

## Use Cases of Lambda Expressions (Table Format)

| Use Case | Description | Lambda Example |
|-------------|---------------|-------------------|
| Thread Creation | Used in multithreading with `Runnable`. | `new Thread(() -> System.out.println("Thread Running")).start();` |
| Sorting Collections | Sorts lists with custom logic. | `list.sort((a, b) -> a.compareTo(b));` |
| Event Handling (Swing/FX) | Handles UI actions in a shorter way. | `button.addActionListener(e -> System.out.println("Clicked!"));` |
| Streams API Operations | Filters, maps, and reduces collections. | `list.stream().filter(x -> x > 10).forEach(System.out::println);` |
| Replacing Anonymous Classes | Reduces verbose anonymous class code. | `Comparator<Integer> comp = (a, b) -> a - b;` |
| Functional Programming | Implements `Predicate`, `Consumer`, etc. | `Predicate<String> checkEmpty = s -> s.isEmpty();` |

---

## Key Benefits of Lambda Expressions
✔ Concise Code → Reduces boilerplate code and enhances readability.  
✔ Improved Performance → Avoids creating anonymous inner classes, improving performance.  
✔ Functional Programming Support → Makes Java more functional and modern.  
✔ Better Parallel Processing → Helps in stream processing and concurrency.  

---

##  Limitations of Lambda Expressions
❌ Cannot modify local variables inside lambda (they must be effectively final).  
❌ Cannot have multiple statements without a `{}` block.  
❌ Does not support checked exceptions directly inside the lambda.  
❌ Cannot refer to `this` for instance methods (as lambdas do not create their own class).  

---

### Syntax of Lambda Expression
```java
(parameters) -> expression
(parameters) -> { statements; }
```

---

## Functional Interfaces in Java
Functional interfaces are interfaces that contain only one abstract method, making them ideal for use with 
lambda expressions.

### Characteristics of Functional Interfaces
✔ Contains a single abstract method (SAM).
✔ Can have default and static methods.
✔ Annotated with `@FunctionalInterface` (optional).
✔ Used with Lambda Expressions.

### Common Functional Interfaces in Java
| Interface | Description | Method |
|--------------|----------------|------------|
| `Runnable` | Represents a task that runs | `void run()` |
| `Callable<T>` | Returns a value after execution | `T call()` |
| `Predicate<T>` | Evaluates a boolean condition | `boolean test(T t)` |
| `Function<T, R>` | Takes an input and returns output | `R apply(T t)` |
| `Consumer<T>` | Performs an action on an input | `void accept(T t)` |
| `Supplier<T>` | Supplies values without input | `T get()` |

---

## Functional Programming in Java
Functional Programming (FP) is a paradigm that treats functions as first-class citizens, promoting immutability and pure functions.

### Principles of Functional Programming
| Concept | Description |
|------------|----------------|
| Pure Functions | Always return the same output for the same input. |
| Immutability | Data cannot be modified after creation. |
| Higher-Order Functions | Functions that take or return other functions. |
| Declarative Style | Focuses on "what to do" rather than "how to do it". |
| Lazy Evaluation | Evaluates values only when needed. |
| Recursion Over Loops | Uses recursion instead of traditional loops. |

### Functional Programming Features in Java
| Feature | Description | Introduced in |
|------------|----------------|------------------|
| Lambda Expressions | Enables functional-style programming. | Java 8 |
| Functional Interfaces | Supports single-method interfaces. | Java 8 |
| Stream API | Enables processing of collections. | Java 8 |
| Method References | Shorter way to call methods. | Java 8 |
| Optional Class | Avoids `NullPointerException`. | Java 8 |
| Records | Immutable data structures. | Java 14 |

### Functional vs Object-Oriented Programming
| Aspect | Functional Programming (FP) | Object-Oriented Programming (OOP) |
|------------|----------------|----------------|
| Focus | Functions and transformations | Objects and behavior |
| State Management | Immutable data | Mutable objects |
| Code Style | Declarative | Imperative |
| Functions | First-class citizens | Methods in objects |
| Concurrency | Safer due to immutability | More complex |

---

## Use Cases of Lambda Expressions and Functional Programming

| Use Case | Description | Java Feature Used |
|-------------|---------------|----------------------|
| Data Processing | Filtering and transforming collections | `Stream API`, `map()`, `filter()` |
| Parallel Computing | Running tasks in parallel | `Parallel Streams` |
| Event Handling | Handling UI or backend events | `Lambda Expressions` |
| Concurrency | Avoiding race conditions | `Immutable Data`, `Streams` |
| Logging & Monitoring | Processing logs functionally | `Consumer<T>` |
| Asynchronous Programming | Handling async calls | `CompletableFuture`, `Reactive Streams` |

---

## Conclusion
- Lambda Expressions are a powerful addition to Java, introduced in Java 8.
- They allow cleaner, shorter, and more functional programming.
- Work best with functional interfaces like `Predicate`, `Consumer`, `Supplier`, and `Function`.
- Used widely in streams, collections, multi-threading, and event handling.

 
*/

/*
Problem Statement: Employee Salary Management Using Lambda Expressions
📌
Implement different types of Lambda expressions to handle salary calculations,
tax deductions, and performance bonuses in an Employee Salary Management System.
 */

import java.util.function.Function;

public class P21_Lambda {

	public static void main(String[] args) {
		EmployeeSalaryLambda.main();
        
}
}



class EmployeeSalaryLambda {
    
    // Custom Functional Interface → No Parameter Lambda
    @FunctionalInterface
    interface EmployeeIDGenerator {
        String generate();
    }

    // Custom Functional Interface → Single Parameter Lambda
    @FunctionalInterface
    interface TaxCalculator {
        double calculate(double salary);
    }

    // Custom Functional Interface → Multiple Parameters Lambda
    @FunctionalInterface
    interface NetSalaryCalculator {
        double calculate(double salary, double taxAmount);
    }

    // Custom Functional Interface → Lambda with Code Block
    @FunctionalInterface
    interface EmployeeDetailsPrinter {
        void print(String name);
    }

    // Custom Functional Interface → Lambda with No Return
    @FunctionalInterface
    interface SalarySlipPrinter {
        void print();
    }

    public static void main() {
    	// No Parameter Lambda → Generates a random Employee ID
        EmployeeIDGenerator generateEmployeeID = () -> "EMP" + (int) (Math.random() * 10000);
        String empID = generateEmployeeID.generate();
        System.out.println("Generated Employee ID: " + empID);

        // Single Parameter Lambda → Calculate Tax (15% of salary)
        TaxCalculator calculateTax = salary -> salary * 0.15;
        double tax = calculateTax.calculate(50000.0);
        System.out.println("Calculated Tax: " + tax);

        // Multiple Parameters Lambda → Calculate Net Salary after Tax
        NetSalaryCalculator calculateNetSalary = (salary, taxAmount) -> salary - taxAmount;
        double netSalary = calculateNetSalary.calculate(50000.0, tax);
        System.out.println("Net Salary After Tax: " + netSalary);

        // Lambda with Code Block → Display formatted Employee Details
        EmployeeDetailsPrinter displayDetails = (name) -> {
            System.out.println("------ Employee Details ------");
            System.out.println("Employee ID: " + empID);
            System.out.println("Employee Name: " + name);
            System.out.println("Net Salary: " + netSalary);
            System.out.println("-----------------------------");
        };
        displayDetails.print("Anirudha");

        // Lambda with No Return → Print Salary Slip
        SalarySlipPrinter printSalarySlip = () -> System.out.println("Generating Salary Slip for " + empID + "... Done!");
        printSalarySlip.print();

	}

 }


/*
 ## 🔥 Problem Statement: Employee Salary Management Using Lambda Expressions  

### 📌 Objective:  
Implement different types of Lambda expressions to handle salary calculations, 
tax deductions, and performance bonuses in an Employee Salary Management System.  

---
### 📝 Types of Lambda to Implement:
1. No Parameter Lambda → Generate a unique Employee ID  
2. Single Parameter Lambda → Calculate Tax based on salary  
3. Multiple Parameters Lambda → Calculate Net Salary after deductions  
4. Lambda with Code Block → Display formatted Employee Details  
5. Lambda with No Return → Print Salary Slip  

---

import java.util.function.*;

public class EmployeeSalaryLambda {
    public static void main(String[] args) {
        // 1️⃣ No Parameter Lambda → Generates a unique Employee ID
        Supplier<String> generateEmployeeID = () -> "EMP" + (int) (Math.random() * 10000);
        String empID = generateEmployeeID.get(); // Calling Supplier's get() method
        System.out.println("Generated Employee ID: " + empID);

        // 2️⃣ Single Parameter Lambda → Calculate Tax (Function<T, R>)
        Function<Double, Double> calculateTax = salary -> salary * 0.15; // 15% Tax
        double tax = calculateTax.apply(50000.0); // Applying tax on 50,000 salary
        System.out.println("Calculated Tax: " + tax);

        // 3️⃣ Multiple Parameters Lambda → Calculate Net Salary after deductions
        BiFunction<Double, Double, Double> calculateNetSalary = (salary, taxAmount) -> salary - taxAmount;
        double netSalary = calculateNetSalary.apply(50000.0, tax);
        System.out.println("Net Salary After Tax: " + netSalary);

        // 4️⃣ Lambda with Code Block → Display formatted Employee Details
        Consumer<String> displayDetails = (name) -> {
            System.out.println("------ Employee Details ------");
            System.out.println("Employee ID: " + empID);
            System.out.println("Employee Name: " + name);
            System.out.println("Net Salary: " + netSalary);
            System.out.println("-----------------------------");
        };
        displayDetails.accept("Anirudha"); // Calling Consumer's accept() method

        // 5️⃣ Lambda with No Return → Print Salary Slip (Runnable)
        Runnable printSalarySlip = () -> System.out.println("Generating Salary Slip for " + empID + "... Done!");
        printSalarySlip.run(); // Running the Runnable Lambda
    }
}
```

---

### 📌 Explanation of Each Lambda Type
| Lambda Type | Functionality | Interface Used | Method |
|---------------|----------------|-----------------|------------|
| No Parameter Lambda | Generates a random Employee ID | `Supplier<T>` | `get()` |
| Single Parameter Lambda | Calculates 15% tax on salary | `Function<T, R>` | `apply(T)` |
| Multiple Parameters Lambda | Calculates Net Salary = Salary - Tax | `BiFunction<T, U, R>` | `apply(T, U)` |
| Lambda with Code Block | Displays Employee details in a structured format | `Consumer<T>` | `accept(T)` |
| Lambda with No Return | Prints a Salary Slip message | `Runnable` | `run()` |

---

### ✅ Sample Output
```
Generated Employee ID: EMP6732
Calculated Tax: 7500.0
Net Salary After Tax: 42500.0
------ Employee Details ------
Employee ID: EMP6732
Employee Name: Anirudha
Net Salary: 42500.0
-----------------------------
Generating Salary Slip for EMP6732... Done!
```

---

### 🚀 Summary
- All types of Lambda expressions have been implemented logically.
- Used built-in functional interfaces (`Supplier`, `Function`, `BiFunction`, `Consumer`, `Runnable`).
- Solves a real-world problem (Salary Management).  
- Uses proper comments for better understanding.  

 */

