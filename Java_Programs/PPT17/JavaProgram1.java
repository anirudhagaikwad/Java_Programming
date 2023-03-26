package PPT17;
/*
Given a stream containing some elements, the task is to get the first element of the Stream in Java.

Example:

Input: Stream = {“burger”, “fries”, “noodles”, “momos”, “roll”}
Output: burger


*/

import java.util.stream.Stream;

public class JavaProgram1 {

    // Function to find the
    // first_elements in a Stream
    public static <T> T
    firstElementInStream(Stream<T> stream)
    {
        T first_element
                = stream

                // reduce() method reduces the Stream
                // to a single element, which is first.
                .reduce((first, second) -> first)

                // if stream is empty
                // null is returned
                .orElse(null);

        return first_element;
    }

    public static void main(String[] args)
    {

        Stream<String> stream
                = Stream.of("pizza", "noodles",
                "burger", "pasta",
                "fries");

        // Print the first element of a Stream
        System.out.println(
                "First Element: "
                        + firstElementInStream(stream));
    }
}

