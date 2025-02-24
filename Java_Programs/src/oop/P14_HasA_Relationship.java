package oop;
/*
---

## What is a Has-A Relationship?  
A Has-A relationship in Java refers to composition or aggregation, where one class contains an instance 
of another class as a field instead of inheriting from it. 
This relationship is also known as "object containment".  

### Syntax:  
class ClassA {  
    ClassB objB;  // Has-A Relationship (Composition)
}

## Purpose of Has-A Relationship  
- Code Reusability: Allows a class to use functionalities of another class without directly inheriting from it.  
- Encapsulation: Keeps classes independent, reducing code complexity and improving maintainability.  
- Loose Coupling: Reduces dependencies between classes, making modifications easier without affecting the entire codebase.  
- Better Flexibility: Allows multiple objects to be used dynamically instead of enforcing a rigid hierarchy.  

## Why is Has-A Relationship Required?  
1. Avoids Inheritance Overuse:  
   - Inheritance creates a strict parent-child bond, which can lead to tightly coupled code.  
   - Composition allows more flexible relationships.  
   
2. Better Code Maintainability:  
   - Changes in the parent class in inheritance can affect all child classes.  
   - With Has-A, only the containing class needs modification, keeping other classes intact.  

3. Supports Real-World Modeling:  
   - Real-world entities often have composition relationships (e.g., A Car has an Engine, but a Car is not an Engine).  
   - This makes code more intuitive and natural.  

4. Solves Diamond Problem:  
   - Since Java does not support multiple inheritance, Has-A allows sharing behavior across classes without conflicts.  

## Why Use Has-A Instead of Inheritance?  
| Feature               | Inheritance (Is-A)               | Composition (Has-A)                   |
|-----------------------|----------------------------------|--------------------------------|
| Relationship Type     | Parent-Child (Strict Hierarchy)  | Object Containment (Flexible) |
| Code Reusability      | High but tightly coupled         | High and loosely coupled      |
| Modifications Impact  | Affects all child classes        | Affects only the containing class |
| Java Support          | Limited (No multiple inheritance for classes) | Fully supported |
| Real-world Example    | A Dog is an Animal               | A Car has an Engine |

## Conclusion  
- Has-A relationship (Composition) is preferred over Inheritance in cases where a class needs 
  to use another class's behavior without being forced into a strict hierarchy.  
- It improves modularity, reusability, and maintainability while avoiding issues like the diamond problem 
  in inheritance.
- Composition is more flexible and helps in designing scalable applications.   
    
---

# Real-World Use Cases of Composition (HAS-A Relationship)  

| Use Case                   | Description                    | Why Use HAS-A Relationship? |
|----------------------------|--------------------------------|--------------------------------|
| Car and Engine             | A `Car` class has an `Engine` object rather than inheriting from it, because different cars can have different engines. | To allow flexibility in engine selection without rigid inheritance. |
| Human and Heart            | A `Human` class has a `Heart` object rather than extending `Heart`, as a human is not a type of heart but contains one. | To maintain proper object relationships in the real world. |
| Company and Employee       | A `Company` class contains multiple `Employee` objects instead of inheriting from `Employee`, because a company is not an employee but has many employees. | To represent a real-world relationship more accurately. |
| Library and Books          | A `Library` class has a collection of `Book` objects, as a library is not a book but contains many books. | To model aggregation relationships effectively. |
| House and Rooms            | A `House` class contains multiple `Room` objects, rather than inheriting from `Room`, since a house consists of rooms but is not a type of room. | To improve modularity and scalability. |
| University and Departments | A `University` class has multiple `Department` objects rather than inheriting from `Department`, as a university consists of departments but is not one itself. | To properly model real-world entity relationships. |

---

## Why Prefer HAS-A Relationship Over Inheritance?  
| HAS-A Relationship (Composition)                                  | IS-A Relationship (Inheritance) |
|-------------------------------------------------------------------|--------------------------------------|
| Provides better flexibility and loose coupling.                   | Creates tight coupling between parent and child. |
| Allows reuse of functionality without modifying base classes.     | Child class inherits everything from the parent, even unnecessary methods. |
| Avoids problems like the diamond problem in multiple inheritance. | Can lead to complex hierarchies that are hard to maintain. |
| More modular, as changes in one class don’t affect others.        | Changes in the parent class directly affect all child classes. |

---
 

*/


/*
 Design a system where a BankAccount has an InterestCalculator. The InterestCalculator calculates 
 interest based on the type of account (Savings or Fixed Deposit) and the principal amount.
 */
public class P14_HasA_Relationship {

	public static void main(String[] args) {
	     // Creating interest calculator for Savings Account (5% interest)
	     InterestCalculator savingsInterest = new InterestCalculator(5.0);

	     // Creating a bank account with aggregation
	     BankAccount account = new BankAccount("Anirudha", 10000, savingsInterest);
	     
	     // Printing interest after 3 years
	     account.printInterest(3);

	}

}

//InterestCalculator class (Aggregation: BankAccount HAS-A InterestCalculator)
class InterestCalculator {
 private double rate;

 // Constructor to initialize interest rate
 public InterestCalculator(double rate) {
     this.rate = rate;
 }

 // Method to calculate simple interest
 public double calculateInterest(double principal, int years) {
     return (principal * rate * years) / 100;
 }
}

//BankAccount class (Aggregating InterestCalculator)
class BankAccount {
 private String accountHolder;
 private double balance;
 private InterestCalculator interestCalculator; // Aggregation

 // Constructor
 public BankAccount(String accountHolder, double balance, InterestCalculator interestCalculator) {
     this.accountHolder = accountHolder;
     this.balance = balance;
     this.interestCalculator = interestCalculator;
 }

 // Method to calculate and print interest
 public void printInterest(int years) {
     double interest = interestCalculator.calculateInterest(balance, years);
     System.out.println("Account Holder: " + accountHolder);
     System.out.println("Balance: $" + balance);
     System.out.println("Interest for " + years + " years: $" + interest);
 }
}
