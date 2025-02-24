package oop;
/*
## What is Exception Handling in Java?  
Exception handling is a mechanism that allows a program to detect, handle, and recover from runtime errors without crashing unexpectedly.  

### Key Concepts:
- Exception – An unexpected event that disrupts the normal flow of a program.  
- Exception Handling – The process of handling runtime errors gracefully using `try-catch` blocks.  
- Throwable – The superclass of all exceptions and errors in Java.  

---

## Hierarchy of Exception Handling Classes  
Java’s exception handling follows a hierarchical structure under the `Throwable` class.

### Exception Hierarchy:

java.lang.Throwable
   ├── java.lang.Exception  (Checked Exceptions)
   │      ├── IOException
   │      ├── SQLException
   │      ├── ClassNotFoundException
   │      └── ... (other checked exceptions)
   │
   ├── java.lang.RuntimeException (Unchecked Exceptions)
   │      ├── NullPointerException
   │      ├── ArithmeticException
   │      ├── ArrayIndexOutOfBoundsException
   │      └── ... (other unchecked exceptions)
   │
   └── java.lang.Error (Serious system errors)
          ├── StackOverflowError
          ├── OutOfMemoryError
          └── ... (other critical errors)


### Breakdown of Exception Hierarchy:
1. Throwable (`java.lang.Throwable`)  
   - Root class for all exception and error handling.
   - Has two major subclasses: `Exception` and `Error`.

2. Exception (`java.lang.Exception`)  
   - Represents recoverable conditions.
   - Further classified into:
     - Checked Exceptions (Compile-time exceptions)
     - Unchecked Exceptions (Runtime exceptions)

3. Error (`java.lang.Error`)  
   - Represents serious system failures (not recoverable).  
   - Handled by JVM, not programmers.

---




Hierarchy of Checked Exceptions:

         Exception (Checked)
           │
    ┌──────┴────────────┐
IOException       SQLException

#### 1. Checked Exception (Compile-Time Exception)
- These are exceptions that are checked at compile-time by the Java compiler.
- If your code contains a checked exception and you don’t handle it using `try-catch` or `throws`, 
  the compiler will throw an error.
- Checked exceptions occur at: `javac FileName.java` (during compilation).  
- These exceptions typically occur due to external factors like file operations, database access, 
  or network issues.

##### Examples of Checked Exceptions:
- `IOException`
- `SQLException`
- `ClassNotFoundException`
- `InterruptedException`
- `FileNotFoundException`

---

Hierarchy of Unchecked Exceptions:

      RuntimeException (Unchecked)
             │
    ┌───────┴────────────────┐
NullPointerException  ArithmeticException

#### 2. Unchecked Exception (Runtime Exception)
- These exceptions occur at runtime and are not checked at compile-time.
- The Java compiler does not force handling of unchecked exceptions.
- Unchecked exceptions occur at: `java FileName.class` (during execution).  
- These usually arise due to logical errors or programming mistakes 
  (e.g., dividing by zero, accessing an invalid array index).

##### Examples of Unchecked Exceptions:
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ArithmeticException`
- `ClassCastException`
- `IllegalArgumentException`

---

### Key Differences Between Checked and Unchecked Exceptions

| Feature     | Checked Exception                     | Unchecked Exception               |
|-------------|--------------------------------------|----------------------------------|
| Checked at  | Compile-time (`javac FileName.java`) | Runtime (`java FileName.class`) |
| Handling    | Must be handled using `try-catch` or `throws` | Optional (compiler doesn’t enforce it) |
| Caused by   | External factors (I/O, database, network) | Programming mistakes (logic errors) |
| Examples    | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |





---


### (C) Errors (JVM Errors)
- Irrecoverable failures in JVM (e.g., hardware or memory issues).
- Not handled by programmers.
- Examples:
  - `StackOverflowError`
  - `OutOfMemoryError`
  - `VirtualMachineError`

Hierarchy of Errors:
```
         Error
           │
    ┌──────┴───────────┐
 StackOverflowError  OutOfMemoryError
```

---

## 2. Exception Handling Mechanism in Java
Java provides multiple ways to handle exceptions effectively:

| Keyword | Purpose |
|------------|------------|
| `try` | Defines a block of code that may throw an exception. |
| `catch` | Catches and handles exceptions thrown in the `try` block. |
| `finally` | Code that executes always, regardless of an exception. |
| `throws` | Declares exceptions that a method might throw. |
| `try-with-resources` | Automatically closes resources (like files, DB connections) to prevent memory leaks. |

---

## `try-with-resources` (Automatic Resource Management)
### What is it?
- Introduced in Java 7 (`java.lang.AutoCloseable` interface).
- Used for automatically closing resources (e.g., files, streams, DB connections) after execution.
- Prevents resource leaks (no need for manual `finally` block).

### Why Use `try-with-resources`?
✔ Eliminates the need for a `finally` block for resource closing.  
✔ Reduces boilerplate code.  
✔ Ensures proper resource management (even if an exception occurs).  
✔ Prevents memory leaks in applications.

---

## Key Takeaways
- `try-with-resources` ensures automatic cleanup of resources like `FileReader`, `BufferedReader`, `Socket`, `Connection`, etc.  
- Works with classes that implement the `AutoCloseable` or `Closeable` interfaces.  
- Recommended over manual `finally` block resource closing for cleaner, more reliable code.  

---

## 3. Why Use Exception Handling?
✔ Prevents Program Crash – Ensures graceful recovery from errors.  
✔ Increases Code Maintainability – Separates error-handling logic from main logic.  
✔ Handles External Issues – Manages file operations, network failures, etc.  
✔ Improves Debugging – Helps identify and resolve errors quickly.  

---

## 4. Common Real-World Scenarios
| Scenario | Exception Type | Example Exception |
|-------------|-------------------|-----------------------|
| File Not Found | Checked Exception | `FileNotFoundException` |
| Invalid User Input | Unchecked Exception | `IllegalArgumentException` |
| Division by Zero | Unchecked Exception | `ArithmeticException` |
| Null Object Access | Unchecked Exception | `NullPointerException` |
| Insufficient Memory | Error (JVM) | `OutOfMemoryError` |

---

## 5. Key Takeaways
✔ Exceptions are categorized into Checked (Compile-time) and Unchecked (Runtime).  
✔ Errors are critical and cannot be handled in Java applications.  
✔ Use `try-catch` to handle exceptions and `finally` for cleanup operations.  
✔ Best practices involve throwing custom exceptions when required.  

### Error Message Methods in Java (Throwable Class)

`Throwable` class provides several methods to retrieve details about exceptions and errors. These methods help developers diagnose issues by providing useful error messages and stack trace information.

#### Table: Error Message Methods in Java
| Method                   | Description |
|--------------------------|---------------|
| `getMessage()`           | Returns a detailed message about the exception or error. It is useful for debugging as it provides a description of what went wrong. |
| `getLocalizedMessage()`  | Similar to `getMessage()`, but can provide localized error messages if overridden in subclasses. |
| `toString()`             | Returns a string representation of the exception, including its class name and message. |
| `printStackTrace()`      | Prints the complete stack trace of the exception, including the method calls leading up to the error. |
| `getStackTrace()`        | Returns an array of `StackTraceElement` objects, each representing a method in the call stack. |
| `setStackTrace(StackTraceElement[] stackTrace)` | Modifies the stack trace of the throwable. Used to set a custom stack trace. |
| `fillInStackTrace()`     | Reinitializes the stack trace information for the exception, useful when rethrowing exceptions. |
| `addSuppressed(Throwable exception)` | Adds an exception to the list of suppressed exceptions. Useful when using try-with-resources. |
| `getSuppressed()`        | Returns an array of suppressed exceptions. These are exceptions that were caught and suppressed while another exception was thrown. |


*/
import java.io.*;
public class P20_ExceptionHandling {

	public static void main(String[] args) {
	     System.out.println("=== Exception Handling Demonstration ===");

	     // Checked Exception (File Reading)
	     try {
			ExceptionHandlingDemo.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	     // Unchecked Exception (Division)
	     ExceptionHandlingDemo.divide(10, 0);

	     // Unchecked Exception (Null Pointer)
	     ExceptionHandlingDemo.checkNull(null);

	     // Checked Exception (Custom Exception)
	     try {
	    	 ExceptionHandlingDemo.withdraw(5000); // Throws InsufficientFundsException
	     } catch (InsufficientFundsException e) {
	         System.out.println("Checked Exception Caught: " + e.getMessage());
	     }

	     // Error (Stack Overflow)
	     ExceptionHandlingDemo.causeStackOverflow(1);

	     // Error (Out of Memory)
	     ExceptionHandlingDemo.causeOutOfMemory();


	}

}


/*
 We will create a Banking System where:
Checked Exception (IOException) occurs when reading account details from a file.
Unchecked Exception (ArithmeticException, NullPointerException) occurs when performing 
calculations or accessing null objects.
Error (StackOverflowError, OutOfMemoryError) occurs due to excessive recursion or memory overload.
 */

//Custom Checked Exception for Bank Account
class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

class ExceptionHandlingDemo {

 // Checked Exception Demonstration: Throws IOException
 public static void readFile() throws IOException {
     try (BufferedReader br = new BufferedReader(new FileReader("non_existent_file.txt"))) {
         System.out.println(br.readLine());
     } catch (IOException e) {
         System.out.println("Checked Exception Caught: " + e);
     }
 }

 // Unchecked Exception Demonstration: Division by zero
 public static void divide(int a, int b) {
     try {
         int result = a / b; // This may cause ArithmeticException
         System.out.println("Division Result: " + result);
     } catch (ArithmeticException e) {
         System.out.println("Unchecked Exception Caught: " + e);
     } finally {
         System.out.println("Finally Block Executed in divide()");
     }
 }

 // Unchecked Exception Demonstration: NullPointerException
 public static void checkNull(String str) {
     try {
         System.out.println("String Length: " + str.length()); // NullPointerException if str is null
     } catch (NullPointerException e) {
         System.out.println("Unchecked Exception Caught: " + e);
     } finally {
         System.out.println("Finally Block Executed in checkNull()");
     }
 }

 // Checked Exception Demonstration: Throws Custom Exception
 public static void withdraw(double amount) throws InsufficientFundsException {
     double balance = 1000.00;
     if (amount > balance) {
         throw new InsufficientFundsException("Withdrawal amount exceeds balance!");
     }
     System.out.println("Withdrawal Successful! Remaining Balance: " + (balance - amount));
 }

 // Error Demonstration: StackOverflowError (Infinite Recursion)
 public static void causeStackOverflow(int num) {
     try {
         System.out.println(num);
         causeStackOverflow(num + 1); // Recursive Call (Never ends)
     } catch (StackOverflowError e) {
         System.out.println("Error Caught: " + e);
     }
 }

 // Error Demonstration: OutOfMemoryError (Creating Large Array)
 public static void causeOutOfMemory() {
     try {
         int[] largeArray = new int[Integer.MAX_VALUE]; // Too large for memory
     } catch (OutOfMemoryError e) {
         System.out.println("Error Caught: " + e);
     }
 }

}
