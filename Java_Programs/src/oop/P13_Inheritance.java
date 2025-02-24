package oop;
/*
## What is Inheritance?  
Inheritance is one of the core concepts of Object-Oriented Programming (OOP) in Java. 
It allows one class (child or subclass) to inherit properties (fields) and behaviors (methods) from another 
class (parent or superclass). This promotes code reusability, maintainability, and hierarchical classification.

### Purpose of Inheritance
- Code Reusability – Reduces redundant code by allowing subclasses to use parent class methods and properties.  
- Method Overriding – Enables modification of inherited methods to provide a specific implementation.  
- Extensibility – Enhances modularity by allowing existing functionality to be extended without modifying existing code.  
- Improved Maintainability – Changes made in the parent class automatically apply to all subclasses.  

---

## Types of Inheritance in Java  
Java supports three types of inheritance through classes, but does not support multiple and hybrid inheritance with classes
to avoid the diamond problem. However, multiple inheritance can be achieved using interfaces.

| Type                     | Description                                   |
|--------------------------|-----------------------------------------------|
| Single Inheritance       | One class inherits from another class (A → B) |
| Multilevel Inheritance   | A class inherits from another class, which itself is inherited from another class (A → B → C) |
| Hierarchical Inheritance | A single parent class is inherited by multiple child classes (A → B, A → C) |
| Multiple Inheritance (Not Supported with Classes, Only with Interfaces) | A child class inherits from multiple parent classes (A, B → C) using interfaces |
| Hybrid Inheritance (Not Supported with Classes, Only with Interfaces) | A combination of two or more inheritance types achieved using interfaces |

---

## Meaning of Different Types of Inheritance  

### Single Inheritance  
- Meaning: A single child class inherits from a single parent class.  
- Use Case: When a subclass needs to extend the behavior of a single superclass.  

### Multilevel Inheritance  
- Meaning: A subclass acts as a parent for another subclass.  
- Use Case: When extending multiple levels of a class hierarchy (e.g., Grandparent → Parent → Child).  

### Hierarchical Inheritance  
- Meaning: Multiple child classes inherit from a single parent class.  
- Use Case: When multiple classes need the same base functionality.  

### Multiple Inheritance (Not Supported with Classes, Only with Interfaces)  
- Meaning: A class inherits from multiple interfaces (Java does not support this directly with classes).  
- Reason for Not Supporting in Classes: It leads to ambiguity (Diamond Problem).  
- Solution: Java uses interfaces to achieve multiple inheritance.  

### Hybrid Inheritance (Not Supported with Classes, Only with Interfaces)  
- Meaning: Combination of two or more types of inheritance (e.g., multiple + multilevel) achieved using interfaces.  
- Reason for Not Supporting in Classes: Complexity and ambiguity in method resolution.  

---

### Diamond Problem in Java Inheritance  

The Diamond Problem in Java occurs when a class inherits from two classes that have a common superclass,
leading to ambiguity in method resolution.  

#### Why does the Diamond Problem occur?  
If Java allowed multiple inheritance through classes, a subclass would inherit methods from two parent classes
that both inherit from a common superclass. If both parents override the same method differently, 
Java wouldn't know which version to use in the subclass, creating a conflict.  

#### Example Structure of the Diamond Problem  

    A
   / \
  B   C
   \ /
    D

- `B` and `C` inherit from `A` and override a method.
- `D` inherits from both `B` and `C`, leading to ambiguity: Which method from `B` or `C` should `D` inherit?  

#### How Java Avoids the Diamond Problem  
Java does not support multiple inheritance through classes to avoid this issue. Instead, Java allows multiple 
inheritance through interfaces because interfaces do not contain implementation, reducing ambiguity.  

#### Solution: Using Interfaces  
Instead of classes, Java allows multiple inheritance through interfaces where a class can implement multiple 
interfaces without conflict. If two interfaces have the same default method, the implementing class must 
override it to resolve ambiguity.  

---

## Why Not Use Inheritance in Some Cases?  

### Increased Coupling  
- Subclasses become tightly coupled with the parent class.  
- If a parent class changes, it may break subclasses.  

### Diamond Problem in Multiple Inheritance  
- Java does not support multiple inheritance using classes because of the diamond problem, 
where a child class inherits from two parent classes that have the same method.  
- Solution: Java uses interfaces instead.  

### Performance Overhead  
- Using inheritance increases memory usage as objects carry unused parent class methods and fields.  

### Reduced Flexibility  
- Inheritance forces an IS-A relationship, which might not always be suitable.  
- Composition (HAS-A relationship) is preferred when a flexible design is needed.  

---

## 5. Which Two Keywords are Used for Inheritance?  

1. `extends` Keyword  
- Used to inherit a class.  
- Use Case: Single, multilevel, and hierarchical inheritance.  

2. `implements` Keyword  
- Used to inherit an interface.  
- Use Case: Supports multiple inheritance via interfaces.  

---


# Real-World Use Cases of Inheritance (IS-A Relationship)  

| Use Case                     | Description | Why Use Inheritance? |
|------------------------------|----------------|----------------------------|
| Banking System               | `BankAccount` is the parent class with common methods like `deposit()`, `withdraw()`, and `getBalance()`, while `SavingsAccount` and `CurrentAccount` extend it. | To reuse common behavior across different account types. |
| Employee Management System   | `Employee` is a parent class with attributes like `name`, `salary`, and `designation`, while `Manager` and `Developer` extend it with additional functionalities. | To avoid redundant code and promote reusability. |
| Vehicle System               | `Vehicle` is a parent class with methods like `startEngine()`, `stopEngine()`, and `move()`, while `Car` and `Bike` inherit and implement specific details. | To define common vehicle behavior and ensure consistency. |
| E-commerce System            | `Product` is a base class, and `Electronics`, `Clothing`, and `Books` are subclasses with specific properties like `warranty`, `size`, or `author`. | To provide a general structure while allowing specialization. |
| Gaming System                | `GameCharacter` is a parent class, while `Warrior` and `Mage` inherit it and provide unique abilities. | To ensure all characters share common attributes but have different skills. |
| UI Component System          | `UIComponent` is a parent class with methods like `render()` and `onClick()`, while `Button`, `TextBox`, and `Checkbox` extend it. | To maintain a uniform design and behavior for UI elements. |

---

---

# super Keyword in Java  

## What is `super` Keyword?  
The `super` keyword in Java is a reference variable used to refer to the immediate parent class object. 
It is primarily used in inheritance to access the parent class's methods, constructors, or variables.  

---

## Purpose of `super` Keyword  

| Usage                          | Description                            |
|--------------------------------|----------------------------------------|
| Access Parent Class Methods    | Calls the parent class's method when overridden in the child class. |
| Access Parent Class Variables  | Refers to the parent class's instance variables if they are hidden by child class variables. |
| Invoke Parent Class Constructor| Calls the parent class's constructor from the child class. |

---

## Types of `super` Keyword Usage  

### 1. Accessing Parent Class Methods  
- When a method is overridden in a subclass, `super` can be used to call the parent class method explicitly.  

Syntax:  

super.methodName();


---

### 2. Accessing Parent Class Variables  
- If a subclass declares a variable with the same name as in the parent class, `super` can be used to differentiate between them.  

Syntax:  

super.variableName;


---

### 3. Calling Parent Class Constructor  
- `super()` is used to invoke the constructor of the parent class from the subclass constructor.  
- It must be the first statement in the child class constructor.  

Syntax:  

super();

or  

super(parameters);


---

## Why Use `super` Instead of `this`?  

| Keyword    | Purpose                                      |
|------------|----------------------------------------------|
| `this`     | Refers to the current class instance (variables, methods, constructor). |
| `super`    | Refers to the parent class instance (variables, methods, constructor). |

---

## Where and Why Use `super`?  
- When a child class needs to call a method from the parent class that has been overridden.  
- When a child class has a variable name that matches the parent class variable name, and differentiation is needed.  
- When a child class constructor must call the parent class constructor to initialize superclass properties.  


## Conclusion  
- `super` helps in accessing parent class members when they are overridden, hidden, or need explicit initialization.  
- It is only applicable in inheritance and improves code clarity and reusability.  

---

### Method Overriding in Java  

## What is Method Overriding?  
Method Overriding occurs when a subclass provides a specific implementation of a method that is already defined in its parent class. The method in the subclass must have the same name, return type, and parameters as the method in the superclass. This is an example of runtime polymorphism in Java.  

### Key Rules for Method Overriding  
- Method name, return type, and parameters must be the same as in the parent class.  
- The overridden method in the subclass must have the same access level or a more accessible modifier 
  (e.g., `protected` in the parent class cannot be `private` in the child class).  
- The method cannot be overridden if it is declared as `final`, `static`, or `private`.  
- Overriding occurs only with instance methods, not with static methods.  
- The subclass method should not throw a broader exception than the superclass method.  

---

## Why Use Method Overriding?  
| Advantage                           | Description                                                        |
|-------------------------------------|--------------------------------------------------------------------|
| Achieves Runtime Polymorphism       | Allows a subclass to provide its own implementation of a method at runtime. |
| Improves Code Maintainability       | Allows modification of behavior without changing the parent class. |
| Provides Specific Implementation    | Allows customization of inherited methods for specific use cases. |
| Supports Object-Oriented Principles | Helps in implementing abstraction and encapsulation in Java. |

---

## Real-World Use Cases of Method Overriding  

| Use Case                | Description                    |
|-------------------------|--------------------------------|
| GUI Frameworks          | `paint()` in different UI components can be overridden to provide specific rendering. |
| Banking Systems         | `calculateInterest()` in different account types (Savings, FixedDeposit, etc.). |
| E-commerce Applications | `processPayment()` overridden in different payment gateways (PayPal, CreditCard, etc.). |
| Database Connectivity   | `connectDatabase()` for different databases (MySQL, PostgreSQL, etc.). |
| Web Frameworks          | `handleRequest()` method overridden in different controllers for API handling. |
| Game Development        | `attack()` method overridden in different character classes (Warrior, Mage, Archer, etc.). |

---

## Conclusion  
- Method Overriding allows a subclass to provide a customized version of a method defined in a superclass.  
- It is a key feature of runtime polymorphism, enabling flexible and maintainable code.  
- It is widely used in real-world applications such as banking, e-commerce, game development, and UI frameworks.  

---

*/

/*
Problem Statement:
Create a Shape Calculation System where different types of shapes (Circle, Rectangle, Sphere, and Cuboid) 
inherit from a common Shape class and override methods to calculate their area and surface area.
 */
public class P13_Inheritance {

	public static void main(String[] args) {
		Shape circle = new Circle(5);
	     Shape rectangle = new Rectangle(4, 6);
	     Shape sphere = new Sphere(3);
	     Shape cuboid = new Cuboid(3, 4, 5);

	     // Displaying results
	     System.out.println("Circle: Area = " + circle.area() + ", Surface Area = " + circle.surfaceArea());
	     System.out.println("Rectangle: Area = " + rectangle.area() + ", Surface Area = " + rectangle.surfaceArea());
	     System.out.println("Sphere: Area = " + sphere.area() + ", Surface Area = " + sphere.surfaceArea());
	     System.out.println("Cuboid: Area = " + cuboid.area() + ", Surface Area = " + cuboid.surfaceArea());

	}

}

//Base class: Shape
abstract class Shape {
 abstract double area();         // Method to calculate area
 abstract double surfaceArea();  // Method to calculate surface area
}

//Single Inheritance: Circle -> Shape
class Circle extends Shape {
 double radius;

 // Constructor
 Circle(double radius) {
     this.radius = radius;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return Math.PI * radius * radius;  // πr²
 }

 @Override
 double surfaceArea() {
     return 2 * Math.PI * radius * radius;  // 2πr²
 }
}

//Single Inheritance: Rectangle -> Shape
class Rectangle extends Shape {
 double length, width;

 // Constructor
 Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return length * width;  // l × w
 }

 @Override
 double surfaceArea() {
     return 2 * (length * width);  // 2(l × w) (for a flat shape)
 }
}

//Multilevel Inheritance: Sphere -> Circle -> Shape
class Sphere extends Circle {
 // Constructor
 Sphere(double radius) {
     super(radius);
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return 4 * Math.PI * radius * radius;  // 4πr² (Sphere surface area)
 }

 @Override
 double surfaceArea() {
     return area();  // Sphere surface area is the same as area
 }
}

//Multilevel Inheritance: Cuboid -> Rectangle -> Shape
class Cuboid extends Rectangle {
 double height;

 // Constructor
 Cuboid(double length, double width, double height) {
     super(length, width);
     this.height = height;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return length * width * height;  // Volume (l × w × h)
 }

 @Override
 double surfaceArea() {
     return 2 * (length * width + width * height + height * length);  // 2(lw + wh + hl)
 }
}



