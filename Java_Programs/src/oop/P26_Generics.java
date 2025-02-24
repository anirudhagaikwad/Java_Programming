package oop;
/*
 ## 1. Introduction to Java Generics  
Java Generics is a powerful feature introduced in Java 5 that allows the creation of classes, 
interfaces, and methods with type parameters. 
This enables type safety, code reusability, and compile-time checking while working with 
different data types without writing multiple versions of the same code.

### Why Generics?
Before generics, Java used raw types (like `ArrayList` without `<T>`), leading to:
- Typecasting Issues – Manual typecasting was required.
- Runtime Errors – Type mismatches were not caught at compile-time.
- Code Duplication – Separate code was needed for different data types.

Generics solve these problems by allowing parameterized types, ensuring type safety and reusability.

---

## 2. Advantages of Generics
1. Type Safety – Ensures that only specific types are used, preventing `ClassCastException`.
2. Compile-Time Checking – Detects errors at compile time instead of runtime.
3. Code Reusability – Enables writing generic classes, interfaces, and methods that work with any type.
4. Eliminates Typecasting – Removes the need for explicit type conversions.

---

## 3. Generic Types
Java allows the creation of generic classes, interfaces, and methods using type parameters. These type parameters are defined inside angle brackets (`<>`).

### Commonly Used Type Parameters
| Symbol | Meaning |
|--------|---------|
| `T`    | Type (any class or interface) |
| `E`    | Element (used in collections) |
| `K`    | Key (used in key-value pairs) |
| `V`    | Value (used in key-value pairs) |
| `N`    | Number (numeric types) |

You can use multiple type parameters like `<T, U, V>`, allowing more flexibility.

---

## 4. Generic Classes
A generic class allows defining a class with parameterized types, meaning it can work with multiple 
data types while maintaining type safety.

### Example Structure 
A generic class `<T>` is defined with a placeholder type that gets replaced when an object is instantiated. 
This avoids using raw types and ensures type safety.

---

## 5. Generic Interfaces
Just like generic classes, interfaces can also be parameterized with type variables.

### Key Points
- Used in frameworks, functional interfaces, and collections.
- When implemented, the implementing class must define the actual type.

---

## 6. Generic Methods
A method can be declared with its own type parameter, independent of the class's generic type.

### Key Features
- Type parameter appears before the return type in method signatures.
- The method can work with different data types without affecting the class definition.
- Can be used in both generic and non-generic classes.

---

## 7. Bounded Type Parameters
Generics can be restricted to certain types using the `extends` keyword.

### Types of Bounds
1. Upper Bounded (`<T extends Class>`)  
   - Restricts `T` to a specific superclass or interface.
   - Allows using methods defined in the bounded class/interface.

2. Lower Bounded (`<T super Class>`)  
   - Restricts `T` to be a superclass of a specific type.
   - Useful for writing flexible methods that can accept multiple types in an inheritance hierarchy.

---

## 8. Wildcards in Generics (`?`)
Wildcards (`?`) allow flexibility when working with generics. They represent an unknown type.

### Types of Wildcards
| Wildcard | Meaning |
|----------|---------|
| `<?>`    | Unbounded wildcard (any type) |
| `<? extends T>` | Upper bounded wildcard (T and its subclasses) |
| `<? super T>` | Lower bounded wildcard (T and its superclasses) |

Use Cases:
- Upper Bounded (`? extends T`) – Reading objects safely.
- Lower Bounded (`? super T`) – Writing objects safely.
- Unbounded (`<?>`) – Accepts any type.

---

## 9. Type Erasure in Generics
Generics are only present at compile-time and are removed during runtime due to type erasure. 
This ensures backward compatibility with older Java versions.

### Effects of Type Erasure
1. Type parameters are replaced with their bounds (or `Object` if unbounded).
2. Bytecode contains only raw types.
3. Cannot use generics with primitive types (`int`, `double`, etc.).
4. Cannot create an instance of a type parameter (`new T()`).
5. Cannot check the exact type parameter with `instanceof`.

---

## 10. Restrictions and Limitations of Generics
1. Cannot Use Primitive Types (`int`, `char`, etc.)  
   - Must use wrapper classes (`Integer`, `Double`, etc.).
2. Cannot Create Generic Arrays  
   - Arrays rely on runtime type checking, which generics remove.
3. Cannot Instantiate Generic Type (`new T()`)  
   - Type information is erased at runtime.
4. Cannot Use `instanceof` with Generics (`obj instanceof T`)  
   - Since type parameters do not exist at runtime.
5. Static Fields Cannot Use Generic Types  
   - Since generics are resolved at the instance level.

---

## 11. Generic Collections in Java
Java Collections Framework heavily uses generics for type safety.

| Collection | Description |
|------------|-------------|
| `ArrayList<T>` | Resizable array |
| `LinkedList<T>` | Doubly-linked list |
| `HashSet<T>` | Unordered set of unique elements |
| `HashMap<K, V>` | Key-value pair storage |
| `TreeSet<T>` | Sorted set of elements |

---

## 12. Generics and Inheritance
- Generic classes can be subclassed.
- A subclass can be generic or non-generic.
- A generic subclass can specify new type parameters or use inherited ones.
- Covariance & Contravariance in Generics  
  - Generics do not support polymorphism in the same way as normal inheritance.

---

## 13. Best Practices for Using Generics
1. Use Generics for Type Safety – Avoid raw types.
2. Prefer Bounded Type Parameters – If applicable, restrict with `extends`.
3. Use Wildcards for Flexibility – Apply `? extends` for reading and `? super` for writing.
4. Minimize Type Erasure Issues – Avoid generic array creation.
5. Use Generic Methods for Code Reusability – Instead of duplicating logic.
6. Avoid Excessive Nesting of Generics – Keep code readable.

---

## 14. Generics in Java vs. C++ Templates
While both Java Generics and C++ Templates provide type parameterization, there are key differences:

| Feature | Java Generics | C++ Templates |
|---------|-------------|--------------|
| Type Information at Runtime | Removed (Type Erasure) | Retained (Templates Instantiated) |
| Primitive Types | Not Allowed | Allowed |
| Code Duplication | No | Yes (Each type instantiates separately) |
| `instanceof` with Type Parameter | Not Allowed | Allowed |
| Reflection with Generics | Limited | Full |

---

## 15. Summary
- Java Generics enable type safety, reusability, and compile-time checking.
- They eliminate the need for typecasting, reducing runtime errors.
- Bounded type parameters (`extends`, `super`) restrict types for more control.
- Wildcards (`?`, `? extends T`, `? super T`) improve flexibility.
- Type erasure removes type parameters at runtime for compatibility.
- Generics are widely used in Java Collections, interfaces, and methods.
- Best practices include avoiding raw types, using proper bounds, and limiting complexity.

---

*/
//Generic Interface with Type Parameter
interface GenericInterface<T> {
 void display(T value);
}

//Generic Class
class GenericClass<T> implements GenericInterface<T> {
 private T data; // Generic variable

 // Constructor
 public GenericClass(T data) {
     this.data = data;
 }

 // Getter method
 public T getData() {
     return data;
 }

 // Implementing method from GenericInterface
 @Override
 public void display(T value) {
     System.out.println("Displaying: " + value);
 }
}

//Generic Method Example
class GenericMethods {
 // Generic method to print any type of array
 public static <T> void printArray(T[] array) {
     for (T item : array) {
         System.out.print(item + " ");
     }
     System.out.println();
 }
}

//Demonstrating Bounded Type Parameters (Upper Bound)
class UpperBoundExample<T extends Number> { // T must be a Number or subclass of Number
 private T num;

 public UpperBoundExample(T num) {
     this.num = num;
 }

 // Method that works only with Number or its subtypes
 public void square() {
     System.out.println("Square: " + (num.doubleValue() * num.doubleValue()));
 }
}

//Demonstrating Wildcards
class WildcardExample {
 // Method to print elements of an array using wildcard
 public static void printArrayWildcard(Object[] array) {
     for (Object obj : array) {
         System.out.print(obj + " ");
     }
     System.out.println();
 }
}

//Main Class
public class P26_Generics {
 public static void main(String[] args) {
     // Example of Generic Class
     GenericClass<String> stringInstance = new GenericClass<>("Hello Generics");
     System.out.println("Generic Class Data: " + stringInstance.getData());
     stringInstance.display("This is a string");

     GenericClass<Integer> integerInstance = new GenericClass<>(100);
     System.out.println("Generic Class Data: " + integerInstance.getData());
     integerInstance.display(200);

     // Example of Generic Method
     Integer[] intArray = {1, 2, 3, 4, 5};
     String[] strArray = {"A", "B", "C"};
     System.out.println("Printing Integer Array:");
     GenericMethods.printArray(intArray);
     System.out.println("Printing String Array:");
     GenericMethods.printArray(strArray);

     // Example of Upper Bounded Type
     UpperBoundExample<Double> doubleExample = new UpperBoundExample<>(5.5);
     doubleExample.square();

     UpperBoundExample<Integer> intExample = new UpperBoundExample<>(10);
     intExample.square();

     // Example of Wildcards with Arrays
     System.out.println("Printing Array using Wildcard:");
     WildcardExample.printArrayWildcard(new String[]{"X", "Y", "Z"});
     WildcardExample.printArrayWildcard(new Integer[]{10, 20, 30});
 }
}

