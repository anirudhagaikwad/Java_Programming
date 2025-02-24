package oop;
/*

#### 1. What is an Enum in Java?  
An `enum` (short for enumeration) is a special data type in Java used to define a collection of named constants. Enums improve code readability, maintainability, and type safety by restricting a variable to take only predefined values.

#### 2. Purpose of Enums in Java  
- To represent fixed sets of constant values (e.g., days of the week, directions, status codes).  
- To improve type safety, preventing invalid values from being assigned.  
- To replace magic numbers with meaningful names, making code more readable.  
- To group related constants under a single type, reducing redundancy.  
- To allow custom methods and constructors for additional functionality.  

---

####  Syntax of Enum  

enum EnumName {
    CONSTANT1, CONSTANT2, CONSTANT3;
}

---

#### Enum in Java - Characteristics  
- Enums are implicitly `final` and `static` (cannot be extended).  
- Each constant inside an enum is an instance of the enum type itself.  
- Enums cannot be instantiated explicitly using `new`.  
- Enums can have fields, constructors, and methods like normal classes.  

---

#### Where to Use Enums?  
| Use Case                    | Example                                      |
|-----------------------------|--------------------------------------------------|
| Days of the week            | `enum Day { MONDAY, TUESDAY, ... }`             |
| Directions                  | `enum Direction { NORTH, EAST, SOUTH, WEST }`   |
| Status codes                | `enum Status { SUCCESS, ERROR, PENDING }`       |
| Logging levels              | `enum LogLevel { INFO, DEBUG, ERROR }`          |
| Order states                | `enum OrderStatus { PLACED, SHIPPED, DELIVERED }` |
| User roles                  | `enum Role { ADMIN, USER, GUEST }`              |

---

#### Built-in Methods of Enum (From `java.lang.Enum`)
| Method                  | Description |
|-------------------------|----------------|
| `values()`              | Returns an array of all enum constants. |
| `ordinal()`             | Retrieves the position (index) of each enum constant (starting from `0`). |
| `name()`                | Returns the exact name of the constant as a `String`. |
| `valueOf(String name)`  | Converts a string to its corresponding enum constant. |
| `compareTo(Enum e)`     | Compares two enum constants based on their order. |
| `toString()`            | Returns the name of the constant as a `String`. |
| `equals(Object obj)`    | Checks if two enum constants are the same. |
| `hashCode()`            | Returns the hashcode of the enum constant. |

---

#### Enum Parent Class & Location  
- Parent Class: `java.lang.Enum<E>`  
- Package: `java.lang`  

>All enums automatically extend `java.lang.Enum`, making them subclasses of `Enum`. 
 This means they cannot extend other classes (Java does not support multiple inheritance for classes).


---

### Conclusion
- Enums represent constant values in a structured manner.  
- They enhance type safety and readability.  
- They support constructors, methods, and interfaces but cannot extend classes.  
- Enums are widely used in status codes, settings, and predefined categories.  

*/
public class P22_Enum {

	public static void main(String[] args) {
	     System.out.println("=== Enum Methods Demonstration ===");

	     // Using values() - Retrieves all enum constants
	     System.out.println("\nAll Days:");
	     for (Day day : Day.values()) {
	         System.out.println(day);
	     }

	     // Using ordinal() - Retrieves index of each constant
	     System.out.println("\nOrdinal Values:");
	     for (Day day : Day.values()) {
	         System.out.println(day + " - Ordinal: " + day.ordinal());
	     }

	     // Using valueOf() - Converts String to Enum Constant
	     Day specificDay = Day.valueOf("WEDNESDAY");
	     System.out.println("\nUsing valueOf(): " + specificDay);

	     // Using isWeekend() - Custom Method
	     System.out.println("\nChecking Weekend:");
	     for (Day day : Day.values()) {
	         System.out.println(day + " is a " + day.getType());
	     }

	     // Comparing Enum Constants (== Operator)
	     System.out.println("\nComparing Enum Constants:");
	     System.out.println("Is MONDAY same as TUESDAY? " + (Day.MONDAY == Day.TUESDAY));
	     System.out.println("Is SATURDAY same as SATURDAY? " + (Day.SATURDAY == Day.SATURDAY));

	     // Using name() - Retrieves exact name of constant
	     System.out.println("\nUsing name() Method:");
	     System.out.println("Name of constant: " + Day.FRIDAY.name());

	     // Using toString() - Returns name of enum constant
	     System.out.println("\nUsing toString() Method:");
	     System.out.println("String Representation: " + Day.SUNDAY.toString());

	}

}

/*
Create a Java program to demonstrate an enum Day, representing days of the week. The program should:

✅ Implement all built-in enum methods
✅ Demonstrate ordinal values, name retrieval, valueOf(), values(), and custom methods
✅ Implement an abstract method inside the enum to display whether the day is a Weekday or Weekend
✅ Demonstrate enum constructor and instance variables
*/

//Enum to represent days of the week
enum Day {
 // Enum Constants with a boolean flag for Weekend
 SUNDAY(true), MONDAY(false), TUESDAY(false), WEDNESDAY(false),
 THURSDAY(false), FRIDAY(false), SATURDAY(true);

 private final boolean isWeekend; // Instance variable to store weekend flag

 // Constructor for Enum (Runs for each constant)
 Day(boolean isWeekend) {
     this.isWeekend = isWeekend;
 }

 // Method to get type of day (Weekend or Weekday)
 public String getType() {
     return isWeekend ? "Weekend" : "Weekday";
 }

 // Getter for Weekend Flag
 public boolean isWeekend() {
     return isWeekend;
 }
}

