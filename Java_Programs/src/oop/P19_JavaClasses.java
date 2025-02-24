package oop;
/*
# Java Classes – Detailed Notes  

## What is a Class in Java?  
A class in Java is a blueprint or template for creating objects. 
It defines attributes (fields/variables) and behaviors (methods/functions) that its objects will have.  

In Java, everything revolves around classes and objects since it is an object-oriented programming (OOP) language.  

---

## Why Use Classes?
1. Encapsulation – Helps bind data and methods together.  
2. Code Reusability – Once defined, a class can be reused multiple times.  
3. Modularity – Classes make the code more organized and maintainable.  
4. Inheritance – One class can inherit properties from another, promoting code reuse.  
5. Abstraction – A class can hide unnecessary implementation details from the user.  

---

## Types of Classes in Java  
Java supports different types of classes, each serving a unique purpose.

| Class Type                   | Description |
|------------------------------|----------------|
| Concrete Class               | A regular class that has both method implementations and variables. |
| Abstract Class               | A class that cannot be instantiated but can be subclassed. It may have both abstract (unimplemented) and concrete methods. |
| Final Class                  | A class that cannot be extended (inherited) by any other class. |
| Static Class                 | A class declared inside another class with the `static` keyword. It cannot access non-static members of the outer class. |
| Inner Class                  | A class defined inside another class. It has access to the members of the outer class. |
| Anonymous Class              | A class that has no name and is used to instantiate an object of an interface or an abstract class. |
| POJO (Plain Old Java Object) | A simple Java class that contains only private fields, public getter/setter methods, and no business logic. |
| Bean Class                   | A specialized POJO with additional rules, such as a no-argument constructor and serializability. |
| Record Class (Since Java 14) | A special class that automatically generates getter methods, `toString()`, `equals()`, and `hashCode()`. |

---

## Detailed Explanation of Each Type  

### 1. Concrete Class  
- A standard class with fully implemented methods.
- Can be instantiated using the `new` keyword.
- Can inherit other classes and implement interfaces.

### 2. Abstract Class  
- Declared with the `abstract` keyword.
- Cannot be instantiated directly.
- Can have both implemented and abstract (unimplemented) methods.
- Used when a base class shares some common functionality but leaves certain methods for child classes to implement.

### 3. Final Class  
- Declared with the `final` keyword.
- Cannot be inherited by any subclass.
- Used when we want to restrict modification of the class functionality.

### 4. Static Class  
- Declared as a static inner class inside another class.
- Cannot access non-static members of the outer class directly.
- Used in utility/helper classes.

### 5. Inner Class  
- A class inside another class.
- Has full access to outer class members (even private).
- Used for encapsulation and better organization of code.

### 6. Anonymous Class  
- A class without a name.
- Defined inside another expression and used for short-lived objects.
- Used in event handling and functional programming.

### 7. POJO (Plain Old Java Object)  
- A simple Java class without any special restrictions.
- Contains only private fields and public getter/setter methods.
- Used for data transfer and entity representation.

### 8. Bean Class  
- Similar to POJO but follows additional rules:
  - Has a no-argument constructor.
  - Implements the Serializable interface.
  - Uses getter and setter methods.
- Used in JavaBeans architecture, frameworks like Spring.

### 9. Record Class (Java 14+)  
- A class introduced to simplify data storage.
- Automatically generates:
  - Getters
  - toString()
  - equals() and hashCode()
- Used for immutable data objects.

---

## Use Cases of Different Java Classes  

| Class Type       | Real-World Use Case |
|------------------|----------------------|
| Concrete Class   | Creating objects for real-world entities like `Car`, `Student`, etc. |
| Abstract Class   | Defining a base class for different types of users (e.g., `User` → `Admin`, `Customer`). |
| Final Class      | Security-critical classes like `Math`, `String` in Java. |
| Static Class     | Helper classes like `Collections`, `Arrays`. |
| Inner Class      | Encapsulating helper classes within main classes for better readability. |
| Anonymous Class  | Event handling in GUI applications (`ActionListener`). |
| POJO Class       | Representing database entities (`Employee`, `Product`). |
| Bean Class       | Used in Java frameworks like Spring for dependency injection. |
| Record Class     | Efficiently representing data (e.g., `Person(String name, int age)`). |

---

## Key Takeaways
✔ Java classes help in organizing code into reusable components.  
✔ Each class type serves a unique purpose in application development.  
✔ Use concrete classes for normal object creation, abstract classes for common functionalities, and final classes for security.  
✔ POJOs and Beans are widely used in Java frameworks and databases.  
✔ Record classes simplify data handling and improve performance.


*/
public class P19_JavaClasses {

	public static void main(String[] args) {
		System.out.println("=== Java Class Demonstration ===");

	     // Final Class Demonstration
	     FinalExample finalObj = new FinalExample();
	     finalObj.show();

	     // Static Class Demonstration
	     StaticExample.StaticInner.display();

	     //  Inner Class Demonstration
	     InnerExample innerExample = new InnerExample();
	     InnerExample.Inner inner = innerExample.new Inner();
	     inner.show();

	     // Anonymous Class Demonstration
	     AnonymousExample anonymousExample = new AnonymousExample();
	     anonymousExample.display();

	     // POJO Class Demonstration
	     PojoExample pojo = new PojoExample("John", 25);
	     System.out.println("\nPOJO Example: Name - " + pojo.getName() + ", Age - " + pojo.getAge());

	     // Bean Class Demonstration
	     BeanExample bean = new BeanExample();
	     bean.setName("Alice");
	     bean.setAge(30);
	     System.out.println("\nBean Example: Name - " + bean.getName() + ", Age - " + bean.getAge());

	     //  Record Class Demonstration
	     RecordExample recordExample = new RecordExample("Bob", 40);
	     System.out.println("\nRecord Example: " + recordExample);

	     // Local Class Demonstration
	     LocalClassExample localClassExample = new LocalClassExample();
	     localClassExample.showLocalClass();
		

	}

}



//Final Class (Cannot be Inherited)
final class FinalExample {
 void show() {
     System.out.println("\nFinal Class: This class cannot be extended.");
 }
}

// Static Class (Nested Class with Static Modifier)
class StaticExample {
 static class StaticInner {
     static void display() {
         System.out.println("\nStatic Inner Class: Called without creating an object.");
     }
 }
}

// Inner Class (Non-Static Nested Class)
class InnerExample {
 class Inner {
     void show() {
         System.out.println("\nInner Class: Accessed through an instance of the outer class.");
     }
 }
}

//Anonymous Class (Class without a Name, Implementing an Interface)
interface AnonymousInterface {
 void display();
}

class AnonymousExample {
 void display() {
     AnonymousInterface obj = new AnonymousInterface() {
         @Override
         public void display() {
             System.out.println("\nAnonymous Class: Implementing an interface without naming a class.");
         }
     };
     obj.display();
 }
}

//POJO Class (Plain Old Java Object - Simple Data Class)
class PojoExample {
 private String name;
 private int age;

 public PojoExample(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
}

//Bean Class (Same as POJO but with a No-Arg Constructor, Getters, and Setters)
class BeanExample {
 private String name;
 private int age;

 public BeanExample() {} // No-argument constructor

 public String getName() { return name; }
 public void setName(String name) { this.name = name; }

 public int getAge() { return age; }
 public void setAge(int age) { this.age = age; }
}

//Record Class (Immutable Data Class in Java 14+)
record RecordExample(String name, int age) {}

//Local Class (Defined Inside a Method)
class LocalClassExample {
 void showLocalClass() {
     class Local {
         void display() {
             System.out.println("\nLocal Class: Defined inside a method.");
         }
     }
     Local localObj = new Local();
     localObj.display();
 }
}
