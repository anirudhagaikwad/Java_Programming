package PPT10;
// Java Program to Illustrate Static Methods in Abstract Class Can be called Independently

// Class 1
// Abstract class
abstract class Helper {

    // static method
    static void demofun()
    {
        // Print statement
        System.out.println("Java Programming");
    }
}

// Class 2
// Main class extending Helper class
public class JavaProgram2 extends Helper {

    // Main driver method
    public static void main(String[] args)
    {
        // Calling method inside main()
        // as defined in above class
        Helper.demofun();
    }
}
