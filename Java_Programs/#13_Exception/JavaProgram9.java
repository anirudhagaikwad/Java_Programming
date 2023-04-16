package PPT13;

// Write a java program for handling null pointer exception
import java.io.*;

public class JavaProgram9 {

    // Driver Main Method
    public static void main(String[] args)
    {
        // Assigning NULL to string
        String m = null;

        // Try-Catch Block
        try {

            // Checking the null value with GFG string
            // and throw exception
            if (m.equals("GFG")) {
                // Print String
                System.out.println("YES");
            }
        }

        // Try-Catch Block
        catch (NullPointerException e) {

            // Handles the exception
            System.out.println(
                    "Object reference cannot be null");
        }
    }
}

