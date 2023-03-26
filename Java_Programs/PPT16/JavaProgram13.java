package PPT16;

// Java program to demonstrate an external iterator

import java.util.Arrays;
import java.util.List;

public class JavaProgram13 {
    public static void main(String[] args)
    {
        List<Integer> numbers
                = Arrays.asList(11, 22, 33, 44,
                55, 66, 77, 88,
                99, 100);

        // External iterator, for Each loop
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
    }
}