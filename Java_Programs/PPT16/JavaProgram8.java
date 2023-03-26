package PPT16;

// Java Program to Illustrate identity() method

// Importing Function interface
import java.util.function.Function;

public class JavaProgram8 {

    public static void main(String args[])
    {
        // Function which takes in a number and returns it
        Function<Integer, Integer> i = Function.identity();

        // Print statement
        System.out.println(i.apply(10));
    }
}
