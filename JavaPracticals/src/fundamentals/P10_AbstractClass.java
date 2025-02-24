package fundamentals;
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
*/
public class P10_AbstractClass {

	public static void main(String[] args) {
		

	}

}


abstract class Shape {
    protected String name;

    // Constructor in the abstract class
    public Shape(String name) {
        this.name = name;
    }

    // Abstract method to calculate the area
    public abstract double calculateArea();

    public String getName() {
        return name;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    // Implementing the calculateArea() method
    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    // Implementing the calculateArea() method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
