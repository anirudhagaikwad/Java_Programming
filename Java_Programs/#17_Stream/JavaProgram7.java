package PPT17;
/*
Given the task is to generate an infinite sequential unordered stream
of double in Java.
*/

import java.util.stream.*;
import java.util.*;

public class JavaProgram7 {

    public static void main(String[] args)
    {

        // Create a Random object
        Random random = new Random();

        random

                // Get the next double
                // using doubles() method
                .doubles()

                // Print the DoubleStream
                // using forEach() method.
                .forEach(System.out::println);
    }
}


