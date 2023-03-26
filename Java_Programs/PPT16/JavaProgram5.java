package PPT16;

// Java Program to Illustrate Functional Interface Via apply() method

// Importing interface
import java.util.function.Function;
// Main class
public class JavaProgram5 {

    // Main driver method
    public static void main(String args[])
    {
        // Function which takes in a number
        // and returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(10));
    }
}
