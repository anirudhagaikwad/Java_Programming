package oop;
/*
### Abstract Class in Java
An abstract class in Java is a class that is declared using the `abstract` keyword. 
It is used to define a blueprint for other classes to extend. Abstract classes can contain both abstract methods (methods without a body)
and non-abstract methods (methods with an implementation). They can also have variables and constructors.

### Characteristics of an Abstract Class:
1. Declared using `abstract` keyword: Any class that is declared with `abstract` becomes an abstract class.
2. Can contain both abstract and non-abstract methods: Abstract methods do not have a body and must be implemented in derived classes,
   while non-abstract methods can have implementations.
3. Cannot be instantiated: You cannot create an object of an abstract class directly.
4. Used to achieve abstraction: Abstract classes provide a way to enforce a contract for subclasses, ensuring that they implement 
   required methods.

### Abstract Method:
1. Method without a body: An abstract method is declared inside an abstract class but does not have an implementation.
2. Must be implemented by subclass: Any class that extends an abstract class must provide implementations for all abstract methods.
3. Cannot be `final` or `static`: Abstract methods cannot be `final` (because they must be overridden) or `static` 
   (since they belong to an instance, not the class itself).
4. By default, they are public: Abstract methods have `public` visibility by default to allow implementation in subclasses.

### Constructors 
- In abstract classes help initialize fields, enforce initialization in subclasses, and promote code reusability. 
  They ensure that any subclass will be properly initialized with the required parameters. 
  
### Summary:
- An abstract class cannot be instantiated but can contain both abstract and concrete methods.
- Abstract methods must be implemented by any concrete subclass.
- Abstract classes help achieve abstraction in Java by defining a common interface for subclasses.
- Abstract methods cannot be `final` or `static`, and they are `public` by default.  

---

## Real-World Use Cases of Abstract Class  

| Use Case                    | Description | Why Use Abstract Class? |
|---------------------------  |----------------|----------------------------|
| Banking System              | A `BankAccount` class defines common features like `deposit()` and `withdraw()`, but subclasses like `SavingsAccount` and `CheckingAccount` implement their own rules. | To enforce common behavior while allowing specific implementations. |
| Vehicle System              | A `Vehicle` class has methods like `startEngine()` and `stopEngine()`, while subclasses like `Car` and `Bike` provide their own engine start/stop logic. | To provide a base structure for all vehicle types with customization. |
| Employee Hierarchy          | An `Employee` class defines general employee attributes and a `calculateSalary()` method, while subclasses like `FullTimeEmployee` and `PartTimeEmployee` implement salary calculations differently. | To ensure all employees have a salary calculation method but with specific implementations. |
| E-commerce Payment System   | A `Payment` abstract class defines a `processPayment()` method, and subclasses like `CreditCardPayment` and `UPIPayment` implement payment logic differently. | To enforce a structure where all payment methods must implement `processPayment()`. |
| Gaming Characters           | A `GameCharacter` class has methods like `attack()` and `defend()`, while specific characters like `Warrior` and `Mage` implement them uniquely. | To define base behavior while allowing specialization. |
| Animal Behavior System      | An `Animal` class defines `makeSound()`, while subclasses like `Dog` and `Cat` implement different sounds. | To enforce that all animals must have a sound-making method. |
| Shapes in Graphics Software | A `Shape` class has methods like `draw()` and `calculateArea()`, while subclasses like `Circle` and `Rectangle` implement these differently. | To allow shape-specific logic while maintaining a common structure. |
| UI Component System         | A `UIComponent` class defines `render()` and `onClick()`, while `Button` and `TextBox` provide their own rendering and click behavior. | To ensure all UI components follow a standard structure. |

---

## Why Use Abstract Classes Instead of Interfaces?  
| Abstract Class                                          | Interface |
|---------------------------------------------------------|--------------|
| Can have both abstract and concrete methods.            | Only has abstract methods (before Java 8). |
| Allows instance variables (fields with state).          | No instance variables, only constants. |
| Used when there is a common behavior across subclasses. | Used when classes only share method signatures. |

---

### Conclusion  
- Abstract classes are useful when defining common functionality with some default behavior.  
- They provide code reusability while enforcing a contract for subclasses.  
- Unlike interfaces, abstract classes can hold state and partially implemented logic.  


*/

public class P12_AbstractClass {

	public static void main(String[] args) {
	     PressureConverter atmToKPa = new AtmToKPa(1);
	     atmToKPa.displayConversion("kPa");

	     PressureConverter atmToTorr = new AtmToTorr(1);
	     atmToTorr.displayConversion("Torr");

	     PressureConverter paToNPerM2 = new PascalToNewtonPerSquareMeter(500);
	     paToNPerM2.displayConversion("N/m²");

	     PressureConverter barToKPa = new BarToKPa(2);
	     barToKPa.displayConversion("kPa");
	}

}


//Abstract class for pressure conversion
abstract class PressureConverter {
 protected double value; // Input pressure value

 // Constructor
 public PressureConverter(double value) {
     this.value = value;
 }

 // Abstract method (to be implemented by subclasses)
 public abstract double convert();

 // Concrete method to display conversion result
 public void displayConversion(String unit) {
     System.out.println(value + " converted to " + unit + " = " + convert());
 }
}

//Subclass: Convert Atmospheres (atm) to Kilopascals (kPa)
class AtmToKPa extends PressureConverter {
 private static final double CONVERSION_FACTOR = 101.325;

 public AtmToKPa(double value) {
     super(value);
 }

 @Override
 public double convert() {
     return value * CONVERSION_FACTOR;
 }
}

//Subclass: Convert Atmospheres (atm) to Torr (mmHg)
class AtmToTorr extends PressureConverter {
 private static final double CONVERSION_FACTOR = 760;

 public AtmToTorr(double value) {
     super(value);
 }

 @Override
 public double convert() {
     return value * CONVERSION_FACTOR;
 }
}

//Subclass: Convert Pascal (Pa) to Newton per Square Meter (N/m²)
class PascalToNewtonPerSquareMeter extends PressureConverter {

 public PascalToNewtonPerSquareMeter(double value) {
     super(value);
 }

 @Override
 public double convert() {
     return value; // 1 Pascal (Pa) = 1 N/m² (same value)
 }
}

//Subclass: Convert Bar to Kilopascals (kPa)
class BarToKPa extends PressureConverter {
 private static final double CONVERSION_FACTOR = 100;

 public BarToKPa(double value) {
     super(value);
 }

 @Override
 public double convert() {
     return value * CONVERSION_FACTOR;
 }
}

