package oop;
/*
# 1. Variables in Java  

### What is a Variable?  
A variable in Java is a named memory location that holds a value. 
It acts as a container that stores data, which can be modified during program execution.

### Types of Variables in Java
Java has three types of variables:

| Variable Type     | Scope & Lifetime                                                                   | Memory Location            | Default Value                                  | Example                            |
|-------------------|------------------------------------------------------------------------------------|----------------------------|------------------------------------------------|-----------------------------------|
| Local Variable    | Declared inside a method, constructor, or block; exists only within that block     | Stack Memory               | No default value (must be initialized)         | `int age = 25;` (inside a method) |
| Instance Variable | Declared inside a class but outside any method; belongs to an object               | Heap Memory                | Default values assigned (`0`, `null`, `false`) | `String name;` (inside a class)   |
| Static Variable   | Declared using `static` keyword inside a class; shared by all objects of the class | Method Area (Class Memory) | Default values assigned                        | `static int count = 0;`           |

### Note on Static Variables:
Static variables have a fixed memory location in the Method Area and are shared among all instances of the class.
They are initialized only once when the class is loaded, 
unlike instance variables that are allocated separately for each object.

### Why is an Instance Variable Called an Object Variable?
Instance variables are associated with an object, meaning each object has its own copy.
Unlike static variables, instance variables are stored in the Heap Memory and are created when an object is instantiated.
Since they belong to an instance (object) rather than the class itself, they are also called object variables.

---

# 2. Methods in Java  

### What is a Method?  
A method in Java is a block of code that performs a specific task. 
It is used to organize code, reuse logic, and improve readability.

### Types of Methods in Java
Java has different types of methods:

| Method Type         | Description                                                                         |
|---------------------|-------------------------------------------------------------------------------------|
| Predefined Method   | Built-in methods provided by Java (e.g., `System.out.println()`, `Math.sqrt()`)     |
| User-Defined Method | Methods created by programmers for custom logic                                     |
| Static Method       | A method declared with `static` keyword, can be called without creating an object   |
| Instance Method     | A method that belongs to an object and can access instance variables                |
| Abstract Method     | A method without a body, defined using `abstract` keyword, used in abstract classes |
| Final Method        | A method declared with `final` keyword, cannot be overridden                        |
| Synchronized Method | A method used in multithreading to allow only one thread at a time                  |

---

### Key Differences: Local, Instance, and Static Variables in Methods
| Feature | Local Variable | Instance Variable | Static Variable |
|---------|---------------|------------------|----------------|
| Scope | Within the method/block | Throughout the object | Throughout the class |
| Memory Location | Stack Memory | Heap Memory | Method Area |
| Default Value | No default value | Default values assigned | Default values assigned |
| Access Modifier | Cannot have access modifiers | Can have access modifiers | Can have access modifiers |
| Example | `int x = 10;` inside a method | `int x;` inside a class | `static int x = 10;` inside a class |

---
### Method Overloading in Java 

## What is Method Overloading?  
Method Overloading in Java allows multiple methods in the same class to have the same name 
but different parameters (different type, number, or order of parameters). 
It is a type of compile-time polymorphism that helps improve code readability and reusability.  

### Key Rules for Method Overloading  
- Methods must have the same name but different parameter lists.  
- Return type can be different, but it does NOT distinguish overloaded methods.  
- Methods can have different data types, sequence, or number of parameters.  
- Method Overloading cannot be done by changing only the return type.  

---

## Why Use Method Overloading?  
| Advantage                 | Description                                                             |
|---------------------------|-------------------------------------------------------------------------|
| Code Reusability          | Avoids writing multiple methods with different names for similar tasks. |
| Improves Readability      | Methods with the same purpose remain under a single name.               |
| Better Maintainability    | Modifications require changes in one place, making code easier to manage. |
| Compile-time Polymorphism | Provides flexibility by allowing different method implementations with the same name. |
| Enhances Performance      | Reduces method calls and enhances performance in some cases.            |

---

## Real-World Use Cases of Method Overloading  

| Use Case                 | Description                              |
|--------------------------|------------------------------------------|
| Mathematical Operations  | `add(int, int)`, `add(double, double)`, and `add(String, String)` allow calculations with different data types. |
| String Manipulation      | `substring(int start)`, `substring(int start, int end)` allow retrieving parts of a string. |
| File Handling            | `readFile(String path)`, `readFile(String path, boolean readAsText)` provide different ways to read files. |
| Database Operations      | `query(String sql)`, `query(String sql, int limit)`, `query(String sql, int limit, String sortBy)`, providing flexibility in fetching records. |
| Logging Systems          | `log(String message)`, `log(String message, int severity)`, `log(String message, String category)`, allowing logging with different parameters. |
| User Input Handling      | `getInput(int type)`, `getInput(String prompt)`, enabling multiple input mechanisms. |

---

## Conclusion  
- Method Overloading helps make code more efficient and user-friendly by allowing multiple methods with the same name but different behaviors.  
- It is widely used in Java libraries, frameworks, and real-world applications such as I/O operations, mathematical computations, and logging mechanisms.  
- It provides compile-time polymorphism, making code flexible and maintainable.  


*/
public class P4_Variable_Methods {

	  int instanceVar = 10; // Instance Variable
	  static int staticVar = 20; // Static Variable

	    void show() {
	        int localVar = 30; // Local Variable
	        System.out.println("Local Variable: " + localVar);
	        System.out.println("Instance Variable: " + instanceVar);
	        System.out.println("Static Variable: " + staticVar);
	    } 
	    
	public static void main(String[] args) {
		P4_Variable_Methods obj=new P4_Variable_Methods(); // Creating Object
		obj.show(); // Calling instance method
        obj.greet(); // Calling instance method
        showMessage(); // Calling static method
        int result = obj.add(5, 10); // Calling method with parameters
        System.out.println("Sum: " + result);
	}
	
	// Instance Method
    void greet() {
        System.out.println("Hello, welcome to Java!");
    }

    // Static Method
    static void showMessage() {
        System.out.println("This is a static method.");
    }

    // Method with Parameters and Return Type
    int add(int a, int b) {
        return a + b;
    }

}
