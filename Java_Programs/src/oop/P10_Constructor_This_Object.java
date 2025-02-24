package oop;
/*

## What is a Constructor?  
A constructor is a special method in Java that is used to initialize objects. 
It is called automatically when an object is created.  

### Key Points:  
- A constructor must have the same name as the class.  
- It does not have a return type (not even `void`).  
- It allocates memory for an object and initializes instance variables.  
- Constructors can be overloaded to allow different ways of object initialization.  

---

## Types of Constructors in Java  

### Default Constructor  
A default constructor is a constructor with no parameters.  

### Parameterized Constructor  
A parameterized constructor takes arguments to initialize instance variables with specific values.  

## Constructor Overloading  
Constructor overloading means defining multiple constructors with different parameter lists in the same class.  

## 6. Purpose of a Constructor  

| Feature | Description |
|------------------------|----------------------------------------------------------------------|
| Automatic Execution    | Called automatically when an object is created.                      |
| Memory Allocation      | Allocates memory for the object in the heap.                         |
| Object Initialization  | Assigns default or user-defined values to instance variables.        |
| Encapsulation          | Ensures proper data initialization and hiding implementation details.|
| Code Reusability       | Overloading allows different ways to initialize objects.             |


## `this` Keyword in Java  
The `this` keyword refers to the current object of the class.  

### Where & Why is `this` Used?  

| Usage                                     | Purpose                                                                         |
|-------------------------------------------|---------------------------------------------------------------------------------|
| Referring to Instance Variables           | Differentiates between instance and local variables if they have the same name. |
| Calling Another Constructor               | Uses `this()` to call another constructor in the same class.                    |
| Returning the Current Object              | Used to return the current object in methods.                                   |
| Passing the Current Object as a Parameter | Passes the current object reference to another method or constructor.           |

#### Syntax:  
this.variableName;      // Referring to instance variable
this.methodName();      // Calling another method in the same class
this();                // Calling another constructor
return this;           // Returning current object

---

## What is an Object in Java?  
An object in Java is an instance of a class that has:  
1. State (Attributes/Fields) – Represented by variables.  
2. Behavior (Methods/Functions) – Represented by functions defined in the class.  
3. Identity (Unique Memory Address) – Each object has a unique reference in memory.  

Java is an object-oriented programming (OOP) language, meaning that everything revolves around objects.  

---

## Why Use Objects in Java?  
- Encapsulation – Bundles data and behavior together.  
- Code Reusability – Reuse existing functionality by creating multiple instances.  
- Modularity – Divides large programs into manageable components.  
- Data Manipulation – Stores and processes real-world entities efficiently.  

---

## How to Create an Object in Java?  
There are five main ways to create an object in Java:  

| Method                                   | Description |
|------------------------------------------|----------------|
| Using `new` keyword                      | The most common way to create an object. |
| Using `Class.newInstance()` (Reflection) | Creates an object dynamically using reflection. |
| Using `clone()` method                   | Creates a duplicate (shallow copy) of an existing object. |
| Using Deserialization                    | Restores an object from a saved state (file/stream). |
| Using Factory Methods                    | Returns an object from a method instead of direct instantiation. |

---

## 1. Creating an Object Using `new` Keyword (Most Common Way)  
- The `new` keyword is the most widely used method to create an object.  
- It allocates memory in the heap for the object.  
- The constructor initializes the object.  

Syntax:  

ClassName obj = new ClassName(); 


---

## 2. Creating an Object Using `Class.newInstance()` (Reflection API)
- Uses Reflection to create objects dynamically.  
- `newInstance()` method invokes the default constructor.  
- Disadvantage: It requires handling exceptions (`InstantiationException`, `IllegalAccessException`).  

Syntax:  

ClassName obj = Class.forName("ClassName").newInstance();


---

## 3. Creating an Object Using `clone()` Method  
- Creates a duplicate object of an existing object.  
- Uses shallow copying by default.  
- The class must implement `Cloneable` interface.  

Syntax:  

ClassName obj2 = (ClassName) obj1.clone();


---

## 4. Creating an Object Using Deserialization  
- Deserialization is the process of converting a saved object (byte stream) back into an object.  
- Used in file handling, networking, and caching.  

Syntax:  

ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
ClassName obj = (ClassName) in.readObject();


---

## 5. Creating an Object Using Factory Methods  
- A static method inside a class returns an object instead of direct instantiation.  
- Used in design patterns like Singleton, Factory Pattern.  

Syntax:  

ClassName obj = ClassName.createObject();


---

## Comparison of Object Creation Methods  

| Method                      | Heap Memory Allocation | Use Case |
|-----------------------------|------------------------|--------------|
| `new` keyword               | Yes                    | Regular object creation |
| `Class.newInstance()`       | Yes                    | Dynamic class loading (Reflection) |
| `clone()`                   | Yes                    | Object duplication |
| Deserialization             | Yes                    | Restoring objects from files |
| Factory Method              | Yes                    | Singleton, Factory Design Pattern |

---

## Key Takeaways
✔ Objects are instances of classes that store state and behavior.  
✔ Most common way to create an object is using the `new` keyword.  
✔ Other methods (`Reflection`, `clone()`, `Deserialization`, `Factory Pattern`) are used for special cases.  
✔ Objects are stored in heap memory, and references are stored in stack memory.  

*/

//P10_Constructor_This class demonstrating constructors and 'this' keyword usage
public class P10_Constructor_This_Object {
	    double radius;
	    // 🔹 Default Constructor - Initializes radius to 1.0
	    P10_Constructor_This_Object() {
	        this(1.0); // Calls parameterized constructor
	        System.out.println("Default Constructor Called: Radius = " + this.radius);
	    }

	    // 🔹 Parameterized Constructor - Initializes radius to given value
	    P10_Constructor_This_Object(double radius) {
	        this.radius = radius; // Using 'this' to refer to instance variable
	        System.out.println("Parameterized Constructor Called: Radius = " + this.radius);
	    }

	    // 🔹 Copy Constructor - Creates a new object using another Circle object
	    P10_Constructor_This_Object(P10_Constructor_This_Object otherCircle) {
	        this(otherCircle.radius); // Calls parameterized constructor
	        System.out.println("Copy Constructor Called: Radius = " + this.radius);
	    }

	    // 🏁 Method to calculate and return area of the circle
	    double calculateArea() {
	        return Math.PI * this.radius * this.radius; // Using 'this' for clarity
	    }

	    // 🏁 Method to calculate and return circumference of the circle
	    double calculateCircumference() {
	        return 2 * Math.PI * this.radius;
	    }

	    // 📢 Display method demonstrating 'this' keyword calling another method
	    void showDetails() {
	        System.out.println("🔵 Circle with Radius: " + this.radius);
	        System.out.println("📐 Area: " + this.calculateArea());
	        System.out.println("📏 Circumference: " + this.calculateCircumference());
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // 🚀 Using Default Constructor
	        P10_Constructor_This_Object c1 = new P10_Constructor_This_Object();
	        c1.showDetails();

	        // 🚀 Using Parameterized Constructor
	        P10_Constructor_This_Object c2 = new P10_Constructor_This_Object(5.0);
	        c2.showDetails();

	        // 🚀 Using Copy Constructor
	        P10_Constructor_This_Object c3 = new P10_Constructor_This_Object(c2);
	        c3.showDetails();
	    }
	}

