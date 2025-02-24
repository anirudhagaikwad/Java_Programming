package oop;
/*

## Non-Access Modifiers in Java
Non-access modifiers in Java define additional properties of classes, methods, and variables. 
These modifiers affect the behavior, scope, and implementation of the code but do not control access 
permissions.

### Types of Non-Access Modifiers:

| Modifier       | Usage                   | Effect                                                           |
|----------------|-------------------------|------------------------------------------------------------------|
| `final`        | Class, Method, Variable | Prevents modification/inheritance, ensures constant values       |
| `static`       | Variable, Method        | Shared at class level, allocates fixed memory area               |
| `abstract`     | Class, Method           | Defines abstraction, forces method implementation in subclasses  |
| `synchronized` | Method, Block           | Ensures thread safety by allowing one thread at a time           |
| `volatile`     | Variable                | Ensures visibility in multithreading, prevents caching issues    |
| `transient`    | Variable                | Excludes field from serialization                                |
| `native`       | Method                  | Uses non-Java implementation                                     |

### final`
   – Prevents modification or inheritance.
   - Applied to variables: Makes the value constant.
   - Applied to methods: Prevents overriding.
   - Applied to classes: Prevents inheritance. 
---

Java provides several modifiers, use cases as follows:  

### 1. Class Level Modifiers
| Modifier     | Description   | Usage    |
|--------------|---------------|----------|
| `final`      | Prevents the class from being inherited. | `final class ClassName { }` |
| `abstract`   | Declares an abstract class that cannot be instantiated directly. | `abstract class ClassName { }` |
| `strictfp`   | Ensures floating-point operations follow IEEE 754 standards for consistency across platforms. | `strictfp class ClassName { }` |

---

### 2. Method Level Modifiers
| Modifier      | Description   | Usage |
|---------------|---------------|----------|
| `final`       | Prevents a method from being overridden. | `final void methodName() { }` |
| `static`      | Allows method to be called without creating an object. | `static void methodName() { }` |
| `abstract`    | Declares a method without implementation (must be in an abstract class). | `abstract void methodName();` |
| `synchronized`| Allows only one thread to execute the method at a time for thread safety. | `synchronized void methodName() { }` |
| `native`      | Indicates that the method is implemented in another language like C/C++. | `native void methodName();` |
| `strictfp`    | Ensures floating-point calculations follow IEEE 754 precision. | `strictfp void methodName() { }` |

---

### 3. Variable Level Modifiers
| Modifier      | Description   | Usage |
|---------------|---------------|----------|
| `final`       | Makes a variable constant (cannot be modified after assignment). | `final int MAX_VALUE = 100;` |
| `static`      | Declares a variable shared among all instances of a class. | `static int count = 0;` |
| `volatile`    | Ensures the value of a variable is always read from the main memory, preventing thread caching issues. | `volatile int flag;` |
| `transient`   | Prevents a variable from being serialized. | `transient int tempData;` |

---

### 4. Constructor Level Modifiers
| Modifier     | Description | Usage |
|--------------|---------------|----------|
| `private`    | Prevents object creation outside the class (used in Singleton design pattern). | `private ConstructorName() { }` |
| `public`     | Allows the constructor to be accessed from anywhere. | `public ConstructorName() { }` |
| `protected`  | Allows constructor to be accessed within package and subclasses. | `protected ConstructorName() { }` |
| `default`    | Allows access within the same package only. | `ConstructorName() { }` |

---

## Key Points
- `final` prevents modification (used for classes, methods, and variables).
- `static` allows sharing among instances (used for methods and variables).
- `abstract` enforces method implementation in subclasses.
- `synchronized` ensures thread safety in concurrent applications.
- `volatile` ensures visibility of changes across threads.
- `transient` prevents serialization of specific fields.
- `strictfp` ensures consistency in floating-point calculations.

 
*/
public class P17_NonAccessModifiers {

	public static void main(String[] args) {
		

	}

}
