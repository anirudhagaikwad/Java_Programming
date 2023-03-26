package PPT10;
// Java Program to Illustrate Abstract Class Can contain Constructors

// Class 1
// Abstract class
abstract class Base_ {

    // Constructor of class 1
    Base_()
    {
        // Print statement
        System.out.println("Base Constructor Called");
    }

    // Abstract method inside class1
    abstract void fun();
}

// Class 2
class Derived_ extends Base_ {

    // Constructor of class2
    Derived_()
    {
        System.out.println("Derived Constructor Called");
    }

    // Method of class2
    void fun()
    {
        System.out.println("Derived fun() called");
    }
}

// Class 3
// Main class
class JavaProgram4 {

    public static void main(String args[])
    {
        // Creating object of class 2
        // inside main() method
        Derived_ d = new Derived_();
        d.fun();
    }
}
