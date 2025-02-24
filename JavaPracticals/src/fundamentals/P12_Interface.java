package fundamentals;
/*
An interface in Java is a blueprint of a class that defines abstract methods. 
It is declared using the interface keyword and is used to achieve 100% abstraction since all methods 
in an interface are abstract by default (except default and static methods).

### Characteristics of an Interface:
- Declared using interface keyword.
- Cannot have instance variables (only static and final constants allowed).
- Supports multiple inheritance: A class can implement multiple interfaces.
- All methods are public and abstract by default, except default and static methods.
- Cannot have constructors since an interface cannot be instantiated.
- A class implementing an interface must provide implementations for all its methods.

### Types of Methods in an Interface:
- Abstract Methods - Methods without a body (implicitly public and abstract).
- Default Methods - Methods with a body using the default keyword (introduced in Java 8).
- Static Methods - Methods with a body using the static keyword (introduced in Java 8). 

###
Interfaces no longer provide 100% abstraction after Java 8. However, they still enforce a strict contract 
for implementing classes, making them useful for abstraction and multiple inheritance.
*/
public class P12_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
