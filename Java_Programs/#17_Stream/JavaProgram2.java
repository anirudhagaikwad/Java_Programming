package PPT17;
/*
Given a stream containing some elements, the task is to get the last element of the Stream in Java.

Example:

Input: Stream={“Geek_First”, “Geek_2”, “Geek_3”, “Geek_4”, “Geek_Last”}
Output: Geek_Last

Input: Stream={1, 2, 3, 4, 5, 6, 7}
Output: 7
*/

import java.util.*;
import java.util.stream.*;

public class JavaProgram2 {

    // Function to find the
    // last_elements in a Stream
    public static <T> T
    lastElementInStream(Stream<T> stream)
    {
        T last_element
                = stream

                // reduce() method reduces the Stream
                // to a single element, which is last.
                .reduce((first, second) -> second)

                // if stream is empty
                // null is returned
                .orElse(null);

        return last_element;
    }

    public static void main(String[] args)
    {

        Stream<String> stream
                = Stream.of("blue", "red",
                "gray", "orange",
                "black");

        // Print the last element of a Stream
        System.out.println(
                "Last Element: "
                        + lastElementInStream(stream));
    }
}

